package hello.itemservice.web.validation;

import hello.itemservice.domain.item.Item;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ItemValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) { // 매개변수 class가 특정 클래스를 지원하는지 검증
        return Item.class.isAssignableFrom(clazz);
        // item == clazz  : 들어온 클래스가 Item 클래스인 경우
        // item = subItem : 들어온 클래스가 Item의 자식 클래스인 경우
    }

    @Override
    public void validate(Object target, Errors errors) {
        Item item = (Item) target;

//        ValidationUtils.rejectIfEmpty(bindingResult, "itemName", "required");

        // 검증 로직
        if(!StringUtils.hasText(item.getItemName())){
            errors.rejectValue("itemName", "required");
//            더 구체적인 것을 먼저 찾고(자신의 객체명 + 필드명이 포함된 메시지가 있는지), 없으면 범용적인 것, 더 심플한 메시지를 적용.
        }
        if(item.getPrice() == null || item.getPrice() < 1000 || item.getPrice()> 1_000_000){
            errors.rejectValue("price", "range", new Object[]{1000, 1000000}, null);
        }
        if(item.getQuantity()== null || item.getQuantity()>=9999){
            errors.rejectValue("quantity", "max", new Object[]{9999}, null);
        }

        // 특정 필드가 아닌 복합 룰 검증
        if(item.getPrice() != null && item.getQuantity() != null){
            int resultPrice = item.getPrice() * item.getQuantity();
            if(resultPrice<10000){
                errors.reject("totalPriceMin", new Object[]{10000, resultPrice}, null);
            }
        }
    }
}
