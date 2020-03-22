package com.my.servlet;

import com.my.pojo.Student;
import com.my.service.StudentService;
import com.my.serviceImp.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequestWrapper;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService = new StudentServiceImpl();
    private String result = null;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        List<Student> studentList = null;
        Student student = null;
        switch (method){
            case "queryAll":
                studentList = studentService.queryAll();
                req.setAttribute("studentList",studentList);
                req.getRequestDispatcher("queryAll.jsp").forward(req,resp);
                break;
            case "queryById":
                String idStr = req.getParameter("id");
                Integer id = Integer.parseInt(idStr);
                student = studentService.queryById(id);
                result = studentService.getResult();
                req.setAttribute("student",student);
                req.setAttribute("result",result);
                String update = req.getParameter("update");
                switch (update){
                    case "true":
                        req.getRequestDispatcher("update.jsp").forward(req,resp);
                        break;
                    default:
                        req.getRequestDispatcher("queryOne.jsp").forward(req,resp);
                        break;
                }
                break;
            case "queryByName":
                String name = req.getParameter("name");
                student = studentService.queryByName(name);
                result = studentService.getResult();
                req.setAttribute("student",student);
                req.setAttribute("result",result);
                req.getRequestDispatcher("queryOne.jsp").forward(req,resp);
                break;
            case "deleteStudent":
                String idStr1 = req.getParameter("id");
                Integer id1 = Integer.parseInt(idStr1);
                studentService.deleteStudent(id1);
                result = studentService.getResult();
                req.getRequestDispatcher("/student?method=queryAll").forward(req,resp);
                break;
            case "insertStudent":
                String name1 = req.getParameter("name");
                String scoreStr = req.getParameter("score");
                Double score = Double.parseDouble(scoreStr);
                Date date = new Date(1);
                student = new Student();
                student.setName(name1);
                student.setScore(score);
                student.setDate(date);
                studentService.insertStudent(student);
                resp.sendRedirect("/student?method=queryAll");
                break;
            case "updateStudent":
                String idStr2 = req.getParameter("id");
                Integer id2 = Integer.parseInt(idStr2);
                String name2 = req.getParameter("name");
                String scoreStr1 = req.getParameter("score");
                Double score1 = Double.parseDouble(scoreStr1);
                Date date1 = new Date(1);
                student = new Student();
                student.setId(id2);
                student.setName(name2);
                student.setScore(score1);
                student.setDate(date1);
                studentService.updateStudent(student);
                req.getRequestDispatcher("/student?method=queryAll").forward(req,resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
