package test;

import model.Sach;

public class DanhSachSach {
	private Sach[] danhSachSach;

	public DanhSachSach() {

	}
	
	public Sach[] getDanhSachSach() {
		return danhSachSach;
	}

	public void setDanhSachSach(Sach[] danhSachSach) {
		this.danhSachSach = danhSachSach;
	}
	
	public void themDanhSach(Sach[] listSach) {
	  if(this.danhSachSach == null) {
		  this.danhSachSach = listSach;
	  }else {
		  int lenghtDanhSachSach = this.danhSachSach.length;
		  int leghtListSach = listSach.length;
		  int lenghtTong = lenghtDanhSachSach + leghtListSach;
		  Sach[] danhSachMoi = new Sach[lenghtTong];
		  int n = 0;
		  int m = 0;
		  boolean ckeckDanhSach1 = true;
		  boolean  ckeckDanhSach2 = true;
           int trungGian = lenghtDanhSachSach;
		  while(ckeckDanhSach1 || ckeckDanhSach2) {
			  if(n == lenghtDanhSachSach) {
				  ckeckDanhSach1 = false;
			  }else {
				  danhSachMoi[n] = this.danhSachSach[n];
				  n++;
			  }
			  
			  if(m == leghtListSach) {
				  ckeckDanhSach2 = false;
			  }else {
				  danhSachMoi[trungGian] = listSach[m];
				  m++;
				  trungGian++;
			  }
			  
			  
		  }
		  
		  this.danhSachSach = danhSachMoi;
	  }
		
	}
	
	public boolean kiemTraSachDaTonTai(Sach sach) {
		
		int lengt = this.danhSachSach.length;
		for (int i = 0; i < lengt; i++) {
			if(this.danhSachSach[i].equals(sach)) {
				return false;
			}
		}
		return true;
		
	}

	public Sach getSachTheoTen(String ten) {
		int n = this.danhSachSach.length;
		for (int i = 0; i < n; i++) {
			if(this.danhSachSach[i].getTenSach().equalsIgnoreCase(ten)){
				return this.danhSachSach[i];
			}
		}
		
		
		
		return null;
	}
	
}
