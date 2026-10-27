package org.example.buoi191026.bai2;

public class HinhTron extends Hinh {
    private final Diem tam;
    private final double banKinh;

    public HinhTron(Diem tam, double banKinh) {
        this.tam = tam;
        this.banKinh = banKinh;
    }

    public Diem getTam() {
        return tam;
    }

    @Override
    public double chuVi() {
        return 2 * Math.PI * banKinh;
    }

    @Override
    public double dienTich() {
        return Math.PI * banKinh * banKinh;
    }

    @Override
    public String getLoai() {
        return "Hình Tròn";
    }
}
