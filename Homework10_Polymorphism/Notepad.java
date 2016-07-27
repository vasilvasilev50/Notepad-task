package Homework10_Polymorphism;

public abstract class Notepad implements INotepad {
	
	private static final int STANDART_NUMBER_OF_PAGES = 30;
	private int numberOfPages;
	private Page [] pages;
	
	protected boolean chekForExceptions(int page, String text) {
		return page > 0 && page <= pages.length && text != null && text != "";
	}

	protected void printAllPagesWithText() {
		for (Page page : pages){
			if (!page.getText().equals("")) {
				System.out.println(page.reviewPage());
			}
		}
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Page[] getPages() {
		return pages;
	}

	public void setPages(Page[] pages) {
		this.pages = pages;
	}

	public static int getStandartNumberOfPages() {
		return STANDART_NUMBER_OF_PAGES;
	}
}
