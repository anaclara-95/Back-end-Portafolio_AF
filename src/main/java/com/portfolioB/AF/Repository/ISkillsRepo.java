package com.portfolioB.AF.Repository;

import com.portfolioB.AF.Entity.Skills;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISkillsRepo extends JpaRepository<Skills, Integer> {
    public Optional<Skills> findByNameSk(String nameSk);
    public boolean existsByNameSk(String nameSk);
}
