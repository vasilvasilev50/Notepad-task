package Homework10_Polymorphism;

public class Page {

	private String title;
	private String text;

	Page(String title) {
		this.title = title;
		this.text = "";
	}

	void addText(String text) {
		this.text += text;
	}

	void deleteText() {
		this.text = "";
	}

	String reviewPage() {
		return this.title + '\n' + this.text;
	}

	boolean searchWord(String word) {
		if (word != null && word != "") {
			return this.text.contains(word);
		}
		return false;
	}

	boolean containsDigits() {
		if (text != null && text != "") {
			for (int index = 0; index < text.length(); index++) {
				if (text.charAt(index) >= '0' && text.charAt(index) <= '9') {
					return true;
				}
			}
		}
		return false;
	}

	String getText() {
		return text;
	}
}
