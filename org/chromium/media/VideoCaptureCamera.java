package org.chromium.media;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import org.chromium.base.Log;

@TargetApi(15)
public class VideoCaptureCamera extends VideoCapture implements Camera.PreviewCallback {
  private static final SparseArray COLOR_TEMPERATURES_MAP;
  
  private Camera.Area mAreaOfInterest;
  
  private Camera mCamera;
  
  private int mExpectedFrameSize;
  
  private int[] mGlTextures;
  
  private boolean mIsRunning;
  
  private int mPhotoHeight;
  
  private long mPhotoTakenCallbackId;
  
  private final Object mPhotoTakenCallbackLock = new Object();
  
  private int mPhotoWidth;
  
  private ReentrantLock mPreviewBufferLock = new ReentrantLock();
  
  private Camera.Parameters mPreviewParameters;
  
  private SurfaceTexture mSurfaceTexture;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  VideoCaptureCamera(int paramInt, long paramLong) {
    super(paramInt, paramLong);
  }
  
  private static Camera.CameraInfo getCameraInfo(int paramInt) {
    Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
    try {
      Camera.getCameraInfo(paramInt, cameraInfo);
      return cameraInfo;
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder("getCameraInfo: Camera.getCameraInfo: ");
      stringBuilder.append(runtimeException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
      return null;
    } 
  }
  
  private static Camera.Parameters getCameraParameters(Camera paramCamera) {
    try {
      return paramCamera.getParameters();
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder("getCameraParameters: android.hardware.Camera.getParameters: ");
      stringBuilder.append(runtimeException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
      if (paramCamera != null)
        paramCamera.release(); 
      return null;
    } 
  }
  
  static int getCaptureApiType(int paramInt) {
    return (getCameraInfo(paramInt) == null) ? 11 : 6;
  }
  
  private static String getClosestWhiteBalance(int paramInt, List paramList) {
    int j = Integer.MAX_VALUE;
    String str = null;
    int i = 0;
    while (i < COLOR_TEMPERATURES_MAP.size()) {
      int k = j;
      String str1 = str;
      if (paramList.contains(COLOR_TEMPERATURES_MAP.valueAt(i))) {
        int m = Math.abs(paramInt - COLOR_TEMPERATURES_MAP.keyAt(i));
        k = j;
        str1 = str;
        if (m < j) {
          str1 = (String)COLOR_TEMPERATURES_MAP.valueAt(i);
          k = m;
        } 
      } 
      i++;
      j = k;
      str = str1;
    } 
    return str;
  }
  
  static VideoCaptureFormat[] getDeviceSupportedFormats(int paramInt) {
    try {
      ArrayList<Integer> arrayList;
      Camera camera = Camera.open(paramInt);
      Camera.Parameters parameters = getCameraParameters(camera);
      if (parameters == null)
        return null; 
      ArrayList<VideoCaptureFormat> arrayList1 = new ArrayList();
      try {
        List list = parameters.getSupportedPreviewFormats();
      } catch (NullPointerException nullPointerException1) {
        Log.e("VideoCapture", "Camera.Parameters.getSupportedPreviewFormats: ", new Object[] { nullPointerException1 });
        nullPointerException1 = null;
      } 
      NullPointerException nullPointerException2 = nullPointerException1;
      if (nullPointerException1 == null)
        arrayList = new ArrayList(); 
      if (arrayList.size() == 0)
        arrayList.add(Integer.valueOf(0)); 
      for (Integer integer : arrayList) {
        ArrayList<int[]> arrayList2;
        int i = integer.intValue();
        paramInt = 842094169;
        if (i != 842094169)
          if (integer.intValue() != 17) {
            paramInt = 0;
          } else {
            continue;
          }  
        try {
          List list = parameters.getSupportedPreviewFpsRange();
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException1) {
          Log.e("VideoCapture", "Camera.Parameters.getSupportedPreviewFpsRange: ", new Object[] { stringIndexOutOfBoundsException1 });
          stringIndexOutOfBoundsException1 = null;
        } 
        StringIndexOutOfBoundsException stringIndexOutOfBoundsException2 = stringIndexOutOfBoundsException1;
        if (stringIndexOutOfBoundsException1 == null)
          arrayList2 = new ArrayList(); 
        if (arrayList2.size() == 0)
          arrayList2.add(new int[] { 0, 0 }); 
        for (int[] arrayOfInt : arrayList2) {
          List<Camera.Size> list2 = parameters.getSupportedPreviewSizes();
          List<Camera.Size> list1 = list2;
          if (list2 == null)
            list1 = new ArrayList(); 
          if (list1.size() == 0) {
            camera.getClass();
            list1.add(new Camera.Size(camera, 0, 0));
          } 
          for (Camera.Size size : list1)
            arrayList1.add(new VideoCaptureFormat(size.width, size.height, (arrayOfInt[1] + 999) / 1000, paramInt)); 
        } 
      } 
      camera.release();
      return arrayList1.<VideoCaptureFormat>toArray(new VideoCaptureFormat[arrayList1.size()]);
    } catch (RuntimeException runtimeException) {
      Log.e("VideoCapture", "Camera.open: ", new Object[] { runtimeException });
      return null;
    } 
  }
  
  static int getFacingMode(int paramInt) {
    Camera.CameraInfo cameraInfo = getCameraInfo(paramInt);
    if (cameraInfo == null)
      return 0; 
    switch (cameraInfo.facing) {
      default:
        return 0;
      case 1:
        return 1;
      case 0:
        break;
    } 
    return 2;
  }
  
  static String getName(int paramInt) {
    String str;
    Camera.CameraInfo cameraInfo = getCameraInfo(paramInt);
    if (cameraInfo == null)
      return null; 
    StringBuilder stringBuilder = new StringBuilder("camera ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", facing ");
    if (cameraInfo.facing == 1) {
      str = "front";
    } else {
      str = "back";
    } 
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  static int getNumberOfCameras() {
    return Camera.getNumberOfCameras();
  }
  
  private void setPreviewCallback(Camera.PreviewCallback paramPreviewCallback) {
    this.mCamera.setPreviewCallbackWithBuffer(paramPreviewCallback);
  }
  
  public boolean allocate(int paramInt1, int paramInt2, int paramInt3) {
    boolean bool = false;
    try {
      this.mCamera = Camera.open(this.mId);
      Camera.CameraInfo cameraInfo = getCameraInfo(this.mId);
      if (cameraInfo == null) {
        this.mCamera.release();
        this.mCamera = null;
        return false;
      } 
      this.mCameraNativeOrientation = cameraInfo.orientation;
      if (cameraInfo.facing == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.mInvertDeviceOrientationReadings = bool1;
      getDeviceRotation();
      int i = this.mCameraNativeOrientation;
      boolean bool1 = this.mInvertDeviceOrientationReadings;
      Camera.Parameters parameters = getCameraParameters(this.mCamera);
      if (parameters == null) {
        this.mCamera = null;
        return false;
      } 
      List list = parameters.getSupportedPreviewFpsRange();
      if (list == null || list.size() == 0) {
        Log.e("VideoCapture", "allocate: no fps range found", new Object[0]);
        return false;
      } 
      ArrayList<VideoCapture$FramerateRange> arrayList = new ArrayList(list.size());
      for (int[] arrayOfInt1 : list)
        arrayList.add(new VideoCapture$FramerateRange(arrayOfInt1[0], arrayOfInt1[1])); 
      VideoCapture$FramerateRange videoCapture$FramerateRange = getClosestFramerateRange(arrayList, paramInt3 * 1000);
      int[] arrayOfInt = new int[2];
      arrayOfInt[0] = videoCapture$FramerateRange.min;
      arrayOfInt[1] = videoCapture$FramerateRange.max;
      paramInt3 = arrayOfInt[0];
      paramInt3 = arrayOfInt[1];
      Iterator<Camera.Size> iterator = parameters.getSupportedPreviewSizes().iterator();
      i = paramInt1;
      paramInt3 = paramInt2;
      int j = Integer.MAX_VALUE;
      while (iterator.hasNext()) {
        Camera.Size size = iterator.next();
        int i1 = Math.abs(size.width - paramInt1) + Math.abs(size.height - paramInt2);
        int k = size.width;
        k = size.height;
        int n = j;
        int m = i;
        k = paramInt3;
        if (i1 < j) {
          n = j;
          m = i;
          k = paramInt3;
          if (size.width % 32 == 0) {
            m = size.width;
            k = size.height;
            n = i1;
          } 
        } 
        j = n;
        i = m;
        paramInt3 = k;
      } 
      if (j == Integer.MAX_VALUE) {
        Log.e("VideoCapture", "allocate: can not find a multiple-of-32 resolution", new Object[0]);
        return false;
      } 
      if (parameters.isVideoStabilizationSupported()) {
        StringBuilder stringBuilder = new StringBuilder("Image stabilization supported, currently: ");
        stringBuilder.append(parameters.getVideoStabilization());
        stringBuilder.append(", setting it.");
        parameters.setVideoStabilization(true);
      } 
      if (parameters.getSupportedFocusModes().contains("continuous-video"))
        parameters.setFocusMode("continuous-video"); 
      this.mCaptureFormat = new VideoCaptureFormat(i, paramInt3, arrayOfInt[1] / 1000, VideoCaptureCamera$BuggyDeviceHack.getImageFormat());
      parameters.setPictureSize(i, paramInt3);
      parameters.setPreviewSize(i, paramInt3);
      parameters.setPreviewFpsRange(arrayOfInt[0], arrayOfInt[1]);
      parameters.setPreviewFormat(this.mCaptureFormat.mPixelFormat);
      try {
        this.mCamera.setParameters(parameters);
        this.mGlTextures = new int[1];
        GLES20.glGenTextures(1, this.mGlTextures, 0);
        GLES20.glBindTexture(36197, this.mGlTextures[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0F);
        GLES20.glTexParameterf(36197, 10240, 9729.0F);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        this.mSurfaceTexture = new SurfaceTexture(this.mGlTextures[0]);
        this.mSurfaceTexture.setOnFrameAvailableListener(null);
        try {
          this.mCamera.setPreviewTexture(this.mSurfaceTexture);
          this.mCamera.setErrorCallback(new VideoCaptureCamera$CrErrorCallback(this, (byte)0));
          this.mExpectedFrameSize = this.mCaptureFormat.mWidth * this.mCaptureFormat.mHeight * ImageFormat.getBitsPerPixel(this.mCaptureFormat.mPixelFormat) / 8;
          for (paramInt1 = bool; paramInt1 < 3; paramInt1++) {
            byte[] arrayOfByte = new byte[this.mExpectedFrameSize];
            this.mCamera.addCallbackBuffer(arrayOfByte);
          } 
          return true;
        } catch (IOException iOException) {
          StringBuilder stringBuilder = new StringBuilder("allocate: ");
          stringBuilder.append(iOException);
          Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
          return false;
        } 
      } catch (RuntimeException runtimeException) {
        StringBuilder stringBuilder = new StringBuilder("setParameters: ");
        stringBuilder.append(runtimeException);
        Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
        return false;
      } 
    } catch (RuntimeException runtimeException) {
      StringBuilder stringBuilder = new StringBuilder("allocate: Camera.open: ");
      stringBuilder.append(runtimeException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
      return false;
    } 
  }
  
  public void deallocate() {
    if (this.mCamera == null)
      return; 
    stopCapture();
    try {
      this.mCamera.setPreviewTexture(null);
      if (this.mGlTextures != null)
        GLES20.glDeleteTextures(1, this.mGlTextures, 0); 
      this.mCaptureFormat = null;
      this.mCamera.release();
      this.mCamera = null;
      return;
    } catch (IOException iOException) {
      StringBuilder stringBuilder = new StringBuilder("deallocate: failed to deallocate camera, ");
      stringBuilder.append(iOException);
      Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
      return;
    } 
  }
  
  public PhotoCapabilities getPhotoCapabilities() {
    // Byte code:
    //   0: aload_0
    //   1: getfield mCamera : Landroid/hardware/Camera;
    //   4: invokestatic getCameraParameters : (Landroid/hardware/Camera;)Landroid/hardware/Camera$Parameters;
    //   7: astore #11
    //   9: new org/chromium/media/PhotoCapabilities$Builder
    //   12: dup
    //   13: invokespecial <init> : ()V
    //   16: astore #10
    //   18: ldc 'VideoCapture'
    //   20: ldc_w ' CAM params: %s'
    //   23: iconst_1
    //   24: anewarray java/lang/Object
    //   27: dup
    //   28: iconst_0
    //   29: aload #11
    //   31: invokevirtual flatten : ()Ljava/lang/String;
    //   34: aastore
    //   35: invokestatic i : (Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   38: aload #10
    //   40: iconst_0
    //   41: putfield minIso : I
    //   44: aload #10
    //   46: iconst_0
    //   47: putfield maxIso : I
    //   50: aload #10
    //   52: iconst_0
    //   53: putfield currentIso : I
    //   56: aload #10
    //   58: iconst_0
    //   59: putfield stepIso : I
    //   62: aload #11
    //   64: invokevirtual getSupportedPictureSizes : ()Ljava/util/List;
    //   67: invokeinterface iterator : ()Ljava/util/Iterator;
    //   72: astore #12
    //   74: ldc 2147483647
    //   76: istore #8
    //   78: ldc 2147483647
    //   80: istore #5
    //   82: iconst_0
    //   83: istore_2
    //   84: iconst_0
    //   85: istore_3
    //   86: aload #12
    //   88: invokeinterface hasNext : ()Z
    //   93: ifeq -> 202
    //   96: aload #12
    //   98: invokeinterface next : ()Ljava/lang/Object;
    //   103: checkcast android/hardware/Camera$Size
    //   106: astore #13
    //   108: iload #8
    //   110: istore #4
    //   112: aload #13
    //   114: getfield width : I
    //   117: iload #8
    //   119: if_icmpge -> 129
    //   122: aload #13
    //   124: getfield width : I
    //   127: istore #4
    //   129: iload #5
    //   131: istore #6
    //   133: aload #13
    //   135: getfield height : I
    //   138: iload #5
    //   140: if_icmpge -> 150
    //   143: aload #13
    //   145: getfield height : I
    //   148: istore #6
    //   150: iload_3
    //   151: istore #7
    //   153: aload #13
    //   155: getfield width : I
    //   158: iload_3
    //   159: if_icmple -> 169
    //   162: aload #13
    //   164: getfield width : I
    //   167: istore #7
    //   169: iload_2
    //   170: istore_3
    //   171: aload #13
    //   173: getfield height : I
    //   176: iload_2
    //   177: if_icmple -> 186
    //   180: aload #13
    //   182: getfield height : I
    //   185: istore_3
    //   186: iload #4
    //   188: istore #8
    //   190: iload #6
    //   192: istore #5
    //   194: iload_3
    //   195: istore_2
    //   196: iload #7
    //   198: istore_3
    //   199: goto -> 86
    //   202: aload #10
    //   204: iload #5
    //   206: putfield minHeight : I
    //   209: aload #10
    //   211: iload_2
    //   212: putfield maxHeight : I
    //   215: aload #10
    //   217: iconst_1
    //   218: putfield stepHeight : I
    //   221: aload #10
    //   223: iload #8
    //   225: putfield minWidth : I
    //   228: aload #10
    //   230: iload_3
    //   231: putfield maxWidth : I
    //   234: aload #10
    //   236: iconst_1
    //   237: putfield stepWidth : I
    //   240: aload #11
    //   242: invokevirtual getPreviewSize : ()Landroid/hardware/Camera$Size;
    //   245: astore #12
    //   247: aload #10
    //   249: aload #12
    //   251: getfield height : I
    //   254: putfield currentHeight : I
    //   257: aload #10
    //   259: aload #12
    //   261: getfield width : I
    //   264: putfield currentWidth : I
    //   267: aload #11
    //   269: invokevirtual isZoomSupported : ()Z
    //   272: ifeq -> 418
    //   275: aload #11
    //   277: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   280: aload #11
    //   282: invokevirtual getMaxZoom : ()I
    //   285: invokeinterface get : (I)Ljava/lang/Object;
    //   290: checkcast java/lang/Integer
    //   293: invokevirtual intValue : ()I
    //   296: istore #7
    //   298: aload #11
    //   300: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   303: aload #11
    //   305: invokevirtual getZoom : ()I
    //   308: invokeinterface get : (I)Ljava/lang/Object;
    //   313: checkcast java/lang/Integer
    //   316: invokevirtual intValue : ()I
    //   319: istore #6
    //   321: aload #11
    //   323: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   326: iconst_0
    //   327: invokeinterface get : (I)Ljava/lang/Object;
    //   332: checkcast java/lang/Integer
    //   335: invokevirtual intValue : ()I
    //   338: istore #5
    //   340: iload #7
    //   342: istore_2
    //   343: iload #6
    //   345: istore_3
    //   346: iload #5
    //   348: istore #4
    //   350: aload #11
    //   352: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   355: invokeinterface size : ()I
    //   360: iconst_1
    //   361: if_icmple -> 425
    //   364: aload #11
    //   366: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   369: iconst_1
    //   370: invokeinterface get : (I)Ljava/lang/Object;
    //   375: checkcast java/lang/Integer
    //   378: invokevirtual intValue : ()I
    //   381: aload #11
    //   383: invokevirtual getZoomRatios : ()Ljava/util/List;
    //   386: iconst_0
    //   387: invokeinterface get : (I)Ljava/lang/Object;
    //   392: checkcast java/lang/Integer
    //   395: invokevirtual intValue : ()I
    //   398: isub
    //   399: istore #8
    //   401: iload #7
    //   403: istore_2
    //   404: iload #6
    //   406: istore_3
    //   407: iload #5
    //   409: istore #4
    //   411: iload #8
    //   413: istore #5
    //   415: goto -> 428
    //   418: iconst_0
    //   419: istore_2
    //   420: iconst_0
    //   421: istore_3
    //   422: iconst_0
    //   423: istore #4
    //   425: iconst_0
    //   426: istore #5
    //   428: aload #10
    //   430: iload #4
    //   432: i2d
    //   433: putfield minZoom : D
    //   436: aload #10
    //   438: iload_2
    //   439: i2d
    //   440: putfield maxZoom : D
    //   443: aload #10
    //   445: iload_3
    //   446: i2d
    //   447: putfield currentZoom : D
    //   450: aload #10
    //   452: iload #5
    //   454: i2d
    //   455: putfield stepZoom : D
    //   458: aload #11
    //   460: invokevirtual getSupportedFocusModes : ()Ljava/util/List;
    //   463: astore #12
    //   465: getstatic org/chromium/media/VideoCaptureCamera.$assertionsDisabled : Z
    //   468: ifne -> 490
    //   471: aload #12
    //   473: ifnull -> 479
    //   476: goto -> 490
    //   479: new java/lang/AssertionError
    //   482: dup
    //   483: ldc_w 'getSupportedFocusModes() should never return null'
    //   486: invokespecial <init> : (Ljava/lang/Object;)V
    //   489: athrow
    //   490: new java/util/ArrayList
    //   493: dup
    //   494: iconst_3
    //   495: invokespecial <init> : (I)V
    //   498: astore #13
    //   500: aload #12
    //   502: ldc_w 'continuous-video'
    //   505: invokeinterface contains : (Ljava/lang/Object;)Z
    //   510: istore #9
    //   512: iconst_4
    //   513: istore_3
    //   514: iload #9
    //   516: ifne -> 545
    //   519: aload #12
    //   521: ldc_w 'continuous-picture'
    //   524: invokeinterface contains : (Ljava/lang/Object;)Z
    //   529: ifne -> 545
    //   532: aload #12
    //   534: ldc_w 'edof'
    //   537: invokeinterface contains : (Ljava/lang/Object;)Z
    //   542: ifeq -> 555
    //   545: aload #13
    //   547: iconst_4
    //   548: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   551: invokevirtual add : (Ljava/lang/Object;)Z
    //   554: pop
    //   555: aload #12
    //   557: ldc_w 'auto'
    //   560: invokeinterface contains : (Ljava/lang/Object;)Z
    //   565: ifne -> 581
    //   568: aload #12
    //   570: ldc_w 'macro'
    //   573: invokeinterface contains : (Ljava/lang/Object;)Z
    //   578: ifeq -> 591
    //   581: aload #13
    //   583: iconst_3
    //   584: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   587: invokevirtual add : (Ljava/lang/Object;)Z
    //   590: pop
    //   591: aload #12
    //   593: ldc_w 'infinity'
    //   596: invokeinterface contains : (Ljava/lang/Object;)Z
    //   601: ifne -> 617
    //   604: aload #12
    //   606: ldc_w 'fixed'
    //   609: invokeinterface contains : (Ljava/lang/Object;)Z
    //   614: ifeq -> 627
    //   617: aload #13
    //   619: iconst_2
    //   620: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   623: invokevirtual add : (Ljava/lang/Object;)Z
    //   626: pop
    //   627: aload #10
    //   629: aload #13
    //   631: invokestatic integerArrayListToArray : (Ljava/util/ArrayList;)[I
    //   634: invokevirtual setFocusModes : ([I)Lorg/chromium/media/PhotoCapabilities$Builder;
    //   637: pop
    //   638: aload #11
    //   640: invokevirtual getFocusMode : ()Ljava/lang/String;
    //   643: astore #12
    //   645: aload #12
    //   647: ldc_w 'continuous-video'
    //   650: invokevirtual equals : (Ljava/lang/Object;)Z
    //   653: ifne -> 746
    //   656: aload #12
    //   658: ldc_w 'continuous-picture'
    //   661: invokevirtual equals : (Ljava/lang/Object;)Z
    //   664: ifne -> 746
    //   667: aload #12
    //   669: ldc_w 'edof'
    //   672: invokevirtual equals : (Ljava/lang/Object;)Z
    //   675: ifeq -> 681
    //   678: goto -> 746
    //   681: aload #12
    //   683: ldc_w 'auto'
    //   686: invokevirtual equals : (Ljava/lang/Object;)Z
    //   689: ifne -> 741
    //   692: aload #12
    //   694: ldc_w 'macro'
    //   697: invokevirtual equals : (Ljava/lang/Object;)Z
    //   700: ifeq -> 706
    //   703: goto -> 741
    //   706: aload #12
    //   708: ldc_w 'infinity'
    //   711: invokevirtual equals : (Ljava/lang/Object;)Z
    //   714: ifne -> 736
    //   717: aload #12
    //   719: ldc_w 'fixed'
    //   722: invokevirtual equals : (Ljava/lang/Object;)Z
    //   725: ifeq -> 731
    //   728: goto -> 736
    //   731: iconst_1
    //   732: istore_2
    //   733: goto -> 748
    //   736: iconst_2
    //   737: istore_2
    //   738: goto -> 748
    //   741: iconst_3
    //   742: istore_2
    //   743: goto -> 748
    //   746: iconst_4
    //   747: istore_2
    //   748: aload #10
    //   750: iload_2
    //   751: putfield focusMode : I
    //   754: new java/util/ArrayList
    //   757: dup
    //   758: iconst_2
    //   759: invokespecial <init> : (I)V
    //   762: astore #12
    //   764: aload #12
    //   766: iconst_4
    //   767: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   770: invokevirtual add : (Ljava/lang/Object;)Z
    //   773: pop
    //   774: aload #11
    //   776: invokevirtual isAutoExposureLockSupported : ()Z
    //   779: ifeq -> 792
    //   782: aload #12
    //   784: iconst_2
    //   785: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   788: invokevirtual add : (Ljava/lang/Object;)Z
    //   791: pop
    //   792: aload #10
    //   794: aload #12
    //   796: invokestatic integerArrayListToArray : (Ljava/util/ArrayList;)[I
    //   799: invokevirtual setExposureModes : ([I)Lorg/chromium/media/PhotoCapabilities$Builder;
    //   802: pop
    //   803: aload #11
    //   805: invokevirtual isAutoExposureLockSupported : ()Z
    //   808: ifeq -> 824
    //   811: aload #11
    //   813: invokevirtual getAutoExposureLock : ()Z
    //   816: ifeq -> 824
    //   819: iconst_2
    //   820: istore_2
    //   821: goto -> 826
    //   824: iconst_4
    //   825: istore_2
    //   826: aload #10
    //   828: iload_2
    //   829: putfield exposureMode : I
    //   832: aload #11
    //   834: invokevirtual getExposureCompensationStep : ()F
    //   837: fstore_1
    //   838: aload #10
    //   840: fload_1
    //   841: f2d
    //   842: putfield stepExposureCompensation : D
    //   845: aload #10
    //   847: aload #11
    //   849: invokevirtual getMinExposureCompensation : ()I
    //   852: i2f
    //   853: fload_1
    //   854: fmul
    //   855: f2d
    //   856: putfield minExposureCompensation : D
    //   859: aload #10
    //   861: aload #11
    //   863: invokevirtual getMaxExposureCompensation : ()I
    //   866: i2f
    //   867: fload_1
    //   868: fmul
    //   869: f2d
    //   870: putfield maxExposureCompensation : D
    //   873: aload #10
    //   875: aload #11
    //   877: invokevirtual getExposureCompensation : ()I
    //   880: i2f
    //   881: fload_1
    //   882: fmul
    //   883: f2d
    //   884: putfield currentExposureCompensation : D
    //   887: new java/util/ArrayList
    //   890: dup
    //   891: iconst_2
    //   892: invokespecial <init> : (I)V
    //   895: astore #12
    //   897: aload #11
    //   899: invokevirtual getSupportedWhiteBalance : ()Ljava/util/List;
    //   902: astore #13
    //   904: aload #13
    //   906: ifnull -> 947
    //   909: aload #13
    //   911: invokeinterface isEmpty : ()Z
    //   916: ifne -> 929
    //   919: aload #12
    //   921: iconst_4
    //   922: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   925: invokevirtual add : (Ljava/lang/Object;)Z
    //   928: pop
    //   929: aload #11
    //   931: invokevirtual isAutoWhiteBalanceLockSupported : ()Z
    //   934: ifeq -> 947
    //   937: aload #12
    //   939: iconst_2
    //   940: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   943: invokevirtual add : (Ljava/lang/Object;)Z
    //   946: pop
    //   947: aload #10
    //   949: aload #12
    //   951: invokestatic integerArrayListToArray : (Ljava/util/ArrayList;)[I
    //   954: invokevirtual setWhiteBalanceModes : ([I)Lorg/chromium/media/PhotoCapabilities$Builder;
    //   957: pop
    //   958: iload_3
    //   959: istore_2
    //   960: aload #11
    //   962: invokevirtual isAutoWhiteBalanceLockSupported : ()Z
    //   965: ifeq -> 980
    //   968: iload_3
    //   969: istore_2
    //   970: aload #11
    //   972: invokevirtual getAutoWhiteBalanceLock : ()Z
    //   975: ifeq -> 980
    //   978: iconst_2
    //   979: istore_2
    //   980: aload #10
    //   982: iload_2
    //   983: putfield whiteBalanceMode : I
    //   986: aload #10
    //   988: getstatic org/chromium/media/VideoCaptureCamera.COLOR_TEMPERATURES_MAP : Landroid/util/SparseArray;
    //   991: iconst_0
    //   992: invokevirtual keyAt : (I)I
    //   995: putfield minColorTemperature : I
    //   998: aload #10
    //   1000: getstatic org/chromium/media/VideoCaptureCamera.COLOR_TEMPERATURES_MAP : Landroid/util/SparseArray;
    //   1003: getstatic org/chromium/media/VideoCaptureCamera.COLOR_TEMPERATURES_MAP : Landroid/util/SparseArray;
    //   1006: invokevirtual size : ()I
    //   1009: iconst_1
    //   1010: isub
    //   1011: invokevirtual keyAt : (I)I
    //   1014: putfield maxColorTemperature : I
    //   1017: iload_2
    //   1018: iconst_2
    //   1019: if_icmpne -> 1050
    //   1022: getstatic org/chromium/media/VideoCaptureCamera.COLOR_TEMPERATURES_MAP : Landroid/util/SparseArray;
    //   1025: aload #11
    //   1027: invokevirtual getWhiteBalance : ()Ljava/lang/String;
    //   1030: invokevirtual indexOfValue : (Ljava/lang/Object;)I
    //   1033: istore_2
    //   1034: iload_2
    //   1035: iflt -> 1050
    //   1038: aload #10
    //   1040: getstatic org/chromium/media/VideoCaptureCamera.COLOR_TEMPERATURES_MAP : Landroid/util/SparseArray;
    //   1043: iload_2
    //   1044: invokevirtual keyAt : (I)I
    //   1047: putfield currentColorTemperature : I
    //   1050: aload #10
    //   1052: bipush #50
    //   1054: putfield stepColorTemperature : I
    //   1057: aload #11
    //   1059: invokevirtual getSupportedFlashModes : ()Ljava/util/List;
    //   1062: astore #12
    //   1064: aload #12
    //   1066: ifnull -> 1205
    //   1069: aload #10
    //   1071: aload #12
    //   1073: ldc_w 'torch'
    //   1076: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1081: putfield supportsTorch : Z
    //   1084: aload #10
    //   1086: ldc_w 'torch'
    //   1089: aload #11
    //   1091: invokevirtual getFlashMode : ()Ljava/lang/String;
    //   1094: invokevirtual equals : (Ljava/lang/Object;)Z
    //   1097: putfield torch : Z
    //   1100: aload #10
    //   1102: aload #12
    //   1104: ldc_w 'red-eye'
    //   1107: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1112: putfield redEyeReduction : Z
    //   1115: new java/util/ArrayList
    //   1118: dup
    //   1119: iconst_0
    //   1120: invokespecial <init> : (I)V
    //   1123: astore #11
    //   1125: aload #12
    //   1127: ldc_w 'off'
    //   1130: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1135: ifeq -> 1148
    //   1138: aload #11
    //   1140: iconst_1
    //   1141: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1144: invokevirtual add : (Ljava/lang/Object;)Z
    //   1147: pop
    //   1148: aload #12
    //   1150: ldc_w 'auto'
    //   1153: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1158: ifeq -> 1171
    //   1161: aload #11
    //   1163: iconst_2
    //   1164: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1167: invokevirtual add : (Ljava/lang/Object;)Z
    //   1170: pop
    //   1171: aload #12
    //   1173: ldc_w 'on'
    //   1176: invokeinterface contains : (Ljava/lang/Object;)Z
    //   1181: ifeq -> 1194
    //   1184: aload #11
    //   1186: iconst_3
    //   1187: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   1190: invokevirtual add : (Ljava/lang/Object;)Z
    //   1193: pop
    //   1194: aload #10
    //   1196: aload #11
    //   1198: invokestatic integerArrayListToArray : (Ljava/util/ArrayList;)[I
    //   1201: invokevirtual setFillLightModes : ([I)Lorg/chromium/media/PhotoCapabilities$Builder;
    //   1204: pop
    //   1205: aload #10
    //   1207: invokevirtual build : ()Lorg/chromium/media/PhotoCapabilities;
    //   1210: areturn
  }
  
  public void onPreviewFrame(byte[] paramArrayOfbyte, Camera paramCamera) {
    this.mPreviewBufferLock.lock();
    try {
      boolean bool = this.mIsRunning;
      if (!bool)
        return; 
      if (paramArrayOfbyte.length == this.mExpectedFrameSize)
        nativeOnFrameAvailable(this.mNativeVideoCaptureDeviceAndroid, paramArrayOfbyte, this.mExpectedFrameSize, getCameraRotation()); 
      return;
    } finally {
      this.mPreviewBufferLock.unlock();
      if (paramCamera != null)
        paramCamera.addCallbackBuffer(paramArrayOfbyte); 
    } 
  }
  
  public void setPhotoOptions(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, float[] paramArrayOffloat, boolean paramBoolean1, double paramDouble4, int paramInt3, double paramDouble5, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, boolean paramBoolean4, boolean paramBoolean5, double paramDouble6) {
    Camera.Parameters parameters = getCameraParameters(this.mCamera);
    if (parameters.isZoomSupported() && paramDouble1 > 0.0D) {
      List<Integer> list = parameters.getZoomRatios();
      int i;
      for (i = 1; i < list.size() && paramDouble1 >= ((Integer)list.get(i)).intValue(); i++);
      parameters.setZoom(i - 1);
    } 
    if (paramInt1 == 2) {
      parameters.setFocusMode("fixed");
    } else if (paramInt1 == 3) {
      parameters.setFocusMode("auto");
    } else if (paramInt1 == 4) {
      parameters.setFocusMode("continuous-picture");
    } 
    if (parameters.isAutoExposureLockSupported())
      if (paramInt2 == 2) {
        parameters.setAutoExposureLock(true);
      } else if (paramInt2 != 1) {
        parameters.setAutoExposureLock(false);
      }  
    if (paramDouble2 > 0.0D)
      this.mPhotoWidth = (int)Math.round(paramDouble2); 
    if (paramDouble3 > 0.0D)
      this.mPhotoHeight = (int)Math.round(paramDouble3); 
    if (this.mAreaOfInterest != null && !this.mAreaOfInterest.rect.isEmpty() && paramDouble1 > 0.0D)
      this.mAreaOfInterest = null; 
    if (paramInt1 == 1 || paramInt2 == 1)
      this.mAreaOfInterest = null; 
    if (parameters.getMaxNumMeteringAreas() > 0 || parameters.getMaxNumFocusAreas() > 0) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    } 
    if (paramInt2 != 0 && paramArrayOffloat.length > 0)
      if ($assertionsDisabled || paramArrayOffloat.length == 2) {
        if ($assertionsDisabled || (paramArrayOffloat[0] <= 1.0D && paramArrayOffloat[0] >= 0.0D)) {
          if ($assertionsDisabled || (paramArrayOffloat[1] <= 1.0D && paramArrayOffloat[1] >= 0.0D)) {
            paramInt2 = Math.round(paramArrayOffloat[0] * 2000.0F) - 1000;
            int i = Math.round(paramArrayOffloat[1] * 2000.0F) - 1000;
            this.mAreaOfInterest = new Camera.Area(new Rect(Math.max(-1000, paramInt2 - 125), Math.max(-1000, i - 125), Math.min(1000, paramInt2 + 125), Math.min(1000, i + 125)), 1000);
            this.mAreaOfInterest.rect.toString();
          } else {
            throw new AssertionError();
          } 
        } else {
          throw new AssertionError();
        } 
      } else {
        throw new AssertionError("Only 1 point of interest supported");
      }  
    if (this.mAreaOfInterest != null) {
      parameters.setFocusAreas(Arrays.asList(new Camera.Area[] { this.mAreaOfInterest }));
      parameters.setMeteringAreas(Arrays.asList(new Camera.Area[] { this.mAreaOfInterest }));
    } 
    if (paramBoolean1)
      parameters.setExposureCompensation((int)Math.round(paramDouble4 / parameters.getExposureCompensationStep())); 
    if (paramInt3 == 4 && parameters.getSupportedWhiteBalance() != null) {
      parameters.setWhiteBalance("auto");
    } else if (paramInt3 == 2 && parameters.isAutoWhiteBalanceLockSupported()) {
      parameters.setAutoWhiteBalanceLock(true);
    } 
    if (paramDouble6 > 0.0D) {
      String str = getClosestWhiteBalance((int)paramDouble6, parameters.getSupportedWhiteBalance());
      if (str != null)
        parameters.setWhiteBalance(str); 
    } 
    if (parameters.getSupportedFlashModes() != null)
      if (paramBoolean4 && paramBoolean5) {
        parameters.setFlashMode("torch");
      } else if (paramInt4 != 0) {
        String str;
        switch (paramInt4) {
          case 3:
            parameters.setFlashMode("on");
            break;
          case 2:
            if (paramBoolean2 && paramBoolean3) {
              str = "red-eye";
            } else {
              str = "auto";
            } 
            parameters.setFlashMode(str);
            break;
          case 1:
            parameters.setFlashMode("off");
            break;
        } 
      }  
    try {
      this.mCamera.setParameters(parameters);
      if (paramInt1 != 3)
        return; 
      this.mCamera.autoFocus(new VideoCaptureCamera$1());
      return;
    } catch (RuntimeException runtimeException) {
      Log.e("VideoCapture", "setParameters: ", new Object[] { runtimeException });
      return;
    } 
  }
  
  public boolean startCapture() {
    if (this.mCamera == null) {
      Log.e("VideoCapture", "startCapture: mCamera is null", new Object[0]);
      return false;
    } 
    this.mPreviewBufferLock.lock();
    try {
      boolean bool = this.mIsRunning;
      if (bool)
        return true; 
      this.mPreviewBufferLock.unlock();
      setPreviewCallback(this);
    } finally {
      this.mPreviewBufferLock.unlock();
    } 
  }
  
  public boolean stopCapture() {
    if (this.mCamera == null) {
      Log.e("VideoCapture", "stopCapture: mCamera is null", new Object[0]);
      return true;
    } 
    this.mPreviewBufferLock.lock();
    try {
      boolean bool = this.mIsRunning;
      if (!bool)
        return true; 
      this.mIsRunning = false;
      this.mPreviewBufferLock.unlock();
      this.mCamera.stopPreview();
      return true;
    } finally {
      this.mPreviewBufferLock.unlock();
    } 
  }
  
  public boolean takePhoto(long paramLong) {
    if (this.mCamera == null || !this.mIsRunning) {
      Log.e("VideoCapture", "takePhoto: mCamera is null or is not running", new Object[0]);
      return false;
    } 
    synchronized (this.mPhotoTakenCallbackLock) {
      if (this.mPhotoTakenCallbackId != 0L)
        return false; 
      this.mPhotoTakenCallbackId = paramLong;
      this.mPreviewParameters = getCameraParameters(this.mCamera);
      Camera.Parameters parameters = getCameraParameters(this.mCamera);
      parameters.setRotation(getCameraRotation());
      if (this.mPhotoWidth > 0 || this.mPhotoHeight > 0) {
        Iterator<Camera.Size> iterator = parameters.getSupportedPictureSizes().iterator();
        null = null;
        int i;
        for (i = Integer.MAX_VALUE; iterator.hasNext(); i = j) {
          Camera.Size size = iterator.next();
          if (this.mPhotoWidth > 0) {
            j = Math.abs(size.width - this.mPhotoWidth);
          } else {
            j = 0;
          } 
          if (this.mPhotoHeight > 0) {
            k = Math.abs(size.height - this.mPhotoHeight);
          } else {
            k = 0;
          } 
          int k = j + k;
          int j = i;
          if (k < i) {
            null = size;
            j = k;
          } 
        } 
        if (i != Integer.MAX_VALUE) {
          i = this.mPhotoWidth;
          i = this.mPhotoHeight;
          i = ((Camera.Size)null).width;
          i = ((Camera.Size)null).height;
          parameters.setPictureSize(((Camera.Size)null).width, ((Camera.Size)null).height);
        } 
      } 
      try {
        parameters.flatten();
        this.mCamera.setParameters(parameters);
        this.mCamera.takePicture(null, null, null, new VideoCaptureCamera$CrPictureCallback(this, (byte)0));
        return true;
      } catch (RuntimeException null) {
        StringBuilder stringBuilder = new StringBuilder("setParameters ");
        stringBuilder.append(null);
        Log.e("VideoCapture", stringBuilder.toString(), new Object[0]);
        return false;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */