package com.portfolioB.AF.Controller;

import com.portfolioB.AF.Dto.DtoEdu;
import com.portfolioB.AF.Entity.Education;
import com.portfolioB.AF.Service.EduService;
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

/**
 *
 * @author Usuario
 */
@RestController
@RequestMapping("education")
@CrossOrigin(origins = "https://portafolioaf-30343.web.app")
public class ContrEdu {

    @Autowired
    EduService eduService;

    @GetMapping("/lista")
    public ResponseEntity<List<Education>> list() {
        List<Education> list = eduService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    @SuppressWarnings("SuspiciousIndentAfterControlStatement")
    public ResponseEntity<?> create(@RequestBody DtoEdu dtoedu) {
        if (StringUtils.isBlank(dtoedu.getEduI())) {
            return new ResponseEntity(new Mensaje("El nombre de la institución es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (eduService.existsByEduI(dtoedu.getEduI())) {
            return new ResponseEntity(new Mensaje("Esa institución educativa ya existe"), HttpStatus.BAD_REQUEST);
        }

        Education edu = new Education(dtoedu.getEduI(), dtoedu.getEduDI(), dtoedu.getEduDF(), dtoedu.getEduT(), dtoedu.getEduDesc());
        eduService.save(edu);

        return new ResponseEntity(new Mensaje("Institución educativa agregada"), HttpStatus.OK);
    }
@GetMapping("/detail/{id}")
 public ResponseEntity<Education> getById(@PathVariable("id") int id){
     if(!eduService.existsById(id))
         return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
     Education edu= eduService.getOne(id).get();
     return new ResponseEntity(edu, HttpStatus.OK);
 }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoEdu dtoedu) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        if (eduService.existsByEduI(dtoedu.getEduI()) && eduService.getByEduI(dtoedu.getEduI()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa institución educativa ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoedu.getEduI())) {
            return new ResponseEntity(new Mensaje("El nomre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Education edu = eduService.getOne(id).get();
        edu.setEduI(dtoedu.getEduI());
        edu.setEduDI(dtoedu.getEduDI());
        edu.setEduDF(dtoedu.getEduDF());
        edu.setEduT(dtoedu.getEduT());
        edu.setEduDesc(dtoedu.getEduDesc());

        eduService.save(edu);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!eduService.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }

        eduService.delete(id);
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);

    }

}
