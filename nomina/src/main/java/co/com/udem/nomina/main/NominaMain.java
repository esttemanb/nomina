package co.com.udem.nomina.main;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import co.com.udem.nomina.hilo.ProcesadorArchivo;
import co.com.udem.nomina.util.LecturaArchivo;

public class NominaMain {

	private static final Logger logger = LogManager.getLogger(NominaMain.class);
	

	public static void main(String[] args) {
		BasicConfigurator.configure();
		 ProcesadorArchivo procesadorArchivo =new ProcesadorArchivo();
		 procesadorArchivo.iniciarHilo();
		LecturaArchivo lecturaArchivo = new LecturaArchivo();
		 String mensaje = lecturaArchivo.leerArchivo();
		 logger.info(mensaje);
		 
		
	}

}

























