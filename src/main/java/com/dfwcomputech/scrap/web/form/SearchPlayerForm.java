package com.dfwcomputech.scrap.web.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.Data;

@Data
public class SearchPlayerForm {
	
	@Min(value = 40)
	@Max(value= 99)
	private Integer minSpeed=40;
	
	@Min(value = 40)
	@Max(value= 99)
	private Integer maxSpeed=99;
}
