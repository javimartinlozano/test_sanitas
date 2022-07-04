package test.sanitas.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RunWith(SpringJUnit4ClassRunner.class)
public class ExceptionControllerTest {

	@InjectMocks
	private ExceptionController exceptionController;

	@Mock
	private WebRequest webRequest;

	@Test
	public void handleConstraintViolationExceptionTest() {
		ResponseEntity<Object> result = exceptionController.handleConstraintViolation(new Exception("exception"),
				webRequest);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals("exception", result.getBody());
	}

	@Test
	public void handleConstraintViolationMissingServletRequestParameterExceptionTest() {
		ResponseEntity<Object> result = exceptionController.handleConstraintViolation(
				new MissingServletRequestParameterException("paramName", "paramType"), webRequest);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals("Parámetro obligatorio no informado: paramName", result.getBody());
	}

	@Test
	public void handleConstraintViolationMethodArgumentTypeMismatchExceptionTest() {
		ResponseEntity<Object> result = exceptionController.handleConstraintViolation(
				new MethodArgumentTypeMismatchException(null, null, "name", null, null), webRequest);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals("Parámetro con tipo incorrecto: name", result.getBody());
	}
}
