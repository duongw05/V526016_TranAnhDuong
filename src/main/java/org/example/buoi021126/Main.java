package org.example.buoi021126;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static double tinhTongKhoangCachLienTiep(List<? extends Diem2D> list) {
        if (list == null || list.size() < 2) {
            return 0.0;
        }
        double tong = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            tong += list.get(i).tinhKhoangCach(list.get(i + 1));
        }
        return tong;
    }

    public static double tinhTongKhoangCachTatCaCacCap(List<? extends Diem2D> list) {
        if (list == null || list.size() < 2) {
            return 0.0;
        }
        double tong = 0.0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                tong += list.get(i).tinhKhoangCach(list.get(j));
            }
        }
        return tong;
    }

    public static void main(String[] args) {
        List<Diem2D> danhSachDiem = new ArrayList<>();

        danhSachDiem.add(new Diem2D(0.0, 0.0));
        danhSachDiem.add(new Diem2D(3.0, 4.0));
        danhSachDiem.add(new Diem2D(6.0, 8.0));

        danhSachDiem.add(new Diem3D(1.0, 2.0, 2.0));
        danhSachDiem.add(new Diem3D(4.0, 6.0, 2.0));
        danhSachDiem.add(new Diem3D(1.0, 1.0, 1.0));

        System.out.println("--- 1. DANH SACH DIEM BAN DAU ---");
        for (int i = 0; i < danhSachDiem.size(); i++) {
            Diem2D d = danhSachDiem.get(i);
            String loai = (d instanceof Diem3D) ? "Diem 3D" : "Diem 2D";
            System.out.printf("[%d] %-8s : %s%n", (i + 1), loai, d);
        }
        System.out.println();

        System.out.println("--- 2. TINH TONG KHOANG CACH CAC DIEM ---");
        List<Diem2D> ds2D = new ArrayList<>();
        List<Diem3D> ds3D = new ArrayList<>();

        for (Diem2D d : danhSachDiem) {
            if (d instanceof Diem3D) {
                ds3D.add((Diem3D) d);
            } else {
                ds2D.add(d);
            }
        }

        System.out.println("Cac diem 2D trong danh sach: " + ds2D);
        double tong2DLienTiep = tinhTongKhoangCachLienTiep(ds2D);
        double tong2DTatCaCap = tinhTongKhoangCachTatCaCacCap(ds2D);
        System.out.printf("  -> Tong khoang cach giua cac diem 2D lien tiep : %.4f%n", tong2DLienTiep);
        System.out.printf("  -> Tong khoang cach giua tat ca cac cap diem 2D : %.4f%n", tong2DTatCaCap);

        System.out.println();

        System.out.println("Cac diem 3D trong danh sach: " + ds3D);
        double tong3DLienTiep = tinhTongKhoangCachLienTiep(ds3D);
        double tong3DTatCaCap = tinhTongKhoangCachTatCaCacCap(ds3D);
        System.out.printf("  -> Tong khoang cach giua cac diem 3D lien tiep : %.4f%n", tong3DLienTiep);
        System.out.printf("  -> Tong khoang cach giua tat ca cac cap diem 3D : %.4f%n", tong3DTatCaCap);

        System.out.println();

        System.out.println("--- 3. THEM DIEM DOI XUNG VAO DANH SACH VA HIEN THI ---");
        List<Diem2D> dsDoiXung = new ArrayList<>();
        for (Diem2D d : danhSachDiem) {
            dsDoiXung.add(d.doiXungQuaGoc());
        }

        int soLuongGoc = danhSachDiem.size();
        danhSachDiem.addAll(dsDoiXung);

        System.out.println("Danh sach toan bo cac diem sau khi da them diem doi xung:");
        for (int i = 0; i < danhSachDiem.size(); i++) {
            Diem2D d = danhSachDiem.get(i);
            String phanLoai = (i < soLuongGoc) ? "Diem goc" : "Diem doi xung";
            String loaiHinh = (d instanceof Diem3D) ? "3D" : "2D";
            System.out.printf("[%2d] %-14s (%s) : %s%n", (i + 1), phanLoai, loaiHinh, d);
        }
        System.out.println();

        System.out.println("--- 4. THU NGHIEM TINH NANG TINH TIEN ---");
        Diem2D p2d = new Diem2D(1.0, 2.0);
        System.out.println("Diem 2D ban dau : " + p2d);
        p2d.tinhTien(2.5, -1.0);
        System.out.println("Diem 2D sau khi tinh tien (+2.5, -1.0) : " + p2d);

        Diem3D p3d = new Diem3D(1.0, 2.0, 3.0);
        System.out.println("Diem 3D ban dau : " + p3d);
        p3d.tinhTien(1.0, 2.0, -1.5);
        System.out.println("Diem 3D sau khi tinh tien (+1.0, +2.0, -1.5) : " + p3d);
    }
}
