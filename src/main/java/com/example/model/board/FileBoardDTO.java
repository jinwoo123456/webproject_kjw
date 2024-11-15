package com.example.model.board;
/*
열 종류
POST_ID	NUMBER
TITLE	VARCHAR2(200 BYTE)
CONTENT	VARCHAR2(2000 BYTE)
ID	VARCHAR2(20 BYTE)
POST_DATE	DATE
VISIT_COUNT	NUMBER
LIKE_COUNT	NUMBER
UPDATED_AT	DATE
CATE	VARCHAR2(50 BYTE)
OFILE	VARCHAR2(100 BYTE)
SFILE	VARCHAR2(30 BYTE)
*/
public class FileBoardDTO {

 private int post_id; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private String id; // 작성자
    private String post_date; // 작성일
    private int visit_count;  // 조회수
    private int like_count; // 좋아요 수
    private String updated_at; // 수정일
    private String cate; // 카테고리
    private String ofile; // 원본파일
    private String sfile; // 저장파일



    //게터세터
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public int getVisit_count() {
        return visit_count;
    }

    public void setVisit_count(int visit_count) {
        this.visit_count = visit_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCate() {
        return cate;
    }

    public void setCate(String cate) {
        this.cate = cate;
    }

    public String getOfile() {
        return ofile;
    }

    public void setOfile(String ofile) {
        this.ofile = ofile;
    }

    public String getSfile() {
        return sfile;
    }

    public void setSfile(String sfile) {
        this.sfile = sfile;
    }
}
