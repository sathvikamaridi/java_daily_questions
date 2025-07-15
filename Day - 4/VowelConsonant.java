public class VowelConsonant {
    public static void main(String[] args) {
        char ch = 'e';

        if (Character.isLetter(ch)) {
            if ("AEIOUaeiou".indexOf(ch) != -1)
                System.out.println(ch + " is a Vowel");
            else
                System.out.println(ch + " is a Consonant");
        } else {
            System.out.println(ch + " is not an alphabet");
        }
    }
}
