package caseStudy.repository;

import caseStudy.model.entity.VeMayBay;
import caseStudy.model.entity.KhachHang;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class VeMayBayRepository {
    private static final String DATA_FILE = "src/caseStudy/data/vemaybay.csv";
//    File file = new File("src/caseStudy/data/vemaybay.csv");

    private List<VeMayBay> veMayBays;

    public VeMayBayRepository() {
        this.veMayBays = new ArrayList<>();
        loadData();
    }

    public void addVeMayBay(VeMayBay veMayBay) {
        veMayBays.add(veMayBay);
    }

    public void removeVeMayBay(VeMayBay veMayBay) {
        veMayBays.remove(veMayBay);
    }

    public Optional<VeMayBay> findVeMayBayByMaVe(String maVe) {
        return veMayBays.stream()
                .filter(ve -> ve.getMaVe().equals(maVe))
                .findFirst();
    }

    public List<VeMayBay> findVeMayBayByNgayBay(Date ngayBay) {
        return veMayBays.stream()
                .filter(ve -> ve.getNgayBay().equals(ngayBay))
                .collect(Collectors.toList());
    }

    public List<VeMayBay> findVeMayBayByNoiDi(String noiDi) {
        return veMayBays.stream()
                .filter(ve -> ve.getNoiDi().equalsIgnoreCase(noiDi))
                .collect(Collectors.toList());
    }

    public List<VeMayBay> findVeMayBayByNoiDen(String noiDen) {
        return veMayBays.stream()
                .filter(ve -> ve.getNoiDen().equalsIgnoreCase(noiDen))
                .collect(Collectors.toList());
    }

    public List<VeMayBay> findVeMayBayByPhoneNumber(String phoneNumber) {
        return veMayBays.stream()
                .filter(ve -> ve.getKhachHang().getSoDienThoai().equals(phoneNumber))
                .collect(Collectors.toList());
    }

    public List<VeMayBay> getAllVeMayBays() {
        return new ArrayList<>(veMayBays);
    }

    public void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DATA_FILE))) {
            for (VeMayBay veMayBay : veMayBays) {
                writer.write(toCSVString(veMayBay));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
        }
    }

    public void loadData() {
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(DATA_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    VeMayBay veMayBay = fromCSVString(line);
                    if (veMayBay != null) {
                        veMayBays.add(veMayBay);
                    }
                }
            } catch (IOException e) {
                System.err.println("Lỗi khi load dữ liệu: " + e.getMessage());
            }
        }
    }

    private String toCSVString(VeMayBay veMayBay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return String.join(",", veMayBay.getMaVe(),
                dateFormat.format(veMayBay.getNgayBay()),
                veMayBay.getGioBay(),
                veMayBay.getNoiDi(),
                veMayBay.getNoiDen(),
                veMayBay.getKhachHang().getHoTen(),
                veMayBay.getKhachHang().getSoDienThoai(),
                veMayBay.getKhachHang().getEmail());
    }

    private VeMayBay fromCSVString(String line) {
        String[] parts = line.split(",");
        if (parts.length == 8) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date ngayBay = dateFormat.parse(parts[1]);
                KhachHang khachHang = new KhachHang(parts[5], parts[6], parts[7]);
                return new VeMayBay(parts[0], ngayBay, parts[2], parts[3], parts[4], khachHang) {
                    @Override
                    public double getGiaVe() {
                        return 0;
                    }
                };
            } catch (ParseException e) {
                System.err.println("Lỗi khi parse ngày bay: " + e.getMessage());
            }
        }
        return null;
    }
}