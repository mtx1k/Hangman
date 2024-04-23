import java.util.ArrayList;
import java.util.Scanner;

public class Hangman implements Runnable {
    private final ArrayList<Character> mistakes;
    private final ArrayList<Character> letters;
    private final String secretWord;
    private String gameProgress;

    public Hangman() {
        this.secretWord = Words.getRandomWord().toString();
        this.gameProgress = generateStartGameProgress();
        this.mistakes = new ArrayList<>();
        this.letters = new ArrayList<>();
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        while (counter != 6) {
            System.out.print("Enter a letter: ");
            char letter = scanner.next().toUpperCase().charAt(0);
            if (letters.contains(letter)) {
                System.out.println("This letter has already been!");
                continue;
            }
            letters.add(letter);
            if(!generateGameProgress(letter)) {
                counter++;
            }
            if (secretWord.equals(gameProgress)) {
                System.out.println("Congratulation!");
                System.out.println(gameProgress + " is correct (" + secretWord + ")");
                return;
            }
            menu(letter);
        }
        System.out.println("GAME OVER!");
    }
    private void menu(char letter) {
        System.out.println("Word: " + gameProgress);
        System.out.println("Mistakes: " + mistakes);
        System.out.println("Letter: " + letter);
        printHangman(mistakes.size());

    }
    private boolean generateGameProgress(char replacement) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == replacement) {
                stringBuilder.append(replacement);
                continue;
            }
            stringBuilder.append(gameProgress.charAt(i));
        }
        if (gameProgress.contentEquals(stringBuilder)) {
            mistakes.add(replacement);
            return false;
        }
        gameProgress = stringBuilder.toString();
        return true;
    }
    private String generateStartGameProgress() {
        return "_".repeat(secretWord.length());
    }
    private void printHangman(int trys) {
        switch (trys) {
            case 0:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 1:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 2:
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
            case 4:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("  --|--  |");
                System.out.println("    |    |");
                System.out.println("         |");
                System.out.println("_________|___");
                break;
            case 5:
                System.out.println("    |----|");
                System.out.println("    |    |");
                System.out.println("    O    |");
                System.out.println("  --|--  |");
                System.out.println("    |    |");
                System.out.println("   /     |");
                System.out.println("_________|___");
                break;
            case 6:
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
