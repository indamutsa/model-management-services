package com.arsene.modeltransformation.DTO;

import java.util.ArrayList;
import java.util.List;

public class ATLTransformationInfo {

	private List<ModelInfo> inputModels;
	public ATLTransformationInfo() {
		this.inputModels = new ArrayList<ModelInfo>();
		this.outputModels = new ArrayList<ModelInfo>();
	}
	private List<ModelInfo> outputModels;
	public List<ModelInfo> getOutputModels() {
		return outputModels;
	}
	public void setOutputModels(List<ModelInfo> outputModels) {
		this.outputModels = outputModels;
	}
	public List<ModelInfo> getInputModels() {
		return inputModels;
	}
	public void setInputModels(List<ModelInfo> inputModels) {
		this.inputModels = inputModels;
	}
}
