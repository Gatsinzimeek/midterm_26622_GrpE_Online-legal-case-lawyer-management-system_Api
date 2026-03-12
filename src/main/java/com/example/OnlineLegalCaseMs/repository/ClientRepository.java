package com.example.OnlineLegalCaseMs.repository;

import com.example.OnlineLegalCaseMs.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {
    List<Client> findByDistrictId(Long districtId);
}
