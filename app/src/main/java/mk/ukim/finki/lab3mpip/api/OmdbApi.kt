package mk.ukim.finki.lab3mpip.api

import mk.ukim.finki.lab3mpip.model.Movie
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OmdbApi {
//    "t={title}&apikey=c8080bfa
    @GET("/")
    fun getMovieByTitle(@Query("t") title: String, @Query("apikey") apikey:String): Call<Movie>



}