package com.bruno.state;

import org.hibernate.validator.constraints.Range;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StateFilter {
	@Range(min=1)
	private Long codeUF;
	private String name;
	private String uf;
	private Long region;
}
