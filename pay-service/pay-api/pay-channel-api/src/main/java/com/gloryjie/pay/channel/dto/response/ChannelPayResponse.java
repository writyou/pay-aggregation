/* ------------------------------------------------------------------
 *   Product:      pay
 *   Module Name:  COMMON
 *   Package Name: com.gloryjie.pay.channel.dto.response
 *   Date Created: 2018/12/21
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Contact
 * ------------------------------------------------------------------
 * 2018/12/21      Jie            GloryJie@163.com
 */
package com.gloryjie.pay.channel.dto.response;

import com.alipay.api.AlipayResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 渠道支付的返回对象
 * @author Jie
 * @since 0.1
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ChannelPayResponse extends ChannelResponse{

    /**
     * 网关支付凭证
     */
    private String credential;


    public ChannelPayResponse(AlipayResponse response){
        super(response);
    }

}
