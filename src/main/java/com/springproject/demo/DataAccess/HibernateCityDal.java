package com.springproject.demo.DataAccess;

import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.EclipseLinkTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springproject.demo.Entities.City;
import com.springproject.demo.Entities.QCity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
public class HibernateCityDal implements ICityDal {
    private static QCity city = QCity.city;
    private EntityManager entityManager;
    private JPAQueryFactory queryFactory;

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.queryFactory = new JPAQueryFactory(EclipseLinkTemplates.DEFAULT, entityManager);

    }

    @Override
    @Transactional
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class);
        List<City> cities = session.createQuery("from City", City.class).getResultList();

        return cities;
    }

    @Override
    public City add(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
        return getById((int) city.getId());
    }

    @Override
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(city);
    }

    @Override
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(city);
    }

    @Override
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class);
        City city = session.get(City.class, id);
        return city;
    }

    @Override
    public Optional<City> findOne(Predicate predicate) {
        City c = queryFactory.selectFrom(city)
                .where(predicate).fetchOne();
        return null;
    }

    @Override
    public Iterable<City> findAll(Predicate predicate) {

        Iterable<City> c = queryFactory.selectFrom(city)
                .where(predicate).fetch();

        return c;
    }

    @Override
    public Iterable<City> findAll(Predicate predicate, Sort sort) {
        return null;
    }

    @Override
    public Iterable<City> findAll(Predicate predicate, OrderSpecifier<?>... orderSpecifiers) {

        Iterable<City> c = (Iterable<City>) queryFactory.from(city).where(predicate).orderBy(orderSpecifiers).fetch();

        return c;
    }

    @Override
    public Iterable<City> findAll(OrderSpecifier<?>... orderSpecifiers) {
        return null;
    }

    @Override
    public Page<City> findAll(Predicate predicate, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Predicate predicate) {
        return 0;
    }

    @Override
    public boolean exists(Predicate predicate) {
        return false;
    }
}
