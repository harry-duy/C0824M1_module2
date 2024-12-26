package caseStudy.model.entity;

import java.util.Date;

public class VeMayBayThuongGia extends VeMayBay {
    private static final double GIA_THUONG_GIA = 1500.0;

    public VeMayBayThuongGia(String maVe, Date ngayBay, String gioBay, String noiDi, String noiDen, KhachHang khachHang) {
        super(maVe, ngayBay, gioBay, noiDi, noiDen, khachHang);
    }

    @Override
    public double getGiaVe() {
        return GIA_THUONG_GIA;
    }
}