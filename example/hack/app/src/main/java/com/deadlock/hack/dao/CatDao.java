package com.deadlock.hack.dao;

import com.deadlock.hack.model.Cat;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class CatDao {

    private final JdbcTemplate jdbcTemplate;

    public CatDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<Cat> findById(final int catId) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject("select * from cat where id=?",
                                                                   new Object[]{catId},
                                                                   new CatRowMapper()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }

    }

    public List<Cat> findAll() {
        return jdbcTemplate.query("select * from cat", new CatRowMapper());
    }

    private static class CatRowMapper implements RowMapper<Cat> {
        private static final String ID = "id";
        private static final String NAME = "name";
        private static final String URL = "url";

        @Override
        public Cat mapRow(final ResultSet resultSet, final int i) throws SQLException {
            final int id = resultSet.getInt(ID);
            final String name = resultSet.getString(NAME);
            final String url = resultSet.getString(URL);
            return new Cat(id, name, url);
        }
    }
}
