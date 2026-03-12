package com.example.OnlineLegalCaseMs.repository;

import com.example.OnlineLegalCaseMs.entity.CaseAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CaseAssignmentRepository extends JpaRepository<CaseAssignment, Long> {
    List<CaseAssignment> findByLawyerId(Long lawyerId);
    List<CaseAssignment> findByLegalCaseId(Long caseId);
}
