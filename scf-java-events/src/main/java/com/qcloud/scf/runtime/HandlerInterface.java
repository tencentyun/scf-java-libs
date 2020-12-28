package com.qcloud.scf.runtime;

import com.qcloud.services.scf.runtime.events.APIGatewayProxyRequestEvent;

public interface HandlerInterface {
    String mainHandler(APIGatewayProxyRequestEvent req);
}
