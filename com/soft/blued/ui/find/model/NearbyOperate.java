package com.soft.blued.ui.find.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.soft.blued.ui.feed.model.BluedADExtra;
import java.util.List;

public class NearbyOperate extends BluedEntityBaseExtra {
  public int code;
  
  public List<DataBean> data;
  
  public String message;
  
  public String request_id;
  
  public double request_time;
  
  public double response_time;
  
  public static class DataBean extends BluedADExtra {
    public String content;
    
    public String title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\NearbyOperate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */