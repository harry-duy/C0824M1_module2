package caseStudy.controller;

import caseStudy.service.VeMayBayService;
import caseStudy.view.MainView;
import java.util.Scanner;

public class MainController {
    private MainView view;
    private VeMayBayService service;
    private Scanner scanner;

    public MainController() {
        this.service = new VeMayBayService();
        this.view = new MainView(service);
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            try {
                view.showMenu();
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        service.muaVeMayBay();
                        break;
                    case 2:
                        service.huyVeMayBay();
                        break;
                    case 3:
                        service.xemThongTinVeMayBay();
                        break;
                    case 4:
                        service.suaThongTinVeMayBay();
                        break;
                    case 5:
                        view.showSearchMenu();
                        int searchChoice = Integer.parseInt(scanner.nextLine());
                        service.timKiemVeMayBay(searchChoice);
                        break;
                    case 6:
                        service.xemDanhSachVeMayBay();
                        break;
                    case 7:
                        service.repository.saveData();
                        System.out.println("Lưu dữ liệu thành công!");
                        break;
                    case 8:
                        service.repository.loadData();
                        System.out.println("Load dữ liệu thành công!");
                        break;
                    case 9:
                        service.repository.saveData();
                        System.out.println("Đang thoát...");
                        System.exit(0);
                    default:
                        System.out.println("Chức năng không hợp lệ!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lỗi nhập dữ liệu! Hãy nhập số.");
            }
        }
    }
}