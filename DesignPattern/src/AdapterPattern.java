


interface chicken
{
	
	public String getMeet();
	public void getName();
	public int getWeight();
}

class Koreanchicken implements chicken
{
	
	int weight;
	
	public Koreanchicken(int weight) {
		// TODO Auto-generated constructor stub
		this.weight=weight;
	}
	
	@Override
	public String getMeet() {
		
		int grade=0;
		
		switch(weight/10)
		{
		case 6:grade=4; break;
		case 4:grade=3;break;
		case 2:grade=2;break;
		default: grade=1;
		
		}
		
		return "이 닭은 "+grade+"호닭 입니다.";
	}

	@Override
	public void getName() {
		
		System.out.println("꼬꼬댁 꼬꼬꼬");
	}

	@Override
	public int getWeight() {
		
		return weight;
	}
	
}

interface pigeon
{
	public int getWeight();
	public void getName();
}



class YongdosanPigeon implements pigeon
{
	int weight;

	public YongdosanPigeon(int w) {
		weight = w;
	}
	@Override
	public int getWeight() {
	
		return weight;
	}
	@Override
	public void getName() {
	
		System.out.println("피~~~~~~죤~~~~~~");
	}
	
}

class MeetFactory
{
	public void makeMeet(chicken c)
	{
		System.out.println(c.getMeet());
		c.getName();
	}
	
}


class pigeonAdapter implements chicken
{
	
	pigeon p;
	
	public pigeonAdapter(pigeon p) 
	{
		this.p=p;
	}

	@Override
	public String getMeet() {
		int grade=0;
		
		switch(p.getWeight()/10)
		{
		case 6:grade=4; break;
		case 4:grade=3;break;
		case 2:grade=2;break;
		default: grade=1;
		
		}
		
		return "이 닭은 "+grade+"호닭 입니다.";
	}

	@Override
	public void getName() {
		// TODO Auto-generated method stub
		p.getName();
	}

	@Override
	public int getWeight() {
		// TODO Auto-generated method stub
		return p.getWeight();
	}
	
}





public class AdapterPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		MeetFactory m=new MeetFactory();
		chicken c=new Koreanchicken(40);
		pigeon p=new YongdosanPigeon(60);
		pigeonAdapter pa=new pigeonAdapter(p);
		m.makeMeet(c);
		m.makeMeet(pa);
		
	}

}
