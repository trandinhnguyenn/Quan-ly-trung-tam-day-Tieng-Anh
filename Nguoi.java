import java.time.LocalDate;

public abstract class Nguoi {
    protected String maso;
    protected String hoten;
    protected LocalDate ngaysinh;
    protected String gioitinh;
    protected String email;
    protected String sdt;

    public Nguoi(String maso, String hoten, LocalDate ngaysinh, String gioitinh, String email, String sdt) {
        this.maso = maso;
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.email = email;
        this.sdt = sdt;
    }

    public String getHoTen() {
        return hoten;
    }

    public String getMaso() {
        return maso;
    }

    public abstract void thongtin();
}

