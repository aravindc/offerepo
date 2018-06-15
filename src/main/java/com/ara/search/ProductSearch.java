package com.ara.search;

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
public class ProductSearch {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> searchProduct(String text){
        // get the full text entity manager
        FullTextEntityManager fullTextEntityManager =
                Search.getFullTextEntityManager(entityManager);

        // create the query using Hibernate Search query DSL
        QueryBuilder queryBuilder =
                fullTextEntityManager.getSearchFactory()
                        .buildQueryBuilder().forEntity(Product.class).get();

        // a very basic query by keywords
        Query query =
                queryBuilder
                        .keyword()
                        .onFields("productname", "productcode","classid","classvalue","categoryid","categoryvalue","supercatid","supercatvalue","groupid","groupvalue","departmentid","departmentvalue","brandid","brandvalue")
                        .matching(text)
                        .createQuery();


        Query query1 =
                queryBuilder
                        .range()
                        .onField("skuno")
                        .from(0).to(999999999).excludeLimit()
                        .createQuery();

        // wrap Lucene query in an Hibernate Query object
        FullTextQuery jpaQuery =
                fullTextEntityManager.createFullTextQuery(query, Product.class);

        // execute search and return results (sorted by relevance as default)
        @SuppressWarnings("unchecked")
        List<Product> results = jpaQuery.getResultList();

        return results;

    }
}
