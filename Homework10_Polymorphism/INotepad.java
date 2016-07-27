package Homework10_Polymorphism;

public interface INotepad {

	void addTextToPage(int page, String text);

	void replaceTextInPageWith(int page, String text);

	void deleteTextInPage(int page);

	void reviewAllPages();

	boolean searchWord(String word);

	void printAllPagesWithDigits();
	
}
