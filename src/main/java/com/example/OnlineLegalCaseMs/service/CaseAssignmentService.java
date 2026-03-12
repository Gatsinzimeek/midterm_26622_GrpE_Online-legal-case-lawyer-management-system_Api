package com.example.OnlineLegalCaseMs.service;

import com.example.OnlineLegalCaseMs.entity.CaseAssignment;
import com.example.OnlineLegalCaseMs.repository.CaseAssignmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CaseAssignmentService {
    private final CaseAssignmentRepository caseAssignmentRepository;

    public CaseAssignmentService(CaseAssignmentRepository caseAssignmentRepository) {
        this.caseAssignmentRepository = caseAssignmentRepository;
    }

    public List<CaseAssignment> getAllAssignments() {
        return caseAssignmentRepository.findAll();
    }

    public CaseAssignment getAssignmentById(Long id) {
        return caseAssignmentRepository.findById(id).orElse(null);
    }

    public CaseAssignment createAssignment(CaseAssignment assignment) {
        return caseAssignmentRepository.save(assignment);
    }

    public CaseAssignment updateAssignment(Long id, CaseAssignment assignment) {
        assignment.setId(id);
        return caseAssignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        caseAssignmentRepository.deleteById(id);
    }

    public List<CaseAssignment> getAssignmentsByLawyer(Long lawyerId) {
        return caseAssignmentRepository.findByLawyerId(lawyerId);
    }

    public List<CaseAssignment> getAssignmentsByCase(Long caseId) {
        return caseAssignmentRepository.findByLegalCaseId(caseId);
    }
}
