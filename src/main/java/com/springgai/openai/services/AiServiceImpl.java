package com.springgai.openai.services;

import java.util.Map;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import com.springgai.openai.model.ArchitectEntity;
import com.springgai.openai.model.ClasificacionTicket;
import com.springgai.openai.model.CodeDto;
import com.springgai.openai.model.CodeExplanation;
import com.springgai.openai.model.InformacionCiudad;
import com.springgai.openai.model.InformacionJson;
import com.springgai.openai.model.Requirement;

@Service
public class AiServiceImpl implements AiService {

	private final ChatClient chatClient;

	public AiServiceImpl(ChatClient.Builder chatClientBuilder) {
		this.chatClient = chatClientBuilder.build();
	}

	@Override
	public String saludar(String nombre) {
		// TODO Auto-generated method stub
		return this.chatClient.prompt().system("Responde siempre en espanol y en una sola linea")
				.user("Dime Hola mundo, con mi nombre: %s".formatted(nombre)).call().content();
	}

	@Override
	public String chat(String prompt) {
		// TODO Auto-generated method stub
		return chatClient.prompt().user(prompt).call().content();
	}

	@Override
	public String chatExpertSpring(String prompt) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system(
				"Eres un experto en java y spring con 40 anos de experencia. " + "responde de forma clara y simple")
				.user(prompt).call().content();
	}

	@Override
	public CodeDto generateCode(Requirement requeriment) {
		// TODO Auto-generated method stub

		String code = chatClient.prompt()
				.system("""

						               Eres un desarrollador senior experto en java, jakarta y spring boot 4.
						               Con buenas practicas, responde solo preguntas o requerimientos relacionado a java y spring boot.
						               Nada mas, ningun otro lenguaje ni contexto, solo programacion java y spring boot.
						""")
				.user(requeriment.requirement()).call().content();

		return new CodeDto(code);
	}

	@Override
	public String explain(String code) {
		// TODO Auto-generated method stub

		PromptTemplate ptemplate = new PromptTemplate("Explica el codigo linea por linea: {code}");
		String userPrompt = ptemplate.render(Map.of("code", code));

		return chatClient.prompt().system("""
				Eres un profesor experto en programacion. Explica paso a paso de forma sencilla.

				""") // parametrizable en base de datos
				.user(userPrompt).call().content()

		;
 
	}
	
	// devolver un json

	@Override
	public String chatFormat(String topic) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un experto en tecnologia  Responde usando nomas de 2 linea por puntos:
				- Titulo
				- Lista de 3 puntos importanes
				- Un ejemplo practico
				""").user(topic).call().content();
	}

	@Override
	public String analizando(String text) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un experto en analisis de texto
				Resume el siguiente texto en 3 puntos claves:
				Devuelve solo json valido.

				Formato exacto:
				{
				   "summary":"string",
				   "key_points":["string","string","string",]
				   "sentiments": "positive|neutral|negative"
				}


				""").user("""

				%s
				""".formatted(text)).call().content();
	}

	@Override
	public InformacionCiudad informacionCiudades(String ciudad) {
		// TODO Auto-generated method stub

		return chatClient.prompt().system("""
				Eres un asistente experto en geografia.
				Responde solo con la informacion correcta y en formato JSON.

				""").user("""
				Devuelve la informacion en espanol de la ciudad %s con este formato:
				{
					"ciudad":"string",
					"pais":"string",
					"habitantes": number,
					"descripcion": "string"
				}
				""".formatted(ciudad)).call().entity(InformacionCiudad.class);
	}

	@Override
	public ClasificacionTicket clasificarTicket(String texto) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un sitema de clasificacion de ticket. Responde solo en json valido.

				""").user("""
				Clasifica el siguiente texto en una categoria y prioridad.
				Categorias:
				- Soporte
				- Ventas
				- Reclamo

				Formato:
				{
					"categoria":"string",
					"razon":"string",
					"prioridad":number

				}

				Texto: %s

				""").call().entity(ClasificacionTicket.class);
	}

	@Override
	public InformacionJson informacionJson(String objetoJson) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un sistema que genera codigo React. Responde solo con json valido.
				""").user("""
				El formato del json sera el siguientes:

				{
					"requerimiento":"string",
					"resumen":"string",
					"codigo":"string",
					"notas":"string"
				}
				""").call().entity(InformacionJson.class);
	}

	@Override
	public CodeExplanation explainCodeType(String codigo) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un profesor expoerto en progracion react.
				Explica el codigo simple y linea por linea
				Devuelve el json valido.
				no uses markdown.
				
				Formato exacto:
				
				{
					"lenguaje":"string",
					"summary":"string",
					"line_by_line":[
					
						{
							"line":1,
							"explanation":"string"
						}
						
					],
					"final_explanation":"string"
				}
				
				
				""").user(codigo).call().entity(CodeExplanation.class);
	}
	
	
	
	
	@Override
	public ArchitectEntity expertoArquitecto(String prompt) {
		// TODO Auto-generated method stub
		return chatClient.prompt().system("""
				Eres un arquitecto de software experto en microservicios, spring boot y arquitectura de sistemas,
				Devuelve solo JSON valido, no uses markdonw.
				Formato exacto:
				{
					"pregunta":"string",
					"respuesta":"string",
					"pros":["string","string","string"],
					"contras":["string","string"],
					"final_decision":"string"
				}
				""").user(prompt).call().entity(ArchitectEntity.class);
	}

	@Override
	public Map<String, Object> metadata(String prompt) {
		// TODO Auto-generated method stub
		ChatResponse response = chatClient.prompt().user(prompt).call().chatResponse();
		
		return Map.of("answer", response.getResult().getOutput().getText(),
				"metadata", response.getMetadata());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
