import java.util.HashMap;

/**
 * S05 - Count the number of the appearance of letters in a string
 * @author CE190990 Nguyen Hoai An
 */
public class MyString {
    // The main target
    private String string;
    // Store count result map
    private HashMap<Character, Integer> count = new HashMap<>();

    /**
     * MyString contructor
     */
    public MyString() {
        // Require init string value input
        boolean isValid = true;
        do {
            string = ""; // Call input string method in your libary

            isValid = true;

            // Validate result
            if (!isValidString(string) || validateNull(string)) {
                isValid = false;
                System.out.println("Input must be leatters, numbers, and spaces only");
            }
        } while (!isValid);
    
        // Create sorting base on ASCII
        for (int i = 97; i <= 122; count.put((char) i++, 0));
    }
    
    /**
     * Check if a string contains only letters, numbers, spaces, and last dot
     * @param str String to check
     * @return Return true if a string contains only letters, numbers, spaces, and last dot, else is false
     */
    private boolean isValidString(String str) {
        return str.matches(
            String.format(
            "[a-zA-Z0-9 ]+%s", (
                string.endsWith(".")
                ? "\\.$"
                : "")
            )
        );
    }
    
    /**
     * Null validation method
     * @param str String to validate
     * @return Return true if a string is null (or multiple spaces), else if false
     */
    private boolean validateNull(String str) {
        if (str.endsWith(".")) {
            str = str.substring(0, str.length() - 1);
        }
        return str.replaceAll(" ", "").isEmpty();
    }

    /**
     * The method to count letters in string
     */
    public void countLetter() {
        // Loop each character in string
        for (Character letter : string.toCharArray()) {
            // Check letter is alpha or not to continue or jump to next loop
            if (isAlpha(letter) == 0) {
                continue;
            }

            // Check if is upper case letter
            if (isUpper(letter) == 1) {
                // Convert letter to lower case
                letter = (char) toLower(letter);
            }

            // Increase count value of letter key
            count.put(letter, count.get(letter) + 1);
        }
    }

    /**
     * Get count result
     * @return Letters count result
     */
    public String getResult() {
        // Store result
        String result = "";

        // Loop each key in count variable
        for (Character i : count.keySet()) {
            if (count.get(i) >= 1) {
                // Append this letter count result
                result += ("\t" + i + ": " + count.get(i) + "\n");
            }
        }

        if (result.isEmpty()) {
            return "No letter to count\n";
        }

        return result;
    }

    /**
     * Is alpha check based on ASCII
     * @param c ASCII value to check
     * @return Return 1 if its a valid letter, 0 is not
     */
    public int isAlpha(int c) {
        // Checking on ASCII table
        return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) ? 1 : 0);
    }

    /**
     * Is upper case check based on ASCII
     * @param c ASCII value to check
     * @return Return 1 if its a upper case letter, 0 is not
     */
    public int isUpper(int c) {
        // Checking on ASCII table
        return (c >= 65 && c <= 90 ? 1 : 0);
    }

    /**
     * Convert upper case to lower case based on ASCII
     * @param c ASCII value to convert
     * @return Return ASCII value in lower
     */
    public int toLower(int c) {
        return (c + 32);
    }
}