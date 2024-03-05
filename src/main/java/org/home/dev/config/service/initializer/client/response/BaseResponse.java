package org.home.dev.config.service.initializer.client.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class BaseResponse {

    private ResponseError error;
}
