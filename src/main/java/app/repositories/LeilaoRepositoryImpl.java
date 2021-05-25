package app.repositories;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import app.models.Leilao;
import app.models.Usuario;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class LeilaoRepositoryImpl
    implements LeilaoRepository {
	
	private static List<Leilao> leiloes = new ArrayList<Leilao>();
	
	static {
		
		Usuario mauricio = new Usuario(1l, "Mauricio Aniche", "mauricio.aniche@caelum.com.br");
		Usuario guilherme = new Usuario(2l, "Guilherme Silveira", "guilherme.silveira@caelum.com.br");

		Leilao l1 = new Leilao(1l, "Geladeira", 800.0, mauricio, false);
		Leilao l2 = new Leilao(2l, "XBox", 450.0, guilherme, false);
		leiloes.add(l1);
		leiloes.add(l2);
	}

	@Override
	public void create(Leilao entity) {
		leiloes.add(entity);
		
	}
	
	private void delete(Leilao entity) {
		Iterator<Leilao> it = leiloes.iterator();
		while(it.hasNext()) {
			Leilao current = it.next();
			if(current.getId() == entity.getId()) {
				it.remove();
				break;
			}
		}
	}

	@Override
	public Leilao update(Leilao entity) {
		delete(entity);
		leiloes.add(entity);
		return entity;
	}

	@Override
	public void destroy(Leilao entity) {
		delete(entity);
		
	}

	@Override
	public Leilao find(Long id) {
		for(Leilao u : leiloes) {
			if(u.getId() == id) return u;
		}
		return null;
	}

	@Override
	public List<Leilao> findAll() {
		return Collections.unmodifiableList(leiloes);
	}

	
}
