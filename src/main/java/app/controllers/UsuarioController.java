package app.controllers;

import java.util.List;

import app.models.Usuario;
import app.repositories.UsuarioRepository;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.com.caelum.vraptor.view.Results;

@Resource
public class UsuarioController {

	private final Result result;
	private final UsuarioRepository repository;
	private final Validator validator;
	
	UsuarioController(Result result, UsuarioRepository repository, Validator validator) {
		this.result = result;
		this.repository = repository;
		this.validator = validator;
	}
	
	@Get("/usuarios")
	public void index() {
		List<Usuario> todos = repository.findAll();
		System.out.println(todos);
		result.use(Results.representation()).from(todos).serialize();
	}
	
	@Post("/usuarios")
	@Consumes
	public void create(final Usuario usuario) {
		
		if (usuario.getNome().isEmpty()) {
		    validator.add(new ValidationMessage("Nome obrigatorio!", "error"));
		}
		if (usuario.getEmail().isEmpty()) {
		    validator.add(new ValidationMessage("E-mail obrigatorio!", "error"));
		}
		
		validator.onErrorSendBadRequest();
		
		repository.create(usuario);
		result.use(Results.representation()).from(usuario).serialize();
	}
	
	@Put("/usuarios")
	@Consumes
	public void update(Usuario usuario) {
		validator.validate(usuario);
		validator.onErrorSendBadRequest();
		repository.update(usuario);
		result.use(Results.representation()).from(usuario).serialize();
	}
	
	@Get("/usuarios/show")
	public void show(Usuario usuario) {
		result.use(Results.representation()).from(repository.find(usuario.getId())).serialize();
	}

	@Delete("/usuarios/deleta")
	@Consumes
	public void destroy(Usuario usuario) {
		repository.destroy(usuario);
		result.nothing();  
	}
}