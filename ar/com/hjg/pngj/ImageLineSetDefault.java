package ar.com.hjg.pngj;

public abstract class ImageLineSetDefault<T extends IImageLine> implements IImageLineSet<T> {
  public static IImageLineSetFactory<ImageLineInt> a() {
    return a(ImageLineInt.a());
  }
  
  public static <T extends IImageLine> IImageLineSetFactory<T> a(IImageLineFactory<T> paramIImageLineFactory) {
    return new IImageLineSetFactory<T>(paramIImageLineFactory) {
      
      };
  }
  
  public static IImageLineSetFactory<ImageLineByte> b() {
    return a(ImageLineByte.a());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\ImageLineSetDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */