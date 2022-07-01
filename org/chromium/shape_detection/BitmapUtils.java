package org.chromium.shape_detection;

import android.graphics.Bitmap;
import com.google.android.gms.vision.Frame;
import java.nio.ByteBuffer;
import org.chromium.mojo_base.BigBufferUtil;
import org.chromium.skia.mojom.Bitmap;

public final class BitmapUtils {
  public static Bitmap convertToBitmap(Bitmap paramBitmap) {
    if (paramBitmap.imageInfo == null)
      return null; 
    int i = paramBitmap.imageInfo.width;
    int j = paramBitmap.imageInfo.height;
    long l1 = i;
    long l2 = j;
    if (paramBitmap.pixelData != null && i > 0 && j > 0) {
      if (l1 * l2 > 2305843009213693951L)
        return null; 
      if (paramBitmap.imageInfo.colorType != 4 && paramBitmap.imageInfo.colorType != 5)
        return null; 
      ByteBuffer byteBuffer = ByteBuffer.wrap(BigBufferUtil.getBytesFromBigBuffer(paramBitmap.pixelData));
      if (byteBuffer.capacity() <= 0)
        return null; 
      Bitmap bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      bitmap.copyPixelsFromBuffer(byteBuffer);
      return bitmap;
    } 
    return null;
  }
  
  public static Frame convertToFrame(Bitmap paramBitmap) {
    Bitmap bitmap = convertToBitmap(paramBitmap);
    if (bitmap == null)
      return null; 
    Frame.Builder builder = new Frame.Builder();
    int i = bitmap.getWidth();
    int j = bitmap.getHeight();
    builder.zzlgf.mBitmap = bitmap;
    Frame.Metadata metadata = builder.zzlgf.zzlgd;
    metadata.zzalt = i;
    metadata.zzalu = j;
    if (builder.zzlgf.zzlge != null || builder.zzlgf.mBitmap != null)
      return builder.zzlgf; 
    throw new IllegalStateException("Missing image data.  Call either setBitmap or setImageData to specify the image");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\shape_detection\BitmapUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */