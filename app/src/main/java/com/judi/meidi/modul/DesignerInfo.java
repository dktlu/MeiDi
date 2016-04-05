package com.judi.meidi.modul;

import java.io.Serializable;

/**
 * 设计师bean类
 * Created by Administrator on 2016/4/1.
 */
public class DesignerInfo implements Serializable {

    private int picID;
    private String name;
    private String position;
    private String school;
    private String worksExperience;
    private String product;
    private String designConcept;
    private String style;
    private String winning;
    private String phone;

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getWorksExperience() {
        return worksExperience;
    }

    public void setWorksExperience(String worksExperience) {
        this.worksExperience = worksExperience;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDesignConcept() {
        return designConcept;
    }

    public void setDesignConcept(String designConcept) {
        this.designConcept = designConcept;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getWinning() {
        return winning;
    }

    public void setWinning(String winning) {
        this.winning = winning;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPicID() {
        return picID;
    }

    public void setPicID(int picID) {
        this.picID = picID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
