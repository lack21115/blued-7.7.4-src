package ar.com.hjg.pngj;

public class ImageLineInt implements IImageLine, IImageLineArray {
  public final ImageInfo a;
  
  protected final int[] b;
  
  public static IImageLineFactory<ImageLineInt> a() {
    return new IImageLineFactory<ImageLineInt>() {
      
      };
  }
  
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(" cols=");
    stringBuilder.append(this.a.a);
    stringBuilder.append(" bpc=");
    stringBuilder.append(this.a.c);
    stringBuilder.append(" size=");
    stringBuilder.append(this.b.length);
    return stringBuilder.toString();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ImageLineInt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */