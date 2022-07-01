package com.soft.blued.ui.msg.model;

public class MsgChattingVideoModel {
  private MsgSourceEntity msgSource;
  
  private String videoCoverUrl;
  
  private int video_height;
  
  public long video_time_long;
  
  private int video_width;
  
  public MsgSourceEntity getMsgSource() {
    return this.msgSource;
  }
  
  public String getVideoCoverUrl() {
    return this.videoCoverUrl;
  }
  
  public int getVideo_height() {
    return this.video_height;
  }
  
  public int getVideo_width() {
    return this.video_width;
  }
  
  public void setMsgSource(MsgSourceEntity paramMsgSourceEntity) {
    this.msgSource = paramMsgSourceEntity;
  }
  
  public void setVideoCoverUrl(String paramString) {
    this.videoCoverUrl = paramString;
  }
  
  public void setVideo_height(int paramInt) {
    this.video_height = paramInt;
  }
  
  public void setVideo_width(int paramInt) {
    this.video_width = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\model\MsgChattingVideoModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */