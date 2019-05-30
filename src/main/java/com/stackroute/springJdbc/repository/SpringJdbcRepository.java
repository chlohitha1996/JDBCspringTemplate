package com.stackroute.springJdbc.repository;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.mapper.MovieRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class SpringJdbcRepository {
    private JdbcTemplate jdbcTemplate;

    public SpringJdbcRepository() {
    }


    //    @Autowired
//    public void SpringJdbcRepository(final DataSource dataSource) {
//        this.jdbcTemplate.setDataSource(dataSource);
//    }
    @Autowired
    public void setDataSource(final DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Movie> getAll() {
        return jdbcTemplate.query("SELECT * FROM Movie", new MovieRowMapper());
    }

   public int add(final int Movie_Id, final String Movie_Name,final  int ReleaseYear, final float Rating) {
        return jdbcTemplate.update("INSERT INTO Movie VALUES (?, ?,?,?)", Movie_Id, Movie_Name, ReleaseYear,Rating);
   }

    public int add(Movie movie) {
        return jdbcTemplate.update("INSERT INTO Movie VALUES (?, ?,?,?)", movie.getMovie_Id(), movie.getMovie_Name(),
                                              movie.getReleaseYear(),movie.getRating());
    }



    public Movie get(final int Movie_Id) {
        final String query = "SELECT * FROM STUDENT WHERE Movie_Id = ?";
        return jdbcTemplate.queryForObject(query, new Object[] { Movie_Id }, new MovieRowMapper());
    }

    public int update(Movie entity) {
        return jdbcTemplate.update("UPDATE Movie SET Rating=? WHERE Movie_Id=?", entity.getRating(), entity.getMovie_Id());
    }


    public int delete(Movie entity) {
        return jdbcTemplate.update("DELETE FROM Movie WHERE Movie_Id=?", entity.getMovie_Id());
    }

}
