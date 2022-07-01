package com.soft.blued.ui.user.model;

import com.soft.blued.model.BluedAlbum;
import java.util.List;

public class AlbumDataForJsonParse {
  public _album album;
  
  public AlbumFlow feed;
  
  public int type;
  
  public class _album {
    public int access_private_photos;
    
    public List<BluedAlbum> pics;
    
    public int pics_num;
    
    public int privacy_photos_has_locked;
    
    public int status;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\AlbumDataForJsonParse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */