package br.com.fiap.tech_challenge.application.usecase.order.impl.evolve;

import br.com.fiap.tech_challenge.domain.models.Order;

public interface EvolveRules {

	void evolveTo(Order order);

}
