package servlet;

import service.impl.StudentSeriviceImpl;
import student.PageBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author 练家鸿
 * @Package ${PACKAGE_NAME}
 * @date 2019/8/7 15:31
 */
@WebServlet(name = "StudentPageServlet")
public class StudentPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int currentPage = Integer.valueOf(request.getParameter("currentPage"));
            System.out.println(currentPage);
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();
            PageBean bean = studentSerivice.findStudentByPage(currentPage);
            request.setAttribute("bean",bean);
            request.getRequestDispatcher("page.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
