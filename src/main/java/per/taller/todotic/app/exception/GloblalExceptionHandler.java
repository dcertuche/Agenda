package per.taller.todotic.app.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GloblalExceptionHandler {

	private final MessageSource messageSource;

	@Autowired
	public GloblalExceptionHandler(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	ResponseEntity<?> handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, Object> errorDetail = new HashMap<>();
		errorDetail.put("title", "Erro de validacion");
		errorDetail.put("code", "invalid_form");
		errorDetail.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());

		List<String> errors = new ArrayList<>();
		for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
			// String message = fieldError.getDefaultMessage();
			String message = messageSource.getMessage(fieldError, Locale.getDefault());
			errors.add(message);
		}
		errorDetail.put("errors", errors);
		return new ResponseEntity<>(errorDetail, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler(EntityNotFoundException.class)
	public void handleEntityNotFoundException(EntityNotFoundException exception) {

	}
}
