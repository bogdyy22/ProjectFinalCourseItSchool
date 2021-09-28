package cars.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.CarsList;
import cars.config.util.HibernateUtil;

public class CarsListDao {
	private Session session;

	private Transaction transaction;

	public Session openCurrentSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

	public Session openCurrentSessionwithTransaction() {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		return session;
	}

	public void closeCurrentSession() {
		session.close();
	}

	public void closeCurrentSessionwithTransaction() throws Exception {
		try {
			transaction.commit();
			session.close();
		} catch (Exception e) {
			session.close();
			throw new Exception("transaction was not commited");
		}
	}

	// CRUD = create, read, update, delete

	// Create
	public void saveCarsList(CarsList carsList) {
		session.save(carsList);
	}

	// Read By Id
	public CarsList getCarsListById(int id) {
		CarsList carList = (CarsList) session.get(CarsList.class, id);
		return carList;
	}

	// Read All
	public List<CarsList> getAllCarsList() {
		openCurrentSession();
		List<CarsList> carsLis = session.createQuery("from Varianta-Compact").list();
		closeCurrentSession();
		return carsLis;
	}

	// Update CarList 
	public void updateCarsList(CarsList newCarsList) {
		session.update(newCarsList);
	}

	// Delete Post
	public void deleteCarsList(CarsList carsList) {
		session.delete(carsList);
	}

}
