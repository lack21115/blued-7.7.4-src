package com.soft.blued.model;

import java.io.Serializable;

public class BluedAlbum implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public int applyStatus;
  
  public int audit_status;
  
  public String id;
  
  public String image;
  
  public boolean isUpdate;
  
  public String key;
  
  private String pid;
  
  public int position;
  
  public String progress = "";
  
  public String token;
  
  private String url;
  
  public String getPid() {
    return this.pid;
  }
  
  public String getUrl() {
    return this.url;
  }
  
  public void setPid(String paramString) {
    this.pid = paramString;
  }
  
  public void setProgress(String paramString) {
    this.progress = paramString;
  }
  
  public void setUrl(String paramString) {
    this.url = paramString;
  }
  
  public static interface PRIVATE_ALBUM_APPLYSTATUS {
    public static final int SHOW_APPLY = 1;
    
    public static final int SHOW_NONE = 0;
    
    public static final int SHOW_WAITING = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\model\BluedAlbum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */