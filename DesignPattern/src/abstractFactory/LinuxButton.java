package abstractFactory;

public class LinuxButton implements Button {

	@Override
	public void click() {
		// TODO Auto-generated method stub
		System.out.println(getClass()+"에서 클릭했습니다.");
	}

}
