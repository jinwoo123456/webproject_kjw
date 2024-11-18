package com.example.model;

public class DataSourceConfig {

    // private static HikariDataSource dataSource;

    // static {
    //     try (InputStream input = DataSourceConfig.class.getClassLoader().getResourceAsStream("db.properties")) {
    //         Properties properties = new Properties();
    //         properties.load(input);

    //         HikariConfig config = new HikariConfig();
    //         config.setJdbcUrl(properties.getProperty("jdbc.url"));
    //         config.setUsername(properties.getProperty("jdbc.username"));
    //         config.setPassword(properties.getProperty("jdbc.password"));
    //         config.setDriverClassName(properties.getProperty("jdbc.driverClassName"));

    //         dataSource = new HikariDataSource(config);
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         System.out.println("DB 연결 오류 발생: " + e.getMessage());
    //     }
    // }

    // public static DataSource getDataSource() {
    //     return dataSource;
    // }
}