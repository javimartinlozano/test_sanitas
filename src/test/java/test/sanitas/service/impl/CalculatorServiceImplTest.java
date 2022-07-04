package test.sanitas.service.impl;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import test.sanitas.service.CalculatorService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CalculatorServiceImplTest {

	private CalculatorService calculatorService = new CalculatorServiceImpl();

	@Test
	public void sumaTest() {
		BigDecimal result = calculatorService.suma(BigDecimal.ONE, BigDecimal.ONE);
		Assert.assertNotNull(result);
		Assert.assertEquals(BigDecimal.valueOf(2), result);
	}

	@Test
	public void restaTest() {
		BigDecimal result = calculatorService.resta(BigDecimal.ONE, BigDecimal.ONE);
		Assert.assertNotNull(result);
		Assert.assertEquals(BigDecimal.ZERO, result);
	}
}
