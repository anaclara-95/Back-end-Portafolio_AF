
package com.portfolioB.AF.Repository;

import com.portfolioB.AF.Entity.Education;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Usuario
 */
@Repository
public interface IEduRepo extends JpaRepository<Education, Integer> {
    public Optional<Education> findByEduI(String eduI);
    public boolean existsByEduI(String eduI);
    
}
