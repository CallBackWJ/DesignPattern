package factorymethod;

public abstract class ItemCreator {
	
	public Item create()
	{
		Item item;
		requestItemInfo();//step 1 
		item=createItem();//step2
		createItemLog();//step3
		return item;
	}

	//아이템을 생성하기 전에 데이터베이스에서 아이템정보를 요청합니다.
	abstract protected void requestItemInfo();
	//아이템을 생성후 아이템 복제등의 불법을 방지하기 위해 로그를 남깁니다.
	abstract protected void createItemLog();
	//아이템을 생성하는 알고리즘
	abstract protected Item createItem();
	
	
}
