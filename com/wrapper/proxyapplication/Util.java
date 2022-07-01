package com.wrapper.proxyapplication;

import android.content.Context;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Util {
  public static String CPUABI;
  
  static final int ERROR_EXCEPTION = -2;
  
  static final int ERROR_FALSE = 0;
  
  static final int ERROR_FILE_EXIST = 2;
  
  static final int ERROR_FILE_NOT_FOUND = -1;
  
  static final int ERROR_FILE_NOT_FOUND_INZIP = -3;
  
  static final int ERROR_SUCCESS = 1;
  
  public static int MAX_DEX_NUM = 300;
  
  public static String TAG = "Util";
  
  public static String dexname = "classes.dex";
  
  public static boolean ifoverwrite = true;
  
  public static String libname = "";
  
  public static String securename0 = "00O000ll111l.dex";
  
  public static String securename1 = "00O000ll111l.jar";
  
  public static String securename11 = ".flag00O000ll111l.vdex";
  
  public static String securename14 = "00O000ll111l.vdex";
  
  public static String securename15 = "00O000ll111l.odex";
  
  public static String securename2 = "000O00ll111l.dex";
  
  public static String securename3 = "0000000lllll.dex";
  
  public static String securename4 = "000000olllll.dex";
  
  public static String securename5 = "0OO00l111l1l";
  
  public static String securename6 = "o0oooOO0ooOo.dat";
  
  public static String securename7 = "exportService.txt";
  
  public static String securename8 = ".flag00O000ll111l.dex";
  
  public static String securename9 = ".updateIV.dat";
  
  public static String simplelibname = "tosprotection";
  
  public static String versionname = "tosversion";
  
  static {
    getCPUABI();
    if (CPUABI == "x86") {
      libname = "libshellx-super.2019.so";
    } else {
      libname = "shell-super.2019";
    } 
    throw new VerifyError("bad dex opcode");
  }
  
  public Util() {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int Comparetxtinzip(ZipFile paramZipFile, String paramString, File paramFile) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static String CreatenewFileName(String paramString1, String paramString2, String paramString3) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static int DeleteFile(String paramString) {
    new File(paramString);
    throw new VerifyError("bad dex opcode");
  }
  
  public static int PrepareSecurefiles(Context paramContext, ZipFile paramZipFile) {
    new StringBuilder();
    throw new VerifyError("bad dex opcode");
  }
  
  public static boolean SafeUnzipFile(ZipFile paramZipFile, String paramString, File paramFile) {
    return SafeUnzipFile(paramZipFile, paramString, paramFile, 0L);
  }
  
  public static boolean SafeUnzipFile(ZipFile paramZipFile, String paramString, File paramFile, long paramLong) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      throw new VerifyError("bad dex opcode");
    } finally {}
    if (false) {
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException iOException) {
        throw new VerifyError("bad dex opcode");
      } finally {}
      throw paramZipFile;
    } 
    throw paramZipFile;
  }
  
  public static boolean UnzipFile(ZipFile paramZipFile, String paramString, File paramFile) {
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Exception null) {
      try {
        throw new VerifyError("bad dex opcode");
      } finally {}
    } finally {}
    if (false) {
      try {
        throw new VerifyError("bad dex opcode");
      } catch (IOException null) {
        throw new VerifyError("bad dex opcode");
      } finally {}
      if (false)
        try {
          throw new VerifyError("bad dex opcode");
        } catch (IOException exception) {
          throw new VerifyError("bad dex opcode");
        }  
      throw exception;
    } 
    throw exception;
  }
  
  public static byte[] UnzipFile(ZipFile paramZipFile, ZipEntry paramZipEntry) throws IOException {
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean checkCopiedFileCrc(ZipFile paramZipFile, String paramString, File paramFile) {
    if (getFileCRC32(paramFile) == -1L)
      return false; 
    try {
      throw new VerifyError("bad dex opcode");
    } catch (Exception exception) {
      return false;
    } 
  }
  
  public static boolean deleteDir(File paramFile) {
    throw new VerifyError("bad dex opcode");
  }
  
  public static void getCPUABI() {
    if (CPUABI == null)
      try {
        Runtime.getRuntime();
        throw new VerifyError("bad dex opcode");
      } catch (Exception exception) {
        CPUABI = "armeabi";
      }  
    throw new VerifyError("bad dex opcode");
  }
  
  public static long getCRC32(File paramFile) {
    CRC32 cRC32 = new CRC32();
    try {
      new CheckedInputStream(new BufferedInputStream(new FileInputStream(paramFile)), cRC32);
      byte[] arrayOfByte = new byte[65536];
      throw new VerifyError("bad dex opcode");
    } catch (FileNotFoundException fileNotFoundException) {
      throw new VerifyError("bad dex opcode");
    } catch (IOException iOException) {
      throw new VerifyError("bad dex opcode");
    } finally {}
    throw paramFile;
  }
  
  private static long getFileCRC32(File paramFile) {
    throw new VerifyError("bad dex opcode");
  }
  
  private static boolean isFileValid(String paramString, long paramLong) {
    new File(paramString);
    throw new VerifyError("bad dex opcode");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued555128-dex2jar.jar!\com\wrapper\proxyapplication\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */