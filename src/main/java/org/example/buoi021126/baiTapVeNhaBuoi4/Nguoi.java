package org.example.buoi021126.baiTapVeNhaBuoi4;

import java.util.Scanner;

public class Nguoi {
    protected String hoTen;
    protected int tuoi;

    public Nguoi() {
    }

    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhập họ tên: ");
        this.hoTen = sc.nextLine().trim();
        System.out.print("Nhập tuổi: ");
        this.tuoi = Integer.parseInt(sc.nextLine().trim());
    }

    public void xuat() {
        System.out.printf("Họ tên: %-20s | Tuổi: %-3d", hoTen, tuoi);
    }

    @Override
    public String toString() {
        return "Họ tên: " + hoTen + ", Tuổi: " + tuoi;
    }
}
