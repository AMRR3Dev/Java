public class UrlGenerator {

    private static String[] specialChars = {"!", ",", ":", "_", "-", "'", "$", "."};

    public static String generatePathVariable(String title) {

        // 1. Return null if title is null or empty string
        if (title == null || title.isEmpty()) {
            return null;
        }

        // 2. Convert to lower case
        title = title.toLowerCase();

        // 3. Trim leading & trailing whitespace
        title = title.trim();

        // 4. Replace special characters with empty string
        for (String ch : specialChars) {
            title = title.replace(ch, "");
        }

        // 5. Replace spaces with "-" using a maximum of 7 words
        String[] words = title.split(" ");
        StringBuilder pathVariable = new StringBuilder();

        int maxWords = Math.min(7, words.length);
        for (int i = 0; i < maxWords; i++) {
            if (!words[i].isEmpty()) {
                if (pathVariable.length() > 0) {
                    pathVariable.append("-");
                }
                pathVariable.append(words[i]);
            }
        }

        return pathVariable.toString();
    }

    public static void main(String[] args) {
        String title = "   Java In-Depth: Become a Complete Java Engineer!";
        System.out.println(generatePathVariable(title));

        title = "Head First Design Patterns: Building Extensible and Maintainable Object-Oriented Software";
        System.out.println(generatePathVariable(title));
    }
}
