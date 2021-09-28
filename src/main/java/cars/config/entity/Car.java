package cars.config.entity;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "Model")
	protected String model;

	@Column(name = "Sasiu")
	protected String sasiu;

	@Enumerated(EnumType.STRING)
	@Column(name = "Caroserie")
	protected CaroserieTyp caroserieTyp;

	public Car(String model, String sasiu, CaroserieTyp caroserieTyp) {
		this.model = model;
		this.sasiu = sasiu;
		this.caroserieTyp = caroserieTyp;
	}
	
	

}
