import javafx.util.Pair;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        csvReaderFunction();
        movieLibraryFunction(csvReaderFunction());
    }


    public static Pair<ArrayList<Movie>, ArrayList<Rating>> csvReaderFunction() {
        CsvReader c = new CsvReader();
        c.push();
        return new Pair<>(c.movies, c.ratings);
    }


    public static void movieLibraryFunction(Pair<ArrayList<Movie>, ArrayList<Rating>> pair){
        MovieLibrary movLib = new MovieLibrary();
        ArrayList<Movie> mov = new ArrayList<>(pair.getKey());
        ArrayList<Rating> rat = new ArrayList<>(pair.getValue());

        for(Movie movie :mov){
            movLib.movies.add(movie);
        }
        for(Rating rating : rat){
            movLib.ratings.add(rating);
        }
        movLib.addGenres();
        movLib.annotate(movLib.generateRatings());
        movLib.addRating();

        Ontology ont = new Ontology();
        ont.makeModel(movLib.movies, movLib.genres);
    }
}