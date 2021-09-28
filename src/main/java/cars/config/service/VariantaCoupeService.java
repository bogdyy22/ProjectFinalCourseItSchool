package cars.config.service;

import java.util.List;
import java.util.Scanner;

import cars.config.dao.VariantaCoupeDao;
import cars.config.entity.VariantaCoupe;
import lombok.extern.log4j.Log4j;

@Log4j
public class VariantaCoupeService {

	private VariantaCoupeDao variantaCoupeDao = new VariantaCoupeDao();

	// CRUD = create, read, update, delete
	// Create
	public void saveVariantaCompact(VariantaCoupe variantaCoupe) {
		variantaCoupeDao.openCurrentSessionwithTransaction();
		variantaCoupeDao.saveVariantaCoupe(variantaCoupe);
		try {
			variantaCoupeDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Nu sa putut salva Varianta Coupe");
		}
	}

	// Read By Id
	public VariantaCoupe getVariantaCoupeById(int id) {
		variantaCoupeDao.openCurrentSession();
		VariantaCoupe variantaCompact = variantaCoupeDao.getVariantaCoupeById(id);
		variantaCoupeDao.closeCurrentSession();
		return variantaCompact;
	}

	// Read All
	public List<VariantaCoupe> getAllVariantaCoupe() {
		variantaCoupeDao.openCurrentSession();
		List<VariantaCoupe> variantaCoupe = variantaCoupeDao.getAllVariantaCoupe();
		variantaCoupeDao.closeCurrentSession();
		return variantaCoupe;
	}

	// Update Post
	public void updateVariantaCoupe(VariantaCoupe newVariantaCoupe) {
		try {
			variantaCoupeDao.openCurrentSessionwithTransaction();
			variantaCoupeDao.updateVariantaCoupe(newVariantaCoupe);
			variantaCoupeDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.info("Object not found in Database. Do you want to save it? yes/no");
			Scanner scanner = new Scanner(System.in);
			if (scanner.nextLine().equalsIgnoreCase("yes")) {
				updateVariantaCoupe(newVariantaCoupe);
			} else {
				log.info("Ok. Bye.");
			}
			scanner.close();
		}
	}

	// Delete Post
	public void deletVariantaCompact(VariantaCoupe variantaCoupe) {
		variantaCoupeDao.openCurrentSessionwithTransaction();
		variantaCoupeDao.deleteVariantaCoupe(variantaCoupe);
		try {
			variantaCoupeDao.closeCurrentSessionwithTransaction();
		} catch (Exception e) {
			log.error("Delete Post cannot be executed");
		}
	}
}
