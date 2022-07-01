package com.qiniu.pili.droid.shortvideo.a.a;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import com.qiniu.pili.droid.shortvideo.f.e;
import java.util.List;

public final class a {
  private Camera a;
  
  private Camera.CameraInfo b = new Camera.CameraInfo();
  
  private int c = 0;
  
  private boolean d = false;
  
  public static a a() {
    return a.a;
  }
  
  private static boolean a(int paramInt, Camera.CameraInfo paramCameraInfo) {
    try {
      Camera.getCameraInfo(paramInt, paramCameraInfo);
      return true;
    } catch (Exception exception) {
      e.f.d(exception.getMessage());
      return false;
    } 
  }
  
  public static int b() {
    return Camera.getNumberOfCameras();
  }
  
  private void b(Camera.Parameters paramParameters) {
    if (paramParameters == null) {
      e.f.d("CameraDevice", "initializeCapabilities params is null");
      return;
    } 
    this.d = paramParameters.getSupportedFocusModes().contains("continuous-picture");
  }
  
  public static boolean e(int paramInt) {
    if (Build.VERSION.SDK_INT < 9)
      return false; 
    int j = Camera.getNumberOfCameras();
    if (j > 2 && paramInt == 2)
      return true; 
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    for (int i = 0; i < j; i++) {
      if (a(i, cameraInfo) && paramInt == cameraInfo.facing)
        return true; 
    } 
    return false;
  }
  
  private int f(int paramInt) {
    int j = Camera.getNumberOfCameras();
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    for (int i = 0; i < j; i++) {
      if (a(i, cameraInfo) && cameraInfo.facing == paramInt)
        return i; 
    } 
    return -1;
  }
  
