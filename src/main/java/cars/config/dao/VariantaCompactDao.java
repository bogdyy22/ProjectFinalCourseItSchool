package cars.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.VariantaCompact;
import cars.config.util.*;

import ro.hibernate.exception.CustomHibernateException;

public class VariantaCompactDao {

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
	public void saveVariantaCompact(VariantaCompact variantaCompact) {
		session.save(variantaCompact);
	}

	// Read By Id
	public VariantaCompact getVariantaCompactById(int id) {
		VariantaCompact variantaCompact = (VariantaCompact) session.get(VariantaCompact.class, id);
		return variantaCompact;
	}

	// Read All
	public List<VariantaCompact> getAllVariantaCompact() {
		openCurrentSession();
		List<VariantaCompact> variantaCompacts = session.createQuery("from Varianta-Compact").list();
		closeCurrentSession();
		return variantaCompacts;
	}

	// Update Post
	public void updateVariantaCompact(VariantaCompact newVariantaCompact) {
		session.update(newVariantaCompact);
	}

	// Delete Post
	public void deleteVariantaCompact(VariantaCompact variantaCompact) {
		session.delete(variantaCompact);
	}

}
