package com.soft.blued.ui.user.model;

import android.graphics.Bitmap;
import java.io.Serializable;
import java.lang.ref.SoftReference;

public class VipBubbleModel extends VIPCustomSettingBase implements Serializable {
  public static final String TYPE_MESSAGE = "message";
  
  public static final String TYPE_TICKTOCKS = "ticktocks";
  
  public int bubble;
  
  public String bubble_left;
  
  public String bubble_left_click;
  
  public String bubble_right;
  
  public String bubble_right_click;
  
  public SoftReference<Bitmap> mNormalBitmap;
  
  public SoftReference<Bitmap> mPressBitmap;
  
  public SoftReference<Bitmap> mVoiceBitmap;
  
  public String text_color;
  
  public String voice_left;
  
  public String voice_left_default;
  
  public String voice_left_gift;
  
  public String voice_right;
  
  public String voice_right_default;
  
  public String voice_right_gift;
  
  public VipBubbleModel copy() {
    VipBubbleModel vipBubbleModel = new VipBubbleModel();
    vipBubbleModel.id = this.id;
    vipBubbleModel.bubble_left = this.bubble_left;
    vipBubbleModel.bubble_left_click = this.bubble_left_click;
    vipBubbleModel.bubble_right = this.bubble_right;
    vipBubbleModel.bubble_right_click = this.bubble_right_click;
    vipBubbleModel.voice_left = this.voice_left;
    vipBubbleModel.voice_left_default = this.voice_left_default;
    vipBubbleModel.voice_right = this.voice_right;
    vipBubbleModel.voice_right_default = this.voice_right_default;
    vipBubbleModel.text_color = this.text_color;
    vipBubbleModel.front_cover = this.front_cover;
    vipBubbleModel.voice_right_gift = this.voice_right_gift;
    vipBubbleModel.voice_left_gift = this.voice_left_gift;
    vipBubbleModel.vip_status = this.vip_status;
    return vipBubbleModel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\model\VipBubbleModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */