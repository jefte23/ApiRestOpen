package br.com.bb.ditec.gesit.capacidade.api.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

public class CapacidadeUtils {
	
	static SimpleDateFormat format;

	public static String gerarNumeroRecomendacaoTecnica(final Long numero) {
		return formatarnumeroRecomendacaoTecnica(String.valueOf(numero));
	}
	private static String formatarnumeroRecomendacaoTecnica(final String numero) {
		 StringBuilder builder = new StringBuilder();
		 if(numero == null) return null;
		 String data = formatarData(new Date(),"yyyy");
		 builder.append("RTC").append(data);
		 if(numero.length() == 1) {
			 return  builder.append("000").append(numero).toString();
		 }else if( numero.length() == 2 ) {
			 return builder.append("00").append(numero).toString();
		 }else if( numero.length() == 3 ) {
			 return builder.append("0").append(numero).toString();
		 }else if( numero.length() == 4 ) {
			 return builder.append(numero).toString();
		 }
		return null;
	}
   private static String formatarData(Date data , String formato) {
	   try {
	    format = new SimpleDateFormat(formato);
		return format.format( new Date()   );
	} catch (Exception e) {
		e.printStackTrace();
	}
	return null;
   } 
  
   public static String decodeBase64(String str) {
	   if(str == null && "".equals(str) ) throw new IllegalArgumentException("Param não pode ser null");
	   return new String ( Base64.decodeBase64(str.getBytes()) );
   }
   
   public static String decodeBase64(Long str) {
	   return  CapacidadeUtils.decodeBase64(String.valueOf(str));
   }
   
   public static Long decodeBase64ToLong(Long str) {
	   return Long.valueOf(CapacidadeUtils.decodeBase64(String.valueOf(str)) );
   }
   
   public static Integer decodeBase64ToInteger(String str) {
	   return Integer.valueOf(CapacidadeUtils.decodeBase64(str) );
   }
   
   public static String encodeBase64(String str) {
	   if(str == null && "".equals(str) ) throw new IllegalArgumentException("Param não pode ser null");
	   return new String ( Base64.encodeBase64(str.getBytes()) );
   }
   
   public static String encodeBase64Array(byte [] str) {
	   if(str == null) throw new IllegalArgumentException("Param não pode ser null");
	   return new String ( Base64.encodeBase64( str ) );
   }
   
   public static String encodeBase64(Long str) {
	   return  CapacidadeUtils.encodeBase64(String.valueOf(str));
   }
   
   public static String encodeBase64(Integer str) {
	   return  CapacidadeUtils.encodeBase64(String.valueOf(str));
   }
   
   public  static long getId(String id) {
		return Long.valueOf(CapacidadeUtils.decodeBase64(id));
   }
  
}
