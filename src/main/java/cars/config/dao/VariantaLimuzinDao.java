package cars.config.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.VariantaLimuzin;
import cars.config.util.HibernateUtil;

public class VariantaLimuzinDao {

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
	public void saveVariantaCompact(VariantaLimuzin variantaLimuzin) {
		session.save(variantaLimuzin);
	}

// Read By Id
	public VariantaLimuzin getVariantaLimuzinById(int id) {
		VariantaLimuzin variantaLimuzin = (VariantaLimuzin) session.get(VariantaLimuzin.class, id);
		return variantaLimuzin;
	}

// Read All
	public List<VariantaLimuzin> getAllVariantaLimuzin() {
		openCurrentSession();
		List<VariantaLimuzin> variantaLimuzin = session.createQuery("from Varianta-Limuzin").list();
		closeCurrentSession();
		return variantaLimuzin;
	}

// Update Post
	public void updateVariantaLimuzin(VariantaLimuzin newVariantaLimuzin) {
		session.update(newVariantaLimuzin);
	}

// Delete Post
	public void deletePost(VariantaLimuzin variantaLimuzin) {
		session.delete(variantaLimuzin);
	}

}
