package model;

import java.util.Objects;

public class BanDoc {
	private static int BanDocTuTang = 10000;
	private int maBanDoc;
	private String hoTen, diaChi;
	private int soDienThoai;
	private String loaiBanDoc;

	public BanDoc(String hoTen, String diaChi, int soDienThoai, String loaiBanDoc) {
		super();
		this.BanDocTuTang++;
		this.maBanDoc = this.BanDocTuTang;
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.loaiBanDoc = loaiBanDoc;
	}

	public BanDoc() {
		this.BanDocTuTang++;
		this.maBanDoc = this.BanDocTuTang;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public int getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getLoaiBanDoc() {
		return loaiBanDoc;
	}

	public void setLoaiBanDoc(String loaiBanDoc) {
		this.loaiBanDoc = loaiBanDoc;
	}

	public int getMaBanDoc() {
		return maBanDoc;
	}

	@Override
	public String toString() {
		return "maBanDoc = " + maBanDoc + ", hoTen = " + hoTen + ", diaChi = " + diaChi + ", soDienThoai = "
				+ soDienThoai + ", loaiBanDoc=" + loaiBanDoc ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(hoTen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BanDoc other = (BanDoc) obj;
		return other.getHoTen().equalsIgnoreCase(this.hoTen);
	}
	

}
