import org.apache.jena.rdf.model.*;

import java.util.ArrayList;

public class Ontology {
    Model model = ModelFactory.createDefaultModel();

    public void makeModel(ArrayList<Movie> movies, ArrayList<String> genres){
        Property hasTitle = model.createProperty("Has Title");
        Property hasGenre = model.createProperty("Has Genre");
        Property wasPublished = model.createProperty("Was Published");
        Property hasRating = model.createProperty("Has Rating");
        ArrayList<String> ontGenres = new ArrayList<>(genres);


        for(Movie m : movies) {
            Resource movie = model.createResource("Movie " + (m.movieID));
            Literal movieTitle = model.createLiteral(m.title);

            movie.addLiteral(hasTitle, movieTitle);
        }
        model.write(System.out, "TURTLE");
    }
}