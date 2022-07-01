package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

public class HelloDataExtra extends BluedEntityBaseExtra {
  public String main_title;
  
  public float multiples;
  
  public int promote_person_num;
  
  public int show_call_btn;
  
  public String subheading;
  
  public int table_type;
  
  public int view_type;
  
  public static interface MsgHelloType {
    public static final int DATA = 2;
    
    public static final int USER = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\HelloDataExtra.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */