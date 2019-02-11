package com;
import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.jaxb.Moneda;
import com.jaxb.Pais;

@Component
public class RepositorioPaises {
	private static final Map<String, Pais> mapaPaises = new HashMap<>();

	@PostConstruct
	public void initData() {
		Pais espania = new Pais();
		espania.setNombre("Espania");
		espania.setCapital("Madrid");
		espania.setMoneda(Moneda.EUR);
		espania.setPoblacion(46704314);

		mapaPaises.put(espania.getNombre(), espania);

		Pais polonia = new Pais();
		polonia.setNombre("Polonia");
		polonia.setCapital("Varsovia");
		polonia.setMoneda(Moneda.PLN);
		polonia.setPoblacion(38186860);

		mapaPaises.put(polonia.getNombre(), polonia);

		Pais uk = new Pais();
		uk.setNombre("Reino Unido");
		uk.setCapital("Londres");
		uk.setMoneda(Moneda.GBP);
		uk.setPoblacion(63705000);

		mapaPaises.put(uk.getNombre(), uk);
	}

	public Pais encuentraPais(String nombre) {
		Assert.notNull(nombre, "el nombre del pais no debe ser nulo");
		return mapaPaises.get(nombre);
	}
}
