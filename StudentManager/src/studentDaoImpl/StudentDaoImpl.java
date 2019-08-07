package studentDaoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import student.Student;
import studentDao.StudentDao;
import util.JDBCUtil;
import util.TextUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 练家鸿
 * @Package studentDaoImpl
 * @date 2019/8/5 12:28
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner q = new QueryRunner(JDBCUtil.getSource());
        List<Student> list = q.query("select * from stu", new BeanListHandler<Student>(Student.class));
        return list;
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        int update = query.update("insert into stu values(null,?,?,?,?,?,?)",
                student.getSname(),
                student.getGender(),
                student.getPhone(),
                student.getBirthday(),
                student.getHobby(),
                student.getInfo()
        );
    }

    @Override
    public void deleteStudent(String id) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        query.update("delete from stu where sid=?", id);
    }

    @Override
    public Student findStudentById(String sid) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        Student s = query.query("select * from stu where sid=?", new BeanHandler<Student>(Student.class), sid);
        return s;
    }

    @Override
    public void updateStudent(Student s) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        query.update("update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid=?",
                s.getSname(),
                s.getGender(),
                s.getPhone(),
                s.getBirthday(),
                s.getHobby(),
                s.getInfo(),
                s.getSid()
        );
    }

    @Override
    public List<Student> searchStudent(String sname, String gender) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        String sql = "select * from stu where 1=1";
        ArrayList<String> l=new ArrayList<String>();
        if(!TextUtil.isEmpty(sname)){
            sql=sql+" "+"and sname like ? ";
            l.add("%"+sname+"%");
        }
        if(!TextUtil.isEmpty(gender)){
            sql=sql+" and gender=?";
            l.add(gender);
        }


        List<Student> list = query.query(sql, new BeanListHandler<Student>(Student.class),l.toArray());
        return list;

    }

    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
        return  query.query("select * from stu limit ? offset ?",new BeanListHandler<Student>(Student.class),
                PAGE_SIZE,currentPage);

    }

    @Override
    public int findCount() throws SQLException {

        QueryRunner query = new QueryRunner(JDBCUtil.getSource());
       Long  count= (Long) query.query("SELECT COUNT(*) FROM stu",new ScalarHandler());
         return count.intValue();

    }
}

