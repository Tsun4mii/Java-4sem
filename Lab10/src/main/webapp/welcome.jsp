<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Title</title>
    <link rel="stylesheet" href="styles/table-style.css">
    <link rel="stylesheet" href="styles/form-style.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<c:if test="${subjects == null}">
    <c:redirect url="/SubjectsServlet"/>
</c:if>

<table class="responsive-table">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Teacher</th>
        <th>Faculty</th>
    </tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.id}</td>
            <td>${subject.name}</td>
            <td>${subject.teacher}</td>
            <td>${subject.faculty}</td>
        </tr>
    </c:forEach>
</table>

<div style="display: flex; background-color: white">
    <fieldset>
        <h3 style="color: red">${DeleteErrorMessage}</h3>
        <legend>Delete</legend>
        <form action="DeleteSubjectServlet" method="POST">
            <input name="id" type="text" placeholder="Subject ID to delete"/> <br/>
            <input type="submit" value="Delete"/>
        </form>
    </fieldset>

    <fieldset>
        <h3 style="color: red">${AddErrorMessage}</h3>
        <legend>Add</legend>
        <form action="AddSubjectServlet" method="POST">
            <input name="name" type="text" placeholder="Subject name"/> <br/>
            <input name="teacher" type="text" placeholder="Teacher"/> <br/>
            <input name="faculty" type="text" placeholder="Faculty"/> <br/>
            <input type="submit" value="Add"/>
        </form>
    </fieldset>

    <fieldset>
        <h3 style="color: red">${UpdateErrorMessage}</h3>
        <legend>Update</legend>
        <form action="UpdateSubjectServlet" method="POST">
            <input name="id" type="text" placeholder="Subject ID to update"/> <br/>
            <input name="name" type="text" placeholder="New subject name"/> <br/>
            <input name="teacher" type="text" placeholder="New teacher"/> <br/>
            <input name="faculty" type="text" placeholder="New faculty"/> <br/>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
