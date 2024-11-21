package com.example.utils;

import java.time.LocalDateTime;


// 테스트용
public class Test {

    public static void main(String[] args) {
        System.out.println("클래스 연결 성공!");
         LocalDateTime localDateTime = LocalDateTime.now(); // 현재 날짜와 시간을 가져오기
        System.out.println("localDateTime: " + localDateTime);

    }
    public String getMessage(){
        return "클래스연결성공~";
    }
}
