package state;

public class LockDown implements UnitState {

	@Override
	public void Attack() {
		// TODO Auto-generated method stub
		System.out.println("공격 불가!!!");
	}

	@Override
	public void Move() {
		// TODO Auto-generated method stub
		System.out.println("이동 불가!!!");
	}

}
