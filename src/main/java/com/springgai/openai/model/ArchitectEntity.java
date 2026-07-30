package com.springgai.openai.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ArchitectEntity(String pregunta,
		String respuesta, 
		@JsonProperty("final_decision") String  finalDecision,
		List<String> pros,
		List<String> contras) {

}
