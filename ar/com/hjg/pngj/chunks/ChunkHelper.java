package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class ChunkHelper {
  public static final byte[] a = a("IHDR");
  
  public static final byte[] b = a("PLTE");
  
  public static final byte[] c = a("IDAT");
  
  public static final byte[] d = a("IEND");
  
  private static byte[] e = new byte[4096];
  
  public static String a(byte[] paramArrayOfbyte) {
    try {
      return new String(paramArrayOfbyte, PngHelperInternal.b);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new PngBadCharsetException(unsupportedEncodingException);
    } 
  }
  
  public static String a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return new String(paramArrayOfbyte, paramInt1, paramInt2, PngHelperInternal.b);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new PngBadCharsetException(unsupportedEncodingException);
    } 
  }
  
  public static List<PngChunk> a(List<PngChunk> paramList, ChunkPredicate paramChunkPredicate) {
    ArrayList<PngChunk> arrayList = new ArrayList();
    for (PngChunk pngChunk : paramList) {
      if (paramChunkPredicate.a(pngChunk))
        arrayList.add(pngChunk); 
    } 
    return arrayList;
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
    synchronized (e) {
      while (true) {
        int i = paramInputStream.read(e);
        if (i > 0) {
          paramOutputStream.write(e, 0, i);
          continue;
        } 
        return;
      } 
    } 
  }
  
  public static boolean a(PngChunk paramPngChunk) {
    return paramPngChunk instanceof PngChunkUNKNOWN;
  }
  
  public static final boolean a(PngChunk paramPngChunk1, PngChunk paramPngChunk2) {
    if (paramPngChunk1 == paramPngChunk2)
      return true; 
    if (paramPngChunk1 != null && paramPngChunk2 != null) {
      if (!paramPngChunk1.a.equals(paramPngChunk2.a))
        return false; 
      if (paramPngChunk1.b)
        return false; 
      if (paramPngChunk1.getClass() != paramPngChunk2.getClass())
        return false; 
      if (!paramPngChunk2.a())
        return true; 
      if (paramPngChunk1 instanceof PngChunkTextVar)
        return ((PngChunkTextVar)paramPngChunk1).e().equals(((PngChunkTextVar)paramPngChunk2).e()); 
      if (paramPngChunk1 instanceof PngChunkSPLT)
        return ((PngChunkSPLT)paramPngChunk1).e().equals(((PngChunkSPLT)paramPngChunk2).e()); 
    } 
    return false;
  }
  
  public static byte[] a(String paramString) {
    try {
      return paramString.getBytes(PngHelperInternal.b);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new PngBadCharsetException(unsupportedEncodingException);
    } 
  }
  
  public static byte[] a(byte[] paramArrayOfbyte, int paramInt1, int paramInt2, boolean paramBoolean) {
    ByteArrayOutputStream byteArrayOutputStream2;
    try {
      InflaterInputStream inflaterInputStream;
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte, paramInt1, paramInt2);
      if (!paramBoolean)
        inflaterInputStream = new InflaterInputStream(byteArrayInputStream); 
      byteArrayOutputStream2 = new ByteArrayOutputStream();
      if (paramBoolean) {
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream2);
        a(inflaterInputStream, deflaterOutputStream);
        inflaterInputStream.close();
        deflaterOutputStream.close();
        return byteArrayOutputStream2.toByteArray();
      } 
    } catch (Exception exception) {
      throw new PngjException(exception);
    } 
    ByteArrayOutputStream byteArrayOutputStream1 = byteArrayOutputStream2;
    a((InputStream)exception, byteArrayOutputStream1);
    exception.close();
    byteArrayOutputStream1.close();
    return byteArrayOutputStream2.toByteArray();
  }
  
  public static String b(byte[] paramArrayOfbyte) {
    try {
      return new String(paramArrayOfbyte, PngHelperInternal.d);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new PngBadCharsetException(unsupportedEncodingException);
    } 
  }
  
  public static String b(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
    try {
      return new String(paramArrayOfbyte, paramInt1, paramInt2, PngHelperInternal.d);
    } catch (UnsupportedEncodingException unsupportedEncodingException) {
      throw new PngBadCharsetException(unsupportedEncodingException);
    } 
  }
  
  public static boolean b(String paramString) {
    return Character.isUpperCase(paramString.charAt(0));
  }
  
  public static int c(byte[] paramArrayOfbyte) {
    for (int i = 0; i < paramArrayOfbyte.length; i++) {
      if (paramArrayOfbyte[i] == 0)
        return i; 
    } 
    return -1;
  }
  
  public static boolean c(String paramString) {
    return Character.isUpperCase(paramString.charAt(1));
  }
  
  public static boolean d(String paramString) {
    return Character.isUpperCase(paramString.charAt(3)) ^ true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\ar\com\hjg\pngj\chunks\ChunkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */