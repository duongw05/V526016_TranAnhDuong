package org.example.buoi261026.baiTap1;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0.");
        }
        this.mauSo = mauSo;
    }

    private int timUCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public PhanSo rutGon() {
        if (this.tuSo == 0) {
            this.mauSo = 1;
            return this;
        }
        int ucln = timUCLN(this.tuSo, this.mauSo);
        this.tuSo /= ucln;
        this.mauSo /= ucln;
        if (this.mauSo < 0) {
            this.tuSo = -this.tuSo;
            this.mauSo = -this.mauSo;
        }
        return this;
    }

    public PhanSo cong(PhanSo p) {
        int ts = this.tuSo * p.mauSo + p.tuSo * this.mauSo;
        int ms = this.mauSo * p.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    public PhanSo tru(PhanSo p) {
        int ts = this.tuSo * p.mauSo - p.tuSo * this.mauSo;
        int ms = this.mauSo * p.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    public PhanSo nhan(PhanSo p) {
        int ts = this.tuSo * p.tuSo;
        int ms = this.mauSo * p.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    public PhanSo chia(PhanSo p) {
        if (p.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0.");
        }
        int ts = this.tuSo * p.mauSo;
        int ms = this.mauSo * p.tuSo;
        return new PhanSo(ts, ms).rutGon();
    }

    public int soSanh(PhanSo p) {
        int t1 = this.mauSo < 0 ? -this.tuSo : this.tuSo;
        int m1 = Math.abs(this.mauSo);
        int t2 = p.mauSo < 0 ? -p.tuSo : p.tuSo;
        int m2 = Math.abs(p.mauSo);

        long diff = (long) t1 * m2 - (long) t2 * m1;
        if (diff > 0) return 1;
        if (diff < 0) return -1;
        return 0;
    }

    public boolean laSoNguyen() {
        return this.tuSo % this.mauSo == 0;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
