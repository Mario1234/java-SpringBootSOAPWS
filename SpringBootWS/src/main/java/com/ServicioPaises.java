package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.jaxb.PeticionDamePais;
import com.jaxb.RespuestaDamePais;

@Endpoint
public class ServicioPaises {

	private RepositorioPaises repositorioPaises;

	@Autowired
	public ServicioPaises(RepositorioPaises repPai) {
		this.repositorioPaises = repPai;
	}

	@PayloadRoot(namespace = Constantes.RUTA_ESPACIO_NOMBRES, localPart = "PeticionDamePais")
	@ResponsePayload
	public RespuestaDamePais damePais(@RequestPayload PeticionDamePais petDamPai) {
		RespuestaDamePais resDamPai = new RespuestaDamePais();
		resDamPai.setPais(repositorioPaises.encuentraPais(petDamPai.getNombre()));

		return resDamPai;
	}
}
