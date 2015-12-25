package com.happydesk.util;

public class Filter 
{
	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public FilterType getType() {
		return type;
	}

	private String name;
	private Object value;
	private FilterType type;

	public Filter(String name, Object value)
	{
		this.name = name;
		this.value = value;
		this.type = FilterType.Contains;
	}
	
	public Filter(String name, Object value, FilterType type)
	{
		this.name = name;
		this.value = value;
		this.type = type;
	}
}
