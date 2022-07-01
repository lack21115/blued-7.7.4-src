package com.soft.blued.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PayConstants {
  public static interface EventBus {}
  
  public static interface FROM {}
  
  public static interface FROM_PAGE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FROM_PAGE_DEF {}
  
  public static interface PAY_CONFIG_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PAY_PLATFORM {}
  
  public static interface PAY_RESULT_TARGET {}
  
  public static interface PAY_STATE {}
  
  public static interface PLATFORM {}
  
  public static interface RESULT {}
  
  public static interface SET_PWD_FROM {}
  
  public static interface SUPER_EXPOSURE_DETAIL {}
  
  public static interface TYPE {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\constant\PayConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */