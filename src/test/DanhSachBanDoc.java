package test;

import model.BanDoc;
import model.Sach;

public class DanhSachBanDoc {
	private BanDoc danhSachBanDoc[];

	public BanDoc[] getDanhSachBanDoc() {
		return danhSachBanDoc;
	}

	public void setBanDoc(BanDoc[] banDoc) {
		this.danhSachBanDoc = banDoc;
	}

	public void themDanhSach(BanDoc[] listBanDoc) {
		if (this.danhSachBanDoc == null) {
			this.danhSachBanDoc = listBanDoc;
		} else {
			int lenghtDanhSachSach = this.danhSachBanDoc.length;
			int leghtListSach = listBanDoc.length;
			int lenghtTong = lenghtDanhSachSach + leghtListSach;
			BanDoc[] danhSachMoi = new BanDoc[lenghtTong];
			int n = 0;
			int m = 0;
			boolean ckeckDanhSach1 = true;
			boolean ckeckDanhSach2 = true;
			int trungGian = lenghtDanhSachSach;
			while (ckeckDanhSach1 || ckeckDanhSach2) {
				if (n == lenghtDanhSachSach) {
					ckeckDanhSach1 = false;
				} else {
					danhSachMoi[n] = this.danhSachBanDoc[n];
					n++;
				}

				if (m == leghtListSach) {
					ckeckDanhSach2 = false;
				} else {
					danhSachMoi[trungGian] = listBanDoc[m];
					m++;
					trungGian++;
				}

			}

			this.danhSachBanDoc = danhSachMoi;
		}
	}
}
