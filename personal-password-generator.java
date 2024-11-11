import java.io.*;

public class passwordGenerator {
    private static String line;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        System.out.println("Enter phrases (type 'exit' to finish):");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        while (!(line = input.readLine()).equalsIgnoreCase("exit") && line != null) {
            String[] phrase = line.trim().toLowerCase().split(" ");
            for (int i = 0; i < phrase.length; i++) {
                for (int j = 0; j < phrase[i].length(); j++) {
                    sb.append(phrase[i].charAt(j));
                }
            }
        }

        String basePassword = sb.toString();

        int rand = (int) (Math.random() * basePassword.length());
        char modifiedChar = basePassword.charAt(rand);

        if (Character.isLowerCase(modifiedChar)) {
            modifiedChar = Character.toUpperCase(modifiedChar);
        } else {
            modifiedChar = Character.toLowerCase(modifiedChar);
        }

        StringBuilder modifiedPassword = new StringBuilder(basePassword);
        modifiedPassword.setCharAt(rand, modifiedChar);
        
        basePassword = modifiedPassword.toString();

        StringBuilder complexPassword = new StringBuilder(basePassword);

        System.out.print("Enter your favorite character: ");
        char favCharacter = (char) input.read();
        complexPassword.insert(rand, favCharacter);

        System.out.println("Generated secure password: " + complexPassword.toString());
        input.close();
    }
}
