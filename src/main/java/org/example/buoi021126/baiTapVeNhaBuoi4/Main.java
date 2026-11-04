package org.example.buoi021126.baiTapVeNhaBuoi4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        if (n <= 0) {
            System.out.println("Số lượng nhân viên không hợp lệ.");
            return;
        }

        ArrayList<NhanVien> ds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhập thông tin nhân viên thứ " + (i + 1) + " ---");
            NhanVien nv = new NhanVien();
            nv.nhap(sc);
            ds.add(nv);
        }

        System.out.println("\n========== DANH SÁCH NHÂN VIÊN VỪA NHẬP ==========");
        for (NhanVien nv : ds) {
            nv.xuat();
        }

        int maxSnct = ds.get(0).getSnct();
        for (int i = 1; i < ds.size(); i++) {
            if (ds.get(i).getSnct() > maxSnct) {
                maxSnct = ds.get(i).getSnct();
            }
        }

        System.out.println("\n========== NHÂN VIÊN CÓ SỐ NĂM CÔNG TÁC NHIỀU NHẤT (" + maxSnct + " năm) ==========");
        for (NhanVien nv : ds) {
            if (nv.getSnct() == maxSnct) {
                nv.xuat();
            }
        }

        ds.sort((nv1, nv2) -> Double.compare(nv2.tinhLuong(), nv1.tinhLuong()));

        System.out.println("\n========== DANH SÁCH NHÂN VIÊN THEO THỨ TỰ LƯƠNG TỪ CAO ĐẾN THẤP ==========");
        for (NhanVien nv : ds) {
            nv.xuat();
        }

        sc.close();
    }
}
