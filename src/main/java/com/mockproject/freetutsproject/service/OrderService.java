package com.mockproject.freetutsproject.service;

import com.mockproject.freetutsproject.dto.OrderDTO;

public interface OrderService extends AbstractService<OrderDTO> {
    OrderDTO updateStatus(boolean status, long id);
}
