import java.util.Scanner;

public class Tuan5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Mảng chứa tối đa 100 cuốn sách
        String[] maSach = new String[100];
        String[] tenSach = new String[100];
        double[] donGia = new double[100];
        int[] soLuong = new int[100];
        int n = 0; // số sách hiện có

        int chon;
        // Bài 3: menu lặp đến khi chọn Thoát
        do {
            System.out.println();
            System.out.println("===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Nhập sách");
            System.out.println("2. Hiển thị danh sách");
            System.out.println("3. Tính tổng số lượng và tổng giá trị");
            System.out.println("4. Tìm sách theo mã");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    // Bài 1: nhập n sách bằng vòng lặp
                    System.out.print("Nhập số lượng sách cần nhập: ");
                    int soSachMoi = Integer.parseInt(sc.nextLine());
                    if (n + soSachMoi > 100) {
                        System.out.println("Chỉ chứa tối đa 100 cuốn sách!");
                        break;
                    }
                    for (int i = 0; i < soSachMoi; i++) {
                        System.out.println("--- Sách thứ " + (n + 1) + " ---");
                        System.out.print("Mã sách: ");
                        maSach[n] = sc.nextLine();
                        System.out.print("Tên sách: ");
                        tenSach[n] = sc.nextLine();
                        System.out.print("Đơn giá: ");
                        donGia[n] = Double.parseDouble(sc.nextLine());
                        System.out.print("Số lượng: ");
                        soLuong[n] = Integer.parseInt(sc.nextLine());
                        n++;
                    }
                    break;

                case 2:
                    // Hiển thị danh sách
                    if (n == 0) {
                        System.out.println("Chưa có sách nào.");
                    } else {
                        for (int i = 0; i < n; i++) {
                            System.out.println(maSach[i] + " | " + tenSach[i]
                                    + " | Đơn giá: " + donGia[i]
                                    + " | Số lượng: " + soLuong[i]);
                        }
                    }
                    break;

                case 3:
                    // Bài 2: tổng số lượng và tổng giá trị
                    int tongSoLuong = 0;
                    double tongGiaTri = 0;
                    for (int i = 0; i < n; i++) {
                        tongSoLuong = tongSoLuong + soLuong[i];
                        tongGiaTri = tongGiaTri + donGia[i] * soLuong[i];
                    }
                    System.out.println("Tổng số lượng: " + tongSoLuong);
                    System.out.println("Tổng giá trị: " + tongGiaTri);
                    break;

                case 4:
                    // Bài 4: tìm sách theo mã
                    System.out.print("Nhập mã sách cần tìm: ");
                    String ma = sc.nextLine();
                    boolean timThay = false;
                    for (int i = 0; i < n; i++) {
                        if (maSach[i].equals(ma)) {
                            System.out.println("Tìm thấy: " + maSach[i] + " | " + tenSach[i]
                                    + " | Đơn giá: " + donGia[i]
                                    + " | Số lượng: " + soLuong[i]);
                            timThay = true;
                            break;
                        }
                    }
                    if (!timThay) {
                        System.out.println("Không tìm thấy sách có mã " + ma);
                    }
                    break;

                case 0:
                    System.out.println("Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 0);
    }
}