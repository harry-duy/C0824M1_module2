package ss16.s3;

import java.io.*;

public class FileCopy {
    public static void copyFile(String source, String target) {
        File sourceFile = new File(source);
        File targetFile = new File(target);

        // Kiểm tra nếu tệp nguồn không tồn tại
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn '" + source + "' không tồn tại.");
            return;
        }

        // Kiểm tra nếu tệp đích đã tồn tại
        if (targetFile.exists()) {
            System.out.println("Tệp đích '" + target + "' đã tồn tại. Không thể sao chép.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(targetFile))) {
            int character;
            int count = 0;
            while ((character = reader.read()) != -1) {
                writer.write(character);
                count++;
            }
            System.out.println("Sao chép thành công " + count + " ký tự.");
        } catch (IOException e) {
            System.out.println("Có lỗi xảy ra: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Nhập tên tệp nguồn: ");
            String sourceFile = console.readLine();
            System.out.print("Nhập tên tệp đích: ");
            String targetFile = console.readLine();
            copyFile(sourceFile, targetFile);
        } catch (IOException e) {
            System.out.println("Có lỗi khi nhập liệu: " + e.getMessage());
        }
    }
}
