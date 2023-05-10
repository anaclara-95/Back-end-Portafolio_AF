

package com.portfolioB.AF.Controller;

import com.portfolioB.AF.Dto.DtoExp;
import com.portfolioB.AF.Entity.Experience;
import com.portfolioB.AF.Service.ExpService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ContrExp {
@Autowired 
ExpService expService;

@GetMapping("/lista")
public ResponseEntity <List<Experience>> list() { 
    List<Experience> list = expService.list();
    return new ResponseEntity(list, HttpStatus.OK);
}

@PostMapping("/create")
@SuppressWarnings("SuspiciousIndentAfterControlStatement")
public ResponseEntity<?> create(@RequestBody DtoExp dtoex) {
    if(StringUtils.isBlank(dtoex.getNameE()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    if(expService.existsByNameE(dtoex.getNameE()))
    return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
    
    Experience exp = new Experience(dtoex.getNameE(),dtoex.getOcpE(), dtoex.getDateI(), dtoex.getDateF(), dtoex.getDescE(), dtoex.getRefE());
    expService.save(exp);
    
    return new ResponseEntity(new Mensaje ("Experiencia agregada"), HttpStatus.OK);
    
}
@PutMapping("/update/(id)")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoExp dtoex) {
    //validamos si existe el ID
    if(!expService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    if(expService.existsByNameE(dtoex.getNameE()) && expService.getByNameE(dtoex.getNameE()).get().getId() != id)
        return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);
    //No puede estar vacío
    if(StringUtils.isBlank(dtoex.getNameE()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
    Experience exp = expService.getOne(id).get();
    exp.setNameE(dtoex.getNameE());
    exp.setOcpE(dtoex.getOcpE());
    exp.setDateI(dtoex.getDateI());
    exp.setDateF(dtoex.getDateF());
    exp.setDescE(dtoex.getDescE());
    exp.setRefE(dtoex.getRefE());
    
    expService.save(exp);
    return new ResponseEntity(new Mensaje("Experiencia ectualizada"), HttpStatus.OK);
    
}

@DeleteMapping("delete")
public ResponseEntity<?> delete(@PathVariable("id") int id) {
    //validamos si existe el ID
    if(!expService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
   
    expService.delete(id);
    
    return new ResponseEntity(new Mensaje("Experiencia eliminada"),HttpStatus.OK);
    
    
}

}


