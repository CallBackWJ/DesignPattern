package abstractFactory;

public class Main {

	public static void main(String[] args) {
		GuiFac fac=new WinGuiFac();
		Button button=fac.createButton();
		TextArea area=fac.createTextArea();
		
		button.click();
		System.out.println(area.getText());
		
	}
}
