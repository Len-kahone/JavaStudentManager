package service;

import student.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 练家鸿
 * @Package service
 * @date 2019/8/5 12:43
 */
public interface StudentService {

    List<Student> findAll() throws SQLException;
    void addStudent(Student student) throws SQLException;
    void deleteStudent(String id) throws SQLException;
    Student findStudentById(String sid) throws SQLException;
    void updateStudent(Student s) throws SQLException;
}
