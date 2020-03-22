package com.my.DAOFactory;

import com.my.DAO.StudentDAO;

import com.my.DAOProxy.StudentDAOProxy;


public class DAOFactory {
    public static StudentDAO getStudentDAOInstance() throws Exception{
        return new StudentDAOProxy();
    }
}
