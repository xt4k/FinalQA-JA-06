package com.academy.lesson13;

import java.sql.*;

public class JDBCDemo {
    private static String JDBC_URL="jdbc:mysql://localhost:3306/qa-ja-06?user=root&password=root&serverTimezone=UTC&useSSL=false";

    public static void main(String[] args) {
        System.out.println("JDBC");
        try {
            // Инициализация драйвера
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL);
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO abonent(first_name, last_name, gender, age) VALUES(?, ?, ?, ?)");
            preparedStatement.setString(1, "Наталья");
            preparedStatement.setString(2, "Ильинская");
            preparedStatement.setString(3, "f");
            preparedStatement.setInt(4, 27);
            preparedStatement.execute();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM abonent");

            while(resultSet.next()) {
                long id = resultSet.getLong("abonent_id");
                String firstName = resultSet.getString("first_name");
                System.out.println(String.format("ID = %d, First Name = %s",
                        id, firstName));
            }


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
