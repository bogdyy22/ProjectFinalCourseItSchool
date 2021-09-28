package cars.config.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.CaroserieTyp;
import cars.config.entity.CarsList;
import cars.config.entity.CompactVariant;
import cars.config.entity.TransmisionVariant;
import cars.config.entity.VariantaCompact;
import cars.config.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		VariantaCompact comp1 = new VariantaCompact(CompactVariant.A160, "A160 AMG", "4", 156,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 690330);
		VariantaCompact comp2 = new VariantaCompact(CompactVariant.AMG_A35_4MATIC, "A35 AMG", "4", 456,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 685330);
		VariantaCompact comp3 = new VariantaCompact(CompactVariant.A250_E, "A250_E", "4", 356,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 681330);
		VariantaCompact comp4 = new VariantaCompact(CompactVariant.AMG_S45_S_4MATIC_PLUS, "S45 AMG", "4", 456,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 690330);
		VariantaCompact comp5 = new VariantaCompact(CompactVariant.AMG_A35_4MATIC, "A35 AMG", "4", 656,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 610330);

		VariantaCompact comp6 = new VariantaCompact(CompactVariant.A160, "A160 AMG", "4", 156,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 690330);
		VariantaCompact comp7 = new VariantaCompact(CompactVariant.AMG_A35_4MATIC, "A35 AMG", "4", 456,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 685330);
		VariantaCompact comp8 = new VariantaCompact(CompactVariant.A250_E, "A250_E", "4", 356,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 681330);
		VariantaCompact comp9 = new VariantaCompact(CompactVariant.AMG_S45_S_4MATIC_PLUS, "S45 AMG", "4", 456,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 690330);
		VariantaCompact comp10 = new VariantaCompact(CompactVariant.AMG_A35_4MATIC, "A35 AMG", "4", 656,
				TransmisionVariant.AUTOMATA, CaroserieTyp.COMPACT, 610330);

		Set<VariantaCompact> variantaCompacts = new HashSet<VariantaCompact>();

		CarsList comps = new CarsList();
		comps.setId(0);
		variantaCompacts.add(comp1);
		variantaCompacts.add(comp2);
		variantaCompacts.add(comp3);
		variantaCompacts.add(comp4);
		variantaCompacts.add(comp5);

		CarsList comps2 = new CarsList();

		variantaCompacts.add(comp6);
		variantaCompacts.add(comp7);
		variantaCompacts.add(comp8);
		variantaCompacts.add(comp9);
		variantaCompacts.add(comp10);

		Transaction transaction = session.beginTransaction();
		session.save(comps);
		session.save(comps2);
		transaction.commit();

		session.close();
	}
}