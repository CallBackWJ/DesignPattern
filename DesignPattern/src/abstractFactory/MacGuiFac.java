package abstractFactory;

public class MacGuiFac implements GuiFac{

	@Override
	public Button createButton() {
		// TODO Auto-generated method stub
		return new MacButton();
	}

	@Override
	public TextArea createTextArea() {
		// TODO Auto-generated method stub
		return new MacTextArea();
	}
	

}
