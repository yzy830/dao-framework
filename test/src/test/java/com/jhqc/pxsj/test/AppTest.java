package com.jhqc.pxsj.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.jhqc.pxsj.core.query.function.DateAdd;
import com.jhqc.pxsj.test.domain.OrderBase;
import com.jhqc.pxsj.test.domain.Status;
import com.jhqc.pxsj.test.oldpojos.CreateOrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderBasePO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryCountPO;
import com.jhqc.pxsj.test.oldpojos.OrderQueryRequestPO;
import com.jhqc.pxsj.test.oldpojos.UserOrderDetailPO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
public class AppTest {
    @Autowired
    private OrderBaseDao orderBaseDao;
    
    @Test
    @Transactional
    @Commit
    public void insertOrderBase() {
        CreateOrderBasePO createOrderBase = new CreateOrderBasePO();
        createOrderBase.setDeliveryFee(BigDecimal.valueOf(10));
        createOrderBase.setLinkTel("13402880645");
        createOrderBase.setMerchandiseQtyTotal(12);
        createOrderBase.setOdrerType(0);
        createOrderBase.setOrderAmt(BigDecimal.valueOf(1200));
        createOrderBase.setOrderNo("123");
        createOrderBase.setOrderSum(BigDecimal.valueOf(1200));
        createOrderBase.setShopId(1L);
        createOrderBase.setTemplateCode(null);
        createOrderBase.setTransactionCode("123");
        createOrderBase.setUserId(1L);
        
        Long id = orderBaseDao.addOrderBase(createOrderBase);
        System.out.println(id);
    }
    
    @Test
    public void queryOrderBasePoByOrderNo() {
        OrderBasePO po = orderBaseDao.getOrderBaseByOrderNo("228129485958504643");
        
        showOrderBasePO(po);
    }
    
    @Test
    public void queryOrderBasePoByTransactionNo() {
        List<OrderBasePO> pos = orderBaseDao.getOrderBaseByTransactionCode("220685900359401201");
        
        for(OrderBasePO po : pos) {
            System.out.println("******************");
            showOrderBasePO(po);
        }
    }
    
    @Test
    public void checkMaintainStatus() {
        Integer r = orderBaseDao.checkUpdateOrderMaintainDateExpire("228020120125600711");
        System.out.println("maintain status = " + r);
    }
    
    @Test
    public void getOrderBaseByUserId() {
        List<OrderBase> baseList = orderBaseDao.getOrderBaseByUserId(4L);
        
        for(OrderBase base : baseList) {
            System.out.println("*******************************");
            showOrderBase(base);
        }
    }
    
    @Test
    @Transactional
    public void updateOrderStatus() {
        int lineCount = orderBaseDao.updateOrderBaseByStatus("228020120125600711", "0");
        
        System.out.println(lineCount);
    }
    
    @Test
    @Transactional
    public void batchInsertOrderBase() {
        CreateOrderBasePO createOrderBase1 = new CreateOrderBasePO();
        createOrderBase1.setDeliveryFee(BigDecimal.valueOf(10));
        createOrderBase1.setLinkTel("13402880645");
        createOrderBase1.setMerchandiseQtyTotal(12);
        createOrderBase1.setOdrerType(0);
        createOrderBase1.setOrderAmt(BigDecimal.valueOf(1200));
        createOrderBase1.setOrderNo("123");
        createOrderBase1.setOrderSum(BigDecimal.valueOf(1200));
        createOrderBase1.setShopId(1L);
        createOrderBase1.setTemplateCode(null);
        createOrderBase1.setTransactionCode("123");
        createOrderBase1.setUserId(1L);
        
        CreateOrderBasePO createOrderBase2 = new CreateOrderBasePO();
        createOrderBase2.setDeliveryFee(BigDecimal.valueOf(10));
        createOrderBase2.setLinkTel("13402880673");
        createOrderBase2.setMerchandiseQtyTotal(15);
        createOrderBase2.setOdrerType(0);
        createOrderBase2.setOrderAmt(BigDecimal.valueOf(1500));
        createOrderBase2.setOrderNo("1234");
        createOrderBase2.setOrderSum(BigDecimal.valueOf(1500));
        createOrderBase2.setShopId(1L);
        createOrderBase2.setTemplateCode(null);
        createOrderBase2.setTransactionCode("1234");
        createOrderBase2.setUserId(1L);
        
        int[] result = orderBaseDao.batchAddOrderBase(Arrays.asList(createOrderBase1, createOrderBase2));
        System.out.println(Arrays.toString(result));
    }
    
    @Test
    public void queryOrderBaseForShop() {
        OrderQueryRequestPO po = new OrderQueryRequestPO();
        po.setOrderStatus(Status.INVLIAD);
        po.setNextNodeCode("END");
        po.setStartDate(new java.sql.Date(parseDate("2017-01-10").getTime()));
        po.setEndDate(new java.sql.Date(parseDate("2017-01-10").getTime()));
        
        List<OrderBasePO> list = orderBaseDao.queryOrderBaseForShop(po);
        
        for(OrderBasePO base : list) {
            System.out.println("***********************");
            showOrderBasePO(base);
        }
    }
    
    @Test
    public void queryOrderCountBase() {
        OrderQueryCountPO po = new OrderQueryCountPO();
        po.setNextNodeCode("END");
        System.out.println(orderBaseDao.queryOrderCountBase(po));
    }
    
    @Test
    public void queryOrderPriceForShopIndex() {
        java.sql.Date start = new java.sql.Date(parseDate("2017-01-07").getTime());
        java.sql.Date end = new java.sql.Date(parseDate("2017-01-07").getTime());
        System.out.println(orderBaseDao.queryOrderPriceForShopIndex(42, "END", start, end));
    }
    
    @Test
    public void queryOrderCountForShopIndex() {
        java.sql.Date start = new java.sql.Date(parseDate("2017-01-07").getTime());
        java.sql.Date end = new java.sql.Date(parseDate("2017-01-07").getTime());
        System.out.println(orderBaseDao.queryOrderCountForShopIndex(42, start, end));
    }
    
    @Test
    @Transactional
    public void updateOrderMaintainDate() {
        System.out.println(orderBaseDao.updateOrderMaintainDate("228129485958504643", 3, DateAdd.Type.MINUTE));
    }
    
    @Test
    @Transactional
    public void addOrderMaintainDate() {
        System.out.println(orderBaseDao.addOrderMaintainDate("228128251748802543", 3, DateAdd.Type.DAY));
    }
    
    @Test
    public void checkOrderMaintainDateExpire() {
        System.out.println(orderBaseDao.checkOrderMaintainDateExpire("228129485958504643"));
    }
    
    @Test
    public void getOrderBaseByShopId() {
        List<OrderBasePO> list = orderBaseDao.getOrderBaseByShopId(180);
        for(OrderBasePO po : list) {
            System.out.println("***************");
            showOrderBasePO(po);
        }
    }
    
    @Test
    public void getUserOrderDetailPageList() {
        java.sql.Date start = new java.sql.Date(parseDate("2016-12-22").getTime());
        java.sql.Date end = new java.sql.Date(parseDate("2016-12-22").getTime());
        List<UserOrderDetailPO> list = orderBaseDao.getUserOrderDetailPageList(1L, null, start, end, "TIMEOUT_CLOSE", "alipay", null, 1, 20);
        
        for(UserOrderDetailPO po : list) {
            System.out.println("*********************");
            System.out.println(po.getOrderNo());
            System.out.println(po.getOrderType());
            System.out.println(po.getOrderSum());
            System.out.println(po.getOrderAmt());
            System.out.println(po.getCreateDate());
            System.out.println(po.getCurrentNodeCode());
            System.out.println(po.getNextNodeCode());
            System.out.println(po.getPayName());
            System.out.println(po.getPayTime());
            System.out.println(po.getReceiveTime());
        }
    }
    
    private static Date parseDate(String dateStr) {
        try {
            return DateUtils.parseDate(dateStr, "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    } 
    
    private void showOrderBasePO(OrderBasePO po) {
        System.out.println("order id = " + po.getOrderId());
        System.out.println("order no =" + po.getOrderNo());
        System.out.println("create date = " + po.getCreateDate());
        System.out.println("end date = " + po.getEndDate());
        System.out.println("current node = " + po.getCurrentNodeCode());
        System.out.println("next node = " + po.getNextNodeCode());
        System.out.println("link tel = " + po.getLinkTel());
        System.out.println("shop status = " + po.getShopStatus());
        System.out.println("user status = " + po.getUserStatus());
        System.out.println("delivery fee = " + po.getDeliveryFee());
        System.out.println("maintain date = " + po.getMaintainDate());
        System.out.println("quantity = " + po.getMerchandiseQuantity());
        System.out.println("amount = " + po.getOrderAmt());
        System.out.println("sum = " + po.getOrderSum());
        System.out.println("type = " + po.getOrderType());
        System.out.println("shop id = " + po.getShopId());
        System.out.println("user id = " + po.getUserId());
    }
    
    private void showOrderBase(OrderBase po) {
        System.out.println("order id = " + po.getOrderId());
        System.out.println("order no =" + po.getOrderNo());
        System.out.println("create date = " + po.getCreateDate());
        System.out.println("link tel = " + po.getLinkTel());
        System.out.println("shop status = " + po.getShopStatus());
        System.out.println("user status = " + po.getUserStatus());
        System.out.println("delivery fee = " + po.getDeliveryFee());
        System.out.println("maintain date = " + po.getMaintainDate());
        System.out.println("quantity = " + po.getMerchandiseQuantity());
        System.out.println("amount = " + po.getOrderAmt());
        System.out.println("sum = " + po.getOrderSum());
        System.out.println("type = " + po.getOrderType());
        System.out.println("shop id = " + po.getShopId());
        System.out.println("user id = " + po.getUserId());
    }
}
