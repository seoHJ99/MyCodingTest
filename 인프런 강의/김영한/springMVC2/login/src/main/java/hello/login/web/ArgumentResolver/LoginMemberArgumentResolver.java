package hello.login.web.ArgumentResolver;

import hello.login.domain.member.Member;
import hello.login.web.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class LoginMemberArgumentResolver implements HandlerMethodArgumentResolver {



    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("supportParameter 실행");

        boolean hasLoginAnnotation = parameter.hasParameterAnnotation(Login.class); // login어노테이션이 붙어있느닞 확인
        boolean hasMemberType = Member.class.isAssignableFrom(parameter.getParameterType()); // 파라미터 타입이 member인지 확인

        return hasMemberType && hasLoginAnnotation;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

        log.info("resolverArgument 실행");

        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest(); // request 를 가져옴
        HttpSession session = request.getSession(false);
        if(session == null){ // 세션이 없으면, 즉, 로그인하지 않았으면 null
            return null;
        }
        return session.getAttribute(SessionConst.LOGIN_MEMBER); // 세션에 맞는 사용자 찾아서 반환
    }
}
