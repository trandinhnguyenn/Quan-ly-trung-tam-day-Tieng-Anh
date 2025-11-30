import java.time.LocalDate;

public class HocVien extends Nguoi {
    private String maHV;
    private String trinhDoTA;
    private String trangThaiDK;

    // Constructor duy nhất
    public HocVien(String maHV, String hoten, LocalDate ngaysinh, String gioitinh, String email, String sdt, String trinhDoTA) {
    super(maHV, hoten, ngaysinh, gioitinh, email, sdt); // đúng rồi, maHV làm maso
    this.maHV = maHV;
    this.trinhDoTA = trinhDoTA != null ? trinhDoTA : "Chưa xác định";
    this.trangThaiDK = "Chưa đăng ký";
}
    // Getter
    public String getMaHV() {
        return maHV;
    }

    public String getHoTen() {
        return hoten;
    }

    public String getTrinhDoTA() {
        return trinhDoTA;
    }

    public String getTrangThaiDK() {
        return trangThaiDK;
    }

    // Setter
    public void setTrinhDoTA(String trinhDoTA) {
        this.trinhDoTA = trinhDoTA;
    }

    public void setTrangThaiDK(String trangThaiDK) {
        this.trangThaiDK = trangThaiDK;
    }

    // Hiển thị thông tin học viên
    @Override
    public void thongtin() {
        System.out.println("Học viên: " + hoten + 
                           " | Mã: " + maHV + 
                           " | Trình độ TA: " + trinhDoTA + 
                           " | Trạng thái: " + trangThaiDK);
    }

    // Đăng ký khóa học
    public void dangKy(KhoaHoc kh) {
        kh.themHocVien(this);
        this.trangThaiDK = "Đã đăng ký";
    }

    // Hủy đăng ký khóa học
    public void huyDangKy(KhoaHoc kh) {
        kh.xoaHocVien(this.maHV);
        this.trangThaiDK = "Chưa đăng ký";
    }
}
