package com.example.OnlineLegalCaseMs.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String email;
    private String phone;
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "district_id")
    private District district;
    
    @OneToMany(mappedBy = "client")
    private List<LegalCase> cases;
    
    public Client() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    public District getDistrict() { return district; }
    public void setDistrict(District district) { this.district = district; }
    public List<LegalCase> getCases() { return cases; }
    public void setCases(List<LegalCase> cases) { this.cases = cases; }
}
