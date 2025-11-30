import java.time.LocalDate;

public class HoaDon {
    private String maHD;
    private LocalDate ngayLap;
    private double tongTien;
    private ThanhToan thanhToan;

    public HoaDon(String maHD, double tongTien, ThanhToan tt) {
        this.maHD = maHD;
        this.ngayLap = LocalDate.now();
        this.tongTien = tongTien;
        this.thanhToan = tt;
    }

    // Thực hiện thanh toán
    public void thanhToan() {
        thanhToan.thanhToan(); // gọi phương thức đã sửa trong ThanhToan
    }

    // Xem trạng thái thanh toán
    public void xemTrangThai() {
        thanhToan.xemTrangThai();
    }

    // Hiển thị thông tin hóa đơn
    public void thongTin() {
        System.out.println("Hóa đơn: " + maHD);
        System.out.println("Ngày lập: " + ngayLap);
        System.out.println("Tổng tiền: " + tongTien);
        System.out.println("Học viên: " + thanhToan.getMaHV());
        System.out.println("Trạng thái thanh toán: " + (thanhToan.isDaThanhToan() ? "Đã thanh toán" : "Chưa thanh toán"));
    }

    // Getter
    public String getMaHD() { return maHD; }
    public double getTongTien() { return tongTien; }
    public ThanhToan getThanhToan() { return thanhToan; }
}
