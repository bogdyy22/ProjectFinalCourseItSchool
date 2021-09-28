package cars.config.main;

import org.hibernate.Session;

import cars.config.entity.CaroserieTyp;
import cars.config.entity.CompactVariant;
import cars.config.entity.TransmisionVariant;
import cars.config.entity.VariantaCompact;
import cars.config.util.HibernateUtil;

public class App {

	public static void main(String[] args) {
		VariantaCompact comp1 = new VariantaCompact(1, CompactVariant.AMG_A35_4MATIC, "A35 AMG", "4x4", 456,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 680330);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.close();
	}
}