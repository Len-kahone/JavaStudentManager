<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>学生列表页面</title>

    <script type="text/javascript">
        function doDelete(e){
            var is=confirm("是否确认删除？")
            if(is){
                location.href="DeleteServlet?sid="+e
            }
        }
        // function EditServlet(sid) {
        //     location.href="UpdateServlet?sid="+sid
        // }

    </script>

</head>
<body>
<form action="SearchStudentServlet" method="post">
    <table border="1" width="700">

        <tr >
            <td colspan="8">

                <form action="">
                    按姓名查询：<input type="text" name="sname">
                    按性别查询：<select name="gender" id="">
                    <option value="">请选择性别--</option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
                    <input type="submit" value="查询">
                </form>
                <a href="addStudent.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${list }" var="stu">
            <tr align="center">
                <td>${stu.sid }</td>
                <td>${stu.sname }</td>
                <td>${stu.gender }</td>
                <td>${stu.phone }</td>
                <td>${stu.birthday }</td>
                <td>${stu.hobby }</td>
                <td>${stu.info }</td>
                <td><a href="UpdateServlet?sid=${stu.sid }">更新</a>   <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>