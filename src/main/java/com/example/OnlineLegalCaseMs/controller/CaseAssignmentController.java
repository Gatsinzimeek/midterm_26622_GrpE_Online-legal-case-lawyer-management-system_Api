package com.example.OnlineLegalCaseMs.controller;

import com.example.OnlineLegalCaseMs.entity.CaseAssignment;
import com.example.OnlineLegalCaseMs.service.CaseAssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class CaseAssignmentController {
    private final CaseAssignmentService caseAssignmentService;

    public CaseAssignmentController(CaseAssignmentService caseAssignmentService) {
        this.caseAssignmentService = caseAssignmentService;
    }

    @GetMapping
    public List<CaseAssignment> getAllAssignments() {
        return caseAssignmentService.getAllAssignments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaseAssignment> getAssignmentById(@PathVariable Long id) {
        CaseAssignment assignment = caseAssignmentService.getAssignmentById(id);
        return assignment != null ? ResponseEntity.ok(assignment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public CaseAssignment createAssignment(@RequestBody CaseAssignment assignment) {
        return caseAssignmentService.createAssignment(assignment);
    }

    @PutMapping("/{id}")
    public CaseAssignment updateAssignment(@PathVariable Long id, @RequestBody CaseAssignment assignment) {
        return caseAssignmentService.updateAssignment(id, assignment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        caseAssignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/lawyer/{lawyerId}")
    public List<CaseAssignment> getAssignmentsByLawyer(@PathVariable Long lawyerId) {
        return caseAssignmentService.getAssignmentsByLawyer(lawyerId);
    }

    @GetMapping("/case/{caseId}")
    public List<CaseAssignment> getAssignmentsByCase(@PathVariable Long caseId) {
        return caseAssignmentService.getAssignmentsByCase(caseId);
    }
}
