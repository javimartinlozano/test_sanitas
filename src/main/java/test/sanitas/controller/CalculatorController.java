/**
 * 
 */
package test.sanitas.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.corp.calculator.TracerImpl;
import test.sanitas.service.CalculatorService;

/**
 * CalculatorController.
 *
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {

	@Autowired
	private CalculatorService calculatorService;

	/**
	 * Operación suma.
	 *
	 * @param valor1
	 * @param valor2
	 * @return resultado
	 */
	@GetMapping("/suma")
	public ResponseEntity<BigDecimal> getSuma(@RequestParam(name = "valor1", required = true) BigDecimal valor1,
			@RequestParam(name = "valor2", required = true) BigDecimal valor2) {
		BigDecimal resultado = calculatorService.suma(valor1, valor2);
		// la interfaz TracerAPI no se puede utilizar, porque no tiene implementación
		// utiliamos directamente la clase TracerImpl
		new TracerImpl().trace(resultado);
		return ResponseEntity.ok(resultado);
	}

	/**
	 * Operación resta.
	 *
	 * @param valor1
	 * @param valor2
	 * @return resultado
	 */
	@GetMapping("/resta")
	public ResponseEntity<BigDecimal> getResta(@RequestParam(name = "valor1", required = true) BigDecimal valor1,
			@RequestParam(name = "valor2", required = true) BigDecimal valor2) {
		BigDecimal resultado = calculatorService.resta(valor1, valor2);
		// la interfaz TracerAPI no se puede utilizar, porque no tiene implementación
		// utiliamos directamente la clase TracerImpl
		new TracerImpl().trace(resultado);
		return ResponseEntity.ok(resultado);
	}
}
