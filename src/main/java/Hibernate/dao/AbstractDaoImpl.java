package Hibernate.dao;

import Hibernate.hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDaoImpl<T , ID extends Comparable<ID>>  implements AbstractDao<T , ID> {

    private Class<T> entityName = null;
    private Session session = null;
    private Transaction tx = null;

    @SuppressWarnings("unchecked")
    public AbstractDaoImpl() {
        this.entityName = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T findOne(ID id) {
        T entity = null ;
        try {
            startOperation();
            //select * from table_name where id = ?
            entity = session.get(entityName, id);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public T save(T entity) {
       try {
           startOperation();
           session.save(entity);
           tx.commit();
       } catch (HibernateException e){
           tx.rollback();
       } finally {
           session.close();
       }
        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T update(T entity) {
        try {
            startOperation();
            entity = (T) session.merge(entity);
            tx.commit();
        } catch (HibernateException e){
            tx.rollback();
        } finally {
            session.close();
        }
        return entity;
    }

    @Override
    public void delete(T entity) {
        try {
            startOperation();
            session.delete(entity);
            tx.commit();
        } catch (HibernateException e){
            System.out.println("Delete method error");
            tx.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteByID(ID id) {
        T entity = findOne(id);
        delete(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {

        List<T> data = null;
        try {
            startOperation();
            TypedQuery<T> query = session.createQuery("from "+entityName.getName());
            data = query.getResultList();
            tx.commit();
        } catch (HibernateException e){
            System.out.println(e);
            tx.rollback();
        } finally {
            session.close();
        }
        return data;
    }

    public void startOperation(){
        session = HibernateUtils.getSessionFactory().openSession();
        tx = session.beginTransaction();
    }
}
