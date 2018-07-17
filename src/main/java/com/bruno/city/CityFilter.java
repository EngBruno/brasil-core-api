package com.bruno.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityFilter {
	private Long id;
	private Long code;
	private String name;
	private String UF;
}
