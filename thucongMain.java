import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class thucongMain {
    static Scanner sc = new Scanner(System.in);
    static QuanLyNguoi qlNguoi = new QuanLyNguoi();
    static ArrayList<KhoaHoc> dsKhoaHoc = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n====== QUẢN LÝ TRUNG TÂM ======");
            System.out.println("1. Quản lý Học viên");
            System.out.println("2. Quản lý Giảng viên");
            System.out.println("3. Quản lý Khóa học");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1": menuHocVien(); break;
                case "2": menuGiangVien(); break;
                case "3": menuKhoaHoc(); break;
                case "0": System.exit(0);
                default: System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    // ======================= MENU HỌC VIÊN ===========================
    static void menuHocVien() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ HỌC VIÊN ---");
            System.out.println("1. Thêm học viên");
            System.out.println("2. Xóa học viên");
            System.out.println("3. Tìm kiếm học viên theo mã");
            System.out.println("4. Hiển thị danh sách học viên");
            System.out.println("5. Đăng ký khóa học");
            System.out.println("6. Hủy đăng ký khóa học");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1": themHocVien(); break;
                case "2": xoaHocVien(); break;
                case "3": timHocVien(); break;
                case "4": hienThiHocVien(); break;
                case "5": dangKyKhoaHoc(); break;
                case "6": huyDangKyKhoaHoc(); break;
                case "0": return;
                default: System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    static void themHocVien() {
        System.out.print("Mã học viên: ");
        String maHV = sc.nextLine();
        System.out.print("Họ tên: ");
        String hoten = sc.nextLine();
        LocalDate ns = nhapNgay("Ngày sinh (dd mm yyyy): ");
        System.out.print("Giới tính: ");
        String gt = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("SĐT: ");
        String sdt = sc.nextLine();
        System.out.print("Trình độ TA: ");
        String trinhDo = sc.nextLine();

        HocVien hv = new HocVien(maHV, hoten, ns, gt, email, sdt, trinhDo);
        qlNguoi.them(hv);
        System.out.println("Thêm học viên thành công!");
        hv.thongtin();
    }

    static void xoaHocVien() {
        System.out.print("Nhập mã học viên cần xóa: ");
        String ma = sc.nextLine();
        qlNguoi.xoa(ma);
        System.out.println("Đã xóa (nếu có).");
    }

    static void timHocVien() {
        System.out.print("Nhập mã học viên cần tìm: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof HocVien && ((HocVien)n).getMaHV().equalsIgnoreCase(ma)) {
                ((HocVien)n).thongtin();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy học viên!");
    }

    static void hienThiHocVien() {
        System.out.println("--- Danh sách học viên ---");
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof HocVien) ((HocVien)n).thongtin();
        }
    }

    static void dangKyKhoaHoc() {
        System.out.print("Nhập mã học viên: ");
        String maHV = sc.nextLine().trim();
        HocVien hv = null;
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof HocVien && ((HocVien)n).getMaHV().equalsIgnoreCase(maHV)) {
                hv = (HocVien)n;
                break;
            }
        }
        if (hv == null) {
            System.out.println("Không tìm thấy học viên!");
            return;
        }
        if (dsKhoaHoc.isEmpty()) {
            System.out.println("Chưa có khóa học nào!");
            return;
        }

        System.out.println("Danh sách khóa học:");
        for (int i=0; i<dsKhoaHoc.size(); i++) {
            KhoaHoc kh = dsKhoaHoc.get(i);
            System.out.println((i+1)+". "+kh.getTenKH()+" ("+kh.getMaKH()+")");
        }
        System.out.print("Chọn khóa học (số): ");
        int chon = Integer.parseInt(sc.nextLine()) - 1;
        if (chon >= 0 && chon < dsKhoaHoc.size()) {
            hv.dangKy(dsKhoaHoc.get(chon));
            System.out.println("Đăng ký thành công!");
            hv.thongtin();
        } else System.out.println("Chọn không hợp lệ!");
    }

    static void huyDangKyKhoaHoc() {
        System.out.print("Nhập mã học viên: ");
        String maHV = sc.nextLine().trim();
        HocVien hv = null;
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof HocVien && ((HocVien)n).getMaHV().equalsIgnoreCase(maHV)) {
                hv = (HocVien)n;
                break;
            }
        }
        if (hv == null) { System.out.println("Không tìm thấy học viên!"); return; }

        ArrayList<KhoaHoc> dk = new ArrayList<>();
        int i = 1;
        System.out.println("Khóa học đã đăng ký:");
        for (KhoaHoc kh : dsKhoaHoc) {
            if (kh.getDanhSachHV().contains(hv)) {
                System.out.println(i+". "+kh.getTenKH()+" ("+kh.getMaKH()+")");
                dk.add(kh);
                i++;
            }
        }
        if (dk.isEmpty()) { System.out.println("Học viên chưa đăng ký khóa học nào."); return; }
        System.out.print("Chọn khóa học để hủy (số): ");
        int chon = Integer.parseInt(sc.nextLine()) - 1;
        if (chon >=0 && chon<dk.size()) {
            hv.huyDangKy(dk.get(chon));
            System.out.println("Hủy đăng ký thành công!");
            hv.thongtin();
        } else System.out.println("Chọn không hợp lệ!");
    }

    // ======================= MENU GIẢNG VIÊN ===========================
    static void menuGiangVien() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ GIẢNG VIÊN ---");
            System.out.println("1. Thêm giảng viên");
            System.out.println("2. Xóa giảng viên");
            System.out.println("3. Tìm kiếm giảng viên theo mã");
            System.out.println("4. Hiển thị danh sách giảng viên");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1": themGiangVien(); break;
                case "2": xoaGiangVien(); break;
                case "3": timGiangVien(); break;
                case "4": hienThiGiangVien(); break;
                case "0": return;
                default: System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    static void themGiangVien() {
        System.out.print("Mã GV: "); String maGV = sc.nextLine();
        System.out.print("Họ tên: "); String hoten = sc.nextLine();
        LocalDate ns = nhapNgay("Ngày sinh (dd mm yyyy): ");
        System.out.print("Giới tính: "); String gt = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("SĐT: "); String sdt = sc.nextLine();
        System.out.print("Trình độ: "); String trinhDo = sc.nextLine();
        System.out.print("Chuyên môn: "); String chuyenMon = sc.nextLine();
        System.out.print("Lương: "); double luong = Double.parseDouble(sc.nextLine());

        GiangVien gv = new GiangVien(maGV, hoten, ns, gt, email, sdt, trinhDo, chuyenMon, luong);
        qlNguoi.them(gv);
        System.out.println("Thêm giảng viên thành công!");
        gv.thongtin();
    }

    static void xoaGiangVien() {
        System.out.print("Nhập mã GV cần xóa: ");
        String ma = sc.nextLine();
        qlNguoi.xoa(ma);
        System.out.println("Đã xóa (nếu có).");
    }

    static void timGiangVien() {
        System.out.print("Nhập mã GV cần tìm: ");
        String ma = sc.nextLine();
        boolean found = false;
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof GiangVien && ((GiangVien)n).getMaGV().equalsIgnoreCase(ma)) {
                ((GiangVien)n).thongtin();
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy giảng viên!");
    }

    static void hienThiGiangVien() {
        System.out.println("--- Danh sách giảng viên ---");
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof GiangVien) ((GiangVien)n).thongtin();
        }
    }

    // ======================= MENU KHÓA HỌC ===========================
    static void menuKhoaHoc() {
        while (true) {
            System.out.println("\n--- QUẢN LÝ KHÓA HỌC ---");
            System.out.println("1. Thêm khóa học");
            System.out.println("2. Hiển thị danh sách khóa học");
            System.out.println("0. Quay lại");
            System.out.print("Chọn: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1": themKhoaHoc(); break;
                case "2": hienThiKhoaHoc(); break;
                case "0": return;
                default: System.out.println("Chọn không hợp lệ!");
            }
        }
    }

    static void themKhoaHoc() {
        System.out.print("Mã khóa học: "); String maKH = sc.nextLine();
        System.out.print("Tên khóa học: "); String tenKH = sc.nextLine();
        System.out.print("Mô tả: "); String moTa = sc.nextLine();
        LocalDate bd = nhapNgay("Ngày bắt đầu (dd mm yyyy): ");
        LocalDate kt = nhapNgay("Ngày kết thúc (dd mm yyyy): ");
        if (qlNguoi.getDanhSach().isEmpty()) {
            System.out.println("Chưa có giảng viên, thêm khóa học sẽ không có GV phụ trách.");
            dsKhoaHoc.add(new KhoaHoc(maKH, tenKH, moTa, bd, kt, null));
            System.out.println("Thêm khóa học thành công!");
            return;
        }
        System.out.println("Danh sách giảng viên:");
        ArrayList<GiangVien> gvList = new ArrayList<>();
        int i=1;
        for (Nguoi n : qlNguoi.getDanhSach()) {
            if (n instanceof GiangVien) {
                System.out.println(i+". "+((GiangVien)n).getHoTen()+" ("+((GiangVien)n).getMaGV()+")");
                gvList.add((GiangVien)n);
                i++;
            }
        }
        System.out.print("Chọn giảng viên phụ trách (số, 0 nếu không có): ");
        int chon = Integer.parseInt(sc.nextLine());
        GiangVien gv = null;
        if (chon>0 && chon<=gvList.size()) gv = gvList.get(chon-1);
        dsKhoaHoc.add(new KhoaHoc(maKH, tenKH, moTa, bd, kt, gv));
        System.out.println("Thêm khóa học thành công!");
    }

    static void hienThiKhoaHoc() {
        System.out.println("--- Danh sách khóa học ---");
        for (KhoaHoc kh : dsKhoaHoc) {
            kh.thongtin();
        }
    }

    // ======================= NHẬP NGÀY ===========================
    public static LocalDate nhapNgay(String thongBao) {
        while (true) {
            try {
                System.out.print(thongBao);
                String line = sc.nextLine().trim();
                String[] parts = line.split("\\s+");
                if (parts.length != 3) throw new Exception("Sai định dạng");
                int day = Integer.parseInt(parts[0]);
                int month = Integer.parseInt(parts[1]);
                int year = Integer.parseInt(parts[2]);
                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Ngày không hợp lệ. Nhập lại theo định dạng: dd mm yyyy (ví dụ: 12 12 2006)");
            }
        }
    }
}
