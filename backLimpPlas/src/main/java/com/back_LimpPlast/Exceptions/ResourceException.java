package com.back_LimpPlast.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class ResourceException extends RuntimeException {
   private static final long serialVersionUID = 1L;

   String Mensagem;
   
   public ResourceException(String e) {
	
	   super(e);
}
}
