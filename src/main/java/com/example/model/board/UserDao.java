package com.example.model.board;

import javax.sql.DataSource;

import com.example.model.DataSourceConfig;



/**
 * UserDao 클래스는 데이터베이스와 상호작용하여 사용자 데이터를 처리하는 역할을 합니다.
 */
public class UserDao {

    private final DataSource dataSource; // DataSource 인스턴스 선언

    /**
     * 생성자에서 DataSourceConfig로부터 DataSource를 주입받습니다.
     */
    public UserDao() {
        this.dataSource = DataSourceConfig.getDataSource(); 
        // DataSourceConfig에서 DataSource 가져오기
    }

    //CRUD 작업 수행 
    /* CRUD :
    C (Create): 새로운 데이터를 데이터베이스에 삽입(Insert) 하는 작업입니다.
    R (Read): 데이터베이스에 저장된 데이터를 조회(Select) 하는 작업입니다.
    U (Update): 데이터베이스에 저장된 데이터를 수정(Update) 하는 작업입니다.
    D (Delete): 데이터베이스에 저장된 데이터를 삭제(Delete) 하는 작업입니다
    */ 

}

