/**
 * S05 - Count the number of the appearance of letters in a string
 * @author CE190990 Nguyen Hoai An
 */
public class App {
    /**
     * The main method
     * @param args Command line args
     */
    public static void main(String[] args) {
        // Create string object
        MyString string = new MyString();
        // Call count letter method
        string.countLetter();
        // Print out count result
        System.out.print(string.getResult());
    }
}
