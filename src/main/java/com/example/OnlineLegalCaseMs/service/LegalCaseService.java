package com.example.OnlineLegalCaseMs.service;

import com.example.OnlineLegalCaseMs.entity.LegalCase;
import com.example.OnlineLegalCaseMs.repository.LegalCaseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LegalCaseService {
    private final LegalCaseRepository legalCaseRepository;

    public LegalCaseService(LegalCaseRepository legalCaseRepository) {
        this.legalCaseRepository = legalCaseRepository;
    }

    public List<LegalCase> getAllCases() {
        return legalCaseRepository.findAll();
    }

    public LegalCase getCaseById(Long id) {
        return legalCaseRepository.findById(id).orElse(null);
    }

    public LegalCase createCase(LegalCase legalCase) {
        return legalCaseRepository.save(legalCase);
    }

    public LegalCase updateCase(Long id, LegalCase legalCase) {
        legalCase.setId(id);
        return legalCaseRepository.save(legalCase);
    }

    public void deleteCase(Long id) {
        legalCaseRepository.deleteById(id);
    }

    public List<LegalCase> getCasesByClient(Long clientId) {
        return legalCaseRepository.findByClientId(clientId);
    }

    public List<LegalCase> getCasesByStatus(String status) {
        return legalCaseRepository.findByStatus(status);
    }
}
