package com.soft.blued.ui.msg.VideoChat;

import android.app.Activity;

public class VideoChatTools implements IVideoChatTools {
  private static IVideoChatTools a;
  
  private BD1V1Config b;
  
  private Activity c;
  
  private IVideoChatListener d;
  
  private String e;
  
  private int f;
  
  public VideoChatTools(Activity paramActivity, BD1V1Config paramBD1V1Config, IVideoChatListener paramIVideoChatListener) {
    this.c = paramActivity;
    this.b = paramBD1V1Config;
    this.d = paramIVideoChatListener;
    a(this.c, this.b, this.d);
  }
  
  public void a() {
    a.a();
  }
  
  public void a(Activity paramActivity, BD1V1Config paramBD1V1Config, IVideoChatListener paramIVideoChatListener) {
    a = VideoChatToolsForZego.i();
    a.a(paramActivity, paramBD1V1Config, paramIVideoChatListener);
  }
  
  public void a(String paramString, int paramInt) {
    this.e = paramString;
    this.f = paramInt;
    a.a(paramString, paramInt);
  }
  
  public void a(boolean paramBoolean) {
    a.a(paramBoolean);
  }
  
  public void b() {
    a.b();
  }
  
  public void b(boolean paramBoolean) {
    a.b(paramBoolean);
  }
  
  public void c() {
    a.c();
  }
  
  public void d() {
    a.d();
  }
  
  public void e() {
    a.e();
  }
  
  public void f() {
    a.f();
  }
  
  public void g() {
    a.g();
  }
  
  public void h() {
    a.h();
  }
  
  public void i() {
    a.c();
  }
  
  public void j() {
    a.c();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\VideoChat\VideoChatTools.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */