package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.common.util.PatchLogger;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;

public class ZipFileParser {
  private ZipEndOfCentralDirectory a;
  
  private long b;
  
  private LinkedHashMap<String, ZipEntry> c = new LinkedHashMap<String, ZipEntry>();
  
  private int a(int paramInt) {
    return ((paramInt & 0xFF) << 24) + ((0xFF00 & paramInt) << 8) + ((0xFF0000 & paramInt) >>> 8) + (paramInt >>> 24 & 0xFF);
  }
  
  private int a(RandomAccessFile paramRandomAccessFile) {
    return a(paramRandomAccessFile.readInt());
  }
  
  public byte[] getBytes() {
    ByteBuffer byteBuffer = ByteBuffer.allocate((int)this.b);
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    for (String str : this.c.keySet()) {
      ZipEntry zipEntry = this.c.get(str);
      ZipLocalFileHeader zipLocalFileHeader = zipEntry.localFileHeader;
      byteBuffer.putInt(67324752);
      byteBuffer.putShort((short)zipLocalFileHeader.minVersion);
      byteBuffer.putShort((short)zipLocalFileHeader.genFlag);
      byteBuffer.putShort((short)zipLocalFileHeader.method);
      byteBuffer.putShort((short)(zipLocalFileHeader.modifiedTime & 0xFFFF));
      byteBuffer.putShort((short)(zipLocalFileHeader.modifiedDate & 0xFFFF));
      byteBuffer.putInt(zipLocalFileHeader.crc32);
      byteBuffer.putInt(zipLocalFileHeader.compressedSize);
      byteBuffer.putInt(zipLocalFileHeader.uncompressedSize);
      byteBuffer.putShort((short)zipLocalFileHeader.nameLength);
      byteBuffer.putShort((short)zipLocalFileHeader.extraLength);
      byteBuffer.put(zipLocalFileHeader.name);
      byteBuffer.put(zipLocalFileHeader.extra);
      if (zipEntry.data != null)
        byteBuffer.put(zipEntry.data, 0, zipEntry.data.length); 
      if (zipEntry.dataDescriptor != null) {
        ZipDataDescriptor zipDataDescriptor = zipEntry.dataDescriptor;
        byteBuffer.putInt(134695760);
        byteBuffer.putInt((int)zipDataDescriptor.crc32);
        byteBuffer.putInt((int)zipDataDescriptor.compressed);
        byteBuffer.putInt((int)zipDataDescriptor.uncompressed);
      } 
    } 
    for (String str : this.c.keySet()) {
      ZipEntry zipEntry = this.c.get(str);
      byteBuffer.putInt(33639248);
      byteBuffer.putShort((short)zipEntry.version);
      byteBuffer.putShort((short)zipEntry.minVersion);
      byteBuffer.putShort((short)zipEntry.flag);
      byteBuffer.putShort((short)zipEntry.method);
      byteBuffer.putShort((short)zipEntry.lastModifiedTime);
      byteBuffer.putShort((short)zipEntry.lastModifiedDate);
      byteBuffer.putInt((int)zipEntry.crc32);
      byteBuffer.putInt((int)zipEntry.compressedLength);
      byteBuffer.putInt((int)zipEntry.uncompressedLength);
      byteBuffer.putShort((short)zipEntry.fileNameLength);
      byteBuffer.putShort((short)zipEntry.extraLength);
      byteBuffer.putShort((short)zipEntry.commentLength);
      byteBuffer.putShort((short)(int)zipEntry.fileStartDiskId);
      byteBuffer.putShort((short)(int)zipEntry.fileInternalAttr);
      byteBuffer.putInt((int)zipEntry.fileExternalAttr);
      byteBuffer.putInt((int)zipEntry.localHdrOffset);
      byteBuffer.put(zipEntry.name);
      byteBuffer.put(zipEntry.extra);
      byteBuffer.put(zipEntry.comment);
    } 
    if (this.a != null) {
      byteBuffer.putInt(101010256);
      byteBuffer.putShort(this.a.diskId);
      byteBuffer.putShort(this.a.startDiskId);
      byteBuffer.putShort(this.a.numEntries);
      byteBuffer.putShort(this.a.numStruct);
      byteBuffer.putInt((int)this.a.dirSize);
      byteBuffer.putInt((int)this.a.dirOffset);
      byteBuffer.putShort((short)(int)this.a.archiveCommentLength);
      byteBuffer.put(this.a.archiveComment);
    } 
    return byteBuffer.array();
  }
  
  public LinkedHashMap<String, ZipEntry> mapEntries() {
    return this.c;
  }
  
