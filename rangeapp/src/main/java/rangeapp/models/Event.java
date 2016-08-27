package rangeapp.models;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
public class Event {
	@Id
	private String id;

	private String product;

	@NotBlank
	@Size(max = 250)
	@Indexed(unique = false)
	private String effectiveDate;

	public Event() {
		super();
	}

	public Event(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String EffectiveDate) {
		this.effectiveDate = EffectiveDate;
	}

	@Override
	public String toString() {
		return String.format("Todo[product = %s, effectiveDate ='%s']", product, effectiveDate);
	}
}
