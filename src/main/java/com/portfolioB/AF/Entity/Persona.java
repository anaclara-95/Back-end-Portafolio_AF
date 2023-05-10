
package com.portfolioB.AF.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;




@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    private String Birth;
    @NotNull
    private String email;
    @NotNull
    private String imgPer;
    
//constructor

    public Persona() {
    }

    public Persona(String name, String lastName, String Birth, String email, String imgPer) {
        this.name = name;
        this.lastName = lastName;
        this.Birth = Birth;
        this.email = email;
        this.imgPer = imgPer;
    }

    
   

    //getters && setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String Birth) {
        this.Birth = Birth;
    }

    public String getImgPer() {
        return imgPer;
    }

    public void setImgPer(String imgPer) {
        this.imgPer = imgPer;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
