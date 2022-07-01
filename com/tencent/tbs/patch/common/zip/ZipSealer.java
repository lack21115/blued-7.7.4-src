package com.tencent.tbs.patch.common.zip;

import com.tencent.tbs.patch.common.PatchException;
import com.tencent.tbs.patch.common.patch.PatchResultExplainer;
import com.tencent.tbs.patch.common.util.DigestProcessor;
import com.tencent.tbs.patch.common.util.FileUtils;
import com.tencent.tbs.patch.common.util.PatchLogger;
import com.tencent.tbs.patch.json.JSONArray;
import com.tencent.tbs.patch.json.JSONException;
import com.tencent.tbs.patch.json.JSONObject;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class ZipSealer {
  public static final int COMPOUND_FAILED_CRC32_NOT_EQUAL = -3;
  
  public static final int COMPOUND_FAILED_DIGEST_NOT_EQUAL = -4;
  
  public static final int COMPOUND_FAILED_ENTRY_OR_INSERTION_EMPTY = -5;
  
  public static final int COMPOUND_FAILED_LEN_NOT_EQUAL = -2;
  
  public static final int COMPOUND_FAILED_LUCKY_BYTES_LEN_NOT_MATCH = -7;
  
  public static final int COMPOUND_FAILED_LUCKY_BYTES_MD5_NOT_MATCH = -6;
  
  public static final int COMPOUND_LUCKY_BYTES_COMPATIBLE = 1;
  
  public static final int COMPOUND_OK = 0;
  
  private static LinkedList<DataEntry> a(File paramFile) {
    LinkedList<DataEntry> linkedList = new LinkedList();
    try {
      JSONArray jSONArray = new JSONArray(FileUtils.readStrFromFile(paramFile));
      for (int i = 0; i < jSONArray.length(); i++) {
        JSONObject jSONObject = jSONArray.optJSONObject(i);
        String str = jSONObject.optString("NAME");
        long l1 = Long.parseLong(jSONObject.optString("CL"));
        long l2 = Long.parseLong(jSONObject.optString("UCL"));
        long l3 = Long.parseLong(jSONObject.optString("IFF"));
        long l4 = Long.parseLong(jSONObject.optString("AFF"));
        linkedList.add(new DataEntry(str, jSONObject.optString("CHK"), l1, l2, Long.parseLong(jSONObject.optString("CRC")), l3, l4));
      } 
      return linkedList;
    } catch (JSONException jSONException) {
    
    } catch (IOException iOException) {}
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("JSON Exception or IO Exception: ");
    stringBuilder.append(iOException.getMessage());
    throw new PatchException(stringBuilder.toString());
  }
  
  private static void a(LinkedList<DataEntry> paramLinkedList, File paramFile) {
    JSONArray jSONArray = new JSONArray();
    int i = 0;
    while (i < paramLinkedList.size()) {
      try {
        DataEntry dataEntry = paramLinkedList.get(i);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("NAME", dataEntry.name);
        jSONObject.put("CL", dataEntry.compressedLength);
        jSONObject.put("UCL", dataEntry.uncompressedLength);
        jSONObject.put("IFF", dataEntry.metaInsertionOffset);
        jSONObject.put("AFF", dataEntry.realOffset);
        jSONObject.put("CRC", dataEntry.crc32);
        jSONObject.put("CHK", dataEntry.digest);
        jSONArray.put(jSONObject);
        i++;
      } catch (JSONException jSONException) {
        jSONException.printStackTrace();
      } 
    } 
    FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(jSONArray.toString().getBytes());
    byte[] arrayOfByte = new byte[1024];
    while (true) {
      i = byteArrayInputStream.read(arrayOfByte, 0, arrayOfByte.length);
      if (i != -1) {
        fileOutputStream.write(arrayOfByte, 0, i);
        continue;
      } 
      fileOutputStream.flush();
      FileUtils.closeQuietly(byteArrayInputStream);
      FileUtils.closeQuietly(fileOutputStream);
      return;
    } 
  }
  
  public static int checkCompatible(ZipEntry paramZipEntry, DataEntry paramDataEntry, byte[] paramArrayOfbyte) {
    if (paramArrayOfbyte != null) {
      StringBuilder stringBuilder;
      if (paramArrayOfbyte.length != paramDataEntry.compressedLength) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("[Lucky Bytes] Compressed length mismatch: ");
        stringBuilder.append(paramDataEntry.compressedLength);
        stringBuilder.append(" != ");
        stringBuilder.append(paramZipEntry.compressedLength);
        PatchLogger.e(stringBuilder.toString());
        return -7;
      } 
      str = DigestProcessor.getInstance().calcDigest((byte[])stringBuilder);
      if (!paramDataEntry.digest.equals(str)) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("[Lucky Bytes] Digest mismatch: ");
        stringBuilder.append(paramDataEntry.digest);
        stringBuilder.append(" != ");
        stringBuilder.append(str);
        PatchLogger.e(stringBuilder.toString());
        return -6;
      } 
      return 1;
    } 
    if (str == null || paramDataEntry == null) {
      PatchLogger.e("zipEntry == null || insertion == null");
      return -5;
    } 
    if (((ZipEntry)str).compressedLength != paramDataEntry.compressedLength) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Compressed length mismatch: ");
      stringBuilder.append(paramDataEntry.compressedLength);
      stringBuilder.append(" != ");
      stringBuilder.append(((ZipEntry)str).compressedLength);
      PatchLogger.e(stringBuilder.toString());
      return -2;
    } 
    if (((ZipEntry)str).crc32 != paramDataEntry.crc32) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("CRC32 mismatch: ");
      stringBuilder.append(paramDataEntry.crc32);
      stringBuilder.append(" != ");
      stringBuilder.append(((ZipEntry)str).crc32);
      PatchLogger.e(stringBuilder.toString());
      return -3;
    } 
    String str = DigestProcessor.getInstance().calcDigest(((ZipEntry)str).data);
    if (!paramDataEntry.digest.equals(str)) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("Digest mismatch: ");
      stringBuilder.append(paramDataEntry.digest);
      stringBuilder.append(" != ");
      stringBuilder.append(str);
      PatchLogger.e(stringBuilder.toString());
      return -4;
    } 
    return 0;
  }
  
  public static void seal(Map<String, PatchResultExplainer> paramMap, String paramString1, String paramString2, String paramString3, String paramString4) {
    ZipFileParser zipFileParser = new ZipFileParser();
    zipFileParser.parse(new File(paramString1), true);
    LinkedHashMap<String, ZipEntry> linkedHashMap = zipFileParser.mapEntries();
    LinkedList<DataEntry> linkedList = a(new File(paramString2));
    FileOutputStream fileOutputStream = new FileOutputStream(paramString4);
    FileChannel fileChannel = (new RandomAccessFile(paramString3, "r")).getChannel();
    long l = 0L;
    for (int i = 0; i < linkedList.size(); i++) {
      byte[] arrayOfByte;
      DataEntry dataEntry = linkedList.get(i);
      int j = (int)(dataEntry.metaInsertionOffset - l);
      fileChannel.position(l);
      ByteBuffer byteBuffer1 = ByteBuffer.allocate(j);
      byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      fileChannel.read(byteBuffer1);
      fileOutputStream.write(byteBuffer1.array());
      ZipEntry zipEntry = linkedHashMap.get(dataEntry.name);
      PatchResultExplainer patchResultExplainer = paramMap.get(dataEntry.name);
      paramString2 = null;
      String str = paramString2;
      if (patchResultExplainer != null) {
        str = paramString2;
        if (patchResultExplainer.isIncompatible())
          arrayOfByte = FileUtils.readBytesFromFile(patchResultExplainer.getPatchFilePath()); 
      } 
      j = checkCompatible(zipEntry, dataEntry, arrayOfByte);
      if (j == 0) {
        fileOutputStream.write(zipEntry.data);
      } else if (j == 1 && arrayOfByte != null) {
        fileOutputStream.write(arrayOfByte);
      } else {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("`");
        stringBuilder.append(dataEntry.name);
        stringBuilder.append("(");
        stringBuilder.append(paramString4);
        stringBuilder.append(")` read bytes from file null， checkResult=");
        stringBuilder.append(j);
        stringBuilder.append(", luckyBytes=");
        stringBuilder.append(arrayOfByte);
        throw new PatchException(stringBuilder.toString());
      } 
      l = dataEntry.metaInsertionOffset;
    } 
    fileChannel.position(l);
    ByteBuffer byteBuffer = ByteBuffer.allocate((int)(fileChannel.size() - l));
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    fileChannel.read(byteBuffer);
    fileOutputStream.write(byteBuffer.array());
    FileUtils.closeQuietly(fileChannel);
    FileUtils.closeQuietly(fileOutputStream);
  }
  
  public static void unseal(String paramString, File paramFile1, File paramFile2) {
    unseal(paramString, paramFile1, paramFile2, new DefaultDataBlockHandler());
  }
  
  public static void unseal(String paramString, File paramFile1, File paramFile2, DataBlockHandler paramDataBlockHandler) {
    ZipFileParser zipFileParser = new ZipFileParser();
    zipFileParser.parse(new File(paramString), true);
    LinkedHashMap<String, ZipEntry> linkedHashMap = zipFileParser.mapEntries();
    RandomAccessFile randomAccessFile = new RandomAccessFile(paramString, "r");
    LinkedList<DataEntry> linkedList = new LinkedList();
    for (String str : linkedHashMap.keySet()) {
      if (!paramDataBlockHandler.accept(str))
        continue; 
      ZipEntry zipEntry = linkedHashMap.get(str);
      DataEntry dataEntry = new DataEntry();
      dataEntry.name = paramDataBlockHandler.sealedName(zipEntry.getName());
      dataEntry.realOffset = zipEntry.offset;
      dataEntry.compressedLength = zipEntry.compressedLength;
      dataEntry.uncompressedLength = zipEntry.uncompressedLength;
      dataEntry.crc32 = zipEntry.crc32;
      dataEntry.digest = DigestProcessor.getInstance().calcDigest(zipEntry.data);
      linkedList.add(dataEntry);
    } 
    FileChannel fileChannel = randomAccessFile.getChannel();
    int i = 0;
    FileOutputStream fileOutputStream = new FileOutputStream(paramFile1);
    long l5 = 0L;
    long l2 = 0L;
    long l1 = l2;
    long l4 = l1;
    long l3 = l1;
    for (l1 = l5; l1 < fileChannel.size() && i < linkedList.size(); l1 = l2 + l3) {
      DataEntry dataEntry = linkedList.get(i);
      int j = (int)(dataEntry.realOffset - l2 - l3);
      if (j <= 0) {
        i++;
        continue;
      } 
      ByteBuffer byteBuffer1 = ByteBuffer.allocate(j);
      byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
      fileChannel.position(l1);
      fileChannel.read(byteBuffer1);
      byte[] arrayOfByte = byteBuffer1.array();
      fileOutputStream.write(arrayOfByte);
      l4 += arrayOfByte.length;
      dataEntry.metaInsertionOffset = l4;
      if (paramDataBlockHandler != null) {
        ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)dataEntry.compressedLength);
        byteBuffer1.order(ByteOrder.LITTLE_ENDIAN);
        fileChannel.position(dataEntry.realOffset);
        fileChannel.read(byteBuffer2);
        paramDataBlockHandler.handleDataBlock(dataEntry, byteBuffer2);
      } 
      l2 = dataEntry.realOffset;
      l3 = dataEntry.compressedLength;
      i++;
    } 
    ByteBuffer byteBuffer = ByteBuffer.allocate((int)(fileChannel.size() - l1));
    byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    fileChannel.position(l1);
    fileChannel.read(byteBuffer);
    fileOutputStream.write(byteBuffer.array());
    FileUtils.closeQuietly(randomAccessFile);
    FileUtils.closeQuietly(fileOutputStream);
    a(linkedList, paramFile2);
  }
  
  public static interface DataBlockHandler {
    boolean accept(String param1String);
    
    void handleDataBlock(ZipSealer.DataEntry param1DataEntry, ByteBuffer param1ByteBuffer);
    
    String sealedName(String param1String);
  }
  
  public static class DataEntry {
    public long compressedLength;
    
    public long crc32;
    
    public String digest;
    
    public long metaInsertionOffset;
    
    public String name;
    
    public long realOffset;
    
    public long uncompressedLength;
    
    public DataEntry() {}
    
    public DataEntry(String param1String1, String param1String2, long param1Long1, long param1Long2, long param1Long3, long param1Long4, long param1Long5) {
      this.realOffset = param1Long5;
      this.metaInsertionOffset = param1Long4;
      this.compressedLength = param1Long1;
      this.uncompressedLength = param1Long2;
      this.crc32 = param1Long3;
      this.name = param1String1;
      this.digest = param1String2;
    }
  }
  
  public static class DefaultDataBlockHandler implements DataBlockHandler {
    public boolean accept(String param1String) {
      return true;
    }
    
    public void handleDataBlock(ZipSealer.DataEntry param1DataEntry, ByteBuffer param1ByteBuffer) {}
    
    public String sealedName(String param1String) {
      return param1String;
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued209820-dex2jar.jar!\com\tencent\tbs\patch\common\zip\ZipSealer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */