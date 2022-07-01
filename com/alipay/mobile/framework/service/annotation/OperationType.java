package com.alipay.mobile.framework.service.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface OperationType {
  String value();
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alipay\mobile\framework\service\annotation\OperationType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */