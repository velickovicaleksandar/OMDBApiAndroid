package mk.ukim.finki.lab3mpip

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.lab3mpip.adapter.MovieAdapter
import mk.ukim.finki.lab3mpip.api.OmdbApi
import mk.ukim.finki.lab3mpip.api.OmdbApiClient
import mk.ukim.finki.lab3mpip.databinding.FragmentFirstBinding
import mk.ukim.finki.lab3mpip.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var omdbApiClient:OmdbApi
    private lateinit var movieRecyclerView:RecyclerView
    private lateinit var movieAdapter: MovieAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        omdbApiClient = OmdbApiClient.getOmdbApi()!!
        val searchMovie : EditText = view.findViewById(R.id.searchTitle)

        movieRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewComponent)

        movieRecyclerView.layoutManager = LinearLayoutManager(activity)

        movieAdapter = MovieAdapter(mutableListOf<Movie>())

        movieRecyclerView.setHasFixedSize(true)

        movieRecyclerView.adapter = movieAdapter
        searchMovie.setOnEditorActionListener{ v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_NEXT ){
                val movieTitle: String = searchMovie.text.toString()
                searchMovieByTitle(movieTitle)
                true
            }
            else {
                Toast.makeText(activity, "Error!", Toast.LENGTH_LONG).show()
                false
            }
        }



    binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
    fun searchMovieByTitle(title:String){
        omdbApiClient.getMovieByTitle(title,"c8080bfa").enqueue(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>?, response: Response<Movie>) {
                displayData(response.body())
                if(response.code()==200)
                Toast.makeText(activity, "Success", Toast.LENGTH_LONG).show()
                println(response.body().toString() +"HEHEHEH")
            }

            override fun onFailure(call: Call<Movie>?, t: Throwable) {
                var m = t.message
                Toast.makeText(activity, t.message, Toast.LENGTH_LONG).show()
            }
        })

    }

 fun displayData(body: Movie) {


     movieAdapter.updateData(body)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}