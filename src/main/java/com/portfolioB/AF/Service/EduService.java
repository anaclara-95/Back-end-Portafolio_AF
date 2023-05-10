package com.portfolioB.AF.Service;

import com.portfolioB.AF.Entity.Education;
import com.portfolioB.AF.Repository.IEduRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Usuario
 */
@Service
@Transactional
public class EduService {

    @Autowired
    IEduRepo iEduRepo;

    public List<Education> list() {
        return iEduRepo.findAll();

    }

    public Optional<Education> getOne(int id) {
        return iEduRepo.findById(id);
    }

    public Optional<Education> getByEduI(String eduI) {
        return iEduRepo.findByEduI(eduI);

    }

    public void save(Education edu) {
        iEduRepo.save(edu);
    }

    public void delete(int id) {
        iEduRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return iEduRepo.existsById(id);
    }

    public boolean existsByEduI(String eduI) {
        return iEduRepo.existsByEduI(eduI);
    }
}
