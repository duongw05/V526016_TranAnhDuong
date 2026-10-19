package org.example.bai2;

public class ChuNhat extends Hinh {
    private final double dai;
    private final double rong;

    public ChuNhat(double dai, double rong) {
        this.dai = dai;
        this.rong = rong;
    }

    @Override
    public double chuVi() {
        return 2 * (dai + rong);
    }

    @Override
    public double dienTich() {
        return dai * rong;
    }

    @Override
    public String getLoai() {
        return "Chữ Nhật";
    }
}
