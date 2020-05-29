package com.bitmart.api.request.Quotation;


import com.bitmart.api.annotations.ParamKey;
import com.bitmart.api.request.Auth;
import com.bitmart.api.request.CloudRequest;
import com.bitmart.api.request.Method;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;


@EqualsAndHashCode(callSuper = true)
@Data
@ToString
@Accessors(chain = true)
public final class TickersRequest extends CloudRequest {

    @ParamKey("symbol")
    private String symbol;

    public TickersRequest() {
        super("/spot/v1/ticker", Method.GET, Auth.NONE);
    }
}
