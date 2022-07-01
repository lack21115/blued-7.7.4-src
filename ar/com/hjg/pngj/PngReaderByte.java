package ar.com.hjg.pngj;

import java.io.File;

public class PngReaderByte extends PngReader {
  public PngReaderByte(File paramFile) {
    super(paramFile);
    a((IImageLineSetFactory)ImageLineSetDefault.b());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\PngReaderByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */