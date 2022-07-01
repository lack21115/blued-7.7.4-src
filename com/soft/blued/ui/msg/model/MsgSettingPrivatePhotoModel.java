package com.soft.blued.ui.msg.model;

import java.io.Serializable;

public class MsgSettingPrivatePhotoModel implements Serializable {
  public Me me;
  
  public Target target;
  
  public class Me {
    public int has_photo;
    
    public int is_sharing;
  }
  
  public class Target {
    public int has_photo;
    
    public int is_sharing;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgSettingPrivatePhotoModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */