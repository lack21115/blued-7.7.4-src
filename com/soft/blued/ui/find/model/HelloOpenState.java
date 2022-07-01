package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

public class HelloOpenState extends BluedEntityBaseExtra {
  public long countdown;
  
  public long expire_time;
  
  public int is_quietly;
  
  public float multiples;
  
  public int open_status = -1;
  
  public static interface OpenStatus {
    public static final int AUDIT = 3;
    
    public static final int FAIL = 0;
    
    public static final int NO_TIME = 2;
    
    public static final int OPEN = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\HelloOpenState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */