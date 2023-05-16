
package com.portfolioB.AF.Service;

import com.portfolioB.AF.Entity.Persona;
import com.portfolioB.AF.Repository.IPersonaRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class IPersonaService {
    @Autowired
    IPersonaRepository iPersonaRepository;
    
    public List<Persona> list() {
        return iPersonaRepository.findAll();
        
}
     public Optional<Persona> getOne(int id) {
       return iPersonaRepository.findById(id);
       
    }
 
    public Optional<Persona> getByName(String name) {
        return iPersonaRepository.findByName(name);
        
    }
  
    public void save(Persona pers) {
        iPersonaRepository.save(pers);
        
    }
    
    public void delete (int id) {
         iPersonaRepository.deleteById(id);
        
    }
    
    public boolean existsById(int id){
        return iPersonaRepository.existsById(id);
        
    }
    
    public boolean existsByName(String name){
        return iPersonaRepository.existsByName(name);
    }
   
}
