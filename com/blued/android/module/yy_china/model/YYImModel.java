package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.blued.android.core.AppInfo;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.HashMap;

public class YYImModel implements MultiItemEntity {
  public String contents;
  
  private String msgExtra;
  
  public HashMap<String, Object> msgMapExtra;
  
  public long msg_time;
  
  public boolean resend;
  
  public YYAudienceModel source_profile;
  
  public YYAudienceModel target_profile;
  
  public int type;
  
  public int getItemType() {
    return this.type;
  }
  
  public String getMsgExtra() {
    if (TextUtils.isEmpty(this.msgExtra) && this.msgMapExtra != null)
      this.msgExtra = AppInfo.f().toJson(this.msgMapExtra); 
    return this.msgExtra;
  }
  
  public void setMsgExtra(String paramString) {
    this.msgExtra = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("YYImModel{contents='");
    stringBuilder.append(this.contents);
    stringBuilder.append('\'');
    stringBuilder.append(", type=");
    stringBuilder.append(this.type);
    stringBuilder.append(", msgExtra='");
    stringBuilder.append(AppInfo.f().toJson(this.msgMapExtra));
    stringBuilder.append('\'');
    stringBuilder.append(", source_profile=");
    stringBuilder.append(this.source_profile);
    stringBuilder.append(", target_profile=");
    stringBuilder.append(this.target_profile);
    stringBuilder.append(", msg_time=");
    stringBuilder.append(this.msg_time);
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYImModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */