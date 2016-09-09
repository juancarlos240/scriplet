package com.tz.scriplet.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * Clase con el proposito de demostrar como realizar una consulta de JDBC a
 * MySQL desde Java
 * 
 * <p>
 * 
 * {@link Connection} {@link Statement} {@link SQLException} {@link JDBCExample}
 * 
 * 
 * @author Juan Carlos
 *
 */
public class ConsultaJDBC {

	/**
	 * Metodo que ejecuta la prueba de consulta a MySQL por JDBC con y sin
	 * parametros
	 * 
	 * <p>
	 * Excepciones: No aplica
	 * 
	 * @param args
	 *            Argumentos de la ejecucion de la prueba transmitidos desde
	 *            consola
	 */
	public static void main(String[] args) {
		// Genera una instancia de esta clase
		ConsultaJDBC consulta = new ConsultaJDBC();
		// Maneja exepcion de posible error de SQL
		try {
			// Consulta todos los usuarios de la base de datos
			consulta.consultarUsuarios();
			System.out.println("\n");
			// Consulta usuario por id
			consulta.consultarUsuarioPorId(1);
		} catch (SQLException e) {
			// Presenta en consola traza de excepcion de SQL
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo que genera una consulta de todos los usuarios a la base de datos
	 * de mysql
	 * <p>
	 * 
	 * @throws SQLException
	 *             Posible excepcion al obtener la conexion, al generar el
	 *             enunciado de la conexion, al ejecutar el enunciado y al
	 *             obtener los valores del cursos
	 * 
	 * 
	 */
	public void consultarUsuarios() throws SQLException {
		// Crea una instancia de la clase que nos regresa una conexion de JDBC a
		// MySQL
		JDBCExample jdbc = new JDBCExample();
		// Genera la conexion de JDBC a MySQL
		Connection conexion = jdbc.generarConexion();

		// int id = 1; // posible concatenado de querys
		// String queryConParametros = "Select * from usuario where id = " + id;

		// Instrucion de SQL para realizar consulta al esque de MySQL
		// hola_mundo_mysql
		String query = "Select * from usuario";
		// Enunciado de JDBC que encampsulara la Instruccion de SQL para
		// realizar la consulta a MySQL
		Statement statement = conexion.createStatement();

		// Solicita la ejecucion del enunciado de JDBC y regresa un cursor de
		// JDBC que encampsulara la respuesta de SQL
		ResultSet result = statement.executeQuery(query);

		// Contador con de numero de registros regresados en el cursos de JDBC
		int numeroRegistro = 1;
		// Itera el cursos de JDBC mientras tenga mas registros y se posiciona
		// en la siguiente fila
		while (result.next()) {
			System.out.println("Usuario numero " + numeroRegistro);
			// Obtiene la primer columna del cursos de JDBC e intenta castearla
			// a tipo entero primitivo
			System.out.println("Id :" + result.getInt(1));
			// Obtiene la segunda columna del cursos de JDBC y la obtene como
			// cadena
			System.out.println("Nombre " + result.getString(2));
			numeroRegistro++;
		}
	}

	/**
	 * 
	 * Metodo que genera consulta de un usuario con el identificador enviado a
	 * la base de datos de mysql
	 * <p>
	 * 
	 * @throws SQLException
	 *             Posible excepcion al obtener la conexion, al generar el
	 *             enunciado de la conexion, al ejecutar el enunciado y al
	 *             obtener los valores del cursos
	 * 
	 */
	public void consultarUsuarioPorId(int id) throws SQLException {
		// Crea una instancia de la clase que nos regresa una conexion de JDBC a
		// MySQL
		JDBCExample jdbc = new JDBCExample();
		// Genera la conexion de JDBC a MySQL
		Connection conexion = jdbc.generarConexion();

		// Instrucion de SQL para realizar consulta por id de usuario al esque
		// de MySQL hola_mundo_mysql
		String query = "Select * from usuario where id = ?";
		// Enunciado dinamico de JDBC que encampsulara la Instruccion de SQL
		// para realizar la consulta a MySQL
		PreparedStatement preparedStatement = conexion.prepareStatement(query);
		// Se ingresan parametros de enunciado de forma dinamica
		preparedStatement.setInt(1, id);

		// Solicita la ejecucion del enunciado dinamico de JDBC y regresa un
		// cursor de JDBC que encampsulara la respuesta de SQL
		ResultSet result = preparedStatement.executeQuery();

		// Contador con de numero de registros regresados en el cursos de JDBC
		int numeroRegistro = 1;
		// Itera el cursos de JDBC mientras tenga mas registros y se posiciona
		// en la siguiente fila
		while (result.next()) {
			System.out.println("Usuario numero " + numeroRegistro);
			// Obtiene la primer columna del cursos de JDBC e intenta castearla
			// a tipo entero primitivo
			System.out.println("Id :" + result.getInt(1));
			// Obtiene la segunda columna del cursos de JDBC y la obtene como
			// cadena
			System.out.println("Nombre " + result.getString(2));
			numeroRegistro++;
		}
	}
}
