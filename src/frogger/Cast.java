package frogger;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class Cast {

	List<Car> cars;
	List<Log> logs;
	
	public Cast() {
		cars = new ArrayList<Car>();
		logs = new ArrayList<Log>();
	}
	
	public void updateCars(Graphics g) {
		for (Car car : cars) {
			car.update();
			car.draw(g);
		}
		
	}
	
	public void updateLogs(Graphics g) {
		for (Log log : logs) {
			log.update();
			log.draw(g);
		}
		
	}
	
	public void addCar() {
		boolean shouldAdd = true;
		for (Car car : cars) {
			if (car.y == 405) {
				if (car.x < 100) {
					shouldAdd = false;
				}
			} else {
				if (car.x > 630) {
					shouldAdd = false;
				}
			}
		}
		if (shouldAdd) {
			Car newCar = new Car();
			cars.add(newCar);	
		}
	}
	
	public void addLog() {
		String[] sizes = {"small", "medium", "large"};
		boolean shouldAddSmall = true;
		boolean shouldAddMedium = true;
		boolean shouldAddLarge = true;
		for (Log log : logs) {
			if (log.y == 130) {
				if (log.x > 420) {
					shouldAddLarge = false;
				}
			} else if (log.y == 70) {
				if (log.x < 200) {
					shouldAddMedium = false;
				}
			} else {
				if (log.x < 155) {
					shouldAddSmall = false;
				}
			}
		}
		for (String size : sizes) {
			if (size == "small" && shouldAddSmall) {
				logs.add(new Log(size));
			} else if (size == "medium" && shouldAddMedium) {
				logs.add(new Log(size));
			} else if (size == "large" && shouldAddLarge) {
				logs.add(new Log(size));
			}
		}
	}

	
}
