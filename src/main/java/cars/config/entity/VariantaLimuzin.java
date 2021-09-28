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
@Table(name = "VariantaLimuzin")
@Getter
@Setter
@ToString
public class VariantaLimuzin extends Car implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	@Enumerated(EnumType.STRING)
	@Column(name = "Variant_Car")
	protected LimuzinVariant limuzinVariant;

	@Column(name = "Horse_Power")
	protected int hp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Transmision_Car")
	protected TransmisionVariant transmisionVariant;

	@Enumerated(EnumType.STRING)
	@Column(name = "Body_Car")
	protected CaroserieTyp bodyType;

	@Column(name = "Prices")
	protected long price;

	public VariantaLimuzin(LimuzinVariant limuzinVariant, String model, String sasiu, int hp,
			TransmisionVariant transmisionVariant, CaroserieTyp caroserieTyp, long price) {
		super(model, sasiu, caroserieTyp);
		this.limuzinVariant = limuzinVariant;
		this.hp = hp;
		this.price = price;
		this.transmisionVariant = transmisionVariant;
	}
}
