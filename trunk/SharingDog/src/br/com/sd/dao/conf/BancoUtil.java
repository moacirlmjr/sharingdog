package br.com.sd.dao.conf;

import javax.persistence.EntityManager;

import br.com.sd.dao.HibernateUtil;
import br.com.sd.modelo.Cachorro;
import br.com.sd.modelo.Porte;
import br.com.sd.modelo.Raca;
import br.com.sd.modelo.Role;
import br.com.sd.modelo.Usuario;
import br.com.sd.util.ModeloUtil;

public class BancoUtil {

	public static void popula() {
		EntityManager em = new HibernateUtil().getEntityManager();

		// roles
		em.getTransaction().begin();

		for (Role role : ModeloUtil.roles) {
			em.persist(role);
		}
		em.getTransaction().commit();

		// criando usuarios
		em.getTransaction().begin();
		for (Usuario user : ModeloUtil.usuarios) {
			em.persist(user);
		}
		em.getTransaction().commit();

		// criando porte
		em.getTransaction().begin();
		for (Porte porte : ModeloUtil.portes) {
			em.persist(porte);
		}
		em.getTransaction().commit();

		// criando Racas
		em.getTransaction().begin();
		for (Raca raca : ModeloUtil.racas) {
			em.persist(raca);
		}
		em.getTransaction().commit();

		// criando Cachorros
		em.getTransaction().begin();
		for (Cachorro cachorro : ModeloUtil.cachorros) {
			em.persist(cachorro);
		}
		em.getTransaction().commit();
		em.close();

	}

}
