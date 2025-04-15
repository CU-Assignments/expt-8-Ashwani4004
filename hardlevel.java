<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Attendance Portal</title>
</head>
<body>
    <h2>Enter Attendance Details</h2>
    <form action="SaveAttendanceServlet" method="post">
        Student ID: <input type="text" name="student_id" required><br><br>
        Student Name: <input type="text" name="student_name" required><br><br>
        Date: <input type="date" name="attendance_date" required><br><br>
        Status:
        <select name="status" required>
            <option value="Present">Present</option>
            <option value="Absent">Absent</option>
        </select><br><br>
        <input type="submit" value="Save Attendance">
    </form>
    
    <h3>Attendance List</h3>
    <table border="1">
        <tr>
            <th>Student ID</th>
            <th>Student Name</th>
            <th>Date</th>
            <th>Status</th>
        </tr>
        <c:forEach var="attendance" items="${attendanceList}">
            <tr>
                <td>${attendance.student_id}</td>
                <td>${attendance.student_name}</td>
                <td>${attendance.attendance_date}</td>
                <td>${attendance.status}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
