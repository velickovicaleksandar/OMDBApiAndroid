package mk.ukim.finki.lab3mpip.model

class Ratings {
//    Title":"John Wick","Year":"2014",
//    "Rated":"R","Released":"24 Oct 2014","Runtime":"101 min","Genre":"Action, Crime, Thriller",
  val source : String
  val value : String

    constructor(source: String, value: String) {
        this.source = source
        this.value = value
    }
}