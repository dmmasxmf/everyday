package com.dmm.strategys;

import com.dmm.bean.Order;

/**
 * @author Mr. Du
 * @explain
 * @createTime 2019/12/12 19:52
 * @motto If you would have leisure, do not waste it.
 */

public interface OrderStrategy {

    void handleOrder(Order order);
}
