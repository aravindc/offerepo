package com.ara.app;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
public class BuildSearchIndex implements ApplicationListener<ApplicationReadyEvent> {

    @PersistenceContext(type = PersistenceContextType.EXTENDED, name = "offersPU")
    private EntityManager entityManager;

    private FullTextEntityManager fullTextEntityManager;

    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        try {
            /* Added to check Lucene full text search */
            final EntityManagerFactory entityManagerFactory = Persistence
                    .createEntityManagerFactory("hascode-local");
            entityManager = entityManagerFactory.createEntityManager();
            /* Added to check Lucene full text search */
            fullTextEntityManager =
                    Search.getFullTextEntityManager(entityManager);
            fullTextEntityManager.createIndexer().startAndWait();
        }
        catch (Exception e) {
            System.out.println(
                    "An error occurred trying to build the serach index: " +
                            e.toString());
        }
    }
}
