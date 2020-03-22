package com.my.DAOImp;

import com.my.DAO.StudentDAO;
import com.my.pojo.Student;
import com.my.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public StudentDAOImpl(Connection connection){ //链接数据库
        this.connection = connection;
    }
    @Override
    public List<Student> queryAll() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "select * from table_student";
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = null;
        while(resultSet.next()){
            student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setScore(resultSet.getDouble(3));
            student.setDate(resultSet.getDate(4));
            students.add(student);
        }
        return students;
    }

    @Override
    public Student queryById(Integer id) throws SQLException {
        Student student = new Student();
        String sql = "select * from table_student where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        return queryStudent(student);
    }

    @Override
    public Student queryByName(String name) throws SQLException {
        Student student = new Student();
        String sql = "select * from table_student where name=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,name);
        return queryStudent(student);
    }

    private Student queryStudent(Student student) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setScore(resultSet.getDouble(3));
            student.setDate(resultSet.getDate(4));
        }
        DatabaseConnection.close(preparedStatement);
        DatabaseConnection.close(resultSet);
        return student;
    }

    @Override
    public boolean insertStudent(Student student) throws SQLException {
        String sql = "insert into table_student(name,score,date) values(?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setDouble(2,student.getScore());
        preparedStatement.setDate(3,student.getDate());
        if(preparedStatement.executeUpdate()>0){
            DatabaseConnection.close(preparedStatement);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(Integer id) throws SQLException {
        String sql = "delete from table_student where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        if(preparedStatement.executeUpdate()>0) {
            DatabaseConnection.close(preparedStatement);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        String sql = "update table_student set name=?,score=?,date=? where id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,student.getName());
        preparedStatement.setDouble(2,student.getScore());
        preparedStatement.setDate(3,student.getDate());
        preparedStatement.setInt(4,student.getId());
        if(preparedStatement.executeUpdate()>0){
            DatabaseConnection.close(preparedStatement);
            return true;
        }
        return false;
    }
}
