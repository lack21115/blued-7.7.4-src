package com.baidu.aip.face.camera;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.baidu.aip.face.PreviewView;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Camera2Control implements ICameraControl {
  private static final int MAX_PREVIEW_HEIGHT = 1080;
  
  private static final int MAX_PREVIEW_SIZE = 2048;
  
  private static final int MAX_PREVIEW_WIDTH = 1920;
  
  private static final SparseIntArray ORIENTATIONS = new SparseIntArray();
  
  private static final int STATE_CAPTURING = 3;
  
  private static final int STATE_PICTURE_TAKEN = 4;
  
  private static final int STATE_PREVIEW = 0;
  
  private static final int STATE_WAITING_FOR_CAPTURE = 2;
  
  private static final int STATE_WAITING_FOR_LOCK = 1;
  
  private Handler backgroundHandler;
  
  private HandlerThread backgroundThread;
  
  private int camFacing = 1;
  
  private CameraDevice cameraDevice;
  
  private String cameraId;
  
  private Semaphore cameraLock = new Semaphore(1);
  
  private CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() {
      private void process(CaptureResult param1CaptureResult) {
        int i = Camera2Control.this.state;
        if (i != 0) {
          Integer integer;
          if (i != 1) {
            if (i != 2) {
              if (i != 3)
                return; 
              integer = (Integer)param1CaptureResult.get(CaptureResult.CONTROL_AE_STATE);
              if (integer == null || integer.intValue() != 5) {
                Camera2Control.this.captureStillPicture();
                return;
              } 
            } else {
              integer = (Integer)integer.get(CaptureResult.CONTROL_AE_STATE);
              if (integer == null || integer.intValue() == 5 || integer.intValue() == 4) {
                Camera2Control.access$1702(Camera2Control.this, 3);
                return;
              } 
              if (integer.intValue() == 2) {
                Camera2Control.this.captureStillPicture();
                return;
              } 
            } 
          } else {
            Integer integer1 = (Integer)integer.get(CaptureResult.CONTROL_AF_STATE);
            if (integer1 == null || integer1.intValue() == 1) {
              Camera2Control.this.captureStillPicture();
              return;
            } 
            if (4 == integer1.intValue() || integer1.intValue() == 0 || 5 == integer1.intValue() || 2 == integer1.intValue()) {
              integer = (Integer)integer.get(CaptureResult.CONTROL_AE_STATE);
              if (integer == null || integer.intValue() == 2) {
                Camera2Control.this.captureStillPicture();
                return;
              } 
              Camera2Control.this.runPreCaptureSequence();
              return;
            } 
          } 
        } 
      }
      
      public void onCaptureCompleted(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, TotalCaptureResult param1TotalCaptureResult) {
        process((CaptureResult)param1TotalCaptureResult);
      }
      
      public void onCaptureProgressed(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, CaptureResult param1CaptureResult) {
        process(param1CaptureResult);
      }
    };
  
  private CameraCaptureSession captureSession;
  
  private Context context;
  
  private final CameraDevice.StateCallback deviceStateCallback = new CameraDevice.StateCallback() {
      public void onDisconnected(CameraDevice param1CameraDevice) {
        Camera2Control.this.cameraLock.release();
        param1CameraDevice.close();
        Camera2Control.access$202(Camera2Control.this, null);
      }
      
      public void onError(CameraDevice param1CameraDevice, int param1Int) {
        Camera2Control.this.cameraLock.release();
        param1CameraDevice.close();
        Camera2Control.access$202(Camera2Control.this, null);
      }
      
      public void onOpened(CameraDevice param1CameraDevice) {
        Camera2Control.this.cameraLock.release();
        Camera2Control.access$202(Camera2Control.this, param1CameraDevice);
        Camera2Control.this.createCameraPreviewSession();
      }
    };
  
  private int flashMode;
  
  private Handler handler = new Handler(Looper.getMainLooper());
  
  private ImageReader imageReader;
  
  private Matrix matrix = new Matrix();
  
  private ICameraControl.OnFrameListener onFrameListener;
  
  private ICameraControl.OnTakePictureCallback onTakePictureCallback;
  
  private int orientation = 0;
  
  private PermissionCallback permissionCallback;
  
  private int preferredHeight = 720;
  
  private int preferredWidth = 1280;
  
  private CaptureRequest previewRequest;
  
  private CaptureRequest.Builder previewRequestBuilder;
  
  private Size previewSize;
  
  private PreviewView previewView;
  
  private int sensorOrientation;
  
  private Comparator<Size> sizeComparator = new Comparator<Size>() {
      public int compare(Size param1Size1, Size param1Size2) {
        return Long.signum(param1Size1.getWidth() * param1Size1.getHeight() - param1Size2.getWidth() * param1Size2.getHeight());
      }
    };
  
  private int state = 0;
  
  private SurfaceTexture surfaceTexture;
  
  private final TextureView.SurfaceTextureListener surfaceTextureListener = new TextureView.SurfaceTextureListener() {
      public void onSurfaceTextureAvailable(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {}
      
      public boolean onSurfaceTextureDestroyed(SurfaceTexture param1SurfaceTexture) {
        Camera2Control.this.stop();
        return false;
      }
      
      public void onSurfaceTextureSizeChanged(SurfaceTexture param1SurfaceTexture, int param1Int1, int param1Int2) {
        Camera2Control.this.configureTransform(param1Int1, param1Int2);
      }
      
      public void onSurfaceTextureUpdated(SurfaceTexture param1SurfaceTexture) {}
    };
  
  private TextureView textureView;
  
  private boolean usbCamera = false;
  
  static {
    ORIENTATIONS.append(0, 90);
    ORIENTATIONS.append(1, 0);
    ORIENTATIONS.append(2, 270);
    ORIENTATIONS.append(3, 180);
  }
  
  public Camera2Control(Context paramContext) {
    this.context = paramContext;
  }
  
  private void captureStillPicture() {
    try {
      if (this.context != null) {
        if (this.cameraDevice == null)
          return; 
        CaptureRequest.Builder builder = this.cameraDevice.createCaptureRequest(2);
        builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
        builder.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(getOrientation(this.orientation)));
        updateFlashMode(this.flashMode, builder);
        CameraCaptureSession.CaptureCallback captureCallback = new CameraCaptureSession.CaptureCallback() {
            public void onCaptureCompleted(CameraCaptureSession param1CameraCaptureSession, CaptureRequest param1CaptureRequest, TotalCaptureResult param1TotalCaptureResult) {
              Camera2Control.this.unlockFocus();
            }
          };
        this.captureSession.stopRepeating();
        this.captureSession.capture(builder.build(), captureCallback, this.backgroundHandler);
        this.state = 4;
        return;
      } 
      return;
    } catch (CameraAccessException cameraAccessException) {
      cameraAccessException.printStackTrace();
      return;
    } 
  }
  
  private void closeCamera() {
    Exception exception;
    try {
      this.cameraLock.acquire();
      if (this.captureSession != null) {
        this.captureSession.close();
        this.captureSession = null;
      } 
      if (this.cameraDevice != null) {
        this.cameraDevice.close();
        this.cameraDevice = null;
      } 
      if (this.imageReader != null) {
        this.imageReader.close();
        this.imageReader = null;
      } 
      this.cameraLock.release();
      return;
    } catch (InterruptedException null) {
      throw new RuntimeException("Interrupted while trying to lock camera closing.", exception);
    } finally {}
    this.cameraLock.release();
    throw exception;
  }
  
  private void configureTransform(int paramInt1, int paramInt2) {
    if (this.textureView != null && this.previewSize != null) {
      if (this.context == null)
        return; 
      int i = this.orientation;
      float f3 = paramInt1;
      float f4 = paramInt2;
      RectF rectF1 = new RectF(0.0F, 0.0F, f3, f4);
      RectF rectF2 = new RectF(0.0F, 0.0F, this.previewSize.getHeight(), this.previewSize.getWidth());
      float f1 = rectF1.centerX();
      float f2 = rectF1.centerY();
      if (1 == i || 3 == i) {
        rectF2.offset(f1 - rectF2.centerX(), f2 - rectF2.centerY());
        this.matrix.setRectToRect(rectF1, rectF2, Matrix.ScaleToFit.FILL);
        f3 = Math.max(f4 / this.previewSize.getHeight(), f3 / this.previewSize.getWidth());
        this.matrix.postScale(f3, f3, f1, f2);
        this.matrix.postRotate(((i - 2) * 90), f1, f2);
      } else if (2 == i) {
        this.matrix.postRotate(180.0F, f1, f2);
      } 
      this.textureView.setTransform(this.matrix);
    } 
  }
  
  private void createCameraPreviewSession() {
    try {
      if (this.surfaceTexture == null)
        this.surfaceTexture = new SurfaceTexture(11); 
      if (this.textureView != null)
        this.handler.post(new Runnable() {
              public void run() {
                try {
                  Camera2Control.this.surfaceTexture.detachFromGLContext();
                } catch (Exception exception) {
                  exception.printStackTrace();
                } 
                if (Camera2Control.this.textureView.getSurfaceTexture() != Camera2Control.this.surfaceTexture)
                  Camera2Control.this.textureView.setSurfaceTexture(Camera2Control.this.surfaceTexture); 
              }
            }); 
      Surface surface = new Surface(this.surfaceTexture);
      if (ORIENTATIONS.get(this.orientation) % 180 == 90) {
        this.surfaceTexture.setDefaultBufferSize(this.preferredWidth, this.preferredHeight);
      } else {
        this.surfaceTexture.setDefaultBufferSize(this.preferredHeight, this.preferredWidth);
      } 
      this.previewRequestBuilder = this.cameraDevice.createCaptureRequest(1);
      this.previewRequestBuilder.addTarget(surface);
      this.imageReader = ImageReader.newInstance(this.preferredWidth, this.preferredHeight, 35, 2);
      this.imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {
            public void onImageAvailable(ImageReader param1ImageReader) {
              // Byte code:
              //   0: aload_1
              //   1: invokevirtual acquireNextImage : ()Landroid/media/Image;
              //   4: astore #4
              //   6: aload #4
              //   8: invokevirtual getPlanes : ()[Landroid/media/Image$Plane;
              //   11: iconst_0
              //   12: aaload
              //   13: invokevirtual getBuffer : ()Ljava/nio/ByteBuffer;
              //   16: astore #6
              //   18: aload #6
              //   20: invokevirtual remaining : ()I
              //   23: newarray byte
              //   25: astore #5
              //   27: aload #6
              //   29: aload #5
              //   31: invokevirtual get : ([B)Ljava/nio/ByteBuffer;
              //   34: pop
              //   35: invokestatic access$700 : ()Landroid/util/SparseIntArray;
              //   38: aload_0
              //   39: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   42: invokestatic access$600 : (Lcom/baidu/aip/face/camera/Camera2Control;)I
              //   45: invokevirtual get : (I)I
              //   48: istore_3
              //   49: iload_3
              //   50: istore_2
              //   51: aload_0
              //   52: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   55: invokestatic access$800 : (Lcom/baidu/aip/face/camera/Camera2Control;)I
              //   58: iconst_1
              //   59: if_icmpne -> 87
              //   62: iload_3
              //   63: bipush #90
              //   65: if_icmpeq -> 77
              //   68: iload_3
              //   69: istore_2
              //   70: iload_3
              //   71: sipush #270
              //   74: if_icmpne -> 87
              //   77: iload_3
              //   78: sipush #180
              //   81: iadd
              //   82: sipush #360
              //   85: irem
              //   86: istore_2
              //   87: new java/lang/StringBuilder
              //   90: dup
              //   91: invokespecial <init> : ()V
              //   94: astore #6
              //   96: aload #6
              //   98: ldc 'sensorOrientation'
              //   100: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   103: pop
              //   104: aload #6
              //   106: aload_0
              //   107: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   110: invokestatic access$900 : (Lcom/baidu/aip/face/camera/Camera2Control;)I
              //   113: invokevirtual append : (I)Ljava/lang/StringBuilder;
              //   116: pop
              //   117: ldc 'xx'
              //   119: aload #6
              //   121: invokevirtual toString : ()Ljava/lang/String;
              //   124: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
              //   127: pop
              //   128: new java/lang/StringBuilder
              //   131: dup
              //   132: invokespecial <init> : ()V
              //   135: astore #6
              //   137: aload #6
              //   139: ldc 'sensorOrientation'
              //   141: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   144: pop
              //   145: aload #6
              //   147: aload #4
              //   149: invokevirtual getWidth : ()I
              //   152: invokevirtual append : (I)Ljava/lang/StringBuilder;
              //   155: pop
              //   156: aload #6
              //   158: ldc ' '
              //   160: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   163: pop
              //   164: aload #6
              //   166: aload #4
              //   168: invokevirtual getHeight : ()I
              //   171: invokevirtual append : (I)Ljava/lang/StringBuilder;
              //   174: pop
              //   175: ldc 'xx'
              //   177: aload #6
              //   179: invokevirtual toString : ()Ljava/lang/String;
              //   182: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
              //   185: pop
              //   186: aload_1
              //   187: invokevirtual getImageFormat : ()I
              //   190: istore_3
              //   191: new java/lang/StringBuilder
              //   194: dup
              //   195: invokespecial <init> : ()V
              //   198: astore_1
              //   199: aload_1
              //   200: ldc 'bob image fmt:'
              //   202: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   205: pop
              //   206: aload_1
              //   207: iload_3
              //   208: invokevirtual append : (I)Ljava/lang/StringBuilder;
              //   211: pop
              //   212: aload_1
              //   213: ldc ' lenght->'
              //   215: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
              //   218: pop
              //   219: aload_1
              //   220: aload #5
              //   222: arraylength
              //   223: invokevirtual append : (I)Ljava/lang/StringBuilder;
              //   226: pop
              //   227: ldc 'xx'
              //   229: aload_1
              //   230: invokevirtual toString : ()Ljava/lang/String;
              //   233: invokestatic e : (Ljava/lang/String;Ljava/lang/String;)I
              //   236: pop
              //   237: iload_2
              //   238: sipush #180
              //   241: irem
              //   242: bipush #90
              //   244: if_icmpne -> 272
              //   247: aload_0
              //   248: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   251: invokestatic access$1000 : (Lcom/baidu/aip/face/camera/Camera2Control;)Lcom/baidu/aip/face/PreviewView;
              //   254: aload #4
              //   256: invokevirtual getHeight : ()I
              //   259: aload #4
              //   261: invokevirtual getWidth : ()I
              //   264: invokeinterface setPreviewSize : (II)V
              //   269: goto -> 294
              //   272: aload_0
              //   273: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   276: invokestatic access$1000 : (Lcom/baidu/aip/face/camera/Camera2Control;)Lcom/baidu/aip/face/PreviewView;
              //   279: aload #4
              //   281: invokevirtual getWidth : ()I
              //   284: aload #4
              //   286: invokevirtual getHeight : ()I
              //   289: invokeinterface setPreviewSize : (II)V
              //   294: aload_0
              //   295: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   298: invokestatic access$1100 : (Lcom/baidu/aip/face/camera/Camera2Control;)Lcom/baidu/aip/face/camera/ICameraControl$OnFrameListener;
              //   301: ifnull -> 329
              //   304: aload_0
              //   305: getfield this$0 : Lcom/baidu/aip/face/camera/Camera2Control;
              //   308: invokestatic access$1100 : (Lcom/baidu/aip/face/camera/Camera2Control;)Lcom/baidu/aip/face/camera/ICameraControl$OnFrameListener;
              //   311: aload #5
              //   313: iload_2
              //   314: aload #4
              //   316: invokevirtual getWidth : ()I
              //   319: aload #4
              //   321: invokevirtual getHeight : ()I
              //   324: invokeinterface onPreviewFrame : (Ljava/lang/Object;III)V
              //   329: aload #4
              //   331: invokevirtual close : ()V
              //   334: return
            }
          },  this.backgroundHandler);
      this.previewRequestBuilder.addTarget(this.imageReader.getSurface());
      updateFlashMode(this.flashMode, this.previewRequestBuilder);
      this.cameraDevice.createCaptureSession(Arrays.asList(new Surface[] { surface, this.imageReader.getSurface() }, ), new CameraCaptureSession.StateCallback() {
            public void onConfigureFailed(CameraCaptureSession param1CameraCaptureSession) {
              StringBuilder stringBuilder = new StringBuilder();
              stringBuilder.append("onConfigureFailed");
              stringBuilder.append(param1CameraCaptureSession);
              Log.e("xx", stringBuilder.toString());
            }
            
            public void onConfigured(CameraCaptureSession param1CameraCaptureSession) {
              if (Camera2Control.this.cameraDevice == null)
                return; 
              Camera2Control.access$1202(Camera2Control.this, param1CameraCaptureSession);
              try {
                Camera2Control.this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
                Camera2Control.access$1402(Camera2Control.this, Camera2Control.this.previewRequestBuilder.build());
                Camera2Control.this.captureSession.setRepeatingRequest(Camera2Control.this.previewRequest, Camera2Control.this.captureCallback, Camera2Control.this.backgroundHandler);
                return;
              } catch (CameraAccessException cameraAccessException) {
                cameraAccessException.printStackTrace();
                return;
              } 
            }
          }this.backgroundHandler);
      return;
    } catch (CameraAccessException cameraAccessException) {
      cameraAccessException.printStackTrace();
      return;
    } 
  }
  
  private Size getOptimalSize(Size[] paramArrayOfSize, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Size paramSize) {
    ArrayList<Size> arrayList2 = new ArrayList();
    ArrayList<Size> arrayList1 = new ArrayList();
    int j = paramSize.getWidth();
    int k = paramSize.getHeight();
    int m = paramArrayOfSize.length;
    int i;
    for (i = 0; i < m; i++) {
      paramSize = paramArrayOfSize[i];
      if (paramSize.getWidth() <= paramInt3 && paramSize.getHeight() <= paramInt4 && paramSize.getHeight() == paramSize.getWidth() * k / j)
        if (paramSize.getWidth() >= paramInt1 && paramSize.getHeight() >= paramInt2) {
          arrayList2.add(paramSize);
        } else {
          arrayList1.add(paramSize);
        }  
    } 
    if (arrayList2.size() > 0)
      return Collections.<Size>min(arrayList2, this.sizeComparator); 
    paramInt2 = paramArrayOfSize.length;
    for (paramInt1 = 0; paramInt1 < paramInt2; paramInt1++) {
      paramSize = paramArrayOfSize[paramInt1];
      if (paramSize.getWidth() > paramInt3 && paramSize.getHeight() > paramInt4)
        return paramSize; 
    } 
    return (arrayList1.size() > 0) ? Collections.<Size>max(arrayList1, this.sizeComparator) : paramArrayOfSize[0];
  }
  
  private int getOrientation(int paramInt) {
    return (ORIENTATIONS.get(paramInt) + this.sensorOrientation + 270) % 360;
  }
  
  private void lockFocus() {
    if (this.captureSession != null && this.state == 0)
      try {
        this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(1));
        this.state = 1;
        this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
        return;
      } catch (CameraAccessException cameraAccessException) {
        cameraAccessException.printStackTrace();
      }  
  }
  
  private void openCamera(int paramInt1, int paramInt2) {
    if (ContextCompat.checkSelfPermission(this.context, "android.permission.CAMERA") != 0) {
      requestCameraPermission();
      return;
    } 
    setUpCameraOutputs(paramInt1, paramInt2);
    configureTransform(paramInt1, paramInt2);
    CameraManager cameraManager = (CameraManager)this.context.getSystemService("camera");
    try {
      if (this.cameraLock.tryAcquire(2500L, TimeUnit.MILLISECONDS)) {
        cameraManager.openCamera("0", this.deviceStateCallback, this.backgroundHandler);
        return;
      } 
      throw new RuntimeException("Time out waiting to lock camera opening.");
    } catch (CameraAccessException cameraAccessException) {
      cameraAccessException.printStackTrace();
      return;
    } catch (InterruptedException interruptedException) {
      throw new RuntimeException("Interrupted while trying to lock camera opening.", interruptedException);
    } 
  }
  
  private void requestCameraPermission() {
    PermissionCallback permissionCallback = this.permissionCallback;
    if (permissionCallback != null)
      permissionCallback.onRequestPermission(); 
  }
  
  private void runPreCaptureSequence() {
    try {
      this.previewRequestBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
      this.state = 2;
      this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
      return;
    } catch (CameraAccessException cameraAccessException) {
      cameraAccessException.printStackTrace();
      return;
    } 
  }
  
  private void setUpCameraOutputs(int paramInt1, int paramInt2) {
    // Byte code:
    //   0: aload_0
    //   1: getfield context : Landroid/content/Context;
    //   4: ldc_w 'camera'
    //   7: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast android/hardware/camera2/CameraManager
    //   13: astore #10
    //   15: aload #10
    //   17: invokevirtual getCameraIdList : ()[Ljava/lang/String;
    //   20: astore #11
    //   22: aload #11
    //   24: arraylength
    //   25: istore #4
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: iload #4
    //   32: if_icmpge -> 401
    //   35: aload #11
    //   37: iload_3
    //   38: aaload
    //   39: astore #7
    //   41: aload #10
    //   43: aload #7
    //   45: invokevirtual getCameraCharacteristics : (Ljava/lang/String;)Landroid/hardware/camera2/CameraCharacteristics;
    //   48: astore #8
    //   50: aload #8
    //   52: getstatic android/hardware/camera2/CameraCharacteristics.LENS_FACING : Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   55: invokevirtual get : (Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   58: checkcast java/lang/Integer
    //   61: astore #9
    //   63: aload #9
    //   65: ifnull -> 83
    //   68: aload #9
    //   70: invokevirtual intValue : ()I
    //   73: aload_0
    //   74: getfield camFacing : I
    //   77: if_icmpne -> 83
    //   80: goto -> 402
    //   83: aload #8
    //   85: getstatic android/hardware/camera2/CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP : Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   88: invokevirtual get : (Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   91: checkcast android/hardware/camera2/params/StreamConfigurationMap
    //   94: astore #9
    //   96: aload #9
    //   98: ifnonnull -> 104
    //   101: goto -> 402
    //   104: aload_0
    //   105: getfield context : Landroid/content/Context;
    //   108: ldc_w 'window'
    //   111: invokevirtual getSystemService : (Ljava/lang/String;)Ljava/lang/Object;
    //   114: checkcast android/view/WindowManager
    //   117: astore #11
    //   119: new android/graphics/Point
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore #10
    //   128: aload #11
    //   130: invokeinterface getDefaultDisplay : ()Landroid/view/Display;
    //   135: aload #10
    //   137: invokevirtual getSize : (Landroid/graphics/Point;)V
    //   140: sipush #2048
    //   143: aload #10
    //   145: getfield y : I
    //   148: iconst_2
    //   149: imul
    //   150: iconst_3
    //   151: idiv
    //   152: invokestatic max : (II)I
    //   155: istore_3
    //   156: aload_0
    //   157: aload #9
    //   159: sipush #256
    //   162: invokevirtual getOutputSizes : (I)[Landroid/util/Size;
    //   165: aload_0
    //   166: getfield textureView : Landroid/view/TextureView;
    //   169: invokevirtual getWidth : ()I
    //   172: aload_0
    //   173: getfield textureView : Landroid/view/TextureView;
    //   176: invokevirtual getHeight : ()I
    //   179: iload_3
    //   180: iload_3
    //   181: new android/util/Size
    //   184: dup
    //   185: iconst_4
    //   186: iconst_3
    //   187: invokespecial <init> : (II)V
    //   190: invokespecial getOptimalSize : ([Landroid/util/Size;IIIILandroid/util/Size;)Landroid/util/Size;
    //   193: astore #11
    //   195: aload_0
    //   196: getfield orientation : I
    //   199: istore_3
    //   200: aload_0
    //   201: aload #8
    //   203: getstatic android/hardware/camera2/CameraCharacteristics.SENSOR_ORIENTATION : Landroid/hardware/camera2/CameraCharacteristics$Key;
    //   206: invokevirtual get : (Landroid/hardware/camera2/CameraCharacteristics$Key;)Ljava/lang/Object;
    //   209: checkcast java/lang/Integer
    //   212: invokevirtual intValue : ()I
    //   215: putfield sensorOrientation : I
    //   218: iconst_1
    //   219: istore #4
    //   221: iload_3
    //   222: ifeq -> 269
    //   225: iload_3
    //   226: iconst_1
    //   227: if_icmpeq -> 243
    //   230: iload_3
    //   231: iconst_2
    //   232: if_icmpeq -> 269
    //   235: iload_3
    //   236: iconst_3
    //   237: if_icmpeq -> 243
    //   240: goto -> 409
    //   243: iload #4
    //   245: istore_3
    //   246: aload_0
    //   247: getfield sensorOrientation : I
    //   250: ifeq -> 297
    //   253: aload_0
    //   254: getfield sensorOrientation : I
    //   257: sipush #180
    //   260: if_icmpne -> 409
    //   263: iload #4
    //   265: istore_3
    //   266: goto -> 297
    //   269: iload #4
    //   271: istore_3
    //   272: aload_0
    //   273: getfield sensorOrientation : I
    //   276: bipush #90
    //   278: if_icmpeq -> 297
    //   281: aload_0
    //   282: getfield sensorOrientation : I
    //   285: sipush #270
    //   288: if_icmpne -> 409
    //   291: iload #4
    //   293: istore_3
    //   294: goto -> 297
    //   297: aload #10
    //   299: getfield x : I
    //   302: istore #6
    //   304: aload #10
    //   306: getfield y : I
    //   309: istore #5
    //   311: iload_3
    //   312: ifeq -> 414
    //   315: aload #10
    //   317: getfield y : I
    //   320: istore #6
    //   322: aload #10
    //   324: getfield x : I
    //   327: istore #5
    //   329: iload_1
    //   330: istore_3
    //   331: iload_2
    //   332: istore #4
    //   334: iload #6
    //   336: istore_1
    //   337: iload #5
    //   339: istore_2
    //   340: goto -> 343
    //   343: iload_1
    //   344: sipush #1920
    //   347: invokestatic min : (II)I
    //   350: istore_1
    //   351: iload_2
    //   352: sipush #1080
    //   355: invokestatic min : (II)I
    //   358: istore_2
    //   359: aload_0
    //   360: aload_0
    //   361: aload #9
    //   363: ldc_w android/graphics/SurfaceTexture
    //   366: invokevirtual getOutputSizes : (Ljava/lang/Class;)[Landroid/util/Size;
    //   369: iload #4
    //   371: iload_3
    //   372: iload_1
    //   373: iload_2
    //   374: aload #11
    //   376: invokespecial getOptimalSize : ([Landroid/util/Size;IIIILandroid/util/Size;)Landroid/util/Size;
    //   379: putfield previewSize : Landroid/util/Size;
    //   382: aload_0
    //   383: aload #7
    //   385: putfield cameraId : Ljava/lang/String;
    //   388: return
    //   389: astore #7
    //   391: goto -> 396
    //   394: astore #7
    //   396: aload #7
    //   398: invokevirtual printStackTrace : ()V
    //   401: return
    //   402: iload_3
    //   403: iconst_1
    //   404: iadd
    //   405: istore_3
    //   406: goto -> 29
    //   409: iconst_0
    //   410: istore_3
    //   411: goto -> 297
    //   414: iload_1
    //   415: istore #4
    //   417: iload_2
    //   418: istore_3
    //   419: iload #6
    //   421: istore_1
    //   422: iload #5
    //   424: istore_2
    //   425: goto -> 343
    // Exception table:
    //   from	to	target	type
    //   15	27	394	android/hardware/camera2/CameraAccessException
    //   15	27	389	java/lang/NullPointerException
    //   41	63	394	android/hardware/camera2/CameraAccessException
    //   41	63	389	java/lang/NullPointerException
    //   68	80	394	android/hardware/camera2/CameraAccessException
    //   68	80	389	java/lang/NullPointerException
    //   83	96	394	android/hardware/camera2/CameraAccessException
    //   83	96	389	java/lang/NullPointerException
    //   104	218	394	android/hardware/camera2/CameraAccessException
    //   104	218	389	java/lang/NullPointerException
    //   246	263	394	android/hardware/camera2/CameraAccessException
    //   246	263	389	java/lang/NullPointerException
    //   272	291	394	android/hardware/camera2/CameraAccessException
    //   272	291	389	java/lang/NullPointerException
    //   297	311	394	android/hardware/camera2/CameraAccessException
    //   297	311	389	java/lang/NullPointerException
    //   315	329	394	android/hardware/camera2/CameraAccessException
    //   315	329	389	java/lang/NullPointerException
    //   343	388	394	android/hardware/camera2/CameraAccessException
    //   343	388	389	java/lang/NullPointerException
  }
  
  private void startBackgroundThread() {
    this.backgroundThread = new HandlerThread("ocr_camera");
    this.backgroundThread.start();
    this.backgroundHandler = new Handler(this.backgroundThread.getLooper());
  }
  
  private void stopBackgroundThread() {
    HandlerThread handlerThread = this.backgroundThread;
    if (handlerThread != null) {
      handlerThread.quitSafely();
      this.backgroundThread = null;
      this.backgroundHandler = null;
    } 
  }
  
  private void unlockFocus() {
    try {
      this.previewRequestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(2));
      this.captureSession.capture(this.previewRequestBuilder.build(), this.captureCallback, this.backgroundHandler);
      this.state = 0;
      this.captureSession.setRepeatingRequest(this.previewRequest, this.captureCallback, this.backgroundHandler);
      return;
    } catch (CameraAccessException cameraAccessException) {
      cameraAccessException.printStackTrace();
      return;
    } 
  }
  
  private void updateFlashMode(int paramInt, CaptureRequest.Builder paramBuilder) {
    if (paramInt != 0) {
      if (paramInt != 1) {
        paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(1));
        return;
      } 
      paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
      return;
    } 
    paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
  }
  
  public static byte[] yuvImageToByteArray(Image paramImage) {
    int k = paramImage.getWidth();
    int m = paramImage.getHeight();
    Image.Plane[] arrayOfPlane = paramImage.getPlanes();
    int n = k * m;
    byte[] arrayOfByte1 = new byte[n * 3 / 2];
    int j = arrayOfPlane[0].getRowStride();
    if (j == k) {
      arrayOfPlane[0].getBuffer().get(arrayOfByte1, 0, k);
    } else {
      for (int i2 = 0; i2 < m; i2++) {
        arrayOfPlane[0].getBuffer().position(i2 * j);
        arrayOfPlane[0].getBuffer().get(arrayOfByte1, i2 * k, k);
      } 
    } 
    int i1 = arrayOfPlane[1].getRowStride();
    byte[] arrayOfByte2 = new byte[i1];
    byte[] arrayOfByte3 = new byte[i1];
    for (int i = 0; i < m / 2; i++) {
      int i2 = k / 2;
      ByteBuffer byteBuffer = arrayOfPlane[1].getBuffer();
      j = i * i1;
      byteBuffer.position(j);
      arrayOfPlane[1].getBuffer().get(arrayOfByte2, 0, i2);
      arrayOfPlane[2].getBuffer().position(j);
      arrayOfPlane[2].getBuffer().get(arrayOfByte3, 0, i2);
      for (j = 0; j < i2; j++) {
        int i3 = j * 2 + i2 * i + n;
        arrayOfByte1[i3] = arrayOfByte3[j];
        arrayOfByte1[i3 + 1] = arrayOfByte2[j];
      } 
    } 
    return arrayOfByte1;
  }
  
  public int getCameraDisplayOrientation(Context paramContext, int paramInt1, int paramInt2, Camera paramCamera) {
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt2, cameraInfo);
    return (cameraInfo.facing == 1) ? ((360 - (cameraInfo.orientation + paramInt1) % 360) % 360) : ((cameraInfo.orientation - paramInt1 + 360) % 360);
  }
  
  public View getDisplayView() {
    return (View)this.textureView;
  }
  
  public int getFlashMode() {
    return this.flashMode;
  }
  
  public Rect getPreviewFrame() {
    return null;
  }
  
  public PreviewView getPreviewView() {
    return this.previewView;
  }
  
  public void pause() {}
  
  public void refreshPermission() {
    openCamera(this.preferredWidth, this.preferredHeight);
  }
  
  public void resume() {
    this.state = 0;
  }
  
  public void setCameraFacing(int paramInt) {
    if (paramInt == 0) {
      paramInt = 0;
    } else {
      paramInt = 1;
    } 
    this.camFacing = paramInt;
  }
  
  public void setDisplayOrientation(int paramInt) {
    this.orientation = paramInt / 90;
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
    this.textureView = paramPreviewView.getTextureView();
    SurfaceTexture surfaceTexture = this.surfaceTexture;
    if (surfaceTexture != null) {
      surfaceTexture.detachFromGLContext();
      this.textureView.setSurfaceTexture(this.surfaceTexture);
    } 
    this.textureView.setSurfaceTextureListener(this.surfaceTextureListener);
  }
  
  public void start() {
    startBackgroundThread();
    openCamera(this.preferredWidth, this.preferredHeight);
  }
  
  public void stop() {
    ImageReader imageReader = this.imageReader;
    if (imageReader != null) {
      imageReader.close();
      closeCamera();
      stopBackgroundThread();
      this.imageReader = null;
    } 
  }
  
  public void switchCamera() {
    if (this.camFacing == 1) {
      this.camFacing = 0;
    } else {
      this.camFacing = 1;
    } 
    stop();
    this.handler.postDelayed(new Runnable() {
          public void run() {
            Camera2Control.this.start();
          }
        },  800L);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\camera\Camera2Control.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */