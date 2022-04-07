package com.arsene.metamodel.metric.DTO;

public class SimpleMetric extends Metric{
	private String value;

	public SimpleMetric() {
	}
	public SimpleMetric(String name, String code, String value) {
		this.setName(name);
		this.setCode(code);
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
