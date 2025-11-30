import java.time.LocalDate;

public class GiangVien extends Nguoi {
    private String maGV;
    private String trinhDo;
    private String chuyenMon;
    private double luong;

    // Constructor duy nhất
    public GiangVien(String maGV, String hoten, LocalDate ngaysinh, String gioitinh,
                     String email, String sdt, String trinhDo, String chuyenMon, double luong) {
        super(maGV, hoten, ngaysinh, gioitinh, email, sdt);// gọi constructor Nguoi
        this.maGV = maGV;
        this.trinhDo = trinhDo != null ? trinhDo : "Chưa xác định";
        this.chuyenMon = chuyenMon != null ? chuyenMon : "Chưa xác định";
        this.luong = luong;
    }

    // Getter
    public String getMaGV() {
        return maGV;
    }

    public String getTrinhDo() {
        return trinhDo;
    }

    public String getChuyenMon() {
        return chuyenMon;
    }

    public double getLuong() {
        return luong;
    }

    // Setter
    public void setTrinhDo(String trinhDo) {
        this.trinhDo = trinhDo;
    }

    public void setChuyenMon(String chuyenMon) {
        this.chuyenMon = chuyenMon;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    // Hiển thị thông tin giảng viên
    @Override
    public void thongtin() {
        System.out.println("Giảng viên: " + hoten + 
                           " | Mã: " + maGV + 
                           " | Trình độ: " + trinhDo + 
                           " | Chuyên môn: " + chuyenMon + 
                           " | Lương: " + luong);
    }
}
