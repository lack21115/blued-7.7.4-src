package com.soft.blued.ui.notify.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

public class CircleNotify extends BluedEntityBaseExtra {
  public String circle_id;
  
  public String cover;
  
  public int from;
  
  public String id;
  
  public String ops_avatar;
  
  public String ops_name;
  
  public String ops_uid;
  
  public String posting_id;
  
  public int result;
  
  public String text;
  
  public String timestamp;
  
  public String title;
  
  public int type;
  
  public static @interface Result {
    public static final int AGREE = 1;
    
    public static final int DENY = 2;
    
    public static final int NONE = 0;
  }
  
  public static @interface Type {
    public static final int AGREE_DENY = 1;
    
    public static final int CAN_JUMP = 2;
    
    public static final int CIRCLE_ACTIVE_MEMBER = 5;
    
    public static final int FEED_ESSENCE = 4;
    
    public static final int PURE_TEXT = 3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\model\CircleNotify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */