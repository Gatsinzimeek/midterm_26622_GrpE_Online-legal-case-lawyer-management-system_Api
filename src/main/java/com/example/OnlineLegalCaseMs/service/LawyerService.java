package com.example.OnlineLegalCaseMs.service;

import com.example.OnlineLegalCaseMs.entity.Lawyer;
import com.example.OnlineLegalCaseMs.repository.LawyerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LawyerService {
    private final LawyerRepository lawyerRepository;

    public LawyerService(LawyerRepository lawyerRepository) {
        this.lawyerRepository = lawyerRepository;
    }

    public List<Lawyer> getAllLawyers() {
        return lawyerRepository.findAll();
    }

    public Lawyer getLawyerById(Long id) {
        return lawyerRepository.findById(id).orElse(null);
    }

    public Lawyer createLawyer(Lawyer lawyer) {
        return lawyerRepository.save(lawyer);
    }

    public Lawyer updateLawyer(Long id, Lawyer lawyer) {
        lawyer.setId(id);
        return lawyerRepository.save(lawyer);
    }

    public void deleteLawyer(Long id) {
        lawyerRepository.deleteById(id);
    }

    public List<Lawyer> getLawyersByDistrict(Long districtId) {
        return lawyerRepository.findByDistrictId(districtId);
    }

    public List<Lawyer> getLawyersBySpecialization(String specialization) {
        return lawyerRepository.findBySpecialization(specialization);
    }
}
