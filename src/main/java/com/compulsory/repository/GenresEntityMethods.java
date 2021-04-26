package com.compulsory.repository;

import com.compulsory.entity.Genre;
import com.compulsory.utils.Singleton;
import org.junit.Test;

import javax.persistence.*;
import java.util.List;

public class GenresEntityMethods implements AbstractRepository<Genre> {

    private static final EntityManagerFactory entityManagerFactory = Singleton.getEntityManagerFactory();
    @Test
    @Override
    public void create(Genre genresEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = null;
        try {
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(genresEntity);
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
    public void findById(Genre genresEntity) {
        EntityManager em = entityManagerFactory.createEntityManager();

        String query = "SELECT genres FROM Genre genres WHERE genres.id = :genresID";

        TypedQuery<Genre> tq = em.createQuery(query, Genre.class);
        tq.setParameter("genresID", genresEntity.getId());

        Genre genre = null;

        try {
            genre = tq.getSingleResult();
            System.out.println("ID: " + genre.getId() + "  Gen: " + genre.getType());
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
    public void findByName(Genre genresEntity){
        EntityManager em = entityManagerFactory.createEntityManager();
        Query query = em.createQuery("SELECT genres from Genre genres WHERE genres.type like :name ");
        List genres = query.setParameter("name", genresEntity.getType()).getResultList();
        em.close();
        System.out.println(genres.isEmpty()? null : genres.get(0).toString());
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
