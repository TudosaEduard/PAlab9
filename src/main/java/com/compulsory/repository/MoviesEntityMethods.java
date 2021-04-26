package com.compulsory.repository;

import com.compulsory.entity.Movie;
import com.compulsory.utils.Singleton;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class MoviesEntityMethods implements  AbstractRepository<Movie>{

    private static final EntityManagerFactory entityManagerFactory = Singleton.getEntityManagerFactory();
    @Test
    @Override
    public void create(Movie moviesEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;

        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(moviesEntity);
            entityTransaction.commit();
        } catch (Exception ex) {
            if (entityTransaction != null) {
                entityTransaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
    @Test
    @Override
    public void findById(Movie moviesEntity) {
        EntityManager em = entityManagerFactory.createEntityManager();

        String query = "SELECT movies FROM Movie movies WHERE movies.id = :moviesID";

        TypedQuery<Movie> tq = em.createQuery(query, Movie.class);
        tq.setParameter("moviesID", moviesEntity.getId());

        Movie movie = null;

        try {
            movie = tq.getSingleResult();
            System.out.println("ID: " + movie.getId() + " TITLU: " + movie.getTitle() +  " DATA LANSARII: "
                    + movie.getReleaseDate() + " TIMP: " + movie.getDuration() + " SCOR: " + movie.getScore());
        }
        catch (NoResultException ex) {
            ex.printStackTrace();
        }
        finally {
            em.close();
        }
    }
    @Test
    @Override
    public void findByName(Movie moviesEntity){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT movie from Movie movie WHERE movie.title like :title ");
        List movies = query.setParameter("title", moviesEntity.getTitle()).getResultList();
        em.close();
        System.out.println(movies.isEmpty()? null : movies.get(0).toString());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

