import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CsvReader {
    String movieFile = "ml-latest-small/movies.csv";
    String ratingFile = "ml-latest-small/ratings.csv";

    File file = new File(movieFile);
    File fileTwo = new File(ratingFile);

    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Rating> ratings = new ArrayList<>();

    public void push(){
        try{
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(",");
            scanner.nextLine();

            while(scanner.hasNextLine()){
                String value = scanner.nextLine();
                if(value.contains(", ")){
                    value = value.replace(", ", " ");
                }
                String[] movieArray = value.split(",");

                if(movieArray[1].contains("\"")){
                   movieArray[1] = movieArray[1].replace("\"", "");
                }

                int year = 0;
                String title = "";
                Pattern pattern = Pattern.compile("\\(\\d{4}\\)");
                Matcher matcher = pattern.matcher(movieArray[1]);
                if(matcher.find()){
                    title = movieArray[1];
                    title = title.replace(matcher.group(), "");
                    String s = matcher.group();
                    s = s.replace("(", "");
                    s = s.replace(")", "");
                    year = Integer.parseInt(s);
                } else{
                    title = movieArray[1];
                }

                Movie movie = new Movie(Integer.parseInt(movieArray[0]), title, movieArray[2], 0, year);
                movies.add(movie);
            }
            scanner.close();

            Scanner newScanner = new Scanner(fileTwo);
            newScanner.useDelimiter(",");
            newScanner.nextLine();


            while(newScanner.hasNextLine()){
                String valueTwo = newScanner.nextLine();
                String[] ratingArray = valueTwo.split(",");

                Rating rating = new Rating(Integer.parseInt(ratingArray[0]), Integer.parseInt(ratingArray[1]),
                        Double.parseDouble(ratingArray[2]), Integer.parseInt(ratingArray[3]));

                ratings.add(rating);
            }
            newScanner.close();
        }

        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

