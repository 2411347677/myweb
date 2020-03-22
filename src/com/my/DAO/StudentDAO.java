package com.my.DAO;

import com.my.pojo.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * 定义数据库增删改查方法
 */
public interface StudentDAO {
    /**
     * 查询所有学生信息
     * @return List<Student>
     * @throws SQLException
     */
    public List<Student> queryAll() throws SQLException;

    /**
     * 根据id查询学生
     * @return Student
     * @throws SQLException
     */
    public Student queryById(Integer id) throws SQLException;

    /**
     * 根据姓名查询学生
     * @return Student
     * @throws SQLException
     */
    public Student queryByName(String name) throws SQLException;

    /**
     * 增加学生信息
     * @param student
     * @return  boolean
     * @throws SQLException
     */
    public boolean insertStudent(Student student) throws SQLException;

    /**
     * 删除学生信息
     * @param student
     * @return  boolean
     * @throws SQLException
     */
    public boolean deleteStudent(Integer id) throws SQLException;

    /**
     * 修改学生信息
     * @param student
     * @return  boolean
     * @throws SQLException
     */
    public boolean updateStudent(Student student) throws SQLException;

}
