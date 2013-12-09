package br.ufrn.ceres.bsi.questions.dao;

import br.ufrn.ceres.bsi.questions.model.Usuario;
import br.ufrn.ceres.bsi.questions.model.Questao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;



/**
 * Implementation of the generic Data Access Service
 * All CRUD (create, read, update, delete) basic data access operations for any
 * persistent object are performed in this class.
 * @author Emre Simtay <emre@simtay.com>
 */

public abstract class DataAccessService<T> {

    @PersistenceContext
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DataAccessService() {
    }

    private Class<T> type;

    /**
     * Default constructor
     *
     * @param type
     *            entity class
     */
    public DataAccessService(Class<T> type, EntityManagerFactory emf) {
        this.type = type;
        this.emf = emf;
    }

    public T create(T t) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.flush();
            em.getTransaction().commit();
            //return t;
        }
        catch (Exception ex) {
            throw ex;
        }
        return t;
    }


    public void delete(Integer id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Object ref;
            ref = em.getReference(Questao.class, id);
            em.remove(ref);
            em.getTransaction().commit();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }

    }

    /**
     * Removes the number of entries from a table
     * @param <T>
     * @param items
     * @return
     */
    /*
    public boolean deleteItems(T[] items) {
        for (T item : items) {
            if( item instanceof Usuario){
                Usuario user = (Usuario)item;
                if(user.getId() == 1){
                    continue;
                }
            }
            else if( item instanceof Questao){
                Questao questao = (Questao)item;
                if(questao.getId() == 1){
                    continue;
                }
            }
            T.remove(T.merge(item));
        }
        return true;
    }

    /**
     * Updates the entity instance
     * @param <T>
     * @param t
     * @return the object that is updated
     */
    public T update(T item) {
        if( item instanceof Usuario){
                Usuario user = (Usuario)item;
                if(user.getId() == 1){
                    return item;
                }
            }
        else if( item instanceof Questao){
            Questao user = (Questao)item;
            if(user.getId() == 1){
                return item;
            }
        }
        return (T) this.getEntityManager().merge(item);


    }

    public List<T> findEntities() {
        return findEntities(true, -1, -1);
    }

    public List<T> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private List<T> findEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(this.type));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Questao findQuestao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Questao.class, id);
        } finally {
            em.close();
        }
    }







}