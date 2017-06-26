/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cwi.crescer.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Criteria;
import org.hibernate.Session;


/**
 *
 * @author mathias
 */
public abstract class GenericDao<Entity, ID> implements CrudDao<Entity, ID>  {
    
    private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("HIBERNATE");
    private final EntityManager entityManager = factory.createEntityManager();
    private final Session session = entityManager.unwrap(Session.class);
    private Class<Entity> entityClass;
    
    public GenericDao(Class<Entity> entityClass) {
        this.entityClass = entityClass;
    }
    
    @Override
    public Entity save(Entity e) {
        entityManager.getTransaction().begin();
        session.saveOrUpdate(e);
        entityManager.getTransaction().commit();

        return e;
    }

    @Override
    public void remove(Entity e) {
        entityManager.getTransaction().begin();
        session.delete(e);
        entityManager.getTransaction().commit();
    }

    @Override
    public Entity loadById(ID id) {
        return (Entity) session.load(entityClass, (Serializable) id);
    }

    @Override
    public List<Entity> findAll() {
        Criteria criteria = session.createCriteria(entityClass);
        return criteria.list();
    }
    
    public void closeConnection() {
        entityManager.close();
        factory.close();
    }
}
