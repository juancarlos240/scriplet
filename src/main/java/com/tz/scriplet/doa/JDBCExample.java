package com.tz.scriplet.doa;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 * Clase con el proposito de demostrar como realizar una conexion de JDBC a
 * MySQL desde Java
 * 
 * <p>
 * 
 * {@link Connection} {@link DriverMannager} {@link SQLException}
 * 
 * 
 * @author Juan Carlos
 *
 */

public class JDBCExample {
	private static final String CLASE_DRIVER = "com.mysql.jdbc.Driver";

	private static final String TIPO_CONEXION = "jdbc";
	private static final String TIPO_BASE_DATOS = "mysql";
	private static final String IP = "localhost";
	private static final String PUERTO = "3306";
	private static final String ESQUEMA = "hola_mundo_mysql";
	private static final String PARAMETROS = "?useSSL=false";
	private static final String USUARIO = "root";
	private static final String PASSWORD = "root";

	/**
	 * Metodo que ejecuta la prueba de conexion a MySQL por JDBC
	 * 
	 * <p> Excepciones: No aplica
	 * 
	 * @param args Argumentos de la ejecucion de la prueba transmitidos desde
	 * consola
	 */

	public static void main(String[] args) {
		System.out.println("Iniciando la prueba de conexion");
		// Crea una instancia de la clase para generar una conexion
		JDBCExample jdbc = new JDBCExample();
		Connection conexion = null;
		// Maneja posible excepcion de SQL al intentar generar la conexion
		try {
			conexion = jdbc.generarConexion();
		} catch (SQLException e) {
			// Presenta traza en consola de la falla en la conexion
			e.printStackTrace();
		}
		System.out.println("Conexion = " + conexion);

	}

	/**
	 * Metodo que valida el Driver de coexion a MySQL es valido
	 * <p>
	 * Exepciones: No Aplica
	 * 
	 * @return driver validado variable booleana que almacena la validez de
	 *         driver del MySQL
	 */
	private boolean validarMysSQLDriver() {
		// Variable que almacena la validez de driver del MySQL
		boolean driverValido = true;
		// Mensaje pisoble excepcion al no encontrar driver de conexion con
		// MySQL
		try {
			// Valida que exista el driver de MySQL solicita que lo agreguen a
			// Build Path
			Class.forName(CLASE_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Agrega el jar de MySQL al Build Path");
			e.printStackTrace();
			// Se actualiza cuando el driver de MySQL no es encontrado
			driverValido = false;

		}
		return driverValido;

	}

	/**
	 * 
	 * Metodo que genera una conexion a la base de datos de mysql con los
	 * valores pre definidos
	 * 
	 * <p>
	 * Excepciones : No Aplica
	 * 
	 * @return conexion Variable donde se almacenara la conexion a la base de
	 *         datos de mysql con los valores predefinidos
	 */

	public Connection generarConexion() throws SQLException {
		// Variable donde se almacena la conexion a la base de datos
		Connection conexion = null;
		// Valida que el driver de mysql sea valido antes de interntar crear la
		// variable
		if (validarMysSQLDriver()) {
			
				// Obtiene la conexcion por la url especifica para MySQL ,con el
				// tipo de conexion , la base de datos , la ip de conexion , el
				// puerto de conexion, el esquema y el parametro useSSL=false ,
				// ademas de las credenciales de acceso
				String url = TIPO_CONEXION + ":" + TIPO_BASE_DATOS + "://" + IP + ":" + PUERTO + "/" + ESQUEMA
						+ PARAMETROS;
				conexion = DriverManager.getConnection(url, USUARIO, PASSWORD);
			
			if (conexion != null) {
				System.out.println("Termino la prueba de conexion de forma satisfactoria");
			} else {
				System.out.println("Hubo una falla");
			}
		}
		return conexion;

	}

}
