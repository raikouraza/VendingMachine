/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.dao;

import com.vm.entity.Penjualan;
import com.vm.util.NewHibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author master
 */
public class PenjualanDaoImpl implements DaoService<Penjualan> {

    @Override
    public int AddData(Penjualan object) throws SQLException {
        int result = 0;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(object);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;

    }

    @Override
    public int UpdateData(Penjualan object) throws SQLException {
        int result = 0;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(object);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int DeleteData(Penjualan object) throws SQLException {
        int result = 0;
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(object);
            transaction.commit();

        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Penjualan> getAllData() throws SQLException {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(PenjualanHasItemDaoImpl.class).setFetchMode("PenjualanHasItem", FetchMode.JOIN);
        List<Penjualan> penjualanss = criteria.list();
        session.close();
        return penjualanss;
    }

    @Override
    public Object getData() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
