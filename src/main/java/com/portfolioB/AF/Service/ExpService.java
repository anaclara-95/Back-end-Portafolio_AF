
package com.portfolioB.AF.Service;

import com.portfolioB.AF.Entity.Experience;
import com.portfolioB.AF.Repository.IExpRepo;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ExpService {
    @Autowired
    IExpRepo iExpRepo;
  
    public List<Experience> list() {
        return iExpRepo.findAll();
    }
    
    public Optional<Experience> getOne(int id) {
        return iExpRepo.findById(id);
    }
    
    public Optional<Experience> getByNameE(String nameE){
        return iExpRepo.findByNameE(nameE);
    }
    
    public void save(Experience exp) {
        iExpRepo.save(exp);
    }
    
    public void delete(int id) {
        iExpRepo.deleteById(id);
    }
    
    public boolean existsById(int id) {
        return iExpRepo.existsById(id);
    }
       
    public boolean existsByNameE(String nameE) {
        return iExpRepo.existsByNameE(nameE);
    }
    
}
