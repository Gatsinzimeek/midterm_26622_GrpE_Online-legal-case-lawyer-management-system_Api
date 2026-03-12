package com.example.OnlineLegalCaseMs.repository;

import com.example.OnlineLegalCaseMs.entity.Lawyer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LawyerRepository extends JpaRepository<Lawyer, Long> {
    List<Lawyer> findByDistrictId(Long districtId);
    List<Lawyer> findBySpecialization(String specialization);
}
