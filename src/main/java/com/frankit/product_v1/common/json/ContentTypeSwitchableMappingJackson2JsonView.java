package com.frankit.product_v1.common.json;

import com.frankit.product_v1.util.AgentUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



public class ContentTypeSwitchableMappingJackson2JsonView extends MappingJackson2JsonView {
    private static final String TEXT_PLAIN = "text/plain";

    public ContentTypeSwitchableMappingJackson2JsonView() {
        super();
    }

    @Override
    protected void setResponseContentType(HttpServletRequest request, HttpServletResponse response) {
        if (AgentUtils.isExplorer(request)) {
            response.setContentType(TEXT_PLAIN);
        } else {
            super.setResponseContentType(request, response);
        }
    }
}
