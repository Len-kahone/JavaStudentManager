package servlet;

import service.impl.StudentSeriviceImpl;
import student.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 练家鸿
 * @Package ${PACKAGE_NAME}
 * @date 2019/8/6 8:58
 */
@WebServlet(name = "AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String[] h = request.getParameterValues("hobby");
            String hobby=Arrays.toString(h);
            hobby=hobby.substring(1,hobby.length()-1);
            String info = request.getParameter("info");
            Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("birthday"));
            Student student = new Student(sname, gender, phone, birthday, hobby, info);
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();

            studentSerivice.addStudent(student);
            request.getRequestDispatcher("StudentList").forward(request,response);

            System.out.println(11111111);


        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
