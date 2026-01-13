class MONARCHY {

    static String[][] matrix = {
        {"M","O","N","E","R"},
        {"C","H","Y","A","B"},
        {"D","F","G","I/J","K"},
        {"L","P","Q","S","T"},
        {"U","V","W","X","Z"}
    };

    public static void main(String[] args) {

        String plaintext = "IHATECOLLEGE";
        plaintext = preprocess(plaintext);

        String cipher = encrypt(plaintext);
        System.out.println("Cipher Text: " + cipher);
    }

    // Step 1: Preprocess plaintext
    static String preprocess(String text) {
        text = text.toUpperCase().replace("J", "I");

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));

            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                sb.append('X');
            }
        }

        if (sb.length() % 2 != 0)
            sb.append('X');

        return sb.toString();
    }

    // Step 2: Encrypt
    static String encrypt(String text) {
        StringBuilder cipher = new StringBuilder();

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            int[] p1 = findPosition(a);
            int[] p2 = findPosition(b);

            // Same row
            if (p1[0] == p2[0]) {
                cipher.append(matrix[p1[0]][(p1[1] + 1) % 5]);
                cipher.append(matrix[p2[0]][(p2[1] + 1) % 5]);
            }
            // Same column
            else if (p1[1] == p2[1]) {
                cipher.append(matrix[(p1[0] + 1) % 5][p1[1]]);
                cipher.append(matrix[(p2[0] + 1) % 5][p2[1]]);
            }
            // Rectangle rule
            else {
                cipher.append(matrix[p1[0]][p2[1]]);
                cipher.append(matrix[p2[0]][p1[1]]);
            }
        }
        return cipher.toString();
    }

    // Step 3: Find character position
    static int[] findPosition(char c) {
        if (c == 'J') c = 'I';

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[i][j].contains(String.valueOf(c)))
                    return new int[]{i, j};
            }
        }
        return null;
    }
}
