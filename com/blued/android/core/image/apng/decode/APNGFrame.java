package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import com.blued.android.core.image.apng.io.Writer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

public class APNGFrame extends Frame<APNGReader, APNGWriter> {
  private static final byte[] m = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
  
  private static final byte[] n = new byte[] { 
      0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 
      96, -126 };
  
  private static ThreadLocal<CRC32> o = new ThreadLocal<CRC32>();
  
  public final byte a;
  
  public final byte b;
  
  byte[] c;
  
  List<Chunk> d;
  
  List<Chunk> e;
  
  public APNGFrame(APNGReader paramAPNGReader, FCTLChunk paramFCTLChunk) {
    super(paramAPNGReader);
    short s1;
    this.d = new ArrayList<Chunk>();
    this.e = new ArrayList<Chunk>();
    this.a = paramFCTLChunk.n;
    this.b = paramFCTLChunk.m;
    short s2 = paramFCTLChunk.k;
    if (paramFCTLChunk.l == 0) {
      s1 = 100;
    } else {
      s1 = paramFCTLChunk.l;
    } 
    this.l = s2 * 1000 / s1;
    this.h = paramFCTLChunk.c;
    this.i = paramFCTLChunk.h;
    this.j = paramFCTLChunk.i;
    this.k = paramFCTLChunk.j;
  }
  
  private int a(APNGWriter paramAPNGWriter) throws IOException {
    null = this.e.iterator();
    int i;
    for (i = 33; null.hasNext(); i += ((Chunk)null.next()).d + 12);
    for (Chunk chunk : this.d) {
      int k;
      if (chunk instanceof IDATChunk) {
        k = chunk.d + 12;
      } else if (chunk instanceof FDATChunk) {
        k = chunk.d + 8;
      } else {
        continue;
      } 
      i += k;
    } 
    i += n.length;
    paramAPNGWriter.c(i);
    paramAPNGWriter.a(m);
    paramAPNGWriter.b(13);
    int j = paramAPNGWriter.a();
    paramAPNGWriter.a(IHDRChunk.a);
    paramAPNGWriter.b(this.h);
    paramAPNGWriter.b(this.i);
    paramAPNGWriter.a(this.c);
    CRC32 cRC32 = a();
    cRC32.reset();
    cRC32.update(paramAPNGWriter.b(), j, 17);
    paramAPNGWriter.b((int)cRC32.getValue());
    for (Chunk chunk : this.e) {
      if (chunk instanceof IENDChunk)
        continue; 
      this.g.reset();
      this.g.skip(chunk.g);
      this.g.read(paramAPNGWriter.b(), paramAPNGWriter.a(), chunk.d + 12);
      paramAPNGWriter.d(chunk.d + 12);
    } 
    for (Chunk chunk : this.d) {
      if (chunk instanceof IDATChunk) {
        this.g.reset();
        this.g.skip(chunk.g);
        this.g.read(paramAPNGWriter.b(), paramAPNGWriter.a(), chunk.d + 12);
        paramAPNGWriter.d(chunk.d + 12);
        continue;
      } 
      if (chunk instanceof FDATChunk) {
        paramAPNGWriter.b(chunk.d - 4);
        j = paramAPNGWriter.a();
        paramAPNGWriter.a(IDATChunk.a);
        this.g.reset();
        this.g.skip((chunk.g + 4 + 4 + 4));
        this.g.read(paramAPNGWriter.b(), paramAPNGWriter.a(), chunk.d - 4);
        paramAPNGWriter.d(chunk.d - 4);
        cRC32.reset();
        cRC32.update(paramAPNGWriter.b(), j, chunk.d);
        paramAPNGWriter.b((int)cRC32.getValue());
      } 
    } 
    paramAPNGWriter.a(n);
    return i;
  }
  
  private CRC32 a() {
    CRC32 cRC322 = o.get();
    CRC32 cRC321 = cRC322;
    if (cRC322 == null) {
      cRC321 = new CRC32();
      o.set(cRC321);
    } 
    return cRC321;
  }
  
  public Bitmap a(Canvas paramCanvas, Paint paramPaint, int paramInt, Bitmap paramBitmap, APNGWriter paramAPNGWriter) {
    try {
      int i = a(paramAPNGWriter);
      BitmapFactory.Options options = new BitmapFactory.Options();
      options.inJustDecodeBounds = false;
      options.inSampleSize = paramInt;
      options.inMutable = true;
      options.inBitmap = paramBitmap;
      paramBitmap = BitmapFactory.decodeByteArray(paramAPNGWriter.b(), 0, i, options);
      if (f || paramBitmap != null) {
        float f1 = this.j;
        float f2 = paramInt;
        paramCanvas.drawBitmap(paramBitmap, f1 / f2, this.k / f2, paramPaint);
        return paramBitmap;
      } 
      throw new AssertionError();
    } catch (Exception exception) {
      exception.printStackTrace();
      return null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\APNGFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */