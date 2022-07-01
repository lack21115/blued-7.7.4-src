package com.baidu.aip.face;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.util.Pools;
import com.baidu.aip.ImageFrame;
import com.baidu.idl.facesdk.FaceInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.UUID;

public class FaceFilter {
  private int angle = 15;
  
  private HashSet<TrackedModel> currentFrame = new HashSet<TrackedModel>();
  
  private ArrayList<Integer> leftFaces = new ArrayList<Integer>();
  
  private OnTrackListener onTrackListener;
  
  private Pools.SynchronizedPool<TrackedModel> pool = new Pools.SynchronizedPool(5);
  
  private SparseArray<TrackedModel> trackingFaces = new SparseArray();
  
  private TrackedModel getTrackedModel(FaceInfo paramFaceInfo, ImageFrame paramImageFrame) {
    TrackedModel trackedModel2 = (TrackedModel)this.trackingFaces.get(paramFaceInfo.face_id);
    TrackedModel trackedModel1 = trackedModel2;
    if (trackedModel2 == null) {
      trackedModel2 = (TrackedModel)this.pool.acquire();
      trackedModel1 = trackedModel2;
      if (trackedModel2 == null)
        trackedModel1 = new TrackedModel(); 
      this.trackingFaces.append(paramFaceInfo.face_id, trackedModel1);
      trackedModel1.setTrackId(UUID.randomUUID().toString());
      trackedModel1.setEvent(Event.OnEnter);
    } 
    trackedModel1.setInfo(paramFaceInfo);
    trackedModel1.setFrame(paramImageFrame);
    return trackedModel1;
  }
  
  public void filter(FaceInfo[] paramArrayOfFaceInfo, ImageFrame paramImageFrame) {
    this.currentFrame.clear();
    int j = 0;
    if (paramArrayOfFaceInfo != null) {
      int m = paramArrayOfFaceInfo.length;
      for (int k = 0; k < m; k++) {
        FaceInfo faceInfo = paramArrayOfFaceInfo[k];
        TrackedModel trackedModel = getTrackedModel(faceInfo, paramImageFrame);
        this.currentFrame.add(trackedModel);
        trackedModel.setInfo(faceInfo);
      } 
    } 
    this.leftFaces.clear();
    for (int i = j; i < this.trackingFaces.size(); i++) {
      j = this.trackingFaces.keyAt(i);
      TrackedModel trackedModel = (TrackedModel)this.trackingFaces.get(j);
      if (!this.currentFrame.contains(trackedModel)) {
        this.leftFaces.add(Integer.valueOf(j));
      } else if (this.onTrackListener != null) {
        trackedModel.setFrame(paramImageFrame);
        this.onTrackListener.onTrack(trackedModel);
      } 
    } 
    for (Integer integer : this.leftFaces) {
      TrackedModel trackedModel = (TrackedModel)this.trackingFaces.get(integer.intValue());
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(" left:");
      stringBuilder.append(trackedModel);
      Log.e("xx", stringBuilder.toString());
      trackedModel.setEvent(Event.OnLeave);
      this.trackingFaces.remove(integer.intValue());
      OnTrackListener onTrackListener = this.onTrackListener;
      if (onTrackListener != null)
        onTrackListener.onTrack(trackedModel); 
    } 
  }
  
  public void setAngle(int paramInt) {
    this.angle = paramInt;
  }
  
  public void setOnTrackListener(OnTrackListener paramOnTrackListener) {
    this.onTrackListener = paramOnTrackListener;
  }
  
  public enum Event {
    OnEnter, OnLeave, OnUpdate;
    
    static {
      $VALUES = new Event[] { OnEnter, OnUpdate, OnLeave };
    }
  }
  
  public static interface OnTrackListener {
    void onTrack(FaceFilter.TrackedModel param1TrackedModel);
  }
  
  public class TrackedModel {
    private FaceFilter.Event event;
    
    private ImageFrame frame;
    
    private FaceInfo info;
    
    int[] points = new int[8];
    
    private String trackId;
    
    public Bitmap cropFace() {
      return cropFace(getFaceRect());
    }
    
    public Bitmap cropFace(Rect param1Rect) {
      return FaceCropper.getFace(getFrame().getArgb(), this.info, getImageFrame().getWidth());
    }
    
    public FaceFilter.Event getEvent() {
      return this.event;
    }
    
    public Rect getFaceRect() {
      Rect rect = new Rect();
      getInfo().getRectPoints(this.points);
      int[] arrayOfInt = this.points;
      int k = arrayOfInt[2];
      int i = arrayOfInt[3];
      int m = arrayOfInt[6];
      int j = arrayOfInt[7];
      int i1 = (m - k) * 8 / 3;
      int n = (j - i) * 10 / 3;
      k = (getInfo()).mCenter_x - i1 / 2;
      j = (getInfo()).mCenter_y - n * 2 / 3;
      m = 0;
      if (j < 0) {
        i = 0;
      } else {
        i = j;
      } 
      rect.top = i;
      if (k < 0) {
        i = m;
      } else {
        i = k;
      } 
      rect.left = i;
      k += i1;
      i = k;
      if (k > this.frame.getWidth())
        i = this.frame.getWidth(); 
      rect.right = i;
      j += n;
      i = j;
      if (j > this.frame.getHeight())
        i = this.frame.getHeight(); 
      rect.bottom = i;
      return rect;
    }
    
    public ImageFrame getFrame() {
      return this.frame;
    }
    
    public ImageFrame getImageFrame() {
      return getFrame();
    }
    
    public FaceInfo getInfo() {
      return this.info;
    }
    
    public String getTrackId() {
      return this.trackId;
    }
    
    public int hashCode() {
      return (getInfo()).face_id;
    }
    
    public boolean meetCriteria() {
      float[] arrayOfFloat = (getInfo()).headPose;
      boolean bool2 = false;
      float f1 = Math.abs(arrayOfFloat[0]);
      float f2 = Math.abs((getInfo()).headPose[1]);
      float f3 = Math.abs((getInfo()).headPose[2]);
      boolean bool1 = bool2;
      if (f1 < FaceFilter.this.angle) {
        bool1 = bool2;
        if (f2 < FaceFilter.this.angle) {
          bool1 = bool2;
          if (f3 < FaceFilter.this.angle)
            bool1 = true; 
        } 
      } 
      return bool1;
    }
    
    public void setEvent(FaceFilter.Event param1Event) {
      this.event = param1Event;
    }
    
    public void setFrame(ImageFrame param1ImageFrame) {
      this.frame = param1ImageFrame;
    }
    
    public void setInfo(FaceInfo param1FaceInfo) {
      this.info = param1FaceInfo;
    }
    
    public void setTrackId(String param1String) {
      this.trackId = param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\baidu\aip\face\FaceFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */