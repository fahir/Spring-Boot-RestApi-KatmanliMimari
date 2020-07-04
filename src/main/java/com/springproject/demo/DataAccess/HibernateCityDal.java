package com.springproject.demo.DataAccess;

import com.springproject.demo.Entities.City;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class HibernateCityDal implements  ICityDal{
    private EntityManager entityManager;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<City> getAll() {
     Session session=entityManager.unwrap(Session.class);
     List<City> cities=session.createQuery("from City",City.class).getResultList();

        return cities;
    }

    @Override
    public City add(City city) {
        Session session=entityManager.unwrap(Session.class);
session.saveOrUpdate(city) ;
return getById((int)city.getId());
    }

    @Override
    public void update(City city) {
        Session session=entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        Session session=entityManager.unwrap(Session.class);
        session.delete(city);
    }

    @Override
    public City getById(int id) {
        Session session=entityManager.unwrap(Session.class);
     City city=   session.get(City.class,id);
     return  city;
    }
}
