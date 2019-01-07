package MVC;

import java.util.ArrayList;
import java.util.Iterator;


interface Quackable extends QuackObservable {
	public void quack();
}
interface Observer
{
	public void update(QuackObservable duck);
}
interface QuackObservable
{
	public void registerObserver(Observer observer);
	public void notifyObservers();
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
class MallardDuck implements Quackable
{

	Observable observable;
	public MallardDuck()
	{
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		System.out.println("Quack");
		
		
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
	
}
class RedheadDuck implements Quackable
{
	Observable observable;
	
	public RedheadDuck()
	{
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		System.out.println("Quack");
		
	}
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
}
class DuckCall implements Quackable
{
	Observable observable;
	public DuckCall()
	{
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		System.out.println("kwak");
		
	}
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
}
class RubberDuck implements Quackable
{
	Observable observable;
	public RubberDuck()
	{
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		System.out.println("squeak");
		
	}
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
class Goose{
	public void honk()
	{
		System.out.println("Honk");
	}
}
class GooseAdapter implements Quackable
{
	Goose goose;
	Observable observable;
	public GooseAdapter(Goose goose)
	{
		this.goose=goose;
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		goose.honk();
	}
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
	
}

class QuackCounter implements Quackable{

	private Quackable duck;
	Observable observable;
	private static int numberofQuacks;
	public QuackCounter(Quackable duck)
	{
		this.duck=duck;
		observable=new Observable(this);
	}
	@Override
	public void quack() {
		// TODO Auto-generated method stub
		duck.quack();
		numberofQuacks++;
	}
	
	public static int getQuacks()
	{
		return numberofQuacks;
	}
	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
	
}

abstract class AbstractDuckFactory
{
	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}

class CountingDuckFactory extends AbstractDuckFactory
{

	@Override
	public Quackable createMallardDuck() {
		// TODO Auto-generated method stub
		return new QuackCounter(new MallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {
		// TODO Auto-generated method stub
		return new QuackCounter(new RedheadDuck());
	}

	@Override
	public Quackable createDuckCall() {
		// TODO Auto-generated method stub
		return new QuackCounter(new DuckCall());
	}

	@Override
	public Quackable createRubberDuck() {
		// TODO Auto-generated method stub
		return new QuackCounter(new RubberDuck());
	}
	
}

class Quackologist implements Observer
{

	@Override
	public void update(QuackObservable duck) {
		// TODO Auto-generated method stub
		System.out.println("Quackologist:"+duck+"just quaked.");
	}
	
}
class Flock implements Quackable
{
	ArrayList<Quackable> quackers = new ArrayList<Quackable>();
	Observable observable;
	public void add(Quackable quacker)
	{
		quackers.add(quacker);
		observable=new Observable(this);
	}

	@Override
	public void quack() {
		Iterator<Quackable>iterator=quackers.iterator();
		while(iterator.hasNext())
		{
			Quackable quacker=iterator.next();
			quacker.quack();
		}
		
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observable.registerObserver(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		observable.notifyObservers();
	}
}



class Observable implements QuackObservable
{
	ArrayList<Observer> observers=new ArrayList<Observer>();
	QuackObservable duck;
	
	public Observable(QuackObservable duck)
	{
		this.duck=duck;
	}
	
	public void notifyObservers()
	{
		Iterator<Observer> iterator=observers.iterator();
		while(iterator.hasNext())
		{
			Observer observer=(Observer)iterator.next();
			observer.update(duck);
		}
	}

	@Override
	public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}
	
}




public class DuckSimulator {
	
	public static void main(String[] args) {
		DuckSimulator simulator=new DuckSimulator();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		simulator.simulate(duckFactory);
	}

	public void simulate(AbstractDuckFactory duckFactory) {
		
		Quackable redheadDuck= duckFactory.createRedheadDuck();
		Quackable duckCall=duckFactory.createDuckCall();
		Quackable rubberDuck=duckFactory.createRubberDuck();
		Quackable gooseDuck=new GooseAdapter(new Goose());
		System.out.println("\nDuck Simulator: With Composite - Flocks");
		
		Flock flockOfDucks=new Flock();
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		Flock flockOfMallards=new Flock();
		Quackable mallard1=duckFactory.createMallardDuck();
		Quackable mallard2=duckFactory.createMallardDuck();
		Quackable mallard3=duckFactory.createMallardDuck();
		Quackable mallard4=duckFactory.createMallardDuck();
		
		flockOfMallards.add(mallard1);
		flockOfMallards.add(mallard2);
		flockOfMallards.add(mallard3);
		flockOfMallards.add(mallard4);
		
		flockOfDucks.add(flockOfMallards);
		
		System.out.println("\n All Duck Simulator");
		
		Quackologist quackologist=new Quackologist();
		flockOfDucks.registerObserver(quackologist);
		
		simulate(flockOfDucks);
		
		
		
		System.out.println("duck count:"+QuackCounter.getQuacks());
		
	}

	public void simulate(Quackable duck) {
		duck.quack();
		
	}
	

}
