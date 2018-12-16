package aereolinea;
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

		int aero1 = 0;
		int aero2 = 0;
		int aero3 = 0;
		int aero4 = 0;
		int aero5 = 0;

	long horaInicial = 0;
	long horaActual = 0;

	tiempo = new GregorianCalendar();
	horaInicial = tiempo.getTimeInMillis();
	horaActual = horaInicial;

	while ( ( ( horaActual - horaInicial ) <= 86400000 ) || !ubicacionCompartida.estaVacio() )	// 10 minutos y que este vacio
	{

		try // permanece inactivo de 5 a 15 segundos, despu�s lee valor del Bufer
		{
			Thread.sleep(generador.nextInt( 3600000 ) ); // periodo de inactividad aleatorio
			int tipo = ubicacionCompartida.obtener(); // lee el tipo de servicio

			if ( tipo == 1 )
				aero1 ++;
			else if ( tipo == 2 )
				aero2 ++;
			else if ( tipo == 3 )
				aero3 ++;
			else if ( tipo == 4 )
				aero4 ++;
			else
				aero5 ++;
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		tiempo = new GregorianCalendar();
		horaActual = tiempo.getTimeInMillis();
	}

	System.out.println( "Lapso de 24 horas terminado\nTotal de aviones que despegaron:" );

	System.out.printf( "Aerolinea\tDespegaron\n" );
	System.out.printf( "Aerolinea 1\t%d\n", aero1);
	System.out.printf( "Aerolinea 2\t%d\n", aero2);
	System.out.printf( "Aerolinea 3\t%d\n", aero3);
	System.out.printf( "Aerolinea 4\t%d\n", aero4);
	System.out.printf( "Aerolinea 5\t%d\n", aero5);

	System.out.printf( "Totales\t%d\n", aero1 + aero2 + aero3 + aero4 + aero5 );

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