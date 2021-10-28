package br.com.bb.ditec.gesit.capacidade.api.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.bb.ditec.gesit.capacidade.api.config.properties.MensagemProperties;
/**
 * 
 * @author Lucas.carvalho - C1279457
 * @since 16/042018
 * @email - lucas.carvalho@capgemeni.com.br
 * 
 */

@ControllerAdvice
public class ResponseEntityExceptionhandler extends ResponseEntityExceptionHandler {

	@Autowired
	private MensagemProperties properties;
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex, new Erro( this.properties.get("mensagem.capacidade.processar.operacao"), ex.getCause().toString() ), headers, status, request );
	}
    
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		return handleExceptionInternal(ex,  criarListaDeErro(ex.getBindingResult()  ) , headers, status, request );
	}
	
	private List<Erro> criarListaDeErro(BindingResult binding) {

		List<Erro> erros = new ArrayList<>();
		binding.getFieldErrors()
			.forEach( fieldErrors -> {
				erros.add(new Erro( this.messageSource.getMessage( fieldErrors,LocaleContextHolder.getLocale() ) , fieldErrors .toString() ) );
			});
		return erros;
	}
}

class Erro {

	private String mensagem;
	private String exception;

	public Erro(String menssagem, String ex) {
		this.mensagem = menssagem;
		this.exception = ex;
	}

	public String getMenssagem() {
		return mensagem;
	}

	public String getException() {
		return exception;
	}
}
