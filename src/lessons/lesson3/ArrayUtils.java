package lessons.lesson3;

import java.util.*;

public class ArrayUtils {

    public static void main(String[] args) {
        String[] array = new String[20];
        array[0] = "Nikita";
        array[1] = "Nikita";
        array[2] = "Nikita";
        array[3] = "Nikita";
        array[4] = "Nikita";
        array[5] = "Ruslan";
        array[6] = "Ruslan";
        array[7] = "Ruslan";
        array[8] = "Like";
        array[9] = "Like";
        array[10] = "Like";
        array[11] = "Like";
        array[12] = "Like";

        String string = "Hello, my dear friend, friend, friend, how how are are you?";

        System.out.println(ArrayUtils.countWords(array));
        System.out.println(ArrayUtils.getWordsFromText(string));
    }

    private static Map<String, Long> countWords(String[] ar) {
        Map<String, Long> result = new HashMap<>();
        for (String string : ar) {
            if (string != null) {
                long counter = 0;
                for (String string1 : ar) {
                    if (string.equals(string1)) {
                        counter++;
                    }
                }
                result.put(string, counter);
            }
        }
        return result;
    }

    private static HashSet<String> getWordsFromText(String text) {
        return new LinkedHashSet<>(Arrays.asList(text.split("\\W+")));
    }

}
