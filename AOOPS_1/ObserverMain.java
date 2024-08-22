import java.util.ArrayList;
import java.util.List;

interface Subject {
    void attach(Observer o);

    void dettach(Observer o);

    void notifyObserver();

}

interface Observer {
    void update(float temp, float humidity, float pressure);
}

class WeatherStation implements Subject {
    private List<Observer> observe;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherStation() {
        observe = new ArrayList<>();
    }

    public void attach(Observer o) {
        observe.add(o);
    }

    public void dettach(Observer o) {
        observe.remove(o);
    }

    public void notifyObserver() {
        for (Observer observe : observe) {
            observe.update(temp, humidity, pressure);
        }
    }

    public void setMeasure(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }

    public void measurementChanged() {
        notifyObserver();
    }
}

class MobileDisplay implements Observer {
    private Subject weatherStation;

    public MobileDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }

    public void update(float temp, float humidity, float pressure) {
        System.out.println("Mobile Display: Temperature: " + temp + "Humidity: " + humidity + "Pressure: " + pressure);
    }
}

class ComputerDisplay implements Observer {
    private Subject weatherStation;

    public ComputerDisplay(Subject weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.attach(this);
    }

    public void update(float temp, float humidity, float pressure) {
        System.out
                .println("Computer Display: Temperature: " + temp + "Humidity: " + humidity + "Pressure: " + pressure);
    }
}

public class ObserverMain {
    public static void main(String[] args) {
        WeatherStation ws = new WeatherStation();
        MobileDisplay md = new MobileDisplay(ws);
        ComputerDisplay sc = new ComputerDisplay(ws);
        ws.setMeasure(35.5f, 4.0f, 1021.6f);
        ws.setMeasure(45.5f, 5.0f, 921.6f);
    }
}
