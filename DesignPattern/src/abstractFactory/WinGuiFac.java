package abstractFactory;

public class WinGuiFac implements GuiFac{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new WinButton();
	}

	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new WinTextArea();
	}
	

}
