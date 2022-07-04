package test.sanitas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * Controlador de excepciones.
 *
 */
@ControllerAdvice
public class ExceptionController {

	/**
	 * Método de manejo de errores.
	 * @param ex la excepción
	 * @param request la request
	 * @return la respuesta
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleConstraintViolation(Exception ex, WebRequest request) {
		if (ex instanceof MissingServletRequestParameterException) {
			String mensaje = "Parámetro obligatorio no informado: "
					+ ((MissingServletRequestParameterException) ex).getParameterName();
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}
		if (ex instanceof MethodArgumentTypeMismatchException) {
			String mensaje = "Parámetro con tipo incorrecto: "
					+ ((MethodArgumentTypeMismatchException) ex).getName();
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
