import java.util.Arrays;

import javax.swing.JOptionPane;

public class computerWordGame {
  public static void main(String[] args) {

    // declare vars
    int score1 = 0;
    int score2 = 0;
    boolean play = true;
    // input
    // player = JOptionPane.showInputDialog(null, 'Select Player 1 or Player 2");

    // output
    JOptionPane.showMessageDialog(null,
        "Only use the random letters.\nNOTE: You will receive 3 points for a word that begins with a vowel and 1 point for a word that begins with a consonant!");
    // As long as the game is going on, play
    while (play) {
      // Computer randomly picks 12 letters
      char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
          't', 'u', 'v', 'w', 'x', 'y', 'z' };
      // int randomNumber = (int) (97 + Math.random() * 122);
      // char randomChar = (char) randomNumber;
      // https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
      char[] randomLetter = new char[12];
      // declare starting point; // duration; // increment
      for (int i = 0; i < 12; i++) {
        int randomNumber = (int) (0 + Math.random() * 25);
        // Random Letter computer has guessed
        char randomChar = alphabet[randomNumber];
        randomLetter[i] = randomChar;
      }
      // Player 1's Turn
      String player = "1";
      String playerGuess = playGame(player, randomLetter);
      int score = checkGuess(playerGuess, ""); // Adds score to player 1's score
      score1 += score;
      String previousPlayerGuess = playerGuess;
      // Display Points awarded
      JOptionPane.showMessageDialog(null, "Player 1 has been awarded " + score + " points!\nPlayer 1: " + score1);

      // Player 2's Turn
      player = "2";
      playerGuess = playGame(player, randomLetter);
      score = checkGuess(playerGuess, previousPlayerGuess);
      score2 += score; // Adds score to player 2's score
      // Display Points awarded
      JOptionPane.showMessageDialog(null, "Player 2 has been awarded " + score + " points!\nPlayer 2: " + score2);
      // Ask if they want to play again
      int reply = JOptionPane.showConfirmDialog(null, "Do you want to play again?", "Play Option",
          JOptionPane.YES_NO_OPTION);
      // Stop the game if they reply no
      if (reply == JOptionPane.NO_OPTION) {
        play = false;
      }
    }
    // Display Winner!!
    if (score1 > score2) {
      JOptionPane.showMessageDialog(null, "Player 1 is the winner!\nPlayer 1: " + score1 + "\nPlayer 2: " + score2);
    } else {
      JOptionPane.showMessageDialog(null, "Player 2 is the winner!\nPlayer 1: " + score1 + "\nPlayer 2: " + score2);
    }
  }

  public static String playGame(String player, char[] randomLetter) {
    // Game Starts
    JOptionPane.showMessageDialog(null, "Player " + player + "'s turn!");
    // The first player creates a word from the letters
    String playerGuess = JOptionPane.showInputDialog(null,
        "These are the random letters: " + Arrays.toString(randomLetter) + "\nMake a word from the letters:");
    // JOptionPane.showMessageDialog(null, playerGuess);
    return playerGuess;
  }

  public static int checkGuess(String playerGuess, String previousPlayerGuess) {
    if (playerGuess.equalsIgnoreCase(previousPlayerGuess)) {
      return 0;
    } else {
      String[] validWords = { "algorithm", "application", "backup", "bit", "buffer", "bandwidth", "broadband", "bug",
          "binary", "browser", "bus", "cache", "command", "computer", "cookie", "compiler", "cyberspace", "compress",
          "configure", "database", "digital", "data", "debug", "desktop", "disk", "domain", "decompress", "development",
          "download", "dynamic", "email", "encryption", "firewall", "flowchart", "file", "folder", "graphics",
          "hyperlink", "host", "hardware", "icon", "inbox", "internet", "kernel", "keyword", "keyboard", "laptop",
          "login", "logic", "malware", "motherboard", "mouse", "mainframe", "memory", "monitor", "multimedia",
          "network", "node", "offline", "online", "path", "process", "protocol", "password", "phishing", "platform",
          "program", "portal", "privacy", "programmer", "queue", "resolution", "root", "restore", "router", "reboot",
          "runtime", "screen", "security", "shell", "snapshot", "spam", "screenshot", "server", "script", "software",
          "spreadsheet", "storage", "syntax", "table", "template", "thread", "terminal", "username", "virtual", "virus",
          "web", "website", "window", "wireless" };
      // The computer checks whether the user created word is valid
      for (int i = 0; i < validWords.length; i++) {
        // If it is valid points are awarded, otherwise it goes to the next round
        if (playerGuess.equalsIgnoreCase(validWords[i])) {
          String[] vowels = { "a", "e", "i", "o", "u" };
          String firstLetter = playerGuess.substring(0, 1);
          boolean vowelCheck = false;
          // Check if first letter is vowel
          for (int j = 0; j < vowels.length; j++) {
            // Checks if the first letter is equal to the vowel
            if (firstLetter.equalsIgnoreCase(vowels[j])) {
              vowelCheck = true;
            }
          }
          if (vowelCheck) {
            return 3;
          } else {
            return 1;
          }
        }
      }
      // Word was invalid, so no points
      return 0;
    }
  }
}
