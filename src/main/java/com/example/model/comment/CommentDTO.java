package com.example.model.comment;

import java.sql.Date;

public class CommentDTO {
   /*  create table comments (
        post_id    number,               -- 게시물 ID (QA_BOARD와 연관된 키)
        content    varchar2(1000) not null, -- 댓글 내용
        id         varchar2(20),             -- 작성자 ID
        post_date  date not null,     -- 댓글 작성일
        like_count number default 0, -- 좋아요 수 (기본값 0)
        updated_at date,             -- 댓글 수정일
         -- 이 제약 조건은 현재 테이블의 POST_ID 열과 QA_BOARD 테이블의 POST_ID 열 간의 
         -- 외래 키 관계를 정의합니다.
         -- QA_BOARD 테이블의 행이 삭제되면 ON DELETE CASCADE 동작으로 인해 
         -- 현재 테이블의 해당 행도 삭제됩니다.
        constraint fk_comments_qa_board foreign key ( post_id )
           references qa_board ( post_id )
              on delete cascade
     );*/

    private int post_id; // 게시물 ID
    private String content; // 댓글 내용
    private String id; // 작성자 ID
    private Date post_date; // 댓글 작성일
    private int like_count; // 좋아요 수
    private Date updated_at; // 댓글 수정일

    // Getter, Setter
    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
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
