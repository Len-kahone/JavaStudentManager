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
 * @date 2019/8/6 10:17
 */
@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            String s = request.getParameter("sid");
            int sid=Integer.valueOf(s);
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            String phone = request.getParameter("phone");
            String b = request.getParameter("birthday");
            Date birthday=new SimpleDateFormat("yyyy-MM-dd").parse(b);
            String[] harr = request.getParameterValues("hobby");
            String hobby= Arrays.toString(harr);
             hobby=hobby.substring(1,hobby.length()-1);
            String info = request.getParameter("info");
            Student student = new Student(sid, sname, gender, phone, birthday, hobby, info);
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();
            studentSerivice.updateStudent(student);
            request.getRequestDispatcher("StudentList").forward(request,response);

        } catch (ParseException | SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();
            String sid = request.getParameter("sid");
            Student s = studentSerivice.findStudentById(sid);
            request.setAttribute("stu",s);
            request.getRequestDispatcher("edit.jsp").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
