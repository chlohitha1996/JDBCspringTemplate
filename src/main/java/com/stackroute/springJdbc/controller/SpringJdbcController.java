package com.stackroute.springJdbc.controller;

import com.stackroute.springJdbc.domain.Movie;
import com.stackroute.springJdbc.repository.SpringJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpringJdbcController {
    @Autowired
    private SpringJdbcRepository springJdbcRepository;

    public ResponseEntity<String> executeShow() {
        Movie entity = springJdbcRepository.get(2);
        return new ResponseEntity("Movie: " + entity.getMovie_Id()
                + ", " + entity.getMovie_Name(), HttpStatus.OK);
    }

   public ResponseEntity<String> insert() {
        Movie entity = new Movie(2, "Mr Perfectionist",2011, 8);
        springJdbcRepository.add(entity);
        return new ResponseEntity("Movie Add: " + entity.getMovie_Id()
                + ", " + entity.getMovie_Name()
                + ", " + entity.getReleaseYear()
                + ", " + entity.getRating()
                , HttpStatus.OK);
    }

    public ResponseEntity<String> read() {
        Movie entity = springJdbcRepository.get(1);
        return new ResponseEntity("Movie Get: " + entity.getMovie_Id()
                + ", " + entity.getMovie_Name()
                + ", " + entity.getReleaseYear()
                + ", " + entity.getRating()
                ,HttpStatus.OK);
    }

    public ResponseEntity<String> update() {
        Movie entity = new Movie(4,"Bahubali", 2016,8);
        springJdbcRepository.update(entity);


        return new ResponseEntity("Movie Update: " + entity.getMovie_Id()
                + ", " + entity.getMovie_Name()
                + ", " + entity.getReleaseYear()
                + ", " + entity.getRating()
                ,HttpStatus.OK);
    }


    public ResponseEntity<String> delete() {
        Movie entity = new Movie(1,"Darling",2012,10);
        springJdbcRepository.delete(entity);

                 return new ResponseEntity("Movie Delete: " + entity.getMovie_Id()
                + ", " + entity.getMovie_Name()
                + ", " + entity.getReleaseYear()
                + ", " + entity.getRating()
                ,HttpStatus.OK);



    }
    public ResponseEntity<?> getAll() {
        List<Movie> movieList =springJdbcRepository.getAll();
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }
}
