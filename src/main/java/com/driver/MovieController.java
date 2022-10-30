package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;
//1
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody() Movie movies) {

        try {
            movieService.addMovie(movies);
            return new ResponseEntity<>("success", HttpStatus.CREATED);
        }catch (Exception e){

            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

//2
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody() Director director){

           try{
               movieService.addDirector(director);
               return new ResponseEntity<>("Success",HttpStatus.CREATED);
           }
           catch (Exception e){
               return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
           }
    }

// 3   Pair an existing movie and director: PUT /movies/add-movie-director-pair
//    Pass movie name and director name as request parameters
//    Return success message wrapped in a ResponseEntity object
//    Controller Name - addMovieDirectorPair

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam("movie_name")String movie_name,

                                                @RequestParam("director_name")String director_name){


//      for (Movie movie:movieService.getAllMovies()){

//          if(movie.getName().equals(movie_name)){

              movieService.addPairhm(director_name,movie_name);
              return  new ResponseEntity<>("successful",HttpStatus.ACCEPTED);
//          }
//      }

//        return  new ResponseEntity<>("not_Exisiting",HttpStatus.NOT_ACCEPTABLE);
    }
//4


    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable("name")String name){
        List<Movie> li =movieService.getAllMovies();
         for(Movie movie:li){
             if(movie.getName().equals(name)){
             return new ResponseEntity<>(movie,HttpStatus.OK);
             }
         }
         return new ResponseEntity("Not_get",HttpStatus.NOT_FOUND);
    }

    //5
@GetMapping("/get-director-by-name/{name}")
public ResponseEntity  getDirectorByName(@PathVariable("name")String name){

        for(Director director:movieService.getAllDirector()){
            if(director.getName().equals(name)){
                return new ResponseEntity(director,HttpStatus.OK);
            }
        }
        return new ResponseEntity("not_found",HttpStatus.NOT_FOUND);
}

//6
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable("director_name")String director_name){
     //   List<String> list =movieService.getallMovielistbydirector(director_name);




        return new ResponseEntity(movieService.getallMovielistbydirector(director_name),HttpStatus.OK);
    }
//7

    @GetMapping("/get-all-movies")
    public ResponseEntity findAllMovies(){
        return new ResponseEntity(movieService.getAllMovies(),HttpStatus.OK);
    }
//   8

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam("name")String name){

        movieService.deleteddirectoronlist(name);

        return new ResponseEntity("successful",HttpStatus.OK);
    }
//    9
    @DeleteMapping("delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
             movieService.deletealldirectorrecodeList();
        return new ResponseEntity<>("successful",HttpStatus.OK);
    }

}
