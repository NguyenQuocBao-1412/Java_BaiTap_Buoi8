import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, chon, result;		
		n = nhapN();
		
		int[] arr = new int[n];
		arr = nhapMang(n);
		xuatMang(arr, n);
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.println("\n=====Menu=====");
			System.out.println("1: Tính tổng các số dương.");
			System.out.println("2: Tính tổng các số lẻ.");
			System.out.println("3: Đếm có bao nhiêu số dương.");
			System.out.println("4: Tìm số nhỏ nhất trong mảng.");
			System.out.println("5: Tìm số dương nhỏ nhất trong mảng.");
			System.out.println("6: Tìm số chẳn cuối cùng.");
			System.out.println("7: Tìm số chẳn đầu tiên.");
			System.out.println("8: Tìm số nguyên tố đầu tiền.");
			System.out.println("9: Tìm số dương cuối cùng trong mảng.");
			System.out.println("10: Tìm giá trị chẳn nhỏ nhất trong mảng.");
			System.out.println("Khác 1 ~ 10: Kết thúc!");
			System.out.print("\nMời nhập chức năng: ");
			chon = scan.nextInt();
			
			switch(chon) {
				case 1: tinhTongCacSoDuong(arr, n);
					break;
				case 2: tinhTongCacSoLe(arr, n);
					break;
				case 3: demSoDuong(arr, n);
					break;
				case 4: timSoNhoNhat(arr, n);
					break;
				case 5: timSoDuongNhoNhat(arr, n);
					break;
				case 6: 
					result = timSoChanCuoiCung(arr, n);
					if(result != -1)
						System.out.println("Số chẳn cuối cùng là " + result);
					else
						System.out.println("Không có số chẳn trong mảng.");
					break;
				case 7: 
					result = timSoChanDauTien(arr, n);
					if(result != -1)
						System.out.println("Số chẳn đầu tiên là " + result);
					else
						System.out.println("Không có số chẳn trong mảng.");
					break;
				case 8: 
					result = timSoNguyenToDauTien(arr, n);
					if(result != -1)
						System.out.println("Số nguyên tố đầu tiên là " + result);
					else
						System.out.println("Không có số nguyên tố trong mảng.");
					break;
				case 9:
					result = timSoDuongCuoiCung(arr, n);
					if(result != -1)
						System.out.println("Số dương cuối cùng là " + result);
					else
						System.out.println("Không có số dương trong mảng.");
					break;
				case 10:
					result = timSoChanNhoNhat(arr, n);
					if(result != -1)
						System.out.println("Số chẳn nhỏ nhất là " + result);
					else
						System.out.println("Không có số chẳn trong mảng.");
					break;
			}
		} while(chon > 0 && chon < 11);
		
		System.out.println("\n=====End=====");
	}
	
	public static int nhapN() {
		int n;
		Scanner scan = new Scanner(System.in);
		
		do {
			System.out.print("Mời bạn nhập số phần tử cho mảng (n > 0): ");
			n = scan.nextInt();
			
			if(n <= 0)
				System.out.println("Số phần tử chưa hợp lệ. Mời bạn nhập lại!");
		} while(n <= 0);
		
		return n;
	}
	
	public static int[] nhapMang(int n) {
		int[] arr = new int[n];
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Mời bạn nhập mảng!");
		for (int i = 0; i < n; i++) {
			System.out.print("arr[" + i + "] = ");
			arr[i] = scan.nextInt();
		}
		
		return arr;
	}
	
	public static void xuatMang(int[] arr, int n) {
		System.out.println("Mang ban vua nhap la:");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "    ");			
		}
	}
	
	public static void tinhTongCacSoDuong(int[] arr, int n) {
		int tong = 0;
		
		for (int i = 0; i < n; i++) {
			if(arr[i] > 0)
				tong += arr[i];
		}
		System.out.println("Tổng các số dương = " + tong);
	}

	public static void tinhTongCacSoLe(int[] arr, int n) {
		int tong = 0;
		
		for (int i = 0; i < n; i++) {
			if(Math.abs(arr[i]) % 2 == 1)
				tong += arr[i];
		}
		System.out.println("Tổng các số lẻ = " + tong);
	}
	
	public static void demSoDuong(int[] arr, int n) {
		int dem = 0;
		
		for (int i = 0; i < n; i++) {
			if(arr[i] > 0)
				dem++;
		}
		System.out.println("Có " + dem + " số dương trong mảng");
	}
	
	public static void timSoNhoNhat(int[] arr, int n) {
		int min = arr[0];
	   
	    for (int i = 1; i < n; i++) {
	    	min = Math.min(min, arr[i]);
	    }
	    System.out.println("Giá trị nhỏ nhất là: " + min);
	}
	
	public static void timSoDuongNhoNhat(int[] arr, int n) {
		int min = 0;
		boolean coSoDuong = false, soDuongDauTien = true;
	   
	    for (int i = 0; i < n; i++) {
	    	if(arr[i] > 0) {
	    		if(soDuongDauTien) {
	    			min = arr[i];
	    			soDuongDauTien = false;
	    		}
	    		else
	    			min = Math.min(min, arr[i]);
	    		
	    		coSoDuong = true;
	    	}
	    }
	    
	    if(coSoDuong)
	    	System.out.println("Giá trị dương nhỏ nhất là: " + min);
	    else
	    	System.out.println("Không có số dương trong mảng!");
	}
	
	public static int timSoChanCuoiCung(int[] arr, int n) {
		int result = -1;
		
		for (int i = n - 1; i >= 0; i--) {
			if(arr[i] % 2 == 0) {
				return arr[i];
			}
		}
		
		return result;
	}
	
	public static int timSoChanDauTien(int[] arr, int n) {
		int result = -1;
		
		for (int i = 0; i < n; i++) {
			if(arr[i] % 2 == 0) {
				return arr[i];
			}
		}
		
		return result;
	}
	
	public static int timSoNguyenToDauTien(int[] arr, int n) {
		int result = -1;
		
		for (int i = 0; i < n; i++) {
			if(ktraSoNguyenTo(arr[i])) {
				return arr[i];
			}
		}
		
		return result;
	}
	
	public static boolean ktraSoNguyenTo(int n) {
		if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
	}
	
	public static int timSoDuongCuoiCung(int[] arr, int n) {
		int result = -1;
		
		for (int i = n - 1; i >= 0; i--) {
			if(arr[i] > 0) {
				return arr[i];
			}
		}
		
		return result;
	}
	
	public static int timSoChanNhoNhat(int[] arr, int n) {
		int min = timSoChanDauTien(arr, n);
		
		if(min != -1) {
			for (int i = 0; i < n; i++) {
				if(arr[i] % 2 == 0)
					min = Math.min(min, arr[i]);
			}
		}
		else
			return -1;
	   
	    
	    return min;
	}
}
