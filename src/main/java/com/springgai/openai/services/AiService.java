package com.springgai.openai.services;

import com.springgai.openai.model.ClasificacionTicket;
import com.springgai.openai.model.CodeDto;
import com.springgai.openai.model.InformacionCiudad;
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

}
