package com.soft.blued.ui.find.manager;

import com.soft.blued.ui.msg.model.ChannelModel;
import com.zego.zegoliveroom.ZegoLiveRoom;

public class FlashZegoApiManager {
  private static FlashZegoApiManager d;
  
  public ChannelModel a;
  
  long b = 3170513794L;
  
  byte[] c = new byte[] { 
      -98, -126, -116, 45, -18, -101, -67, 14, 2, 90, 
      -85, 54, -84, 63, 45, -111, -110, 33, -9, -74, 
      -109, -121, 18, 8, -127, 75, -62, 24, -115, -69, 
      -70, -28 };
  
  private ZegoLiveRoom e = null;
  
  private boolean f;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private boolean i = false;
  
  private FlashZegoApiManager() {
    this.e = new ZegoLiveRoom();
  }
  
  public static FlashZegoApiManager a() {
    // Byte code:
    //   0: getstatic com/soft/blued/ui/find/manager/FlashZegoApiManager.d : Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
    //   3: ifnonnull -> 37
    //   6: ldc com/soft/blued/ui/find/manager/FlashZegoApiManager
    //   8: monitorenter
    //   9: getstatic com/soft/blued/ui/find/manager/FlashZegoApiManager.d : Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
    //   12: ifnonnull -> 25
    //   15: new com/soft/blued/ui/find/manager/FlashZegoApiManager
    //   18: dup
    //   19: invokespecial <init> : ()V
    //   22: putstatic com/soft/blued/ui/find/manager/FlashZegoApiManager.d : Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
    //   25: ldc com/soft/blued/ui/find/manager/FlashZegoApiManager
    //   27: monitorexit
    //   28: goto -> 37
    //   31: astore_0
    //   32: ldc com/soft/blued/ui/find/manager/FlashZegoApiManager
    //   34: monitorexit
    //   35: aload_0
    //   36: athrow
    //   37: getstatic com/soft/blued/ui/find/manager/FlashZegoApiManager.d : Lcom/soft/blued/ui/find/manager/FlashZegoApiManager;
    //   40: areturn
    // Exception table:
    //   from	to	target	type
    //   9	25	31	finally
    //   25	28	31	finally
    //   32	35	31	finally
  }
  
  public void a(ChannelModel paramChannelModel) {
    this.a = paramChannelModel;
  }
  
  public void a(boolean paramBoolean) {
    this.f = paramBoolean;
  }
  
  public ZegoLiveRoom b() {
    return this.e;
  }
  
  public void c() {
    if (e()) {
      ZegoLiveRoom zegoLiveRoom = a().b();
      if (zegoLiveRoom != null) {
        zegoLiveRoom.enableMic(false);
        zegoLiveRoom.enableCamera(false);
        zegoLiveRoom.setPreviewView(null);
        zegoLiveRoom.setZegoLivePublisherCallback(null);
        zegoLiveRoom.setZegoLivePlayerCallback(null);
        zegoLiveRoom.setZegoRoomCallback(null);
        zegoLiveRoom.setZegoIMCallback(null);
        zegoLiveRoom.logoutRoom();
        BizLivePresenter.a().a((OnLiveRoomListener)null);
        BizLivePresenter.a().a((OnVideoLiveListener)null);
      } 
      a(false);
    } 
  }
  
  public void d() {
    if (e() && a().b() != null)
      this.e.pauseModule(12); 
  }
  
  public boolean e() {
    return this.f;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\manager\FlashZegoApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */