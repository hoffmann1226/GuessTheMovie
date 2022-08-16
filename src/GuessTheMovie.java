import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


public class GuessTheMovie {

    public static void main(String[] args) throws Exception {

        File movieFile = new File("movies.txt");
        Scanner scanner = new Scanner(movieFile);

        //pick a random movie
        int numberOfMovies = 0;
        int randomMovieNumber = 0;

        ArrayList<String> moviesArrayList = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            numberOfMovies++;
            moviesArrayList.add(scanner.nextLine().toString());
        }

        //pick a random line number/movie of the file
        Random random = new Random();
        randomMovieNumber = (int) (Math.random() * (numberOfMovies));

        //locate the movie corresponding to the random number
        String selectedMovie = moviesArrayList.get(randomMovieNumber);

        Game game = new Game();
        game.Start(selectedMovie);
    }

}


