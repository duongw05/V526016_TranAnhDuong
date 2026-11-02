package org.example.buoi021126;

public class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        super();
        this.z = 0.0;
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double tinhKhoangCach(Diem3D other) {
        if (other == null) {
            throw new IllegalArgumentException("Điểm truyền vào không được là null.");
        }
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        double dz = this.z - other.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public double tinhKhoangCach(Diem2D other) {
        if (other == null) {
            throw new IllegalArgumentException("Điểm truyền vào không được là null.");
        }
        if (other instanceof Diem3D) {
            return this.tinhKhoangCach((Diem3D) other);
        }
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        double dz = this.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public Diem3D doiXungQuaGoc() {
        double nx = (this.x == 0.0) ? 0.0 : -this.x;
        double ny = (this.y == 0.0) ? 0.0 : -this.y;
        double nz = (this.z == 0.0) ? 0.0 : -this.z;
        return new Diem3D(nx, ny, nz);
    }

    public void tinhTien(double dx, double dy, double dz) {
        super.tinhTien(dx, dy);
        this.z += dz;
    }

    @Override
    public void tinhTien(double dx, double dy) {
        super.tinhTien(dx, dy);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
