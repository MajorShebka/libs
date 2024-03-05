package org.home.dev.config.service.initializer.client.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.home.dev.config.service.initializer.entity.Property;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetPropertyResponse extends BaseResponse {

    private List<Property> properties;
}
