import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lex = 0;
        
        String lineOne = sc.nextLine().trim();
        String lineTwo = sc.nextLine().trim();
        
        if (lineOne.length() == lineTwo.length()) {
            for (int i = 0; i < lineOne.length(); i++) {
                if (Character.toLowerCase(lineOne.charAt(i)) != Character.toLowerCase(lineTwo.charAt(i))) {
                    if ((int) Character.toLowerCase(lineOne.charAt(i)) > (int) Character.toLowerCase(lineTwo.charAt(i))) {
                        lex = 1;
                        break;
                    } else if ((int) Character.toLowerCase(lineOne.charAt(i)) < (int) Character.toLowerCase(lineTwo.charAt(i))) {
                        lex = -1;
                        break;
                    }
                }
            }
        }
        System.out.print(String.valueOf(lex));
    }
}
