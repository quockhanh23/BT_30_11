package controller;

import model.Student;
import service.StudentService;
import service.StudentServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/students")
public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request, response);
                break;
            default:
                showListStudent(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;

        }
    }

    void showDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/delete.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("sDelete", student);
        requestDispatcher.forward(request, response);
    }

    void showEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Student student = studentService.findById(id);
        request.setAttribute("sEdit", student);
        requestDispatcher.forward(request, response);
    }

    void showListStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/student/list.jsp");
        List<Student> studentList = studentService.findAll();
        request.setAttribute("list", studentList);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            default:
                break;
            case "edit":
                saveEdit(request, response);
                break;
            case "delete":
                saveDelete(request, response);
                break;
        }
    }

    private void saveEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double math = Double.parseDouble(request.getParameter("math"));
        double phy = Double.parseDouble(request.getParameter("physics"));
        double chem = Double.parseDouble(request.getParameter("chemistry"));
        studentService.update(id, new Student(id, name, math, phy, chem));
        response.sendRedirect("/students");

    }

    private void saveDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        response.sendRedirect("/students");
    }

}
