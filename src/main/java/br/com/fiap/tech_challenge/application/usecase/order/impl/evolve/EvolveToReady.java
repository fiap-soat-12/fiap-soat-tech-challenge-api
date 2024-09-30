package br.com.fiap.tech_challenge.application.usecase.order.impl.evolve;

import br.com.fiap.tech_challenge.domain.models.Order;
import br.com.fiap.tech_challenge.domain.models.enums.OrderStatusEnum;

public class EvolveToReady implements EvolveRules {

    @Override
    public void evolveTo(Order order) {
        if(OrderStatusEnum.PREPARING.equals(order.getStatus())){
            order.setStatusReady();
        }
    }
}
