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

@Entity(name = "Compact")
@Table(name = "Compact_Variant")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class VariantaCompact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Model")
	private String model;

	@Column(name = "Serie_sasiu")
	private String sasiu;

	@Enumerated(EnumType.STRING)
	@Column(name = "Caroserie_Compact")
	private CaroserieTyp caroserieTyp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Color")
	private ColorVariant colorVariant;

	@Enumerated(EnumType.STRING)
	@Column(name = "CompactVariant")
	private CompactVariant compactVariant;

	@Column(name = "Power")
	private int hp;

	@Enumerated(EnumType.STRING)
	@Column(name = "Caroserie")
	private TransmisionVariant transmisionVariant;

	@Column(name = "Price")
	private long price;

	public VariantaCompact(String model, String sasiu, CaroserieTyp caroserieTyp, ColorVariant colorVariant,
			CompactVariant compactVariant, int hp, TransmisionVariant transmisionVariant, long price) {
		this.model = model;
		this.sasiu = sasiu;
		this.caroserieTyp = caroserieTyp;
		this.colorVariant = colorVariant;
		this.compactVariant = compactVariant;
		this.hp = hp;
		this.transmisionVariant = transmisionVariant;
		this.price = price;
	}

}
