package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.common.util.StringUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public final class ZipEntry {
  public byte[] comment;
  
  public int commentLength;
  
  public long compressedLength;
  
  public long crc32;
  
  public byte[] data;
  
  public ZipDataDescriptor dataDescriptor;
  
  public byte[] extra;
  
  public int extraLength;
  
  public long fileExternalAttr;
  
  public long fileInternalAttr;
  
  public int fileNameLength;
  
  public long fileStartDiskId;
  
  public int flag;
  
  public int lastModifiedDate;
  
  public int lastModifiedTime;
  
  public ZipLocalFileHeader localFileHeader;
  
  public long localHdrOffset;
  
  public int method;
  
  public int minVersion;
  
  public byte[] name;
  
  public long offset = -1L;
  
  public long uncompressedLength;
  
  public int version;
  
  public String getName() {
    return StringUtils.getString(this.name);
  }
  
  public void setOffsetFromFile(RandomAccessFile paramRandomAccessFile, boolean paramBoolean) {
    long l1 = this.localHdrOffset;
    ByteBuffer byteBuffer = ByteBuffer.allocate((int)Math.min(paramRandomAccessFile.length() - l1, Math.min(paramRandomAccessFile.length(), 131100L)));
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    long l2 = (int)l1;
    try {
      paramRandomAccessFile.seek(l2);
      paramRandomAccessFile.readFully(byteBuffer.array());
      if (byteBuffer.getInt(0) == 67324752) {
        this.localFileHeader = new ZipLocalFileHeader();
        this.localFileHeader.minVersion = byteBuffer.getShort(4) & 0xFFFF;
        this.localFileHeader.genFlag = byteBuffer.getShort(6) & 0xFFFF;
        this.localFileHeader.method = byteBuffer.getShort(8) & 0xFFFF;
        this.localFileHeader.modifiedTime = byteBuffer.getShort(10) & 0xFFFF;
        this.localFileHeader.modifiedDate = byteBuffer.getShort(12) & 0xFFFF;
        this.localFileHeader.crc32 = byteBuffer.getInt(14) & 0xFFFFFFFF;
        this.localFileHeader.compressedSize = byteBuffer.getInt(18) & 0xFFFFFFFF;
        this.localFileHeader.uncompressedSize = byteBuffer.getInt(22) & 0xFFFFFFFF;
        this.localFileHeader.nameLength = byteBuffer.getShort(26) & 0xFFFF;
        this.localFileHeader.extraLength = 0xFFFF & byteBuffer.getShort(28);
        byteBuffer.position(30);
        byte[] arrayOfByte = new byte[this.localFileHeader.nameLength];
        byteBuffer.get(arrayOfByte);
        this.localFileHeader.name = arrayOfByte;
        byteBuffer.position(this.localFileHeader.nameLength + 30);
        arrayOfByte = new byte[this.localFileHeader.extraLength];
        byteBuffer.get(arrayOfByte);
        this.localFileHeader.extra = arrayOfByte;
        this.offset = l1 + 30L + this.localFileHeader.nameLength + this.localFileHeader.extraLength;
        if (paramBoolean) {
          byteBuffer = paramRandomAccessFile.getChannel().map(FileChannel.MapMode.READ_ONLY, this.offset, this.compressedLength);
          byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
          byteBuffer.position(0);
          arrayOfByte = new byte[(int)this.compressedLength];
          byteBuffer.get(arrayOfByte);
          this.data = arrayOfByte;
        } 
        FileChannel fileChannel = paramRandomAccessFile.getChannel();
        FileChannel.MapMode mapMode = FileChannel.MapMode.READ_ONLY;
        l1 = this.offset;
        MappedByteBuffer mappedByteBuffer = fileChannel.map(mapMode, this.compressedLength + l1, 16L);
        mappedByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        mappedByteBuffer.position(0);
        if (mappedByteBuffer.getInt() == 134695760) {
          this.dataDescriptor = new ZipDataDescriptor();
          this.dataDescriptor.crc32 = mappedByteBuffer.getInt(4) & 0xFFFFFFFFL;
          this.dataDescriptor.compressed = mappedByteBuffer.getInt(8) & 0xFFFFFFFFL;
          this.dataDescriptor.uncompressed = mappedByteBuffer.getInt(12) & 0xFFFFFFFFL;
          return;
        } 
      } else {
        System.out.println("didn't find signature at start of lfh");
        throw new IOException();
      } 
    } catch (IOException iOException) {
      iOException.printStackTrace();
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */