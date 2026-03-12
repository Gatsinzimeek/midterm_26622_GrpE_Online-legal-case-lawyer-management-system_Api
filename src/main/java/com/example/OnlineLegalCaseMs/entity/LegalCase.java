package com.example.OnlineLegalCaseMs.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class LegalCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String caseNumber;
    private String title;
    private String description;
    private String caseType;
    private String status;
    private LocalDate filingDate;
    private LocalDate hearingDate;
    
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
    
    @OneToMany(mappedBy = "legalCase", cascade = CascadeType.ALL)
    private List<CaseAssignment> caseAssignments;
    
    public LegalCase() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCaseNumber() { return caseNumber; }
    public void setCaseNumber(String caseNumber) { this.caseNumber = caseNumber; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCaseType() { return caseType; }
    public void setCaseType(String caseType) { this.caseType = caseType; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDate getFilingDate() { return filingDate; }
    public void setFilingDate(LocalDate filingDate) { this.filingDate = filingDate; }
    public LocalDate getHearingDate() { return hearingDate; }
    public void setHearingDate(LocalDate hearingDate) { this.hearingDate = hearingDate; }
    public Client getClient() { return client; }
    public void setClient(Client client) { this.client = client; }
    public List<CaseAssignment> getCaseAssignments() { return caseAssignments; }
    public void setCaseAssignments(List<CaseAssignment> caseAssignments) { this.caseAssignments = caseAssignments; }
}
