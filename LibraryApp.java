package Library;

import java.util.Scanner;

public class LibraryApp {
	public static void main(String[] args) {
		// set Category
		Category children = new Category();
		children.id = 1;
		children.category = "Children";

		Category cookbook = new Category();
		cookbook.id = 2;
		cookbook.category = "Cookbooks, Food & Wine";

		// set Book
		Book harryCook = new Book();
		harryCook.id = 1;
		harryCook.title = "The Official Harry Potter Baking Book";
		harryCook.author = "Joanna Farrow";
		harryCook.ISBN = "978-1338285260";

		Book theCat = new Book();
		theCat.id = 2;
		theCat.title = "Pete the Cat: I Love My White Shoes";
		theCat.author = "Eric Litwin";
		theCat.ISBN = "978-0061906220";

		// set book-category
		CategoryOfBook bookCat1 = new CategoryOfBook();
		bookCat1.id = 1;
		bookCat1.book = harryCook;
		bookCat1.category = children;

		CategoryOfBook bookCat2 = new CategoryOfBook();
		bookCat2.id = 2;
		bookCat2.book = harryCook;
		bookCat2.category = cookbook;

		CategoryOfBook bookCat3 = new CategoryOfBook();
		bookCat3.id = 2;
		bookCat3.book = theCat;
		bookCat3.category = children;

		// set location
		Location hanoi = new Location();
		hanoi.id = 1;
		hanoi.address = "Lieu Giai";
		hanoi.name = "Nha sach Ha Noi";

		Location hcm = new Location();
		hcm.id = 1;
		hcm.address = "HCM Q1";
		hcm.name = "Nha sach Sai Gon";

		// set stock
		StockInLocation harryCookInHanoi = new StockInLocation();
		harryCookInHanoi.id = 1;
		harryCookInHanoi.book = harryCook;
		harryCookInHanoi.location = hanoi;
		harryCookInHanoi.quantity = 15;

		StockInLocation harryCookInHcm = new StockInLocation();
		harryCookInHcm.id = 2;
		harryCookInHcm.book = harryCook;
		harryCookInHcm.location = hcm;
		harryCookInHcm.quantity = 10;

		StockInLocation theCatInHanoi = new StockInLocation();
		theCatInHanoi.id = 3;
		theCatInHanoi.book = theCat;
		theCatInHanoi.location = hanoi;
		theCatInHanoi.quantity = 50;

		StockInLocation theCatInHcm = new StockInLocation();
		theCatInHcm.id = 3;
		theCatInHcm.book = theCat;
		theCatInHcm.location = hanoi;
		theCatInHcm.quantity = 20;

		StockInLocation[] stockInLocations = { harryCookInHanoi, harryCookInHcm, theCatInHanoi, theCatInHcm };

		// set customer
		Customer yen = new Customer();
		yen.id = 1;
		yen.name = "pham thi yen";
		yen.setEmail("maiiyenpham@gmail.com");
		yen.setTel("0377123456");

		Customer hoa = new Customer();
		hoa.id = 2;
		hoa.name = "nguyen thieu hoa";
		hoa.setEmail("hoantt@toyota.com");
		hoa.setTel("0987654321");

		Customer hong = new Customer();
		hong.id = 3;
		hong.name = "nguyen thu hong";
		hong.setEmail("hongnt@toyota.com");
		hong.setTel("0987123456");

		// Book stt: book-location-customer
		BookStatus stt1 = new BookStatus();
		stt1.id = 1;
		stt1.book = harryCook;
		stt1.location = hanoi;
		stt1.customer = yen;
		stt1.borrowDate = "20/4/2023";

		BookStatus stt2 = new BookStatus();
		stt2.id = 2;
		stt2.book = harryCook;
		stt2.location = hanoi;
		stt2.customer = hoa;
		stt2.borrowDate = "25/3/2023";
		stt2.returnDate = "23/4/2023";

		BookStatus stt3 = new BookStatus();
		stt3.id = 3;
		stt3.book = harryCook;
		stt3.location = hcm;
		stt3.customer = hong;
		stt3.borrowDate = "22/4/2023";

		BookStatus stt4 = new BookStatus();
		stt4.id = 4;
		stt4.book = theCat;
		stt4.location = hanoi;
		stt4.customer = yen;
		stt4.borrowDate = "25/2/2023";

		BookStatus stt5 = new BookStatus();
		stt5.id = 5;
		stt5.book = theCat;
		stt5.location = hcm;
		stt5.customer = hoa;
		stt5.borrowDate = "01/3/2023";
		stt5.returnDate = "09/4/2023";

		BookStatus stt6 = new BookStatus();
		stt6.id = 6;
		stt6.book = theCat;
		stt6.location = hcm;
		stt6.customer = hong;
		stt6.borrowDate = "10/4/2023";
		stt6.returnDate = "15/4/2023";

		BookStatus[] bookstts = { stt1, stt2, stt3, stt4, stt5, stt6 };

		printBorrowList(bookstts);
		printBorrowReturnList(bookstts, stockInLocations);
	}

	// Print borrow list
	public static void printBorrowList(BookStatus[] bookstts) {
		for (BookStatus bookstt : bookstts) {
			System.out.println("Book name: " + bookstt.book.title + " - Location: " + bookstt.location.name);
			System.out.println("Borrow date: " + bookstt.borrowDate);
			if (bookstt.returnDate == null) {
				System.out.println("Book is not return");
			} else
				System.out.println("Return date: " + bookstt.returnDate);
			System.out.println("---------------------------------------");
		}
	}

	// Print borrow & return for each book scanned
	public static void printBorrowReturnList(BookStatus[] bookstts, StockInLocation[] stockInLocations) {
		Scanner searchBook = new Scanner(System.in);
		System.out.println("Please input book title: ");
		String inputBook = searchBook.nextLine();

		// stock remain
		int totalQuantity = 0;
		for (StockInLocation stock : stockInLocations) {
			if (stock.book.title.equals(inputBook))
				totalQuantity = totalQuantity + stock.quantity;
		}

		int borrowedQty = 0;
		for (BookStatus bookstt : bookstts) {
			if (bookstt.book.title.equals(inputBook) && bookstt.returnDate == null) {
				borrowedQty += 1;
			}
		}
		int stockRemain = totalQuantity - borrowedQty;
		System.out.println("Available for borrow: " + stockRemain);

		// print
		for (BookStatus bookstt : bookstts) {
			if (bookstt.book.title.equals(inputBook)) {
				System.out.println("Borrowed by : " + bookstt.customer.name);
				System.out.println("Borrow date: " + bookstt.borrowDate);
				if (bookstt.returnDate == null) {
					System.out.println("Book is not return");
				} else
					System.out.println("Return date:" + bookstt.returnDate);
				System.out.println("---------------------------------------");
			}
		}
	}
}
