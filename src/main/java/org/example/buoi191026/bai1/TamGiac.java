package org.example.buoi191026.bai1;

public class TamGiac {
    private final Diem a;
    private final Diem b;
    private final Diem c;

    public TamGiac(Diem a, Diem b, Diem c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean hopLe() {
        return dienTich() > 1e-9;
    }

    public double chuVi() {
        return a.khoangCach(b) + b.khoangCach(c) + c.khoangCach(a);
    }

    public double dienTich() {
        return Math.abs((b.getX() - a.getX()) * (c.getY() - a.getY())
                - (c.getX() - a.getX()) * (b.getY() - a.getY())) / 2;
    }

    public String getLoai() {
        return "Tam Giác";
    }
}
