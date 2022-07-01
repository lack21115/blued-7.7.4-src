package com.blued.android.module.live_china.model;

public class LiveRoomCloseReason {
  public int errorCode;
  
  public String errorMessage;
  
  public LiveRoomCloseReason(int paramInt, String paramString) {
    this.errorCode = paramInt;
    this.errorMessage = paramString;
  }
  
  public static boolean isCloseByNormal(LiveRoomCloseReason paramLiveRoomCloseReason) {
    return (paramLiveRoomCloseReason != null && paramLiveRoomCloseReason.errorCode == 400006);
  }
  
  public static interface REASON {
    public static final int BEEN_BLOCKED = 400004;
    
    public static final int BLOCKED_HIM = 400003;
    
    public static final int NORMAL = 400006;
    
    public static final int ROOM_FULL = 400005;
    
    public static final int UNKNOW = 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\model\LiveRoomCloseReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */