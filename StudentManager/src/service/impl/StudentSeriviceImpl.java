package service.impl;

import service.StudentService;
import student.Student;
import studentDaoImpl.StudentDaoImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 练家鸿
 * @Package service.impl
 * @date 2019/8/5 12:44
 */
public class StudentSeriviceImpl implements StudentService {
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDaoImpl student = new StudentDaoImpl();
        List<Student> list = student.findAll();
        return list;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        StudentDaoImpl s = new StudentDaoImpl();
        s.addStudent(student);
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        StudentDaoImpl s = new StudentDaoImpl();
        s.deleteStudent(id);
    }

    @Override
    public Student findStudentById(String sid) throws SQLException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        Student s = studentDao.findStudentById(sid);

        return s;
    }

    @Override
    public void updateStudent(Student s) throws SQLException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        studentDao.updateStudent(s);
    }
}
