package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.Countrylanguage;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class HibernateCountryLanguageDal implements ICountrylanguageDal
{
    private EntityManager entityManager;
@Autowired
    public HibernateCountryLanguageDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Countrylanguage> getAll() {
        Session session=entityManager.unwrap(Session.class);
        List<Countrylanguage> countrylanguages =session.createQuery("from CountryLanguage",Countrylanguage.class).getResultList();
        return countrylanguages;
    }

    @Override
    @Transactional
    public Countrylanguage add(Countrylanguage country) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(country);
        return getById(country.getLanguage());
    }

    @Override
    @Transactional
    public void update(Countrylanguage country) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(country);
    }

    @Override
    @Transactional
    public void delete(Countrylanguage country) {
        Session session=entityManager.unwrap(Session.class);
        session.delete(country);
    }

    @Override
    @Transactional
    public Countrylanguage getById(String id) {
        Session session=entityManager.unwrap(Session.class);
       return session.get(Countrylanguage.class,id);
}
}
