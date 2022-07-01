package com.soft.blued.ui.user.model;

import com.soft.blued.ui.feed.model.BluedIngSelfFeed;

public class AlbumFlow extends BluedIngSelfFeed {
  public String album_pic;
  
  public int album_pics_num;
  
  public int album_status = 1;
  
  public int isFeed = 1;
  
  public boolean isOccupyModel;
  
  public boolean isSelf;
  
  public String lockText;
  
  public String pid;
  
  public boolean showApply;
  
  public static interface ALBUM_STATUS {
    public static final int LOCKED = 0;
    
    public static final int UNLOCKED = 1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\AlbumFlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */