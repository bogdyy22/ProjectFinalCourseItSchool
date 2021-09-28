package cars.config.service;

import java.util.List;
import java.util.Scanner;

import cars.config.dao.CarsListDao;
import cars.config.entity.CarsList;
import lombok.extern.log4j.Log4j;

@Log4j
public class CarsLisService {
	private CarsListDao carsListDao = new CarsListDao();

	// CRUD = create, read, update, delete
	// Create
	public void saveCarsList(CarsList carsList) {
		carsListDao.openCurrentSessionwithTransaction();
		carsListDao.saveCarsList(carsList);
		try {
			carsListDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Nu sa putut salva Cars List");
		}
	}

	// Read By Id
	public CarsList getCarsList(int id) {
		carsListDao.openCurrentSession();
		CarsList carsList = carsListDao.getCarsListById(id);
		carsListDao.closeCurrentSession();
		return carsList;
	}

	// Read All
	public List<CarsList> getAllCarsLists() {
		carsListDao.openCurrentSession();
		List<CarsList> carsLists = carsListDao.getAllCarsList();
		carsListDao.closeCurrentSession();
		return carsLists;
	}

	// Update Post
	public void updateCarsList(CarsList newCarsList) {
		try {
			carsListDao.openCurrentSessionwithTransaction();
			carsListDao.updateCarsList(newCarsList);
			carsListDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.info("Object not found in Database. Do you want to save it? yes/no");
			Scanner scanner = new Scanner(System.in);
			if (scanner.nextLine().equalsIgnoreCase("yes")) {
				updateCarsList(newCarsList);
			} else {
				log.info("Ok. Bye.");
			}
			scanner.close();
		}
	}

	// Delete Post
	public void deletCarsList(CarsList carsList) {
		carsListDao.openCurrentSessionwithTransaction();
		carsListDao.deleteCarsList(carsList);
		try {
			carsListDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Delete Post cannot be executed");
		}
	}
}
