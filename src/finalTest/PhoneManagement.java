package finalTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneManagement {
    private static final String DATA_FILE = "src/finalTest/data/mobiles.csv";
    private static List<Phone> phoneList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        loadData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu chức năng:");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewPhone(scanner);
                    break;
                case "2":
                    deletePhone(scanner);
                    break;
                case "3":
                    viewPhoneList();
                    break;
                case "4":
                    searchPhone(scanner);
                    break;
                case "5":
                    System.out.println("Kết thúc chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void loadData() {
        phoneList.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE))) {
            String line;
            br.readLine(); // Skip header row
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    double price = Double.parseDouble(parts[2].trim());
                    int quantity = Integer.parseInt(parts[3].trim());
                    String manufacturer = parts[4].trim();
                    String type = parts[5].trim();

                    if ("authentic".equalsIgnoreCase(type) && parts.length == 8) {
                        int warrantyTime = Integer.parseInt(parts[6].trim());
                        String warrantyScope = parts[7].trim();
                        phoneList.add(new AuthenticPhone(id, name, price, quantity, manufacturer, warrantyTime, warrantyScope));
                    } else if ("handcarry".equalsIgnoreCase(type) && parts.length == 8) {
                        String countryOfOrigin = parts[6].trim();
                        String condition = parts[7].trim();
                        phoneList.add(new HandCarryPhone(id, name, price, quantity, manufacturer, countryOfOrigin, condition));
                    }
                }
            }
            if (!phoneList.isEmpty()) {
                nextId = phoneList.stream().mapToInt(Phone::getId).max().orElse(0) + 1;
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }
    }

    private static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE))) {
            bw.write("ID,Ten dien thoai,Gia ban,So luong,Nha san xuat,Loai dien thoai,Thoi gian bao hanh/Quoc gia xach tay,Pham vi bao hanh/Trang thai\n");
            for (Phone phone : phoneList) {
                String line = phone.getId() + "," + phone.getName() + "," + phone.getPrice() + "," + phone.getQuantity() + "," + phone.getManufacturer() + ",";
                if (phone instanceof AuthenticPhone) {
                    AuthenticPhone authenticPhone = (AuthenticPhone) phone;
                    line += "authentic,"
                            + authenticPhone.getWarrantyTime() + ","
                            + authenticPhone.getWarrantyScope();
                } else if (phone instanceof HandCarryPhone) {
                    HandCarryPhone handCarryPhone = (HandCarryPhone) phone;
                    line += "handcarry,"
                            + handCarryPhone.getCountryOfOrigin() + ","
                            + handCarryPhone.getCondition();
                }
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    private static void addNewPhone(Scanner scanner) {
        System.out.println("\nThêm mới điện thoại:");
        System.out.println("Chọn loại điện thoại (1: Chính hãng, 2: Xách tay):");
        String typeChoice = scanner.nextLine();

        System.out.print("Tên điện thoại: ");
        String name = scanner.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Lỗi: Tên điện thoại không được để trống.");
            return;
        }

        double price = 0;
        while (true) {
            System.out.print("Giá bán: ");
            if (scanner.hasNextDouble()) {
                price = scanner.nextDouble();
                if (price <= 0) {
                    System.out.println("Lỗi: Giá bán phải là số dương.");
                } else {
                    break;
                }
            } else {
                System.out.println("Lỗi: Giá bán phải là một số.");
                scanner.next(); // consume invalid input
            }
        }
        scanner.nextLine(); // consume newline

        int quantity = 0;
        while (true) {
            System.out.print("Số lượng: ");
            if (scanner.hasNextInt()) {
                quantity = scanner.nextInt();
                if (quantity <= 0) {
                    System.out.println("Lỗi: Số lượng phải là số dương.");
                } else {
                    break;
                }
            } else {
                System.out.println("Lỗi: Số lượng phải là một số.");
                scanner.next(); // consume invalid input
            }
        }
        scanner.nextLine(); // consume newline

        System.out.print("Nhà sản xuất: ");
        String manufacturer = scanner.nextLine().trim();
        if (manufacturer.isEmpty()) {
            System.out.println("Lỗi: Nhà sản xuất không được để trống.");
            return;
        }

        if ("1".equals(typeChoice)) {
            int warrantyTime = 0;
            while (true) {
                System.out.print("Thời gian bảo hành (ngày): ");
                if (scanner.hasNextInt()) {
                    warrantyTime = scanner.nextInt();
                    if (warrantyTime <= 0 || warrantyTime > 730) {
                        System.out.println("Lỗi: Thời gian bảo hành phải là số dương và không quá 730 ngày.");
                    } else {
                        break;
                    }
                } else {
                    System.out.println("Lỗi: Thời gian bảo hành phải là một số.");
                    scanner.next(); // consume invalid input
                }
            }
            scanner.nextLine(); // consume newline

            System.out.print("Phạm vi bảo hành (Toan Quoc/Quoc Te): ");
            String warrantyScope = scanner.nextLine().trim();
            if (!warrantyScope.equals("Toan Quoc") && !warrantyScope.equals("Quoc Te")) {
                System.out.println("Lỗi: Phạm vi bảo hành chỉ có thể là 'Toan Quoc' hoặc 'Quoc Te'.");
                return;
            }

            phoneList.add(new AuthenticPhone(nextId++, name, price, quantity, manufacturer, warrantyTime, warrantyScope));
        } else if ("2".equals(typeChoice)) {
            System.out.print("Quốc gia xách tay: ");
            String countryOfOrigin = scanner.nextLine().trim();
            if (countryOfOrigin.equalsIgnoreCase("Viet Nam")) {
                System.out.println("Lỗi: Quốc gia xách tay không được là 'Viet Nam'.");
                return;
            }

            System.out.print("Trạng thái (Da sua chua/Chua sua chua): ");
            String condition = scanner.nextLine().trim();
            if (!condition.equals("Da sua chua") && !condition.equals("Chua sua chua")) {
                System.out.println("Lỗi: Trạng thái chỉ có thể là 'Da sua chua' hoặc 'Chua sua chua'.");
                return;
            }
            phoneList.add(new HandCarryPhone(nextId++, name, price, quantity, manufacturer, countryOfOrigin, condition));
        } else {
            System.out.println("Lựa chọn loại điện thoại không hợp lệ.");
            return;
        }

        saveData();
        System.out.println("Thêm mới điện thoại thành công.");
    }

    private static void deletePhone(Scanner scanner) {
        System.out.println("\nXóa điện thoại:");
        while (true) {
            System.out.print("Nhập ID điện thoại cần xóa: ");
            if (scanner.hasNextInt()) {
                int idToDelete = scanner.nextInt();
                scanner.nextLine(); // consume newline

                Phone phoneToDelete = null;
                for (Phone phone : phoneList) {
                    if (phone.getId() == idToDelete) {
                        phoneToDelete = phone;
                        break;
                    }
                }

                if (phoneToDelete != null) {
                    System.out.print("Bạn có chắc chắn muốn xóa điện thoại này? (Yes/No): ");
                    String confirmation = scanner.nextLine().trim();
                    if ("yes".equalsIgnoreCase(confirmation)) {
                        phoneList.remove(phoneToDelete);
                        saveData();
                        System.out.println("Xóa điện thoại thành công.");
                        viewPhoneList();
                        return;
                    } else {
                        System.out.println("Hủy xóa.");
                        return;
                    }
                } else {
                    try {
                        throw new NotFoundProductException("ID điện thoại không tồn tại.");
                    } catch (NotFoundProductException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Nhấn Enter để quay lại menu chính.");
                        scanner.nextLine();
                        return;
                    }
                }
            } else {
                System.out.println("Lỗi: ID điện thoại phải là một số.");
                scanner.next(); // consume invalid input
            }
        }
    }

    private static void viewPhoneList() {
        System.out.println("\nDanh sách điện thoại:");
        if (phoneList.isEmpty()) {
            System.out.println("Không có điện thoại nào trong danh sách.");
            return;
        }
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }

    private static void searchPhone(Scanner scanner) {
        System.out.println("\nTìm kiếm điện thoại:");
        System.out.println("Nhập từ khóa để tìm kiếm (theo ID hoặc Tên điện thoại): ");
        String keyword = scanner.nextLine().trim().toLowerCase();

        List<Phone> searchResults = new ArrayList<>();
        for (Phone phone : phoneList) {
            if (String.valueOf(phone.getId()).contains(keyword) || phone.getName().toLowerCase().contains(keyword)) {
                searchResults.add(phone);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("Không tìm thấy điện thoại nào phù hợp.");
        } else {
            System.out.println("\nKết quả tìm kiếm:");
            for (Phone phone : searchResults) {
                System.out.println(phone);
            }
        }
    }
}