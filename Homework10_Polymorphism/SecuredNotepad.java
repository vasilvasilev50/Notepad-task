package Homework10_Polymorphism;

import java.util.Scanner;

public class SecuredNotepad extends Notepad implements ISecuredNotepad {

	Scanner sc = new Scanner(System.in);

	public static final String TYPE_OF_NOTEPAD = "SecuredNotepad";
	private final String password;

	SecuredNotepad(String password, int numberOfPages) throws PasswordNotStrongException {

		if (!isPasswordStrong(password) || password == null) {
			throw new PasswordNotStrongException("The password is not Strong!");
		}
		this.password = password;
		super.setNumberOfPages((numberOfPages > 0) ? numberOfPages : getStandartNumberOfPages());
		super.setPages(new Page[this.getNumberOfPages()]);
		for (int index = 0; index < super.getPages().length; index++) {
			getPages()[index] = new Page("Page " + (index + 1));
		}

	}

	private boolean isPasswordStrong(String password) {
		boolean hasPasswordCapitalLetter = false;
		boolean hasPasswordSmallLetter = false;
		boolean hasPasswordNumber = false;
		for (int index = 0; index < password.length(); index++) {
			if (password.charAt(index) >= 'A' && password.charAt(index) <= 'Z') {
				hasPasswordCapitalLetter = true;
			}
			if (password.charAt(index) >= 'a' && password.charAt(index) <= 'z') {
				hasPasswordSmallLetter = true;
			}
			if (password.charAt(index) >= '0' && password.charAt(index) <= '9') {
				hasPasswordNumber = true;
			}
		}
		if (hasPasswordCapitalLetter && hasPasswordSmallLetter && hasPasswordNumber) {
			return true;
		}
		return false;
	}

	@Override
	public void addTextToPage(int page, String text) {
		System.out.println("Enter password");
		if (passwordCheck()) {
			if (chekForExceptions(page, text)) {
				this.getPages()[page - 1].addText(text);
			}
		} else {
			System.out.println("Wrong password");
		}
	}

	@Override
	public void replaceTextInPageWith(int page, String text) {
		System.out.println("Enter password");
		if (passwordCheck()) {
			if (chekForExceptions(page, text)) {
				this.getPages()[page - 1].deleteText();
				this.getPages()[page - 1].addText(text);
			}
		} else {
			System.out.println("Wrong password");
		}
	}

	@Override
	public void deleteTextInPage(int page) {
		System.out.println("Enter password");
		if (passwordCheck()) {
			if (page > 0 && page <= super.getPages().length && !this.getPages()[page - 1].getText().equals("")) {
				this.getPages()[page - 1].deleteText();
			}
		} else {
			System.out.println("Wrong password");
		}
	}

	@Override
	public void reviewAllPages() {
		System.out.println("Enter password");
		if (passwordCheck()) {
			System.out.println(this.TYPE_OF_NOTEPAD);
			printAllPagesWithText();
		} else {
			System.out.println("Wrong password");
		}
	}

	private boolean passwordCheck() {
		return this.password.equals(sc.next());
	}

	@Override
	public boolean searchWord(String word) {
		System.out.println("Enter password");
		if (passwordCheck()) {
			if (word != null && word != "") {
				for (int index = 0; index < super.getPages().length; index++) {
					if (getPages()[index] != null) {
						if (getPages()[index].searchWord(word)) {
							return true;
						}
					}
				}
			}
			return false;
		} else {
			System.out.println("Wrong password");
		}
		return false;
	}

	@Override
	public void printAllPagesWithDigits() {
		System.out.println("Enter password");
		if (passwordCheck()) {
			for (int index = 0; index < getPages().length; index++) {
				if (getPages()[index] != null) {
					if (getPages()[index].containsDigits()) {
						System.out.println(getPages()[index].reviewPage());
					}
				}
			}
		} else {
			System.out.println("Wrong password");
		}
	}

}
