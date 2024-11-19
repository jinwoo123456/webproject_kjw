package com.example.model;

import java.sql.Date;

/*
테이블 
ID	VARCHAR2(20 BYTE)	
PASSWORD	VARCHAR2(30 BYTE)	N
EMAIL	VARCHAR2(25 BYTE)	
NAME	VARCHAR2(25 BYTE)	
PHONE_NUMBER	NUMBER(20,0)	
HIRE_DATE	DATE	
*/
public class MemberDTO {
private String id;
private String pw;
private String email;
private String name;
private int pnum;
private Date hdate;

// public MemberDTO() {
//     this.hdate = new Date(System.currentTimeMillis());
// }



public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getPw() {
    return pw;
}

public void setPw(String pw) {
    this.pw = pw;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public int getPnum() {
    return pnum;
}

public void setPnum(int pnum) {
    this.pnum = pnum;
}

public Date getHdate() {
    return hdate;
}

public void setHdate(Date hdate) {
    this.hdate = hdate;
}



}
