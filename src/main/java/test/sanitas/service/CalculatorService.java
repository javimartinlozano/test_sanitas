/**
 * 
 */
package test.sanitas.service;

import java.math.BigDecimal;

/**
 * Interfaz CalculatorService.
 *
 */
public interface CalculatorService {

	/**
	 * Servicio encargado de realizar la suma.
	 * 
	 * @param valor1 the valor1
	 * @param valor2 the valor2
	 * @return resultado suma
	 */
	public BigDecimal suma(BigDecimal valor1, BigDecimal valor2);

	/**
	 * Servicio encargado de realizar la resta.
	 * 
	 * @param valor1 the valor1
	 * @param valor2 the valor2
	 * @return resultado resta
	 */
	public BigDecimal resta(BigDecimal valor1, BigDecimal valor2);
}
