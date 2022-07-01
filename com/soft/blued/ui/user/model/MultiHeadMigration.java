package com.soft.blued.ui.user.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

public class MultiHeadMigration extends BluedEntityBaseExtra {
  public int code;
  
  public DataBean data;
  
  public String message;
  
  public String request_id;
  
  public double request_time;
  
  public double response_time;
  
  public static class DataBean {
    public int vip_avatar_num;
    
    public int vip_grade;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\MultiHeadMigration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */