
import java.util.Arrays;

public class SentimentAnalyzer {

    // Tip: labeled continue can be used when iterating featureSet + convert review to lower-case
    public static int[] detectProsAndCons(String review, String[][] featureSet,
                                          String[] posOpinionWords, String[] negOpinionWords) {

        int[] featureOpinions = new int[featureSet.length];
        review = review.toLowerCase();

        FEATURE_LOOP:
        for (int i = 0; i < featureSet.length; i++) {
            for (int j = 0; j < featureSet[i].length; j++) {

                String feature = featureSet[i][j];
                int opinion = getOpinionOnFeature(review, feature, posOpinionWords, negOpinionWords);

                if (opinion != 0) {
                    featureOpinions[i] = opinion;
                    continue FEATURE_LOOP; // move to next feature group
                }
            }
            featureOpinions[i] = 0;
        }
        return featureOpinions;
    }

    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature,
                                           String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = checkForWasPhrasePattern(review, feature, posOpinionWords, negOpinionWords);

        if (opinion == 0) {
            opinion = checkForOpinionFirstPattern(review, feature, posOpinionWords, negOpinionWords);
        }
        return opinion;
    }

    // Pattern: {feature} was {opinion}
    private static int checkForWasPhrasePattern(String review, String feature,
                                                String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = 0;
        String pattern = feature + " was ";

        int index = review.indexOf(pattern);
        if (index >= 0) {
            String textAfterPattern = review.substring(index + pattern.length());

            for (String pos : posOpinionWords) {
                if (textAfterPattern.startsWith(pos)) {
                    return 1;
                }
            }
            for (String neg : negOpinionWords) {
                if (textAfterPattern.startsWith(neg)) {
                    return -1;
                }
            }
        }
        return opinion;
    }

    // Pattern: {opinion} {feature}
    private static int checkForOpinionFirstPattern(String review, String feature,
                                                   String[] posOpinionWords, String[] negOpinionWords) {

        String[] sentences = review.split("\\.");
        int opinion = 0;

        for (String sentence : sentences) {
            sentence = sentence.trim();

            for (String pos : posOpinionWords) {
                String pattern = pos + " " + feature;
                if (sentence.contains(pattern)) {
                    return 1;
                }
            }
            for (String neg : negOpinionWords) {
                String pattern = neg + " " + feature;
                if (sentence.contains(pattern)) {
                    return -1;
                }
            }
        }
        return opinion;
    }

    public static void main(String[] args) {

        String review =
            "Haven't been here in years! Fantastic service and the food was delicious! " +
            "Definetly will be a frequent flyer! Francisco was very attentive";

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" }
        };

        String[] posOpinionWords = {
                "good", "fantastic", "friendly", "great",
                "excellent", "amazing", "awesome", "delicious"
        };

        String[] negOpinionWords = {
                "slow", "bad", "horrible", "awful", "unprofessional", "poor"
        };

        int[] featureOpinions =
                detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);

        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}
