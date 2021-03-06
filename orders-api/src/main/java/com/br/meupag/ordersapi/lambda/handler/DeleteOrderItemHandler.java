package com.br.meupag.ordersapi.lambda.handler;

import java.util.Map;

import org.jboss.logging.Logger;

import com.br.meupag.ordersapi.db.service.OrderItemService;
import com.br.meupag.ordersapi.domain.OrderItem;
import com.br.meupag.ordersapi.lambda.handler.abs.AbstractDeleteHandler;

public class DeleteOrderItemHandler extends AbstractDeleteHandler<OrderItem> {
	
	public DeleteOrderItemHandler() {
		this.service = new OrderItemService();
		this.logger = Logger.getLogger(DeleteOrderItemHandler.class);
	}
	
	protected OrderItem createHolderEntityFromRequest(Map<String, Object> request) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, String> parameters = (Map<String, String>) request.get("pathParameters");
		
		OrderItem orderItem = new OrderItem();
		orderItem.setId(Long.parseLong(parameters.get("id")));
		
		return orderItem;
	}

}
