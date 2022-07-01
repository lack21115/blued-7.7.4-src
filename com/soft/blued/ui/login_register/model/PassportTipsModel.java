package com.soft.blued.ui.login_register.model;

public class PassportTipsModel {
  public int is_open_dialog = -1;
  
  public String tips = "";
  
  public static interface TIPS_STATUS {
    public static final int CLOSE = 0;
    
    public static final int OPEN = 1;
    
    public static final int UNDECIDE = -1;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\PassportTipsModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */