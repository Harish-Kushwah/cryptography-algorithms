import java.util.*;

public class PlayfairCipher {
    private char[][] keyTable;

    public PlayfairCipher(String key) {
        keyTable = generateKeyTable(key);
    }

    private char[][] generateKeyTable(String key) {
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : key.toCharArray()) set.add(c);
        for (char c = 'A'; c <= 'Z'; c++) if (c != 'J') set.add(c);

        char[][] table = new char[5][5];
        Iterator<Character> it = set.iterator();
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                table[i][j] = it.next();
        return table;
    }

    private String formatText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            sb.append(text.charAt(i));
            if (i < text.length() - 1 && text.charAt(i) == text.charAt(i + 1))
                sb.append('X');
        }
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    private int[] findPosition(char c) {
        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                if (keyTable[i][j] == c) return new int[]{i, j};
        return null;
    }

    public String encrypt(String text) {
        text = formatText(text);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i), b = text.charAt(i + 1);
            int[] posA = findPosition(a), posB = findPosition(b);
            if (posA[0] == posB[0]) {
                result.append(keyTable[posA[0]][(posA[1] + 1) % 5]);
                result.append(keyTable[posB[0]][(posB[1] + 1) % 5]);
            } else if (posA[1] == posB[1]) {
                result.append(keyTable[(posA[0] + 1) % 5][posA[1]]);
                result.append(keyTable[(posB[0] + 1) % 5][posB[1]]);
            } else {
                result.append(keyTable[posA[0]][posB[1]]);
                result.append(keyTable[posB[0]][posA[1]]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        PlayfairCipher pf = new PlayfairCipher("MONARCHY");
        String text = "HELLO WORLD";
        String encrypted = pf.encrypt(text);
        System.out.println("Encrypted: " + encrypted);
    }
}
