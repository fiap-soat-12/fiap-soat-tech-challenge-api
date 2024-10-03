package br.com.fiap.tech_challenge.application.usecase.order.impl.evolve;

import br.com.fiap.tech_challenge.domain.models.Order;
import br.com.fiap.tech_challenge.domain.models.enums.OrderStatusEnum;

public class EvolveToFinished implements EvolveRules {

	@Override
	public void evolveTo(Order order) {
		if (OrderStatusEnum.READY.equals(order.getStatus())) {
			order.setStatusFinished();
		}
	}

}
