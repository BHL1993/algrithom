public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) != t.charAt(tIndex)) {
                tIndex++;
            } else {
                sIndex++;
                tIndex++;
            }
        }

        return sIndex > s.length();
    }

    public static void main(String[] args) {
        isSubsequence("abc","aebfc");
    }
}
