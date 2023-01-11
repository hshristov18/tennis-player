package com.example.classs;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class PlayerDao implements PlayerDaoo {
    private JdbcTemplate jdbcTemplate;
    private static final class PlayerMapper implements RowMapper<Player> {

        @Override
        public int[] getRowsForPaths(TreePath[] path) {
            return new int[0];
        }
    }
    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person player = new Person();
        player.setId(resultSet.getInt("id"));
        player.setName(resultSet.getString("name"));
        player.setNationality(resultSet.getString("nationality"));
        player.setBirthDate(resultSet.getDate("birth_date"));
        player.setTitles(resultSet.getInt("titles"));
        return player;
    }
    public List<Person> getPlayerByNationality(String nationality){
        String sql = "SELECT * FROM PLAYER WHERE NATIONALITY = ?";
        return jdbcTemplate.query(sql, new PlayerMapper(), new Object[] (nationality));
    }
    @Override
    public void run(String... args) throws Exception{
        logger.info("French Players: {}", dao.getPlayerByNationality("France"));
    }
}