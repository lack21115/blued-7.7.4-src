package org.chromium.shape_detection;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import org.chromium.base.AsyncTask;
import org.chromium.base.Log;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.FaceDetection;
import org.chromium.shape_detection.mojom.FaceDetectorOptions;
import org.chromium.skia.mojom.Bitmap;

public final class FaceDetectionImpl implements FaceDetection {
  private final int mMaxFaces;
  
  FaceDetectionImpl(FaceDetectorOptions paramFaceDetectorOptions) {
    boolean bool = paramFaceDetectorOptions.fastMode;
    this.mMaxFaces = Math.min(paramFaceDetectorOptions.maxDetectedFaces, 32);
  }
  
  public final void close() {}
  
  public final void detect(Bitmap paramBitmap, FaceDetection.DetectResponse paramDetectResponse) {
    Bitmap bitmap2 = BitmapUtils.convertToBitmap(paramBitmap);
    if (bitmap2 == null) {
      Log.e("FaceDetectionImpl", "Error converting Mojom Bitmap to Android Bitmap", new Object[0]);
      paramDetectResponse.call(new org.chromium.shape_detection.mojom.FaceDetectionResult[0]);
      return;
    } 
    int i = paramBitmap.imageInfo.width + paramBitmap.imageInfo.width % 2;
    int j = paramBitmap.imageInfo.height;
    if (i != paramBitmap.imageInfo.width) {
      bitmap1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      (new Canvas(bitmap1)).drawBitmap(bitmap2, 0.0F, 0.0F, null);
    } else {
      bitmap1 = bitmap2;
    } 
    int[] arrayOfInt = new int[i * j];
    bitmap1.getPixels(arrayOfInt, 0, i, 0, 0, i, j);
    Bitmap bitmap1 = Bitmap.createBitmap(arrayOfInt, i, j, Bitmap.Config.RGB_565);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new FaceDetectionImpl$1(this, i, j, bitmap1, paramDetectResponse));
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\FaceDetectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */