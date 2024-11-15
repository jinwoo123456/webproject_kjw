package com.example.model;
import java.sql.Connection;
import java.sql.SQLException;

public class DBtest {
    

    public static void main(String[] args) {
        try (Connection conn = DataSourceConfig.getDataSource().getConnection()) {
            System.out.println("Connection successful: " + (conn != null));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


