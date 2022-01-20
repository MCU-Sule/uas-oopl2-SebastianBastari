package com.example.uaspbo2.DAO;

import java.util.List;

/**
 * Sebastian Giovanni Bastari 1972006
 */
public interface DAOinterface<E> {
    public int addData(E data) ;

    public int delData(E data) ;

    public int updateData(E data);

    public List<E> showData();
}
