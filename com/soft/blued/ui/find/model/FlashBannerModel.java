package com.soft.blued.ui.find.model;

import com.blued.android.chat.model.FlashVideoGiftModel;

public class FlashBannerModel extends FlashVideoGiftModel {
  public String uid;
  
  public FlashBannerModel() {}
  
  public FlashBannerModel(FlashVideoGiftModel paramFlashVideoGiftModel) {
    copy(paramFlashVideoGiftModel);
  }
  
  public void copy(FlashVideoGiftModel paramFlashVideoGiftModel) {
    if (paramFlashVideoGiftModel != null) {
      this.roomId = paramFlashVideoGiftModel.roomId;
      this.addTime = paramFlashVideoGiftModel.addTime;
      this.addLike = paramFlashVideoGiftModel.addLike;
      this.totalTime = paramFlashVideoGiftModel.totalTime;
      this.totalLike = paramFlashVideoGiftModel.totalLike;
      this.giftIcon = paramFlashVideoGiftModel.giftIcon;
      this.giftName = paramFlashVideoGiftModel.giftName;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\model\FlashBannerModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */