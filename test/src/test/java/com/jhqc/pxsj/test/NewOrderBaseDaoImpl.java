package com.jhqc.pxsj.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jhqc.pxsj.core.CriteriaBuilder;
import com.jhqc.pxsj.core.query.Insert;
import com.jhqc.pxsj.core.query.Query;
import com.jhqc.pxsj.core.query.Query.OrderType;
import com.jhqc.pxsj.core.query.Update;
import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.dao.integration.BaseDao;
import com.jhqc.pxsj.test.domain.OrderBase;
import com.jhqc.pxsj.test.domain.OrderBase_;
import com.jhqc.pxsj.test.domain.OrderDelivery;
import com.jhqc.pxsj.test.domain.OrderMonitor;
import com.jhqc.pxsj.test.domain.OrderMonitor_;
import com.jhqc.pxsj.test.domain.OrderPay;
import com.jhqc.pxsj.test.domain.OrderPayType;
import com.jhqc.pxsj.test.domain.OrderPay_;
import com.jhqc.pxsj.test.domain.Status;
import com.jhqc.pxsj.test.oldpojos.CreateOrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryCountPO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryRequestPO;
import com.jhqc.pxsj.test.oldpojos.Page;
import com.jhqc.pxsj.test.oldpojos.UserOrderDetailPO;

@Repository
public class NewOrderBaseDaoImpl extends BaseDao implements OrderBaseDao {
    @Autowired
    private JdbcTemplate jtm;
    
    @Autowired
    private CriteriaBuilder builder;
    
    private Insert<OrderBase> INSERT_ORDER_BASE;
    
    @Autowired
    public NewOrderBaseDaoImpl(JdbcTemplate jtm, CriteriaBuilder builder) {
        super(jtm, builder);
    }
    
    @PostConstruct
    public void init() {
        INSERT_ORDER_BASE = builder.creatInsert(OrderBase.class);
    }

    @Override
    public Long addOrderBase(CreateOrderBasePO entity) {
        OrderBase orderBase = convertCreateOrderBase(entity);
        
        insert(orderBase, INSERT_ORDER_BASE);
        
        return orderBase.getOrderId();
    }

    @Override
    public OrderBasePO getOrderBaseByOrderNo(String orderNo) {
        Query<OrderBasePO> query = builder.trick(OrderBasePO.class).root(OrderBase.class, "orderBase").eq(OrderBase_.orderNo, orderNo)
                                                                   .join(OrderMonitor.class, "orderMonitor")
                                                                   .done()
                                                                   .autoSelect()
                                                                   .done();
        
        return super.queryForBeanObject(query);
    }   

    @Override
    public List<OrderBasePO> getOrderBaseByTransactionCode(
            String transactionCode) {
        Query<OrderBasePO> query = builder.trick(OrderBasePO.class).root(OrderBase.class, "orderBase").eq(OrderBase_.transactionCode, transactionCode)
                                                                   .join(OrderMonitor.class, "orderMonitor")
                                                                   .done()
                                                                   .autoSelect()
                                                                   .done();
        
        return super.queryForBeanList(query);
    }

    @Override
    public List<OrderBase> getOrderBaseByUserId(Long userId) {
        Query<OrderBase> query = builder.trick(OrderBase.class).root(OrderBase.class, "orderBase").eq(OrderBase_.userId, userId)
                                                               .done().autoSelect().done();
        
        return super.queryForBeanList(query);
    }

    @Override
    public int updateOrderBaseByStatus(String orderNo, String status) {
        Update<OrderBase> update = builder.trickUpdate(OrderBase.class).root().eq(OrderBase_.userStatus, Status.VALID)
                                                                              .eq(OrderBase_.orderNo, orderNo)
                                                                       .done()
                                                                       .set(OrderBase_.userStatus, Status.INVLIAD)
                                                                       .done();
        
        return super.update(update);
    }
    
    @Override
    public int checkUpdateOrderMaintainDateExpire(String orderNo) {
        Query<Integer> query = builder.trick(Integer.class).root(OrderBase.class, "orderBase").eq(OrderBase_.orderNo, orderNo)
                                                           .done().select("orderBase", OrderBase_.maintainStatus).done();
        
        return super.queryForSimpleObject(query);
    }

    @Override
    public int updateOrderBaseByOrderStatus(String orderNo, String orderStatus) {
        Update<OrderBase> update = builder.trickUpdate(OrderBase.class).root().eq(OrderBase_.shopStatus, Status.VALID)
                                                                              .eq(OrderBase_.orderNo, orderNo)
                                                                       .done()
                                                                       .set(OrderBase_.shopStatus, Status.INVLIAD)
                                                                       .done();
        
        return super.update(update);
    }

