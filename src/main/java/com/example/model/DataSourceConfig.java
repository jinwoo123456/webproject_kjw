package com.example.model; // 패키지 선언

import java.io.IOException; // IOException 클래스 임포트
import java.io.InputStream; // InputStream 클래스 임포트
import java.util.Properties; // Properties 클래스 임포트

import javax.sql.DataSource; // DataSource 인터페이스 임포트

import com.zaxxer.hikari.HikariConfig; // HikariCP 설정 클래스 임포트
import com.zaxxer.hikari.HikariDataSource; // HikariCP 데이터 소스 클래스 임포트

/**
 * DataSourceConfig 클래스는 HikariCP DataSource를 구성하고 제공하는 역할을 합니다.
 * 데이터베이스 연결 속성을 properties 파일에서 읽어와서 DataSource를 초기화합니다.
 * 
 * <p>구성 속성은 클래스패스에 위치한 "db.properties" 파일에서 찾을 수 있습니다.
 * properties 파일은 다음과 같은 키를 포함해야 합니다:
 * <ul>
 *   <li>jdbc.url - 데이터베이스 연결을 위한 JDBC URL.</li>
 *   <li>jdbc.username - 데이터베이스 연결을 위한 사용자 이름.</li>
 *   <li>jdbc.password - 데이터베이스 연결을 위한 비밀번호.</li>
 *   <li>jdbc.driverClassName - JDBC 드라이버 클래스의 완전한 이름.</li>
 *   <li>maximumPoolSize - 최대 풀 크기.</li>
 * </ul>
 */
public class DataSourceConfig { // DataSourceConfig 클래스 선언

    private static HikariDataSource dataSource; // HikariDataSource 인스턴스 선언

    static { // 정적 초기화 블록
        try (InputStream input = DataSourceConfig.class.getClassLoader().getResourceAsStream("db.properties")) { // db.properties 파일을 읽기 위한 InputStream 생성
            Properties properties = new Properties(); // Properties 객체 생성
            properties.load(input); // properties 파일 로드

            HikariConfig config = new HikariConfig(); // HikariConfig 객체 생성
            config.setJdbcUrl(properties.getProperty("jdbc.url")); // JDBC URL 설정
            config.setUsername(properties.getProperty("jdbc.username")); // 사용자 이름 설정
            config.setPassword(properties.getProperty("jdbc.password")); // 비밀번호 설정
            config.setDriverClassName(properties.getProperty("jdbc.driverClassName")); // JDBC 드라이버 클래스 설정
            config.setMaximumPoolSize(Integer.parseInt(properties.getProperty("maximumPoolSize"))); // 최대 풀 크기 설정
            /*오류 날 시 풀 크기 확인해볼것. */ 
            dataSource = new HikariDataSource(config); // HikariDataSource 인스턴스 생성
        } catch (IOException e) { // IOException 예외 처리
            e.printStackTrace(); // 예외 스택 트레이스 출력
            System.out.println("db연결 오류 발생dtsrcf " + e.getMessage()); // 예외 메시지 출력
        }
    }

    public static DataSource getDataSource() { // DataSource 반환 메서드
        return dataSource; // dataSource 반환
    }
}
