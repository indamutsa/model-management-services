package com.arsene.metamodel.metric.DTO;

import java.util.ArrayList;
import java.util.List;

public class QualitiesAndMetrics {
	private List<QualityAttribute> qualityAttributes;
	private List<Metric> metrics;
	public QualitiesAndMetrics() {
		metrics = new ArrayList<Metric>();
		qualityAttributes = new ArrayList<QualityAttribute>();
	}
	public List<QualityAttribute> getQualityAttributes() {
		return qualityAttributes;
	}

	public void setQualityAttributes(List<QualityAttribute> qualityAttributes) {
		this.qualityAttributes = qualityAttributes;
	}

	public List<Metric> getMetrics() {
		return metrics;
	}

	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}
}
