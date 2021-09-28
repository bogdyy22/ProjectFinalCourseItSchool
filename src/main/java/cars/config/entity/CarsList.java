package cars.config.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@ToString
public class CarsList implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String varianta;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CompactVarianta_id")
	private Set<VariantaCompact> variantaCompacts;

	public CarsList() {
		super();
		this.variantaCompacts = new HashSet<>();

	}

	public void addVariantaCompactToCarsList(VariantaCompact variantaCompact) {
		this.variantaCompacts.add(variantaCompact);
	}

	public void removeVariantaCompactFromCarsList(VariantaCompact variantaCompact) {
		this.variantaCompacts.remove(variantaCompact);
	}

}
