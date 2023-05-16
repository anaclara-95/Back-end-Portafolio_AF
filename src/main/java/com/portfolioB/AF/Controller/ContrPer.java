

package com.portfolioB.AF.Controller;

import com.portfolioB.AF.Dto.DtoPersona;
import com.portfolioB.AF.Entity.Persona;
import com.portfolioB.AF.Service.IPersonaService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("persona")
@CrossOrigin(origins = "https://portafolioaf-30343.web.app")
public class ContrPer {
    @Autowired
    IPersonaService iPersonaService;
    
@GetMapping("/lista")
public ResponseEntity <List<Persona>> list() {
  List<Persona> list = iPersonaService.list();
 return new ResponseEntity(list, HttpStatus.OK);
}
@GetMapping("/detail/{id}")
 public ResponseEntity<Persona> getById(@PathVariable("id") int id){
     if(!iPersonaService.existsById(id))
         return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
     Persona persona= iPersonaService.getOne(id).get();
     return new ResponseEntity(persona, HttpStatus.OK);
 }
/*@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody DtoPersona dtoper) {
    if(StringUtils.isBlank(dtoper.getName()))
       return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
       if(iPersonaService.existsByName(dtoper.getName()))
       return new ResponseEntity(new Mensaje("Esa persona existe"),HttpStatus.BAD_REQUEST);

Persona per = new Persona(dtoper.getName(), dtoper.getLastName(), dtoper.getBirth(), dtoper.getEmail(), dtoper.getImgPer());
iPersonaService.save(per);

return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);

}*/
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoPersona dtoper){
    //validamos si existe el ID
    if(!iPersonaService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    if(iPersonaService.existsByName(dtoper.getName()) && iPersonaService.getByName(dtoper.getName()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa persona ya existe"), HttpStatus.BAD_REQUEST);
    //No puede estar vacío
    if(StringUtils.isBlank(dtoper.getName()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"),HttpStatus.BAD_REQUEST);
    
    Persona per = iPersonaService.getOne(id).get();
    per.setName(dtoper.getName());
    per.setLastName(dtoper.getLastName());
    per.setBirth(dtoper.getBirth());
    per.setEmail(dtoper.getEmail());
    per.setDescP(dtoper.getDescP());
    per.setImgPer(dtoper.getImgPer());
    
    iPersonaService.save(per);
    return new ResponseEntity(new Mensaje("Persona actualizada"), HttpStatus.OK);
    
        
}
/*
public ResponseEntity<?> delete(@PathVariable("id") int id){
    //validamos si existe el ID
    if(!iPersonaService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    iPersonaService.delete(id);
    
    return new ResponseEntity(new Mensaje("Persona Eliminada"), HttpStatus.OK);
    
}*/





}
