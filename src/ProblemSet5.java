/**
 * Problem Set 5.
 *
 * It's time to put your skills to the test. This problem set focuses on using
 * built-in methods, most notable of the String class. It is also your first
 * introduction to methods that accept parameters and return values. The main
 * method is declared, but it is up to you to implement. Write your code for each
 * exercise in the corresponding method. Make sure you test your code thoroughly.
 *
 * The specifications for each exercise are outlined below. Your job is to write
 * lines of code to produce answers to my questions. Your code must meet the
 * requirements set forth in this section, and must support all possible values
 * that might be passed into your methods.
 *
 * Work through these exercises on your own. Experiment, make mistakes, ask
 * questions, and fix your mistakes. It's the only way to get good at programming.
 */

public class ProblemSet5 {

    public static void main(String[] args) {
      ProblemSet5 ps = new ProblemSet5();

      System.out.println(ps.surroundMe("leCheu", "Kyng"));
      System.out.println(ps.endsMeet("Cheaw aung", 3));
      System.out.println(ps.middleMan("BOOOM"));
      System.out.println(ps.isCentered("STEPHEN", "EPH"));
      System.out.println(ps.countMe("I am an example sentence", 'e'));
      System.out.println(ps.triplets("ccccbbbbaaaa"));
      System.out.println(ps.addMe("oof couch 123456"));
      System.out.println(ps.sequence("aAabBbBb"));
      System.out.println(ps.intertwine("abc", "12345"));
      System.out.println(ps.isPalindrome("racecar"));
    }

    /*
     * Exercise 1.
     *
     * Given two strings, return a new string built by surrounding in with the first
     * and last two characters of out.
     */

    public String surroundMe(String in, String out) {
      if (!in.equals(null) & !out.equals(null) && out.length() == 4) {
           String outHalf1 = out.substring(0, 2);
           String outHalf2 = out.substring(2);
           String rearrangedString = outHalf1 + in + outHalf2;
           return rearrangedString;
         } else {
           return in;
         }
    }
    /*
    * Exercise 2.
    *
    * Given a string and an integer, return a new string that represents the first
    * and last n characters of text.
    */

    public String endsMeet(String text, int n) {
      if (1 <= text.length() && text.length() <= 10 && 1 <= n && n <= text.length()) {
        String firstChars = text.substring(0, n);
        String lastChars = text.substring(text.length() - n);

        String firstAndLastChars = firstChars + lastChars;

        return firstAndLastChars;
      } else {
        return text;
      }
    }

    /*
    * Exercise 3.
    *
    * Given a string, return a new string using the middle three characters of text.
    */

    public String middleMan(String text) {
      if (!text.equals(null) && text.length() % 2 == 1 && text.length() >= 3) {
        int startingPoint = (text.length() - 3) / 2;
        String middleString = text.substring(startingPoint, startingPoint + 3);

        return middleString;
      } else {
       return text;
      }
    }

    /*
    * Exercise 4.
    *
    * Given two strings, determine whether or not target is equivalent to the middle
    * three characters of text.
    */

    public boolean isCentered(String text, String target) {
      if (!text.equals(null) && text.length() % 2 == 1 && text.length() >= 3 && !target.equals(null) && target.length() == 3) {
            int startingPoint = (text.length() - 3) / 2;
            String middleString = text.substring(startingPoint, startingPoint + 3);

            if (middleString.equals(target)) {
              return true;
            } else {
              return false;
            }
          } else {
            return false;
          }
    }

    /*
    * Exercise 5.
    *
    * Given a string and a character, compute the number of words that end in suffix.
    */

    public int countMe(String text, char suffix) {
      int numWords = 0;

      if (!text.equals(null) && ((suffix >= 'a' && suffix <= 'z') || (suffix >= 'A' && suffix <= 'Z'))) {
        boolean firstWord = true;
        boolean newWord;
        for (int i = 0; i < text.length(); i++) {
          if (text.charAt(i) == ' ') {
            if(text.charAt(i - 1) == suffix) {
              numWords++;
            }
          } else if (i == text.length() - 1) {
            if (text.charAt(i - 1) == suffix) {
              numWords++;
            }
          }
        }
      } else {
        numWords = -1;
      }
      return numWords;
    }

