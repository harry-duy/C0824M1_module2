package ss13.s2;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static String findLongestIncreasingSubsequence(String inputString) {
        int n = inputString.length();
        if (n == 0) {
            return "";
        }

        // dp[i] là độ dài của chuỗi con tăng dần dài nhất kết thúc tại i
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        // predecessor[i] lưu vị trí ký tự trước trong chuỗi con
        int[] predecessor = new int[n];
        Arrays.fill(predecessor, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (inputString.charAt(i) > inputString.charAt(j) && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    predecessor[i] = j;
                }
            }
        }

        int maxLength = 0;
        int endIndex = -1;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLength) {
                maxLength = dp[i];
                endIndex = i;
            }
        }

        // Tái tạo chuỗi con
        StringBuilder longestSubsequence = new StringBuilder();
        int current = endIndex;
        while (current != -1) {
            longestSubsequence.insert(0, inputString.charAt(current));
            current = predecessor[current];
        }

        return longestSubsequence.toString();
    }

    public static void main(String[] args) {
        String inputString = "Welcome";
        String result = findLongestIncreasingSubsequence(inputString);
        System.out.println("Chuỗi tăng dần lớn nhất là: " + result); // Output: Welo
    }
}
