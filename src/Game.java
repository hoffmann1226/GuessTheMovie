import java.util.Scanner;
import java.util.regex.Pattern;

public class Game {

    public void Start(String selectedMovie){

        //Start the game
        System.out.println("Can you guess the movie?");
        int numLoops = 0;
        Boolean alreadyGuessedThatLetter = false;

        String hidden = new String(new char[selectedMovie.length()]).replace("\0", "_");
        String lettersGuessed = "";

        //fix movie title to remove spaces
        String fixedMovie = selectedMovie;
        fixedMovie = fixedMovie.replace(" ", "_");

        for (int i = 15; i > 0; i--) {
            System.out.println("You have " + i + " guess(es) left.");
            System.out.println("So far you have guessed the following letters:" + lettersGuessed);
            System.out.println("Current word: " + hidden);
            System.out.println("Guess a letter:");

            //ask for a letter
            Scanner scanner1 = new Scanner(System.in);
            String guess = scanner1.next();
            char currentGuess = guess.charAt(0);

            //Check to see if you haven't already guessed the letter
            if (Pattern.matches("[a-z]+", guess)) {
                for (int x = 1; x <= numLoops; x++) {
                    if (currentGuess == lettersGuessed.charAt(x - 1)) {
                        System.out.println("You already guessed the letter " + currentGuess);
                        alreadyGuessedThatLetter = true;
                        break;
                    } else {
                        alreadyGuessedThatLetter = false;
                    }
                }

                //If this is not a letter that was already guessed
                //Check the logic to see where it is and reveal the letter in the word
                if (!alreadyGuessedThatLetter) {


                    for (int r = 0; r <= selectedMovie.length() - 1; r++) {
                        char current = selectedMovie.charAt(r);
                        if (current == currentGuess) {
                            System.out.println("You guessed a correct letter");
                            char[] charHidden = hidden.toCharArray();
                            charHidden[r] = current;
                            hidden = String.valueOf(charHidden);
                        }
                    }
                    lettersGuessed = lettersGuessed + currentGuess + ", ";
                    numLoops++;

                    if (fixedMovie.equals(hidden)) {
                        System.out.println("YOU WIN!");
                        System.out.println("The movie was " + selectedMovie);
                        break;
                    }
                } else {
                    System.out.println("Please enter an alphabetical character.");
                    i++;
                }

            }
        }
        if (!fixedMovie.equals(hidden)) {
            System.out.println("You lose... :( ");

        }
    }
}

