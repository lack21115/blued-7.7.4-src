package com.blued.android.module.yy_china.model;

public class YYReportMsg {
  public String contents;
  
  public int report;
  
  public long time;
  
  public String uid;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{uid='");
    stringBuilder.append(this.uid);
    stringBuilder.append('\'');
    stringBuilder.append(", report=");
    stringBuilder.append(this.report);
    stringBuilder.append(", contents='");
    stringBuilder.append(this.contents);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYReportMsg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */