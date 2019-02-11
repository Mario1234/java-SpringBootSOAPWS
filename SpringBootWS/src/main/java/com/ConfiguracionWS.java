package com;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ConfiguracionWS extends WsConfigurerAdapter {	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext contextoAplicacion) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(contextoAplicacion);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean(servlet, Constantes.RUTA_RELATIVA_SERVLET);
	}
	
	//	deja el wsdl en 
	//	http://localhost:8080/ws/paises.wsdl
	@Bean(name = "paises")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema esqPai) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName(Constantes.NOMBRE_PUERTO_SERVICIO);
		wsdl11Definition.setLocationUri(Constantes.RUTA_RELATIVA_SERVICIO);
		wsdl11Definition.setTargetNamespace(Constantes.RUTA_ESPACIO_NOMBRES);
		wsdl11Definition.setSchema(esqPai);
		return wsdl11Definition;
	}
	
	//	deja el xsd en 
	// http://localhost:8080/ws/esquemaPaises.xsd
	@Bean(name="esquemaPaises")
	public XsdSchema esquemaPaises() {
		return new SimpleXsdSchema(new ClassPathResource(Constantes.NOMBRE_ESQUEMA));
	}
}
