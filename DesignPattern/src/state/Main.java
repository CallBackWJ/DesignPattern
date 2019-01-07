package state;

public class Main {
	
	public static void main(String[] args) {

		SiegeTank tank1 = new SiegeTank(new NormalState());
		tank1.Attack();
		tank1.Move();
		System.out.println("");
		
		tank1.Attacked("Medic Blind");
		tank1.Attack();
		tank1.Move();
		System.out.println("");

		tank1.Attacked("Ghost LockDown");
		tank1.Attack();
		tank1.Move();
		System.out.println("");
		
		
	}
}
