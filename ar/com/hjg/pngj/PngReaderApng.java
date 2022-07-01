package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkACTL;
import ar.com.hjg.pngj.chunks.PngChunkFCTL;
import java.io.File;
import java.util.List;

public class PngReaderApng extends PngReaderByte {
  protected PngChunkACTL g;
  
  protected int h = -1;
  
  private Boolean i = null;
  
  private boolean j = false;
  
  private PngChunkFCTL k;
  
  public PngReaderApng(File paramFile) {
    super(paramFile);
    a("fcTL");
  }
  
  public void c() {
    super.c();
  }
  
  protected ChunkSeqReaderPng f() {
    return new ChunkSeqReaderPng(this, false) {
        protected void a(int param1Int, String param1String, long param1Long) {
          super.a(param1Int, param1String, param1Long);
        }
        
        protected void a(ChunkReader param1ChunkReader) {
          super.a(param1ChunkReader);
          if ((param1ChunkReader.a()).c.equals("fcTL")) {
            PngReaderApng pngReaderApng = this.h;
            pngReaderApng.h++;
            List<PngChunk> list = this.h.c.m();
            PngReaderApng.a(this.h, (PngChunkFCTL)list.get(list.size() - 1));
            if (param1ChunkReader.a().d() == PngReaderApng.a(this.h).b().d()) {
              ImageInfo imageInfo = PngReaderApng.a(this.h).e();
              this.h.e().a(imageInfo);
              return;
            } 
            throw new PngjInputException("something went wrong");
          } 
        }
        
        protected boolean a(String param1String) {
          return (param1String.equals("IDAT") || param1String.equals("fdAT"));
        }
        
        protected DeflatedChunksSet b(String param1String) {
          IdatSet idatSet = new IdatSet(param1String, n(), this.d);
          idatSet.a(this.g);
          return idatSet;
        }
        
        public boolean b(int param1Int, String param1String) {
          return super.b(param1Int, param1String);
        }
        
        protected boolean e(String param1String) {
          return (super.e(param1String) && !param1String.equals(Boolean.valueOf(param1String.equals("fdAT"))));
        }
      };
  }
  
  public boolean g() {
    if (this.i == null) {
      boolean bool1;
      this.g = (PngChunkACTL)b().a("acTL");
      PngChunkACTL pngChunkACTL = this.g;
      boolean bool2 = true;
      if (pngChunkACTL != null) {
        bool1 = true;
      } else {
        bool1 = false;
      } 
      this.i = Boolean.valueOf(bool1);
      if (this.k != null) {
        bool1 = bool2;
      } else {
        bool1 = false;
      } 
      this.j = bool1;
    } 
    return this.i.booleanValue();
  }
  
  public int h() {
    return g() ? this.g.e() : 0;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\PngReaderApng.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */