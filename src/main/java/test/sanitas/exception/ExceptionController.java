package test.sanitas.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	 * El logger.
	 */
	private Logger log = LoggerFactory.getLogger(ExceptionController.class);

	/**
	 * Método de manejo de errores.
	 * 
	 * @param ex      la excepción
	 * @param request la request
	 * @return la respuesta
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleConstraintViolation(Exception ex, WebRequest request) {
		log.error("Se ha producido una excepción", ex);
		log.info("Se procede a tratar la excepción");
		if (ex instanceof MissingServletRequestParameterException) {
			log.info("La excepción es de tipo MissingServletRequestParameterException");
			String mensaje = "Parámetro obligatorio no informado: "
					+ ((MissingServletRequestParameterException) ex).getParameterName();
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}
		if (ex instanceof MethodArgumentTypeMismatchException) {
			log.info("La excepción es de tipo MethodArgumentTypeMismatchException");
			String mensaje = "Parámetro con tipo incorrecto: " + ((MethodArgumentTypeMismatchException) ex).getName();
			return new ResponseEntity<>(mensaje, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
