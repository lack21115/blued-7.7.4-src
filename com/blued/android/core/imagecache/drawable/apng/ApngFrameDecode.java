package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.util.Pair;
import ar.com.hjg.pngj.PngReaderApng;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkACTL;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import com.blued.android.core.imagecache.RecyclingUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ApngFrameDecode {
  protected boolean a = false;
  
  protected int b;
  
  protected int c;
  
  ApngDrawable d;
  
  ApngRenderTask e;
  
  private File f;
  
  private ArrayList<PngChunkFCTL> g = new ArrayList<PngChunkFCTL>();
  
  private Map<Integer, Pair<Integer, Integer>> h = new HashMap<Integer, Pair<Integer, Integer>>();
  
  public ApngFrameDecode(ApngDrawable paramApngDrawable) {
    this.d = paramApngDrawable;
    this.e = new ApngRenderTask(paramApngDrawable, this);
  }
  
  private Bitmap a(int paramInt1, int paramInt2, byte paramByte, Bitmap paramBitmap1, Bitmap paramBitmap2) {
    Bitmap bitmap;
    if (paramBitmap2 != null && paramBitmap2.getWidth() == this.d.c && paramBitmap2.getHeight() == this.d.d && !this.d.h.a(paramBitmap2)) {
      bitmap = paramBitmap2;
    } else {
      bitmap = this.d.h.a(this.d.c, this.d.d);
    } 
    if (bitmap == null)
      return paramBitmap2; 
    Canvas canvas = new Canvas(bitmap);
    if (paramBitmap2 != null) {
      if (bitmap != paramBitmap2)
        canvas.drawBitmap(paramBitmap2, 0.0F, 0.0F, null); 
      if (paramByte == 0) {
        canvas.clipRect(paramInt1, paramInt2, paramBitmap1.getWidth() + paramInt1, paramBitmap1.getHeight() + paramInt2);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        canvas.clipRect(0, 0, this.d.c, this.d.d);
      } 
    } 
    canvas.drawBitmap(paramBitmap1, paramInt1, paramInt2, null);
    return bitmap;
  }
  
  private void a(File paramFile) {
    PngReaderApng pngReaderApng = new PngReaderApng(paramFile);
    pngReaderApng.c();
    List<PngChunk> list = pngReaderApng.b().a();
    int i = 0;
    int j;
    for (j = 1; i < list.size(); j = k) {
      PngChunkACTL pngChunkACTL;
      int k;
      PngChunk pngChunk = list.get(i);
      if (pngChunk instanceof PngChunkACTL) {
        pngChunkACTL = (PngChunkACTL)pngChunk;
        this.b = pngChunkACTL.e();
        if (this.c > 0) {
          k = j;
        } else {
          this.c = pngChunkACTL.f();
          k = j;
        } 
      } else {
        k = j;
        if (pngChunkACTL instanceof PngChunkFCTL) {
          ArrayList<PngChunkFCTL> arrayList = this.g;
          PngChunkFCTL pngChunkFCTL = (PngChunkFCTL)pngChunkACTL;
          arrayList.add(pngChunkFCTL);
          int m = this.g.size() - 1;
          k = 1;
          while (pngChunkFCTL.j() == 2 && m > 0) {
            m--;
            k++;
            pngChunkFCTL = this.g.get(m);
          } 
          k = Math.max(j, k);
        } 
      } 
      i++;
    } 
    this.d.h.a(j);
  }
  
  private Bitmap c(int paramInt) {
    PngChunkFCTL pngChunkFCTL1;
    Bitmap bitmap1;
    Bitmap bitmap2;
    Canvas canvas;
    PngChunkFCTL pngChunkFCTL2 = null;
    if (paramInt > 0) {
      pngChunkFCTL1 = this.g.get(paramInt - 1);
    } else {
      pngChunkFCTL1 = null;
    } 
    if (pngChunkFCTL1 == null)
      return null; 
    byte b = pngChunkFCTL1.j();
    int i = pngChunkFCTL1.f();
    int j = pngChunkFCTL1.g();
    ApngDrawable apngDrawable = this.d;
    if (b != 0) {
      if (b != 1) {
        if (b != 2)
          return null; 
        pngChunkFCTL1 = pngChunkFCTL2;
        if (paramInt > 1) {
          paramInt -= 2;
          while (true) {
            pngChunkFCTL1 = pngChunkFCTL2;
            if (paramInt >= 0) {
              pngChunkFCTL1 = this.g.get(paramInt);
              i = pngChunkFCTL1.j();
              j = pngChunkFCTL1.f();
              int k = pngChunkFCTL1.g();
              if (i != 2) {
                if (i == 0)
                  return this.d.h.b(paramInt); 
                pngChunkFCTL1 = pngChunkFCTL2;
                if (i == 1) {
                  bitmap1 = this.d.h.b(paramInt);
                  if (bitmap1 != null && this.h.containsKey(Integer.valueOf(paramInt))) {
                    bitmap2 = this.d.h.a(this.d.c, this.d.d);
                    if (bitmap2 != null) {
                      canvas = new Canvas(bitmap2);
                      canvas.drawBitmap(bitmap1, 0.0F, 0.0F, null);
                      canvas.clipRect(j, k, ((Integer)((Pair)this.h.get(Integer.valueOf(paramInt))).first).intValue() + j, ((Integer)((Pair)this.h.get(Integer.valueOf(paramInt))).second).intValue() + k);
                      canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                      canvas.clipRect(0, 0, this.d.c, this.d.d);
                      return bitmap2;
                    } 
                  } 
                  return bitmap1;
                } 
                break;
              } 
              paramInt--;
              continue;
            } 
            break;
          } 
        } 
      } else {
        if (paramInt > 0) {
          bitmap1 = ((ApngDrawable)canvas).h.b(paramInt - 1);
        } else {
          pngChunkFCTL1 = null;
        } 
        if (pngChunkFCTL1 != null) {
          Map<Integer, Pair<Integer, Integer>> map = this.h;
          if (map.containsKey(Integer.valueOf(--paramInt))) {
            bitmap2 = this.d.h.a(this.d.c, this.d.d);
            if (bitmap2 != null) {
              canvas = new Canvas(bitmap2);
              canvas.drawBitmap((Bitmap)pngChunkFCTL1, 0.0F, 0.0F, null);
              canvas.clipRect(i, j, ((Integer)((Pair)this.h.get(Integer.valueOf(paramInt))).first).intValue() + i, ((Integer)((Pair)this.h.get(Integer.valueOf(paramInt))).second).intValue() + j);
              canvas.drawColor(0, PorterDuff.Mode.CLEAR);
              canvas.clipRect(0, 0, this.d.c, this.d.d);
              return bitmap2;
            } 
          } 
        } 
        return (Bitmap)pngChunkFCTL1;
      } 
    } else {
      bitmap1 = bitmap2;
      if (paramInt > 0)
        bitmap1 = ((ApngDrawable)canvas).h.b(paramInt - 1); 
    } 
    return bitmap1;
  }
  
  public int a(int paramInt) {
    PngChunkFCTL pngChunkFCTL = this.g.get(paramInt);
    paramInt = pngChunkFCTL.h();
    int i = pngChunkFCTL.i();
    return Math.round(paramInt * 1000.0F / i);
  }
  
  public void a() {
    String str = this.d.i();
    if (str == null)
      return; 
    this.f = new File(str);
    if (!this.f.exists())
      return; 
    ApngExtractFrames.a(this.f);
    a(this.f);
    this.a = true;
  }
  
  Bitmap b(int paramInt) {
    if (paramInt == 0) {
      String str1 = this.d.i();
      Bitmap bitmap5 = this.d.h.b(0);
      Bitmap bitmap4 = bitmap5;
      if (bitmap5 == null) {
        bitmap4 = ApngImageUtils.a(RecyclingUtils.Scheme.c.b(str1), this.d.h.a(this.d.c, this.d.d));
        this.d.h.a(0, bitmap4);
      } 
      return bitmap4;
    } 
    Bitmap bitmap2 = null;
    String str = (new File(this.d.b, ApngExtractFrames.a(this.f, paramInt))).getPath();
    Bitmap bitmap1 = bitmap2;
    try {
      Bitmap bitmap = this.d.h.a(this.d.c, this.d.d);
      bitmap1 = bitmap2;
      bitmap2 = ApngImageUtils.a(RecyclingUtils.Scheme.c.b(str), bitmap);
      bitmap1 = bitmap2;
    } finally {
      bitmap2 = null;
    } 
    if (bitmap1 != null)
      this.h.put(Integer.valueOf(paramInt), new Pair(Integer.valueOf(bitmap1.getWidth()), Integer.valueOf(bitmap1.getHeight()))); 
    bitmap2 = c(paramInt);
    PngChunkFCTL pngChunkFCTL = this.g.get(paramInt);
    byte b = pngChunkFCTL.k();
    Bitmap bitmap3 = a(pngChunkFCTL.f(), pngChunkFCTL.g(), b, bitmap1, bitmap2);
    this.d.h.a(paramInt, bitmap3);
    this.d.h.b(bitmap1);
    this.d.h.b(bitmap2);
    return bitmap3;
  }
  
  public void b() {
    if (this.d.e < 0) {
      this.d.e = 0;
    } else if (this.d.e >= this.g.size() - 1) {
      this.d.e = 0;
    } 
    b(0);
    int i = a(0);
    this.d.f.schedule(this.e, i, TimeUnit.MILLISECONDS);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngFrameDecode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */