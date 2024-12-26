package ss11.s4;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyCounter {

    public static void countWordFrequency(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println("Văn bản trống.");
            return;
        }

        // 1. Chuyển thành chữ thường và tách từ
        text = text.toLowerCase();
        // Loại bỏ các ký tự đặc biệt, giữ lại chữ cái và số
        text = text.replaceAll("[^a-zA-Z0-9\\s]", "");
        String[] words = text.split("\\s+");


        // 2. Khởi tạo TreeMap
        Map<String, Integer> wordFrequencyMap = new TreeMap<>();

        // 3. Đếm tần suất
        for (String word : words) {
            if (!word.isEmpty()){ //Kiểm tra từ khác rỗng
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
            }

        }

        // 4. Hiển thị kết quả
        System.out.println("Tần suất xuất hiện của các từ:");
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "Đây là một ví dụ. Ví dụ này để minh họa việc đếm từ. Đây là ví dụ khác!";
        countWordFrequency(text);

        String text2 = "  Ví dụ Ví dụ ví dụ  ";
        countWordFrequency(text2);
        String text3 = null;
        countWordFrequency(text3);
    }
}
