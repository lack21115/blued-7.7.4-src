package org.chromium.shape_detection;

import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.gms.internal.zzdkx;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;
import java.nio.ByteBuffer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.BarcodeDetection;
import org.chromium.shape_detection.mojom.BarcodeDetectionResult;
import org.chromium.skia.mojom.Bitmap;

public final class BarcodeDetectionImpl implements BarcodeDetection {
  private BarcodeDetector mBarcodeDetector;
  
  public BarcodeDetectionImpl() {
    BarcodeDetector.Builder builder = new BarcodeDetector.Builder(ContextUtils.sApplicationContext);
    this.mBarcodeDetector = new BarcodeDetector(new zzdkx(builder.mContext, builder.zzlgp), (byte)0);
  }
  
  public final void close() {
    this.mBarcodeDetector.release();
  }
  
  public final void detect(Bitmap paramBitmap, BarcodeDetection.DetectResponse paramDetectResponse) {
    if (!this.mBarcodeDetector.zzlgo.isOperational()) {
      Log.e("BarcodeDetectionImpl", "BarcodeDetector is not operational", new Object[0]);
      paramDetectResponse.call(new BarcodeDetectionResult[0]);
      return;
    } 
    Frame frame = BitmapUtils.convertToFrame(paramBitmap);
    if (frame == null) {
      Log.e("BarcodeDetectionImpl", "Error converting Mojom Bitmap to Frame", new Object[0]);
      paramDetectResponse.call(new BarcodeDetectionResult[0]);
      return;
    } 
    BarcodeDetector barcodeDetector = this.mBarcodeDetector;
    if (frame != null) {
      Barcode[] arrayOfBarcode;
      zzdld zzdld = zzdld.zzc(frame);
      if (frame.mBitmap != null) {
        arrayOfBarcode = barcodeDetector.zzlgo.zza(frame.mBitmap, zzdld);
        if (arrayOfBarcode == null)
          throw new IllegalArgumentException("Internal barcode detector error; check logcat output."); 
      } else {
        ByteBuffer byteBuffer = frame.getGrayscaleImageData();
        arrayOfBarcode = ((BarcodeDetector)arrayOfBarcode).zzlgo.zza(byteBuffer, zzdld);
      } 
      SparseArray sparseArray = new SparseArray(arrayOfBarcode.length);
      int j = arrayOfBarcode.length;
      int i;
      for (i = 0; i < j; i++) {
        Barcode barcode = arrayOfBarcode[i];
        sparseArray.append(barcode.rawValue.hashCode(), barcode);
      } 
      BarcodeDetectionResult[] arrayOfBarcodeDetectionResult = new BarcodeDetectionResult[sparseArray.size()];
      for (i = 0; i < sparseArray.size(); i++) {
        arrayOfBarcodeDetectionResult[i] = new BarcodeDetectionResult((byte)0);
        Barcode barcode = (Barcode)sparseArray.valueAt(i);
        (arrayOfBarcodeDetectionResult[i]).rawValue = barcode.rawValue;
        Rect rect = barcode.getBoundingBox();
        (arrayOfBarcodeDetectionResult[i]).boundingBox = new RectF((byte)0);
        (arrayOfBarcodeDetectionResult[i]).boundingBox.x = rect.left;
        (arrayOfBarcodeDetectionResult[i]).boundingBox.y = rect.top;
        (arrayOfBarcodeDetectionResult[i]).boundingBox.width = rect.width();
        (arrayOfBarcodeDetectionResult[i]).boundingBox.height = rect.height();
        Point[] arrayOfPoint = barcode.cornerPoints;
        (arrayOfBarcodeDetectionResult[i]).cornerPoints = new PointF[arrayOfPoint.length];
        for (j = 0; j < arrayOfPoint.length; j++) {
          (arrayOfBarcodeDetectionResult[i]).cornerPoints[j] = new PointF((byte)0);
          ((arrayOfBarcodeDetectionResult[i]).cornerPoints[j]).x = (arrayOfPoint[j]).x;
          ((arrayOfBarcodeDetectionResult[i]).cornerPoints[j]).y = (arrayOfPoint[j]).y;
        } 
      } 
      paramDetectResponse.call(arrayOfBarcodeDetectionResult);
      return;
    } 
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\BarcodeDetectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */