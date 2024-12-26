package caseStudy.service;

import caseStudy.model.entity.KhachHang;
import caseStudy.model.entity.VeMayBay;
import caseStudy.model.entity.VeMayBayThuong;
import caseStudy.model.entity.VeMayBayThuongGia;
import caseStudy.repository.VeMayBayRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VeMayBayService {
    public VeMayBayRepository repository;
    private Scanner scanner;

    public VeMayBayService() {
        this.repository = new VeMayBayRepository();
        this.scanner = new Scanner(System.in);
    }

    public void muaVeMayBay() {
        System.out.print("Nhập mã vé: ");
        String maVe = scanner.nextLine();
        while (repository.findVeMayBayByMaVe(maVe).isPresent()) {
            System.out.println("Mã vé đã tồn tại! Vui lòng nhập mã khác.");
            System.out.print("Nhập mã vé: ");
            maVe = scanner.nextLine();
        }

        Date ngayBay = nhapNgayBay();
        String gioBay = nhapGioBay();

        System.out.print("Nhập nơi đi: ");
        String noiDi = scanner.nextLine();
        System.out.print("Nhập nơi đến: ");
        String noiDen = scanner.nextLine();

        KhachHang khachHang = nhapThongTinKhachHang();

        System.out.print("Chọn loại vé (1 - Thường, 2 - Thương gia): ");
        int loaiVe = Integer.parseInt(scanner.nextLine());

        VeMayBay veMayBay;
        if (loaiVe == 1) {
            veMayBay = new VeMayBayThuong(maVe, ngayBay, gioBay, noiDi, noiDen, khachHang);
        } else if (loaiVe == 2) {
            veMayBay = new VeMayBayThuongGia(maVe, ngayBay, gioBay, noiDi, noiDen, khachHang);
        } else {
            System.out.println("Loại vé không hợp lệ. Vui lòng thử lại.");
            return;
        }

        repository.addVeMayBay(veMayBay);
        System.out.println("Mua vé máy bay thành công!");
    }

    public void huyVeMayBay() {
        System.out.print("Nhập mã vé cần hủy: ");
        String maVe = scanner.nextLine();
        Optional<VeMayBay> veMayBay = repository.findVeMayBayByMaVe(maVe);
        if (veMayBay.isPresent()) {
            repository.removeVeMayBay(veMayBay.get());
            System.out.println("Hủy vé máy bay thành công!");
        } else {
            System.out.println("Vé máy bay không tồn tại!");
        }
    }

    public void xemThongTinVeMayBay() {
        System.out.print("Nhập mã vé: ");
        String maVe = scanner.nextLine();
        Optional<VeMayBay> veMayBay = repository.findVeMayBayByMaVe(maVe);
        if (veMayBay.isPresent()) {
            System.out.println(veMayBay.get());
        } else {
            System.out.println("Vé máy bay không tồn tại!");
        }
    }

    public void suaThongTinVeMayBay() {
        System.out.print("Nhập mã vé cần sửa: ");
        String maVe = scanner.nextLine();
        Optional<VeMayBay> veMayBay = repository.findVeMayBayByMaVe(maVe);
        if (veMayBay.isPresent()) {
            Date ngayBayMoi = nhapNgayBay();
            veMayBay.get().setNgayBay(ngayBayMoi);

            String gioBayMoi = nhapGioBay();
            veMayBay.get().setGioBay(gioBayMoi);

            System.out.print("Nhập nơi đi mới: ");
            String noiDiMoi = scanner.nextLine();
            veMayBay.get().setNoiDi(noiDiMoi);

            System.out.print("Nhập nơi đến mới: ");
            String noiDenMoi = scanner.nextLine();
            veMayBay.get().setNoiDen(noiDenMoi);

            KhachHang khachHang = nhapThongTinKhachHang();
            veMayBay.get().setKhachHang(khachHang);

            System.out.println("Sửa thông tin vé máy bay thành công!");
        } else {
            System.out.println("Vé máy bay không tồn tại!");
        }
    }

    public void timKiemVeMayBay(int searchChoice) {
        switch (searchChoice) {
            case 1:
                System.out.print("Nhập mã vé: ");
                String maVe = scanner.nextLine();
                Optional<VeMayBay> foundVe = repository.findVeMayBayByMaVe(maVe);
                if (foundVe.isPresent()) {
                    System.out.println(foundVe.get());
                } else {
                    System.out.println("Không tìm thấy vé máy bay có mã " + maVe);
                }
                break;
            case 2:
                Date ngayBay = nhapNgayBay();
                List<VeMayBay> foundVesByDate = repository.findVeMayBayByNgayBay(ngayBay);
                foundVesByDate.forEach(System.out::println);
                break;
            case 3:
                System.out.print("Nhập nơi đi: ");
                String noiDi = scanner.nextLine();
                List<VeMayBay> foundVesByOrigin = repository.findVeMayBayByNoiDi(noiDi);
                foundVesByOrigin.forEach(System.out::println);
                break;
            case 4:
                System.out.print("Nhập nơi đến: ");
                String noiDen = scanner.nextLine();
                List<VeMayBay> foundVesByDestination = repository.findVeMayBayByNoiDen(noiDen);
                foundVesByDestination.forEach(System.out::println);
                break;
            case 5:
                System.out.print("Nhập số điện thoại khách hàng: ");
                String sdt = scanner.nextLine();
                List<VeMayBay> foundVeByPhone = repository.findVeMayBayByPhoneNumber(sdt);
                foundVeByPhone.forEach(System.out::println);
                break;
            case 6:
                return; // Quay lại menu chính
            default:
                System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void xemDanhSachVeMayBay() {
        List<VeMayBay> veMayBays = repository.getAllVeMayBays();
        if (veMayBays.isEmpty()) {
            System.out.println("Không có vé máy bay nào.");
        } else {
            veMayBays.forEach(System.out::println);
        }
    }

    // Helper Methods for Input and Validation
    private Date nhapNgayBay() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // Bắt buộc định dạng dd/MM/yyyy

        while (true) {
            System.out.print("Nhập ngày bay (dd/MM/yyyy): ");
            String ngayBayStr = scanner.nextLine();
            try {
                return dateFormat.parse(ngayBayStr);
            } catch (ParseException e) {
                System.out.println("Ngày bay không hợp lệ. Vui lòng nhập đúng định dạng dd/MM/yyyy.");
            }
        }
    }

    private String nhapGioBay() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        timeFormat.setLenient(false);

        while (true) {
            System.out.print("Nhập giờ bay (HH:mm): ");
            String gioBayStr = scanner.nextLine();
            try {
                timeFormat.parse(gioBayStr); // Chỉ kiểm tra định dạng, không cần lấy giá trị
                return gioBayStr;
            } catch (ParseException e) {
                System.out.println("Giờ bay không hợp lệ. Vui lòng nhập đúng định dạng HH:mm.");
            }
        }
    }

    private KhachHang nhapThongTinKhachHang() {
        System.out.print("Nhập họ tên khách hàng: ");
        String hoTen = scanner.nextLine();

        String soDienThoai = nhapSoDienThoai();
        String email = nhapEmail();

        return new KhachHang(hoTen, soDienThoai, email);
    }

    private String nhapSoDienThoai() {
        Pattern pattern = Pattern.compile("^\\d{10}$"); // Mẫu số điện thoại 10 chữ số

        while (true) {
            System.out.print("Nhập số điện thoại khách hàng (10 số): ");
            String sdt = scanner.nextLine();
            Matcher matcher = pattern.matcher(sdt);
            if (matcher.matches()) {
                return sdt;
            } else {
                System.out.println("Số điện thoại không hợp lệ. Vui lòng nhập đủ 10 số.");
            }
        }
    }

    private String nhapEmail() {
        Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"); // Mẫu email cơ bản

        while (true) {
            System.out.print("Nhập email khách hàng: ");
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                return email;
            } else {
                System.out.println("Email không hợp lệ. Vui lòng nhập đúng định dạng.");
            }
        }
    }
}
