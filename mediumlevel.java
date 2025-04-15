import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {

    // JDBC details
    private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
    private static final String USER = "root";
    private static final String PASSWORD = "password"; // Use your actual MySQL password here.

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Display search form
        out.println("<html><body>");
        out.println("<h2>Search Employee by ID</h2>");
        out.println("<form action='EmployeeServlet' method='POST'>");
        out.println("Employee ID: <input type='text' name='empId' required>");
        out.println("<input type='submit' value='Search'>");
        out.println("</form>");

        // Fetch and display all employees if no search is done
        out.println("<h3>Employee List</h3>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>Name</th><th>Position</th><th>Salary</th></tr>");

        try {
            // Establish JDBC connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String position = resultSet.getString("position");
                double salary = resultSet.getDouble("salary");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
