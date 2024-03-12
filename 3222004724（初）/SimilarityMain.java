import java.util.HashMap;
import java.util.Map;

public class SimilarityMain {
    private final Map<Character, int[]> vectorMap = new HashMap<>();

    public SimilarityMain(String string1, String string2) {
        calculateVector(string1, 0);
        calculateVector(string2, 1);
    }

    public double similarity() {
        return cosineSimilarity();
    }

    private void calculateVector(String str, int index) {
        for (char c : str.toCharArray()) {
            vectorMap.computeIfAbsent(c, k -> new int[2])[index]++;
        }
    }

    private double cosineSimilarity() {
        double dotProduct = 0.0;
        double normA = 0.0;
        double normB = 0.0;

        for (int[] vector : vectorMap.values()) {
            dotProduct += vector[0] * vector[1];
            normA += Math.pow(vector[0], 2);
            normB += Math.pow(vector[1], 2);
        }

        return dotProduct / (Math.sqrt(normA) * Math.sqrt(normB));
    }
}
