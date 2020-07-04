package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.City;
import com.springproject.demo.Entities.Country;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateCountryDal implements ICountryDal {

    private EntityManager entityManager;

    @Autowired
    public HibernateCountryDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Country> getAll() {
        Session session=entityManager.unwrap(Session.class);
        List<Country> countries=session.createQuery("from Country",Country.class).getResultList();

        return countries;
    }

    @Override
    @Transactional
    public Country add(Country country) {
Session session=entityManager.unwrap(Session.class);
  session.saveOrUpdate(country);
    return  getById(country.getCode());
    }

    @Override
    @Transactional

    public void update(Country country) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(country);
    }

    @Override
    @Transactional
    public void delete(Country country) {
        Session session=entityManager.unwrap(Session.class);
        session.delete(country);
    }

    @Override
    @Transactional
    public Country getById(String id) {
        Session session=entityManager.unwrap(Session.class);
        Country country=   session.get(Country.class,id);
        return  country;    }
}
