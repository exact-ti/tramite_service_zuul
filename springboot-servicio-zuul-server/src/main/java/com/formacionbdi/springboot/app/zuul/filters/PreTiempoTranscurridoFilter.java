package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter{

	private static  Logger Log  = org.slf4j.LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);
	
	
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//Logica
	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx =  RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		Log.info(String.format("request enrutado a ", request.getMethod(), request.getRequestURL().toString()));

		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		return null;
	}

	//1RO DEFINIR EL TIPO DE FILTRO
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
