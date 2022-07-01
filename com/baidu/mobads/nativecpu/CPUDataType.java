package com.baidu.mobads.nativecpu;

import android.text.TextUtils;

public enum CPUDataType {
  AD,
  HOTDOC,
  IMAGE,
  NEWS("news", 0),
  POLICETASK("news", 0),
  RECALLNEWS("news", 0),
  SMALLVIDEO("news", 0),
  TOPIC("news", 0),
  VIDEO("news", 0);
  
  String a;
  
  int b;
  
  static {
    IMAGE = new CPUDataType("IMAGE", 1, "image", 1);
    VIDEO = new CPUDataType("VIDEO", 2, "video", 2);
    TOPIC = new CPUDataType("TOPIC", 3, "topic", 3);
    AD = new CPUDataType("AD", 4, "ad", 4);
    HOTDOC = new CPUDataType("HOTDOC", 5, "hotkey", 5);
    SMALLVIDEO = new CPUDataType("SMALLVIDEO", 6, "smallvideo", 6);
    RECALLNEWS = new CPUDataType("RECALLNEWS", 7, "recallNews", 8);
    POLICETASK = new CPUDataType("POLICETASK", 8, "policetask", 9);
    c = new CPUDataType[] { NEWS, IMAGE, VIDEO, TOPIC, AD, HOTDOC, SMALLVIDEO, RECALLNEWS, POLICETASK };
  }
  
  CPUDataType(String paramString1, int paramInt1) {
    this.a = paramString1;
    this.b = paramInt1;
  }
  
  public static CPUDataType parseType(String paramString) {
    for (CPUDataType cPUDataType : values()) {
      if (cPUDataType != null && TextUtils.isEmpty(cPUDataType.a) && cPUDataType.a.equals(paramString))
        return cPUDataType; 
    } 
    return null;
  }
  
  public String getName() {
    return this.a;
  }
  
  public int getValue() {
    return this.b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\mobads\nativecpu\CPUDataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */