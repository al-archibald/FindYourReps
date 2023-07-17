package com.findyourreps.dao;

import com.findyourreps.model.Representative;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcRepDao implements RepDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRepDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override // display all representatives
    public List<Representative> findAll() {
        List<Representative> reps = new ArrayList<>();
        String sql = "SELECT * FROM reps";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Representative representative = mapRowToRepresentative(results);
            reps.add(representative);
        }
        return reps;
    }

    @Override // search and display reps based on search query
    public List<Representative> searchName(String searchQuery) {
        List<Representative> reps = new ArrayList<>();
        String sql = "SELECT * FROM reps WHERE TRIM(name) ILIKE ?";
            // TRIM removes leading and trailing spaces; ILIKE makes search case-insensitive
        String searchParam = "%" + searchQuery + "%";

        sql += " Order BY name ASC LIMIT 5";
            // sort by name in ascending order and limit to 5 results

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchParam);
        while (results.next()) {
            Representative representative = mapRowToRepresentative(results);
            reps.add(representative);
        }
        return reps;
    }

//    @Override
//    public List<Representative> searchParty(String searchQuery) {
//        List<Representative> reps = new ArrayList<>();
//        String sql = "SELECT name, phone, email FROM reps WHERE TRIM(party) ILIKE ?";
//        String searchParam = "%" + searchQuery + "%";
//
//        sql += " Order BY name ASC LIMIT 5";
//        // sort by name in ascending order and limit to 5 results
//
//        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, searchParam);
//        while (results.next()) {
//            Representative representative = mapRowToRepresentative(results);
//            reps.add(representative);
//        }
//        return reps;
//    }

    private Representative mapRowToRepresentative(SqlRowSet rs) {
        Representative representative = new Representative();
        representative.setId(rs.getInt("id"));
        representative.setName(rs.getString("name"));
        representative.setPhone(rs.getString("phone"));
        representative.setParty(rs.getString("party"));
        representative.setEmail(rs.getString("email"));
        return representative;
    }

}
