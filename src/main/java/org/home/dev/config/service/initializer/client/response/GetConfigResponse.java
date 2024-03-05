package org.home.dev.config.service.initializer.client.response;

import lombok.Getter;
import lombok.Setter;
import org.home.dev.config.service.initializer.entity.Config;

import java.util.List;

@Getter
@Setter
public class GetConfigResponse extends BaseResponse {

    private List<Config> configs;
}
