// Prog0121.java
// Prueba de Menu

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class Prog0121
{
	public static void main( String[] args )
	{
		MiVentana miVentana = new MiVentana( "Prueba de Menu" );
		miVentana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		miVentana.setSize( 600, 200 );
		miVentana.setVisible( true );
	}
}

class MiVentana extends JFrame 
{
   private final Color[] valoresColores = 
      { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN };   
   private JMenuItem elementoAcercaDe;
   private JMenuItem elementoSalir;
   private JRadioButtonMenuItem[] elementosColores; // elementos del men� colores
   private JRadioButtonMenuItem[] fuentes; // elementos del men� fuentes
   private JCheckBoxMenuItem[] elementosEstilos; // elementos del menu estilos
   private JLabel mostrarJLabel; // muestra texto de ejemplo
   private ButtonGroup fuentesButtonGroup; // administra elementos del men� fuentes
   private ButtonGroup coloresButtonGroup; // administra elementos del men� colores
   private int estilo; // se utiliza para crear el estilo para la fuente

   // el constructor sin argumentos establece la GUI
   public MiVentana( String titulo )
   {
      super( titulo );

      JMenuBar barra = new JMenuBar(); // crea la barra de men�s
      setJMenuBar( barra ); // agrega la barra de men�s a la aplicaci�n

      ManejadorArchivo manejadorArchivo = new ManejadorArchivo(); // manejador elementos del men� archivo
      JMenu menuArchivo = new JMenu( "Archivo" ); // crea el men� archivo
      menuArchivo.setMnemonic( 'A' ); // establece el nem�nico a A

      // crea el elemento de men� Acerca de...
      elementoAcercaDe = new JMenuItem( "Acerca de..." );
      elementoAcercaDe.setMnemonic( 'c' ); // establece el nem�nico a c
      elementoAcercaDe.addActionListener( manejadorArchivo );
 
      elementoSalir = new JMenuItem( "Salir" ); // crea el elemento salir
      elementoSalir.setMnemonic( 'S' ); // establece el nem�nico a s
      elementoSalir.addActionListener( manejadorArchivo );

      menuArchivo.add( elementoAcercaDe ); // agrega el elemento elementoAcercaDe al men� archivo
      menuArchivo.add( elementoSalir ); // agrega elemento salir al men� archivo

      barra.add( menuArchivo ); // agrega el men� archivo a la barra de men�s

      ManejadorElementos manejadorElementos = new ManejadorElementos(); // manejador para colores
      JMenu menuFormato = new JMenu( "Formato" ); // crea el men� formato
      menuFormato.setMnemonic( 'F' ); // establece el nem�nico a F

      // arreglo que enlista la cadena colores
      String[] colores = { "Negro", "Azul", "Rojo", "Verde" };
      JMenu menuColor = new JMenu( "Color" ); // crea el men� color
      menuColor.setMnemonic( 'C' ); // establece el nem�nico a C

      // crea los elementos de men� de los botones de opci�n para los colores
      elementosColores = new JRadioButtonMenuItem[ colores.length ];
      coloresButtonGroup = new ButtonGroup(); // administra los colores

      // crea los elementos de menu del bot�n de opci�n color
      for ( int cuenta = 0; cuenta < colores.length; cuenta++ ) 
      {
         elementosColores[ cuenta ] = new JRadioButtonMenuItem( colores[ cuenta ] ); // crea elemento
         elementosColores[ cuenta ].addActionListener( manejadorElementos );
         coloresButtonGroup.add( elementosColores[ cuenta ] ); // lo agrega al grupo
         menuColor.add( elementosColores[ cuenta ] ); // agrega elemento al men� color
      } // fin de for

      elementosColores[ 0 ].setSelected( true ); // selecciona el primer elemento de Color

      JMenu menuFuente = new JMenu( "Fuente" ); // crea el men� fuente
      menuFuente.setMnemonic( 'u' ); // establece el nem�nico a u

      // arreglo que enlista los nombres de las fuentes
      String[] nombresFuentes = { "Serif", "Monospaced", "SansSerif" };
      // crea elementos de men� de botones de opci�n para los nombres de las fuentes
      fuentes = new JRadioButtonMenuItem[ nombresFuentes.length ];
      fuentesButtonGroup = new ButtonGroup(); // administra los nombres de las fuentes

      // crea elementos de men� de botones de opci�n de Fuente
      for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ ) 
      {
         fuentes[ cuenta ] = new JRadioButtonMenuItem( nombresFuentes[ cuenta ] );
         fuentes[ cuenta ].addActionListener( manejadorElementos ); // agrega el manejador
         fuentesButtonGroup.add( fuentes[ cuenta ] ); // agrega al grupo de botones
         menuFuente.add( fuentes[ cuenta ] ); // agrega fuente al men� fuente
      } // fin de for

      fuentes[ 0 ].setSelected( true ); // selecciona el primer elemento del men� Fuente
      menuFuente.addSeparator(); // agrega barra separadura al men� fuente

      ManejadorEstilos manejadorEstilos = new ManejadorEstilos(); // manejador de estilos
      String[] nombresEstilos = { "Negrita", "Cursiva" }; // nombres de los estilos
      elementosEstilos = new JCheckBoxMenuItem[ nombresEstilos.length ];

      // crea elementos de men� de la casilla de verificaci�n de estilo
      for ( int cuenta = 0; cuenta < nombresEstilos.length; cuenta++ ) 
      {
         elementosEstilos[ cuenta ] =  new JCheckBoxMenuItem( nombresEstilos[ cuenta ] ); // para el estilo
         elementosEstilos[ cuenta ].addItemListener( manejadorEstilos ); // manejador
         menuFuente.add( elementosEstilos[ cuenta ] ); // agrega al men� fuente
      } // fin de for

      menuFormato.add( menuColor ); // agrega el men� color al men� formato
      menuFormato.addSeparator(); // agrega un separador en el men�
      menuFormato.add( menuFuente ); // agrega el men� Fuente al men� Formato
      barra.add( menuFormato ); // agrega el men� Formato a la barra de men�s
     
      // establece la etiqueta para mostrar el texto
      mostrarJLabel = new JLabel( "Texto de ejemplo", SwingConstants.CENTER );
      mostrarJLabel.setForeground( valoresColores[ 0 ] );
      mostrarJLabel.setFont( new Font( "Serif", Font.PLAIN, 72 ) );

      getContentPane().setBackground( Color.CYAN ); // establece el color de fondo
      add( mostrarJLabel, BorderLayout.CENTER ); // agrega mostrarJLabel
   } // fin del constructor de MiVentana


   // clase interna para manejar los eventos de acci�n de los elementos de men� Archivo
   private class ManejadorArchivo implements ActionListener 
   {
      // procesa las selecciones de color y fuente
      public void actionPerformed( ActionEvent evento )
      {
          JMenuItem fuente = (JMenuItem) evento.getSource();

          if ( fuente == elementoAcercaDe )
	  {
               JOptionPane.showMessageDialog( MiVentana.this,
                  "Este es un ejemplo\ndel uso de menus",
                  "Acerca de", JOptionPane.PLAIN_MESSAGE );
	  }
	  else
	  {
		System.exit( 0 ); // sale de la aplicaci�n
	  }
      }
   }

   // clase interna para manejar los eventos de acci�n de los elementos de men�
   private class ManejadorElementos implements ActionListener 
   {
      // procesa las selecciones de color y fuente
      public void actionPerformed( ActionEvent evento )
      {
         // procesa la selecci�n del color
         for ( int cuenta = 0; cuenta < elementosColores.length; cuenta++ )
         {
            if ( elementosColores[ cuenta ].isSelected() ) 
            {
               mostrarJLabel.setForeground( valoresColores[ cuenta ] );
               break;
            } // fin de if
         } // fin de for

         // procesa la selecci�n de fuente
         for ( int cuenta = 0; cuenta < fuentes.length; cuenta++ )
         {
            if ( evento.getSource() == fuentes[ cuenta ] ) 
            {
               mostrarJLabel.setFont( 
                  new Font( fuentes[ cuenta ].getText(), estilo, 72 ) );
            } // fin de if
         } // fin de for

         repaint(); // vuelve a dibujar la aplicaci�n
      } // fin del m�todo actionPerformed
   } // fin de la clase ManejadorElementos

   // clase interna para manejar los eventos de los elementos de men� de las casillas de verificaci�n
   private class ManejadorEstilos implements ItemListener 
   {
      // procesa las selecciones de estilo de las fuentes
      public void itemStateChanged( ItemEvent e )
      {
         estilo = 0; // inicializa el estilo

         // comprueba la selecci�n de negrita
         if ( elementosEstilos[ 0 ].isSelected() )
            estilo += Font.BOLD; // agrega negrita al estilo

         // comprueba la selecci�n de cursiva
         if ( elementosEstilos[ 1 ].isSelected() )
            estilo += Font.ITALIC; // agrega cursiva al estilo

         mostrarJLabel.setFont( 
            new Font( mostrarJLabel.getFont().getName(), estilo, 72 ) );
         repaint(); // vuelve a dibujar la aplicaci�n
      } // fin del m�todo itemStateChanged
   } // fin de la clase ManejadorEstilos
} // fin de la clase MarcoMenu
