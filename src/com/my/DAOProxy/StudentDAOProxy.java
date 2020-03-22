package com.my.DAOProxy;

import com.my.DAO.StudentDAO;
import com.my.DAOImp.StudentDAOImpl;
import com.my.pojo.Student;
import com.my.utils.DatabaseConnection;

import java.sql.SQLException;
import java.util.List;

public class StudentDAOProxy implements StudentDAO {

    private DatabaseConnection databaseConnection = null;
    private StudentDAO studentDAO = null;
    public StudentDAOProxy() throws Exception {
        try {
            databaseConnection = new DatabaseConnection();
            studentDAO = new StudentDAOImpl(databaseConnection.getConnection());
        } catch (Exception e) {
            throw e;
        }
    }
    @Override
    public List<Student> queryAll() throws SQLException {
        List<Student> studentList = null;
        try {
            studentList = studentDAO.queryAll();
        } catch (SQLException e) {
            throw e;
        }finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return studentList;
    }

    @Override
    public Student queryById(Integer id) throws SQLException {
        Student student = null;
        try {
            student = studentDAO.queryById(id);
        } catch (SQLException e) {
            throw e;
        }finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return student;
    }

    @Override
    public Student queryByName(String name) throws SQLException {
        Student student = null;
        try {
            student = studentDAO.queryByName(name);
        } catch (SQLException e) {
            throw e;
        }finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return student;
    }

    @Override
    public boolean insertStudent(Student student) throws SQLException {
        boolean flag = false;
        try {
            flag = studentDAO.insertStudent(student);
        } catch (SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(Integer id) throws SQLException {
        boolean flag = false;
        try {
            flag = studentDAO.deleteStudent(id);
        } catch (SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return flag;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean flag = false;
        try {
            flag = studentDAO.updateStudent(student);
        } catch (SQLException e) {
            throw e;
        } finally {
            DatabaseConnection.close(databaseConnection.getConnection());
        }
        return flag;
    }
}
