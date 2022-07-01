package com.baidu.aip.face;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import com.baidu.aip.FaceSDKManager;
import com.baidu.aip.ImageFrame;
import com.baidu.aip.face.stat.Ast;
import com.baidu.idl.facesdk.FaceInfo;
import com.baidu.idl.facesdk.FaceSDK;
import com.baidu.idl.facesdk.FaceTracker;
import java.util.ArrayList;
import java.util.Iterator;

public class FaceDetectManager {
  private byte[] data;
  
  private FaceFilter faceFilter = new FaceFilter();
  
  private ImageSource imageSource;
  
  private ImageFrame lastFrame;
  
  private OnFaceDetectListener listener;
  
  private Context mContext;
  
  private int mDetectMax = 3;
  
  private int mPreviewDegree = 90;
  
  private OnFrameAvailableListener onFrameAvailableListener = new OnFrameAvailableListener() {
      public void onFrameAvailable(ImageFrame param1ImageFrame) {
        FaceDetectManager.access$002(FaceDetectManager.this, param1ImageFrame);
        FaceDetectManager.this.processHandler.removeCallbacks(FaceDetectManager.this.processRunnable);
        FaceDetectManager.this.processHandler.post(FaceDetectManager.this.processRunnable);
      }
    };
  
  private ArrayList<FaceProcessor> preProcessors = new ArrayList<FaceProcessor>();
  
  private Handler processHandler;
  
  private Runnable processRunnable = new Runnable() {
      public void run() {
        if (FaceDetectManager.this.lastFrame == null)
          return; 
        Process.setThreadPriority(-19);
        synchronized (FaceDetectManager.this.lastFrame) {
          int[] arrayOfInt = FaceDetectManager.this.lastFrame.getArgb();
          int i = FaceDetectManager.this.lastFrame.getWidth();
          int j = FaceDetectManager.this.lastFrame.getHeight();
          ArgbPool argbPool = FaceDetectManager.this.lastFrame.getPool();
          FaceDetectManager.access$002(FaceDetectManager.this, null);
          FaceDetectManager.this.process(arrayOfInt, i, j, argbPool);
          return;
        } 
      }
    };
  
  private HandlerThread processThread;
  
  private Handler uiHandler;
  
  public FaceDetectManager(Context paramContext) {
    this.mContext = paramContext;
    Ast.getInstance().init(paramContext.getApplicationContext(), "3.3.0.0", "facedetect");
  }
  
  private void process(int[] paramArrayOfint, int paramInt1, int paramInt2, ArgbPool paramArgbPool) {
    ImageFrame imageFrame = this.imageSource.borrowImageFrame();
    imageFrame.setArgb(paramArrayOfint);
    imageFrame.setWidth(paramInt1);
    imageFrame.setHeight(paramInt2);
    imageFrame.setPool(paramArgbPool);
    Iterator<FaceProcessor> iterator = this.preProcessors.iterator();
    do {
    
    } while (iterator.hasNext() && !((FaceProcessor)iterator.next()).process(this, imageFrame));
    paramInt1 = FaceSDKManager.getInstance().getFaceTracker(this.mContext).prepare_max_face_data_for_verify(imageFrame.getArgb(), imageFrame.getHeight(), imageFrame.getWidth(), FaceSDK.ImgType.ARGB.ordinal(), FaceTracker.ActionType.RECOGNIZE.ordinal());
    FaceSDKManager.getInstance().getFaceTracker(this.mContext).track(imageFrame.getArgb(), imageFrame.getHeight(), imageFrame.getWidth(), FaceSDK.ImgType.ARGB.ordinal(), this.mDetectMax);
    FaceInfo[] arrayOfFaceInfo = FaceSDKManager.getInstance().getFaceTracker(this.mContext).get_TrackedFaceInfo();
    if (paramInt1 == 0)
      this.faceFilter.filter(arrayOfFaceInfo, imageFrame); 
    OnFaceDetectListener onFaceDetectListener = this.listener;
    if (onFaceDetectListener != null)
      onFaceDetectListener.onDetectFace(paramInt1, arrayOfFaceInfo, imageFrame); 
    Ast.getInstance().faceHit("detect", 3600000, arrayOfFaceInfo);
    imageFrame.release();
  }
  
  public void addPreProcessor(FaceProcessor paramFaceProcessor) {
    this.preProcessors.add(paramFaceProcessor);
  }
  
  public FaceFilter getFaceFilter() {
    return this.faceFilter;
  }
  
  public ImageSource getImageSource() {
    return this.imageSource;
  }
  
  public void setDetectMax(int paramInt) {
    this.mDetectMax = paramInt;
  }
  
  public void setImageSource(ImageSource paramImageSource) {
    this.imageSource = paramImageSource;
  }
  
  public void setOnFaceDetectListener(OnFaceDetectListener paramOnFaceDetectListener) {
    this.listener = paramOnFaceDetectListener;
  }
  
  public void setOnTrackListener(FaceFilter.OnTrackListener paramOnTrackListener) {
    this.faceFilter.setOnTrackListener(paramOnTrackListener);
  }
  
  public void setPreviewDegree(int paramInt) {
    this.mPreviewDegree = paramInt;
  }
  
  public void start() {
    this.imageSource.addOnFrameAvailableListener(this.onFrameAvailableListener);
    this.processThread = new HandlerThread("process");
    this.processThread.setPriority(10);
    this.processThread.start();
    this.processHandler = new Handler(this.processThread.getLooper());
    this.uiHandler = new Handler();
    this.imageSource.start();
  }
  
  public void stop() {
    ImageSource imageSource = this.imageSource;
    if (imageSource != null) {
      imageSource.stop();
      this.imageSource.removeOnFrameAvailableListener(this.onFrameAvailableListener);
    } 
    HandlerThread handlerThread = this.processThread;
    if (handlerThread != null) {
      handlerThread.quit();
      this.processThread = null;
    } 
    Ast.getInstance().immediatelyUpload();
  }
  
  public static interface OnFaceDetectListener {
    void onDetectFace(int param1Int, FaceInfo[] param1ArrayOfFaceInfo, ImageFrame param1ImageFrame);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\FaceDetectManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */