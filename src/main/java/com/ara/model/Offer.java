package com.ara.model;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Store;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * Offer class
 */
@Entity
@Table(name = "offer")
@Indexed
public class Offer implements java.io.Serializable {

    private Long offerid;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String offername;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String offerdescription;
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    private String offercode;
    private String offerstartdate;
    private String offerenddate;
    private Set<Product> products = new HashSet<Product>(0);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "offerid", unique = true, nullable = false)
    public Long getOfferid() {
        return offerid;
    }

    public void setOfferid(Long offerid) {
        this.offerid = offerid;
    }

    @NotNull
    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public String getOfferdescription() {
        return offerdescription;
    }

    public void setOfferdescription(String offerdescription) {
        this.offerdescription = offerdescription;
    }

    @NotNull
    @Size(min = 5)
    public String getOffercode() {
        return offercode;
    }

    public void setOffercode(String offercode) {
        this.offercode = offercode;
    }

    public String getOfferstartdate() {
        return offerstartdate;
    }

    public void setOfferstartdate(String offerstartdate) {
        this.offerstartdate = offerstartdate;
    }

    public String getOfferenddate() {
        return offerenddate;
    }

    public void setOfferenddate(String offerenddate) {
        this.offerenddate = offerenddate;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "offer_product",
            joinColumns = {@JoinColumn(name = "offerid", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "productid", nullable = false, updatable = false)})
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

