package com.bun.miitmdid.core;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.CRC32;
import java.util.zip.ZipException;

public class ZipUtils {
  private static final int BUFFER_SIZE = 16384;
  
  private static final int ENDHDR = 22;
  
  private static final int ENDSIG = 101010256;
  
  static long computeCrcOfCentralDir(RandomAccessFile paramRandomAccessFile, CentralDirectory paramCentralDirectory) throws IOException {
    CRC32 cRC32 = new CRC32();
    long l = paramCentralDirectory.b;
    paramRandomAccessFile.seek(paramCentralDirectory.a);
    int i = (int)Math.min(16384L, l);
    byte[] arrayOfByte = new byte[16384];
    while (true) {
      i = paramRandomAccessFile.read(arrayOfByte, 0, i);
      if (i == -1)
        break; 
      cRC32.update(arrayOfByte, 0, i);
      l -= i;
      if (l != 0L) {
        i = (int)Math.min(16384L, l);
        continue;
      } 
      break;
    } 
    return cRC32.getValue();
  }
  
  static CentralDirectory findCentralDirectory(RandomAccessFile paramRandomAccessFile) throws IOException, ZipException {
    long l2 = paramRandomAccessFile.length() - 22L;
    long l1 = 0L;
    if (l2 >= 0L) {
      long l = l2 - 65536L;
      if (l >= 0L)
        l1 = l; 
      int i = Integer.reverseBytes(101010256);
      while (true) {
        paramRandomAccessFile.seek(l2);
        if (paramRandomAccessFile.readInt() == i) {
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          paramRandomAccessFile.skipBytes(2);
          CentralDirectory centralDirectory = new CentralDirectory();
          centralDirectory.b = Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFFL;
          centralDirectory.a = Integer.reverseBytes(paramRandomAccessFile.readInt()) & 0xFFFFFFFFL;
          return centralDirectory;
        } 
        l2--;
        if (l2 >= l1)
          continue; 
        throw new ZipException("End Of Central Directory signature not found");
      } 
    } 
    StringBuilder stringBuilder = new StringBuilder("File too short to be a zip file: ");
    stringBuilder.append(paramRandomAccessFile.length());
    throw new ZipException(stringBuilder.toString());
  }
  
  public static long getZipCrc(File paramFile) throws IOException {
    RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "r");
    try {
      return computeCrcOfCentralDir(randomAccessFile, findCentralDirectory(randomAccessFile));
    } finally {
      randomAccessFile.close();
    } 
  }
  
  static class CentralDirectory {
    long a;
    
    long b;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\bun\miitmdid\core\ZipUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */