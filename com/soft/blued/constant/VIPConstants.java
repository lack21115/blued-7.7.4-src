package com.soft.blued.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class VIPConstants {
  public static interface DATA_KEY {}
  
  public static interface GIVE_OR_ASK {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface GiveOrAsk {}
  
  public static interface PAY_DETAIL {}
  
  public static interface PAY_FROM {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface PayDetail {}
  
  public static interface REQUEST_CODE {}
  
  public static interface RIGHT_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VIPPageFrom {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface VIPRightDef {}
  
  public static interface VIP_RIGHT {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\constant\VIPConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */