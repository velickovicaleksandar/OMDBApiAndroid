package mk.ukim.finki.lab3mpip.model

//@Entity
class Movie{
    val imbdId: String
    val Title: String
    val Plot: String
    val Poster: String

    val Director: String
    val Writer: String
    val Actors: String



    constructor(
        imbdId: String,
        Title: String,
        Plot: String,
        Poster: String,
        Director: String,
        Writer: String,
        Actors: String,

    ) {
        this.imbdId = imbdId
        this.Title = Title
        this.Plot = Plot
        this.Poster = Poster
        this.Director = Director
        this.Writer = Writer
        this.Actors = Actors

    }
}