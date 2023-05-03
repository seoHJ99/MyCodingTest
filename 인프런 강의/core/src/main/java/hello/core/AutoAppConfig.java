package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan( // 베이스 페키지 지정 않할시, ComponentScan 자신이 있는 패키지 내부가 기본값으로 설정됨
//        basePackages = "hello.core.member",
//        basePackageClasses = AutoAppConfig.class,  // 자신의 패키지 내부에서 찾음
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

//    @Bean
//    OrderService orderService(){
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

//    @Bean("memoryMemberRepository")
//    MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }

}
