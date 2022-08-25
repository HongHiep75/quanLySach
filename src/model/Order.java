package model;

import java.util.Objects;

public class Order {

	private final int MAX_SO_LUONG = 3;
	private Sach sach;
	private int soLuong;
	private String tinhTrang;

	public Order(Sach sach, int soLuong, String tinhTrang) {
		super();
		this.sach = sach;
		this.soLuong = soLuong;
		this.tinhTrang = tinhTrang;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public boolean themSoLuong(int soLuong) {
		if (this.soLuong >= this.MAX_SO_LUONG || (soLuong + this.soLuong) > this.MAX_SO_LUONG) {
			System.out.println("Không được mượn quá 3 sách giống nhau");
			return false;
		}
		this.soLuong += soLuong;
		return true;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(sach);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(sach, other.sach);
	}

	@Override
	public String toString() {
		return " sach = " + sach + ", soLuong = " + soLuong + ", tinhTrang = " + tinhTrang;
	}

}
