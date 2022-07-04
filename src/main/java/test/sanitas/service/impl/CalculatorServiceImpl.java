package test.sanitas.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import test.sanitas.service.CalculatorService;

/**
 * Implementación de CalculatorService.
 *
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Override
	public BigDecimal suma(BigDecimal valor1, BigDecimal valor2) {
		return valor1.add(valor2);
	}

	@Override
	public BigDecimal resta(BigDecimal valor1, BigDecimal valor2) {
		return valor1.subtract(valor2);
	}
}
