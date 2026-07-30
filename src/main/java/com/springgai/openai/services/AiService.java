package com.springgai.openai.services;

import java.util.Map;

import com.springgai.openai.model.ArchitectEntity;
import com.springgai.openai.model.ClasificacionTicket;
import com.springgai.openai.model.CodeDto;
import com.springgai.openai.model.CodeExplanation;
import com.springgai.openai.model.InformacionCiudad;
import com.springgai.openai.model.InformacionJson;
import com.springgai.openai.model.Requirement;
 
public interface AiService {
	
	String saludar(String nombre);
	String chat(String prompt);
	String chatExpertSpring(String prompt);
	
	
	CodeDto generateCode(Requirement requirement);
	String explain(String code);
	String chatFormat(String topic);
	
	String analizando(String text);
	InformacionCiudad informacionCiudades(String ciudad);
	ClasificacionTicket clasificarTicket(String texto);

	InformacionJson informacionJson(String objetoJson);
	CodeExplanation explainCodeType(String codigo);
	
    ArchitectEntity expertoArquitecto(String prompt);
 	
	Map<String, Object> metadata(String prompt);
	
}

 