package cars.config.service;

import java.util.List;
import java.util.Scanner;

import cars.config.dao.VariantaLimuzinDao;
import cars.config.entity.VariantaLimuzin;
import lombok.extern.log4j.Log4j;

@Log4j
public class VariantaLimuzinService {

	private VariantaLimuzinDao variantaLimuzinDao = new VariantaLimuzinDao();

	// CRUD = create, read, update, delete
	// Create
	public void saveVariantaCompact(VariantaLimuzin variantaLimuzin) {
		variantaLimuzinDao.openCurrentSessionwithTransaction();
		variantaLimuzinDao.saveVariantaCompact(variantaLimuzin);
		try {
			variantaLimuzinDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Nu sa putut salva Varianta Limuzin");
		}
	}

	// Read By Id
	public VariantaLimuzin getVariantaLimuzinById(int id) {
		variantaLimuzinDao.openCurrentSession();
		VariantaLimuzin variantaCompact = variantaLimuzinDao.getVariantaLimuzinById(id);
		variantaLimuzinDao.closeCurrentSession();
		return variantaCompact;
	}

	// Read All
	public List<VariantaLimuzin> getAllVariantaLimuin() {
		variantaLimuzinDao.openCurrentSession();
		List<VariantaLimuzin> variantaLimuzin = variantaLimuzinDao.getAllVariantaLimuzin();
		variantaLimuzinDao.closeCurrentSession();
		return variantaLimuzin;
	}

	// Update Post
	public void updateVariantaLimuzin(VariantaLimuzin newVariantaLimuzin) {
		try {
			variantaLimuzinDao.openCurrentSessionwithTransaction();
			variantaLimuzinDao.updateVariantaLimuzin(newVariantaLimuzin);
			variantaLimuzinDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.info("Object not found in Database. Do you want to save it? yes/no");
			Scanner scanner = new Scanner(System.in);
			if (scanner.nextLine().equalsIgnoreCase("yes")) {
				updateVariantaLimuzin(newVariantaLimuzin);
			} else {
				log.info("Ok. Bye.");
			}
			scanner.close();
		}
	}

	// Delete Post
	public void deletVariantaCompact(VariantaLimuzin variantaLimuzin) {
		variantaLimuzinDao.openCurrentSessionwithTransaction();
		variantaLimuzinDao.updateVariantaLimuzin(variantaLimuzin);
		try {
			variantaLimuzinDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Delete Post cannot be executed");
		}
	}
}
