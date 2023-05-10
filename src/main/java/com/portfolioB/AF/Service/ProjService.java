

package com.portfolioB.AF.Service;

import com.portfolioB.AF.Entity.Projects;
import com.portfolioB.AF.Repository.IProjRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjService {
@Autowired
IProjRepo iProjRepo;

    public List<Projects> list() {
        return iProjRepo.findAll();

    }

    public Optional<Projects> getOne(int id) {
        return iProjRepo.findById(id);
    }

    public Optional<Projects> getByNameP(String nameP) {
        return iProjRepo.findByNameP(nameP);

    }

    public void save(Projects proj) {
        iProjRepo.save(proj);
    }

    public void delete(int id) {
        iProjRepo.deleteById(id);
    }

    public boolean existsById(int id) {
        return iProjRepo.existsById(id);
    }

    public boolean existsByNameP(String nameP) {
        return iProjRepo.existsByNameP(nameP);
    }
}
