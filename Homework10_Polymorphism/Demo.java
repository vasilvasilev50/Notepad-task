package Homework10_Polymorphism;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.xml.crypto.dsig.spec.SignatureMethodParameterSpec;

public class Demo {

	public static void main(String[] args) {
		
		String word = "page";

		 Page page = new Page ("Page1");
		 page.addText("some text");
		 System.out.println(page.reviewPage());
		
		 INotepad simpleNotepad = new SimpleNotepad(10);
		 simpleNotepad.addTextToPage(1, "Text in first page");
		 simpleNotepad.addTextToPage(1, " some more text");
		 simpleNotepad.addTextToPage(3, "Text in page three");
		 simpleNotepad.addTextToPage(6, "Text in page 6");
		 simpleNotepad.replaceTextInPageWith(6, "New text in page 6");
		 simpleNotepad.reviewAllPages();
		 simpleNotepad.deleteTextInPage(1);
		 System.out.println();
		 simpleNotepad.reviewAllPages();
		
		 System.out.println();
		
		 System.out.println("Contains word \"" + word + "\" - " +
		 simpleNotepad.searchWord(word));
		 System.out.println("Pages with digits: ");
		 simpleNotepad.printAllPagesWithDigits();
		
		
		try {
			ISecuredNotepad securedNotepad = new SecuredNotepad("Password!", 10);
			securedNotepad.addTextToPage(1, "Text in first page in secured notepad");
			securedNotepad.replaceTextInPageWith(3, "New text in page 3 in secured notepad");
			securedNotepad.reviewAllPages();

			System.out.println("Contains word \"" + word + "\" - " + securedNotepad.searchWord(word));
			System.out.println("Pages with digits: ");
			securedNotepad.printAllPagesWithDigits();
		} catch (PasswordNotStrongException e) {
			System.out.println("The password is not Strong!");
			e.printStackTrace();
		}

		try {
			IÅlectronicDevice electronicSecuredNotepad = new ElectronicSecuredNotepad("Test1?", 10);
			electronicSecuredNotepad.start();
			electronicSecuredNotepad.addTextToPage(2, "This is the first text in electronic secured notepad");
			electronicSecuredNotepad.addTextToPage(4, "This is a text with digits: 123");
			electronicSecuredNotepad.reviewAllPages();
			System.out.println("Contains word \"" + word + "\" - " + electronicSecuredNotepad.searchWord(word));
			System.out.println("Pages with digits: ");
			electronicSecuredNotepad.printAllPagesWithDigits();
		} catch (PasswordNotStrongException e) {
			System.out.println("The password is not Strong!");
			e.printStackTrace();
		}

	}

}
