package com.qq.e.comm.plugin.aa.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.util.GDTLogger;

public class d extends FrameLayout implements b, c.a {
  private Context a;
  
  private boolean b;
  
  private boolean c;
  
  private e d;
  
  private ImageView e;
  
  private ImageView f;
  
  private final Handler g;
  
  private f.a h;
  
  private void a() {
    ImageView imageView;
    Bitmap bitmap;
    if (this.e == null)
      return; 
    if (this.d.c()) {
      imageView = this.e;
      bitmap = g.b(this.a);
    } else {
      imageView = this.e;
      bitmap = g.a(this.a);
    } 
    imageView.setImageBitmap(bitmap);
  }
  
  public void a(int paramInt) {
    if (!this.c)
      return; 
    if (!this.b) {
      this.b = true;
      setVisibility(0);
    } 
    a();
    e();
    this.g.sendEmptyMessage(2);
    Message message = this.g.obtainMessage(1);
    if (paramInt != 0) {
      this.g.removeMessages(1);
      this.g.sendMessageDelayed(message, paramInt);
    } 
  }
  
  public void a(e parame) {
    this.d = parame;
    this.d.a(this.h);
    a();
  }
  
  public void c() {
    if (!this.c)
      return; 
    if (this.d.g() != f.d.a && this.d.g() != f.d.b)
      a(3000); 
  }
  
  public void d() {
    if (this.b) {
      try {
        this.g.removeMessages(2);
        setVisibility(4);
      } catch (IllegalArgumentException illegalArgumentException) {
        GDTLogger.d("MediaController already removed");
      } 
      this.b = false;
    } 
  }
  
  public void e() {
    ImageView imageView;
    Bitmap bitmap;
    if (this.f == null)
      return; 
    if (this.d.d()) {
      imageView = this.f;
      bitmap = g.d(this.a);
    } else {
      imageView = this.f;
      bitmap = g.c(this.a);
    } 
    imageView.setImageBitmap(bitmap);
  }
  
  public void h() {
    if (this.b)
      c(); 
  }
  
  public boolean isShown() {
    return this.b;
  }
  
  public static interface a {
    void a(int param1Int, Exception param1Exception);
    
    void b_();
    
    void c_();
    
    void f_();
    
    void g();
    
    void g_();
    
    void h_();
    
    void i_();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qq\e\comm\plugin\aa\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */