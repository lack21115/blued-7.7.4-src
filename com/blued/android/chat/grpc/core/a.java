package com.blued.android.chat.grpc.core;

import com.blued.android.chat.grpc.utils.ChatLog;

public class a {
  private int a = 0;
  
  private int a(int paramInt) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append(" state changed from ");
    stringBuilder.append(this.a);
    stringBuilder.append(" to ");
    stringBuilder.append(paramInt);
    ChatLog.v("Chat_Worker", stringBuilder.toString());
    int i = this.a;
    this.a = paramInt;
    return i;
  }
  
  protected String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("worker-");
    stringBuilder.append(getClass().getSimpleName());
    return stringBuilder.toString();
  }
  
  protected void b() {}
  
  protected void c() {}
  
  public void d() {}
  
  protected void e() {}
  
  public void f() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append(" pause()");
    ChatLog.v("Chat_Worker", stringBuilder.toString());
    if (this.a == 2) {
      a(1);
      b();
    } 
  }
  
  public void g() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append(" resume()");
    ChatLog.v("Chat_Worker", stringBuilder.toString());
    if (this.a == 1) {
      a(2);
      c();
    } 
  }
  
  public void h() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append(" start()");
    ChatLog.v("Chat_Worker", stringBuilder.toString());
    int i = a(2);
    if (i == 0) {
      d();
      c();
      return;
    } 
    if (i == 1)
      c(); 
  }
  
  public void i() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(a());
    stringBuilder.append(" stop()");
    ChatLog.v("Chat_Worker", stringBuilder.toString());
    int i = a(0);
    if (i == 2) {
      b();
      e();
      return;
    } 
    if (i == 1)
      e(); 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\chat\grpc\core\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */