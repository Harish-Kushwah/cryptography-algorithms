import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        BigInteger p = new BigInteger("23"); // Prime number
        BigInteger g = new BigInteger("5");  // Primitive root

        // Alice private & public key
        BigInteger a = new BigInteger(1024, random).mod(p);
        BigInteger A = g.modPow(a, p);

        // Bob private & public key
        BigInteger b = new BigInteger(1024, random).mod(p);
        BigInteger B = g.modPow(b, p);

        // Exchange public keys
        BigInteger secretAlice = B.modPow(a, p);
        BigInteger secretBob = A.modPow(b, p);

        System.out.println("Public prime (p): " + p);
        System.out.println("Primitive root (g): " + g);
        System.out.println("Alice private: " + a);
        System.out.println("Alice public: " + A);
        System.out.println("Bob private: " + b);
        System.out.println("Bob public: " + B);
        System.out.println("Shared secret (Alice): " + secretAlice);
        System.out.println("Shared secret (Bob): " + secretBob);
    }
}
