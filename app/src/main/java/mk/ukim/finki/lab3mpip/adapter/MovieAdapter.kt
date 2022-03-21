package mk.ukim.finki.lab3mpip.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.lab3mpip.R
import mk.ukim.finki.lab3mpip.model.Movie

class MovieAdapter(var movies:MutableList<Movie>) :RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView
        val director: TextView
        val actors: TextView
        val imageUrl: ImageView


        init {
            title = view.findViewById(R.id.movieTitle)
           director = view.findViewById(R.id.movieDirector)
           actors = view.findViewById(R.id.movieActors)
            imageUrl = view.findViewById(R.id.movieImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.title.text = currentMovie.Title
        holder.director.text ="Director: "+ currentMovie.Director
        holder.actors.text = "Actors: "+currentMovie.Actors
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun updateData(movie:Movie) {
       this.movies.add(movies.size,movie)
        this.notifyDataSetChanged()
    }
}