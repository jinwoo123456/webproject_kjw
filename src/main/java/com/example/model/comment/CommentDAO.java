package com.example.model.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.model.JDBConnect;

import jakarta.servlet.ServletContext;

public class CommentDAO extends JDBConnect {

    public CommentDAO(String drv, String url, String id, String pw) {
        super(drv, url, id, pw);
    }

    public CommentDAO(ServletContext application) {
        super(application);
    }

    // 댓글 추가 메서드
    public void writeComment(int postId, String userId, String content) throws SQLException {
        String query = "INSERT INTO comments (comment_id, post_id, user_id, content, post_date) VALUES (seq_comment_id.NEXTVAL, ?, ?, ?, SYSDATE)";
        try {
            psmt = con.prepareStatement(query); // PreparedStatement 객체 생성
            psmt.setInt(1, postId); // 첫 번째 매개변수에 postId 설정
            psmt.setString(2, userId); // 두 번째 매개변수에 userId 설정
            psmt.setString(3, content); // 세 번째 매개변수에 content 설정
            psmt.executeUpdate(); // 쿼리 실행
            System.out.println("===========================commentDAO - writeComment===========================");
            System.out.println("Comment added successfully: postId=" + postId + ", userId=" + userId + ", content=" + content);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 댓글 목록 가져오기 메서드
    public List<CommentDTO> getCommentsByPostId(int postId) throws SQLException {
        List<CommentDTO> commentList = new ArrayList<>();
        String sql = "SELECT * FROM comments WHERE post_id = ? ORDER BY post_date DESC";
        try {
            psmt = con.prepareStatement(sql);
            psmt.setInt(1, postId);
            rs = psmt.executeQuery();
            while (rs.next()) {
                CommentDTO comment = new CommentDTO();
                comment.setCommentId(rs.getInt("comment_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setUserId(rs.getString("user_id"));
                comment.setContent(rs.getString("content"));
                comment.setPostDate(rs.getDate("post_date"));
                commentList.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commentList;
    }
}