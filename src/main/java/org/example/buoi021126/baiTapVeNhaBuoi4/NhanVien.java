package org.example.buoi021126.baiTapVeNhaBuoi4;

import java.util.Scanner;

public class NhanVien extends Nguoi {
    private int snct;
    private double hsl;

    public NhanVien() {
        super();
    }

    public NhanVien(String hoTen, int tuoi, int snct, double hsl) {
        super(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    public int getSnct() {
        return snct;
    }

    public void setSnct(int snct) {
        this.snct = snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    public double tinhLuong() {
        double lcb = 1.5;
        double phucap = 0.2 * snct;
        return lcb * hsl + phucap;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);
        System.out.print("Nhập số năm công tác: ");
        this.snct = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Nhập hệ số lương: ");
        this.hsl = Double.parseDouble(sc.nextLine().trim());
    }

    @Override
    public void xuat() {
        super.xuat();
        System.out.printf(" | SNCT: %-3d | HSL: %-5.2f | Tiền lương: %-8.2f triệu\n",
                snct, hsl, tinhLuong());
    }

    @Override
    public String toString() {
        return super.toString() + ", SNCT: " + snct + ", HSL: " + hsl + ", Tiền lương: " + String.format("%.2f", tinhLuong()) + " triệu";
    }
}
