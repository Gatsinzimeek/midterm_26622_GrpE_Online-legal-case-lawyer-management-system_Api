package com.example.OnlineLegalCaseMs.repository;

import com.example.OnlineLegalCaseMs.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DistrictRepository extends JpaRepository<District, Long> {
    List<District> findByProvinceId(Long provinceId);
}
