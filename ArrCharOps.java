
/** A library of operations on arrays of characters (char values).
 *  The library also features a string comparison method. */
public class ArrCharOps {

    public static void main(String[] args) {
        String str = "clearly";
        char[] arr1 = {'c', 'l', 'e', 'a', 'r', 'l', 'y'};
        char[] arr2 = {'U', 'n', 'd', 'e', 'r', 's', 't', 'o', 'o', 'd'};
        System.out.println(str);  // Prints the string
        println(arr1);            // Prints an array of characters
        System.out.println(charAt(arr1, 2));
        System.out.println(indexOf(arr1, 'l'));
        System.out.println(indexOf(arr1, 'l', 3));
        System.out.println(lastIndexOf(arr1, 'l'));
        System.out.println(concat(arr1, arr2));
        System.out.println(subArray(arr2, 2, 9));
        System.out.println(compareTo("abcd", "abcd"));
        System.out.println(compareTo("abc", "abcd"));
        System.out.println(compareTo("abw", "abcd"));
        System.out.println(compareTo("Abcd", "a"));
        System.out.println(compareTo("apple", "banana"));
        System.out.println(compareTo("apple", "applepie"));
        System.out.println(compareTo("Zoo", "zoo"));
        System.out.println(hashCode(arr1));
        System.out.println(hashCode(arr2));
    }

    /**
     * Prints the given array of characters, and moves the cursor to the next
     * line.
     */
    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    /**
     * Returns the char value at the specified index. Assume that the array is
     * non-empty.
     */
    public static char charAt(char[] arr, int index) {
        return arr[index];
    }

    /**
     * If the two arrays have the same value in every index, returns true;
     * Otherwise returns false.
     */
    public static boolean equals(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the index within the given array of the first occurrence of the
     * given character. If no such character is found, returns -1.
     */
    public static int indexOf(char[] arr, char ch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Same as indexOf(char[], char), but starts the search in the given index.
     */
    public static int indexOf(char[] arr, char ch, int fromIndex) {
        for (int i = fromIndex; i < arr.length; i++) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the index within the given arr of the last occurrence of the
     * given character. If no such character is found, returns -1.
     */
    public static int lastIndexOf(char[] arr, char ch) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns an array which is the concatenation of the two given arrays.
     */
    public static char[] concat(char[] arr1, char[] arr2) {
        char[] together = new char[arr1.length + arr2.length];

        // Copy arr1 into the result
        for (int i = 0; i < arr1.length; i++) {
            together[i] = arr1[i];
        }

        // Copy arr2 into the result
        for (int i = 0; i < arr2.length; i++) {
            together[arr1.length + i] = arr2[i];
        }

        return together;
    }

    /**
     * Returns a new array that can be described as a sub-array of this array.
     * The sub-array begins at the specified beginIndex and extends to the
     * character at index endIndex - 1. For example, if arr contains the
     * characters "hamburger", then subArray(4, 8) returns an array of
     * characters containing the characters "urge".
     */
    public static char[] subArray(char[] arr, int beginIndex, int endIndex) {
        char[] daArray = new char[endIndex - beginIndex];

        for (int i = beginIndex, j = 0; i < endIndex; i++, j++) {
            daArray[j] = arr[i];
        }
        return daArray;
    }

    /**
     * Returns a single integer that represents the given array. The hash code
     * is computed as: arr[0]*7^(n-1) + arr[1]*7^(n-2) + ... + arr[n-2]*7 +
     * arr[n-1]. The hash value of an empty array is zero.
     */
    public static long hashCode(char[] arr) {

        if (arr.length == 0) {
            return 0;
        }

        long hash = 0;
        long powerOfSeven = 1;

        for (int i = arr.length - 1; i >= 0; i--) {
            hash += arr[i] * powerOfSeven;
            powerOfSeven *= 7;
        }

        return hash;
    }

    /**
     * Compares the two strings lexicographically. Assume that both strings are
     * not empty.
     *
     * Characters are compared one by one from left to right, using their
     * numeric Unicode values, as follows: - If two characters at the same
     * position in both strings are different, the string with the smaller
     * character is considered lexicographically smaller. - If all characters in
     * the shorter string match the corresponding characters in the longer
     * string, the shorter string is considered lexicographically smaller. - If
     * both strings have the same characters and the same length, they are
     * considered equal. - Strings are compared in a case-sensitive manner.
     *
     * @param str1 the first string to compare
     * @param str2 the second string to compare
     * @return -1 if str1 is lexicographically less than str2, 0 if they are
     * equal, and 1 if str1 is lexicographically greater than str2. Returns -2
     * if either string is null or empty.
     */
    public static int compareTo(String str1, String str2) {

        if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty()) {
            return -2;
        }

        int minLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < minLength; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);

            if (ch1 < ch2) {
                return -1;
            } else if (ch1 > ch2) {
                return 1;
            }
        }

        if (str1.length() < str2.length()) {
            return -1;
        } else if (str1.length() > str2.length()) {
            return 1;
        }

        return 0;
    }

}
