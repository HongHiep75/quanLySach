package model;

import java.util.Objects;

public class Sach {
	private static int maSachTuTang = 10000;
	private int maSach;
	private String tenSach, tacGia, chuyenNganh;
	private int namXuatBan;

	public Sach( String tenSach, String tacGia, String chuyenNganh, int namXuatBan) {
		super();
		this.maSachTuTang++;
		this.maSach = this.maSachTuTang;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.chuyenNganh = chuyenNganh;
		this.namXuatBan = namXuatBan;
	}
	public Sach() {
		this.maSachTuTang++;
		this.maSach = this.maSachTuTang;
	}
	
	
	
	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public int getMaSach() {
		return maSach;
	}
	@Override
	public String toString() {
		return " maSach = " + maSach + ", tenSach = " + tenSach + ", tacGia= " + tacGia + ", chuyenNganh = " + chuyenNganh
				+ ", namXuatBan = " + namXuatBan + "";
	}
	@Override
	public int hashCode() {
		return Objects.hash(tenSach);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return Objects.equals(tenSach, other.tenSach);
	}
   
}
