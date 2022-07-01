package com.baidu.aip.face.camera;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.TextureView;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.baidu.aip.face.PreviewView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Camera1Control implements ICameraControl {
  private static final int MAX_PREVIEW_SIZE = 2048;
  
  private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
  
  private Camera camera;
  
  private int cameraFacing = 1;
  
  private Handler cameraHandler = null;
  
  private HandlerThread cameraHandlerThread = null;
  
  private int cameraId = 0;
  
  private Context context;
  
  private int displayOrientation = 0;
  
  private int flashMode;
  
  private ICameraControl.OnFrameListener onFrameListener;
  
  private Camera.Parameters parameters;
  
  private PermissionCallback permissionCallback;
  
  private int preferredHeight = 720;
  
  private int preferredWidth = 1280;
  
  private Rect previewFrame = new Rect();
  
  private PreviewView previewView;
  
  private Comparator<Camera.Size> sizeComparator = new Comparator<Camera.Size>() {
      public int compare(Camera.Size param1Size1, Camera.Size param1Size2) {
        return Long.signum(param1Size1.width * param1Size1.height - param1Size2.width * param1Size2.height);
      }
    };
  
  private SurfaceTexture surfaceTexture;
  
  private AtomicBoolean takingPicture = new AtomicBoolean(false);
  
  private TextureView textureView;
  
  private Handler uiHandler = null;
  
  static {
    ORIENTATIONS.append(0, 0);
    ORIENTATIONS.append(1, 90);
    ORIENTATIONS.append(2, 180);
    ORIENTATIONS.append(3, 270);
  }
  
  public Camera1Control(Context paramContext) {
    this.context = paramContext;
  }
  
  private int getCameraDisplayOrientation(int paramInt1, int paramInt2, Camera paramCamera) {
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt2, cameraInfo);
    return (cameraInfo.facing == 1) ? ((360 - (cameraInfo.orientation + paramInt1) % 360) % 360) : ((cameraInfo.orientation - paramInt1 + 360) % 360);
  }
  
  private Camera.Size getOptimalSize(int paramInt1, int paramInt2, List<Camera.Size> paramList) {
    Camera.Size size = paramList.get(0);
    ArrayList<Camera.Size> arrayList = new ArrayList();
    for (Camera.Size size1 : paramList) {
      if (size1.width >= paramInt1 && size1.height >= paramInt2 && size1.width * paramInt2 == size1.height * paramInt1) {
        arrayList.add(size1);
        continue;
      } 
      if (size1.height >= paramInt1 && size1.width >= paramInt2 && size1.width * paramInt1 == size1.height * paramInt2)
        arrayList.add(size1); 
    } 
    if (!arrayList.isEmpty())
      return Collections.<Camera.Size>min(arrayList, this.sizeComparator); 
    for (Camera.Size size1 : paramList) {
      if (size1.width >= paramInt1 && size1.height >= paramInt2)
        return size1; 
    } 
    return size;
  }
  
  private int getSurfaceOrientation() {
    int i = this.displayOrientation;
    return (i != 0) ? ((i != 1) ? ((i != 2) ? 90 : 180) : 0) : 90;
  }
  
  private void opPreviewSize(int paramInt1, int paramInt2) {
    Camera camera = this.camera;
    if (camera != null && paramInt1 > 0)
      try {
        Camera.Parameters parameters = camera.getParameters();
        Camera.Size size = getOptimalSize(paramInt1, paramInt2, this.camera.getParameters().getSupportedPreviewSizes());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("opPreviewSize-> ");
        stringBuilder.append(size.width);
        stringBuilder.append(" ");
        stringBuilder.append(size.height);
        Log.i("wtf", stringBuilder.toString());
        parameters.setPreviewSize(size.width, size.height);
        this.camera.setParameters(parameters);
        this.camera.startPreview();
        return;
      } catch (RuntimeException runtimeException) {
        runtimeException.printStackTrace();
      }  
  }
  
  private void postStartCamera() {
    HandlerThread handlerThread = this.cameraHandlerThread;
    if (handlerThread == null || !handlerThread.isAlive()) {
      this.cameraHandlerThread = new HandlerThread("camera");
      this.cameraHandlerThread.start();
      this.cameraHandler = new Handler(this.cameraHandlerThread.getLooper());
      this.uiHandler = new Handler(Looper.getMainLooper());
    } 
    Handler handler = this.cameraHandler;
    if (handler == null)
      return; 
    handler.post(new Runnable() {
          public void run() {
            Camera1Control.this.startCamera();
          }
        });
  }
  
  private void startCamera() {
    // Byte code:
    //   0: aload_0
    //   1: getfield context : Landroid/content/Context;
    //   4: ldc_w 'android.permission.CAMERA'
    //   7: invokestatic checkSelfPermission : (Landroid/content/Context;Ljava/lang/String;)I
    //   10: ifeq -> 33
    //   13: aload_0
    //   14: getfield permissionCallback : Lcom/baidu/aip/face/camera/PermissionCallback;
    //   17: astore #4
    //   19: aload #4
    //   21: ifnull -> 32
    //   24: aload #4
    //   26: invokeinterface onRequestPermission : ()Z
    //   31: pop
    //   32: return
    //   33: aload_0
    //   34: getfield camera : Landroid/hardware/Camera;
    //   37: astore #4
    //   39: iconst_0
    //   40: istore_2
    //   41: aload #4
    //   43: ifnonnull -> 123
    //   46: new android/hardware/Camera$CameraInfo
    //   49: dup
    //   50: invokespecial <init> : ()V
    //   53: astore #4
    //   55: iconst_0
    //   56: istore_1
    //   57: iload_1
    //   58: invokestatic getNumberOfCameras : ()I
    //   61: if_icmpge -> 94
    //   64: iload_1
    //   65: aload #4
    //   67: invokestatic getCameraInfo : (ILandroid/hardware/Camera$CameraInfo;)V
    //   70: aload #4
    //   72: getfield facing : I
    //   75: aload_0
    //   76: getfield cameraFacing : I
    //   79: if_icmpne -> 87
    //   82: aload_0
    //   83: iload_1
    //   84: putfield cameraId : I
    //   87: iload_1
    //   88: iconst_1
    //   89: iadd
    //   90: istore_1
    //   91: goto -> 57
    //   94: aload_0
    //   95: aload_0
    //   96: getfield cameraId : I
    //   99: invokestatic open : (I)Landroid/hardware/Camera;
    //   102: putfield camera : Landroid/hardware/Camera;
    //   105: goto -> 115
    //   108: astore #4
    //   110: aload #4
    //   112: invokevirtual printStackTrace : ()V
    //   115: aload_0
    //   116: getfield camera : Landroid/hardware/Camera;
    //   119: ifnonnull -> 123
    //   122: return
    //   123: aload_0
    //   124: getfield cameraFacing : I
    //   127: istore_3
    //   128: iload_3
    //   129: iconst_1
    //   130: if_icmpne -> 201
    //   133: aload_0
    //   134: getstatic com/baidu/aip/face/camera/Camera1Control.ORIENTATIONS : Landroid/util/SparseIntArray;
    //   137: aload_0
    //   138: getfield displayOrientation : I
    //   141: invokevirtual get : (I)I
    //   144: aload_0
    //   145: getfield cameraId : I
    //   148: aload_0
    //   149: getfield camera : Landroid/hardware/Camera;
    //   152: invokespecial getCameraDisplayOrientation : (IILandroid/hardware/Camera;)I
    //   155: istore_2
    //   156: aload_0
    //   157: getfield camera : Landroid/hardware/Camera;
    //   160: iload_2
    //   161: invokevirtual setDisplayOrientation : (I)V
    //   164: iload_2
    //   165: istore_1
    //   166: aload_0
    //   167: getfield displayOrientation : I
    //   170: ifne -> 198
    //   173: iload_2
    //   174: bipush #90
    //   176: if_icmpeq -> 188
    //   179: iload_2
    //   180: istore_1
    //   181: iload_2
    //   182: sipush #270
    //   185: if_icmpne -> 198
    //   188: iload_2
    //   189: sipush #180
    //   192: iadd
    //   193: sipush #360
    //   196: irem
    //   197: istore_1
    //   198: goto -> 256
    //   201: iload_3
    //   202: ifne -> 239
    //   205: aload_0
    //   206: getstatic com/baidu/aip/face/camera/Camera1Control.ORIENTATIONS : Landroid/util/SparseIntArray;
    //   209: aload_0
    //   210: getfield displayOrientation : I
    //   213: invokevirtual get : (I)I
    //   216: aload_0
    //   217: getfield cameraId : I
    //   220: aload_0
    //   221: getfield camera : Landroid/hardware/Camera;
    //   224: invokespecial getCameraDisplayOrientation : (IILandroid/hardware/Camera;)I
    //   227: istore_1
    //   228: aload_0
    //   229: getfield camera : Landroid/hardware/Camera;
    //   232: iload_1
    //   233: invokevirtual setDisplayOrientation : (I)V
    //   236: goto -> 256
    //   239: iload_2
    //   240: istore_1
    //   241: iload_3
    //   242: iconst_2
    //   243: if_icmpne -> 256
    //   246: aload_0
    //   247: getfield camera : Landroid/hardware/Camera;
    //   250: iconst_0
    //   251: invokevirtual setDisplayOrientation : (I)V
    //   254: iload_2
    //   255: istore_1
    //   256: aload_0
    //   257: aload_0
    //   258: getfield preferredWidth : I
    //   261: aload_0
    //   262: getfield preferredHeight : I
    //   265: invokespecial opPreviewSize : (II)V
    //   268: aload_0
    //   269: getfield camera : Landroid/hardware/Camera;
    //   272: invokevirtual getParameters : ()Landroid/hardware/Camera$Parameters;
    //   275: invokevirtual getPreviewSize : ()Landroid/hardware/Camera$Size;
    //   278: astore #4
    //   280: iload_1
    //   281: sipush #180
    //   284: irem
    //   285: bipush #90
    //   287: if_icmpne -> 312
    //   290: aload_0
    //   291: getfield previewView : Lcom/baidu/aip/face/PreviewView;
    //   294: aload #4
    //   296: getfield height : I
    //   299: aload #4
    //   301: getfield width : I
    //   304: invokeinterface setPreviewSize : (II)V
    //   309: goto -> 331
    //   312: aload_0
    //   313: getfield previewView : Lcom/baidu/aip/face/PreviewView;
    //   316: aload #4
    //   318: getfield width : I
    //   321: aload #4
    //   323: getfield height : I
    //   326: invokeinterface setPreviewSize : (II)V
    //   331: aload_0
    //   332: getfield cameraFacing : I
    //   335: iconst_2
    //   336: if_icmpne -> 356
    //   339: aload_0
    //   340: getfield camera : Landroid/hardware/Camera;
    //   343: aload_0
    //   344: getfield textureView : Landroid/view/TextureView;
    //   347: invokevirtual getSurfaceTexture : ()Landroid/graphics/SurfaceTexture;
    //   350: invokevirtual setPreviewTexture : (Landroid/graphics/SurfaceTexture;)V
    //   353: goto -> 421
    //   356: getstatic android/os/Build$VERSION.SDK_INT : I
    //   359: bipush #26
    //   361: if_icmplt -> 381
    //   364: aload_0
    //   365: getfield camera : Landroid/hardware/Camera;
    //   368: aload_0
    //   369: getfield textureView : Landroid/view/TextureView;
    //   372: invokevirtual getSurfaceTexture : ()Landroid/graphics/SurfaceTexture;
    //   375: invokevirtual setPreviewTexture : (Landroid/graphics/SurfaceTexture;)V
    //   378: goto -> 421
    //   381: aload_0
    //   382: new android/graphics/SurfaceTexture
    //   385: dup
    //   386: bipush #11
    //   388: invokespecial <init> : (I)V
    //   391: putfield surfaceTexture : Landroid/graphics/SurfaceTexture;
    //   394: aload_0
    //   395: getfield camera : Landroid/hardware/Camera;
    //   398: aload_0
    //   399: getfield surfaceTexture : Landroid/graphics/SurfaceTexture;
    //   402: invokevirtual setPreviewTexture : (Landroid/graphics/SurfaceTexture;)V
    //   405: aload_0
    //   406: getfield uiHandler : Landroid/os/Handler;
    //   409: new com/baidu/aip/face/camera/Camera1Control$2
    //   412: dup
    //   413: aload_0
    //   414: invokespecial <init> : (Lcom/baidu/aip/face/camera/Camera1Control;)V
    //   417: invokevirtual post : (Ljava/lang/Runnable;)Z
    //   420: pop
    //   421: aload_0
    //   422: getfield camera : Landroid/hardware/Camera;
    //   425: new com/baidu/aip/face/camera/Camera1Control$3
    //   428: dup
    //   429: aload_0
    //   430: iload_1
    //   431: aload #4
    //   433: invokespecial <init> : (Lcom/baidu/aip/face/camera/Camera1Control;ILandroid/hardware/Camera$Size;)V
    //   436: invokevirtual setPreviewCallback : (Landroid/hardware/Camera$PreviewCallback;)V
    //   439: return
    //   440: astore #4
    //   442: aload #4
    //   444: invokevirtual printStackTrace : ()V
    //   447: return
    //   448: astore #4
    //   450: aload #4
    //   452: invokevirtual printStackTrace : ()V
    //   455: return
    // Exception table:
    //   from	to	target	type
    //   94	105	108	java/lang/RuntimeException
    //   331	353	448	java/io/IOException
    //   331	353	440	java/lang/RuntimeException
    //   356	378	448	java/io/IOException
    //   356	378	440	java/lang/RuntimeException
    //   381	421	448	java/io/IOException
    //   381	421	440	java/lang/RuntimeException
    //   421	439	448	java/io/IOException
    //   421	439	440	java/lang/RuntimeException
  }
  
  private void startPreview(boolean paramBoolean) {
    if (ActivityCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
      if (paramBoolean) {
        PermissionCallback permissionCallback = this.permissionCallback;
        if (permissionCallback != null)
          permissionCallback.onRequestPermission(); 
      } 
      return;
    } 
    this.camera.startPreview();
  }
  
  private void updateFlashMode(int paramInt) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          this.parameters.setFlashMode("auto");
          return;
        } 
        this.parameters.setFlashMode("auto");
        return;
      } 
      this.parameters.setFlashMode("torch");
      return;
    } 
    this.parameters.setFlashMode("off");
  }
  
  public View getDisplayView() {
    return null;
  }
  
  public int getFlashMode() {
    return this.flashMode;
  }
  
  public Rect getPreviewFrame() {
    return this.previewFrame;
  }
  
  public PreviewView getPreviewView() {
    return this.previewView;
  }
  
  public void pause() {
    Camera camera = this.camera;
    if (camera != null)
      camera.stopPreview(); 
  }
  
  public void refreshPermission() {
    startPreview(true);
  }
  
  public void resume() {
    this.takingPicture.set(false);
    if (this.camera == null)
      postStartCamera(); 
  }
  
  public void setCameraFacing(int paramInt) {
    this.cameraFacing = paramInt;
  }
  
  public void setDisplayOrientation(int paramInt) {
    this.displayOrientation = paramInt;
  }
  
  public void setOnFrameListener(ICameraControl.OnFrameListener paramOnFrameListener) {
    this.onFrameListener = paramOnFrameListener;
  }
  
  public void setPermissionCallback(PermissionCallback paramPermissionCallback) {
    this.permissionCallback = paramPermissionCallback;
  }
  
  public void setPreferredPreviewSize(int paramInt1, int paramInt2) {
    this.preferredWidth = Math.max(paramInt1, paramInt2);
    this.preferredHeight = Math.min(paramInt1, paramInt2);
  }
  
  public void setPreviewView(PreviewView paramPreviewView) {
    this.previewView = paramPreviewView;
    setTextureView(paramPreviewView.getTextureView());
  }
  
  public void setTextureView(TextureView paramTextureView) {
    this.textureView = paramTextureView;
    SurfaceTexture surfaceTexture = this.surfaceTexture;
    if (surfaceTexture != null) {
      surfaceTexture.detachFromGLContext();
      paramTextureView.setSurfaceTexture(this.surfaceTexture);
    } 
  }
  
  public void start() {
    postStartCamera();
  }
  
  public void stop() {
    Camera camera = this.camera;
    if (camera != null) {
      camera.stopPreview();
      this.camera.setPreviewCallback(null);
      this.camera.release();
      this.camera = null;
    } 
    HandlerThread handlerThread = this.cameraHandlerThread;
    if (handlerThread != null) {
      handlerThread.quit();
      this.cameraHandlerThread = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\camera\Camera1Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */