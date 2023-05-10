package com.portfolioB.AF.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Usuario
 */
@Entity

public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String eduI;
    @NotNull
    private String eduDI;
    @NotNull
    private String eduDF;
    @NotNull
    private String eduT;
    @NotNull
    private String eduDesc;

    //constructor
    public Education() {
    }

    public Education(String eduI, String eduDI, String eduDF, String eduT, String eduDesc) {
        this.eduI = eduI;
        this.eduDI = eduDI;
        this.eduDF = eduDF;
        this.eduT = eduT;
        this.eduDesc = eduDesc;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEduI() {
        return eduI;
    }

    public void setEduI(String eduI) {
        this.eduI = eduI;
    }

    public String getEduDI() {
        return eduDI;
    }

    public void setEduDI(String eduDI) {
        this.eduDI = eduDI;
    }

    public String getEduDF() {
        return eduDF;
    }

    public void setEduDF(String eduDF) {
        this.eduDF = eduDF;
    }

    public String getEduT() {
        return eduT;
    }

    public void setEduT(String eduT) {
        this.eduT = eduT;
    }

    public String getEduDesc() {
        return eduDesc;
    }

    public void setEduDesc(String eduDesc) {
        this.eduDesc = eduDesc;
    }

}
