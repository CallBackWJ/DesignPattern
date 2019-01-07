package state;

public class SiegeTank {

	private UnitState state;
	
	public SiegeTank(UnitState state)
	{
		this.state=state;
	}
	public void Attacked(String _StateAttack)
	{
		switch (_StateAttack)//자바7부터는 primitive(원시)type 이외에도 String도 비교가능 
		{
		case "Medic Blind":
			System.out.println("메딕에게 블라인드 상태이상 공격을 받음");
			this.state=new Blind();
			break;
		case "Ghost LockDown":
			System.out.println("고스트에게 락다운 상태이상 공격을 받음");
			this.state=new LockDown();
			break;
		default :break;
		
		}
	}

	public void Attack() {
		state.Attack();
	}

	public void Move() {
		state.Move();
	}
	
}
