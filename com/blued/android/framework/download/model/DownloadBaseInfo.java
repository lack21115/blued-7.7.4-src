package com.blued.android.framework.download.model;

import java.io.Serializable;

public class DownloadBaseInfo implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public String description;
  
  public String download_url = "";
  
  public String md5 = "";
  
  public String name = "";
  
  public int times;
  
  public String title;
  
  public String type;
  
  public String version;
  
  public String version_code;
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\framework\download\model\DownloadBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */