package org.chromium.shape_detection;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.media.FaceDetector;
import org.chromium.gfx.mojom.RectF;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectionResult;

final class FaceDetectionImpl$1 implements Runnable {
  public final void run() {
    FaceDetector faceDetector = new FaceDetector(width, height, FaceDetectionImpl.access$000(FaceDetectionImpl.this));
    FaceDetector.Face[] arrayOfFace = new FaceDetector.Face[FaceDetectionImpl.access$000(FaceDetectionImpl.this)];
    int j = faceDetector.findFaces(unPremultipliedBitmap, arrayOfFace);
    FaceDetectionResult[] arrayOfFaceDetectionResult = new FaceDetectionResult[j];
    for (int i = 0; i < j; i++) {
      arrayOfFaceDetectionResult[i] = new FaceDetectionResult((byte)0);
      FaceDetector.Face face = arrayOfFace[i];
      PointF pointF = new PointF();
      face.getMidPoint(pointF);
      float f = face.eyesDistance();
      (arrayOfFaceDetectionResult[i]).boundingBox = new RectF((byte)0);
      (arrayOfFaceDetectionResult[i]).boundingBox.x = pointF.x - f;
      (arrayOfFaceDetectionResult[i]).boundingBox.y = pointF.y - f;
      RectF rectF = (arrayOfFaceDetectionResult[i]).boundingBox;
      f *= 2.0F;
      rectF.width = f;
      (arrayOfFaceDetectionResult[i]).boundingBox.height = f;
      (arrayOfFaceDetectionResult[i]).landmarks = new org.chromium.shape_detection.mojom.Landmark[0];
    } 
    callback.call(arrayOfFaceDetectionResult);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\FaceDetectionImpl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */