package app.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import app.models.Usuario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class UsuarioRepositoryImpl
    implements UsuarioRepository {

	private static List<Usuario> usuarios = new ArrayList<Usuario>();
	
	static {
		usuarios.add(new Usuario(1L, "Mauricio Aniche", "mauricio.aniche@caelum.com.br"));
		usuarios.add(new Usuario(2L, "Guilherme Silveira", "guilherme.silveira@caelum.com.br"));
	}
	
	@Override
	public void create(Usuario entity) {
		entity.setId(Math.abs(new Random().nextLong()));
		usuarios.add(entity);
	}

	@Override
	public Usuario update(Usuario entity) {
		delete(entity);
		
		usuarios.add(entity);
		return entity;
	}

	private void delete(Usuario entity) {
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			Usuario current = it.next();
			System.out.println("current " + current);
			System.out.println("entity " + entity);
			if(current.getId() == entity.getId()) {
				it.remove();
				break;
			}
		}
	}

	@Override
	public void destroy(Usuario entity) {
		delete(entity);
	}

	@Override
	public Usuario find(Long id) {
		for(Usuario u : usuarios) {
			if(u.getId() == id) return u;
		}
		return null;
	}

	@Override
	public List<Usuario> findAll() {
		return Collections.unmodifiableList(usuarios);
	}

}
