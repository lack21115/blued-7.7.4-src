package com.blued.android.module.yy_china.model;

public class YYSeatMemberModel extends YYAudienceModel {
  public String apngUrl;
  
  public YYImModel emojiModel;
  
  public boolean isVoted = false;
  
  public int is_open_mic;
  
  public String likeNum;
  
  public int position_status;
  
  public String publish_url;
  
  public YYSeatMemberModel copy() {
    YYSeatMemberModel yYSeatMemberModel = new YYSeatMemberModel();
    yYSeatMemberModel.setUid(getUid());
    yYSeatMemberModel.setName(getName());
    yYSeatMemberModel.setAvatar(getAvatar());
    yYSeatMemberModel.role = this.role;
    yYSeatMemberModel.chat_anchor = this.chat_anchor;
    yYSeatMemberModel.relationship = this.relationship;
    yYSeatMemberModel.mic_position = this.mic_position;
    yYSeatMemberModel.invited = this.invited;
    yYSeatMemberModel.age = this.age;
    yYSeatMemberModel.height = this.height;
    yYSeatMemberModel.is_mic = this.is_mic;
    yYSeatMemberModel.weight = this.weight;
    yYSeatMemberModel.position_status = this.position_status;
    yYSeatMemberModel.is_open_mic = this.is_open_mic;
    yYSeatMemberModel.publish_url = this.publish_url;
    yYSeatMemberModel.apngUrl = this.apngUrl;
    yYSeatMemberModel.emojiModel = this.emojiModel;
    yYSeatMemberModel.isVoted = this.isVoted;
    yYSeatMemberModel.likeNum = this.likeNum;
    return yYSeatMemberModel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\model\YYSeatMemberModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */