package service.impl;

import service.StudentService;
import student.PageBean;
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

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        return studentDao.searchStudent(sname, gender);
    }

    @Override
    public PageBean findStudentByPage(int currentPage) throws SQLException {
        PageBean<Student> bean = new PageBean<Student>();
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> list = studentDao.findStudentByPage(currentPage);
        int count = studentDao.findCount();
        bean.setCount(count);
        bean.setCurrentPage(currentPage);

        bean.setPageSize( studentDao.PAGE_SIZE);
        bean.setList(list);
        bean.setTotalPage(count%studentDao.PAGE_SIZE==0?count/studentDao.PAGE_SIZE:count/studentDao.PAGE_SIZE+1);

        return bean;
    }
}
