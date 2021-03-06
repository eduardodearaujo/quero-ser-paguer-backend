package com.br.meupag.ordersapi.lambda.handler;

import java.util.Map;

import org.jboss.logging.Logger;

import com.br.meupag.ordersapi.db.service.OrderService;
import com.br.meupag.ordersapi.domain.Order;
import com.br.meupag.ordersapi.lambda.handler.abs.AbstractDeleteHandler;

public class DeleteOrderHandler extends AbstractDeleteHandler<Order> {
	
	public DeleteOrderHandler() {
		this.service = new OrderService();
		this.logger = Logger.getLogger(DeleteOrderHandler.class);
	}
	
	protected Order createHolderEntityFromRequest(Map<String, Object> request) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> parameters = (Map<String, String>) request.get("pathParameters");
		
		Order order = new Order();
		order.setId(Long.parseLong(parameters.get("id")));
		
		return order;
	}

}
