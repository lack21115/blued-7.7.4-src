package com.soft.blued.ui.msg.model;

import java.util.List;

public class MsgExtraForTextTypeEntity {
  public String htmlContent;
  
  public MsgSourceEntity msgSource;
  
  public String quote;
  
  public SecureNotify secureNotify;
  
  public static class SecureNotify {
    public String collapse_desc;
    
    public String collapse_desc_en_us;
    
    public String collapse_desc_zh_cn;
    
    public String collapse_desc_zh_tw;
    
    public String contents;
    
    public String contents_en_us;
    
    public String contents_zh_cn;
    
    public String contents_zh_tw;
    
    public List<String> highlight_keywords;
    
    public List<String> highlight_keywords_en_us;
    
    public List<String> highlight_keywords_zh_cn;
    
    public List<String> highlight_keywords_zh_tw;
    
    public String icon;
    
    public String link;
    
    public String link_title;
    
    public String link_title_en_us;
    
    public String link_title_zh_cn;
    
    public String link_title_zh_tw;
    
    public List<SecureContent> multi_contents;
    
    public List<SecureContent> multi_contents_en_us;
    
    public List<SecureContent> multi_contents_zh_cn;
    
    public List<SecureContent> multi_contents_zh_tw;
    
    public int notify_type;
    
    public String report_title;
    
    public String report_title_en_us;
    
    public String report_title_zh_cn;
    
    public String report_title_zh_tw;
    
    public String title;
    
    public String title_en_us;
    
    public String title_zh_cn;
    
    public String title_zh_tw;
    
    public static class SecureContent {
      public String background_link;
      
      public String body;
      
      public String link;
      
      public String link_title;
      
      public String title;
    }
  }
  
  public static class SecureContent {
    public String background_link;
    
    public String body;
    
    public String link;
    
    public String link_title;
    
    public String title;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgExtraForTextTypeEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */