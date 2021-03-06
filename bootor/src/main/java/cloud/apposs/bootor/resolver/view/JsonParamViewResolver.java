package cloud.apposs.bootor.resolver.view;

import cloud.apposs.bootor.WebUtil;
import cloud.apposs.ioc.annotation.Component;
import cloud.apposs.netkit.filterchain.http.server.HttpRequest;
import cloud.apposs.netkit.filterchain.http.server.HttpResponse;
import cloud.apposs.rest.view.AbstractViewResolver;
import cloud.apposs.util.MediaType;
import cloud.apposs.util.Param;

/**
 * Json格式输出视图渲染器
 */
@Component
public class JsonParamViewResolver extends AbstractViewResolver<HttpRequest, HttpResponse> {
    @Override
    public boolean supports(HttpRequest request, HttpResponse response, Object result) {
        return (result instanceof Param);
    }

    @Override
    public void render(HttpRequest request, HttpResponse response, Object result, boolean flush) throws Exception {
        WebUtil.response(response, MediaType.APPLICATION_JSON, config.getCharset(), ((Param) result).toJson(), flush);
    }
}
