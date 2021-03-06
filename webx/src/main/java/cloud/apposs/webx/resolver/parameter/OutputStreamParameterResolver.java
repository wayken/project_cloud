package cloud.apposs.webx.resolver.parameter;

import cloud.apposs.ioc.annotation.Component;
import cloud.apposs.rest.parameter.Parameter;
import cloud.apposs.rest.parameter.ParameterResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

/**
 * {@link OutputStream}参数绑定
 */
@Component
public class OutputStreamParameterResolver implements ParameterResolver<HttpServletRequest, HttpServletResponse> {
    @Override
    public boolean supportsParameter(Parameter parameter) {
        return OutputStream.class.isAssignableFrom(parameter.getType());
    }

    @Override
    public Object resolveArgument(Parameter parameter,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        return response.getOutputStream();
    }
}
