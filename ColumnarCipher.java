import java.util.*;

public class ColumnarCipher {
    public static String encrypt(String text, String key) {
        int col = key.length();
        int row = (int) Math.ceil((double) text.length() / col);

        char[][] matrix = new char[row][col];
        int k = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (k < text.length()) matrix[i][j] = text.charAt(k++);
                else matrix[i][j] = 'X'; // Padding
            }
        }

        Integer[] order = getOrder(key);
        StringBuilder result = new StringBuilder();
        for (int j : order) {
            for (int i = 0; i < row; i++) {
                result.append(matrix[i][j]);
            }
        }
        return result.toString();
    }

    public static String decrypt(String cipher, String key) {
        int col = key.length();
        int row = (int) Math.ceil((double) cipher.length() / col);

        char[][] matrix = new char[row][col];
        Integer[] order = getOrder(key);

        int k = 0;
        for (int j : order) {
            for (int i = 0; i < row; i++) {
                matrix[i][j] = cipher.charAt(k++);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result.append(matrix[i][j]);
            }
        }
        return result.toString().replace("X", "");
    }

    private static Integer[] getOrder(String key) {
        Integer[] order = new Integer[key.length()];
        for (int i = 0; i < key.length(); i++) order[i] = i;

        Arrays.sort(order, (a, b) -> Character.compare(key.charAt(a), key.charAt(b)));
        return order;
    }

    public static void main(String[] args) {
        String text = "HELLO WORLD";
        String key = "ZEBRAS";

        String encrypted = encrypt(text.replaceAll(" ", ""), key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
