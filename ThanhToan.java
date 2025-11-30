public class ThanhToan {
    private String maTT;
    private String maHV;
    private double soTien;
    private boolean daThanhToan;

    public ThanhToan(String maTT, String maHV, double soTien) {
        this.maTT = maTT;
        this.maHV = maHV;
        this.soTien = soTien;
        this.daThanhToan = false; // mặc định chưa thanh toán
    }

    // Thực hiện thanh toán
    public void thanhToan() {
        daThanhToan = true;
        System.out.println("Thanh toán thành công: " + soTien + " cho học viên " + maHV + " (Mã TT: " + maTT + ")");
    }

    // Xem trạng thái thanh toán
    public void xemTrangThai() {
        if (daThanhToan) {
            System.out.println("Trạng thái: Đã thanh toán");
        } else {
            System.out.println("Trạng thái: Chưa thanh toán");
        }
    }

    // Getter
    public String getMaTT() { return maTT; }
    public String getMaHV() { return maHV; }
    public double getSoTien() { return soTien; }
    public boolean isDaThanhToan() { return daThanhToan; }

    // Setter (nếu cần)
    public void setSoTien(double soTien) { this.soTien = soTien; }
}
