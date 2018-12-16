// Fig. 23.13: Consumidor.java
// Consumidor con un m�todo run que itera y lee 10 valores del b�fer.
import java.util.Random;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
   private Calendar tiempo;

   // constructor
   public Consumidor( Bufer compartido )
   {
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                                           
   {
      int particulares = 0;
      int trabajadores= 0;

      tiempo = new GregorianCalendar();
      long horaInicial = tiempo.getTimeInMillis();
      long horaActual = horaInicial;

      while ( ( ( horaActual - horaInicial ) <= 600000 ) || !ubicacionCompartida.estaVacio() )	// Jornada de 10 minutos o que el lavado no est� vacio
      {
         try 
         {
            Thread.sleep( 5000 + generador.nextInt( 10000 ) ); // 10 segundos maximo entre cada auto
	    int servicio = ubicacionCompartida.obtener(); // obtener el tipo de servicio

	    if ( particulares == 1 )
		particulares++;
	    else trabajadores ++;
	    
         } // fin de try
         catch ( InterruptedException excepcion ) 
         {
            excepcion.printStackTrace();
         } // fin de catch

         tiempo = new GregorianCalendar();
         horaActual = tiempo.getTimeInMillis();

      }

      // Calcular totales
      double impparticulares = particulares * 80.0;
      double imptrabajadores = trabajadores * 100.0;
      
      System.out.println( 
         "Trabajadores terminaron\nTotales de la jornada" );
      System.out.printf( "Servicio\tCantidad\tImporte\n" );
      System.out.printf( "Basico: \t%,9d\t%,9.2f\n", basico, impBasico );
      System.out.printf( "Normal: \t%,9d\t%,9.2f\n", normal, impNormal );
      System.out.printf( "Extra : \t%,9d\t%,9.2f\n", extra, impExtra );
      System.out.printf( "Total : \t%,9d\t%,9.2f\n", basico + normal + extra, impBasico + impNormal + impExtra );

   } // fin del m�todo run
} // fin de la clase Consumidor


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