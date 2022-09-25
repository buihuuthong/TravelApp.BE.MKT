package com.MyTravel.mytravel.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
public class TourCreateDto {
	@NotBlank
	@Size(max = 20)
	private String tourName;

	private String banner;

	private String listImage;

	private String introduce;

	@NotBlank
	@Size(max = 5)
	private String rating;

	@NotBlank
	private String tourPlan;

	@NotBlank
	@Size(max = 10)
	private String phone;

	@NotBlank
	private String tourTime;

	@NotNull(message = "Missing base price")
	@Min(value = 0, message = "Value must be greater than 0")
	private BigDecimal basePrice;
}
