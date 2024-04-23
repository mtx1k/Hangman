public class Main {
    public static void main(String[] args) {
        Hangman hangman = new Hangman();
        HangmanConsole hangmanConsole = new HangmanConsole(hangman);
        hangmanConsole.run();

    }
}