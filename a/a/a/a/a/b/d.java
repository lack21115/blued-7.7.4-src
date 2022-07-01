package a.a.a.a.a.b;

import com.qiniu.pili.droid.streaming.CameraStreamingSetting;

public class d {
  public boolean a;
  
  public boolean b;
  
  public volatile boolean c = true;
  
  public boolean d;
  
  public CameraStreamingSetting.CAMERA_FACING_ID e;
  
  public void a(CameraStreamingSetting.CAMERA_FACING_ID paramCAMERA_FACING_ID) {
    this.e = paramCAMERA_FACING_ID;
  }
  
  public void a(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public boolean a() {
    if (!this.c)
      return this.d; 
    boolean bool = false;
    this.c = false;
    if (this.e == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
      if (this.b) {
        bool = this.a;
      } else if (!this.a) {
        bool = true;
      } 
      this.d = bool;
    } else {
      this.d = false;
    } 
    return this.d;
  }
  
  public void b(boolean paramBoolean) {
    this.b = paramBoolean;
  }
  
  public void c(boolean paramBoolean) {
    this.c = paramBoolean;
  }
  
  public boolean d(boolean paramBoolean) {
    if (this.e == CameraStreamingSetting.CAMERA_FACING_ID.CAMERA_FACING_FRONT) {
      if (!this.b)
        if (!paramBoolean) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }  
      this.d = paramBoolean;
    } else {
      this.d = paramBoolean;
    } 
    return this.d;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */