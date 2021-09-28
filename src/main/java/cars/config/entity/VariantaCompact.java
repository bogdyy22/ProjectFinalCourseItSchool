package cars.config.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table()
@Setter
@Getter
@ToString

public class VariantaCompact extends Car implements Serializable {

	@Id
	@Column(name = "Id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "Variant_Car")

	private CompactVariant compactVariant;

	@Column(name = "Horse_Power")
	private int hp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Transmision_Car")
	private TransmisionVariant transmisionVariant;

	@Column(name = "Prices", unique = false)
	private long price;

//	@OneToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
//	@JoinColumn(name = "post_id")
//	private VariantaCompact variantaCompact;

	public VariantaCompact(int id, CompactVariant compactVariant, String model, String sasiu, int hp,
			TransmisionVariant transmisionVariant, CaroserieTyp caroserieTyp, long price) {
		super(id, model, sasiu, caroserieTyp);
		this.compactVariant = compactVariant;
		this.hp = hp;
		this.price = price;
		this.transmisionVariant = transmisionVariant;
	}
}
