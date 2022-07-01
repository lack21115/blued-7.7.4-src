package com.soft.blued.ui.login_register.model;

import java.util.List;

public class UpdateTerms {
  public List<Button> button;
  
  public String description;
  
  public int is_open;
  
  public List<Link> jump_links;
  
  public String title;
  
  public static class Button {
    public int click_type;
    
    public String click_url;
    
    public String text;
  }
  
  public static class Link {
    public String link;
    
    public String text;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\login_register\model\UpdateTerms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */