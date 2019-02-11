# java-SpringBootSOAPWS
Ejemplo de servicio web SOAP con Spring Boot framwork


Utiliza maven:

añadir proyecto a eclipse y click en confiugre-> convert to maven proyect

click der sobre el proyecto, Maven->update project...

ejecutar AplicacionSpringBoot.java


abrir aplicacion(instalada antes) SOAPUI

File new SOAP proyect

click der sobre el proyecto, New Rest service from uri

method:

POST


endpoint:

http://localhost:8080/ws


media type:

text/xml


texto a enviar:

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
				  xmlns:gs="http://localhost:8080/ws/esquemaPaises.xsd">
   <soapenv:Header/>
   <soapenv:Body>
      <gs:PeticionDamePais>
         <gs:nombre>Reino Unido</gs:nombre>
      </gs:PeticionDamePais>
   </soapenv:Body>
</soapenv:Envelope>

->PLAY
