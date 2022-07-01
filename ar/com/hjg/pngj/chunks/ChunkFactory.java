package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.IChunkFactory;
import ar.com.hjg.pngj.ImageInfo;

public class ChunkFactory implements IChunkFactory {
  boolean a;
  
  public ChunkFactory() {
    this(true);
  }
  
  public ChunkFactory(boolean paramBoolean) {
    this.a = paramBoolean;
  }
  
  public final PngChunk a(ChunkRaw paramChunkRaw, ImageInfo paramImageInfo) {
    PngChunk pngChunk2 = a(paramChunkRaw.c, paramImageInfo);
    PngChunk pngChunk1 = pngChunk2;
    if (pngChunk2 == null)
      pngChunk1 = c(paramChunkRaw.c, paramImageInfo); 
    pngChunk2 = pngChunk1;
    if (pngChunk1 == null)
      pngChunk2 = b(paramChunkRaw.c, paramImageInfo); 
    pngChunk2.b(paramChunkRaw);
    if (this.a && paramChunkRaw.d != null)
      pngChunk2.a(paramChunkRaw); 
    return pngChunk2;
  }
  
  protected final PngChunk a(String paramString, ImageInfo paramImageInfo) {
    return (PngChunk)(paramString.equals("IDAT") ? new PngChunkIDAT(paramImageInfo) : (paramString.equals("IHDR") ? new PngChunkIHDR(paramImageInfo) : (paramString.equals("PLTE") ? new PngChunkPLTE(paramImageInfo) : (paramString.equals("IEND") ? new PngChunkIEND(paramImageInfo) : (paramString.equals("tEXt") ? new PngChunkTEXT(paramImageInfo) : (paramString.equals("iTXt") ? new PngChunkITXT(paramImageInfo) : (paramString.equals("zTXt") ? new PngChunkZTXT(paramImageInfo) : (paramString.equals("bKGD") ? new PngChunkBKGD(paramImageInfo) : (paramString.equals("gAMA") ? new PngChunkGAMA(paramImageInfo) : (paramString.equals("pHYs") ? new PngChunkPHYS(paramImageInfo) : (paramString.equals("iCCP") ? new PngChunkICCP(paramImageInfo) : (paramString.equals("tIME") ? new PngChunkTIME(paramImageInfo) : (paramString.equals("tRNS") ? new PngChunkTRNS(paramImageInfo) : (paramString.equals("cHRM") ? new PngChunkCHRM(paramImageInfo) : (paramString.equals("sBIT") ? new PngChunkSBIT(paramImageInfo) : (paramString.equals("sRGB") ? new PngChunkSRGB(paramImageInfo) : (paramString.equals("hIST") ? new PngChunkHIST(paramImageInfo) : (paramString.equals("sPLT") ? new PngChunkSPLT(paramImageInfo) : (paramString.equals("fdAT") ? new PngChunkFDAT(paramImageInfo) : (paramString.equals("acTL") ? new PngChunkACTL(paramImageInfo) : (paramString.equals("fcTL") ? new PngChunkFCTL(paramImageInfo) : null)))))))))))))))))))));
  }
  
  protected final PngChunk b(String paramString, ImageInfo paramImageInfo) {
    return new PngChunkUNKNOWN(paramString, paramImageInfo);
  }
  
  protected PngChunk c(String paramString, ImageInfo paramImageInfo) {
    return (PngChunk)(paramString.equals("oFFs") ? new PngChunkOFFS(paramImageInfo) : (paramString.equals("sTER") ? new PngChunkSTER(paramImageInfo) : null));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\ChunkFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */