package com.soft.blued.ui.find.model;

public class NearbyModule {
  public String avatar;
  
  public int cid;
  
  public String color;
  
  public String description;
  
  public int is_fixed;
  
  public int is_show;
  
  public String title;
  
  public NearbyModule(String paramString1, String paramString2, int paramInt) {
    this.title = paramString1;
    this.description = paramString2;
    this.is_show = paramInt;
  }
  
  public static interface MODULE_ID {
    public static final int HOT_MAN = 3;
    
    public static final int MAP_FIND = 998;
    
    public static final int NEARBY_FIND = 997;
    
    public static final int NEARBY_LIVE = 0;
    
    public static final int NEW_FACES = 1;
    
    public static final int TAG_USER = 999;
    
    public static final int YOU_MAY_LIKE = 2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\NearbyModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */