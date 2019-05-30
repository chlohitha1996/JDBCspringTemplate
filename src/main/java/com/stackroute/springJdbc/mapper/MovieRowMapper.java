package com.stackroute.springJdbc.mapper;

import com.stackroute.springJdbc.domain.Movie;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieRowMapper implements RowMapper<Movie> {

    @Override
    public Movie mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final Movie movie = new Movie();
        movie.setMovie_Id(rs.getInt("Movie_Id"));
        movie.setMovie_Name(rs.getString("Movie_Name"));
        movie.setReleaseYear(rs.getInt("ReleaseYear"));
        movie.setRating(rs.getFloat("Rating"));
        return movie;
    }
}
