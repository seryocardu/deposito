import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParametrizacionDepCombustibleCRR {
	private double depMax;	
	private double depNivel;     	
	private DepositoCombustible pdc;
	
	@Before
	public void inicio(){
		pdc = new DepositoCombustible(depMax,depNivel);
	}
	
	@After
	public void fin(){
		pdc = null;
	}
	
	//Constructor necesario
	public ParametrizacionDepCombustibleCRR(double n, double m)  
	{
		this.depMax = n;
		this.depNivel = m;		
		
	}

	//En este metodo se introduce la bateria de pruebas
	@Parameters    	
	public static Collection<Object[]> pruebasConsumo()	{
		
		return Arrays.asList( new Object[][]{{30,15}} );		
	}
		
	@Test
	public void testGetDepositoNivel() {		
			
		double resultado = pdc.getDepositoNivel();
		assertEquals(depNivel,resultado,0);		
	}
	
	@Test
	public void testGetDepositoMax() {			
		
		double resultado = pdc.getDepositoMax();
		assertEquals(depMax,resultado,0);
	}

	@Test
	public void testEstaVacio() {		
		
		boolean vacio = pdc.estaVacio();
		if (depNivel != 0)		
		assertFalse(false);		
	}	
	
	@Test
	public void testDepositoMitad() {		
		
		double mitad = pdc.getDepositoMax()/2;
		assertEquals(depNivel,mitad,0);
	}	
}
