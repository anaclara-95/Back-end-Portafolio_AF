
package com.portfolioB.AF.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Projects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nameP;
    @NotNull
    private String descP;
    @NotNull
    private String urlcP;
    @NotNull
    private String urlpP;
    @NotNull
    private String imgP;
    
    //Constructores

    public Projects() {
    }

    public Projects(String nameP, String descP, String urlcP, String urlpP, String imgP) {
        this.nameP = nameP;
        this.descP = descP;
        this.urlcP = urlcP;
        this.urlpP = urlpP;
        this.imgP = imgP;
    }
    
    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }

    public String getUrlcP() {
        return urlcP;
    }

    public void setUrlcP(String urlcP) {
        this.urlcP = urlcP;
    }

    public String getUrlpP() {
        return urlpP;
    }

    public void setUrlpP(String urlpP) {
        this.urlpP = urlpP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }

    
    
   
    }
    
    



