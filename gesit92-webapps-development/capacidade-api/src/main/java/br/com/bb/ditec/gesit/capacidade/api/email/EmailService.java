package br.com.bb.ditec.gesit.capacidade.api.email;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bb.ditec.gesit.capacidade.api.enuns.TEMPLATE_EMAIL;
import br.com.bb.ditec.gesit.capacidade.api.entities.Funcionario;
import br.com.bb.ditec.gesit.capacidade.api.entities.RecomendacaoTecnica;
import br.com.bb.ditec.gesit.capacidade.api.config.properties.CapacidadeProperties;
import br.com.bb.ditec.gesit.capacidade.api.repositories.EmailRepository;

@Service
public class EmailService {
	
    @Autowired
	private EmailRepository repository;
    
    @Autowired 
    private CapacidadeProperties config;
	
	public void add(TemplateEmail email) {
		if (email == null)
			return;
		repository.save(email);
	}

	public TemplateEmail get(Long id) {
		if (id == null)
			return null;
		return repository.getOne(id);
	}
     
	/* ++++++++++++++++ E-mail de abertura do RTC ++++++++++++++++ */
	public void enviarEmailRTC(RecomendacaoTecnica rtc, Funcionario funci, List<String> emails) {
		if (rtc == null || funci == null )
			new IllegalArgumentException("TemplateEmail Não pode Ser null");
		if (config.getServidor().isEmProducao()) {
			  TemplateEmail template = get( TEMPLATE_EMAIL.TEMPLATE_ABRIR_EMAIL_RTC.getId() );
	    	  template.setFunci(funci);
	    	  template.setEmails(emails);
	    	  template.setRtc(rtc);
			  EmailBuilder.create().enviarEmailRTC(template);
		}
	}
	
	/* ++++++++++++++++ E-mail nova fase do RTC ++++++++++++++++ */ 
	public void enviarEmailFaseRTC(RecomendacaoTecnica rtc, Funcionario funci, List<String> emails, String comentario, String Status) {
		if (rtc == null || funci == null )
			new IllegalArgumentException("TemplateEmail Não pode Ser null");
		if (config.getServidor().isEmProducao()) {
			  TemplateEmail template = get( TEMPLATE_EMAIL.TEMPLATE_NOVA_ETAPA_RTC.getId() );
			  template.setComentRtc(comentario);
			  template.setStatusRtc(Status);
	    	  template.setFunci(funci);
	    	  template.setEmails(emails);
	    	  template.setRtc(rtc);
			  EmailBuilder.create().enviarEmailRTC(template);
		}
	}
	
	public void enviarEmailEditorRTC(TemplateEmail e) {
		try {
			if ( e.getId() == null) new IllegalArgumentException("TemplateEmail Não pode Ser null");
				e = EmailBuilder.create().enviarEmailRTC(e);
				System.out.println(e.getEmails());
				System.out.println("Email enviado com sucesso..");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
}
