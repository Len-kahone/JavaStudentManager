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

<table border="1" width="700">

    <tr >
        <td colspan="8">

            <form action="SearchServlet" method="post">
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

    <c:forEach items="${bean.list }" var="stu">
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
    <tr >
        <td colspan="8">
            第${bean.currentPage}/${bean.totalPage}
            每页显示${bean.pageSize}条
            总记录数${bean.count}
            <a href="StudentPageServlet?currentPage=1">首页</a>
           <c:if test="${bean.currentPage!=1}">
               <a href="StudentPageServlet?currentPage=${bean.currentPage-1}">上一页</a>
           </c:if>
            <c:forEach begin="1" end="${bean.totalPage}" var="no" >
                <c:if test="${bean.currentPage==no}">
                    ${no}
                </c:if>
                <c:if test="${bean.currentPage!=no}">
                    <a href="StudentPageServlet?currentPage=${no}"> ${no}</a>
                </c:if>
            </c:forEach>
            <a href="StudentPageServlet?currentPage=${bean.totalPage}">末页</a>
            <c:if test="${bean.currentPage!=bean.totalPage}">
                <a href="StudentPageServlet?currentPage=${bean.currentPage+1}">下一页</a>
            </c:if>
<%--            <c:forEach items="${bean.totalPage}" var="no">--%>
<%--                ${no}--%>
<%--            </c:forEach>--%>
        </td>
    </tr>
</table>

</body>
</html>