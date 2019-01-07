import java.util.ArrayList;

//옵저버 패턴: 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들한테 연락이 가고 자동으로 내용이 갱신되는 방식 -> 1:N 관계 의존성
//디자인 원칙 tip:서로 상호작용을 하는 객체 사이에서는 가능하면 느슨하게 결합하는 디자인을 사용해야한다.
//느슨한 결함?? ->두 객체가 느슨학게 결합되어 있다는 것은, 그 둘이 상호작용을 하긴 하지만 서로에 대해 잘 모른다는 것을 말한다.
//느슨하게 결합라는 디자인을 사용하면 변경사항이 생겨도 무난히 처리할 수 있는 유연한 객체지향 시스템을 구축할수 있습니다.->상호의존성 최소화

interface Subject
{
	public void registerObserver(Observer o);//옵저버 등록
	public void removeObserver(Observer o);//옵저버 해제
	public void notifyObservers();//옵저버들에게 알리기
}
interface Observer
{
	public void update(double temp,double humidity,double pressure);
}
interface DisplayElement
{
	public void display();
}
////////////////////////////////////////인터페이스 부분///////////////////////////////////////////
class WeatherData implements Subject
{
	private ArrayList observers;
	private double temperature;//온도
	private double humidity;//습도
	private double pressure;//기압
	
	public WeatherData()
	{
		observers=new ArrayList();
	}
	@Override
	public void registerObserver(Observer o) {observers.add(o);}

	@Override
	public void removeObserver(Observer o) {
		int i=observers.indexOf(o);
		if(i>=0)observers.remove(i);
	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observers.size();i++)
			{Observer observer=(Observer)observers.get(i);
			observer.update(temperature,humidity, pressure);
			}
	}
	
	public void measurementsChanged(){notifyObservers();	}
	
	public void setMeasurements(double temperature,double humidity, double pressure)
	{
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		measurementsChanged();
	}
}

class CurrentConditionsDisplay implements Observer, DisplayElement
{
	private double temperature;//온도
	private double humidity;//습도
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData=weatherData;
		weatherData.registerObserver(this);
	}
	@Override
	public void display() {
		System.out.println("Current condition:"+temperature+"F degrees and "+humidity+ "% humidity");		
	}

	@Override
	public void update(double temp, double humidity, double pressure) {
		this.temperature=temp;
		this.humidity=humidity;
		display();
	}
}



class StatisticsDisplay implements Observer, DisplayElement {
	private double maxTemp = 0.0f;
	private double minTemp = 200;
	private double tempSum= 0.0f;
	private int numReadings;
	private WeatherData weatherData;

	public StatisticsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(double temp, double humidity, double pressure) {
		tempSum += temp;
		numReadings++;

		if (temp > maxTemp) {
			maxTemp = temp;
		}
 
		if (temp < minTemp) {
			minTemp = temp;
		}

		display();
	}

	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
			+ "/" + maxTemp + "/" + minTemp);
	}
}

class ForecastDisplay implements Observer, DisplayElement {
	private double currentPressure = 29.92f;  
	private double lastPressure;
	private WeatherData weatherData;

	public ForecastDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}

	@Override
	public void update(double temp, double humidity, double pressure) {
		// TODO Auto-generated method stub
		lastPressure = currentPressure;
		currentPressure = pressure;

		display();
	} 
}


public class ObserverPattern {

	public static void main(String[] args) {
		WeatherData weatherData=new WeatherData();
		
		CurrentConditionsDisplay currentDisplay=new CurrentConditionsDisplay(weatherData);
		StatisticsDisplay statisticsDisplay=new StatisticsDisplay(weatherData);
		ForecastDisplay forecastDisplay=new ForecastDisplay(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.4);
		weatherData.setMeasurements(82, 70, 29.2);
		weatherData.setMeasurements(78, 90, 29.2);
	}

}
