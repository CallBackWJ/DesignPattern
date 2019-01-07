package state;

public class Blind implements UnitState {

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		System.out.println("공격 가능");
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		System.out.println("이동 가능 시야 1");
	}

}
