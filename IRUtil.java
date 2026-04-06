public class IRUtil {
 
    
public static int getFrequencyCount(String term, String doc) {

        // Step 1: Convert both term & doc into lower-case
        term = term.toLowerCase();
        doc = doc.toLowerCase();

        // Step 2: Initialize variable frequencyCount to 0
        int frequencyCount = 0;

        // Step 3: Initialize variable index with index position of term in doc
        int index = doc.indexOf(term);

        // Step 4–7: Loop until term no longer appears in doc
        while (index >= 0) {
            // Step 5: Increment frequencyCount
            frequencyCount++;

            // Step 6: Re-compute doc from the position after the found term
            doc = doc.substring(index + term.length());

            // Step 7: Re-compute index in the updated doc
            index = doc.indexOf(term);
        }

        // Step 8: Return frequencyCount
        return frequencyCount;
    }

    public static double termFrequency(String term, String doc) {

        // Step 1: Get frequency count of term in document
        int frequencyCount = getFrequencyCount(term, doc);

        // Step 2: Get total number of terms in document
        String[] terms = doc.split(" ");
        int totalTermCount = terms.length;

        // Step 3: Return term frequency
        return (double) frequencyCount / totalTermCount;
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        String doc = "Java is a programming language. Java is widely used.";
        String term = "java";

        System.out.println("Frequency Count: " + getFrequencyCount(term, doc));
        System.out.println("Term Frequency: " + termFrequency(term, doc));
    }


}
