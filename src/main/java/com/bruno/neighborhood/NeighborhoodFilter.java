package com.bruno.neighborhood;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NeighborhoodFilter {
	private String uf;
	private String name;
	private String code;
	private int pageSize;
	private int pageNumber;
}
