/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.dao;

import com.vm.entity.PenjualanHasItem;
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
public class PenjualanHasItemDaoImpl implements DaoService<PenjualanHasItem> {

    @Override
    public int AddData(PenjualanHasItem object) throws SQLException {
        int result = 0;
        Session session = NewHibernateUtil.getSessionFactory().
                openSession();
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
    public int UpdateData(PenjualanHasItem object) throws SQLException {
        int result = 0;

        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public int DeleteData(PenjualanHasItem object) throws SQLException {
        int result = 0;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(object);
            transaction.commit();
            result = 1;
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<PenjualanHasItem> getAllData() throws SQLException {
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.
                createCriteria(PenjualanHasItemDaoImpl.class).setFetchMode(
                "Item", FetchMode.JOIN).
                setFetchMode("Penjualan", FetchMode.JOIN);
        List<PenjualanHasItem> penjualans = criteria.list();
        session.close();
        return penjualans;
    }

    @Override
    public Object getData() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
