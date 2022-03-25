package com.arsene.modeltransformation.DTO;

public class ModelInfo {
	public ModelInfo(String modelName, String metamodelName) {
		super();
		this.modelName = modelName;
		this.metamodelName = metamodelName;
	}
	private String modelName;
	private String metamodelName;
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getMetamodelName() {
		return metamodelName;
	}
	public void setMetamodelName(String metamodelName) {
		this.metamodelName = metamodelName;
	}
}
