package com.tennis.springboot;

import java.sql.Timestamp;

public class TennisController {
    public int insertPlayer(Player player)
    {
        String sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) "+"VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, new Object[]{ player.getid(), player.getname(), player.getnationality(), new Timestamp(player.getBirthDate().getTime()), player.getTitles()});
    }
    @Override
    public void run(String... args) throws Exception
    {
        logger.info("Inserting Player 4: {}", dao.insertPlayer(new Player (4, "Thiem", "Australia", new Date(System.currentTimeMillis()), 17)));
        logger.info("All Players Data: {}", dao.getAllPlayers());
    }
    public int updatePlayer(Player player)
    {
        String sql = "UPDATE PLAYER "+"SET Name = ?, Nationality = ?, Birth_date = ?, Titles = ? " + "WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[]{ player.getid(), player.getname(), player.getnationality(), new Timestamp(player.getBirthDate().getTime()), player.getTitles(), player.getId()});
    }
    public void run (String... args) throws Exception{
        logger.info("Inserting Player 4: {}", dao.insertPlayer(new Player (4, "Thiem", "Australia", new Date(System.currentTimeMillis()), 17)));
        logger.info("Updating Player with Id 4: {}", dao.insertPlayer(new Player (4, "Thiem", "Australia", Date.valueOf(("1993-09-03"), 17)));
        logger.info("Players with id 4: {}", dao.getPlayerById(4));
    }
    public int deletePlayerById(int id){
        String sql = "DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object[] {id});
    }
    @Override
    public void run(String... args) throws Exception
    {
        logger.info("Deleting Player with Id 2: {}", dao.deletePlayerById(2));
        logger.info("All Players Data: {}", dao.getAllPlayers());
    }
    public void createTournamentTable()
    {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY(ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }
    public void runO(String... args)
    {
        dao.createTournamentTable();
    }
}