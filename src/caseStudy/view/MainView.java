package caseStudy.view;

import caseStudy.service.VeMayBayService;
import caseStudy.model.entity.VeMayBay;

import java.text.SimpleDateFormat;
import java.util.List;

public class MainView {
    private VeMayBayService service;

    public MainView(VeMayBayService service) {
        this.service = service;
    }

    public void showMenu() {
        System.out.println("========== MENU CHỦ ==========");
        System.out.println("1. Mua vé máy bay");
        System.out.println("2. Hủy vé máy bay");
        System.out.println("3. Xem thông tin vé máy bay");
        System.out.println("4. Sửa thông tin vé máy bay");
        System.out.println("5. Tìm kiếm vé máy bay");
        System.out.println("6. Xem danh sách vé máy bay");
        System.out.println("7. Lưu danh sách vé");
        System.out.println("8. Load danh sách vé");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public void showVeMayBay(VeMayBay veMayBay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("-------------------------------");
        System.out.println("|          VÉ MÁY BAY         |");
        System.out.println("-------------------------------");
        System.out.println("| Mã vé: " + veMayBay.getMaVe());
        System.out.println("| Ngày bay: " + dateFormat.format(veMayBay.getNgayBay()));
        System.out.println("| Giờ bay: " + veMayBay.getGioBay());
        System.out.println("| Nơi đi: " + veMayBay.getNoiDi());
        System.out.println("| Nơi đến: " + veMayBay.getNoiDen());
        System.out.println("| Giá vé: " + veMayBay.getGiaVe() + " VND");
        System.out.println("| Khách hàng: " + veMayBay.getKhachHang().getHoTen());
        System.out.println("-------------------------------");
        System.out.println("|          THÔNG TIN KHÁCH HÀNG |");
        System.out.println("-------------------------------");
        System.out.println("| Họ tên: " + veMayBay.getKhachHang().getHoTen());
        System.out.println("| Số điện thoại: " + veMayBay.getKhachHang().getSoDienThoai());
        System.out.println("| Email: " + veMayBay.getKhachHang().getEmail());
        System.out.println("-------------------------------");
    }

    public void showDanhSachVeMayBay(List<VeMayBay> veMayBays) {
        System.out.println("Danh sách vé máy bay:");
        if (veMayBays.isEmpty()) {
            System.out.println("Không có vé máy bay nào.");
        } else {
            for (VeMayBay veMayBay : veMayBays) {
                showVeMayBay(veMayBay);
            }
        }
    }

    public void showSearchMenu() {
        System.out.println("========== TÌM KIẾM VÉ MÁY BAY ==========");
        System.out.println("1. Tìm theo mã vé");
        System.out.println("2. Tìm theo ngày bay");
        System.out.println("3. Tìm theo nơi đi");
        System.out.println("4. Tìm theo nơi đến");
        System.out.println("5. Tìm theo số điện thoại khách hàng");
        System.out.println("6. Quay lại menu chính");
        System.out.print("Chọn tiêu chí tìm kiếm: ");
    }
}