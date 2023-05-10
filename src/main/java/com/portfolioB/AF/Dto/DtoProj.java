

package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoProj {
@NotBlank
private String nameP;
@NotBlank 
private String descP;
@NotBlank
private String urlcP;
@NotBlank 
private String urlpP;
@NotBlank 
private String imgP; 

    public DtoProj() {
    }

    public DtoProj(String nameP, String descP, String urlcP, String urlpP, String imgP) {
        this.nameP = nameP;
        this.descP = descP;
        this.urlcP = urlcP;
        this.urlpP = urlpP;
        this.imgP = imgP;
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

