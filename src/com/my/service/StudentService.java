package com.my.service;

import com.my.pojo.Student;

import java.util.List;

public interface StudentService {
    public String getResult();
    public void setResult(String result);
    /**
     * 展示所有学生信息
     * @return List<Student>
     */
    public List<Student> queryAll();
    /**
     * 根据id查询学生信息
     * @param id
     * @return Student
     */
    public Student queryById(Integer id);

    /**
     * 根据名字查询
     * @param name
     * @return Student
     */
    public Student queryByName(String name);

    /**
     * 增加学生
     * @param student
     * @return boolean
     */
    public boolean insertStudent(Student student);

    /**
     * 根据id删除学生
     * @param id
     * @return boolean
     */
    public boolean deleteStudent(Integer id);

    /**
     * 更新学生信息
     * @param student
     * @return boolean
     */
    public boolean updateStudent(Student student);
}
