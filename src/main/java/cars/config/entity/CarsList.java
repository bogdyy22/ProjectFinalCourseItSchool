package cars.config.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Configurator")
@Table(name = "TabelClienti")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CarsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String variantList;

	@OneToMany(cascade = CascadeType.ALL)
	private Set<VariantaCompact> CompactsVariant = new HashSet<VariantaCompact>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<VariantaCoupe> CoupesVariant = new HashSet<VariantaCoupe>();

	@OneToMany(cascade = CascadeType.ALL)
	private Set<VariantaLimuzin> LimuzinsVariant = new HashSet<VariantaLimuzin>();

	public void addVariantaCompactToCarsList(VariantaCompact variantaCompact) {
		this.CompactsVariant.add(variantaCompact);
	}

	public void removeVariantaCompactToCarsList(VariantaCompact variantaCompact) {
		this.CompactsVariant.remove(variantaCompact);
	}

	public void addVariantaCoupeToCarsList(VariantaCoupe variantaCoupe) {
		this.CoupesVariant.add(variantaCoupe);
	}

	public void removeVariantaCoupeToCarsList(VariantaCoupe variantaCoupe) {
		this.CoupesVariant.remove(variantaCoupe);
	}

	public void addVariantaLimuzinToCarsList(VariantaLimuzin variantaLimuzin) {
		this.LimuzinsVariant.add(variantaLimuzin);
	}

	public void removeVariantaLimuzinToCarsList(VariantaLimuzin variantaLimuzin) {
		this.LimuzinsVariant.remove(variantaLimuzin);
	}

	public CarsList(String variantList) {
		super();
		this.variantList = variantList;

	}

}
