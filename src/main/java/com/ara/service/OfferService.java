package com.ara.service;

import com.ara.model.Offer;

import java.util.List;

public interface OfferService {
    public abstract List<Offer> findAll();
    public abstract Offer findOne(Long id);
    public abstract void saveOffer(Offer offer);
    public abstract Offer findByOffercode(String offercode);
    public abstract void updateByOffercode(Offer offer);
}
