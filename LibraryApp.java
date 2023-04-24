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
		BookStatus sttHarryCookinHanoi1 = new BookStatus();
		sttHarryCookinHanoi1.bookInLocation = harryCookInHanoi;
		sttHarryCookinHanoi1.customer = yen;
		sttHarryCookinHanoi1.borrowDate = "20/4/2023";

		BookStatus sttHarryCookinHanoi2 = new BookStatus();
		sttHarryCookinHanoi2.bookInLocation = harryCookInHanoi;
		sttHarryCookinHanoi2.customer = hoa;
		sttHarryCookinHanoi2.borrowDate = "25/3/2023";
		sttHarryCookinHanoi2.returnDate = "23/4/2023";

		BookStatus sttHarryCookinHcm1 = new BookStatus();
		sttHarryCookinHcm1.bookInLocation = harryCookInHcm;
		sttHarryCookinHcm1.customer = hong;
		sttHarryCookinHcm1.borrowDate = "22/4/2023";

		BookStatus sttTheCatinHanoi1 = new BookStatus();
		sttTheCatinHanoi1.bookInLocation = theCatInHanoi;
		sttTheCatinHanoi1.customer = yen;
		sttTheCatinHanoi1.borrowDate = "25/2/2023";

		BookStatus sttTheCatinHcm1 = new BookStatus();
		sttTheCatinHcm1.bookInLocation = theCatInHcm;
		sttTheCatinHcm1.customer = hoa;
		sttTheCatinHcm1.borrowDate = "01/3/2023";
		sttTheCatinHcm1.returnDate = "09/4/2023";

		BookStatus sttTheCatinHcm2 = new BookStatus();
		sttTheCatinHcm2.bookInLocation = theCatInHcm;
		sttTheCatinHcm2.customer = hong;
		sttTheCatinHcm2.borrowDate = "10/4/2023";
		sttTheCatinHcm2.returnDate = "15/4/2023";

		BookStatus[] bookstts = { sttHarryCookinHanoi1, sttHarryCookinHanoi2, sttHarryCookinHcm1, sttTheCatinHanoi1,
				sttTheCatinHcm1, sttTheCatinHcm2 };

		// Print borrow list
		System.out.println("Books borrowed list:");
		for (BookStatus bookstt : bookstts) {
			System.out.println(" - " + bookstt.bookInLocation.book.title + " - " + bookstt.customer.name + " - "
					+ "Borrow date: " + bookstt.borrowDate);
		}
		System.out.println("--------------");

		// Scanner 1 book --> show borrow/return status of the book
		// Input any book title:
		Scanner searchBook = new Scanner(System.in);
		System.out.println("Please input book title: ");
		String inputBook = searchBook.nextLine();
		System.out.println("Status of '" + inputBook + "' is as bellow:");
		searchBook.close();

		// Total quantity of Book
		int totalQuantity = 0;
		for (StockInLocation stock : stockInLocations) {
			if (stock.book.title.equals(inputBook))
				totalQuantity = totalQuantity + stock.quantity;
		}

		// check how many units in borrowed status
		int borrowedQty = 0;
		for (BookStatus bookstt : bookstts) {
			if (bookstt.bookInLocation.book.title.equals(inputBook) && bookstt.returnDate == null) {
				borrowedQty += 1;
			}
		}
		int stockRemain = totalQuantity - borrowedQty;
		System.out.println("- Available for borrow: " + stockRemain);

		for (BookStatus bookstt : bookstts) {
			if (bookstt.bookInLocation.book.title.equals(inputBook)) { // k dung dc == input
				System.out.println(" - Borrow Date: " + bookstt.borrowDate + " - by " + bookstt.customer.name
						+ " - Return Date: " + bookstt.returnDate);
			}

		}

	}
}