package cars.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.VariantaCoupe;
import cars.config.util.HibernateUtil;
import ro.hibernate.exception.CustomHibernateException;

public class VariantaCoupeDao {

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

	public void closeCurrentSessionwithTransaction() throws CustomHibernateException {
		try {
			transaction.commit();
			session.close();
		} catch (Exception e) {
			session.close();
			throw new CustomHibernateException("transaction was not commited");
		}
	}

// CRUD = create, read, update, delete

// Create
	public void saveVariantaCoupe(VariantaCoupe variantaCoupe) {
		session.save(variantaCoupe);
	}

// Read By Id
	public VariantaCoupe getVariantaCoupeById(int id) {
		VariantaCoupe variantaCoupe = (VariantaCoupe) session.get(VariantaCoupe.class, id);
		return variantaCoupe;
	}

// Read All
	public List<VariantaCoupe> getAllVariantaCoupe() {
		openCurrentSession();
		List<VariantaCoupe> variantaCoupe = session.createQuery("from Varianta-Coupe").list();
		closeCurrentSession();
		return variantaCoupe;
	}

// Update Post
	public void updateVariantaCoupe(VariantaCoupe newVariantaCoupe) {
		session.update(newVariantaCoupe);
	}

// Delete Post
	public void deleteVariantaCoupe(VariantaCoupe variantaCoupe) {
		session.delete(variantaCoupe);
	}

}
