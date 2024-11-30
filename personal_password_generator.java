import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

@SuppressWarnings("all")
public class passwordGenerator {
    private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static String originalDomain;
    private static String websiteDomain;
    private static boolean check = false;
    private static String line;
    public static void main(String[] args) throws IOException, NullPointerException, IllegalArgumentException {
        originalDomain = input.readLine().replaceAll("(?s)\\s+", " ").trim();
        websiteDomain = originalDomain.replaceAll("[^a-zA-Z0-9]", "");
        String randomizedDomain = randomizeDomain(websiteDomain);
        
        while (!(line = input.readLine()).equalsIgnoreCase("exit") && line != null) {
           String[] phrase = line.trim().toLowerCase().split(" ");
           
            for (int i = 0; i < phrase.length; i++) {
                for (int j = 0; j < phrase[i].length(); j++) {
                    sb.append(phrase[i].charAt(j));
                }
            }
            
            if (sb.length() > 10 && !check) {
                String response = input.readLine().trim().toLowerCase();
                
                if (response.equals("yes")) {
                    check = true;
                    continue;
                    
                } else if (response.equals("no") || response == null) {
                    sb.setLength(11);
                    sb.append(randomizedDomain.substring(0, Math.min(5, randomizedDomain.length())));
                    break;
                }
                
            } else if (sb.toString().split("\n").length > 3) {
                String[] lines = sb.toString().split("\n");
                sb.setLength(0);
                
                for (int i = 0; i < Math.min(lines.length, 3); i++) {
                    sb.append(lines[i]).append("\n");
                }
            }
        }

        String basePassword = sb.toString();
        
        if (basePassword.isEmpty() || basePassword == null) {
            throw new IllegalArgumentException(" ");
        }

        int rand = (int) (Math.random() * basePassword.length());
        char modifiedChar = basePassword.charAt(rand);

        if (Character.isLowerCase(modifiedChar)) {
            modifiedChar = Character.toUpperCase(modifiedChar);
        } else {
            modifiedChar = Character.toLowerCase(modifiedChar);
        }

        StringBuilder modifiedPassword = new StringBuilder(shuffle(basePassword));
        
        modifiedPassword.setCharAt(rand, modifiedChar);
        basePassword = modifiedPassword.toString();
        
        int insertPosition = (int) (Math.random() * basePassword.length());
        StringBuilder complexPassword = new StringBuilder(basePassword);
        complexPassword.insert(insertPosition, randomizedDomain);
        
        char favCharacter = (char) input.read();
        complexPassword.insert(rand, favCharacter);
        
        System.out.println(originalDomain + ": " + complexPassword.toString() + "\n");
        
        input.close();
    }

    private static String shuffle(String basePassword) {
        List<Character> characters = new ArrayList<Character>();
        for (char c : basePassword.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(basePassword.length());
        while (characters.size() != 0) {
            int randPicker = (int) (Math.random() * characters.size());
            output.append(characters.remove(randPicker));
        }
        return output.toString();
    }

    private static String randomizeDomain(String domain) {
        String alphanumeric = domain.replaceAll("[^a-zA-Z0-9]", "");
        List<Character> characters = new ArrayList<>();
        for (char c : alphanumeric.toCharArray()) {
            characters.add(c);
        }
        StringBuilder randomized = new StringBuilder();
        while (characters.size() != 0) {
            int randIndex = (int) (Math.random() * characters.size());
            randomized.append(characters.remove(randIndex));
        }
        return randomized.toString();
    }
}

