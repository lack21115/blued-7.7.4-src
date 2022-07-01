package com.soft.blued.ui.feed.model;

import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.model.SessionProfileModel;
import com.soft.blued.ui.msg.model.MsgSourceEntity;

public class MsgPhotoModel {
  public ChattingModel chattingModel;
  
  public String imgPath;
  
  public int isBurn;
  
  public MsgSourceEntity msgSource;
  
  public int picHeight;
  
  public int picWidth;
  
  public SessionProfileModel sessionProfileModel;
  
  public MsgPhotoModel() {}
  
  public MsgPhotoModel(String paramString, int paramInt1, int paramInt2, int paramInt3) {
    this.imgPath = paramString;
    this.picWidth = paramInt1;
    this.picHeight = paramInt2;
    this.isBurn = paramInt3;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\model\MsgPhotoModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */