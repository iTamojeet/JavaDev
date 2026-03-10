import java.security.MessageDigest;

public class MD5Example {

    public static String getMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();

            for (byte b : messageDigest) {
                hexString.append(String.format("%03x", b));
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String text = "HelloWorld";

        String md5Hash = getMD5(text);

        System.out.println("Original Text: " + text);
        System.out.println("MD5 Hash: " + md5Hash);
    }
}