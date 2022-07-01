package com.blued.android.core.image.apng.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.APNGWriter;
import com.blued.android.core.image.apng.io.Reader;
import com.blued.android.core.image.apng.io.Writer;
import com.blued.android.core.image.apng.loader.ByteBufferLoader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class APNGDecoder extends FrameSeqDecoder<APNGReader, APNGWriter> {
  private APNGWriter g;
  
  private int h;
  
  private final Paint i = new Paint();
  
  private SnapShot j = new SnapShot();
  
  public APNGDecoder(ByteBufferLoader paramByteBufferLoader, FrameSeqDecoder.RenderListener paramRenderListener) {
    super(paramByteBufferLoader, paramRenderListener);
    this.i.setAntiAlias(true);
  }
  
  protected Rect a(APNGReader paramAPNGReader) throws IOException {
    List<Chunk> list = APNGParser.a(paramAPNGReader);
    ArrayList<Chunk> arrayList = new ArrayList();
    byte[] arrayOfByte = new byte[0];
    Iterator<Chunk> iterator = list.iterator();
    list = null;
    int i = 0;
    int j = 0;
    int k = 0;
    while (iterator.hasNext()) {
      APNGFrame aPNGFrame1;
      APNGFrame aPNGFrame2;
      Chunk chunk = iterator.next();
      if (chunk instanceof ACTLChunk) {
        this.h = ((ACTLChunk)chunk).c;
        i = 1;
        continue;
      } 
      if (chunk instanceof FCTLChunk) {
        aPNGFrame2 = new APNGFrame(paramAPNGReader, (FCTLChunk)chunk);
        aPNGFrame2.e = arrayList;
        aPNGFrame2.c = arrayOfByte;
        aPNGFrame1 = aPNGFrame2;
        if (this.a != null) {
          this.a.add(aPNGFrame2);
          aPNGFrame1 = aPNGFrame2;
        } 
        continue;
      } 
      if (aPNGFrame2 instanceof FDATChunk) {
        if (aPNGFrame1 != null)
          aPNGFrame1.d.add(aPNGFrame2); 
        continue;
      } 
      if (aPNGFrame2 instanceof IDATChunk) {
        if (!i) {
          StillFrame stillFrame = new StillFrame(paramAPNGReader);
          stillFrame.h = j;
          stillFrame.i = k;
          if (this.a != null)
            this.a.add(stillFrame); 
          this.h = 1;
          break;
        } 
        if (aPNGFrame1 != null)
          aPNGFrame1.d.add(aPNGFrame2); 
        continue;
      } 
      if (aPNGFrame2 instanceof IHDRChunk) {
        IHDRChunk iHDRChunk = (IHDRChunk)aPNGFrame2;
        j = iHDRChunk.b;
        k = iHDRChunk.c;
        byte[] arrayOfByte1 = iHDRChunk.h;
        continue;
      } 
      if (!(aPNGFrame2 instanceof IENDChunk))
        arrayList.add(aPNGFrame2); 
    } 
    i = j * k;
    this.e = ByteBuffer.allocate((i / this.c * this.c + 1) * 4);
    this.j.c = ByteBuffer.allocate((i / this.c * this.c + 1) * 4);
    return new Rect(0, 0, j, k);
  }
  
  protected APNGReader a(Reader paramReader) {
    return new APNGReader(paramReader);
  }
  
  protected APNGWriter a() {
    if (this.g == null)
      this.g = new APNGWriter(); 
    return this.g;
  }
  
  protected void a(Frame paramFrame) {
    if (paramFrame != null) {
      if (this.f == null)
        return; 
      try {
        Bitmap bitmap2 = a(this.f.width() / this.c, this.f.height() / this.c);
        Canvas canvas1 = null;
        if (this.d != null)
          canvas1 = this.d.get(bitmap2); 
        Canvas canvas2 = canvas1;
        if (canvas1 == null) {
          canvas2 = new Canvas(bitmap2);
          this.d.put(bitmap2, canvas2);
        } 
        if (paramFrame instanceof APNGFrame) {
          this.e.rewind();
          bitmap2.copyPixelsFromBuffer(this.e);
          if (this.b == 0) {
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
          } else {
            canvas2.save();
            canvas2.clipRect(this.j.b);
            byte b = this.j.a;
            if (b != 1) {
              if (b == 2) {
                this.j.c.rewind();
                bitmap2.copyPixelsFromBuffer(this.j.c);
              } 
            } else {
              canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
            } 
            canvas2.restore();
          } 
          if (((APNGFrame)paramFrame).b == 2 && this.j.a != 2) {
            this.j.c.rewind();
            bitmap2.copyPixelsToBuffer(this.j.c);
          } 
          this.j.a = ((APNGFrame)paramFrame).b;
          canvas2.save();
          if (((APNGFrame)paramFrame).a == 0) {
            canvas2.clipRect(paramFrame.j / this.c, paramFrame.k / this.c, (paramFrame.j + paramFrame.h) / this.c, (paramFrame.k + paramFrame.i) / this.c);
            canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
          } 
          this.j.b.set(paramFrame.j / this.c, paramFrame.k / this.c, (paramFrame.j + paramFrame.h) / this.c, (paramFrame.k + paramFrame.i) / this.c);
          canvas2.restore();
        } 
        Bitmap bitmap1 = a(paramFrame.h, paramFrame.i);
        a(paramFrame.a(canvas2, this.i, this.c, bitmap1, a()));
        this.e.rewind();
        bitmap2.copyPixelsToBuffer(this.e);
        a(bitmap2);
        return;
      } catch (Exception exception) {
        exception.printStackTrace();
      } catch (Error error) {
        error.printStackTrace();
        return;
      } 
    } 
  }
  
  protected int b() {
    return this.h;
  }
  
  protected void c() {
    if (this.j.c != null) {
      this.j.c.clear();
      this.j.c = null;
    } 
    APNGWriter aPNGWriter = this.g;
    if (aPNGWriter != null) {
      aPNGWriter.c();
      this.g = null;
    } 
  }
  
  class SnapShot {
    byte a;
    
    Rect b = new Rect();
    
    ByteBuffer c;
    
    private SnapShot(APNGDecoder this$0) {}
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\APNGDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */