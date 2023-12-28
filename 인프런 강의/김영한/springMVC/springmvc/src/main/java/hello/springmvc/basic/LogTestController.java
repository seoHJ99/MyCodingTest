package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //어노테이션이 자동으로 코드 삽입
//    private final Logger log = LoggerFactory.getLogger(getClass()); // 매개변수 내 클래스

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name);
        /* 결과는 같지만 사용하면 안됨
         자바는 더하기 연산이 있으면 컴파일 단계에서 미리 연산을 완료해 완성된 문자열
         info log=Spring 를 가지고 있음.
         이는 사용하지도 않을 코드인데 미리 연산하는 결과가 될수도 있어서 사용 x
         */
        log.info("info log=" + name);

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
        // 로그를 사용하면 파일로 저장하는 것도 간단해진다.
        // 특히 일별, 특정 용량에 따라 파일을 분할하는 것도 가능하다.
        // 성능도 System.out보다 좋다.
    }
}