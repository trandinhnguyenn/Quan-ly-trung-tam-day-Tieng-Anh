import java.time.LocalDate;
import java.util.ArrayList;

public class KhoaHoc {
    private String maKH;
    private String tenKH;
    private String moTa;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;
    private GiangVien giangVienPhuTrach;

    private ArrayList<HocVien> danhSachHV = new ArrayList<>();

    // Constructor duy nhất
    public KhoaHoc(String maKH, String tenKH, String moTa,
                   LocalDate ngayBatDau, LocalDate ngayKetThuc, GiangVien gv) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.moTa = moTa != null ? moTa : "";
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giangVienPhuTrach = gv;
    }

    // Getter
    public String getMaKH() {
        return maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public ArrayList<HocVien> getDanhSachHV() {
        return danhSachHV;
    }

    public GiangVien getGiangVienPhuTrach() {
        return giangVienPhuTrach;
    }

    // Thêm học viên
    public void themHocVien(HocVien hv) {
        danhSachHV.add(hv);
        hv.setTrangThaiDK("Đã đăng ký");
        System.out.println("Đã thêm học viên " + hv.getMaHV() + " vào khóa " + tenKH);
    }

    // Xóa học viên
    public void xoaHocVien(String maHV) {
        danhSachHV.removeIf(hv -> hv.getMaHV().equals(maHV));
        System.out.println("Đã xóa học viên " + maHV + " khỏi khóa " + tenKH);
    }

    // Hiển thị thông tin khóa học
    public void thongtin() {
        System.out.println("Khóa học: " + tenKH + " (" + maKH + ")");
        if (giangVienPhuTrach != null) {
            System.out.println("Giảng viên phụ trách: " + giangVienPhuTrach.getHoTen());
        }
        if (danhSachHV.isEmpty()) {
            System.out.println("Chưa có học viên đăng ký.");
        } else {
            System.out.println("Danh sách học viên:");
            for (HocVien hv : danhSachHV) {
                hv.thongtin();
            }
        }
    }
}
