package com.soft.blued.ui.msg.manager;

import android.app.Activity;
import android.view.ViewGroup;
import com.blued.android.chat.VideoChatHelper;
import com.soft.blued.ui.msg.ChannelFragment;
import com.soft.blued.ui.msg.VideoChat.BD1V1Config;
import com.soft.blued.ui.msg.VideoChat.IVideoChatListener;
import com.soft.blued.ui.msg.VideoChat.VideoChatTools;
import com.soft.blued.ui.msg.model.ChannelModel;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.Logger;

public class ChannelManager implements VideoChatHelper.CallInfoListener, VideoChatHelper.CallListener {
  public VideoChatHelper a;
  
  private Activity b;
  
  private ChannelModel c;
  
  private int d;
  
  private String e = "";
  
  private int f;
  
  private int g;
  
  private ChannelFragment h;
  
  private VideoChatTools i;
  
  private String j = "434b4c6598e4427a8a15ab18f08780e6";
  
  private long k = 3170513794L;
  
  private byte[] l = new byte[] { 
      -98, -126, -116, 45, -18, -101, -67, 14, 2, 90, 
      -85, 54, -84, 63, 45, -111, -110, 33, -9, -74, 
      -109, -121, 18, 8, -127, 75, -62, 24, -115, -69, 
      -70, -28 };
  
  public ChannelManager(ChannelFragment paramChannelFragment, ChannelModel paramChannelModel) {
    this.h = paramChannelFragment;
    this.c = paramChannelModel;
    this.b = (Activity)paramChannelFragment.getActivity();
    this.d = paramChannelModel.callType;
    this.e = paramChannelModel.channelId;
    this.g = paramChannelModel.remoteUid;
    try {
      this.f = Integer.parseInt(UserInfo.a().i().getUid());
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
    BD1V1Config bD1V1Config = new BD1V1Config(paramChannelModel.chat_sdk_type, this.l, this.k, this.j, (ViewGroup)paramChannelFragment.e, (ViewGroup)paramChannelFragment.f);
    this.i = new VideoChatTools(this.b, bD1V1Config, new IVideoChatListener(this) {
          public void a() {
            ChannelManager.a(this.a).a(new Runnable(this) {
                  public void run() {
                    (ChannelManager.a(this.a.a)).f.performClick();
                  }
                });
          }
          
          public void b() {
            ChannelManager.a(this.a).a(new Runnable(this) {
                  public void run() {
                    ChannelManager.a(this.a.a).k();
                    (ChannelManager.a(this.a.a)).f.performClick();
                  }
                });
          }
          
          public void c() {
            ChannelManager.a(this.a).a(new Runnable(this) {
                  public void run() {
                    ChannelManager.a(this.a.a).a();
                  }
                });
          }
          
          public void d() {
            ChannelManager.a(this.a).a(new Runnable(this) {
                  public void run() {
                    ChannelManager.a(this.a.a).o();
                  }
                });
          }
        });
    int i = this.d;
    if (i == 0) {
      b();
    } else if (i == 1) {
      c();
    } 
    i = this.d;
    if (i == 0) {
      this.a = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, this.g, this.e, 2, paramChannelModel.chat_sdk_type, this);
      return;
    } 
    if (i == 1) {
      this.a = new VideoChatHelper(VideoChatHelper.ROLE.CALLER, this.g, this.e, 1, paramChannelModel.chat_sdk_type, this);
      return;
    } 
    if (i == 2) {
      this.a = new VideoChatHelper(VideoChatHelper.ROLE.RECEIVER, this.g, this.e, 2, paramChannelModel.chat_sdk_type, this);
      return;
    } 
    if (i == 3)
      this.a = new VideoChatHelper(VideoChatHelper.ROLE.RECEIVER, this.g, this.e, 1, paramChannelModel.chat_sdk_type, this); 
  }
  
  private void k() {
    this.i.a(this.e, this.f);
  }
  
  public void a() {
    this.a.call(this);
  }
  
  public void a(Activity paramActivity) {
    this.i.e();
  }
  
  public void a(boolean paramBoolean) {
    this.i.a(paramBoolean);
  }
  
  public void b() {
    d();
    if (this.h.f.getChildCount() == 0)
      k(); 
  }
  
  public void b(Activity paramActivity) {
    this.i.f();
  }
  
  public void b(boolean paramBoolean) {
    this.i.b(paramBoolean);
  }
  
  public void c() {
    e();
    if (this.h.f.getChildCount() == 0)
      k(); 
  }
  
  public void c(Activity paramActivity) {
    this.i.g();
  }
  
  public void d() {
    this.i.c();
  }
  
  public void e() {
    this.i.i();
  }
  
  public void f() {
    this.i.d();
  }
  
  public void g() {
    this.i.j();
  }
  
  public void h() {
    this.i.a();
  }
  
  public void i() {
    this.i.b();
  }
  
  public void j() {
    this.i.h();
  }
  
  public void onCallClose(int paramInt) {
    this.h.a(new Runnable(this, paramInt) {
          public void run() {
            Logger.b(ChannelFragment.d, new Object[] { "onCallClose===" });
            ChannelManager.a(this.b).a(this.a);
          }
        });
  }
  
  public void onCallFailed(VideoChatHelper.CallFailed paramCallFailed, String paramString, int paramInt) {
    this.h.a(new Runnable(this, paramCallFailed, paramString) {
          public void run() {
            Logger.b(ChannelFragment.d, new Object[] { "onCallFailed===" });
            ChannelManager.a(this.c).a(this.a, this.b);
          }
        });
  }
  
  public void onCallLeftTime(int paramInt1, int paramInt2) {
    this.h.a(new Runnable(this, paramInt1) {
          public void run() {
            Logger.b(ChannelFragment.d, new Object[] { "onCallLeftTime===" });
            ChannelManager.a(this.b).b(this.a);
          }
        });
  }
  
  public void onCallLeftTimeFail() {}
  
  public void onCallSuccess(int paramInt1, int paramInt2, boolean paramBoolean, String paramString, int paramInt3) {
    this.h.a(new Runnable(this) {
          public void run() {
            Logger.b(ChannelFragment.d, new Object[] { "onCallSuccess===" });
            ChannelManager.a(this.a).l();
          }
        });
  }
  
  public void onSwitchToAudio() {
    this.h.a(new Runnable(this) {
          public void run() {
            Logger.b(ChannelFragment.d, new Object[] { "onSwitchToAudio===" });
            ChannelManager.a(this.a).b(true);
          }
        });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\manager\ChannelManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */