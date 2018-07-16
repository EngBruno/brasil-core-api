package com.bruno.state;

import lombok.Data;

@Data
public class State {
	private Long id;
	private Long codeUF;
	private String name;
	private String UF;
	private Long region;
}
