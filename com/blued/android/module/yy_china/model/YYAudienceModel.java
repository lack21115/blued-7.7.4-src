package com.blued.android.module.yy_china.model;

import android.text.TextUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;

public class YYAudienceModel implements MultiItemEntity {
  public String age;
  
  private String avatar = "";
  
  public String chat_anchor;
  
  public String height;
  
  public String invited;
  
  public String is_mic;
  
  public int itemType = 0;
  
  public int mic_position;
  
  private String name = "";
  
  public String relationship;
  
  public String role;
  
  private String uid = "";
  
  public String weight;
  
  public YYAudienceModel copy() {
    YYAudienceModel yYAudienceModel = new YYAudienceModel();
    yYAudienceModel.uid = getUid();
    yYAudienceModel.name = getName();
    yYAudienceModel.avatar = getAvatar();
    yYAudienceModel.role = this.role;
    yYAudienceModel.chat_anchor = this.chat_anchor;
    yYAudienceModel.relationship = this.relationship;
    yYAudienceModel.mic_position = this.mic_position;
    yYAudienceModel.invited = this.invited;
    yYAudienceModel.age = this.age;
    yYAudienceModel.height = this.height;
    yYAudienceModel.is_mic = this.is_mic;
    yYAudienceModel.weight = this.weight;
    return yYAudienceModel;
  }
  
  public String getAvatar() {
    return this.avatar;
  }
  
  public int getItemType() {
    return this.itemType;
  }
  
  public String getName() {
    return this.name;
  }
  
  public String getUid() {
    if (TextUtils.isEmpty(this.uid))
      this.uid = ""; 
    return this.uid;
  }
  
  public void setAvatar(String paramString) {
    this.avatar = paramString;
  }
  
  public void setName(String paramString) {
    this.name = paramString;
  }
  
  public void setUid(String paramString) {
    this.uid = paramString;
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("{uid='");
    stringBuilder.append(this.uid);
    stringBuilder.append('\'');
    stringBuilder.append(", name='");
    stringBuilder.append(this.name);
    stringBuilder.append('\'');
    stringBuilder.append(", avatar='");
    stringBuilder.append(this.avatar);
    stringBuilder.append('\'');
    stringBuilder.append(", role='");
    stringBuilder.append(this.role);
    stringBuilder.append('\'');
    stringBuilder.append(", age='");
    stringBuilder.append(this.age);
    stringBuilder.append('\'');
    stringBuilder.append(", height='");
    stringBuilder.append(this.height);
    stringBuilder.append('\'');
    stringBuilder.append(", relationship='");
    stringBuilder.append(this.relationship);
    stringBuilder.append('\'');
    stringBuilder.append(", is_on_mic='");
    stringBuilder.append(this.is_mic);
    stringBuilder.append('\'');
    stringBuilder.append(", invited='");
    stringBuilder.append(this.invited);
    stringBuilder.append('\'');
    stringBuilder.append(", chat_anchor='");
    stringBuilder.append(this.chat_anchor);
    stringBuilder.append('\'');
    stringBuilder.append(", weight='");
    stringBuilder.append(this.weight);
    stringBuilder.append('\'');
    stringBuilder.append(", mic_position='");
    stringBuilder.append(this.mic_position);
    stringBuilder.append('\'');
    stringBuilder.append('}');
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYAudienceModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */