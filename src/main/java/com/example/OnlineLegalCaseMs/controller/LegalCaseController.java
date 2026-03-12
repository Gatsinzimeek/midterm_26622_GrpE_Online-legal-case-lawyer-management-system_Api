package com.example.OnlineLegalCaseMs.controller;

import com.example.OnlineLegalCaseMs.entity.LegalCase;
import com.example.OnlineLegalCaseMs.service.LegalCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class LegalCaseController {
    private final LegalCaseService legalCaseService;

    public LegalCaseController(LegalCaseService legalCaseService) {
        this.legalCaseService = legalCaseService;
    }

    @GetMapping
    public List<LegalCase> getAllCases() {
        return legalCaseService.getAllCases();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LegalCase> getCaseById(@PathVariable Long id) {
        LegalCase legalCase = legalCaseService.getCaseById(id);
        return legalCase != null ? ResponseEntity.ok(legalCase) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public LegalCase createCase(@RequestBody LegalCase legalCase) {
        return legalCaseService.createCase(legalCase);
    }

    @PutMapping("/{id}")
    public LegalCase updateCase(@PathVariable Long id, @RequestBody LegalCase legalCase) {
        return legalCaseService.updateCase(id, legalCase);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCase(@PathVariable Long id) {
        legalCaseService.deleteCase(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/client/{clientId}")
    public List<LegalCase> getCasesByClient(@PathVariable Long clientId) {
        return legalCaseService.getCasesByClient(clientId);
    }

    @GetMapping("/status/{status}")
    public List<LegalCase> getCasesByStatus(@PathVariable String status) {
        return legalCaseService.getCasesByStatus(status);
    }
}
