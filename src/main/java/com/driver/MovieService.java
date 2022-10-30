package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    //add movie
    List<Movie> getAllMovies(){

        return movieRepository.getallMoviesintList();
    }


    void addMovie(Movie movie){

        movieRepository.addMovies(movie);
    }

   //add director
    public void addDirector(Director director) {

        movieRepository.addDiretor(director);
    }


    List<Director> getAllDirector(){
        return movieRepository.getallDirectorList();
    }

    public void addPairhm(String directorname,String moviename) {

        movieRepository.addpairhm(directorname,moviename);
    }
    public HashMap<String,List<String>> getallpair(){
        return movieRepository.getallPairMovie();
    }
public List<String> getallMovielistbydirector(String directorname){

      return movieRepository.getalldirectornamebymovie(directorname);
}
public void deleteddirectoronlist(String directorname){

        movieRepository.deleteddirector(directorname);
}

public void deletealldirectorrecodeList(){

        movieRepository.deletetalldirectorrecord();
}

}
