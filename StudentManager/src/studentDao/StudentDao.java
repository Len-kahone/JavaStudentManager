package studentDao;

import student.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 练家鸿
 * @Package studentDao
 * @date 2019/8/5 12:25
 */
public interface StudentDao {
    int PAGE_SIZE=5;
    List<Student> findAll() throws SQLException;
    void addStudent(Student student) throws SQLException;
    void deleteStudent(String id) throws SQLException;
    Student findStudentById(String sid) throws SQLException;
    void updateStudent(Student s) throws SQLException;
    List<Student> searchStudent(String sname,String gender) throws SQLException;
    List<Student> findStudentByPage(int currentPage) throws SQLException;
    int findCount() throws SQLException;
}
