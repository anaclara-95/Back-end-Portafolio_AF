package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;

/**
 *
 * @author Usuario
 */
public class DtoEdu {

    @NotBlank
    private String eduI;
    @NotBlank
    private String eduDI;
    @NotBlank
    private String eduDF;
    @NotBlank
    private String eduT;
    @NotBlank
    private String eduDesc;

    public DtoEdu() {
    }

    public DtoEdu(String eduI, String eduDI, String eduDF, String eduT, String eduDesc) {
        this.eduI = eduI;
        this.eduDI = eduDI;
        this.eduDF = eduDF;
        this.eduT = eduT;
        this.eduDesc = eduDesc;
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
