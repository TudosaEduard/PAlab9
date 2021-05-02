package com.compulsory.repository;

import com.compulsory.entity.Movie;
import com.compulsory.utils.Singleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class ChartEntityMethods {
    public void insertDatabase(Movie moviesEntity){

        EntityManagerFactory entityManagerFactory = Singleton.getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("INSERT INTO ChartsEntity(id, title, releasedata, rating) " +
                "SELECT movies.id, movies.title, movies.releaseDate, movies.score FROM MoviesEntity movies " +
                "ORDER BY movies.score DESC");
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
