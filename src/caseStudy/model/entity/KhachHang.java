package caseStudy.model.entity;

public class KhachHang {
    private String hoTen;
    private String soDienThoai;
    private String email;

    public KhachHang(String hoTen, String soDienThoai, String email) {
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    // Getters and Setters
    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "hoTen='" + hoTen + '\'' +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}