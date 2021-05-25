package app.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class CookieController {

	private final Result result;
	public CookieController(Result result) {
		this.result = result;
	}
	
	@Get("/cookie/teste")
	public void cria(HttpServletResponse response) {
		response.addCookie(new Cookie("rest-assured", "funciona"));
		response.addHeader("novo-header", "abc");
		result.nothing();
	}
}
