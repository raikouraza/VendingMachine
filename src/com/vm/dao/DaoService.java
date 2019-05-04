/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vm.dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author master
 * @param <T>
 */
public interface DaoService<T> {

    int AddData(T object) throws SQLException;

    int UpdateData(T object) throws SQLException;

    int DeleteData(T object) throws SQLException;

    List<T> getAllData() throws SQLException;

    Object getData() throws SQLException;

}