    @Override
    public int[] batchAddOrderBase(List<CreateOrderBasePO> orderBases) {
        List<OrderBase> paramsList = new ArrayList<>();
        
        for(CreateOrderBasePO po : orderBases) {
            OrderBase base = convertCreateOrderBase(po);
            paramsList.add(base);
        }
        
        super.insert(paramsList, INSERT_ORDER_BASE);
        
        int[] result = new int[paramsList.size()];
        
        int i = 0;
        for(OrderBase b : paramsList) {
            result[i++] = b.getOrderId().intValue();
        }
        
        return result;
    }
    
    private static OrderBase convertCreateOrderBase(CreateOrderBasePO entity) {
        OrderBase orderBase = new OrderBase();
        
        orderBase.setOrderNo(entity.getOrderNo());
        orderBase.setTemplateCode(entity.getTemplateCode());
        orderBase.setTransactionCode(entity.getTransactionCode());
        orderBase.setOrderType(entity.getOdrerType() == null? null : entity.getOdrerType().toString());
        orderBase.setShopId(entity.getShopId());
        orderBase.setUserId(entity.getUserId());
        orderBase.setOrderSum(entity.getOrderSum().intValue());
        orderBase.setOrderAmt(entity.getOrderAmt().intValue());
        orderBase.setDeliveryFee(entity.getDeliveryFee().intValue());
        orderBase.setMerchandiseQuantity(entity.getMerchandiseQtyTotal());
        orderBase.setShopStatus(Status.VALID);
        orderBase.setUserStatus(Status.INVLIAD);
        orderBase.setMaintainStatus("0");
        orderBase.setLinkTel(entity.getLinkTel());
        orderBase.setUserRemake(entity.getUserRemake());
        
        return orderBase;
    }

    @Override
    public List<OrderBasePO> queryOrderBaseForShop(OrderQueryRequestPO request) {
        OrderType orderType = OrderType.DESC;
        if(!StringUtils.isEmpty(request.getOrderBy())) {
            orderType = "desc".equals(request.getOrderBy())? OrderType.DESC:OrderType.ASC;
        }
        
        Page page = request.getPage();
        if(page == null) {
            page = new Page(Page.DEFAULT_INDEX - 1, Page.DEFAULT_SIZE);
        }
        
        Date endDate = request.getEndDate();
        if(endDate != null) {
            endDate = DateUtils.addDays(endDate, 1);
        }
        
        Query<OrderBasePO> query = builder.trick(OrderBasePO.class)
                                          .root(OrderBase.class, "orderBase")
                                              .eqIf(OrderBase_.shopId, request.getShopId(), Objects::nonNull)
                                              .eqIf(OrderBase_.userId, request.getUserId(), Objects::nonNull)
                                              .eqIf(OrderBase_.orderType, request.getOrderType(), StringUtils::isNotEmpty)
                                              .likeIf(OrderBase_.orderNo, "%" + request.getOrderNo() + "%", t-> StringUtils.isNotEmpty(request.getOrderNo()))
                                              .geIf(OrderBase_.createDate, request.getStartDate(), Objects::nonNull)
                                              .ltIf(OrderBase_.createDate, endDate, Objects::nonNull)
                                              .eqIf(OrderBase_.userStatus, request.getStatus(), Objects::nonNull)
                                              .eqIf(OrderBase_.shopStatus, request.getOrderStatus(), Objects::nonNull)
                                          .join(OrderMonitor.class, "orderMonitor")
                                              .eqIf(OrderMonitor_.nextNodeCode, request.getNextNodeCode(), StringUtils::isNotEmpty)
                                          .done()
                                          .autoSelect()
                                          .orderBy("orderBase", OrderBase_.createDate, orderType)
                                          .limit(page.getOffset(), page.getSize())
                                          .done();
        
        return super.queryForBeanList(query);
    }

    @Override
    public int queryOrderCountBase(OrderQueryCountPO request) {
        Date endDate = request.getEndDate();
        if(endDate != null) {
            endDate = DateUtils.addDays(endDate, 1);
        }
        
        Query<Long> query = builder.trick(Long.class)
                                        .root(OrderBase.class, "orderBase")
                                            .eqIf(OrderBase_.shopId, request.getShopId(), Objects::nonNull)
                                            .eqIf(OrderBase_.userId, request.getUserId(), Objects::nonNull)
                                            .geIf(OrderBase_.createDate, request.getStartDate(), Objects::nonNull)
                                            .ltIf(OrderBase_.createDate, endDate, Objects::nonNull)
                                            .eqIf(OrderBase_.userStatus, request.getStatus(), Objects::nonNull)
                                            .eqIf(OrderBase_.shopStatus, request.getOrderStatus(), Objects::nonNull)
                                            .eqIf(OrderBase_.orderType, request.getOrderType(), Objects::nonNull)
                                        .join(OrderMonitor.class, "orderMonitor")
                                            .eqIf(OrderMonitor_.nextNodeCode, request.getNextNodeCode(), StringUtils::isNotEmpty)
                                        .done()
                                        .count();
        
        return super.queryForSimpleObject(query).intValue();
    }

    @Override
    public String queryOrderPriceForShopIndex(long shopId, String nextNodeCode,
            java.sql.Date endDateStart, java.sql.Date endDateEnd) {        
        Query<String> query = builder.trick(String.class)
                                        .root(OrderBase.class, "orderBase")
                                            .eq(OrderBase_.shopId, shopId)
                                        .join(OrderMonitor.class, "orderMonitor")
                                            .eq(OrderMonitor_.nextNodeCode, nextNodeCode)
                                            .ge(OrderMonitor_.endDate, endDateStart)
                                            .lt(OrderMonitor_.endDate, DateUtils.addDays(endDateEnd, 1))
                                        .done()
                                        .sum("orderBase", OrderBase_.orderAmt);
        
        return super.queryForSimpleObject(query);
    }

    @Override
    public Long queryOrderCountForShopIndex(long shopId,
            java.sql.Date creasteDateStart, java.sql.Date createDateEnd) {
        Query<Long> query = builder.trick(Long.class).root(OrderBase.class, "orderBase")
                                                         .eq(OrderBase_.shopId, shopId)
                                                         .ge(OrderBase_.createDate, creasteDateStart)
                                                         .lt(OrderBase_.createDate, DateUtils.addDays(createDateEnd, 1))
                                                         .done()
                                                         .count();
        
        return super.queryForSimpleObject(query);
    }

    @Override
    public int updateOrderMaintainDate(String orderNo, int maintainDays,
            DateAdd.Type type) {
        Update<OrderBase> update = builder.trickUpdate(OrderBase.class)
                                          .root().eq(OrderBase_.orderNo, orderNo).notEq(OrderBase_.maintainStatus, "1")
                                          .done()
                                          .set(OrderBase_.maintainStatus, "1")
                                          .setEx(OrderBase_.maintainDate, (r, p)->builder.dateAdd(r.get(p), maintainDays, type))
                                          .done();
        return super.update(update);
    }

    @Override
    public int addOrderMaintainDate(String orderNo, int maintainDays,
            DateAdd.Type type) {
        Update<OrderBase> update = builder.trickUpdate(OrderBase.class)
                                          .root().eq(OrderBase_.orderNo, orderNo)
                                                 .eq(OrderBase_.maintainStatus, "0")
                                                 .isNull(OrderBase_.maintainDate)
                                          .done()
                                          .set(OrderBase_.maintainDate, builder.dateAdd(builder.now(), maintainDays, type))
                                          .done();
        
        return super.update(update);
    }

    @Override
    public boolean checkOrderMaintainDateExpire(String orderNo) {
        Query<Integer> query = builder.trick(Integer.class).root(OrderBase.class, "orderBase")
                                                           .eq(OrderBase_.orderNo, orderNo)
                                                           .lt(OrderBase_.maintainDate, builder.now())
                                                           .done()
                                                           .count();
        
        return super.queryForSimpleObject(query) > 0;
    }

    @Override
    public List<OrderBasePO> getOrderBaseByShopId(long shopId) {
        Query<OrderBasePO> query = builder.trick(OrderBasePO.class).root(OrderBase.class, "orderBase").eq(OrderBase_.shopId, shopId)
                                                                   .join(OrderMonitor.class, "orderMonitor")
                                                                   .done()
                                                                   .autoSelect()
                                                                   .done();
        
        return super.queryForBeanList(query);
    }

    @Override
    public List<UserOrderDetailPO> getUserOrderDetailPageList(Long userId,
            String orderType, java.sql.Date startTime, java.sql.Date lastTime,
            String orderStatus, String payCode, String orderNo, int index,
            int size) {
        Date last = lastTime;
        if(lastTime != null) {
            last = DateUtils.addDays(lastTime, 1);
        }
        
        Query<UserOrderDetailPO> query = builder.trick(UserOrderDetailPO.class)
                                                .root(OrderBase.class, "orderBase")
                                                    .eqIf(OrderBase_.userId, userId, Objects::nonNull)
                                                    .eqIf(OrderBase_.orderType, orderType, StringUtils::isNotEmpty)
                                                    .geIf(OrderBase_.createDate, startTime, Objects::nonNull)
                                                    .ltIf(OrderBase_.createDate, last, Objects::nonNull)
                                                    .eqIf(OrderBase_.orderNo, orderNo, StringUtils::isNotEmpty)
                                                .leftJoin(OrderMonitor.class, "orderMonitor")
                                                    .eqIf(OrderMonitor_.currentNodeCode, orderStatus, StringUtils::isNotEmpty)
                                                .from("orderBase").leftJoin(OrderDelivery.class, "orderDelivery")
                                                .from("orderBase").leftJoin(OrderPay.class, "orderPay")
                                                    .eqIf(OrderPay_.payCode, payCode, StringUtils::isNotEmpty)
                                                .leftJoin(OrderPayType.class, "payType")
                                                .done()
                                                .autoSelect()
                                                .limit((index-1)*size, size)
                                                .done();
        
        return super.queryForBeanList(query);
    }
}
