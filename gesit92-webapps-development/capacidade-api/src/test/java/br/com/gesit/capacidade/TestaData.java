//package br.com.gesit.capacidade;
//
//import static org.junit.Assert.assertTrue;
//
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
//import br.com.bb.ditec.gesit.capacidade.api.entities.Evento;
//
//public class TestaData {
//	
//	Calendar startDate = Calendar.getInstance();
//	
//	Evento evento = new Evento();
//	
//	//@Test
//	public void dataEventoEAnterioDataAtual() {
//		
//		startDate.set(2018, 03, 23);
//		evento.setStart(  startDate);
//		
//		System.out.println(" Inicio do Evento antes" +  imprimirData( evento.getStart() ) + "  Data Atual  " + imprimirData( Calendar.getInstance() ) );
//		     assertTrue(  evento.getStart().before( Calendar.getInstance() ) );	
//		 System.out.println( startDate );
//		 
//		 //LocalDate current =  LocalDate.now();
//		
//		// LocalDate x = current.minusDays(2); // 2015-05-19
////		 /System.out.println( current.g );
//		 
//	}
//
//	
//	public static String imprimirData(Calendar calendar) {
//		SimpleDateFormat spf = new SimpleDateFormat("dd/MM/yyyy");
//		return spf.format(calendar.getTime());
//	}
//	
//	
//	
//
//}
