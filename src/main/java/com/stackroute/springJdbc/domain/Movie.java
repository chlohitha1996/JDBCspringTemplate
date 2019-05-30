package com.stackroute.springJdbc.domain;

public class Movie {


    private int Movie_Id;
    private String Movie_Name;
    private int ReleaseYear;
    private float Rating;

    public Movie() {

    }


    public int getMovie_Id() {
        return Movie_Id;
    }

    public void setMovie_Id(int movie_Id) {
        Movie_Id = movie_Id;
    }

    public String getMovie_Name() {
        return Movie_Name;
    }

    public void setMovie_Name(String movie_Name) {
        Movie_Name = movie_Name;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        ReleaseYear = releaseYear;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }


    public Movie(int movie_Id, String movie_Name, int releaseYear, float rating) {
        Movie_Id = movie_Id;
        Movie_Name = movie_Name;
        ReleaseYear = releaseYear;
        Rating = rating;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "Movie_ID=" + Movie_Id +
                ", Movie_Name='" + Movie_Name + '\'' +
                ", ReleaseYear=" + ReleaseYear +
                ", Rating=" + Rating +
                '}';
    }


}
