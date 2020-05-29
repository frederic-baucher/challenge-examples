package com.deadlock.hack.dao;

import com.deadlock.hack.model.Comment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDao {

    private final JdbcTemplate jdbcTemplate;

    public CommentDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Comment> findByCat(final int catId) {
        return jdbcTemplate.query("SELECT * FROM comment WHERE cat_id = ?", new Object[]{catId}, new CommentRowMapper());
    }

    public void insertComment(final int catId, final String comment) {
        jdbcTemplate.update("INSERT INTO comment (cat_id, who, content) VALUES (?, ?, '" + comment + "')", catId, "Me");
    }

    private static class CommentRowMapper implements RowMapper<Comment> {
        private static final String ID = "id";
        private static final String CONTENT = "content";
        private static final String CAT_ID = "cat_id";
        private static final String WHO = "WHO";

        @Override
        public Comment mapRow(final ResultSet resultSet, final int i) throws SQLException {
            final int id = resultSet.getInt(ID);
            final String content = resultSet.getString(CONTENT);
            final int cat_id = resultSet.getInt(CAT_ID);
            final String who = resultSet.getString(WHO);
            return new Comment(id, content, cat_id, who);
        }
    }
}
