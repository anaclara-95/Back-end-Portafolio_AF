package com.portfolioB.AF.Repository;

import com.portfolioB.AF.Entity.Projects;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjRepo extends JpaRepository<Projects, Integer> {
       public Optional<Projects> findByNameP(String nameP); 
    public boolean existsByNameP(String nameP);
   
    
}
