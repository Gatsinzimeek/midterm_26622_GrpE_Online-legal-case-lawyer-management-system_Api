package com.example.OnlineLegalCaseMs.controller;

import com.example.OnlineLegalCaseMs.entity.Lawyer;
import com.example.OnlineLegalCaseMs.service.LawyerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/lawyers")
public class LawyerController {
    private final LawyerService lawyerService;

    public LawyerController(LawyerService lawyerService) {
        this.lawyerService = lawyerService;
    }

    @GetMapping
    public List<Lawyer> getAllLawyers() {
        return lawyerService.getAllLawyers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lawyer> getLawyerById(@PathVariable Long id) {
        Lawyer lawyer = lawyerService.getLawyerById(id);
        return lawyer != null ? ResponseEntity.ok(lawyer) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Lawyer createLawyer(@RequestBody Lawyer lawyer) {
        return lawyerService.createLawyer(lawyer);
    }

    @PutMapping("/{id}")
    public Lawyer updateLawyer(@PathVariable Long id, @RequestBody Lawyer lawyer) {
        return lawyerService.updateLawyer(id, lawyer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLawyer(@PathVariable Long id) {
        lawyerService.deleteLawyer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/district/{districtId}")
    public List<Lawyer> getLawyersByDistrict(@PathVariable Long districtId) {
        return lawyerService.getLawyersByDistrict(districtId);
    }

    @GetMapping("/specialization/{specialization}")
    public List<Lawyer> getLawyersBySpecialization(@PathVariable String specialization) {
        return lawyerService.getLawyersBySpecialization(specialization);
    }
}
