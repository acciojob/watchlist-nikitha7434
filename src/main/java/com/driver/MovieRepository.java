package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

   HashMap<String,Movie> hmMovies=new HashMap<>();
   HashMap<String,Director> hmdirector=new HashMap<>();
   HashMap<String,List<String>> hmpair = new HashMap<>();

    public  void  addMovies(Movie movie){

    hmMovies.put(movie.getName(),movie);

        //listmovies.add(movie);

    }

    public void addDiretor(Director director){

        hmdirector.put(director.name, director);

    }

  public void addpairhm(String director_name, String movie_name){

       if(hmpair.containsKey(director_name)){

           hmpair.get(director_name).add(movie_name);
       }
       else{
           hmpair.put(director_name,new ArrayList<>(Collections.singleton(movie_name)));
       }
 }

    public List<Movie> getallMoviesintList(){

        List<Movie> movieList =new ArrayList<>();

        for(Movie movies : hmMovies.values()){
            movieList.add(movies);
        }
        return movieList;

    }

    public List<Director> getallDirectorList(){
        List<Director> directorList =new ArrayList<>();

        for(Director director : hmdirector.values()){
            directorList.add(director);
        }
        return directorList;
    }

public HashMap<String, List<String>> getallPairMovie() {

    return hmpair;
}
public List<String> getalldirectornamebymovie(String directorname){

        return hmpair.get(directorname);
}
// deleteted

    public void deleteddirector(String directorname){

        for(String name:hmdirector.keySet()){

           if(name.equals(directorname)){
            if(hmpair.containsKey(name)) {
                List<String> list = hmpair.get(name);
                for (String moviename : list) {
                    if (hmMovies.containsKey(moviename)) {
                        hmMovies.remove(moviename);
                    }
                }
            }


            }
        }
        hmdirector.remove(directorname);

        hmpair.remove(directorname);
    }

    public void deletetalldirectorrecord(){

        for(String name : hmdirector.keySet()){

            if(hmpair.containsKey(name)){

                List<String> list =hmpair.get(name);

                for(String moviename:list){
                    if(hmMovies.containsKey(moviename)){
                        hmMovies.remove(moviename);
                    }
                }

                hmpair.remove(name);

            }
            hmdirector.remove(name);
        }
    }


}
