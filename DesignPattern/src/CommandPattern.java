
class Fan {
	String[] state = { "정지", "미풍", "약풍", "강풍" };
	int mode = 0;

	public void setStop() {
		mode = 0;
		printState();
	}

	public void setPower1() {
		mode = 1;
		printState();
	}

	public void setPower2() {
		mode = 2;
		printState();
	}

	public void setPower3() {
		mode = 3;
		printState();
	}

	public int getMode() {
		return mode;
	}

	public void printState() {
		System.out.println("현재 상태는 " + state[mode] + "입니다.");
	}

}

class StopComand implements Command {
	Fan f;
	int prevState;

	public StopComand(Fan f) {
		this.f = f;
	}

	@Override
	public void excute() {
		prevState = f.getMode();
		f.setStop();
	}

	@Override
	public void undo() {

		switch (prevState) {
		case 0:
			f.setStop();
			break;
		case 1:
			f.setPower1();
			break;
		case 2:
			f.setPower2();
			break;
		case 3:
			f.setPower3();
			break;
		}

	}

}

class Power1 implements Command {

	Fan f;
	int prevState;

	public Power1(Fan f) {

		this.f = f;
	}

	@Override
	public void excute() {
		prevState = f.getMode();
		f.setPower1();

	}

	@Override
	public void undo() {

		switch (prevState) {
		case 0:
			f.setStop();
			break;
		case 1:
			f.setPower1();
			break;
		case 2:
			f.setPower2();
			break;
		case 3:
			f.setPower3();
			break;
		}

	}

}

class Power2 implements Command {
	Fan f;
	int prevState;

	public Power2(Fan f) {
		this.f = f;
	}

	@Override
	public void excute() {
		prevState = f.getMode();
		f.setPower2();

	}

	@Override
	public void undo() {

		switch (prevState) {
		case 0:
			f.setStop();
			break;
		case 1:
			f.setPower1();
			break;
		case 2:
			f.setPower2();
			break;
		case 3:
			f.setPower3();
			break;
		}

	}
}

class Power3 implements Command {
	Fan f;
	int prevState;

	public Power3(Fan f) {
		this.f = f;
	}

	@Override
	public void excute() {
		prevState = f.getMode();
		f.setPower3();

	}

	@Override
	public void undo() {

		switch (prevState) {
		case 0:
			f.setStop();
			break;
		case 1:
			f.setPower1();
			break;
		case 2:
			f.setPower2();
			break;
		case 3:
			f.setPower3();
			break;
		}

	}
}

class NoCommand implements Command {

	@Override
	public void excute() {
		System.out.println("비어있는 버튼입니다.");
	}

	@Override
	public void undo() {

	}

}

class RemoteControl {
	Command[] commands;
	Command undoCommand;

	public RemoteControl() {
		commands = new Command[4];
		NoCommand n = new NoCommand();
		for (int i = 0; i < 4; i++)
			commands[i] = n;
		undoCommand = n;
	}

	public void setCommand(int slot, Command c) {
		commands[slot] = c;
	}

	public void ButtonWasPushed(int slot) {
		commands[slot].excute();
		undoCommand = commands[slot];
	}

	public void UndoButtonWasPushed() {
		undoCommand.undo();
	}

}

public class CommandPattern {
	public static void main(String[] args) {

		RemoteControl r = new RemoteControl();
		Fan f = new Fan();
		StopComand stc = new StopComand(f);
		Power1 p1c = new Power1(f);
		Power2 p2c = new Power2(f);
		Power3 p3c = new Power3(f);

		r.setCommand(0, stc);
		r.setCommand(1, p1c);
		r.setCommand(2, p2c);
		r.setCommand(3, p3c);

		r.ButtonWasPushed(0);
		r.ButtonWasPushed(1);
		
		r.UndoButtonWasPushed();
		
		r.ButtonWasPushed(2);
		r.ButtonWasPushed(3);
		
		r.UndoButtonWasPushed();

	}

}
