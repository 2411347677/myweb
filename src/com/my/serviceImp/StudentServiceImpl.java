package com.my.serviceImp;

import com.my.DAOFactory.DAOFactory;
import com.my.pojo.Student;
import com.my.service.StudentService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private String result;

    @Override
    public String getResult() {
        return result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public List<Student> queryAll() {
        List<Student> studentList = null;
        try {
            studentList = DAOFactory.getStudentDAOInstance().queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentList;
    }

    @Override
    public Student queryById(Integer id) {
        Student student = null;
        try {
            student = DAOFactory.getStudentDAOInstance().queryById(id);
            if(student.getId()!=null){
                this.setResult("查询成功，查询结果为：");
            }else{
                this.setResult("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public Student queryByName(String name) {
        Student student = null;
        try {
            student = DAOFactory.getStudentDAOInstance().queryByName(name);
            if(student.getId()!=null){
                this.setResult("查询成功，查询结果为：");
            }else{
                this.setResult("查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean insertStudent(Student student) {
        boolean flag = false;
        try {
            flag = DAOFactory.getStudentDAOInstance().insertStudent(student);
            if(flag){
                this.setResult("插入成功");
            }else{
                this.setResult("插入失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean deleteStudent(Integer id) {
        boolean flag = false;
        try {
            flag = DAOFactory.getStudentDAOInstance().deleteStudent(id);
            if(flag){
                this.setResult("删除成功");
            }else{
                this.setResult("删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean updateStudent(Student student) {
        boolean flag = false;
        try {
            flag = DAOFactory.getStudentDAOInstance().updateStudent(student);
            if(flag){
                this.setResult("更新成功");
            }else{
                this.setResult("更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
