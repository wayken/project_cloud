package cloud.apposs.webx.resolver.parameter;

import cloud.apposs.ioc.annotation.Component;
import cloud.apposs.rest.parameter.Parameter;
import cloud.apposs.rest.parameter.ParameterResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Reader;

/**
 * {@link Reader}参数绑定
 */
@Component
public class ReaderParameterResolver implements ParameterResolver<HttpServletRequest, HttpServletResponse> {
    @Override
    public boolean supportsParameter(Parameter parameter) {
        return Reader.class.isAssignableFrom(parameter.getType());
    }

    @Override
    public Object resolveArgument(Parameter parameter,
                                  HttpServletRequest request, HttpServletResponse response) throws Exception {
        return request.getReader();
    }
}
