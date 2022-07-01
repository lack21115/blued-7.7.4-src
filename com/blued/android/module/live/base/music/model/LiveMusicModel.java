package com.blued.android.module.live.base.music.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LiveMusicModel implements MultiItemEntity {
  public static final int MUSIC_MODEL = 0;
  
  public static final int MUSIC_MODEL_NO_DATA = 1;
  
  public String artist;
  
  public String cover;
  
  public long curDuration;
  
  public long duration;
  
  public String expires;
  
  public String file_size;
  
  public String file_url;
  
  public String music_id;
  
  public String name;
  
  public int playStatus = 0;
  
  public String sheet_id;
  
  public int type = 0;
  
  public int getItemType() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live\base\music\model\LiveMusicModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */