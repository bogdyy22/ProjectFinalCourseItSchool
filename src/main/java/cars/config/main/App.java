package cars.config.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cars.config.entity.CaroserieTyp;
import cars.config.entity.CarsList;
import cars.config.entity.ColorVariant;
import cars.config.entity.CompactVariant;
import cars.config.entity.CoupeVariant;
import cars.config.entity.LimuzinVariant;
import cars.config.entity.TransmisionVariant;
import cars.config.entity.VariantaCompact;
import cars.config.entity.VariantaCoupe;
import cars.config.entity.VariantaLimuzin;
import cars.config.util.HibernateUtil;

public class App {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		VariantaCompact comp1 = new VariantaCompact("Mercedes", "4001200", CaroserieTyp.COMPACT, ColorVariant.BLUE,
				CompactVariant.AMG_A35_4MATIC, 490, TransmisionVariant.AUTOMATA, 67080);
		VariantaCompact comp2 = new VariantaCompact("Mercedes", "4001201", CaroserieTyp.COMPACT, ColorVariant.GOLD,
				CompactVariant.AMG_S45_S_4MATIC_PLUS, 890, TransmisionVariant.SEMI_AUTOMAT, 69059);
		VariantaCompact comp3 = new VariantaCompact("Mercedes", "4001202", CaroserieTyp.COMPACT, ColorVariant.WHITE,
				CompactVariant.A200_4MATIC, 290, TransmisionVariant.AUTOMATA, 190599);
		VariantaCompact comp4 = new VariantaCompact("Mercedes", "4001203", CaroserieTyp.COMPACT, ColorVariant.WHITE,
				CompactVariant.A250_E, 190, TransmisionVariant.AUTOMATA, 19059);

		VariantaCoupe coupe1 = new VariantaCoupe("Mercedes", "4002200", CaroserieTyp.COUPE, ColorVariant.RED,
				CoupeVariant.AMG_C43_4MATIC_COUPE, 595, TransmisionVariant.SEMI_AUTOMAT, 180049);
		VariantaCoupe coupe2 = new VariantaCoupe("Mercedes", "4002201", CaroserieTyp.COUPE, ColorVariant.SILVER,
				CoupeVariant.AMG_CLS53_4MATIC_PLUS, 940, TransmisionVariant.SEMI_AUTOMAT, 280049);
		VariantaCoupe coupe3 = new VariantaCoupe("Mercedes", "4002202", CaroserieTyp.COUPE, ColorVariant.YELLOW,
				CoupeVariant.CLS450_4MATIC_COUPE, 495, TransmisionVariant.AUTOMATA, 85049);
		VariantaCoupe coupe4 = new VariantaCoupe("Mercedes", "4002203", CaroserieTyp.COUPE, ColorVariant.BLUE,
				CoupeVariant.CLS450_4MATIC_COUPE, 230, TransmisionVariant.MANUALA, 64049);

		VariantaLimuzin limuzin1 = new VariantaLimuzin("Mercedes", "4003200", CaroserieTyp.LIMIZINA, ColorVariant.BLACK,
				LimuzinVariant.A250_4MATIC_LIMUZINA, 456, TransmisionVariant.AUTOMATA, 124218);

		VariantaLimuzin limuzin2 = new VariantaLimuzin("Mercedes", "4003201", CaroserieTyp.LIMIZINA, ColorVariant.GRAY,
				LimuzinVariant.C300_d_LIMUZINA, 256, TransmisionVariant.SEMI_AUTOMAT, 984218);

		VariantaLimuzin limuzin3 = new VariantaLimuzin("Mercedes", "4003202", CaroserieTyp.LIMIZINA,
				ColorVariant.SILVER, LimuzinVariant.E220_d_4MATIC_LIMUZINA, 556, TransmisionVariant.MANUALA, 194218);

		VariantaLimuzin limuzin4 = new VariantaLimuzin("Mercedes", "4003203", CaroserieTyp.LIMIZINA, ColorVariant.BLUE,
				LimuzinVariant.E300_LIMUZINA, 236, TransmisionVariant.AUTOMATA, 124218);

		CarsList cars1 = new CarsList("Cars_List");
		cars1.addVariantaCompactToCarsList(comp1);
		CarsList cars2 = new CarsList("Cars_List");
		cars2.addVariantaCompactToCarsList(comp2);
		CarsList cars3 = new CarsList("Cars_List");
		cars3.addVariantaCompactToCarsList(comp3);
		CarsList cars4 = new CarsList("Cars_List");
		cars4.addVariantaCompactToCarsList(comp4);
		CarsList cars5 = new CarsList("Cars_List");
		cars5.addVariantaCoupeToCarsList(coupe1);
		CarsList cars6 = new CarsList("Cars_List");
		cars6.addVariantaCoupeToCarsList(coupe2);
		CarsList cars7 = new CarsList("Cars_List");
		cars7.addVariantaCoupeToCarsList(coupe3);
		CarsList cars8 = new CarsList("Cars_List");
		cars8.addVariantaCoupeToCarsList(coupe4);
		CarsList cars9 = new CarsList("Cars_List");
		cars1.addVariantaLimuzinToCarsList(limuzin1);
		cars9.addVariantaLimuzinToCarsList(limuzin2);
		cars2.addVariantaLimuzinToCarsList(limuzin3);
		cars1.addVariantaLimuzinToCarsList(limuzin4);

		session.save(cars1);
		session.save(cars2);
		session.save(cars3);
		session.save(cars4);
		session.save(cars5);
		session.save(cars6);
		session.save(cars7);
		session.save(cars8);
		session.save(cars9);

		transaction.commit();

		session.close();
	}
}