  public void a(SurfaceTexture paramSurfaceTexture) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setPreviewTexture failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: getstatic android/os/Build$VERSION.SDK_INT : I
    //   25: istore_2
    //   26: iload_2
    //   27: bipush #11
    //   29: if_icmplt -> 90
    //   32: aload_0
    //   33: getfield a : Landroid/hardware/Camera;
    //   36: aload_1
    //   37: invokevirtual setPreviewTexture : (Landroid/graphics/SurfaceTexture;)V
    //   40: goto -> 90
    //   43: astore_1
    //   44: aload_1
    //   45: invokevirtual printStackTrace : ()V
    //   48: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   51: astore_3
    //   52: new java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial <init> : ()V
    //   59: astore #4
    //   61: aload #4
    //   63: ldc 'setPreviewTexture failed '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #4
    //   71: aload_1
    //   72: invokevirtual getMessage : ()Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: ldc 'CameraDevice'
    //   82: aload #4
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: monitorexit
    //   92: return
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	93	finally
    //   22	26	93	finally
    //   32	40	43	java/lang/Exception
    //   32	40	93	finally
    //   44	90	93	finally
  }
  
  public void a(Camera.AutoFocusCallback paramAutoFocusCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'autoFocus failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: aload_1
    //   27: invokevirtual autoFocus : (Landroid/hardware/Camera$AutoFocusCallback;)V
    //   30: goto -> 76
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   41: astore_2
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc 'autoFocus failed: '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_1
    //   59: invokevirtual getMessage : ()Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 'CameraDevice'
    //   69: aload_3
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	79	finally
    //   22	30	33	java/lang/RuntimeException
    //   22	30	79	finally
    //   34	76	79	finally
  }
  
  public void a(Camera.AutoFocusMoveCallback paramAutoFocusMoveCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setAutoFocusMoveCallback failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: aload_1
    //   27: invokevirtual setAutoFocusMoveCallback : (Landroid/hardware/Camera$AutoFocusMoveCallback;)V
    //   30: goto -> 76
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   41: astore_2
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc 'setAutoFocusMoveCallback failed: '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_1
    //   59: invokevirtual getMessage : ()Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 'CameraDevice'
    //   69: aload_3
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	79	finally
    //   22	30	33	java/lang/RuntimeException
    //   22	30	79	finally
    //   34	76	79	finally
  }
  
  public void a(Camera.Parameters paramParameters) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setParameters failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: aload_1
    //   27: invokevirtual setParameters : (Landroid/hardware/Camera$Parameters;)V
    //   30: goto -> 76
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   41: astore_2
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc 'setParameters failed: '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_1
    //   59: invokevirtual getMessage : ()Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 'CameraDevice'
    //   69: aload_3
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	79	finally
    //   22	30	33	java/lang/RuntimeException
    //   22	30	79	finally
    //   34	76	79	finally
  }
  
  public void a(Camera.PreviewCallback paramPreviewCallback) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setPreviewCallbackWithBuffer failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: aload_1
    //   27: invokevirtual setPreviewCallbackWithBuffer : (Landroid/hardware/Camera$PreviewCallback;)V
    //   30: goto -> 76
    //   33: astore_1
    //   34: aload_1
    //   35: invokevirtual printStackTrace : ()V
    //   38: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   41: astore_2
    //   42: new java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial <init> : ()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc 'setPreviewCallbackWithBuffer failed: '
    //   53: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_1
    //   59: invokevirtual getMessage : ()Ljava/lang/String;
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_2
    //   67: ldc 'CameraDevice'
    //   69: aload_3
    //   70: invokevirtual toString : ()Ljava/lang/String;
    //   73: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload_0
    //   77: monitorexit
    //   78: return
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	79	finally
    //   22	30	33	java/lang/RuntimeException
    //   22	30	79	finally
    //   34	76	79	finally
  }
  
  public void a(byte[] paramArrayOfbyte) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'addCallbackBuffer failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: aload_1
    //   27: invokevirtual addCallbackBuffer : ([B)V
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	33	finally
    //   22	30	33	finally
  }
  
  public boolean a(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: invokespecial f : (I)I
    //   7: istore_2
    //   8: iconst_0
    //   9: istore #4
    //   11: iload_2
    //   12: iconst_m1
    //   13: if_icmpne -> 61
    //   16: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   19: astore #5
    //   21: new java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial <init> : ()V
    //   28: astore #6
    //   30: aload #6
    //   32: ldc 'can not find the camera by faceID : '
    //   34: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload #6
    //   40: iload_1
    //   41: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload #5
    //   47: ldc 'CameraDevice'
    //   49: aload #6
    //   51: invokevirtual toString : ()Ljava/lang/String;
    //   54: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload_0
    //   58: monitorexit
    //   59: iconst_0
    //   60: ireturn
    //   61: aload_0
    //   62: invokevirtual f : ()V
    //   65: aload_0
    //   66: iload_2
    //   67: invokestatic open : (I)Landroid/hardware/Camera;
    //   70: putfield a : Landroid/hardware/Camera;
    //   73: iload #4
    //   75: istore_3
    //   76: aload_0
    //   77: getfield a : Landroid/hardware/Camera;
    //   80: ifnull -> 190
    //   83: aload_0
    //   84: getfield a : Landroid/hardware/Camera;
    //   87: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   90: astore #5
    //   92: iload #4
    //   94: istore_3
    //   95: aload #5
    //   97: ifnull -> 190
    //   100: iconst_1
    //   101: istore_3
    //   102: goto -> 190
    //   105: astore #5
    //   107: aload_0
    //   108: aconst_null
    //   109: putfield a : Landroid/hardware/Camera;
    //   112: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   115: astore #6
    //   117: new java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial <init> : ()V
    //   124: astore #7
    //   126: aload #7
    //   128: ldc 'failed to open camera '
    //   130: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: pop
    //   134: aload #7
    //   136: iload_2
    //   137: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload #7
    //   143: ldc ' faceID is '
    //   145: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload #7
    //   151: iload_1
    //   152: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload #7
    //   158: ldc ' : '
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload #7
    //   166: aload #5
    //   168: invokevirtual getMessage : ()Ljava/lang/String;
    //   171: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload #6
    //   177: ldc 'CameraDevice'
    //   179: aload #7
    //   181: invokevirtual toString : ()Ljava/lang/String;
    //   184: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   187: iload #4
    //   189: istore_3
    //   190: iload_3
    //   191: ifeq -> 275
    //   194: iload_2
    //   195: aload_0
    //   196: getfield b : Landroid/hardware/Camera$CameraInfo;
    //   199: invokestatic a : (ILandroid/hardware/Camera$CameraInfo;)Z
    //   202: pop
    //   203: aload_0
    //   204: aload_0
    //   205: invokevirtual k : ()Landroid/hardware/Camera$Parameters;
    //   208: invokespecial b : (Landroid/hardware/Camera$Parameters;)V
    //   211: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   214: astore #5
    //   216: new java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial <init> : ()V
    //   223: astore #6
    //   225: aload #6
    //   227: ldc 'open camera '
    //   229: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload #6
    //   235: iload_2
    //   236: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload #6
    //   242: ldc ' success,'
    //   244: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload #6
    //   250: ldc ' faceID is '
    //   252: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: aload #6
    //   258: iload_1
    //   259: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload #5
    //   265: ldc 'CameraDevice'
    //   267: aload #6
    //   269: invokevirtual toString : ()Ljava/lang/String;
    //   272: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload_0
    //   276: monitorexit
    //   277: iload_3
    //   278: ireturn
    //   279: astore #5
    //   281: aload_0
    //   282: monitorexit
    //   283: aload #5
    //   285: athrow
    // Exception table:
    //   from	to	target	type
    //   2	8	279	finally
    //   16	57	279	finally
    //   61	73	105	java/lang/Exception
    //   61	73	279	finally
    //   76	92	105	java/lang/Exception
    //   76	92	279	finally
    //   107	187	279	finally
    //   194	275	279	finally
  }
  
  public void b(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setDisplayOrientation failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: iload_1
    //   27: invokevirtual setDisplayOrientation : (I)V
    //   30: aload_0
    //   31: iload_1
    //   32: putfield c : I
    //   35: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   38: astore_2
    //   39: new java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial <init> : ()V
    //   46: astore_3
    //   47: aload_3
    //   48: ldc 'setDisplayOrientation: '
    //   50: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_3
    //   55: iload_1
    //   56: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload_2
    //   61: ldc 'CameraDevice'
    //   63: aload_3
    //   64: invokevirtual toString : ()Ljava/lang/String;
    //   67: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   70: goto -> 120
    //   73: astore_2
    //   74: aload_2
    //   75: invokevirtual printStackTrace : ()V
    //   78: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   81: astore_3
    //   82: new java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial <init> : ()V
    //   89: astore #4
    //   91: aload #4
    //   93: ldc 'setDisplayOrientation failed: '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload #4
    //   101: aload_2
    //   102: invokevirtual getMessage : ()Ljava/lang/String;
    //   105: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_3
    //   110: ldc 'CameraDevice'
    //   112: aload #4
    //   114: invokevirtual toString : ()Ljava/lang/String;
    //   117: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_2
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_2
    //   127: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	123	finally
    //   22	70	73	java/lang/RuntimeException
    //   22	70	123	finally
    //   74	120	123	finally
  }
  
  public Camera.CameraInfo c() {
    return this.b;
  }
  
  public void c(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setExposureCompensation failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   29: invokevirtual isAutoExposureLockSupported : ()Z
    //   32: ifeq -> 127
    //   35: aload_0
    //   36: getfield a : Landroid/hardware/Camera;
    //   39: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   42: iconst_0
    //   43: invokevirtual setAutoExposureLock : (Z)V
    //   46: aload_0
    //   47: getfield a : Landroid/hardware/Camera;
    //   50: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   53: astore_2
    //   54: aload_2
    //   55: iload_1
    //   56: invokevirtual setExposureCompensation : (I)V
    //   59: aload_0
    //   60: getfield a : Landroid/hardware/Camera;
    //   63: aload_2
    //   64: invokevirtual setParameters : (Landroid/hardware/Camera$Parameters;)V
    //   67: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   70: astore_2
    //   71: new java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial <init> : ()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 'setExposure:'
    //   82: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: iload_1
    //   88: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_3
    //   93: ldc ' Current exposure: '
    //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_3
    //   100: aload_0
    //   101: getfield a : Landroid/hardware/Camera;
    //   104: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   107: invokevirtual getExposureCompensation : ()I
    //   110: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_2
    //   115: ldc 'CameraDevice'
    //   117: aload_3
    //   118: invokevirtual toString : ()Ljava/lang/String;
    //   121: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   124: goto -> 187
    //   127: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   130: ldc 'CameraDevice'
    //   132: ldc 'setExposureCompensation failed, AutoExposureLock is unsupported'
    //   134: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: astore_2
    //   141: aload_2
    //   142: invokevirtual printStackTrace : ()V
    //   145: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   148: astore_3
    //   149: new java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial <init> : ()V
    //   156: astore #4
    //   158: aload #4
    //   160: ldc 'setExposureCompensation failed: '
    //   162: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload #4
    //   168: aload_2
    //   169: invokevirtual getMessage : ()Ljava/lang/String;
    //   172: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload_3
    //   177: ldc 'CameraDevice'
    //   179: aload #4
    //   181: invokevirtual toString : ()Ljava/lang/String;
    //   184: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: monitorexit
    //   189: return
    //   190: astore_2
    //   191: aload_0
    //   192: monitorexit
    //   193: aload_2
    //   194: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	190	finally
    //   22	124	140	java/lang/RuntimeException
    //   22	124	190	finally
    //   127	137	140	java/lang/RuntimeException
    //   127	137	190	finally
    //   141	187	190	finally
  }
  
  public void d(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'setZoom failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   29: astore_2
    //   30: iload_1
    //   31: iflt -> 115
    //   34: iload_1
    //   35: aload_2
    //   36: invokevirtual getMaxZoom : ()I
    //   39: if_icmpgt -> 115
    //   42: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   45: astore_3
    //   46: new java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore #4
    //   55: aload #4
    //   57: ldc 'set zoom:'
    //   59: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload #4
    //   65: iload_1
    //   66: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload #4
    //   72: ldc ', current zoom: '
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload #4
    //   80: aload_2
    //   81: invokevirtual getZoom : ()I
    //   84: invokevirtual append : (I)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_3
    //   89: ldc 'CameraDevice'
    //   91: aload #4
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_2
    //   100: iload_1
    //   101: invokevirtual setZoom : (I)V
    //   104: aload_0
    //   105: getfield a : Landroid/hardware/Camera;
    //   108: aload_2
    //   109: invokevirtual setParameters : (Landroid/hardware/Camera$Parameters;)V
    //   112: goto -> 175
    //   115: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   118: ldc 'CameraDevice'
    //   120: ldc 'zoom index out of valid range.'
    //   122: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   125: goto -> 175
    //   128: astore_2
    //   129: aload_2
    //   130: invokevirtual printStackTrace : ()V
    //   133: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   136: astore_3
    //   137: new java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial <init> : ()V
    //   144: astore #4
    //   146: aload #4
    //   148: ldc 'setZoom failed: '
    //   150: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload #4
    //   156: aload_2
    //   157: invokevirtual getMessage : ()Ljava/lang/String;
    //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: pop
    //   164: aload_3
    //   165: ldc 'CameraDevice'
    //   167: aload #4
    //   169: invokevirtual toString : ()Ljava/lang/String;
    //   172: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload_0
    //   176: monitorexit
    //   177: return
    //   178: astore_2
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	178	finally
    //   22	30	128	java/lang/RuntimeException
    //   22	30	178	finally
    //   34	112	128	java/lang/RuntimeException
    //   34	112	178	finally
    //   115	125	128	java/lang/RuntimeException
    //   115	125	178	finally
    //   129	175	178	finally
  }
  
  public boolean d() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull -> 16
    //   11: iconst_1
    //   12: istore_1
    //   13: goto -> 18
    //   16: iconst_0
    //   17: istore_1
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  public void e() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 22
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc 'cancelAutoFocus failed, camera == null'
    //   16: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield a : Landroid/hardware/Camera;
    //   26: invokevirtual cancelAutoFocus : ()V
    //   29: goto -> 75
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual printStackTrace : ()V
    //   37: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   40: astore_2
    //   41: new java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial <init> : ()V
    //   48: astore_3
    //   49: aload_3
    //   50: ldc 'cancelAutoFocus failed: '
    //   52: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload_3
    //   57: aload_1
    //   58: invokevirtual getMessage : ()Ljava/lang/String;
    //   61: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc 'CameraDevice'
    //   68: aload_3
    //   69: invokevirtual toString : ()Ljava/lang/String;
    //   72: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: monitorexit
    //   77: return
    //   78: astore_1
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Exception table:
    //   from	to	target	type
    //   2	19	78	finally
    //   22	29	32	java/lang/RuntimeException
    //   22	29	78	finally
    //   33	75	78	finally
  }
  
  public void f() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnull -> 32
    //   9: aload_0
    //   10: getfield a : Landroid/hardware/Camera;
    //   13: invokevirtual release : ()V
    //   16: aload_0
    //   17: aconst_null
    //   18: putfield a : Landroid/hardware/Camera;
    //   21: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   24: ldc 'CameraDevice'
    //   26: ldc_w 'release camera success'
    //   29: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   32: aload_0
    //   33: monitorexit
    //   34: return
    //   35: astore_1
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_1
    //   39: athrow
    // Exception table:
    //   from	to	target	type
    //   2	32	35	finally
  }
  
  public int g() {
    Camera.Parameters parameters = k();
    return (parameters == null) ? 0 : (parameters.getPreviewSize()).width;
  }
  
  public int h() {
    Camera.Parameters parameters = k();
    return (parameters == null) ? 0 : (parameters.getPreviewSize()).height;
  }
  
  public int i() {
    return this.c;
  }
  
  public boolean j() {
    return (this.b.facing == 1);
  }
  
  public Camera.Parameters k() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_1
    //   9: aload_2
    //   10: ifnonnull -> 28
    //   13: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   16: ldc 'CameraDevice'
    //   18: ldc_w 'getParameters failed, camera == null'
    //   21: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: aconst_null
    //   27: areturn
    //   28: aload_0
    //   29: getfield a : Landroid/hardware/Camera;
    //   32: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: goto -> 89
    //   41: astore_2
    //   42: aload_2
    //   43: invokevirtual printStackTrace : ()V
    //   46: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   49: astore_3
    //   50: new java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial <init> : ()V
    //   57: astore #4
    //   59: aload #4
    //   61: ldc_w 'getParameters failed: '
    //   64: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload #4
    //   70: aload_2
    //   71: invokevirtual getMessage : ()Ljava/lang/String;
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_3
    //   79: ldc 'CameraDevice'
    //   81: aload #4
    //   83: invokevirtual toString : ()Ljava/lang/String;
    //   86: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_1
    //   92: areturn
    //   93: astore_1
    //   94: aload_0
    //   95: monitorexit
    //   96: aload_1
    //   97: athrow
    // Exception table:
    //   from	to	target	type
    //   2	7	93	finally
    //   13	24	93	finally
    //   28	36	41	java/lang/RuntimeException
    //   28	36	93	finally
    //   42	89	93	finally
  }
  
  public List<int[]> l() {
    Camera.Parameters parameters = k();
    if (parameters == null)
      return null; 
    try {
      return parameters.getSupportedPreviewFpsRange();
    } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
      stringIndexOutOfBoundsException.printStackTrace();
      e.f.e("CameraDevice", "getSupportedPreviewFpsRange() failed");
      return null;
    } 
  }
  
  public int m() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 24
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc_w 'getMaxExposureCompensation failed, camera == null'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield a : Landroid/hardware/Camera;
    //   28: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   31: invokevirtual getMaxExposureCompensation : ()I
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual printStackTrace : ()V
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: astore_3
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore #4
    //   57: aload #4
    //   59: ldc_w 'getMaxExposureCompensation failed: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #4
    //   68: aload_2
    //   69: invokevirtual getMessage : ()Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: ldc 'CameraDevice'
    //   79: aload #4
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	91	finally
    //   24	35	39	java/lang/RuntimeException
    //   24	35	91	finally
    //   40	87	91	finally
  }
  
  public int n() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 24
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc_w 'getMinExposureCompensation failed, camera == null'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: getfield a : Landroid/hardware/Camera;
    //   28: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   31: invokevirtual getMinExposureCompensation : ()I
    //   34: istore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: iload_1
    //   38: ireturn
    //   39: astore_2
    //   40: aload_2
    //   41: invokevirtual printStackTrace : ()V
    //   44: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   47: astore_3
    //   48: new java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial <init> : ()V
    //   55: astore #4
    //   57: aload #4
    //   59: ldc_w 'getMinExposureCompensation failed: '
    //   62: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload #4
    //   68: aload_2
    //   69: invokevirtual getMessage : ()Ljava/lang/String;
    //   72: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: aload_3
    //   77: ldc 'CameraDevice'
    //   79: aload #4
    //   81: invokevirtual toString : ()Ljava/lang/String;
    //   84: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_0
    //   88: monitorexit
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_2
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_2
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	91	finally
    //   24	35	39	java/lang/RuntimeException
    //   24	35	91	finally
    //   40	87	91	finally
  }
  
  public List<Integer> o() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnull -> 94
    //   9: aload_0
    //   10: getfield a : Landroid/hardware/Camera;
    //   13: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   16: invokevirtual isZoomSupported : ()Z
    //   19: istore_1
    //   20: iload_1
    //   21: ifne -> 27
    //   24: goto -> 94
    //   27: aload_0
    //   28: getfield a : Landroid/hardware/Camera;
    //   31: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   34: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: areturn
    //   42: astore_2
    //   43: aload_2
    //   44: invokevirtual printStackTrace : ()V
    //   47: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   50: astore_3
    //   51: new java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial <init> : ()V
    //   58: astore #4
    //   60: aload #4
    //   62: ldc_w 'getZoomRatios failed: '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload #4
    //   71: aload_2
    //   72: invokevirtual getMessage : ()Ljava/lang/String;
    //   75: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload_3
    //   80: ldc 'CameraDevice'
    //   82: aload #4
    //   84: invokevirtual toString : ()Ljava/lang/String;
    //   87: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload_0
    //   91: monitorexit
    //   92: aconst_null
    //   93: areturn
    //   94: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   97: ldc 'CameraDevice'
    //   99: ldc_w 'getZoomRatios failed, camera == null or zoom not supported'
    //   102: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: aconst_null
    //   108: areturn
    //   109: astore_2
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_2
    //   113: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	109	finally
    //   27	38	42	java/lang/RuntimeException
    //   27	38	109	finally
    //   43	90	109	finally
    //   94	105	109	finally
  }
  
  public void p() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 23
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc_w 'startPreview failed, camera == null'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield a : Landroid/hardware/Camera;
    //   27: invokevirtual startPreview : ()V
    //   30: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   33: ldc 'CameraDevice'
    //   35: ldc_w 'startPreview'
    //   38: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   41: goto -> 88
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual printStackTrace : ()V
    //   49: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   52: astore_2
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore_3
    //   61: aload_3
    //   62: ldc_w 'startPreview failed: '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual getMessage : ()Ljava/lang/String;
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 'CameraDevice'
    //   81: aload_3
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	91	finally
    //   23	41	44	java/lang/RuntimeException
    //   23	41	91	finally
    //   45	88	91	finally
  }
  
  public void q() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield a : Landroid/hardware/Camera;
    //   6: ifnonnull -> 23
    //   9: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   12: ldc 'CameraDevice'
    //   14: ldc_w 'stopPreview failed, camera == null'
    //   17: invokevirtual d : (Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield a : Landroid/hardware/Camera;
    //   27: invokevirtual stopPreview : ()V
    //   30: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   33: ldc 'CameraDevice'
    //   35: ldc_w 'stopPreview'
    //   38: invokevirtual c : (Ljava/lang/String;Ljava/lang/String;)V
    //   41: goto -> 88
    //   44: astore_1
    //   45: aload_1
    //   46: invokevirtual printStackTrace : ()V
    //   49: getstatic com/qiniu/pili/droid/shortvideo/f/e.f : Lcom/qiniu/pili/droid/shortvideo/f/e;
    //   52: astore_2
    //   53: new java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial <init> : ()V
    //   60: astore_3
    //   61: aload_3
    //   62: ldc_w 'stopPreview failed: '
    //   65: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_3
    //   70: aload_1
    //   71: invokevirtual getMessage : ()Ljava/lang/String;
    //   74: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc 'CameraDevice'
    //   81: aload_3
    //   82: invokevirtual toString : ()Ljava/lang/String;
    //   85: invokevirtual e : (Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload_0
    //   89: monitorexit
    //   90: return
    //   91: astore_1
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Exception table:
    //   from	to	target	type
    //   2	20	91	finally
    //   23	41	44	java/lang/RuntimeException
    //   23	41	91	finally
    //   45	88	91	finally
  }
  
  static class a {
    public static final a a = new a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\qiniu\pili\droid\shortvideo\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */