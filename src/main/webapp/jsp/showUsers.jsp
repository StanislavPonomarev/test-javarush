<%@include file="taglib_includes.jsp" %>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title><spring:message code="App.Title"></spring:message> </title>

<script type="text/javascript" src="js/users.js"></script>
</head>
<body style="font-family: Arial; font-size:smaller;">

<h2>USERS DATABASE (CRUD testing work to JavaRush)</h2>

        <form action="searchUsers.do" method="post">
                        <table style="border-collapse: collapse;" border="0" bordercolor="#006699" width="50%">
                        <tr>
                                <td><input type="button" value="New user" onclick="javascript:go('saveUser.do');"/> </td>
                                <td>Enter user`s name to search  <input type="text" name="name"/>
                                        &nbsp;&nbsp;<input type="submit" value="Search"/>
                                        &nbsp;&nbsp;<input type="button"  value="Home" onclick="javascript:go('viewAllUsers.do?pageNum=1');">
                        </td></tr>
                </table>
        </form>



        <table style="border-collapse: collapse;" border="1" bordercolor="grey" width="100%">
                <tr bgcolor="lightgrey">
                        <th align = "center">Id</th>
                        <th align = "center">Name</th>
                        <th align = "center">Age</th>
                        <th align = "center">isAdmin</th>
                       <th align = "center">createdDate</th>
                        <th align = "center">Actions</th>
                </tr>
                <c:if test="${empty SEARCH_USERS_RESULTS_KEY}">
                <tr>
                        <td colspan="4">No users found</td>
                </tr>
                </c:if>
                <c:if test="${! empty SEARCH_USERS_RESULTS_KEY}">
                        <c:forEach var="user" items="${SEARCH_USERS_RESULTS_KEY}">
                    <tr>
                                <td align = "center"><c:out value="${user.id}"></c:out></td>
                                <td align = "center"><c:out value="${user.name}"></c:out></td>
                                <td align = "center"><c:out value="${user.age}"></c:out> </td>
                                <td align = "center"><c:out value="${user.isAdmin}"></c:out></td>
                                <td align = "center"><c:out value="${user.createdDate}"></c:out></td>
                                <td align = "center">
                                        &nbsp;<a href="updateUser.do?id=${user.id}">Edit user</a>
                                        &nbsp;&nbsp;<a href="javascript:deleteUser('deleteUser.do?id=${user.id}');">Delete user</a>
                                </td>
                        </tr>

                        </c:forEach>
                </c:if>




        </table>


        </center>


   </br>
        <c:forEach begin="${pageNum - 5 > 0?pageNum - 5:1}" end="${USERS_PAGE_COUNT}" var="p">
            <a style ="font-size:10px" href="viewAllUsers.do?pageNum=${p}">${p}</a>
        </c:forEach>

</body>
</html>