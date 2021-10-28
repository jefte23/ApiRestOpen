package br.com.bb.ditec.gesit.capacidade.api.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public void  method(HttpServletResponse rponse , HttpServletRequest req) throws IOException {
		String  url = new StringBuilder().append(req.getScheme())
		.append("://")
		.append(req.getServerName())
		.append(":")
		.append(req.getServerPort())
	.append(req.getRequestURI())
		.append("swagger-ui.html").toString();

		rponse.sendRedirect( url );
		
		
    }

}
