package org.chromium.shape_detection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.util.SparseArray;
import com.google.android.gms.internal.zzdld;
import com.google.android.gms.internal.zzdln;
import com.google.android.gms.internal.zzdlr;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import org.chromium.base.ContextUtils;
import org.chromium.base.Log;
import org.chromium.gfx.mojom.PointF;
import org.chromium.gfx.mojom.RectF;
import org.chromium.mojo.system.MojoException;
import org.chromium.shape_detection.mojom.TextDetection;
import org.chromium.shape_detection.mojom.TextDetectionResult;
import org.chromium.skia.mojom.Bitmap;

public final class TextDetectionImpl implements TextDetection {
  private TextRecognizer mTextRecognizer;
  
  public TextDetectionImpl() {
    TextRecognizer.Builder builder = new TextRecognizer.Builder(ContextUtils.sApplicationContext);
    this.mTextRecognizer = new TextRecognizer(new zzdlr(builder.mContext, builder.zzlie), (byte)0);
  }
  
  public final void close() {
    this.mTextRecognizer.release();
  }
  
  public final void detect(Bitmap paramBitmap, TextDetection.DetectResponse paramDetectResponse) {
    if (!this.mTextRecognizer.zzlid.isOperational()) {
      Log.e("TextDetectionImpl", "TextDetector is not operational", new Object[0]);
      paramDetectResponse.call(new TextDetectionResult[0]);
      return;
    } 
    Frame frame = BitmapUtils.convertToFrame(paramBitmap);
    if (frame == null) {
      Log.e("TextDetectionImpl", "Error converting Mojom Bitmap to Frame", new Object[0]);
      paramDetectResponse.call(new TextDetectionResult[0]);
      return;
    } 
    TextRecognizer textRecognizer = this.mTextRecognizer;
    zzdln zzdln = new zzdln(new Rect());
    if (frame != null) {
      Bitmap bitmap1;
      zzdld zzdld = zzdld.zzc(frame);
      if (frame.mBitmap != null) {
        bitmap1 = frame.mBitmap;
      } else {
        Frame.Metadata metadata = frame.zzlgd;
        ByteBuffer byteBuffer = frame.getGrayscaleImageData();
        int m = metadata.format;
        int n = zzdld.width;
        int i1 = zzdld.height;
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
          arrayOfByte = byteBuffer.array();
        } else {
          arrayOfByte = new byte[byteBuffer.capacity()];
          byteBuffer.get(arrayOfByte);
        } 
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        (new YuvImage(arrayOfByte, m, n, i1, null)).compressToJpeg(new Rect(0, 0, n, i1), 100, byteArrayOutputStream);
        byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
        bitmap1 = BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
      } 
      int j = bitmap1.getWidth();
      int k = bitmap1.getHeight();
      Bitmap bitmap2 = bitmap1;
      if (zzdld.rotation != 0) {
        char c;
        Matrix matrix = new Matrix();
        switch (zzdld.rotation) {
          default:
            throw new IllegalArgumentException("Unsupported rotation degree.");
          case 3:
            c = 'Ď';
            break;
          case 2:
            c = '´';
            break;
          case 1:
            c = 'Z';
            break;
          case 0:
            c = Character.MIN_VALUE;
            break;
        } 
        matrix.postRotate(c);
        bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, j, k, matrix, false);
      } 
      if (zzdld.rotation == 1 || zzdld.rotation == 3) {
        zzdld.width = k;
        zzdld.height = j;
      } 
      if (!zzdln.zzliq.isEmpty()) {
        Rect rect = zzdln.zzliq;
        int m = frame.zzlgd.zzalt;
        j = frame.zzlgd.zzalu;
        switch (zzdld.rotation) {
          case 3:
            rect = new Rect(rect.top, m - rect.right, rect.bottom, m - rect.left);
            break;
          case 2:
            rect = new Rect(m - rect.right, j - rect.bottom, m - rect.left, j - rect.top);
            break;
          case 1:
            rect = new Rect(j - rect.bottom, rect.left, j - rect.top, rect.right);
            break;
        } 
        zzdln.zzliq.set(rect);
      } 
      zzdld.rotation = 0;
      SparseArray sparseArray = TextRecognizer.zza(textRecognizer.zzlid.zza(bitmap2, zzdld, zzdln));
      TextDetectionResult[] arrayOfTextDetectionResult = new TextDetectionResult[sparseArray.size()];
      for (int i = 0; i < sparseArray.size(); i++) {
        arrayOfTextDetectionResult[i] = new TextDetectionResult((byte)0);
        TextBlock textBlock = (TextBlock)sparseArray.valueAt(i);
        (arrayOfTextDetectionResult[i]).rawValue = textBlock.getValue();
        Rect rect = textBlock.getBoundingBox();
        (arrayOfTextDetectionResult[i]).boundingBox = new RectF((byte)0);
        (arrayOfTextDetectionResult[i]).boundingBox.x = rect.left;
        (arrayOfTextDetectionResult[i]).boundingBox.y = rect.top;
        (arrayOfTextDetectionResult[i]).boundingBox.width = rect.width();
        (arrayOfTextDetectionResult[i]).boundingBox.height = rect.height();
        Point[] arrayOfPoint = textBlock.getCornerPoints();
        (arrayOfTextDetectionResult[i]).cornerPoints = new PointF[arrayOfPoint.length];
        for (j = 0; j < arrayOfPoint.length; j++) {
          (arrayOfTextDetectionResult[i]).cornerPoints[j] = new PointF((byte)0);
          ((arrayOfTextDetectionResult[i]).cornerPoints[j]).x = (arrayOfPoint[j]).x;
          ((arrayOfTextDetectionResult[i]).cornerPoints[j]).y = (arrayOfPoint[j]).y;
        } 
      } 
      paramDetectResponse.call(arrayOfTextDetectionResult);
      return;
    } 
    throw new IllegalArgumentException("No frame supplied.");
  }
  
  public final void onConnectionError(MojoException paramMojoException) {
    close();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\TextDetectionImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */