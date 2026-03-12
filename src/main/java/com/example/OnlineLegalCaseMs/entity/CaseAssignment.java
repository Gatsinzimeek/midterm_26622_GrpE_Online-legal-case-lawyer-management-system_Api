package com.example.OnlineLegalCaseMs.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class CaseAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "case_id")
    private LegalCase legalCase;
    
    @ManyToOne
    @JoinColumn(name = "lawyer_id")
    private Lawyer lawyer;
    
    private LocalDate assignedDate;
    private String role;
    private String status;
    
    public CaseAssignment() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LegalCase getLegalCase() { return legalCase; }
    public void setLegalCase(LegalCase legalCase) { this.legalCase = legalCase; }
    public Lawyer getLawyer() { return lawyer; }
    public void setLawyer(Lawyer lawyer) { this.lawyer = lawyer; }
    public LocalDate getAssignedDate() { return assignedDate; }
    public void setAssignedDate(LocalDate assignedDate) { this.assignedDate = assignedDate; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
