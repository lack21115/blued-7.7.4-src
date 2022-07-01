package com.blued.android.module.live_china.utils;

import com.blued.android.chat.data.ProfileData;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.module.live_china.manager.LiveRoomManager;
import com.blued.android.module.live_china.model.LiveRoomViewerExtra;
import com.blued.android.module.live_china.model.LiveRoomViewerModel;

public class LiveRoomUtils {
  public static void a(long paramLong, int paramInt) {
    LiveRoomManager.a().a(paramLong, paramInt);
  }
  
  public static void a(ProfileData paramProfileData, int paramInt) {
    // Byte code:
    //   0: ldc com/blued/android/module/live_china/utils/LiveRoomUtils
    //   2: monitorenter
    //   3: invokestatic a : ()Lcom/blued/android/module/live_china/manager/LiveRoomManager;
    //   6: aload_0
    //   7: iload_1
    //   8: invokevirtual a : (Lcom/blued/android/chat/data/ProfileData;I)V
    //   11: ldc com/blued/android/module/live_china/utils/LiveRoomUtils
    //   13: monitorexit
    //   14: return
    //   15: astore_0
    //   16: ldc com/blued/android/module/live_china/utils/LiveRoomUtils
    //   18: monitorexit
    //   19: aload_0
    //   20: athrow
    // Exception table:
    //   from	to	target	type
    //   3	11	15	finally
  }
  
  public static void a(IRequestHost paramIRequestHost, String paramString) {
    long l = LiveRoomManager.a().b();
    LiveRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntity<LiveRoomViewerModel, LiveRoomViewerExtra>>(paramIRequestHost, l) {
          public void onUIUpdate(BluedEntity<LiveRoomViewerModel, LiveRoomViewerExtra> param1BluedEntity) {
            if (this.a != LiveRoomManager.a().b())
              return; 
            LiveRoomManager.a().a(this.a, param1BluedEntity.data, (int)((LiveRoomViewerExtra)param1BluedEntity.extra).realtime_count);
          }
        }paramIRequestHost, String.valueOf(l), paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_chin\\utils\LiveRoomUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */