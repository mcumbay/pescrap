package com.dfwcomputech.scrap.web.form;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class SearchForm {
	
	@NotEmpty
	private String id;
	
}
