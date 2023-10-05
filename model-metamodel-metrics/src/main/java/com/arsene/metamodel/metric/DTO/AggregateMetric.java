package com.arsene.metamodel.metric.DTO;

public class AggregateMetric extends Metric {
	private String minimum;
	private String maximum;
	private String average;
	private String median;
	private String standartdDeviation;
	
	public String getMinimum() {
		return minimum;
	}
	public AggregateMetric(String name, String code, String minimum, String maximum, String average, String median, String standartdDeviation) {
		this.setName(name);
		this.minimum = minimum;
		this.maximum = maximum;
		this.average = average;
		this.median = median;
		this.setCode(code);
		this.standartdDeviation = standartdDeviation;
	}
	public void setMinimum(String minimum) {
		this.minimum = minimum;
	}
	public String getMaximum() {
		return maximum;
	}
	public void setMaximum(String maximum) {
		this.maximum = maximum;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	public String getMedian() {
		return median;
	}
	public void setMedian(String median) {
		this.median = median;
	}
	public String getStandartdDeviation() {
		return standartdDeviation;
	}
	public void setStandartdDeviation(String standartdDeviation) {
		this.standartdDeviation = standartdDeviation;
	}

}
