package org.example.buoi191026;

import java.util.Arrays;
import java.util.Scanner;

public class BaiTapMang {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BÀI 1: Nhập mảng và tính tổng =====");
        int n = nhapSoNguyen(sc, "Nhập số phần tử n: ");
        while (n <= 0) {
            System.out.println("n phải lớn hơn 0, vui lòng nhập lại.");
            n = nhapSoNguyen(sc, "Nhập số phần tử n: ");
        }

        int[] mang = new int[n];
        for (int i = 0; i < n; i++) {
            mang[i] = nhapSoNguyen(sc, "Nhập phần tử thứ " + (i + 1) + ": ");
        }
        System.out.println("Mảng vừa nhập: " + Arrays.toString(mang));
        System.out.println("Tổng các phần tử: " + tinhTong(mang));

        System.out.println();
        System.out.println("===== BÀI 2: Cộng 2 mảng =====");
        int[] mangA = {1, 2, 3, 4, 5};
        int[] mangB = {10, 20, 30};
        System.out.println("Mảng A: " + Arrays.toString(mangA));
        System.out.println("Mảng B: " + Arrays.toString(mangB));
        congHaiMang(mangA, mangB);

        System.out.println();
        System.out.println("===== BÀI 3: Nhập mảng dạng chuỗi =====");
        System.out.print("Nhập các số nguyên, cách nhau bởi dấu cách: ");
        String chuoi = sc.nextLine();
        xuLyChuoiSo(chuoi);

        sc.close();
    }

    private static int nhapSoNguyen(Scanner sc, String thongBao) {
        while (true) {
            System.out.print(thongBao);
            String dong = sc.nextLine().trim();
            try {
                return Integer.parseInt(dong);
            } catch (NumberFormatException e) {
                System.out.println("Giá trị không hợp lệ, vui lòng nhập một số nguyên.");
            }
        }
    }

    public static long tinhTong(int[] mang) {
        long tong = 0;
        for (int x : mang) {
            tong += x;
        }
        return tong;
    }


    public static int[] congHaiMang(int[] a, int[] b) {
        int doDai = Math.max(a.length, b.length);
        int[] ketQua = new int[doDai];

        for (int i = 0; i < doDai; i++) {
            int giaTriA = (i < a.length) ? a[i] : 0;
            int giaTriB = (i < b.length) ? b[i] : 0;
            ketQua[i] = giaTriA + giaTriB;
        }

        System.out.println("Mảng kết quả: " + Arrays.toString(ketQua));
        return ketQua;
    }

    public static void xuLyChuoiSo(String chuoi) {
        chuoi = chuoi.trim();
        if (chuoi.isEmpty()) {
            System.out.println("Số phần tử: 0; Tổng: 0");
            return;
        }

        String[] cacPhanTu = chuoi.split("\\s+");
        int[] mang = new int[cacPhanTu.length];
        try {
            for (int i = 0; i < cacPhanTu.length; i++) {
                mang[i] = Integer.parseInt(cacPhanTu[i]);
            }
        } catch (NumberFormatException e) {
            System.out.println("Chuỗi chứa giá trị không phải số nguyên: " + e.getMessage());
            return;
        }

        System.out.println("Số phần tử: " + mang.length + "; Tổng: " + tinhTong(mang));
    }
}
