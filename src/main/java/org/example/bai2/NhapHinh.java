package org.example.bai2;

import java.util.Scanner;

public class NhapHinh {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = nhapSoNguyenDuong(sc, "Nhập số lượng hình: ");
        Hinh[] dsHinh = new Hinh[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Hình thứ " + (i + 1) + " ---");
            int loai = chonLoaiHinh(sc);
            switch (loai) {
                case 1:
                    dsHinh[i] = nhapTamGiac(sc);
                    break;
                case 2:
                    dsHinh[i] = nhapChuNhat(sc);
                    break;
                default:
                    dsHinh[i] = nhapHinhTron(sc);
                    break;
            }
        }

        System.out.println("\n===== DANH SÁCH HÌNH =====");
        System.out.printf("%-5s %-12s %15s %15s%n", "STT", "Loại hình", "Chu vi", "Diện tích");
        for (int i = 0; i < dsHinh.length; i++) {
            Hinh h = dsHinh[i];
            System.out.printf("%-5d %-12s %15.2f %15.2f%n", i + 1, h.getLoai(), h.chuVi(), h.dienTich());
        }
    }

    private static int chonLoaiHinh(Scanner sc) {
        while (true) {
            System.out.println("Chọn loại hình: 1. Tam Giác  2. Chữ Nhật  3. Hình Tròn");
            int loai = nhapSoNguyen(sc, "Lựa chọn: ");
            if (loai >= 1 && loai <= 3) {
                return loai;
            }
            System.out.println("Lựa chọn không hợp lệ, vui lòng chọn 1, 2 hoặc 3.");
        }
    }

    private static Hinh nhapTamGiac(Scanner sc) {
        while (true) {
            Diem a = nhapDiem(sc, "A");
            Diem b = nhapDiem(sc, "B");
            Diem c = nhapDiem(sc, "C");
            TamGiac tg = new TamGiac(a, b, c);
            if (tg.hopLe()) {
                return tg;
            }
            System.out.println("Ba điểm thẳng hàng, không tạo thành tam giác. Vui lòng nhập lại.");
        }
    }

    private static Hinh nhapChuNhat(Scanner sc) {
        double dai = nhapSoThucDuong(sc, "Nhập chiều dài: ");
        double rong = nhapSoThucDuong(sc, "Nhập chiều rộng: ");
        return new ChuNhat(dai, rong);
    }

    private static Hinh nhapHinhTron(Scanner sc) {
        Diem tam = nhapDiem(sc, "tâm O");
        double r = nhapSoThucDuong(sc, "Nhập bán kính: ");
        return new HinhTron(tam, r);
    }

    private static Diem nhapDiem(Scanner sc, String ten) {
        double x = nhapSoThuc(sc, "Nhập x của điểm " + ten + ": ");
        double y = nhapSoThuc(sc, "Nhập y của điểm " + ten + ": ");
        return new Diem(x, y);
    }

    private static int nhapSoNguyen(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập số nguyên.");
            }
        }
    }

    private static int nhapSoNguyenDuong(Scanner sc, String thongBao) {
        while (true) {
            int n = nhapSoNguyen(sc, thongBao);
            if (n > 0) {
                return n;
            }
            System.out.println("Giá trị phải lớn hơn 0.");
        }
    }

    private static double nhapSoThuc(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String s = sc.nextLine().trim();
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập số.");
            }
        }
    }

    private static double nhapSoThucDuong(Scanner sc, String thongBao) {
        while (true) {
            double v = nhapSoThuc(sc, thongBao);
            if (v > 0) {
                return v;
            }
            System.out.println("Giá trị phải lớn hơn 0.");
        }
    }
}
