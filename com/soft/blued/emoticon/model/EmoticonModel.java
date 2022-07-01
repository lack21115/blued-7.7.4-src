package com.soft.blued.emoticon.model;

import com.soft.blued.customview.emoji.manager.Emoji;

public class EmoticonModel {
  public String code;
  
  private String content;
  
  public Emoji emoji;
  
  public int emoticonType;
  
  public long eventType;
  
  public String name;
  
  public String name_zh;
  
  public String name_zh_tw;
  
  public String original;
  
  public String packageCode;
  
  public String packageUrl;
  
  public String small;
  
  public String url;
  
  public String url_original;
  
  public EmoticonModel() {}
  
  public EmoticonModel(long paramLong, String paramString1, String paramString2) {
    this.eventType = paramLong;
    this.original = paramString1;
    this.content = paramString2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\emoticon\model\EmoticonModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */