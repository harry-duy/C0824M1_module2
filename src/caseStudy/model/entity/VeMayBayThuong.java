package caseStudy.model.entity;

import java.util.Date;

public class VeMayBayThuong extends VeMayBay {
    private static final double GIA_THUONG = 1000.0;

    public VeMayBayThuong(String maVe, Date ngayBay, String gioBay, String noiDi, String noiDen, KhachHang khachHang) {
        super(maVe, ngayBay, gioBay, noiDi, noiDen, khachHang);
    }

    @Override
    public double getGiaVe() {
        return GIA_THUONG;
    }
}