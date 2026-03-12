package com.codeinfinity.ankit.service;

import com.codeinfinity.ankit.entity.JournalEntry;
import com.codeinfinity.ankit.entity.User;
import com.codeinfinity.ankit.repository.JournalEntryRepository;
import com.codeinfinity.ankit.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveEntry(JournalEntry journalEntry, String userName) {
        User user = userRepository.findByUserName(userName);
        journalEntry.setDate(LocalDateTime.now());
        JournalEntry saved = journalEntryRepository.save(journalEntry);
        user.getJournalEntries().add(saved);
        userRepository.save(user);
    }

    public List<JournalEntry> findAll() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    @Transactional
    public boolean deleteById(ObjectId id, String userName) {
        boolean removed = false;
        try {
            User user = userRepository.findByUserName(userName);
            removed = user.getJournalEntries().removeIf(x -> x.getId().equals(id));
            if (removed) {
                userRepository.save(user);
                journalEntryRepository.deleteById(id);
            }
        } catch (Exception e) {
            System.out.println("Error deleting journal entry: " + e.getMessage());
            throw new RuntimeException("Error deleting journal entry: " + e.getMessage());
        }
        return removed;
    }

    public void saveEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }
}
