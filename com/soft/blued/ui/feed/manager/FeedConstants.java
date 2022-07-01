package com.soft.blued.ui.feed.manager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class FeedConstants {
  public static interface AD_TYPE {}
  
  public static interface COMMENT_PERMISSION {}
  
  public static interface DATA_KEY {}
  
  public static interface EventBus {}
  
  public static interface FEATURED_DATATYPE {}
  
  public static interface FEED_FROM {}
  
  public static interface FEED_SEND_STATE {}
  
  public static interface FEED_TYPE {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FeedFromDef {}
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface FeedTypeDef {}
  
  public static @interface PromotionState {
    public static final int CAN = 1;
    
    public static final int NOT = 0;
    
    public static final int PROMOTION = 3;
    
    public static final int REVIEW = 2;
  }
  
  public static interface READ_AUTH_PERMISSION {}
  
  public static interface VOTE_STATUS {}
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\manager\FeedConstants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */