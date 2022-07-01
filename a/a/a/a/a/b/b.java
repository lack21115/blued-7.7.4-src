package a.a.a.a.a.b;

import a.a.a.a.a.e.h;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class b {
  public e a;
  
  public Camera b;
  
  public volatile Camera.CameraInfo c = new Camera.CameraInfo();
  
  public Camera.Parameters d;
  
  public Handler e;
  
  public d f;
  
  public int g = -1;
  
  public final Object h = new Object();
  
  public ConditionVariable i = new ConditionVariable();
  
  public Semaphore j = new Semaphore(1);
  
  public b() {
    HandlerThread handlerThread = new HandlerThread("CameraHandlerThread");
    handlerThread.start();
    this.e = new b(this, handlerThread.getLooper());
  }
  
  public static b a() {
    return c.a;
  }
  
  public static boolean a(int paramInt) {
    if (Build.VERSION.SDK_INT < 9)
      return false; 
    int j = Camera.getNumberOfCameras();
    if (j > 2 && paramInt == 2)
      return true; 
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    for (int i = 0; i < j; i++) {
      Camera.getCameraInfo(i, cameraInfo);
      if (paramInt == cameraInfo.facing)
        return true; 
    } 
    return false;
  }
  
  public void a(e parame) {
    this.a = parame;
  }
  
  public d b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokevirtual c : (I)V
    //   7: aload_0
    //   8: getfield b : Landroid/hardware/Camera;
    //   11: ifnull -> 33
    //   14: new a/a/a/a/a/b/b$d
    //   17: dup
    //   18: aload_0
    //   19: aconst_null
    //   20: invokespecial <init> : (La/a/a/a/a/b/b;La/a/a/a/a/b/b$a;)V
    //   23: astore_2
    //   24: aload_0
    //   25: aload_2
    //   26: putfield f : La/a/a/a/a/b/b$d;
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_2
    //   32: areturn
    //   33: aload_0
    //   34: monitorexit
    //   35: aconst_null
    //   36: areturn
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Exception table:
    //   from	to	target	type
    //   2	29	37	finally
  }
  
  public Camera.CameraInfo b() {
    synchronized (this.h) {
      Camera.getCameraInfo(this.g, this.c);
      return this.c;
    } 
  }
  
  public final void c(int paramInt) {
    this.e.removeCallbacksAndMessages(null);
    if (this.b != null)
      this.f.a(); 
    this.b = Camera.open(paramInt);
    this.g = paramInt;
    a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
    null = new StringBuilder();
    null.append("camera opened:");
    null.append(this.b);
    null.append(",(");
    null.append(paramInt);
    null.append(")");
    e1.c("CameraDevice", null.toString());
    synchronized (this.h) {
      Camera.getCameraInfo(paramInt, this.c);
      return;
    } 
  }
  
  public boolean c() {
    synchronized (this.h) {
      int i = this.c.facing;
      boolean bool = true;
      if (i != 1)
        bool = false; 
      return bool;
    } 
  }
  
  public int d() {
    return Camera.getNumberOfCameras();
  }
  
  public final void e() {
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: acquiring semphore");
    try {
      this.j.acquire();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    } 
    this.i.close();
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: acquired semphore");
  }
  
  public final void f() {
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: blocking");
    this.i.block();
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: released blocking");
  }
  
  public final void g() {
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: releasing semphore");
    this.i.open();
    this.j.release();
    a.a.a.a.a.e.e.g.a("CameraDevice", "sginal: released semphore");
  }
  
  public class b extends Handler {
    public b(b this$0, Looper param1Looper) {
      super(param1Looper);
    }
    
    public void handleMessage(Message param1Message) {
      a.a.a.a.a.e.e e = a.a.a.a.a.e.e.g;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("msg.what:");
      stringBuilder.append(param1Message.what);
      e.c("CameraDevice", stringBuilder.toString());
      try {
        int i = param1Message.what;
        switch (i) {
          case 14:
            try {
              b.a(this.a).setAutoFocusMoveCallback((Camera.AutoFocusMoveCallback)param1Message.obj);
            } catch (NoClassDefFoundError noClassDefFoundError) {
              a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append("FATAL ERROR:");
              stringBuilder1.append(noClassDefFoundError.getMessage());
              e1.e("CameraDevice", stringBuilder1.toString());
            } 
            break;
          case 13:
            b.a(this.a).cancelAutoFocus();
            break;
          case 12:
            b.a(this.a).autoFocus((Camera.AutoFocusCallback)param1Message.obj);
            break;
          case 11:
            for (byte[] arrayOfByte : param1Message.obj) {
              a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
              StringBuilder stringBuilder1 = new StringBuilder();
              stringBuilder1.append(arrayOfByte);
              stringBuilder1.append(" added");
              e1.c("CameraDevice", stringBuilder1.toString());
              b.a(this.a).addCallbackBuffer(arrayOfByte);
            } 
            break;
          case 10:
            b.a(this.a).setErrorCallback((Camera.ErrorCallback)param1Message.obj);
            break;
          case 9:
            e = a.a.a.a.a.e.e.g;
            stringBuilder = new StringBuilder();
            stringBuilder.append("arg1:");
            stringBuilder.append(param1Message.arg1);
            e.c("CameraDevice", stringBuilder.toString());
            b.a(this.a).setDisplayOrientation(param1Message.arg1);
            break;
          case 8:
            b.a(this.a).setPreviewCallbackWithBuffer((Camera.PreviewCallback)param1Message.obj);
            break;
          case 7:
            b.a(this.a).setOneShotPreviewCallback((Camera.PreviewCallback)param1Message.obj);
            break;
          case 6:
            b.a(this.a, b.a(this.a).getParameters());
            break;
          case 5:
            b.a(this.a).setParameters((Camera.Parameters)param1Message.obj);
            break;
          case 4:
            b.a(this.a).stopPreview();
            break;
          case 3:
            a.a.a.a.a.e.e.g.c("CameraDevice", "startPreview");
            b.a(this.a).startPreview();
            return;
          case 2:
            try {
              b.a(this.a).setPreviewTexture((SurfaceTexture)param1Message.obj);
              return;
            } catch (IOException iOException) {
              throw new RuntimeException(iOException);
            } 
          case 1:
            b.a(this.a).stopPreview();
            b.a(this.a).setPreviewCallbackWithBuffer(null);
            b.a(this.a).release();
            b.a(this.a, (Camera)null);
            b.a(this.a, (b.d)null);
            b.a(this.a, (Camera.Parameters)null);
            a.a.a.a.a.e.e.g.c("CameraDevice", "RELEASE");
            break;
        } 
      } catch (NullPointerException nullPointerException) {
        e = a.a.a.a.a.e.e.g;
        stringBuilder = new StringBuilder();
        stringBuilder.append("exception msg:");
        stringBuilder.append(nullPointerException.getMessage());
        e.e("CameraDevice", stringBuilder.toString());
      } catch (RuntimeException runtimeException) {
        if (((Message)nullPointerException).what != 1 && b.a(this.a) != null) {
          try {
            a.a.a.a.a.e.e e1 = a.a.a.a.a.e.e.g;
            stringBuilder = new StringBuilder();
            stringBuilder.append("CameraManager,CameraHandler in handle message exception:");
            stringBuilder.append(runtimeException);
            e1.e("CameraDevice", stringBuilder.toString());
            b.a(this.a).release();
          } catch (Exception exception) {
            a.a.a.a.a.e.e.g.e("CameraDevice", "Fail to release the camera.");
          } 
          b.a(this.a, (Camera)null);
          b.a(this.a, (b.d)null);
          b.a(this.a, (Camera.Parameters)null);
        } 
      } 
      b.h(this.a);
    }
  }
  
  public static class c {
    public static final b a = new b(null);
  }
  
  public class d {
    public d(b this$0) {
      boolean bool;
      new ReentrantLock();
      if (b.a(b.this) != null) {
        bool = true;
      } else {
        bool = false;
      } 
      h.a(bool);
    }
    
    public void a() {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield a : La/a/a/a/a/b/b;
      //   6: invokestatic c : (La/a/a/a/a/b/b;)Landroid/os/Handler;
      //   9: aconst_null
      //   10: invokevirtual removeCallbacksAndMessages : (Ljava/lang/Object;)V
      //   13: aload_0
      //   14: getfield a : La/a/a/a/a/b/b;
      //   17: invokestatic d : (La/a/a/a/a/b/b;)V
      //   20: aload_0
      //   21: getfield a : La/a/a/a/a/b/b;
      //   24: invokestatic c : (La/a/a/a/a/b/b;)Landroid/os/Handler;
      //   27: iconst_1
      //   28: invokevirtual sendEmptyMessage : (I)Z
      //   31: pop
      //   32: aload_0
      //   33: getfield a : La/a/a/a/a/b/b;
      //   36: invokestatic e : (La/a/a/a/a/b/b;)V
      //   39: aload_0
      //   40: monitorexit
      //   41: return
      //   42: astore_1
      //   43: aload_0
      //   44: monitorexit
      //   45: aload_1
      //   46: athrow
      // Exception table:
      //   from	to	target	type
      //   2	39	42	finally
    }
    
    public void a(int param1Int) {
      b.d(this.a);
      b.c(this.a).obtainMessage(9, param1Int, 0).sendToTarget();
      b.e(this.a);
    }
    
    public void a(SurfaceTexture param1SurfaceTexture) {
      b.c(this.a).obtainMessage(2, param1SurfaceTexture).sendToTarget();
    }
    
    public void a(Camera.AutoFocusCallback param1AutoFocusCallback) {
      b.g(this.a).close();
      b.c(this.a).obtainMessage(12, param1AutoFocusCallback).sendToTarget();
      b.g(this.a).block();
    }
    
    public void a(Camera.AutoFocusMoveCallback param1AutoFocusMoveCallback) {
      b.g(this.a).close();
      b.c(this.a).obtainMessage(14, param1AutoFocusMoveCallback).sendToTarget();
      b.g(this.a).block();
    }
    
    public void a(Camera.Parameters param1Parameters) {
      b.d(this.a);
      b.c(this.a).obtainMessage(5, param1Parameters).sendToTarget();
      b.e(this.a);
      b(param1Parameters);
    }
    
    public void a(Camera.PreviewCallback param1PreviewCallback) {
      b.d(this.a);
      b.c(this.a).obtainMessage(8, param1PreviewCallback).sendToTarget();
      b.e(this.a);
    }
    
    public void a(List<byte[]> param1List) {
      b.d(this.a);
      b.c(this.a).obtainMessage(11, param1List).sendToTarget();
      b.e(this.a);
    }
    
    public void b() {
      b.c(this.a).sendEmptyMessage(3);
    }
    
    public final void b(Camera.Parameters param1Parameters) {
      if (b.b(this.a) != null)
        b.b(this.a).a(param1Parameters); 
    }
    
    public void b(Camera.PreviewCallback param1PreviewCallback) {
      b.d(this.a);
      b.c(this.a).obtainMessage(7, param1PreviewCallback).sendToTarget();
      b.e(this.a);
    }
    
    public void c() {
      b.d(this.a);
      b.c(this.a).sendEmptyMessage(4);
      b.e(this.a);
    }
    
    public Camera.Parameters d() {
      b.d(this.a);
      b.c(this.a).sendEmptyMessage(6);
      b.e(this.a);
      b(b.f(this.a));
      return b.f(this.a);
    }
    
    public void e() {
      b.g(this.a).close();
      b.c(this.a).sendEmptyMessage(13);
      b.g(this.a).block();
    }
  }
  
  public static interface e {
    void a(Camera.Parameters param1Parameters);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\a\a\a\a\a\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */