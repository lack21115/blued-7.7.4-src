package com.blued.android.module.live_china.model;

import java.io.Serializable;

public class LiveRoomAnchorModel extends LiveRoomUserModel implements Serializable {
  private static final long serialVersionUID = 1L;
  
  public LiveRoomAnchorModel() {}
  
  public LiveRoomAnchorModel(String paramString1, String paramString2, String paramString3, int paramInt) {
    this.uid = paramString1;
    this.name = paramString2;
    this.avatar = paramString3;
    this.vbadge = paramInt;
  }
  
  public LiveRoomAnchorModel(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2) {
    this.uid = paramString1;
    this.name = paramString2;
    this.avatar = paramString3;
    this.vbadge = paramInt1;
    this.rich_level = paramInt2;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveRoomAnchorModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */