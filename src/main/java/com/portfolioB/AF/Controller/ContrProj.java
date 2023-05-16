

package com.portfolioB.AF.Controller;

import com.portfolioB.AF.Dto.DtoProj;
import com.portfolioB.AF.Entity.Projects;
import com.portfolioB.AF.Service.ProjService;
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
@RequestMapping("projects")
@CrossOrigin(origins = "http://localhost:4200")
public class ContrProj {
    @Autowired
    ProjService projService;
    
@GetMapping("/lista")
public ResponseEntity <List<Projects>> list() { 
    List<Projects> list = projService.list();
    return new ResponseEntity(list, HttpStatus.OK);
    
}
@GetMapping("/detail/{id}")
 public ResponseEntity<Projects> getById(@PathVariable("id") int id){
     if(!projService.existsById(id))
         return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
     Projects proj= projService.getOne(id).get();
     return new ResponseEntity(proj, HttpStatus.OK);
 }

@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/create")
public ResponseEntity<?> create(@RequestBody DtoProj dtoproj) {
    if(StringUtils.isBlank(dtoproj.getNameP()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
    if(projService.existsByNameP(dtoproj.getNameP()))
    return new ResponseEntity(new Mensaje("Ese proyecto existe"), HttpStatus.BAD_REQUEST);
    
  Projects proj = new Projects(dtoproj.getNameP(), dtoproj.getDescP(), dtoproj.getUrlcP(), dtoproj.getUrlpP(), dtoproj.getImgP());
  projService.save(proj);
    return new ResponseEntity(new Mensaje ("Proyecto agregado"), HttpStatus.OK);
    
}
@PreAuthorize("hasRole('ADMIN')")
@PutMapping("/update/{id}")
public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProj dtoproj) {
    //validamos si existe el ID
    if(!projService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
    
    if(projService.existsByNameP(dtoproj.getNameP()) && projService.getByNameP(dtoproj.getNameP()).get().getId() != id)
        return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
    //No puede estar vacío
    if(StringUtils.isBlank(dtoproj.getNameP()))
        return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
    Projects proj = projService.getOne(id).get();
    proj.setNameP(dtoproj.getNameP());
    proj.setDescP(dtoproj.getDescP());
    proj.setUrlcP(dtoproj.getUrlcP());
    proj.setUrlpP(dtoproj.getUrlpP());
    proj.setImgP(dtoproj.getImgP());
    
    projService.save(proj);
    return new ResponseEntity(new Mensaje("Proyecyo actualizado"), HttpStatus.OK);

}

@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("delete/{id}")        
public ResponseEntity<?> delete(@PathVariable("id") int id) {
    //validamos si existe el ID
    if(!projService.existsById(id))
        return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
   
    projService.delete(id);
    
    return new ResponseEntity(new Mensaje("Proyecto eliminado"),HttpStatus.OK);

}

}






