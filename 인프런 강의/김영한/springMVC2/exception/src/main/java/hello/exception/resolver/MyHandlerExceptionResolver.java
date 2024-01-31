package hello.exception.resolver;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Slf4j
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        log.info("call resolver ", ex);

        try {
            if (ex instanceof IllegalArgumentException) {
                log.info("IllegalArgumentException resolver to 400");
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, ex.getMessage());
                return new ModelAndView(); // ModelAndView 를 받아야 was가 정상적으로 작동함. 즉, was가 정상 작동하도록 만들고
                // 브라우져가 400 에러가 발생하도록 하는 기법. view를 반환하면 그 view를 렌더링함
            }
        } catch (IOException e) {
            log.error("resolver ex", e);
        }
        return null; // null 로 리턴하면 다음 ExceptionResolver를 찾음. ExceptionResolver를 찾을수 없으면 서블릿 밖으로 예외를 날림.
    }
}
