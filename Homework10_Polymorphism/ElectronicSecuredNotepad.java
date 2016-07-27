package Homework10_Polymorphism;

public class ElectronicSecuredNotepad extends SecuredNotepad implements IÅlectronicDevice  {
	
	public static final String TYPE_OF_NOTEPAD = "SecuredNotepad";
	private boolean isStarted;

	ElectronicSecuredNotepad(String password, int numberOfPages) throws PasswordNotStrongException {
		super(password, numberOfPages);
	}
	

	@Override
	public void start() {
		this.isStarted = true;
	}

	@Override
	public void stop() {
		this.isStarted = false;
	}

	@Override
	public boolean isStarted() {
		return this.isStarted;
	}

	@Override
	public void addTextToPage(int page, String text) {
		if (isStarted()) {
			super.addTextToPage(page, text);
		} else {
			System.out.println("The device is not switch on");
		}
	}

	@Override
	public void replaceTextInPageWith(int page, String text) {
		if (isStarted()) {
		super.replaceTextInPageWith(page, text);
		} else {
			System.out.println("The device is not switch on");
		}
	}
	
	@Override
	public void deleteTextInPage(int page) {
		if (isStarted()) {
		super.deleteTextInPage(page);
		} else {
			System.out.println("The device is not switch on");
		}
	}
	
	@Override
	public void reviewAllPages() {
		if (isStarted()) {
		super.reviewAllPages();
		} else {
			System.out.println("The device is not switch on");
		}
	}
	
	@Override
	public boolean searchWord(String word) {
		if (isStarted()) {
		return super.searchWord(word);
		} else {
			System.out.println("The device is not switch on");
		}
		return false;
	}
	
	@Override
	public void printAllPagesWithDigits() {
		if (isStarted()) {
		super.printAllPagesWithDigits();
		} else {
			System.out.println("The device is not switch on");
		}
	}
}
