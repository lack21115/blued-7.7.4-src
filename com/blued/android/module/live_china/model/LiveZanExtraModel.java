package com.blued.android.module.live_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import java.util.List;

public class LiveZanExtraModel extends BluedEntityBaseExtra {
  public List<LiveGiftModel> box;
  
  public Danmaku danmu;
  
  public long danmu_count;
  
  public List<HotWords> hot_words;
  
  public int join_club;
  
  public LiveZanModel like_style;
  
  public int user_store_count;
  
  public class Danmaku {
    public long beans;
    
    public long goods_id;
  }
  
  public class HotWords {
    public String id;
    
    public String text;
  }
  
  public class LiveZanModel {
    public String me;
    
    public String other;
    
    public String[] random;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveZanExtraModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */