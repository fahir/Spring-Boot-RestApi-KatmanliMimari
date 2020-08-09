package com.springproject.demo.Business;


import com.querydsl.core.types.*;
import com.querydsl.core.types.dsl.Expressions;
import com.springproject.demo.DataAccess.ICityDal;
import com.springproject.demo.Entities.City;
import com.springproject.demo.Entities.QCity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.Predicate;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static com.springproject.demo.Entities.QCity.city;

@Service
public class CityManager implements ICityService {
    private ICityDal _cityDal;

    @Autowired
    public CityManager(ICityDal cityDal) {
        this._cityDal = cityDal;
    }

    @Override
    @Transactional
    public List<City> getAll() {

        return _cityDal.getAll();
    }

    @Transactional
    @Override
    public City getById(int id) {
        return _cityDal.getById(id);
    }

    @Override
    @Transactional
    public City add(City city) {
        return _cityDal.add(city);
    }

    @Override
    @Transactional
    public void update(City city) {
        _cityDal.update(city);
    }

    @Override
    @Transactional
    public void delete(City city) {
        _cityDal.update(city);
    }


    @Override
    public Iterable<City> findAll(String columnName,String value,String orderColumn) {

        com.querydsl.core.types.Predicate p = getPredicate(columnName, value);
        Order order = Order.ASC;

        Path<Object> fieldPath = Expressions.path(Object.class, city, orderColumn.isEmpty()?"Id":orderColumn);

        OrderSpecifier<Integer> sortOrder1 = new OrderSpecifier(order, fieldPath);
        return _cityDal.findAll(p/*,sortOrder1*/);//sortorder ile hata veriyor

    }

    private com.querydsl.core.types.Predicate getPredicate(String column, String value) {


        Class aClass = City.class;
        com.querydsl.core.types.Predicate p=null;
        Field field;

        try {
            field = aClass.getDeclaredField(column);


            Path<City> person = Expressions.path(City.class, "city");
            String fieldType = field.getType().getName();

            Class methodClass = String.class;
            String className;
            switch (fieldType) {
                case "int":
                    className = "Integer";
                    break;
                case "boolean":
                    className = "Boolean";
                    break;
                case "byte":
                    className = "Byte";
                    break;
                case "short":
                    className = "Short";
                    break;
                case "char":
                    className = "Character";
                    break;
                case "long":
                    className = "Long";
                    break;
                case "float":
                    className = "Float";
                    break;
                case "double":
                    className = "Double";
                    break;

                default:
                    className = "String";
                    break;
            }
            if (className == "String")
                methodClass = Object.class;

            Class<?> theValue = Class.forName("java.lang." + className);
            Method parseMethod = theValue.getDeclaredMethod("valueOf", methodClass);
            Object obj = parseMethod.invoke(theValue, value);
            Path<Object> personFirstName = Expressions.path(theValue, person, column);
            Expression<Object> constant = Expressions.constant(obj);

            p = Expressions.predicate(Ops.CONTAINS_VALUE, personFirstName, constant);

        } catch (NoSuchFieldException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();

        }
        return p;
    }

    public Iterable<City> findAllOrderByPopulation(int id) {

        Order order = Order.ASC;
        Path<Object> fieldPath = Expressions.path(Object.class, city, "population");

        com.querydsl.core.types.Predicate p = city.population.gt(id);
        OrderSpecifier<Integer> sortOrder1 = new OrderSpecifier(order, fieldPath);
        return _cityDal.findAll(p,sortOrder1);
    }

    @Override
    public Optional<City> findOne(Predicate predicate) {
        return Optional.empty();
    }

    @Override
    public List<City> getByCountryCodeLike(String countryCode) {
        com.querydsl.core.types.Predicate p = getPredicate("countrcode", countryCode);

        return (List<City>) _cityDal.findAll(p);
    }
}
