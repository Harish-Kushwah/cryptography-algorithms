public class RailFenceCipher {
    public static String encrypt(String text, int key) {
        if (key == 1) return text;

        StringBuilder[] rail = new StringBuilder[key];
        for (int i = 0; i < key; i++) rail[i] = new StringBuilder();

        int dir = 1, row = 0;
        for (char c : text.toCharArray()) {
            rail[row].append(c);
            row += dir;
            if (row == 0 || row == key - 1) dir = -dir;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : rail) result.append(sb);
        return result.toString();
    }

    public static String decrypt(String cipher, int key) {
        if (key == 1) return cipher;

        boolean[][] mark = new boolean[cipher.length()][key];
        int dir = 1, row = 0;

        for (int i = 0; i < cipher.length(); i++) {
            mark[i][row] = true;
            row += dir;
            if (row == 0 || row == key - 1) dir = -dir;
        }

        char[][] rail = new char[cipher.length()][key];
        int index = 0;
        for (int j = 0; j < key; j++) {
            for (int i = 0; i < cipher.length(); i++) {
                if (mark[i][j] && index < cipher.length()) {
                    rail[i][j] = cipher.charAt(index++);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        row = 0; dir = 1;
        for (int i = 0; i < cipher.length(); i++) {
            result.append(rail[i][row]);
            row += dir;
            if (row == 0 || row == key - 1) dir = -dir;
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String text = "HELLO WORLD";
        int key = 3;

        String encrypted = encrypt(text, key);
        String decrypted = decrypt(encrypted, key);

        System.out.println("Encrypted: " + encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
