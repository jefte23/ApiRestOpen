package br.com.bb.ditec.gesit.capacidade.api.email;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import br.com.bb.ditec.gesit.capacidade.api.enuns.TEMPLATE_VARIAVEL;

//https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch24s03.html
public class EmailBuilder {
	private static final String CAPACIDADE_PORTAL_BB_COM_BR = "capacidade@portal.bb.com.br";
	private static final int PORT = 25;
	private static final String SMTP_BB = "smtp.bb.com.br";
	private static final boolean multipart = true;
	private static final boolean usarHTML = true;
	
	protected TemplateEmail email = new TemplateEmail();

	private EmailBuilder() {}
	
	private EmailBuilder(TemplateEmail email) {
		this.email = email;
	}
	
    public static EmailBuilder create() {
		return new EmailBuilder();
    }
	
	public TemplateEmail enviarEmailRTC(TemplateEmail email) {
		try {
			if(email == null ) new IllegalArgumentException("TemplateEmail Não pode Ser null");
			
			String numeroRTC = (null == email.getRtc() || null == email.getRtc().getNumeroRTC()  ) ? "": email.getRtc().getNumeroRTC();
			if( email.getAssunto()  != null )  email.setAssunto ( subistituirNumeroRTC(email.getAssunto(), numeroRTC) );
			if( email.getMessagem() != null  ) email.setMessagem( subistituirNumeroRTC( email.getMessagem(),numeroRTC ) );
			
			String rtcStatus = (null == email.getRtc().getStatusRecomendacaoTecnica().getNomeStatus() || null == email.getRtc().getStatusRecomendacaoTecnica().getNomeStatus() ) ? "": String.valueOf(email.getRtc().getStatusRecomendacaoTecnica().getNomeStatus());
			if( email.getAssunto()  != null )  email.setAssunto ( subistituirStatusRTC(email.getAssunto(), rtcStatus) );
			if( email.getMessagem() != null  ) email.setMessagem( subistituirStatusRTC( email.getMessagem(),rtcStatus ) );

			String rtcComentario = (null == email.getComentRtc() || null == email.getComentRtc() ) ? "": String.valueOf(email.getComentRtc());
			if( email.getAssunto()  != null )  email.setAssunto ( subistituirComentarioRTC(email.getAssunto(), rtcComentario) );
			if( email.getMessagem() != null  ) email.setMessagem( subistituirComentarioRTC( email.getMessagem(), rtcComentario ) );

			
			String nome = ( email.getFunci() == null || email.getFunci().getNomeCompleto() ==  null  ) ? "" : email.getFunci().getNomeCompleto();
			if( email.getMessagem() != null ) email.setMessagem( subistituirNome( email.getMessagem(), nome) );
			
			String chave = ( email.getFunci() == null || email.getFunci().getMatricula() ==  null  ) ? "": email.getFunci().getMatricula();
			if( email.getMessagem() != null ) email.setMessagem( subistituirChave( email.getMessagem(), chave ) );
			
			if( email.getMessagem() != null ) email.setMessagem( subistituirData( email.getMessagem()) );
			if( email.getMessagem() != null ) email.setMessagem( subistituirDataHora( email.getMessagem()) );
			
		
			TemplateHTMLBody(email);
			
			return email;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Email Error...");
			return email;
		}
	}
	
	protected void TemplateHTMLBody(TemplateEmail email) throws MessagingException {
	    if (email == null) new IllegalArgumentException("subistituirNumeroRTC(String texto, String numeroRTC)");
		MimeMessage message = sender().createMimeMessage();
		MimeMessageHelper emailBody = new MimeMessageHelper(message, multipart);
		if (!email.getEmails().isEmpty() ) emailBody.setTo(email.getEmails().toArray(new String[email.getEmails().size()]));
		if (email.getMessagem() != null) emailBody.setText(email.getMessagem(), usarHTML);
		if (email.getAssunto()  != null ) emailBody.setSubject(email.getAssunto());
		String from = (email.getFrom() == null || "".equals(email.getFrom())) ? CAPACIDADE_PORTAL_BB_COM_BR : email.getFrom();
		emailBody.setFrom(from);
		sender().send(message);
	}

	private JavaMailSenderImpl sender() {
		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost(SMTP_BB);
		sender.setPort(PORT);
		// sender.setDefaultEncoding("UTF-8");
		return sender;
	}
	
	
	private String subistituirNumeroRTC(String texto, String numeroRTC) {
		if (texto == null) new IllegalArgumentException("subistituirNumeroRTC(String texto, String numeroRTC)");
		String assunto = texto.replace( TEMPLATE_VARIAVEL.NUMERO_RTC.getNome() , numeroRTC);
		return assunto;
	}
	
	private String subistituirStatusRTC(String texto, String statusRTC) {
		if (texto == null) new IllegalArgumentException("subistituirStatusRTC(String texto, String statusRTC)");
		String assunto = texto.replace( TEMPLATE_VARIAVEL.RTC_STATUS.getNome(), statusRTC);
		return assunto;
	}
	
	private String subistituirComentarioRTC(String texto, String comentarioRTC) {
		if (texto == null) new IllegalArgumentException("subistituirComentarioRTC(String texto, String comentarioRTC)");
		String assunto = texto.replace( TEMPLATE_VARIAVEL.RTC_COMENTARIO.getNome() , comentarioRTC);
		return assunto;
	}	

	
	private String subistituirChave(String texto, String Chave) {
		if (texto == null) new IllegalArgumentException("String subistituirChave(String texto, String Chave)");
		String assunto = texto.replace( TEMPLATE_VARIAVEL.CHAVE_RESP.getNome(), Chave);
		return assunto;
	}
	
	private String subistituirNome(String texto, String nome) {
		if (texto == null) new IllegalArgumentException("subistituirNome(String texto, String nome)");
		String assunto = texto.replace(TEMPLATE_VARIAVEL.NOME_RESP.getNome() , nome);
		return assunto;
	}
	
	private String subistituirData(String texto) {
		if (texto == null) new IllegalArgumentException("subistituirData(String texto, String nome)");
		String assunto = texto.replace(TEMPLATE_VARIAVEL.DATA.getNome() ,  new SimpleDateFormat("dd/MM/yyyy").format(new Date() ));
		return assunto;
	}
	
	private String subistituirDataHora(String texto) {
		if (texto == null) new IllegalArgumentException("subistituirData(String texto, String nome)");
		String assunto = texto.replace(TEMPLATE_VARIAVEL.DATA_HORA.getNome() ,  new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date() ));
		return assunto;
	}
	

}
