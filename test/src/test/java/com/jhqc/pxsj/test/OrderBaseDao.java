package com.jhqc.pxsj.test;

import java.util.List;

import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.test.domain.OrderBase;
import com.jhqc.pxsj.test.oldpojos.CreateOrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryCountPO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryRequestPO;
import com.jhqc.pxsj.test.oldpojos.UserOrderDetailPO;

/**
 * 描述: 订单Dao
 * @author HYF
 * @since
 * @date 2016年9月2日 下午5:25:15
 */
public interface OrderBaseDao {
	
	/**
	 * 添加订单
	 * @param entity
	 * @return
	 */
	Long addOrderBase(CreateOrderBasePO entity);
	
	OrderBasePO getOrderBaseByOrderNo(String orderNo);
	
	int checkUpdateOrderMaintainDateExpire(String orderNo);
	
	List<OrderBasePO> getOrderBaseByTransactionCode(String transactionCode);
	
	List<OrderBase> getOrderBaseByUserId(Long userId);
	
	int updateOrderBaseByStatus(String orderNo, String status);
	
	int updateOrderBaseByOrderStatus(String orderNo, String orderStatus);
	
	int[] batchAddOrderBase(final List<CreateOrderBasePO> orderBases);
	
	List<OrderBasePO> queryOrderBaseForShop(OrderQueryRequestPO request);
	
	int queryOrderCountBase(OrderQueryCountPO request);
	
	String queryOrderPriceForShopIndex(long shopId,String nextNodeCode,java.sql.Date endDateStart,java.sql.Date endDateEnd);
	
	Long queryOrderCountForShopIndex(long shopId,java.sql.Date creasteDateStart,java.sql.Date createDateEnd);
	
	int updateOrderMaintainDate(String orderNo, int maintainDays,DateAdd.Type type);
	
	int addOrderMaintainDate(String orderNo, int maintainDays,DateAdd.Type type);
	
	boolean checkOrderMaintainDateExpire(String orderNo);
	
	List<OrderBasePO> getOrderBaseByShopId(long shopId);
	
	List<UserOrderDetailPO> getUserOrderDetailPageList(Long userId,
            String orderType, java.sql.Date startTime, java.sql.Date lastTime,
            String orderStatus, String payCode, String orderNo, int index,
            int size);
}