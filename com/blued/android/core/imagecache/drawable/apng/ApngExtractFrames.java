package com.blued.android.core.imagecache.drawable.apng;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.ChunkSeqReaderPng;
import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngReader;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkRaw;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import ar.com.hjg.pngj.chunks.PngChunkIEND;
import ar.com.hjg.pngj.chunks.PngChunkIHDR;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;

public class ApngExtractFrames {
  public static int a(File paramFile) {
    PngReaderBuffered pngReaderBuffered = new PngReaderBuffered(paramFile);
    pngReaderBuffered.c();
    return pngReaderBuffered.j + 1;
  }
  
  public static String a(File paramFile, int paramInt) {
    String str = paramFile.getName();
    int i = str.lastIndexOf(".");
    if (i > 0) {
      String str1 = str.substring(0, i);
      str = str.substring(i + 1);
      return String.format(Locale.ENGLISH, "%s_%03d.%s", new Object[] { str1, Integer.valueOf(paramInt), str });
    } 
    return String.format(Locale.ENGLISH, "%s_%03d", new Object[] { str, Integer.valueOf(paramInt) });
  }
  
  static class PngReaderBuffered extends PngReader {
    FileOutputStream g = null;
    
    File h;
    
    ImageInfo i;
    
    int j = -1;
    
    private File k;
    
    public PngReaderBuffered(File param1File) {
      super(param1File);
      this.k = param1File;
    }
    
    private void g() throws Exception {
      if (this.g != null)
        h(); 
      this.h = i();
      this.g = new FileOutputStream(this.h);
      this.g.write(PngHelperInternal.a());
      (new PngChunkIHDR(this.i)).e().a(this.g);
      for (PngChunk pngChunk : a(false).a()) {
        String str = pngChunk.a;
        if (str.equals("IHDR") || str.equals("fcTL") || str.equals("acTL"))
          continue; 
        if (str.equals("IDAT"))
          return; 
        pngChunk.b().a(this.g);
      } 
    }
    
    private void h() throws IOException {
      (new PngChunkIEND(null)).e().a(this.g);
      this.g.close();
      this.g = null;
    }
    
    private File i() {
      return new File(this.k.getParent(), ApngExtractFrames.a(this.k, this.j));
    }
    
    public ChunkSeqReaderPng f() {
      return new ChunkSeqReaderPng(this, false) {
          public void a(ChunkReader param2ChunkReader) {
            super.a(param2ChunkReader);
            try {
              String str = (param2ChunkReader.a()).c;
              PngChunk pngChunk = this.f.a().get(this.f.a().size() - 1);
              if (str.equals("fcTL")) {
                ApngExtractFrames.PngReaderBuffered pngReaderBuffered = this.h;
                pngReaderBuffered.j++;
                this.h.i = ((PngChunkFCTL)pngChunk).e();
                ApngExtractFrames.PngReaderBuffered.a(this.h);
              } 
              boolean bool = str.equals("fdAT");
              if (bool || str.equals("IDAT")) {
                if (str.equals("IDAT")) {
                  if (this.h.g != null)
                    param2ChunkReader.a().a(this.h.g); 
                } else {
                  ChunkRaw chunkRaw = new ChunkRaw((param2ChunkReader.a()).a - 4, ChunkHelper.c, true);
                  System.arraycopy((param2ChunkReader.a()).d, 4, chunkRaw.d, 0, chunkRaw.d.length);
                  chunkRaw.a(this.h.g);
                } 
                (param2ChunkReader.a()).d = null;
              } 
              if (str.equals("IEND") && this.h.g != null)
                ApngExtractFrames.PngReaderBuffered.b(this.h); 
              return;
            } catch (Exception exception) {
              throw new PngjException(exception);
            } 
          }
          
          public boolean a(String param2String) {
            return false;
          }
          
          public boolean b(int param2Int, String param2String) {
            return false;
          }
        };
    }
  }
  
  class null extends ChunkSeqReaderPng {
    null(ApngExtractFrames this$0, boolean param1Boolean) {
      super(param1Boolean);
    }
    
    public void a(ChunkReader param1ChunkReader) {
      super.a(param1ChunkReader);
      try {
        String str = (param1ChunkReader.a()).c;
        PngChunk pngChunk = this.f.a().get(this.f.a().size() - 1);
        if (str.equals("fcTL")) {
          ApngExtractFrames.PngReaderBuffered pngReaderBuffered = this.h;
          pngReaderBuffered.j++;
          this.h.i = ((PngChunkFCTL)pngChunk).e();
          ApngExtractFrames.PngReaderBuffered.a(this.h);
        } 
        boolean bool = str.equals("fdAT");
        if (bool || str.equals("IDAT")) {
          if (str.equals("IDAT")) {
            if (this.h.g != null)
              param1ChunkReader.a().a(this.h.g); 
          } else {
            ChunkRaw chunkRaw = new ChunkRaw((param1ChunkReader.a()).a - 4, ChunkHelper.c, true);
            System.arraycopy((param1ChunkReader.a()).d, 4, chunkRaw.d, 0, chunkRaw.d.length);
            chunkRaw.a(this.h.g);
          } 
          (param1ChunkReader.a()).d = null;
        } 
        if (str.equals("IEND") && this.h.g != null)
          ApngExtractFrames.PngReaderBuffered.b(this.h); 
        return;
      } catch (Exception exception) {
        throw new PngjException(exception);
      } 
    }
    
    public boolean a(String param1String) {
      return false;
    }
    
    public boolean b(int param1Int, String param1String) {
      return false;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\imagecache\drawable\apng\ApngExtractFrames.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */