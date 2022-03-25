package com.arsene.metamodel.metric.DTO;

import java.util.ArrayList;
import java.util.List;

public class QualityAttribute {
	private String name;
	private Object value;
	private List<Metric> metrics;
	
	
	
	public QualityAttribute() {
		this.name = "";
		this.setMetrics(new ArrayList<Metric>());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	public List<Metric> getMetrics() {
		return metrics;
	}
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
	
	

}
