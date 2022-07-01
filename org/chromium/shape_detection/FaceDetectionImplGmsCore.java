package org.chromium.shape_detection;

import android.graphics.PointF;
import android.util.SparseArray;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.face.internal.client.zza;
import com.google.android.gms.vision.face.internal.client.zzc;
import java.util.ArrayList;
import java.util.List;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectionResult;
import org.chromium.shape_detection.mojom.FaceDetectorOptions;
import org.chromium.shape_detection.mojom.Landmark;
import org.chromium.skia.mojom.Bitmap;

public class FaceDetectionImplGmsCore implements FaceDetection {
  private final FaceDetector mFaceDetector;
  
  private final boolean mFastMode;
  
  private final int mMaxFaces;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  FaceDetectionImplGmsCore(FaceDetectorOptions paramFaceDetectorOptions) {
    FaceDetector.Builder builder = new FaceDetector.Builder(ContextUtils.sApplicationContext);
    this.mMaxFaces = Math.min(paramFaceDetectorOptions.maxDetectedFaces, 32);
    this.mFastMode = paramFaceDetectorOptions.fastMode;
    try {
      builder.zzgpd = this.mFastMode ^ true;
      builder.zzlhc = 1;
      if (this.mMaxFaces == 1)
        builder.zzlhd = true; 
    } catch (IllegalArgumentException illegalArgumentException) {
      StringBuilder stringBuilder = new StringBuilder("Unexpected exception ");
      stringBuilder.append(illegalArgumentException);
      Log.e("FaceDetectionImpl", stringBuilder.toString(), new Object[0]);
      assert false;
    } 
    zzc zzc = new zzc();
    zzc.mode = builder.zzgpd;
    zzc.zzlhp = builder.zzlhc;
    zzc.zzlhq = builder.zzlhe;
    zzc.zzlhr = builder.zzlhd;
    zzc.zzlhs = builder.zzlhf;
    zzc.zzlht = builder.zzlhg;
    this.mFaceDetector = new FaceDetector(new zza(builder.mContext, zzc), (byte)0);
  }
  
  public void close() {
    this.mFaceDetector.release();
  }
  
  public final void detect(Bitmap paramBitmap, FaceDetection.DetectResponse paramDetectResponse) {
    if (!this.mFaceDetector.zzlhb.isOperational()) {
      Log.e("FaceDetectionImpl", "FaceDetector is not operational", new Object[0]);
      FaceDetectorOptions faceDetectorOptions = new FaceDetectorOptions((byte)0);
      faceDetectorOptions.fastMode = this.mFastMode;
      faceDetectorOptions.maxDetectedFaces = this.mMaxFaces;
      (new FaceDetectionImpl(faceDetectorOptions)).detect(paramBitmap, paramDetectResponse);
      return;
    } 
    Frame frame = BitmapUtils.convertToFrame(paramBitmap);
    if (frame == null) {
      Log.e("FaceDetectionImpl", "Error converting Mojom Bitmap to Frame", new Object[0]);
      paramDetectResponse.call(new FaceDetectionResult[0]);
      return;
    } 
    SparseArray sparseArray = this.mFaceDetector.detect(frame);
    FaceDetectionResult[] arrayOfFaceDetectionResult = new FaceDetectionResult[sparseArray.size()];
    int i;
    for (i = 0; i < sparseArray.size(); i++) {
      RectF rectF;
      arrayOfFaceDetectionResult[i] = new FaceDetectionResult((byte)0);
      Face face = (Face)sparseArray.valueAt(i);
      List<Landmark> list = face.zzlgw;
      ArrayList<Landmark> arrayList = new ArrayList(list.size());
      int j = 0;
      int n = -1;
      int m = -1;
      int k = -1;
      while (j < list.size()) {
        Landmark landmark = list.get(j);
        int i1 = landmark.zzenu;
        if (i1 == 4 || i1 == 10 || i1 == 0 || i1 == 6) {
          Landmark landmark1 = new Landmark((byte)0);
          landmark1.locations = new PointF[1];
          landmark1.locations[0] = new PointF((byte)0);
          (landmark1.locations[0]).x = landmark.zzlgr.x;
          (landmark1.locations[0]).y = landmark.zzlgr.y;
          if (i1 == 4) {
            landmark1.type = 1;
            n = j;
          } else if (i1 == 10) {
            landmark1.type = 1;
            m = j;
          } else if (i1 == 0) {
            landmark1.type = 0;
            k = j;
          } else if ($assertionsDisabled || i1 == 6) {
            landmark1.type = 2;
          } else {
            throw new AssertionError();
          } 
          arrayList.add(landmark1);
        } 
        j++;
      } 
      (arrayOfFaceDetectionResult[i]).landmarks = arrayList.<Landmark>toArray(new Landmark[arrayList.size()]);
      PointF pointF = new PointF(face.zzlgr.x - face.zzlgs / 2.0F, face.zzlgr.y - face.zzlgt / 2.0F);
      (arrayOfFaceDetectionResult[i]).boundingBox = new RectF((byte)0);
      if (n != -1 && m != -1 && Math.abs(face.zzlgv) < 15.0F) {
        float f1;
        PointF pointF3 = ((Landmark)list.get(n)).zzlgr;
        PointF pointF2 = ((Landmark)list.get(m)).zzlgr;
        float f3 = pointF3.x - pointF2.x;
        if (k != -1) {
          f1 = ((Landmark)list.get(k)).zzlgr.y - pointF3.y;
        } else {
          f1 = -1.0F;
        } 
        PointF pointF1 = new PointF(pointF.x + face.zzlgs / 2.0F, pointF3.y);
        (arrayOfFaceDetectionResult[i]).boundingBox.x = pointF2.x * 2.0F - pointF1.x;
        (arrayOfFaceDetectionResult[i]).boundingBox.y = pointF1.y - f3;
        rectF = (arrayOfFaceDetectionResult[i]).boundingBox;
        float f2 = 2.0F * f3;
        rectF.width = f2;
        rectF = (arrayOfFaceDetectionResult[i]).boundingBox;
        if (f1 > f3)
          f2 = f1 + f3; 
        rectF.height = f2;
      } else {
        (arrayOfFaceDetectionResult[i]).boundingBox.x = pointF.x;
        (arrayOfFaceDetectionResult[i]).boundingBox.y = pointF.y;
        (arrayOfFaceDetectionResult[i]).boundingBox.width = ((Face)rectF).zzlgs;
        (arrayOfFaceDetectionResult[i]).boundingBox.height = ((Face)rectF).zzlgt;
      } 
    } 
    paramDetectResponse.call(arrayOfFaceDetectionResult);
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\FaceDetectionImplGmsCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */