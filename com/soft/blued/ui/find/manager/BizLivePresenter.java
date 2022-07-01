package com.soft.blued.ui.find.manager;

import com.soft.blued.utils.Logger;
import com.zego.zegoliveroom.ZegoLiveRoom;
import com.zego.zegoliveroom.callback.IZegoLivePlayerCallback;
import com.zego.zegoliveroom.callback.IZegoLivePublisherCallback;
import com.zego.zegoliveroom.callback.IZegoRoomCallback;
import com.zego.zegoliveroom.entity.ZegoPlayStreamQuality;
import com.zego.zegoliveroom.entity.ZegoPublishStreamQuality;
import com.zego.zegoliveroom.entity.ZegoRoomInfo;
import com.zego.zegoliveroom.entity.ZegoStreamInfo;
import java.util.HashMap;

public class BizLivePresenter {
  private static BizLivePresenter a;
  
  private ZegoLiveRoom b = FlashZegoApiManager.a().b();
  
  private volatile OnVideoLiveListener c = null;
  
  private volatile OnLiveRoomListener d = null;
  
  private volatile boolean e = false;
  
  private volatile boolean f = false;
  
  public static BizLivePresenter a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/manager/BizLivePresenter.a : Lcom/soft/blued/ui/find/manager/BizLivePresenter;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/manager/BizLivePresenter
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/manager/BizLivePresenter.a : Lcom/soft/blued/ui/find/manager/BizLivePresenter;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/manager/BizLivePresenter
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/manager/BizLivePresenter.a : Lcom/soft/blued/ui/find/manager/BizLivePresenter;
    //   25: ldc com/soft/blued/ui/find/manager/BizLivePresenter
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/manager/BizLivePresenter
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/manager/BizLivePresenter.a : Lcom/soft/blued/ui/find/manager/BizLivePresenter;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(OnLiveRoomListener paramOnLiveRoomListener) {
    this.d = paramOnLiveRoomListener;
  }
  
  public void a(OnVideoLiveListener paramOnVideoLiveListener) {
    this.c = paramOnVideoLiveListener;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\BizLivePresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */