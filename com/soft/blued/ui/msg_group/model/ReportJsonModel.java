package com.soft.blued.ui.msg_group.model;

import java.util.List;

public class ReportJsonModel {
  public List<ReportMsgContent> contexts;
  
  public long group_id;
  
  public String reason;
  
  public int report_type;
  
  public long report_uid;
  
  public static class ReportMsgContent {
    public String contents;
    
    public long createdAt;
    
    public long messageId;
    
    public int report;
    
    public String type;
    
    public long uid;
    
    public String url;
    
    public void setMsgTypeString(int param1Int) {
      if (param1Int != 1) {
        if (param1Int != 2) {
          if (param1Int != 3) {
            if (param1Int != 5) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append(param1Int);
              stringBuilder.append("");
              this.type = stringBuilder.toString();
              return;
            } 
            this.type = "VIDEO";
            return;
          } 
          this.type = "SOUND";
          return;
        } 
        this.type = "IMAGE";
        return;
      } 
      this.type = "TEXT";
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg_group\model\ReportJsonModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */