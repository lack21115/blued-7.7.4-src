package com.blued.android.module.common.event;

import com.blued.android.module.common.model.BaseGiftModel;

public class GiftItemChangeEvent {
  public BaseGiftModel giftModel;
  
  public int packageTabIndex;
  
  public int pageIndex;
  
  public GiftItemChangeEvent(int paramInt1, int paramInt2, BaseGiftModel paramBaseGiftModel) {
    this.packageTabIndex = paramInt1;
    this.pageIndex = paramInt2;
    this.giftModel = paramBaseGiftModel;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\common\event\GiftItemChangeEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */