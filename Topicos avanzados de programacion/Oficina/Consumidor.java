package Oficina;

// Fig. 23.13: Consumidor.java
// Consumidor con un m�todo run que itera y lee 10 valores del b�fer.
import java.util.Random;


public class Consumidor implements Runnable
{ 
   private final static Random generador = new Random();
   private final Bufer ubicacionCompartida; // referencia al objeto compartido
 
   private int Ndocumentos;
   
   // constructor
   public Consumidor( Bufer compartido, int NDocum )
   {
	Ndocumentos = NDocum;   
      ubicacionCompartida = compartido;
   } // fin del constructor de Consumidor

   // lee el valor de ubicacionCompartida 10 veces y suma los valores
   public void run()                             
   {
	int altas = 0;
	int RenovacionVigencia = 0;
	int SolicitudCredencial = 0;

	
	int Actual = 0;
	//sin tiempo porque durara hasta que terminen todos los turnos dados
	while (  Actual  < Ndocumentos  )	
	{

		try // permanece inactivo de 0 a 10 segundos, despu�s coloca valor en Bufer
		{
			Thread.sleep(1000 + generador.nextInt( 1000 ) ); // entre 10 y 20 minutos 
			
			int tipo = ubicacionCompartida.obtener(); // establece el tipo de servicio

			if ( tipo == 1 )
				altas ++;
			else if ( tipo == 2 )
				RenovacionVigencia ++;
			else
				SolicitudCredencial ++;
		} // fin de try
		catch ( InterruptedException excepcion ) 
		{
			excepcion.printStackTrace();
		} // fin de catch

		// Actualizar el tiempo
		
		Actual++;
	}

	

	System.out.println( "\nOficina cerrada\nTotales de documentos:\n" );

	System.out.print("Altas: "+altas +"\n" );
	System.out.print( "Renovacion de vigencia: "+ RenovacionVigencia  +"\n" );
	System.out.print( "Solicitud de credencial: "+ SolicitudCredencial  +"\n" );

	System.out.printf( "Totales: "+ (altas + RenovacionVigencia + SolicitudCredencial) +"\n" );

   } // fin del m�todo run
} // fin de la clase Productor



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