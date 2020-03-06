package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

	private static  Logger Log  = org.slf4j.LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//Logica
	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx =  RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Log.info("Entrando a post filter");

		Long tiempoInicio = (Long)request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal-tiempoInicio;
		
		
		Log.info(String.format("Tiempo transcurrido en segundos :", tiempoTranscurrido.doubleValue()/1000.00));
		Log.info(String.format("Tiempo transcurrido en milisegundos :", tiempoTranscurrido));
		
		
		return null;
	}

	//1RO DEFINIR EL TIPO DE FILTRO
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
