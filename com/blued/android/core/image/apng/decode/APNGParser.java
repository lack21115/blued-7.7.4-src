package com.blued.android.core.image.apng.decode;

import com.blued.android.core.image.apng.io.APNGReader;
import com.blued.android.core.image.apng.io.Reader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class APNGParser {
  public static List<Chunk> a(APNGReader paramAPNGReader) throws IOException {
    if (paramAPNGReader.a("PNG") && paramAPNGReader.a("\r\n\032\n")) {
      ArrayList<Chunk> arrayList = new ArrayList();
      while (paramAPNGReader.available() > 0)
        arrayList.add(b(paramAPNGReader)); 
      return arrayList;
    } 
    throw new FormatException();
  }
  
  public static boolean a(Reader paramReader) {
    APNGReader aPNGReader;
    if (paramReader instanceof APNGReader) {
      aPNGReader = (APNGReader)paramReader;
    } else {
      aPNGReader = new APNGReader((Reader)aPNGReader);
    } 
    try {
      if (aPNGReader.a("PNG") && aPNGReader.a("\r\n\032\n")) {
        while (aPNGReader.available() > 0) {
          if (b(aPNGReader) instanceof ACTLChunk)
            return true; 
        } 
      } else {
        throw new FormatException();
      } 
    } catch (IOException iOException) {
      if (!(iOException instanceof FormatException))
        iOException.printStackTrace(); 
    } 
    return false;
  }
  
  private static Chunk b(APNGReader paramAPNGReader) throws IOException {
    Chunk chunk;
    int i = paramAPNGReader.b();
    int j = paramAPNGReader.r_();
    int k = paramAPNGReader.d();
    if (k == ACTLChunk.a) {
      chunk = new ACTLChunk();
    } else if (k == FCTLChunk.a) {
      chunk = new FCTLChunk();
    } else if (k == FDATChunk.a) {
      chunk = new FDATChunk();
    } else if (k == IDATChunk.a) {
      chunk = new IDATChunk();
    } else if (k == IENDChunk.a) {
      chunk = new IENDChunk();
    } else if (k == IHDRChunk.a) {
      chunk = new IHDRChunk();
    } else {
      chunk = new Chunk();
    } 
    chunk.g = i;
    chunk.e = k;
    chunk.d = j;
    chunk.b(paramAPNGReader);
    chunk.f = paramAPNGReader.r_();
    return chunk;
  }
  
  static class FormatException extends IOException {
    FormatException() {
      super("APNG Format error");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\blued\android\core\image\apng\decode\APNGParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */