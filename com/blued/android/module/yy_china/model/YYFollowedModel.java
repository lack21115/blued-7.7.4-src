package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntity;

public class YYFollowedModel extends BluedEntity {
  public int code;
  
  public DataBean data;
  
  public String message;
  
  public static class DataBean {
    public String avatar;
    
    public String create_time;
    
    public int is_on_live;
    
    public String last_on_time;
    
    public String name;
    
    public String room_desc;
    
    public String room_id;
    
    public String room_name;
    
    public String room_type;
    
    public String type_id;
    
    public String uid;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYFollowedModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */