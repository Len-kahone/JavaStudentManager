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
import java.util.List;

/**
 * @author 练家鸿
 * @Package ${PACKAGE_NAME}
 * @date 2019/8/6 17:39
 */
@WebServlet(name = "SearchServlet")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();
            String sname = request.getParameter("sname");
            String gender = request.getParameter("gender");
            System.out.println(gender);
            List<Student> list = studentSerivice.searchStudent(sname, gender);
            request.setAttribute("list",list);
            request.getRequestDispatcher("list.jsp").forward(request,response);
//            for(Student s:list){
//                System.out.println(s);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
