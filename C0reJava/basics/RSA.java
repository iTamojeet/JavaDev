import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

public class RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger N;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;
    private int bitLength = 1024;
    private Random r;

    public RSA(){
        r = new Random();

        p = BigInteger.probablePrime(bitLength / 2, r);
        q = BigInteger.probablePrime(bitLength / 2, r);

        N = p.multiply(q);
        phi = (p.subtract(BigInteger.ONE))
            .multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.valueOf(65537); // common public exponent
        d = e.modInverse(phi);
    }

    // Encryption
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, N);
    }

    // Decryption
    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, N);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

        BigInteger message = new BigInteger("1010");
        System.out.println("Original Message: " + message);

        BigInteger encrypted = rsa.encrypt(message);
        System.out.println("Encrypted Message: " + encrypted);

        BigInteger decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted Message: " + decrypted);

    }
}
