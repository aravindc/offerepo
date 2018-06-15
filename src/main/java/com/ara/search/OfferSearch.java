package com.ara.search;

import com.ara.model.Offer;
import com.ara.model.Product;
import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OfferSearch {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Offer> searchOffer(String text){
        // get the full text entity manager
        FullTextEntityManager fullTextEntityManager =
                Search.getFullTextEntityManager(entityManager);

        // create the query using Hibernate Search query DSL
        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Offer.class).get();

        // a very basic query by keywords
        Query query =
                queryBuilder
                        .keyword()
                        .onFields("offername", "offerdescription", "offercode")
                        .matching(text)
                        .createQuery();

        // wrap Lucene query in an Hibernate Query object
        FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Offer.class);

        // execute search and return results (sorted by relevance as default)
        @SuppressWarnings("unchecked")
        List<Offer> results = jpaQuery.getResultList();

        return results;

    }

    public List<Product> searchProduct(String q){
        List<Product> results=null;
        return results;
    }
}
