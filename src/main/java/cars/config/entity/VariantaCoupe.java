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
@Table(name = "VariantaCoupe")
@Setter
@Getter
@ToString

public class VariantaCoupe extends Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Coupe_id")
	private int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "Variant_Car")
	private CoupeVariant coupeVariant;

	@Column(name = "Horse_Power")
	private int hp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Transmision_Car")
	private TransmisionVariant transmisionVariant;

	@Enumerated(EnumType.STRING)
	@Column(name = "Body_Car")
	private CaroserieTyp bodyType;

	@Column(name = "Prices")
	private long price;

	public VariantaCoupe(int id, CoupeVariant coupeVariant, String model, String sasiu, int hp,
			TransmisionVariant transmisionVariant, CaroserieTyp caroserieTyp, long price) {
		super(id, model, sasiu, caroserieTyp);
		this.coupeVariant = coupeVariant;
		this.hp = hp;
		this.price = price;
		this.transmisionVariant = transmisionVariant;
	}

}
