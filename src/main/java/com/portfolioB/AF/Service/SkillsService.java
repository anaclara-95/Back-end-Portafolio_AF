

package com.portfolioB.AF.Service;

import com.portfolioB.AF.Entity.Skills;
import com.portfolioB.AF.Repository.ISkillsRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SkillsService {
@Autowired
ISkillsRepo iSkillsRepo;

public List<Skills> list() {
        return iSkillsRepo.findAll();
    }

public Optional<Skills> getOne(int id) {
        return iSkillsRepo.findById(id);
    }
 
public Optional<Skills> getByNameSk(String nameSk){
        return iSkillsRepo.findByNameSk(nameSk);
    }
 
public void save(Skills skill) {
        iSkillsRepo.save(skill);
    }
 
public void delete(int id) {
        iSkillsRepo.deleteById(id);
    }

public boolean existsById(int id) {
        return iSkillsRepo.existsById(id);
    }

public boolean existsByNameSk(String nameSk) {
        return iSkillsRepo.existsByNameSk(nameSk);
    }
 
}
