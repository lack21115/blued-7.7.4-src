package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class LiveMusicSongModel implements MultiItemEntity {
  public static final int MUSIC_MODEL = 0;
  
  public static final int MUSIC_MODEL_NO_DATA = 1;
  
  public String artist;
  
  public String audition_begin;
  
  public String audition_end;
  
  public String cover;
  
  public long duration;
  
  public boolean fromSearchPage;
  
  public int is_collect;
  
  public String music_id;
  
  public String music_name;
  
  public int playTime;
  
  public String sheetId;
  
  public int type = 0;
  
  public int getItemType() {
    return this.type;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveMusicSongModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */