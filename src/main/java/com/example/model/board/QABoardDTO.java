package com.example.model.board;

import java.sql.Date;

/*
열종류
POST_ID	NUMBER
TITLE	VARCHAR2(200 BYTE)
CONTENT	VARCHAR2(2000 BYTE)
ID	VARCHAR2(20 BYTE)
POST_DATE	DATE
VISIT_COUNT	NUMBER
LIKE_COUNT	NUMBER
UPDATED_AT	DATE
*/

// Q&A게시판
public class QABoardDTO {
  private int post_id; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private String id; // 작성자
    private Date post_date; // 작성일
    private int visit_count;  // 조회수
    private int like_count; // 좋아요 수
    private Date updated_at; // 수정일

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

    public Date getPost_date() {
        return post_date;
    }

    public void setPost_date(Date post_date) {
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

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

}
