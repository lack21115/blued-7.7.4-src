package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

public class LivePKProgressModel implements Serializable {
  public int score;
  
  public List<LivePKProgressUserModel> target_top;
  
  public List<LivePKProgressUserModel> top;
  
  public int total;
  
  public long uid;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LivePKProgressModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */