package org.chromium.media;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Range;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import java.util.ArrayList;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

@TargetApi(23)
public class VideoCaptureCamera2 extends VideoCapture {
  private static final SparseIntArray COLOR_TEMPERATURES_MAP;
  
  private Range mAeFpsRange;
  
  private MeteringRectangle mAreaOfInterest;
  
  private CameraDevice mCameraDevice;
  
  private VideoCaptureCamera2$CameraState mCameraState = VideoCaptureCamera2$CameraState.STOPPED;
  
  private final Object mCameraStateLock = new Object();
  
  private int mColorTemperature = -1;
  
  private Rect mCropRect = new Rect();
  
  private int mExposureCompensation;
  
  private int mExposureMode = 4;
  
  private int mFillLightMode = 1;
  
  private int mFocusMode = 4;
  
  private ImageReader mImageReader = null;
  
  private int mIso;
  
  private long mLastExposureTimeNs;
  
  private final Looper mLooper = Looper.myLooper();
  
  private Handler mMainHandler;
  
  private float mMaxZoom = 1.0F;
  
  private int mPhotoHeight;
  
  private int mPhotoWidth;
  
  private CaptureRequest mPreviewRequest;
  
  private CaptureRequest.Builder mPreviewRequestBuilder;
  
  private CameraCaptureSession mPreviewSession;
  
  private final Runnable mReconfigureCaptureTask = new VideoCaptureCamera2$1(this);
  
  private boolean mRedEyeReduction;
  
  private boolean mTorch;
  
