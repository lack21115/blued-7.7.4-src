package a.a.a.a.a.i.b.c;

import android.content.Context;
import com.qiniu.pili.droid.streaming.processing.image.mm.JNIControl;
import java.nio.ByteBuffer;

public final class a {
  public int a = -1;
  
  public int b;
  
  public boolean c = false;
  
  public int a(int paramInt1, int paramInt2, int paramInt3) {
    JNIControl.setSurfaceTextureID(paramInt1);
    JNIControl.handlePreview(0L, paramInt3, paramInt2, paramInt3, paramInt2);
    paramInt1 = JNIControl.getOutputTexture();
    this.b = paramInt1;
    return paramInt1;
  }
  
  public void a() {
    if (this.c)
      JNIControl.reInit(); 
    this.c = false;
    this.a = -1;
  }
  
  public void a(float paramFloat) {
    JNIControl.setBeautify(paramFloat);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2) {
    this.c = true;
    if (this.a == -1) {
      if (paramInt1 == 3) {
        JNIControl.setGLES(3);
      } else {
        JNIControl.setGLES(2);
      } 
      JNIControl.onSurfaceCreated(paramContext, paramInt2);
    } 
  }
  
  public void a(boolean paramBoolean) {
    JNIControl.setFrontCamera(paramBoolean);
  }
  
  public boolean a(ByteBuffer paramByteBuffer, int paramInt) {
    return JNIControl.updateNV21Frame(paramByteBuffer, paramInt);
  }
  
  public void b(float paramFloat) {
    JNIControl.setWhiten(paramFloat);
  }
  
  public void b(Context paramContext, int paramInt1, int paramInt2) {
    JNIControl.onSurfaceChanged(paramInt1, paramInt2);
    this.b = JNIControl.getOutputTexture();
    JNIControl.setCurrentDirection(1);
  }
  
  public void b(boolean paramBoolean) {
    JNIControl.setIsPortraitDisplay(paramBoolean);
  }
  
  public void c(float paramFloat) {
    JNIControl.setRedden(paramFloat);
  }
  
  public void c(boolean paramBoolean) {
    JNIControl.setDrawRotate180(paramBoolean);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\i\b\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */