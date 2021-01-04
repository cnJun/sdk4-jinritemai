package com.sdk4.jinritemai.model.message;

import com.alibaba.fastjson.JSON;
import com.sdk4.jinritemai.util.DoudianUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 买家收货信息变更消息
 *
 * https://op.jinritemai.com/docs/message-docs/30/114
 */
@Getter
@Setter
public class DoudianTradeTradeAddressChanged105 {
    /**
     * 父订单ID
     */
    private Long pId;

    /**
     * 子订单ID列表
     */
    private List<Long> sIds;

    /**
     * 店铺ID
     */
    private Long shopId;

    /**
     * 父订单状态，买家收货信息变更消息的status值为"2"
     */
    private Integer orderStatus;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 收货信息变更时间
     */
    private Long updateTime;

    /**
     * 收货人详细信息
     */
    private ReceiverMsg receiverMsg;

    @Getter
    @Setter
    public static class ReceiverMsg {
        /**
         * 收货人姓名
         */
        private String name;

        /**
         * 收货人手机号
         */
        private String tel;

        /**
         * 收货地址
         */
        private String addr;

        public Addr getAddrObject() {
            return DoudianUtils.isEmpty(addr) ? null : JSON.parseObject(addr, Addr.class);
        }
    }

    @Getter
    @Setter
    public static class Addr {
        private IdName province;
        private IdName city;
        private IdName town;
        private String detail;
    }

    @Getter
    @Setter
    public static class IdName {
        private Long id;
        private String name;
    }

}
