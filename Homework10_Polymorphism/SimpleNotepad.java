package Homework10_Polymorphism;

public class SimpleNotepad extends Notepad {

	public static final String TYPE_OF_NOTEPAD = "SimpleNotepad";

	SimpleNotepad(int numberOfPages) {
		super.setNumberOfPages((numberOfPages > 0) ? numberOfPages : getStandartNumberOfPages());
		super.setPages(new Page[this.getNumberOfPages()]);
		for (int index = 0; index < super.getPages().length; index++) {
			getPages()[index] = new Page("Page " + (index + 1));
		}
	}

	@Override
	public void addTextToPage(int page, String text) {
		if (chekForExceptions(page, text)) {
			this.getPages()[page - 1].addText(text);
		}
	}

	@Override
	public void replaceTextInPageWith(int page, String text) {
		if (chekForExceptions(page, text)) {
			this.getPages()[page - 1].deleteText();
			this.getPages()[page - 1].addText(text);
		}
	}

	@Override
	public void deleteTextInPage(int page) {
		if (page > 0 && page <= super.getPages().length && !this.getPages()[page - 1].getText().equals("")) {
			this.getPages()[page - 1].deleteText();
		}
	}

	@Override
	public void reviewAllPages() {
		System.out.println(this.TYPE_OF_NOTEPAD);
		printAllPagesWithText();
	}

	@Override
	public boolean searchWord(String word) {
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
	}

	@Override
	public void printAllPagesWithDigits() {
		System.out.println("All pages with digits:");
		for (int index = 0; index < getPages().length; index++) {
			if (getPages()[index] != null) {
				if (getPages()[index].containsDigits()) {
					System.out.println(getPages()[index].reviewPage());
				}
			}
		}
	}

}
