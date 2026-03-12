package com.example.OnlineLegalCaseMs.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Lawyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String specialization;
    private String licenseNumber;
    
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    
    @OneToMany(mappedBy = "lawyer")
    private List<CaseAssignment> caseAssignments;
    
    public Lawyer() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }
    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }
    public List<CaseAssignment> getCaseAssignments() { return caseAssignments; }
    public void setCaseAssignments(List<CaseAssignment> caseAssignments) { this.caseAssignments = caseAssignments; }
}
