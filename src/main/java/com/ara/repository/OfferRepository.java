package com.ara.repository;

import com.ara.model.Offer;
import org.springframework.data.repository.Repository;

public interface OfferRepository extends Repository<Offer, Long> {
    Offer findByOffercode(String offercode);
}