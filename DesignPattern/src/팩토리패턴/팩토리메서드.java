package 팩토리패턴;

import java.util.ArrayList;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

class Pizza {
	String name;
	String dough;
	String sauce;
	ArrayList<String> toppings = new ArrayList<String>();

	void prepare() {
		System.out.println("preparing " + name);
		System.out.println("Tossing dough..");
		System.out.println("adding sauce");
		System.out.println("Adding toppings :");
		for (String s : toppings) {
			System.out.println(s);
		}
	}

	void bake() {
		System.out.println("25분동안 350도에서 굽는다.");
	}

	void cut() {
		System.out.println("평범하게 자른다.");
	}

	void box() {
		System.out.println("피자회사 박스에 포장한다.");

	}

	String getName() {
		return name;
	}

}

class NYStyleCheesePizza extends Pizza
{
	NYStyleCheesePizza()
	{
		name="NY Style Cheese Pizza";
		dough="Thin Crust Dough";
		sauce="Marrinara Sauce";
		toppings.add("cheese");
	}
}

abstract class PizzaStore {

	Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		return pizza;

	}
	
	abstract protected Pizza createPizza(String type);
}

class NYPizzaStore extends PizzaStore{

	@Override
	protected Pizza createPizza(String type) {
		// TODO Auto-generated method stub
		if(type.equals("cheese"))
		{
			return new NYStyleCheesePizza();
		}else if(type.equals("veggie"))
		{
		
			return null;
		}else if(type.equals("clam"))
		{
			return null;
		}else if(type.equals("pepperoni"))
		{
			return null;
		}else
		{
			return null;
		}
		
	}

}

public class 팩토리메서드 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore nyStore = new NYPizzaStore();
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan order a" + pizza.getName() + "\n");
	}

}
