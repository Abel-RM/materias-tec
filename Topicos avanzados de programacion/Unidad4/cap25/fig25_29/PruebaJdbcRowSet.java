// Fig. 25.30: PruebaJdbcRowSet.java
// Visualizaci�n del contenido de la tabla autores, mediante el uso de JdbcRowSet.
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.rowset.JdbcRowSet;  
import com.sun.rowset.JdbcRowSetImpl; // implementaci�n de JdbcRowSet de Sun

public class PruebaJdbcRowSet 
{
   // nombre del controlador de JDBC y URL de la base de datos 
   static final String CONTROLADOR = "com.mysql.jdbc.Driver";
   static final String URL_BASEDATOS = "jdbc:derby:Libros";
   static final String NOMBREUSUARIO = "jhtp7";
   static final String CONTRASENIA = "jhtp7";
   
   // el constructor se conecta a la base de datos, la consulta, procesa 
   // los resultados y los muestra en la ventana
   public PruebaJdbcRowSet() 
   {
      // se conecta a la base de datos libros y la consulta
      try 
      {
         //Class.forName( CONTROLADOR );
   
         // especifica las propiedades del objeto JdbcRowSet                       
         JdbcRowSet rowSet = new JdbcRowSetImpl();                 
         rowSet.setUrl( URL_BASEDATOS ); // establece URL de la base de datos        
         rowSet.setUsername( NOMBREUSUARIO ); // establece el nombre de usuario           
         rowSet.setPassword( CONTRASENIA ); // establece contrase�a
         rowSet.setCommand( "SELECT * FROM autores" ); // establece la consulta
         rowSet.execute(); // ejecuta la consulta 

         // procesa los resultados de la consulta
         ResultSetMetaData metaDatos = rowSet.getMetaData();
         int numeroDeColumnas = metaDatos.getColumnCount();
         System.out.println( "Tabla Autores de la base de datos Libros:\n" );

         // muestra el encabezado del objeto RowSet
         for ( int i = 1; i <= numeroDeColumnas; i++ )
            System.out.printf( "%-8s\t", metaDatos.getColumnName( i ) );
         System.out.println();
         
         // muestra cada fila
         while ( rowSet.next() ) 
         {
            for ( int i = 1; i <= numeroDeColumnas; i++ )
               System.out.printf( "%-8s\t", rowSet.getObject( i ) );
            System.out.println();
         } // fin de while

         // cierra el objeto ResultSet subyacente, y los objetos Statement y Connection
         rowSet.close();
      } // fin de try
      catch ( SQLException excepcionSql ) 
      {
         excepcionSql.printStackTrace();
         System.exit( 1 );
      } // fin de catch
/*
      catch ( ClassNotFoundException noEncontroClase ) 
      {
         noEncontroClase.printStackTrace();            
         System.exit( 1 );
      } // fin de catch                                 
*/
   } // fin del constructor de mostrarAutores
   
   // inicia la aplicaci�n
   public static void main( String args[] )
   {
      PruebaJdbcRowSet aplicacion = new PruebaJdbcRowSet();      
   } // fin de main
} // fin de la clase PruebaJdbcRowSet


/**************************************************************************
 * (C) Copyright 1992-2007 por Deitel & Associates, Inc. y                *
 * Pearson Education, Inc. Todos los derechos reservados.                 *
 *                                                                        *
 * RENUNCIA: Los autores y el editor de este libro han realizado su mejor *
 * esfuerzo para preparar este libro. Esto incluye el desarrollo, la      *
 * investigaci�n y prueba de las teor�as y programas para determinar su   *
 * efectividad. Los autores y el editor no hacen ninguna garant�a de      *
 * ning�n tipo, expresa o impl�cita, en relaci�n con estos programas o    *
 * con la documentaci�n contenida en estos libros. Los autores y el       *
 * editor no ser�n responsables en ning�n caso por los da�os consecuentes *
 * en conexi�n con, o que surjan de, el suministro, desempe�o o uso de    *
 * estos programas.                                                       *
 *************************************************************************/
