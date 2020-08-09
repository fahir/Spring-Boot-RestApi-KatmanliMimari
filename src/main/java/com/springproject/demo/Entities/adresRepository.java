package com.springproject.demo.Entities;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class adresRepository {
    private EntityManager entityManager;

    public adresRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public adresRepository() {
    }
    @Transactional
    public List<Adres> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<Adres> cities = session.createQuery("from City", Adres.class).getResultList();

        return cities;
    }
}
