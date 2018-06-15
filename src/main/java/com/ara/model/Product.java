package com.ara.model;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;

/**
 * Product class
 */
@Entity
@Table(name = "product")
@Indexed
public class Product {

    private Long productid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String productname;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String productcode;
    private int skuno;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String classid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String classvalue;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String categoryid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String categoryvalue;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String supercatid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String supercatvalue;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String groupid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String groupvalue;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String departmentid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String departmentvalue;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String brandid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String brandvalue;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productid", unique = true, nullable = false)
    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductcode() {
        return productcode;
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public int getSkuno() {
        return skuno;
    }

    public void setSkuno(int skuno) {
        this.skuno = skuno;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClassvalue() {
        return classvalue;
    }

    public void setClassvalue(String classvalue) {
        this.classvalue = classvalue;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryvalue() {
        return categoryvalue;
    }

    public void setCategoryvalue(String categoryvalue) {
        this.categoryvalue = categoryvalue;
    }

    public String getSupercatid() {
        return supercatid;
    }

    public void setSupercatid(String supercatid) {
        this.supercatid = supercatid;
    }

    public String getSupercatvalue() {
        return supercatvalue;
    }

    public void setSupercatvalue(String supercatvalue) {
        this.supercatvalue = supercatvalue;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupvalue() {
        return groupvalue;
    }

    public void setGroupvalue(String groupvalue) {
        this.groupvalue = groupvalue;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentvalue() {
        return departmentvalue;
    }

    public void setDepartmentvalue(String departmentvalue) {
        this.departmentvalue = departmentvalue;
    }

    public String getBrandid() {
        return brandid;
    }

    public void setBrandid(String brandid) {
        this.brandid = brandid;
    }

    public String getBrandvalue() {
        return brandvalue;
    }

    public void setBrandvalue(String brandvalue) {
        this.brandvalue = brandvalue;
    }

}