  public void parse(File paramFile, boolean paramBoolean) {
    RandomAccessFile randomAccessFile = new RandomAccessFile(paramFile, "r");
    this.b = randomAccessFile.length();
    long l = this.b;
    if (l >= 22L) {
      if (65557L <= l)
        l = 65557L; 
      randomAccessFile.seek(0L);
      int i = a(randomAccessFile);
      if (i != 101010256) {
        if (i == 67324752) {
          randomAccessFile.seek((int)(this.b - l));
          ByteBuffer byteBuffer = ByteBuffer.allocate((int)l);
          byte[] arrayOfByte = byteBuffer.array();
          randomAccessFile.readFully(arrayOfByte);
          byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          for (i = arrayOfByte.length - 22; i >= 0 && (arrayOfByte[i] != 80 || byteBuffer.getInt(i) != 101010256); i--);
          if (i < 0)
            PatchLogger.d("Zip end of central directory not found"); 
          this.a = new ZipEndOfCentralDirectory();
          this.a.diskId = byteBuffer.getShort(i + 4);
          this.a.startDiskId = byteBuffer.getShort(i + 6);
          this.a.numEntries = byteBuffer.getShort(i + 8);
          this.a.numStruct = byteBuffer.getShort(i + 10);
          this.a.dirSize = byteBuffer.getInt(i + 12) & 0xFFFFFFFFL;
          this.a.dirOffset = byteBuffer.getInt(i + 16) & 0xFFFFFFFFL;
          this.a.archiveCommentLength = byteBuffer.getShort(i + 20) & 0xFFFFL;
          arrayOfByte = new byte[(int)this.a.archiveCommentLength];
          byteBuffer.get(arrayOfByte, 0, arrayOfByte.length);
          ZipEndOfCentralDirectory zipEndOfCentralDirectory = this.a;
          zipEndOfCentralDirectory.archiveComment = arrayOfByte;
          if (zipEndOfCentralDirectory.dirOffset + this.a.dirSize <= this.b) {
            if (this.a.numEntries != 0) {
              randomAccessFile.seek((int)this.a.dirOffset);
              ByteBuffer byteBuffer1 = ByteBuffer.allocate((int)this.a.dirSize);
              randomAccessFile.readFully(byteBuffer1.array());
              byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
              byte[] arrayOfByte1 = new byte[65535];
              ByteBuffer byteBuffer2 = ByteBuffer.allocate(30);
              byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
              i = 0;
              int j = 0;
              while (i < this.a.numEntries) {
                if (byteBuffer1.getInt(j) == 33639248) {
                  ZipEntry zipEntry = new ZipEntry();
                  zipEntry.version = byteBuffer1.getShort(j + 4) & 0xFFFF;
                  zipEntry.minVersion = byteBuffer1.getShort(j + 6) & 0xFFFF;
                  zipEntry.flag = byteBuffer1.getShort(j + 8) & 0xFFFF;
                  zipEntry.method = byteBuffer1.getShort(j + 10) & 0xFFFF;
                  zipEntry.lastModifiedTime = (short)(int)(byteBuffer1.getShort(j + 12) & 0xFFFFL);
                  zipEntry.lastModifiedDate = (int)(byteBuffer1.getShort(j + 14) & 0xFFFFL);
                  zipEntry.crc32 = byteBuffer1.getLong(j + 16) & 0xFFFFFFFFL;
                  zipEntry.compressedLength = byteBuffer1.getLong(j + 20) & 0xFFFFFFFFL;
                  zipEntry.uncompressedLength = byteBuffer1.getLong(j + 24) & 0xFFFFFFFFL;
                  int k = byteBuffer1.getShort(j + 28) & 0xFFFF;
                  int n = j + 46;
                  byteBuffer1.position(n);
                  byteBuffer1.get(arrayOfByte1, 0, k);
                  byteBuffer1.position(0);
                  byte[] arrayOfByte2 = new byte[k];
                  System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, k);
                  int m = byteBuffer1.getShort(j + 30) & 0xFFFF;
                  n += k;
                  byteBuffer1.position(n);
                  byteBuffer1.get(arrayOfByte1, 0, m);
                  byteBuffer1.position(0);
                  byte[] arrayOfByte3 = new byte[m];
                  System.arraycopy(arrayOfByte1, 0, arrayOfByte3, 0, m);
                  int i1 = byteBuffer1.getShort(j + 32) & 0xFFFF;
                  byteBuffer1.position(n + m);
                  byteBuffer1.get(arrayOfByte1, 0, i1);
                  byteBuffer1.position(0);
                  byte[] arrayOfByte4 = new byte[i1];
                  System.arraycopy(arrayOfByte1, 0, arrayOfByte4, 0, i1);
                  zipEntry.fileNameLength = k;
                  zipEntry.extraLength = m;
                  zipEntry.commentLength = i1;
                  zipEntry.extra = arrayOfByte3;
                  zipEntry.name = arrayOfByte2;
                  zipEntry.comment = arrayOfByte4;
                  zipEntry.fileStartDiskId = byteBuffer1.getInt(j + 34) & 0xFFFFL;
                  zipEntry.fileInternalAttr = byteBuffer1.getInt(j + 36) & 0xFFFFL;
                  zipEntry.fileExternalAttr = byteBuffer1.getInt(j + 38) & 0xFFFFFFFFL;
                  zipEntry.localHdrOffset = byteBuffer1.getLong(j + 42) & 0xFFFFFFFFL;
                  byteBuffer2.clear();
                  zipEntry.setOffsetFromFile(randomAccessFile, paramBoolean);
                  this.c.put(zipEntry.getName(), zipEntry);
                  j += k + 46 + m + i1;
                  i++;
                  continue;
                } 
                StringBuilder stringBuilder1 = new StringBuilder();
                stringBuilder1.append("Missed a central dir sig (at ");
                stringBuilder1.append(j);
                stringBuilder1.append(")");
                PatchLogger.d(stringBuilder1.toString());
                throw new IOException();
              } 
              return;
            } 
            PatchLogger.e("Empty archive ?");
            throw new IOException();
          } 
          StringBuilder stringBuilder = new StringBuilder();
          stringBuilder.append("Bad offsets (dir ");
          stringBuilder.append(this.a.dirOffset);
          stringBuilder.append(", size ");
          stringBuilder.append(this.a.dirSize);
          stringBuilder.append(", zipEocd ");
          stringBuilder.append(i);
          stringBuilder.append(")");
          PatchLogger.e(stringBuilder.toString());
          throw new IOException();
        } 
        System.out.println("Not a Zip archive");
        throw new IOException();
      } 
      System.out.println("Found Zip archive, but it looks empty");
      throw new IOException();
    } 
    throw new IOException();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipFileParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */