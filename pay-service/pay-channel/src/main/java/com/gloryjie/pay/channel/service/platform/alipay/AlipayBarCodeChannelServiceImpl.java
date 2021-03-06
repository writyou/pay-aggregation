/* ------------------------------------------------------------------
 *   Product:      pay
 *   Module Name:  COMMON
 *   Package Name: com.gloryjie.pay.channel.service.platform.alipay
 *   Date Created: 2018/11/30
 * ------------------------------------------------------------------
 * Modification History
 * DATE            Name           Contact
 * ------------------------------------------------------------------
 * 2018/11/30      Jie            GloryJie@163.com
 */
package com.gloryjie.pay.channel.service.platform.alipay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.request.AlipayTradePayRequest;
import com.gloryjie.pay.base.util.AmountUtil;
import com.gloryjie.pay.base.util.JsonUtil;
import com.gloryjie.pay.channel.dto.ChannelPayDto;
import com.gloryjie.pay.channel.dto.response.ChannelPayResponse;
import com.gloryjie.pay.channel.enums.ChannelType;
import org.springframework.stereotype.Service;

/**
 * 支付宝条码支付
 *
 * @author Jie
 * @since
 */
@Service
public class AlipayBarCodeChannelServiceImpl extends BaseAlipayChannelService {

    @Override
    public ChannelType getChannelType() {
        return ChannelType.ALIPAY_BAR_CODE;
    }

    @Override
    public ChannelPayResponse pay(ChannelPayDto payDto) {
        AlipayClient client = getAlipayClient(payDto.getAppId(),payDto.getChannel());

        AlipayTradePayRequest request = new AlipayTradePayRequest();

        AlipayTradePayModel model = new AlipayTradePayModel();
        model.setOutTradeNo(payDto.getChargeNo());
        model.setTotalAmount(AmountUtil.amountToStr(payDto.getAmount()));
        model.setSubject(payDto.getSubject());
        model.setProductCode(ChannelType.ALIPAY_BAR_CODE.getProductCode());
        model.setAuthCode(payDto.getExtra().get("authCode"));
        model.setScene("bar_code");

        request.setBizModel(model);

        try {
            AlipayResponse response = client.execute(request);
            System.out.println(JsonUtil.toJson(response));
            System.out.println(response.getBody());
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return null;
    }
}
