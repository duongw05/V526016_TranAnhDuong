package org.example.bai1;

public class HinhTron {
    private final Diem tam;
    private final double banKinh;

    public HinhTron(Diem tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public Diem getTam() {
        return tam;
    }

    public double chuVi() {
        return 2 * Math.PI * banKinh;
    }

    public double dienTich() {
        return Math.PI * banKinh * banKinh;
    }

    public String getLoai() {
        return "Hình Tròn";
    }
}
