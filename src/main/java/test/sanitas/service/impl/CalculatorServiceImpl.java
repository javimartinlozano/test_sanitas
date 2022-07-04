package test.sanitas.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import test.sanitas.service.CalculatorService;

/**
 * Implementación de CalculatorService.
 *
 */
@Service
public class CalculatorServiceImpl implements CalculatorService {

	/**
	 * El logger.
	 */
	private Logger log = LoggerFactory.getLogger(CalculatorServiceImpl.class);

	@Override
	public BigDecimal suma(BigDecimal valor1, BigDecimal valor2) {
		log.info("Se procede a sumar los valores {} y {}", valor1, valor2);
		return valor1.add(valor2);
	}

	@Override
	public BigDecimal resta(BigDecimal valor1, BigDecimal valor2) {
		log.info("Se procede a restar los valores {} y {}", valor1, valor2);
		return valor1.subtract(valor2);
	}
}
