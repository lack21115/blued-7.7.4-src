package com.wrapper.proxyapplication;

import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.zip.ZipFile;

public class CustomerClassLoader extends PathClassLoader {
  private static final boolean VERBOSE_DEBUG = false;
  
  private boolean initialized;
  
  private final String libPath;
  
  private final String mDexOutputPath;
  
  private DexFile[] mDexs;
  
  private File[] mFiles;
  
  private String[] mLibPaths;
  
  private String[] mPaths;
  
  private ZipFile[] mZips;
  
  private final String path;
  
  public CustomerClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader) throws NoSuchFieldException, IllegalAccessException, IllegalArgumentException, NullPointerException, IOException {}
  
  private native int ShowLogs(String paramString, int paramInt);
  
  private void ensureInit() throws IOException {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new java/lang/VerifyError
    //   5: dup
    //   6: ldc 'bad dex opcode'
    //   8: invokespecial <init> : (Ljava/lang/String;)V
    //   11: athrow
    //   12: astore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: goto -> 20
    //   18: aload_1
    //   19: athrow
    //   20: goto -> 18
    // Exception table:
    //   from	to	target	type
    //   2	12	12	finally
  }
  
  private static Field findField(Object paramObject, String paramString) throws NoSuchFieldException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static String generateOutputName(String paramString1, String paramString2) {
    new StringBuilder(80);
    throw new VerifyError("bad dex opcode");
  }
  
  private boolean isInArchive(ZipFile paramZipFile, String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private byte[] loadFromArchive(ZipFile paramZipFile, String paramString) {
    throw new VerifyError("bad dex opcode");
  }
  
  private byte[] loadFromDirectory(String paramString) {
    try {
      new RandomAccessFile(paramString, "r");
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {}
      return null;
    } catch (FileNotFoundException fileNotFoundException) {
      return null;
    } 
  }
  
  protected Class<?> findClass(String paramString) throws ClassNotFoundException {
    try {
      ensureInit();
    } catch (IOException iOException) {
      throw new VerifyError("bad dex opcode");
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public String findLibrary(String paramString) {
    try {
      ensureInit();
    } catch (IOException iOException) {
      throw new VerifyError("bad dex opcode");
    } 
    System.mapLibraryName((String)iOException);
    throw new VerifyError("bad dex opcode");
  }
  
  protected URL findResource(String paramString) {
    URL uRL = super.findResource(paramString);
    if (uRL != null)
      return uRL; 
    throw new VerifyError("bad dex opcode");
  }
  
  protected Package getPackage(String paramString) {
    if (paramString != null)
      throw new VerifyError("bad dex opcode"); 
    return null;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\CustomerClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */