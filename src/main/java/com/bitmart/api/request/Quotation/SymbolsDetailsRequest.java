package com.bitmart.api.request.Quotation;


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
public final class SymbolsDetailsRequest extends CloudRequest {
    public SymbolsDetailsRequest() {
        super("/spot/v1/symbols/details", Method.GET, Auth.NONE);
    }
}
