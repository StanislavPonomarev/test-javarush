<%@include file="taglib_includes.jsp" %>


<html>
<head>
        <script type="text/javascript" src="js/users.js"></script>
        <title><spring:message code="App.Title"></spring:message> </title>
</head>
<body style="font-family: Arial; font-size:smaller;">

<table   width="100%" height="auto" align="center" style="border-collapse: collapse;" border="1" bordercolor="grey" >
        <tr bgcolor="lightgrey">
                <td ><b>Add new User</b></td>
        </tr>
        <tr valign="top" >
    <td >
                 <form:form action="saveUser.do" method="post" commandName="newUser">

                                <table width="500" style="border-collapse: collapse;" border="0" bordercolor="#006699" cellspacing="2" cellpadding="2">
                                        <tr>
                                                <td width="100" align="right">Name</td>
                                                <td width="150">
                                                <form:input path="name"/></td>
                                                <td align="left">
                                                <form:errors path="name" cssStyle="color:red"></form:errors>
                                                </td>
                                        </tr>

                                        <tr>
                                                <td width="100" align="right">Age</td>
                                                <td><form:input path="age"/></td>
                                                <td align="left"><form:errors path="age" cssStyle="color:red"></form:errors>  </td>
                                        </tr>
                                        <tr>
                                                <td width="100" align="right">isAdmin</td>
                                                <td>
                                                        <form:select path="isAdmin">
                                                    <form:option value="true" label="true"/>
                                                    <form:option value="false" label="false"/>
                                                </form:select>
                                                </td>
                                                <td>
                                                </td>
                                        </tr>


                                        <tr>
                                                <td colspan="3" align="center">
                                                <input type="submit" name="" value="Save">
                                                &nbsp;&nbsp;
                                                <input type="reset" name="" value="Reset">
                                                &nbsp;&nbsp;
                                                <input type="button"  value="Home" onclick="javascript:go('viewAllUsers.do?pageNum=1');">
                                                </td>
                                        </tr>
                                </table>
                </form:form>
    </td>
  </tr>
</table>
</body>
</html>
