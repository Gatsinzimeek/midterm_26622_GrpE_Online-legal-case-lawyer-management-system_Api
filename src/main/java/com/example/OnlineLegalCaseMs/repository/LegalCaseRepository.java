package com.example.OnlineLegalCaseMs.repository;

import com.example.OnlineLegalCaseMs.entity.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LegalCaseRepository extends JpaRepository<LegalCase, Long> {
    List<LegalCase> findByClientId(Long clientId);
    List<LegalCase> findByStatus(String status);
}
