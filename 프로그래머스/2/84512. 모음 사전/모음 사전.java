import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final char[] VOWELS = {'A', 'E', 'I', 'O', 'U'};
    private List<String> dictionary;

    public int solution(String word) {
        dictionary = new ArrayList<>();
        generateWords("", 0);
    
        return dictionary.indexOf(word) + 1;
    }

    private void generateWords(String currentWord, int depth) {
        if (depth > 5) return;

        if (!currentWord.isEmpty()) {
            dictionary.add(currentWord);
        }

        for (char vowel : VOWELS) {
            generateWords(currentWord + vowel, depth + 1);
        }
    }
}