package caseStudy.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class VeMayBay {
    private String maVe;
    private Date ngayBay;
    private String gioBay;
    private String noiDi;
    private String noiDen;
    private KhachHang khachHang;

    public VeMayBay(String maVe, Date ngayBay, String gioBay, String noiDi, String noiDen, KhachHang khachHang) {
        this.maVe = maVe;
        this.ngayBay = ngayBay;
        this.gioBay = gioBay;
        this.noiDi = noiDi;
        this.noiDen = noiDen;
        this.khachHang = khachHang;
    }

    // Getters and Setters
    public String getMaVe() {
        return maVe;
    }

    public void setMaVe(String maVe) {
        this.maVe = maVe;
    }

    public Date getNgayBay() {
        return ngayBay;
    }

    public void setNgayBay(Date ngayBay) {
        this.ngayBay = ngayBay;
    }

    public String getGioBay() {
        return gioBay;
    }

    public void setGioBay(String gioBay) {
        this.gioBay = gioBay;
    }

    public String getNoiDi() {
        return noiDi;
    }

    public void setNoiDi(String noiDi) {
        this.noiDi = noiDi;
    }

    public String getNoiDen() {
        return noiDen;
    }

    public void setNoiDen(String noiDen) {
        this.noiDen = noiDen;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "VeMayBay{" +
                "maVe='" + maVe + '\'' +
                ", ngayBay=" + sdf.format(ngayBay) +
                ", gioBay='" + gioBay + '\'' +
                ", noiDi='" + noiDi + '\'' +
                ", noiDen='" + noiDen + '\'' +
                ", khachHang=" + khachHang +
                '}';
    }

    public abstract double getGiaVe();
}