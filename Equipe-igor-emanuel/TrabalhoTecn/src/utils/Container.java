package utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Container {
	
	public static Object setBean(Object objeto, Map<String, String[]> parametros) {
		Class classe = objeto.getClass();
		Map<String, Method> mapaMetodos = new HashMap<String, Method>();
		Method[] metodos = classe.getDeclaredMethods();

		for (Method metodo : metodos)
			if (metodo.getName().startsWith("set"))
				mapaMetodos.put(metodo.getName(), metodo);
		try {
			objeto = classe.newInstance();
			for (Field atributo : objeto.getClass().getDeclaredFields()) {
				if (parametros.get(atributo.getName()) != null) {
					if (!(atributo.getName().startsWith("obj") && (atributo.getName().endsWith("Beans")))) {
						String nomeMetodo = "set"+ atributo.getName().substring(0, 1).toUpperCase()+ atributo.getName().substring(1,atributo.getName().length());

						Class params[] = mapaMetodos.get(nomeMetodo).getParameterTypes();

						if (params[0].toString().equals("int"))
							mapaMetodos.get(nomeMetodo).invoke(objeto,Integer.parseInt(parametros.get(atributo.getName())[0].toString()));
						else
							mapaMetodos.get(nomeMetodo).invoke(objeto,parametros.get(atributo.getName())[0]);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return objeto;
	}

	public static Date formatarData(String dataNaoFormatada) throws ParseException{
		
		SimpleDateFormat dataInicioTeste  = new SimpleDateFormat("dd/MM/yyyy");  
		Date dataFormatada = dataInicioTeste.parse(dataNaoFormatada);
		
		return dataFormatada;
	}
	
}
