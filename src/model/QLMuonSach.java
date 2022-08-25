package model;

import java.util.Objects;

public class QLMuonSach {

	private final int MAX_ORDER = 5;
	private BanDoc banDoc;
	private Order[] order = new Order[MAX_ORDER];

	public QLMuonSach() {
	};

	public BanDoc getBanDoc() {
		return banDoc;
	}

	public void setBanDoc(BanDoc banDoc) {
		this.banDoc = banDoc;
	}

	public Order[] getOrders() {
		return order;
	}

	public boolean themOrder(Order order) {

		int n = this.order.length;
		for (int i = 0; i < n; i++) {
			if (this.order[i] == null) {
				this.order[i] = order;
				return true;
			}
			if (this.order[i].equals(order)) {
				if (this.order[i].themSoLuong(order.getSoLuong())) {
					return true;
				} else {
					return false;
				}

			}
		}
		System.out.println("Số lượng sách không quá 5 quyển");
		return false;

	}

	public void hienThiThongTin() {
		System.out.println("Sách đang mượn của bạn " + this.getBanDoc().getHoTen());
		Order[] orders = this.getOrders();
		int orderLenght = orders.length;
		for (int j = 0; j < orderLenght; j++) {
			if (orders[j] == null) {
				break;
			} else {
				System.out.println(orders[j].toString());
			}
		}
		System.out.println();
	}

	public int tongSachMuon() {
		int n = this.order.length;
		int tong = 0;
		for (int i = 0; i < order.length; i++) {
			if (this.order[i] != null) {
				tong += this.order[i].getSoLuong();
			}
		}

		return tong;

	}

	@Override
	public int hashCode() {
		return Objects.hash(banDoc);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QLMuonSach other = (QLMuonSach) obj;
		return Objects.equals(banDoc, other.banDoc);
	}

}
