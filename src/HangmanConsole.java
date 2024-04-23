import java.util.Scanner;

public class HangmanConsole {
    Hangman hangman;
    public HangmanConsole(Hangman hangman) {
        this.hangman = hangman;
    }
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (counter != 6) {
            System.out.print("Enter a letter: ");
            char letter = scanner.next().toUpperCase().charAt(0);
            if (hangman.isExist(letter)) {
                System.out.println("This letter has already been!");
                continue;
            }
            hangman.addInputtedLetter(letter);
            if(!hangman.generateGameProgress(letter)) {
                counter++;
            }
            if (hangman.getSecretWord().equals(hangman.getGameProgress())) {
                System.out.println("Congratulation!");
                System.out.println(hangman.getGameProgress() + " is correct (" + hangman.getSecretWord() + ")");
                return;
            }
            menu(letter);
        }
        System.out.println("GAME OVER!");
    }
    private void menu(char letter) {
        System.out.println("Word: " + hangman.getGameProgress());
        System.out.println("Mistakes: " + hangman.getMistakes());
        System.out.println("Letter: " + letter);
        printHangman(hangman.getLives());

    }
    private void printHangman(int lives) {
        switch (lives) {
            case 6:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 5:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 4:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("    |    |");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 3:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("  --|    |");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 2:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("  --|--  |");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 1:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("  --|--  |");
                System.out.println("    |    |");
                System.out.println("   /     |");
                System.out.println("_________|___");
                break;
            case 0:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("   (X)   |");
                System.out.println("  --|--  |");
                System.out.println("    |    |");
                System.out.println("   / \\   |");
                System.out.println("_________|___");
        }
    }
}
