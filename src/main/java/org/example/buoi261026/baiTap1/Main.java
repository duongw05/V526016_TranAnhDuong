package org.example.buoi261026.baiTap1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phân số: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Danh sách rỗng (số lượng phân số <= 0).");
            return;
        }

        ArrayList<PhanSo> danhSach = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phân số thứ " + (i + 1) + ":");
            System.out.print("  Nhập tử số: ");
            int tuSo = scanner.nextInt();

            int mauSo;
            while (true) {
                System.out.print("  Nhập mẫu số (khác 0): ");
                mauSo = scanner.nextInt();
                if (mauSo != 0) {
                    break;
                }
                System.out.println("  Lỗi: Mẫu số không được bằng 0! Vui lòng nhập lại.");
            }
            danhSach.add(new PhanSo(tuSo, mauSo));
        }

        System.out.println("\n--- KẾT QUẢ XỬ LÝ ---");
        System.out.print("1. Danh sách phân số đã nhập: ");
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.print(danhSach.get(i) + (i < danhSach.size() - 1 ? ", " : ""));
        }
        System.out.println();

        PhanSo max = danhSach.get(0);
        for (int i = 1; i < danhSach.size(); i++) {
            if (danhSach.get(i).soSanh(max) > 0) {
                max = danhSach.get(i);
            }
        }
        System.out.println("2. Phân số lớn nhất: " + max);

        PhanSo tong = new PhanSo(0, 1);
        for (PhanSo ps : danhSach) {
            tong = tong.cong(ps);
        }
        System.out.println("3. Tổng các phân số: " + tong);

        int demKhongPhaiNguyen = 0;
        ArrayList<PhanSo> dsKhongPhaiNguyen = new ArrayList<>();
        for (PhanSo ps : danhSach) {
            if (!ps.laSoNguyen()) {
                demKhongPhaiNguyen++;
                dsKhongPhaiNguyen.add(ps);
            }
        }
        System.out.println("4. Số phân số không phải số nguyên: " + demKhongPhaiNguyen);
        if (demKhongPhaiNguyen > 0) {
            System.out.print("   Danh sách gồm: ");
            for (int i = 0; i < dsKhongPhaiNguyen.size(); i++) {
                System.out.print(dsKhongPhaiNguyen.get(i) + (i < dsKhongPhaiNguyen.size() - 1 ? ", " : ""));
            }
            System.out.println();
        }

        if (danhSach.size() >= 2) {
            PhanSo p1 = danhSach.get(0);
            PhanSo p2 = danhSach.get(1);
            System.out.println("\n--- MINH HỌA CÁC PHÉP TOÁN KHÁC (p1 = " + p1 + ", p2 = " + p2 + ") ---");
            System.out.println("Hiệu (p1 - p2): " + p1.tru(p2));
            System.out.println("Tích (p1 * p2): " + p1.nhan(p2));
            try {
                System.out.println("Thương (p1 / p2): " + p1.chia(p2));
            } catch (ArithmeticException e) {
                System.out.println("Thương (p1 / p2): Lỗi - " + e.getMessage());
            }
        }
    }
}