  private int mWhiteBalanceMode = 4;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  VideoCaptureCamera2(int paramInt, long paramLong) {
    super(paramInt, paramLong);
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    if (cameraCharacteristics != null)
      this.mMaxZoom = ((Float)cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue(); 
  }
  
  private void changeCameraStateAndNotify(VideoCaptureCamera2$CameraState paramVideoCaptureCamera2$CameraState) {
    synchronized (this.mCameraStateLock) {
      this.mCameraState = paramVideoCaptureCamera2$CameraState;
      this.mCameraStateLock.notifyAll();
      return;
    } 
  }
  
  private void configureCommonCaptureSettings(CaptureRequest.Builder paramBuilder) {
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(this.mId);
    if (this.mFocusMode == 4) {
      paramBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(4));
      paramBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
    } else if (this.mFocusMode == 2) {
      paramBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(0));
      paramBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, Integer.valueOf(0));
    } 
    if (this.mExposureMode == 1 || this.mExposureMode == 2) {
      paramBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(0));
      if (this.mLastExposureTimeNs != 0L) {
        paramBuilder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(this.mLastExposureTimeNs));
      } else {
        Range range = (Range)cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_EXPOSURE_TIME_RANGE);
        paramBuilder.set(CaptureRequest.SENSOR_EXPOSURE_TIME, Long.valueOf(((Long)range.getLower()).longValue() + (((Long)range.getUpper()).longValue() + ((Long)range.getLower()).longValue()) / 2L));
      } 
    } else {
      paramBuilder.set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
      paramBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
      paramBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, this.mAeFpsRange);
    } 
    if (this.mTorch) {
      boolean bool;
      CaptureRequest.Key key = CaptureRequest.CONTROL_AE_MODE;
      if (this.mExposureMode == 4) {
        bool = true;
      } else {
        bool = false;
      } 
      paramBuilder.set(key, Integer.valueOf(bool));
      paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(2));
    } else {
      byte b;
      CaptureRequest.Key key;
      switch (this.mFillLightMode) {
        case 3:
          paramBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(3));
          paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(1));
          break;
        case 2:
          key = CaptureRequest.CONTROL_AE_MODE;
          if (this.mRedEyeReduction) {
            b = 4;
          } else {
            b = 2;
          } 
          paramBuilder.set(key, Integer.valueOf(b));
          break;
        case 1:
          paramBuilder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(0));
          break;
      } 
      paramBuilder.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
    } 
    paramBuilder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(this.mExposureCompensation));
    if (this.mWhiteBalanceMode == 4) {
      paramBuilder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(false));
      paramBuilder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(1));
    } else if (this.mWhiteBalanceMode == 1) {
      paramBuilder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(false));
      paramBuilder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(0));
    } else if (this.mWhiteBalanceMode == 2) {
      paramBuilder.set(CaptureRequest.CONTROL_AWB_LOCK, Boolean.valueOf(true));
    } 
    if (this.mColorTemperature > 0) {
      int n = this.mColorTemperature;
      int[] arrayOfInt = (int[])cameraCharacteristics.get(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
      int j = 0;
      int k = -1;
      int m;
      for (m = Integer.MAX_VALUE; j < COLOR_TEMPERATURES_MAP.size(); m = i1) {
        int i3;
        int i2 = COLOR_TEMPERATURES_MAP.valueAt(j);
        int i1 = 0;
        while (true) {
          if (i1 < arrayOfInt.length) {
            if (i2 == arrayOfInt[i1]) {
              int i4 = i1;
              break;
            } 
            i1++;
            continue;
          } 
          i3 = -1;
          break;
        } 
        i2 = k;
        i1 = m;
        if (i3 != -1) {
          i3 = Math.abs(n - COLOR_TEMPERATURES_MAP.keyAt(j));
          i2 = k;
          i1 = m;
          if (i3 < m) {
            i2 = COLOR_TEMPERATURES_MAP.valueAt(j);
            i1 = i3;
          } 
        } 
        j++;
        k = i2;
      } 
      int i = this.mColorTemperature;
      if (k != -1)
        paramBuilder.set(CaptureRequest.CONTROL_AWB_MODE, Integer.valueOf(k)); 
    } 
    if (this.mAreaOfInterest != null) {
      MeteringRectangle[] arrayOfMeteringRectangle = new MeteringRectangle[1];
      arrayOfMeteringRectangle[0] = this.mAreaOfInterest;
      this.mAreaOfInterest.toString();
      paramBuilder.set(CaptureRequest.CONTROL_AF_REGIONS, arrayOfMeteringRectangle);
      paramBuilder.set(CaptureRequest.CONTROL_AE_REGIONS, arrayOfMeteringRectangle);
      paramBuilder.set(CaptureRequest.CONTROL_AWB_REGIONS, arrayOfMeteringRectangle);
    } 
    if (!this.mCropRect.isEmpty())
      paramBuilder.set(CaptureRequest.SCALER_CROP_REGION, this.mCropRect); 
    if (this.mIso > 0)
      paramBuilder.set(CaptureRequest.SENSOR_SENSITIVITY, Integer.valueOf(this.mIso)); 
  }
  
  private boolean createPreviewObjectsAndStartPreview() {
    if (this.mCameraDevice == null)
      return false; 
    this.mImageReader = ImageReader.newInstance(this.mCaptureFormat.mWidth, this.mCaptureFormat.mHeight, this.mCaptureFormat.mPixelFormat, 2);
    HandlerThread handlerThread = new HandlerThread("CameraPreview");
    handlerThread.start();
    Handler handler = new Handler(handlerThread.getLooper());
    VideoCaptureCamera2$CrPreviewReaderListener videoCaptureCamera2$CrPreviewReaderListener = new VideoCaptureCamera2$CrPreviewReaderListener(this, (byte)0);
    this.mImageReader.setOnImageAvailableListener(videoCaptureCamera2$CrPreviewReaderListener, handler);
    try {
      this.mPreviewRequestBuilder = this.mCameraDevice.createCaptureRequest(1);
      if (this.mPreviewRequestBuilder == null) {
        Log.e("VideoCapture", "mPreviewRequestBuilder error", new Object[0]);
        return false;
      } 
      this.mPreviewRequestBuilder.addTarget(this.mImageReader.getSurface());
      this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_MODE, Integer.valueOf(1));
      this.mPreviewRequestBuilder.set(CaptureRequest.NOISE_REDUCTION_MODE, Integer.valueOf(1));
      this.mPreviewRequestBuilder.set(CaptureRequest.EDGE_MODE, Integer.valueOf(1));
      int[] arrayOfInt = (int[])getCameraCharacteristics(this.mId).get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
      int j = arrayOfInt.length;
      for (int i = 0; i < j; i++) {
        if (arrayOfInt[i] == 1) {
          this.mPreviewRequestBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(1));
          break;
        } 
      } 
      configureCommonCaptureSettings(this.mPreviewRequestBuilder);
      ArrayList<Surface> arrayList = new ArrayList(1);
      arrayList.add(this.mImageReader.getSurface());
      this.mPreviewRequest = this.mPreviewRequestBuilder.build();
      try {
        this.mCameraDevice.createCaptureSession(arrayList, new VideoCaptureCamera2$CrPreviewSessionListener(this, this.mPreviewRequest), null);
        return true;
      } catch (CameraAccessException|IllegalArgumentException|SecurityException cameraAccessException) {
        Log.e("VideoCapture", "createCaptureSession: ", new Object[] { cameraAccessException });
        return false;
      } 
    } catch (CameraAccessException|IllegalArgumentException|SecurityException cameraAccessException) {
      Log.e("VideoCapture", "createCaptureRequest: ", new Object[] { cameraAccessException });
      return false;
    } 
  }
  
  private static Size findClosestSizeInArray(Size[] paramArrayOfSize, int paramInt1, int paramInt2) {
    if (paramArrayOfSize == null)
      return null; 
    int k = paramArrayOfSize.length;
    Size size = null;
    int i = 0;
    int j;
    for (j = Integer.MAX_VALUE; i < k; j = m) {
      Size size1 = paramArrayOfSize[i];
      if (paramInt1 > 0) {
        m = Math.abs(size1.getWidth() - paramInt1);
      } else {
        m = 0;
      } 
      if (paramInt2 > 0) {
        n = Math.abs(size1.getHeight() - paramInt2);
      } else {
        n = 0;
      } 
      int n = m + n;
      int m = j;
      if (n < j) {
        size = size1;
        m = n;
      } 
      i++;
    } 
    if (j == Integer.MAX_VALUE) {
      Log.e("VideoCapture", "Couldn't find resolution close to (%dx%d)", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return null;
    } 
    return size;
  }
  
  private static CameraCharacteristics getCameraCharacteristics(int paramInt) {
    CameraManager cameraManager = (CameraManager)ContextUtils.sApplicationContext.getSystemService("camera");
    try {
      return cameraManager.getCameraCharacteristics(Integer.toString(paramInt));
    } catch (CameraAccessException|IllegalArgumentException cameraAccessException) {
      Log.e("VideoCapture", "getCameraCharacteristics: ", new Object[] { cameraAccessException });
      return null;
    } 
  }
  
  static int getCaptureApiType(int paramInt) {
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    if (cameraCharacteristics == null)
      return 11; 
    switch (((Integer)cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue()) {
      default:
        return 7;
      case 2:
        return 7;
      case 1:
        return 8;
      case 0:
        break;
    } 
    return 9;
  }
  
  static VideoCaptureFormat[] getDeviceSupportedFormats(int paramInt) {
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    if (cameraCharacteristics == null)
      return null; 
    int[] arrayOfInt = (int[])cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
    int i = arrayOfInt.length;
    paramInt = 0;
    while (true) {
      boolean bool = true;
      if (paramInt < i) {
        if (arrayOfInt[paramInt] == 1) {
          paramInt = bool;
          break;
        } 
        paramInt++;
        continue;
      } 
      paramInt = 0;
      break;
    } 
    ArrayList<VideoCaptureFormat> arrayList = new ArrayList();
    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap)cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    for (int j : streamConfigurationMap.getOutputFormats()) {
      Size[] arrayOfSize = streamConfigurationMap.getOutputSizes(j);
      if (arrayOfSize != null) {
        int k = arrayOfSize.length;
        for (i = 0; i < k; i++) {
          Size size = arrayOfSize[i];
          double d = 0.0D;
          if (paramInt != 0) {
            long l = streamConfigurationMap.getOutputMinFrameDuration(j, size);
            if (l != 0L)
              d = 1.0E9D / l; 
          } 
          arrayList.add(new VideoCaptureFormat(size.getWidth(), size.getHeight(), (int)d, j));
        } 
      } 
    } 
    return arrayList.<VideoCaptureFormat>toArray(new VideoCaptureFormat[arrayList.size()]);
  }
  
  static int getFacingMode(int paramInt) {
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    if (cameraCharacteristics == null)
      return 0; 
    switch (((Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue()) {
      default:
        return 0;
      case 1:
        return 2;
      case 0:
        break;
    } 
    return 1;
  }
  
  static String getName(int paramInt) {
    String str;
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    if (cameraCharacteristics == null)
      return null; 
    int i = ((Integer)cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
    StringBuilder stringBuilder = new StringBuilder("camera2 ");
    stringBuilder.append(paramInt);
    stringBuilder.append(", facing ");
    if (i == 0) {
      str = "front";
    } else {
      str = "back";
    } 
    stringBuilder.append(str);
    return stringBuilder.toString();
  }
  
  static int getNumberOfCameras() {
    try {
      CameraManager cameraManager = (CameraManager)ContextUtils.sApplicationContext.getSystemService("camera");
      if (cameraManager == null)
        return 0; 
      try {
        return (cameraManager.getCameraIdList()).length;
      } catch (CameraAccessException|SecurityException|AssertionError cameraAccessException) {
        Log.e("VideoCapture", "getNumberOfCameras: getCameraIdList(): ", new Object[] { cameraAccessException });
        return 0;
      } 
    } catch (IllegalArgumentException illegalArgumentException) {
      Log.e("VideoCapture", "getSystemService(Context.CAMERA_SERVICE): ", new Object[] { illegalArgumentException });
      return 0;
    } 
  }
  
  static boolean isLegacyDevice(int paramInt) {
    CameraCharacteristics cameraCharacteristics = getCameraCharacteristics(paramInt);
    return (cameraCharacteristics != null && ((Integer)cameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue() == 2);
  }
  
  public boolean allocate(int paramInt1, int paramInt2, int paramInt3) {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
  
  public void deallocate() {}
  
  public PhotoCapabilities getPhotoCapabilities() {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
  
  public void setPhotoOptions(double paramDouble1, int paramInt1, int paramInt2, double paramDouble2, double paramDouble3, float[] paramArrayOffloat, boolean paramBoolean1, double paramDouble4, int paramInt3, double paramDouble5, boolean paramBoolean2, boolean paramBoolean3, int paramInt4, boolean paramBoolean4, boolean paramBoolean5, double paramDouble6) {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
  
  public boolean startCapture() {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
  
  public boolean stopCapture() {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
  
  public boolean takePhoto(long paramLong) {
    assert false;
    throw new AssertionError("called on wrong thread");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\media\VideoCaptureCamera2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */