import java.util.ArrayList;

public class QuanLyNguoi implements IQuanLy<Nguoi> {
    private ArrayList<Nguoi> danhSach = new ArrayList<>();

    @Override
    public void them(Nguoi obj) {
        danhSach.add(obj);
    }

    @Override
    public void sua(Nguoi obj) {
        // Có thể override ở lớp con để sửa thông tin
        // Hoặc để trống nếu không cần chỉnh sửa
    }

    @Override
    public void xoa(String id) {
        danhSach.removeIf(n -> {
            if (n instanceof HocVien) {
                return ((HocVien) n).getMaHV().equals(id);
            } else if (n instanceof GiangVien) {
                return ((GiangVien) n).getMaGV().equals(id);
            }
            return false;
        });
    }

    @Override
    public void timkiem(String keyword) {
        System.out.println("Kết quả tìm kiếm với từ khóa: " + keyword);
        for (Nguoi n : danhSach) {
            if (n.getHoTen().toLowerCase().contains(keyword.toLowerCase())) {
                n.thongtin();
            }
        }
    }

    // Getter danh sách để hiển thị
    public ArrayList<Nguoi> getDanhSach() {
        return danhSach;
    }
}
