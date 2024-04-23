import java.util.ArrayList;

public class Hangman {
    private final ArrayList<Character> mistakes;
    private final ArrayList<Character> letters;
    private final String secretWord;
    private String gameProgress;
    private int lives;

    public int getLives() {
        return lives;
    }

    public ArrayList<Character> getMistakes() {
        return mistakes;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public String getGameProgress() {
        return gameProgress;
    }

    public void addInputtedLetter(char letter) {
        letters.add(letter);
    }

    public Hangman() {
        this.secretWord = Words.getRandomWord().toString();
        this.gameProgress = generateStartGameProgress();
        this.mistakes = new ArrayList<>();
        this.letters = new ArrayList<>();
        this.lives = 6;
    }

    public boolean isExist(char letter) {
        return letters.contains(letter);
    }
    public boolean generateGameProgress(char letter) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                stringBuilder.append(letter);
                continue;
            }
            stringBuilder.append(gameProgress.charAt(i));
        }
        if (gameProgress.contentEquals(stringBuilder)) {
            mistakes.add(letter);
            lives--;
            return false;
        }
        gameProgress = stringBuilder.toString();
        return true;
    }
    private String generateStartGameProgress() {
        return "_".repeat(secretWord.length());
    }
}
