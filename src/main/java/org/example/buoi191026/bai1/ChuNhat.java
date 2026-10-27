package org.example.buoi191026.bai1;

public class ChuNhat {
    private final double dai;
    private final double rong;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    public double chuVi() {
        return 2 * (dai + rong);
    }

    public double dienTich() {
        return dai * rong;
    }

    public String getLoai() {
        return "Chữ Nhật";
    }
}
