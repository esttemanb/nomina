package co.com.udem.nomina.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import co.com.udem.nomina.dto.EmpleadoDTO;

public class LecturaArchivo {
	
	private static final Logger logger = LogManager.getLogger(LecturaArchivo.class);
	private HashMap<String, EmpleadoDTO> listaEmpleados = new HashMap<String, EmpleadoDTO>();
	private int cantidadaRegistro = 0;
	
	public String leerArchivo() {
		BasicConfigurator.configure();
		String rutaArchiv = "H:\\Cursos\\udem\\java 1\\ejercio_18_04\\nomina\\nominaEmpleado.txt";
		File archivoNomina = new File(rutaArchiv);
		Scanner scanner = null;
		String mensaje = "";
		try {
			scanner = new Scanner(archivoNomina);
			while (scanner.hasNextLine()) {
				String registro = scanner.nextLine();
				leerRegistro(registro);
				cantidadaRegistro++;
			}		
			
		} catch (FileNotFoundException e) {
			mensaje = "El archivo no esta en la ruta especificada";			
		}finally {
			if(scanner != null) {
				scanner.close();
			}			
		}		
		
		return mensaje;
	}

	private void leerRegistro(String registro) {
		Scanner scanner = new Scanner(registro);
		scanner.useDelimiter(",");
		while (scanner.hasNext()) {
			EmpleadoDTO empleadoDTO = new EmpleadoDTO();
			empleadoDTO.setNombres(scanner.next());
			empleadoDTO.setApellidos(scanner.next());
			String cedula = scanner.next();
			empleadoDTO.setCedula(cedula);
			empleadoDTO.setDepartamento(scanner.next());
			empleadoDTO.setSalario(Double.parseDouble(scanner.next()));
			
			listaEmpleados.put(cedula, empleadoDTO);
		}
		imprimirEmpleadosArchivo(listaEmpleados);
		scanner.close();
	}
	
	private void imprimirEmpleadosArchivo(HashMap<String, EmpleadoDTO> listaEmpleados) {
		BasicConfigurator.configure();
		logger.info(listaEmpleados);
		
	}
	
	public int devolverCatidadRegistros() {		
		return cantidadaRegistro;		
	}

}























