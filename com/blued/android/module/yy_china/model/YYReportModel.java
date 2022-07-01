package com.blued.android.module.yy_china.model;

import java.util.List;

public class YYReportModel {
  public String anchor;
  
  public List<String> members;
  
  public List<YYReportMsg> msg;
  
  public String reason;
  
  public String room_id;
  
  public String uid;
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYReportModel{room_id='");
    stringBuilder.append(this.room_id);
    stringBuilder.append('\'');
    stringBuilder.append(", members=");
    stringBuilder.append(this.members);
    stringBuilder.append(", reason='");
    stringBuilder.append(this.reason);
    stringBuilder.append('\'');
    stringBuilder.append(", uid='");
    stringBuilder.append(this.uid);
    stringBuilder.append('\'');
    stringBuilder.append(", msg=");
    stringBuilder.append(this.msg);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYReportModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */