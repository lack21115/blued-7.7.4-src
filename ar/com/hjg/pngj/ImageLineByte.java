package ar.com.hjg.pngj;

public class ImageLineByte implements IImageLine, IImageLineArray {
  public final ImageInfo a;
  
  final byte[] b;
  
  public static IImageLineFactory<ImageLineByte> a() {
    return new IImageLineFactory<ImageLineByte>() {
      
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


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ImageLineByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */