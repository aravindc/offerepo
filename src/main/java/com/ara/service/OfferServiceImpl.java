package com.ara.service;

import com.ara.model.Offer;
import com.ara.repository.OfferJpaRepository;
import com.ara.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferJpaRepository offerJpaRepository;

    @Autowired
    private OfferRepository offerRepository;

    @Transactional
    public List<Offer> findAll() {
        return offerJpaRepository.findAll();
    }

    @Transactional
        public Offer findOne(Long id) {
            return offerJpaRepository.findOne(id);
        }

    @Transactional
    public void saveOffer(Offer offer) {
        offerJpaRepository.save(offer);
    }

    @Transactional
    public Offer findByOffercode(String offercode) {
        return offerRepository.findByOffercode(offercode);
    }

    @Transactional
    public void updateByOffercode(Offer offer) {
        offerJpaRepository.save(offer);
    }
}
