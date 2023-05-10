

package com.portfolioB.AF.Controller;

import com.portfolioB.AF.Dto.DtoSkills;
import com.portfolioB.AF.Entity.Skills;
import com.portfolioB.AF.Service.SkillsService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("skills")
@CrossOrigin(origins = "http://localhost:4200")
public class ContrSkills {
@Autowired
SkillsService skillsService;

@GetMapping("/lista")    
public ResponseEntity <List<Skills>> list() { 
    List<Skills> list = skillsService.list();
    return new ResponseEntity(list, HttpStatus.OK);
}
    

@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody DtoSkills dtosk) {
    if(StringUtils.isBlank(dtosk.getNameSk()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    if(skillsService.existsByNameSk(dtosk.getNameSk()))
    return new ResponseEntity(new Mensaje("Esa hablilidad existe"), HttpStatus.BAD_REQUEST);
    
   Skills skill = new Skills(dtosk.getNameSk(), dtosk.getPorcS());
   skillsService.save(skill);
    
    return new ResponseEntity(new Mensaje ("Hablilidad agregada"), HttpStatus.OK);
    
}

@PutMapping("/update/(id)")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoSkills dtosk) {
    //validamos si existe el ID
    if(!skillsService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    if(skillsService.existsByNameSk(dtosk.getNameSk()) &&  skillsService.getByNameSk(dtosk.getNameSk()).get().getId() != id)
        return new ResponseEntity(new Mensaje("Esa habilidad ya existe"), HttpStatus.BAD_REQUEST);
    //No puede estar vacío
    if(StringUtils.isBlank(dtosk.getNameSk()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
    Skills skill = skillsService.getOne(id).get();
    skill.setNameSk(dtosk.getNameSk());
    skill.setPorcS(dtosk.getPorcS());
    
    skillsService.save(skill);
    return new ResponseEntity(new Mensaje("Habilidad ectualizada"), HttpStatus.OK);
    
}

public ResponseEntity<?> delete(@PathVariable("id") int id) {
    //validamos si existe el ID
    if(!skillsService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
   
    skillsService.delete(id);
    
    return new ResponseEntity(new Mensaje("Habilidad eliminada"),HttpStatus.OK);
    
}

}