    /*
    * Exercise 6.
    *
    * Given a string, compute the number of triplets in text.
    */

    public int triplets(String text) {
      int numTriplets = 0;

      if (text != null) {
        for (char tripleLetter = 'a'; tripleLetter <= 'z'; tripleLetter++) {
          for (int i = 0; i < text.length() - 2; i++) {
            if (text.charAt(i) == tripleLetter && text.charAt(i + 1) == tripleLetter && text.charAt(i + 2) == tripleLetter) {
              numTriplets++;
            }
          }
        }
        for (char tripleLetter = 'A'; tripleLetter <= 'Z'; tripleLetter++) {
          for (int i = 0; i < text.length() - 2; i++) {
            if (text.charAt(i) == tripleLetter && text.charAt(i + 1) == tripleLetter && text.charAt(i + 2) == tripleLetter) {
              numTriplets++;
            }
          }
        }
      } else {
        numTriplets = -1;
      }
      return numTriplets;
    }

    /*
    * Exercise 7.
    *
    * Given a string, compute the sum of the digits in text.
    */

    public long addMe(String text) {
      int digitSum = 0;

      if (text != null) {
        for (int i = 0; i < text.length(); i++) {
          if (Character.isDigit(text.charAt(i))) {
            digitSum = digitSum + (Character.getNumericValue(text.charAt(i)));
          }
        }
      } else {
        digitSum = -1;
      }
      return digitSum;
    }

    /*
    * Exercise 8.
    *
    * Given a string, compute the length of the longest sequence.
    */

    public long sequence(String text) {
      long sequenceLength = 0;
      long longestSequence = 0;
      long lastSequence = 0;
      String lastCharacter = "";
      char sequenceCharacter = 'x';

      if (text != null) {
        for (int i = 0; i < text.length(); i++) {
          sequenceCharacter = text.charAt(i);
          while (sequenceCharacter == text.charAt(i) && i < text.length() - 1) {
            sequenceLength++;
            i++;
            lastCharacter = String.valueOf(text.charAt(i));
          }
          if (sequenceLength > longestSequence) {
            longestSequence = sequenceLength;
          }
          lastSequence = sequenceLength;
          sequenceLength = 0;
        }
        if (text.charAt(text.length() - 1) == sequenceCharacter && lastSequence == longestSequence && lastCharacter.equals(String.valueOf(text.charAt(text.length() - 1)))) {
          longestSequence++;
        }
      } else {
        longestSequence = -1;
      }
      return longestSequence;
    }

    /*
    * Exercise 9.
    *
    * Given two strings, return a new string built by intertwining each of the
    * characters of a and b.
    */

    public String intertwine(String a, String b) {
      String longerString = "";
      String shorterString = "";
      String intertwinedString = "";
      if (a != null && b != null) {
        if (a.length() > b.length()) {
          for (int i = 0; i <= a.length() - b.length(); i++) {
            b += " ";
          }
        } else if (b.length() > a.length()) {
          for (int i = 0; i < b.length() - a.length(); i++) {
            a += " ";
          }
        }
        for (int i = 0; i < a.length(); i++) {
          intertwinedString += a.substring(i, i + 1);
          intertwinedString += b.substring(i, i + 1);
        }
        return intertwinedString;
      } else {
        return null;
      }
    }

    /*
    * Exercise 10.
    *
    * Given a string, determine whether or not it is a palindrome.
    */

    public boolean isPalindrome(String text) {
      String reversedText = "";
      if (text != null) {
        for (int i = text.length() - 1; i >= 0; i--) {
          reversedText += text.charAt(i);
        }
        if (reversedText.equals(text)) {
          return true;
        } else {
          return false;
        }
      } else {
        return false;
      }
    }
  }
