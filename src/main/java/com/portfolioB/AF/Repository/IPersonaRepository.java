
package com.portfolioB.AF.Repository;

import com.portfolioB.AF.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Integer> {
    public Optional<Persona> findByName(String name);
    public boolean existsByName(String name);

}
 



