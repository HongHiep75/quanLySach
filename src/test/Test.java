package test;

import java.util.Scanner;

import javax.xml.xpath.XPathEvaluationResult;

import model.BanDoc;
import model.Order;
import model.QLMuonSach;
import model.Sach;

public class Test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Chào mừng bạn tới ứng dụng quản lý sách\n");
		DanhSachSach danhSachSach = new DanhSachSach();
		DanhSachBanDoc danhSachBanDoc = new DanhSachBanDoc();
		DanhSachQLMuonSach danhSachQLMuonSach = new DanhSachQLMuonSach();

//		Sach sach = new Sach("doremon", "hiep", "chuyen nganh", 1223);
//		Sach sach2 = new Sach("doremon1", "hiep1", "chuyen nganh", 1223);
//		Sach sach3 = new Sach("doremon2", "hiep2", "chuyen nganh", 1223);
//		Sach sach4 = new Sach("doremon3", "hiep3", "chuyen nganh", 4444);
//		Sach sach5 = new Sach("doremon5", "hiep4", "chuyen nganh", 1223);
//		Sach sach6 = new Sach("doremon6", "hiep5", "chuyen nganh", 4444);
//		Sach[] listSach = { sach, sach2, sach3, sach4, sach5, sach6 };
//		danhSachSach.setDanhSachSach(listSach);
//
//		BanDoc banDoc3 = new BanDoc("Hiep3", "hanoi", 0123, "hoc sinh");
//		BanDoc banDoc1 = new BanDoc("Hiep2", "hanoi", 0123, "hoc sinh");
//		BanDoc banDoc2 = new BanDoc("Hiep1", "hanoi", 0123, "hoc sinh");
//		BanDoc[] listBanDoc = { banDoc3, banDoc2, banDoc1 };
//		danhSachBanDoc.setBanDoc(listBanDoc);
		int luaChon;
		// vong lap chon chuc nang
		do {
			System.out.println("Vui lòng chọn chức năng(nhập số):");
			System.out.println("1. Nhập sách mới ");
			System.out.println("2. Hiển thị danh sách các đầu sách ");
			System.out.println("3. Nhập bạn đọc mới ");
			System.out.println("4. Hiển thị danh sách các bạn đọc");
			System.out.println("5. Nhập thêm sách đã mượn cho bạn đọc");
			System.out.println("6. Hiển thị danh sách quản lý sách");
			System.out.println("7. Tìm kiếm đầu sách mượn theo tên");
			System.out.println("0.Thoát");
			luaChon = sc.nextInt();
			while (luaChon > 7) {
				System.out.println("Chọn lại chức năng:");
				luaChon = sc.nextInt();
			}

			switch (luaChon) {
			// them sach
			case 1: {
				danhSachSach = nhapSachMoi(sc, danhSachSach);
				System.out.println("Thêm thành công");
			}
				break;
			// hien thi sach
			case 2: {

				if (danhSachSach.getDanhSachSach() == null) {
					System.out.println("Danh sách trống");
				} else {
					
					Sach[] 	listSach = danhSachSach.getDanhSachSach();
					int n = listSach.length;
					for (int i = 0; i < n; i++) {
						System.out.println(listSach[i].toString());

					}
				}
			}
				break;
			// them ban doc
			case 3: {
				danhSachBanDoc = nhapBanDoc(sc, danhSachBanDoc);
				System.out.println("Thêm thành công");

			}
				break;
			// hien thi ban doc
			case 4: {
				if (danhSachBanDoc.getDanhSachBanDoc() == null) {
					System.out.println("Danh sách trống");
				} else {
					BanDoc[] list = danhSachBanDoc.getDanhSachBanDoc();
					int n = list.length;
					for (int i = 0; i < n; i++) {
						System.out.println(list[i].toString());

					}

				}
			}
				break;
			// them va hien thi quan ly muon sach
			case 5: {
				danhSachQLMuonSach = themMuonSach(sc, danhSachQLMuonSach, danhSachBanDoc, danhSachSach);
				danhSachQLMuonSach.hienThiThongTin();
			}
				break;
			// Sắp xếp danh sách Quản lý mượn sách
			case 6: {
				System.out.println("Chọn kiểu sắp xếp");
				System.out.println("1. Theo tên");
				System.out.println("2.Theo số lượng sách đã mượn");
				int chon = sc.nextInt();
				while (chon < 1 || chon > 2) {
					System.out.println("Vui lòng chọn lại");
					chon = sc.nextInt();
				}
				if (chon == 1) {
					if (danhSachQLMuonSach.getQlMuonSach() == null) {
						System.out.println("Danh sách quản lý trống\n");
						break;
					}
					danhSachQLMuonSach.sapXepTheoTen();
					danhSachQLMuonSach.hienThiThongTin();
				} else {
					danhSachQLMuonSach.sapXepTheoSoLuong();
					danhSachQLMuonSach.hienThiThongTin();
				}

			}
				break;
			// tim quan ly muon sach theo ten
			case 7: {
				if (danhSachQLMuonSach.getQlMuonSach() == null) {
					System.out.println("Danh sách quản lý trống\n");
					break;
				}
				System.out.println("Nhập tên:");
				sc.nextLine();
				String ten = sc.nextLine();
				QLMuonSach qlMuonSach = danhSachQLMuonSach.timQlSachTheoTen(ten);
				if (qlMuonSach == null) {
					System.out.println("Tên không tồn tại trong quản lý sách");
				} else {
					qlMuonSach.hienThiThongTin();
				}
			}
				break;

			}
		} while (luaChon != 0);

	}
  
	
	// them sach da muon vao ban doc
	private static DanhSachQLMuonSach themMuonSach(Scanner sc, DanhSachQLMuonSach danhSachQLMuonSach,
			DanhSachBanDoc danhSachBanDoc, DanhSachSach danhSachSach) {

		BanDoc[] banDoc = danhSachBanDoc.getDanhSachBanDoc();
		Sach[] sach = danhSachSach.getDanhSachSach();
		int banDocLength = banDoc.length;
		int sachLength = sach.length;
		if (danhSachQLMuonSach.getQlMuonSach() == null) {
			danhSachQLMuonSach = new DanhSachQLMuonSach(banDocLength);
		}
		// tao danh sach qua ly moi va gan lai phan tu
		if (danhSachQLMuonSach.getQlMuonSach().length < banDocLength) {
			int n = danhSachQLMuonSach.getQlMuonSach().length;
			DanhSachQLMuonSach danhSachCu = danhSachQLMuonSach;
			danhSachQLMuonSach = new DanhSachQLMuonSach(banDocLength);
			for (int i = 0; i < n; i++) {
				danhSachQLMuonSach.getQlMuonSach()[i] = danhSachCu.getQlMuonSach()[i];
			}
		}

		// truong hop khong co ban doc hoac khong co sach trong danh sach
		if (banDoc == null || sach == null) {
			System.out.println("Danh sách bạn đọc hoặc sách trống\n");
			return danhSachQLMuonSach;
		}

		// lap in va them sach cho tung ban doc
		for (int i = 0; i < banDocLength; i++) {
			System.out.println("Thêm sách cho bạn:" + banDoc[i].getHoTen());
//			QLMuonSach qlMuonSach = danhSachQLMuonSach.timQlSachTheoTen(banDoc[i].getHoTen());
//			if(qlMuonSach == null) {
			QLMuonSach qlMuonSach = new QLMuonSach();
			qlMuonSach.setBanDoc(banDoc[i]);
//			}

			System.out.println("Thêm sách nhấn 1, bỏ qua nhấn 0");
			int luaChon = sc.nextInt();

			while (luaChon != 0) {
				Order order = taoOrder(danhSachSach, sc);
				qlMuonSach.themOrder(order);
				System.out.println("kết thúc nhấn 0, tiếp tục thêm sách nhấn 1");
				luaChon = sc.nextInt();
			}
			danhSachQLMuonSach.themQlMuonSach(qlMuonSach);
		}
		return danhSachQLMuonSach;
	}

	private static Order taoOrder(DanhSachSach danhSachSach, Scanner sc) {
		System.out.println("Nhập tên sách");
		sc.nextLine();
		String tenSach = sc.nextLine();
		Sach sachTuTen = danhSachSach.getSachTheoTen(tenSach);
		// kiem tra lay đối tượng sách
		while (sachTuTen == null) {
			System.out.println("Tên sách không dúng");
			System.out.println("Nhập lại tên sách");
			tenSach = sc.nextLine();
			sachTuTen = danhSachSach.getSachTheoTen(tenSach);
		}
		System.out.println("Nhập tình trạng");
		String tinhTrang = sc.nextLine();
		System.out.println("Nhập số lượng");
		int soLuong = sc.nextInt();
		while (soLuong > 3 || soLuong <= 0) {
			System.out.println("Nhập lại số lượng");
			soLuong = sc.nextInt();
		}

		Order order = new Order(sachTuTen, soLuong, tinhTrang);
		return order;
	}

	// ----------------------end-------------------

	// them hien thi ban doc-----------
	private static DanhSachBanDoc nhapBanDoc(Scanner sc, DanhSachBanDoc danhSachBanDoc) {
		System.out.println("Số lượng bạn đọc muốn thêm: ");
		int soLuongSach = sc.nextInt();
		while (soLuongSach <= 0) {
			System.out.println("Nhập lại số lượng (số lượng > 0): ");
			soLuongSach = sc.nextInt();
		}
		// nhap vao danh sach sach
		BanDoc[] list = new BanDoc[soLuongSach];
		for (int i = 0; i < soLuongSach; i++) {
			list[i] = taoBanDoc(sc);
		}
		danhSachBanDoc.themDanhSach(list);

		return danhSachBanDoc;
	}

	private static BanDoc taoBanDoc(Scanner sc) {
		System.out.println("----------------------------\n");
		System.out.println("Nhập họ và tên : ");
		sc.nextLine();
		String ten = sc.nextLine();
		System.out.println("Nhập địa chỉ: ");
		String diaChi = sc.nextLine();
		System.out.println("Nhập loại bạn đọc: ");
		String laiBanDoc = sc.nextLine();
		System.out.println("Nhập số điện thoại: ");
		int soDienThoai = sc.nextInt();
		BanDoc banDoc = new BanDoc(ten, diaChi, soDienThoai, laiBanDoc);
		return banDoc;
	}

	// -----------------------end---------------

	// them va hien thi sach
	private static DanhSachSach nhapSachMoi(Scanner sc, DanhSachSach danhSachSach) {
		System.out.println("Số lượng sách muốn thêm: ");
		int soLuongSach = sc.nextInt();
		while (soLuongSach <= 0) {
			System.out.println("Nhập lại số lượng (số lượng > 0): ");
			soLuongSach = sc.nextInt();
		}
		// nhap vao danh sach sach
		Sach[] listSach = new Sach[soLuongSach];
		for (int i = 0; i < soLuongSach; i++) {
			listSach[i] = taoSach(sc);
		}
		danhSachSach.themDanhSach(listSach);

		return danhSachSach;
	}

	private static Sach taoSach(Scanner sc) {
		System.out.println("----------------------------\n");
		System.out.println("Nhập tên sách: ");
		sc.nextLine();
		String tenSach = sc.nextLine();
		System.out.println("Nhập tên tác giả: ");
		String tenTacGia = sc.nextLine();
		System.out.println("Nhập tên chuyên nghành: ");
		String tenChuyenNganh = sc.nextLine();
		System.out.println("Nhập năm xuất bản: ");
		int namXuatBan = sc.nextInt();
		Sach sach = new Sach(tenSach, tenTacGia, tenChuyenNganh, namXuatBan);
		return sach;
	}
	// --------------------end-----------------

}
