package com.portfolioB.AF.Repository;

import com.portfolioB.AF.Entity.Experience;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpRepo extends JpaRepository<Experience, Integer> {
    public Optional<Experience> findByNameE(String nameE); 
    public boolean existsByNameE(String nameE);
    
}
