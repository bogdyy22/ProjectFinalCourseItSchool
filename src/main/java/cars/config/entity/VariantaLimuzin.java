package cars.config.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Limuzin")
@Table(name = "Limuzin_Variant")
@Setter
@Getter
@NoArgsConstructor
@ToString // (exclude = "LimuzinModel")

public class VariantaLimuzin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Model")
	private String model;

	@Column(name = "Serie_sasiu")
	private String sasiu;

	@Enumerated(EnumType.STRING)
	@Column(name = "Caroserie_Limuzin")
	private CaroserieTyp caroserieTyp;

	@Enumerated(EnumType.STRING)
	@Column(name = "LimuzinVariant")
	private LimuzinVariant limuzinVariant;

	@Column(name = "Power")
	private int hp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Caroserie")
	private TransmisionVariant transmisionVariant;

	@Column(name = "Price")
	private long price;

	public VariantaLimuzin(String model, String sasiu, CaroserieTyp caroserieTyp, LimuzinVariant limuzinVariant, int hp,
			TransmisionVariant transmisionVariant, long price) {
		super();
		this.model = model;
		this.sasiu = sasiu;
		this.caroserieTyp = caroserieTyp;
		this.limuzinVariant = limuzinVariant;
		this.hp = hp;
		this.transmisionVariant = transmisionVariant;
		this.price = price;
	}

}
