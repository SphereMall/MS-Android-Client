package com.spheremall.core.shop;

import com.spheremall.core.SMClient;
import com.spheremall.core.entities.shop.Order;
import com.spheremall.core.entities.shop.OrderItem;
import com.spheremall.core.exceptions.SphereMallException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OrderFinalized {

    public static final int DEFAULT_ORDER_ID = -1;

    protected Order order;
    protected int id = DEFAULT_ORDER_ID;
    protected SMClient client;
    protected String version;

    public OrderFinalized(SMClient client, String verison) {
        this.client = client;
        this.version = verison;
    }

    public SMClient getClient() {
        return client;
    }

    public void setOrderData(Order order) {
        this.id = order.getId();
        this.order = order;
    }

    public void update(HashMap<String, String> params) throws SphereMallException, IOException {
        Order order = client.orders().update(id, params).data();
        setOrderData(order);
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public int getUserId() {
        if (this.order == null) {
            return 0;
        }
        return this.order.userId;
    }

    public List<OrderItem> getItems() {
        return order.items;
    }
}
