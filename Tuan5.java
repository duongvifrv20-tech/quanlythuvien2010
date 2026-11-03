import java.util.ArrayList;
import java.util.Scanner;

public class Tuan5 {

    static Scanner sc = new Scanner(System.in);

    // Mỗi phần tử là 1 cuốn sách, dạng "mã;tên;đơn giá;số lượng"
    static ArrayList<String> danhSachSach = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            System.out.println();
            System.out.println("===== QUẢN LÝ THƯ VIỆN =====");
            System.out.println("1. Thêm sách");
            System.out.println("2. Hiển thị sách");
            System.out.println("3. Tìm sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Sửa sách");
            System.out.println("6. Tính tổng số lượng");
            System.out.println("7. Tính tổng giá trị");
            System.out.println("8. Thoát");
            System.out.println("9. Bài 1: Mảng số lượng");
            System.out.println("10. Bài 2: Danh sách mã sách");
            System.out.print("Chọn chức năng: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1: themSach(); break;
                case 2: hienThiSach(); break;
                case 3: timSach(); break;
                case 4: xoaSach(); break;
                case 5: suaSach(); break;
                case 6: tongSoLuong(); break;
                case 7: tongGiaTri(); break;
                case 8: System.out.println("Tạm biệt!"); break;
                case 9: bai1(); break;
                case 10: bai2(); break;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (chon != 8);
    }

    // ---------- Bài 3, Bài 4 ----------

    static void themSach() {
        System.out.print("Mã sách: ");
        String ma = sc.nextLine();
        System.out.print("Tên sách: ");
        String ten = sc.nextLine();
        System.out.print("Đơn giá: ");
        String gia = sc.nextLine();
        System.out.print("Số lượng: ");
        String sl = sc.nextLine();
        danhSachSach.add(ma + ";" + ten + ";" + gia + ";" + sl);
    }

    static void hienThiSach() {
        if (danhSachSach.size() == 0) {
            System.out.println("Chưa có sách nào.");
            return;
        }
        for (int i = 0; i < danhSachSach.size(); i++) {
            System.out.println(danhSachSach.get(i).replace(";", " | "));
        }
    }

    static void timSach() {
        System.out.print("Nhập mã sách cần tìm: ");
        int vt = timViTri(sc.nextLine());
        if (vt == -1) {
            System.out.println("Không tìm thấy.");
        } else {
            System.out.println(danhSachSach.get(vt).replace(";", " | "));
        }
    }

    static void xoaSach() {
        System.out.print("Nhập mã sách cần xóa: ");
        int vt = timViTri(sc.nextLine());
        if (vt == -1) {
            System.out.println("Không tìm thấy.");
        } else {
            danhSachSach.remove(vt);
            System.out.println("Đã xóa.");
        }
    }

    static void suaSach() {
        System.out.print("Nhập mã sách cần sửa: ");
        String ma = sc.nextLine();
        int vt = timViTri(ma);
        if (vt == -1) {
            System.out.println("Không tìm thấy.");
            return;
        }
        System.out.print("Tên mới: ");
        String ten = sc.nextLine();
        System.out.print("Đơn giá mới: ");
        String gia = sc.nextLine();
        System.out.print("Số lượng mới: ");
        String sl = sc.nextLine();
        danhSachSach.set(vt, ma + ";" + ten + ";" + gia + ";" + sl);
        System.out.println("Đã sửa.");
    }

    static void tongSoLuong() {
        int tong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            tong = tong + Integer.parseInt(p[3]);
        }
        System.out.println("Tổng số lượng: " + tong);
    }

    static void tongGiaTri() {
        double tong = 0;
        for (int i = 0; i < danhSachSach.size(); i++) {
            String[] p = danhSachSach.get(i).split(";");
            tong = tong + Double.parseDouble(p[2]) * Integer.parseInt(p[3]);
        }
        System.out.println("Tổng giá trị: " + tong);
    }

    // Trả về vị trí sách theo mã, không có thì trả về -1
    static int timViTri(String ma) {
        for (int i = 0; i < danhSachSach.size(); i++) {
            if (danhSachSach.get(i).startsWith(ma + ";")) {
                return i;
            }
        }
        return -1;
    }

    // ---------- Bài 1: mảng số lượng 5 cuốn ----------

    static void bai1() {
        int[] soLuong = new int[5];
        int tong = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Số lượng sách " + (i + 1) + ": ");
            soLuong[i] = Integer.parseInt(sc.nextLine());
            tong = tong + soLuong[i];
        }
        int max = soLuong[0];
        for (int i = 0; i < 5; i++) {
            System.out.println("Sách " + (i + 1) + ": " + soLuong[i]);
            if (soLuong[i] > max) {
                max = soLuong[i];
            }
        }
        System.out.println("Tổng: " + tong);
        System.out.println("Lớn nhất: " + max);
    }

    // ---------- Bài 2: ArrayList mã sách ----------

    static void bai2() {
        ArrayList<String> dsMa = new ArrayList<>();
        int c;
        do {
            System.out.print("1.Thêm 2.Hiển thị 3.Tìm 4.Xóa 0.Quay lại: ");
            c = Integer.parseInt(sc.nextLine());
            if (c == 1) {
                System.out.print("Mã sách: ");
                dsMa.add(sc.nextLine());
            } else if (c == 2) {
                System.out.println(dsMa);
            } else if (c == 3) {
                System.out.print("Mã cần tìm: ");
                System.out.println(dsMa.contains(sc.nextLine()) ? "Có" : "Không có");
            } else if (c == 4) {
                System.out.print("Mã cần xóa: ");
                System.out.println(dsMa.remove(sc.nextLine()) ? "Đã xóa." : "Không tìm thấy.");
            }
        } while (c != 0);
    }
}