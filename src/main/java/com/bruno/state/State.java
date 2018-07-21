package com.bruno.state;

import java.util.List;
import com.bruno.city.City;
import com.bruno.region.Region;
import lombok.Data;

@Data
public class State {
	private Long id;
	private Long codeUF;
	private String name;
	private String UF;
	private Region region;
	private List<City> listCity;
}
