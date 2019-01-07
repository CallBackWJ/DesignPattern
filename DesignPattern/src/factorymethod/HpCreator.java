package factorymethod;

import java.util.Date;

public class HpCreator extends ItemCreator{

	@Override
	protected void requestItemInfo() {
		// TODO Auto-generated method stub
		System.out.println("데이터베이스에서 체력물약에 대한 정보를 가져옵니다.");
		
	}

	@Override
	protected void createItemLog() {
		// TODO Auto-generated method stub
		System.out.println("체력 회복 물약을 새로 생성 했습니다."+new Date());
		
	}

	@Override
	protected Item createItem() {
		// TODO Auto-generated method stub
		return new HpPotion();
	}

}
