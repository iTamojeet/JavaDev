/**
 * Implement the substitution ciphers
 */

public class CaesarCipher {

    static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * encrypt -- perform Caesar-style rotation
     *
     * @param plaintext the input String of uppercase letters
     * @param shift     number of positions to rotate
     * @return the encrypted ciphertext String
     */
    public static String encrypt(String plaintext, int shift) {
        // Start with an empty output String
        String ciphertext = "";

        // Loop through the plaintext letters
        for (int i = 0; i < plaintext.length(); i++) {
            // Plaintext character at position i
            char ch = plaintext.charAt(i);

            // Look up its alphabetical index
            int index = ALPHABET.indexOf(ch);

            // Rotate and convert back to a char
            int rotIndex = (index + shift) % ALPHABET.length();
            char cipherChar = ALPHABET.charAt(rotIndex);

            // Append to the output String
            ciphertext += cipherChar;
        }

        return ciphertext;
    }

    /**
     * decrypt -- reverse rotation
     *
     * @param ciphertext the input String
     * @param shift      rotation used for the encryption
     */
    public static String decrypt(String ciphertext, int shift) {
        String plaintext = "";

        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);

            int index = ALPHABET.indexOf(ch);

            int rotindex;
            if (index < shift)
                rotindex = ALPHABET.length() + (index - shift);
            else
                rotindex = index - shift;

            char plaintextChar = ALPHABET.charAt(rotindex);

            plaintext += plaintextChar;
        }

        return plaintext;
    }

    /**
     * main -- entry point for the program
     */
    public static void main(String[] args) {
        String message = "TRAVELEAST";
        int rotation = 3;

        System.out.println(message);

        // Encrypt the message
        String cipher = encrypt(message, rotation);
        System.out.println(cipher);

        // Decrypt
        String decrypted = decrypt(cipher, rotation);
        System.out.println(decrypted);
    }
}
