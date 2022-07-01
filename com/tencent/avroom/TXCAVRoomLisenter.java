package com.tencent.avroom;

import android.os.Bundle;

public interface TXCAVRoomLisenter {
  void onAVRoomEvent(long paramLong, int paramInt, Bundle paramBundle);
  
  void onAVRoomStatus(long paramLong, Bundle paramBundle);
  
  void onMemberChange(long paramLong, boolean paramBoolean);
  
  void onVideoStateChange(long paramLong, boolean paramBoolean);
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\tencent\avroom\TXCAVRoomLisenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */