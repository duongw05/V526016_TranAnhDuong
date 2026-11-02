package org.example.buoi021126;

public class Diem2D {
    protected double x;
    protected double y;

    public Diem2D() {
        this.x = 0.0;
        this.y = 0.0;
    }

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double tinhKhoangCach(Diem2D other) {
        if (other == null) {
            throw new IllegalArgumentException("Điểm truyền vào không được là null.");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public Diem2D doiXungQuaGoc() {
        double nx = (this.x == 0.0) ? 0.0 : -this.x;
        double ny = (this.y == 0.0) ? 0.0 : -this.y;
        return new Diem2D(nx, ny);
    }

    public void tinhTien(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
