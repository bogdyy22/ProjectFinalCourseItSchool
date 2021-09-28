package cars.config.service;

import java.util.List;
import java.util.Scanner;

import cars.config.dao.VariantaCompactDao;
import cars.config.entity.VariantaCompact;
import lombok.extern.log4j.Log4j;

@Log4j
public class VariantaCompactService {

	private VariantaCompactDao variantaCompactDao = new VariantaCompactDao();

	// CRUD = create, read, update, delete
	// Create
	public void saveVariantaCompact(VariantaCompact variantaCompact) {
		variantaCompactDao.openCurrentSessionwithTransaction();
		variantaCompactDao.saveVariantaCompact(variantaCompact);
		try {
			variantaCompactDao.closeCurrentSessionwithTransaction();
		} catch (ro.hibernate.exception.CustomHibernateException e) {
			log.error("Nu sa putut salva Varianta Coupe");
		}
	}

	// Read By Id
	public VariantaCompact getVariantaCompactById(int id) {
		variantaCompactDao.openCurrentSession();
		VariantaCompact variantaCompact = variantaCompactDao.getVariantaCompactById(id);
		variantaCompactDao.closeCurrentSession();
		return variantaCompact;
	}

	// Read All
	public List<VariantaCompact> getAllVariantaCompact() {
		variantaCompactDao.openCurrentSession();
		List<VariantaCompact> variantaCompact = variantaCompactDao.getAllVariantaCompact();
		variantaCompactDao.closeCurrentSession();
		return variantaCompact;
	}

	// Update Post
	public void updatePost(VariantaCompact newVariantaCompact) {
		try {
			variantaCompactDao.openCurrentSessionwithTransaction();
			variantaCompactDao.updateVariantaCompact(newVariantaCompact);
			variantaCompactDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.info("Object not found in Database. Do you want to save it? yes/no");
			Scanner scanner = new Scanner(System.in);
			if (scanner.nextLine().equalsIgnoreCase("yes")) {
				saveVariantaCompact(newVariantaCompact);
			} else {
				log.info("Ok. Bye.");
			}
			scanner.close();
		}
	}

	// Delete Post
	public void deletVariantaCompact(VariantaCompact variantaCompact) {
		variantaCompactDao.openCurrentSessionwithTransaction();
		variantaCompactDao.deleteVariantaCompact(variantaCompact);
		try {
			variantaCompactDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Delete Post cannot be executed");
		}
	}
}
