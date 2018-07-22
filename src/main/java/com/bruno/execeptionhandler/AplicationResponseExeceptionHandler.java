package com.bruno.execeptionhandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AplicationResponseExeceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message = messageSource.getMessage("messagem.invalida", null, LocaleContextHolder.getLocale());
		String messageForDeveloper = ex.getCause().toString();
		return handleExceptionInternal(ex, new Erro(message, messageForDeveloper), headers, status, request);
	}
	
	@ExceptionHandler({ ObjectNullException.class })
	public ResponseEntity<Object> handlePessoaInexistenteException(ObjectNullException ex,WebRequest request) {
		String messageForUser = ex.getMessage();
		String messageForDeveloper = ex.toString();
//		return ResponseEntity.notFound().body(new Erro(messageForUser, messageForDeveloper));
		return handleExceptionInternal(ex, new Erro(messageForUser, messageForDeveloper), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<Erro> erros = creatListErro(ex.getBindingResult());
		return handleExceptionInternal(ex, erros, headers, status, request);
	}
	
//	@Override
//	protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,WebRequest request) {
//		// TODO Auto-generated method stub
////		return super.handleBindException(ex, headers, status, request);
//		String messageForDeveloper = ex.getObjectName();
//		return new ResponseEntity<>(messageForDeveloper, HttpStatus.BAD_REQUEST);
//	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	ResponseEntity<Set<String>> handleConstraintViolation(ConstraintViolationException e) {
	    Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

	Set<String> messages = new HashSet<>(constraintViolations.size());
	messages.addAll(constraintViolations.stream()
	        .map(constraintViolation -> String.format("%s valor '%s' %s", constraintViolation.getPropertyPath(),
	                constraintViolation.getInvalidValue(), constraintViolation.getMessage()))
	        .collect(Collectors.toList()));

	return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);

	}
	
	
	
	private List<Erro> creatListErro(BindingResult bindingResult){
		List<Erro> erros =  new ArrayList<>();
		
		for (FieldError fieldError : bindingResult.getFieldErrors()) {
			String messageForUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String messageForDeveloper = fieldError.toString();
			erros.add(new Erro(messageForUser, messageForDeveloper));
		}
		return erros;
	}

	
	public static class Erro {
		
		private String messageForUser;
		private String  messageForDeveloper;
		
		public Erro(String messageForUser,String  messageForDeveloper) {
			this.messageForUser = messageForUser;
			this.messageForDeveloper = messageForDeveloper;
		}
		
		public String getMessageForUser() {
			return messageForUser;
		}
		public void setMessageForUser(String messageForUser) {
			this.messageForUser = messageForUser;
		}
		public String getMessageForDeveloper() {
			return messageForDeveloper;
		}
		public void setMessageForDeveloper(String messageForDeveloper) {
			this.messageForDeveloper = messageForDeveloper;
		}
	}
}
