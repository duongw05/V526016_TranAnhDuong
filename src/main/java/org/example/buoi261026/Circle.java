package org.example.buoi261026;

public class Circle {
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public Circle() {
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Circle(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public  double area() {
        return Math.PI * z * z;
    }

    public Circle tinhTien(double d) {
        this.x += d;
        this.y += d;
        this.z += d;
        return this;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
