package ss11.s11;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class NhanSu {
    String hoTen;
    String gioiTinh;
    String ngaySinh;

    public NhanSu(String hoTen, String gioiTinh, String ngaySinh) {
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
    }

    public String toString() {
        return hoTen + " - " + gioiTinh + " - " + ngaySinh;
    }
}

public class QueueNhanSu {
    public static void main(String[] args) {
        Queue<NhanSu> nu = new LinkedList<>();
        Queue<NhanSu> nam = new LinkedList<>();

        // Đọc dữ liệu từ file
        try {
            File file = new File("nhan_su.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(" - ");
                NhanSu nhanSu = new NhanSu(parts[0], parts[1], parts[2]);
                if (nhanSu.gioiTinh.equals("Nữ")) {
                    nu.add(nhanSu);
                } else {
                    nam.add(nhanSu);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }

        // Ghi dữ liệu ra file output
        try {
            FileWriter writer = new FileWriter("nhan_su_output.txt");
            while (!nu.isEmpty()) {
                NhanSu nhanSu = nu.poll();
                writer.write(nhanSu.toString() + "\n");
            }
            while (!nam.isEmpty()) {
                NhanSu nhanSu = nam.poll();
                writer.write(nhanSu.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Lỗi ghi file");
        }
    }
}
