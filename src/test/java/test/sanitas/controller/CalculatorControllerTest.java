package test.sanitas.controller;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.sanitas.service.CalculatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorControllerTest {

	@InjectMocks
	private CalculatorController controller;

	@Mock
	private CalculatorService calculatorService;

	@Test
	public void sumaTest() {
		Mockito.when(calculatorService.suma(Mockito.any(), Mockito.any())).thenReturn(BigDecimal.valueOf(2));
		ResponseEntity<BigDecimal> result = controller.suma(BigDecimal.ONE, BigDecimal.ONE);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals(BigDecimal.valueOf(2), result.getBody());
	}

	@Test
	public void restaTest() {
		Mockito.when(calculatorService.resta(Mockito.any(), Mockito.any())).thenReturn(BigDecimal.ZERO);
		ResponseEntity<BigDecimal> result = controller.resta(BigDecimal.ONE, BigDecimal.ONE);
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getBody());
		Assert.assertEquals(BigDecimal.ZERO, result.getBody());
	}
}
