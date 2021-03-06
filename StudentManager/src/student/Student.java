package student;

import java.util.Date;

public class Student {
    int sid;
    String sname;
    String gender;
    String phone;
    Date birthday;
    String hobby;
    String info;
    public Student() {
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Student( String sname, String gender, String phone, Date birthday, String hobby, String info) {

        this.sname = sname;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.info = info;
    }

    public Student(int sid, String sname, String gender, String phone, Date birthday, String hobby, String info) {
        this.sid = sid;
        this.sname = sname;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.hobby = hobby;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", birthday=" + birthday +
                ", hobby='" + hobby + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
