package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngjException;
import java.util.ArrayList;
import java.util.List;

public class ChunksList {
  List<PngChunk> a = new ArrayList<PngChunk>();
  
  final ImageInfo b;
  
  boolean c = false;
  
  public ChunksList(ImageInfo paramImageInfo) {
    this.b = paramImageInfo;
  }
  
  protected static List<PngChunk> a(List<PngChunk> paramList, String paramString1, String paramString2) {
    return (paramString2 == null) ? ChunkHelper.a(paramList, new ChunkPredicate(paramString1) {
          public boolean a(PngChunk param1PngChunk) {
            return param1PngChunk.a.equals(this.a);
          }
        }) : ChunkHelper.a(paramList, new ChunkPredicate(paramString1, paramString2) {
          public boolean a(PngChunk param1PngChunk) {
            return !param1PngChunk.a.equals(this.a) ? false : ((param1PngChunk instanceof PngChunkTextVar && !((PngChunkTextVar)param1PngChunk).e().equals(this.b)) ? false : (!(param1PngChunk instanceof PngChunkSPLT && !((PngChunkSPLT)param1PngChunk).e().equals(this.b))));
          }
        });
  }
  
  public PngChunk a(String paramString) {
    return a(paramString, false);
  }
  
  public PngChunk a(String paramString1, String paramString2, boolean paramBoolean) {
    List<? extends PngChunk> list = a(paramString1, paramString2);
    if (list.isEmpty())
      return null; 
    if (list.size() <= 1 || (!paramBoolean && ((PngChunk)list.get(0)).a()))
      return list.get(list.size() - 1); 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("unexpected multiple chunks id=");
    stringBuilder.append(paramString1);
    throw new PngjException(stringBuilder.toString());
  }
  
  public PngChunk a(String paramString, boolean paramBoolean) {
    return a(paramString, (String)null, paramBoolean);
  }
  
  public List<PngChunk> a() {
    return this.a;
  }
  
  public List<? extends PngChunk> a(String paramString1, String paramString2) {
    return a(this.a, paramString1, paramString2);
  }
  
  public void a(PngChunk paramPngChunk, int paramInt) {
    paramPngChunk.a(paramInt);
    this.a.add(paramPngChunk);
    if (paramPngChunk.a.equals("PLTE"))
      this.c = true; 
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("ChunkList: read: ");
    stringBuilder.append(this.a.size());
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\ChunksList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */