package test;

import model.Order;
import model.QLMuonSach;

public class DanhSachQLMuonSach {

	private QLMuonSach[] qlMuonSach;

	public DanhSachQLMuonSach(int index) {
		super();
		this.qlMuonSach = new QLMuonSach[index];
	}

	public DanhSachQLMuonSach() {
	}

	public QLMuonSach[] getQlMuonSach() {
		return qlMuonSach;
	}

	public void setQlMuonSach(QLMuonSach[] qlMuonSach) {
		this.qlMuonSach = qlMuonSach;
	}

	public boolean themQlMuonSach(QLMuonSach qlMuonSach) {
		int n = this.qlMuonSach.length;
		for (int i = 0; i < n; i++) {
			if (this.qlMuonSach[i] == null) {
				this.qlMuonSach[i] = qlMuonSach;
				return true;
			}
			if (this.qlMuonSach[i].equals(qlMuonSach)) {
				Order[] orders = qlMuonSach.getOrders();
				int m = orders.length;
				for (int j = 0; j < m; j++) {
					if (orders[j] != null) {
						if (!this.qlMuonSach[i].themOrder(orders[j])) {
							return false;
						}
					}
				}
				return true;
			}
		}

		return false;
	}

	public void hienThiThongTin() {

		int n = this.qlMuonSach.length;
		for (int i = 0; i < n; i++) {
			if (this.qlMuonSach[i] != null) {
				this.qlMuonSach[i].hienThiThongTin();
			}
		}
	}

	public void sapXepTheoTen() {
		int n = this.qlMuonSach.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (this.qlMuonSach[i].getBanDoc().getHoTen()
						.compareTo(this.qlMuonSach[j].getBanDoc().getHoTen()) > 0) {
					QLMuonSach temp = this.qlMuonSach[i];
					this.qlMuonSach[i] = this.qlMuonSach[j];
					this.qlMuonSach[j] = temp;
				}
			}
		}
	}

	public QLMuonSach timQlSachTheoTen(String ten) {
		// TODO Auto-generated method stub
		int n = this.qlMuonSach.length;
		for (int i = 0; i < n; i++) {
			if (this.qlMuonSach[i] != null) {
				if (this.qlMuonSach[i].getBanDoc().getHoTen().equalsIgnoreCase(ten)) {
					return this.qlMuonSach[i];
				}
			}
		}
		return null;
	}

	public void sapXepTheoSoLuong() {
		int n = this.qlMuonSach.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {

				if (this.qlMuonSach[i].tongSachMuon() > this.qlMuonSach[j].tongSachMuon()) {
					QLMuonSach temp = this.qlMuonSach[i];
					this.qlMuonSach[i] = this.qlMuonSach[j];
					this.qlMuonSach[j] = temp;
				}
			}
		}

	}

}
