package com.bruno.city;


import javax.persistence.Id;
import lombok.Data;

@Data
public class City {
	
	@Id
	private Long id;
	private Long code;
	private String name;
	private String UF;
}
