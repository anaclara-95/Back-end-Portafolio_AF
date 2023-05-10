

package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
    @NotBlank
    private String nameSk;
    @NotBlank
    private String porcS;
    
    //constructores

    public DtoSkills() {
    }

    public DtoSkills(String nameSk, String porcS) {
        this.nameSk = nameSk;
        this.porcS = porcS;
    }

    
    
    //getters & setters

    public String getNameSk() {
        return nameSk;
    }

    public void setNameSk(String nameSk) {
        this.nameSk = nameSk;
    }

    public String getPorcS() {
        return porcS;
    }

    public void setPorcS(String porcS) {
        this.porcS = porcS;
    }

    
 
    
}
