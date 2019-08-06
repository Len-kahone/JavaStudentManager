package servlet;

import service.impl.StudentSeriviceImpl;

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
 * @date 2019/8/6 9:44
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            StudentSeriviceImpl studentSerivice = new StudentSeriviceImpl();
            String sid = request.getParameter("sid");
            studentSerivice.deleteStudent(sid);
            request.getRequestDispatcher("StudentList").forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
