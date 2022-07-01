package com.qiniu.android.dns.local;

import com.qiniu.android.dns.DnsException;
import com.qiniu.android.dns.Record;
import com.qiniu.android.dns.util.BitSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.IDN;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;

public final class DnsMessage {
  public static byte[] buildQuery(String paramString, int paramInt) {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
    DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
    BitSet bitSet = new BitSet();
    bitSet.set(8);
    paramInt = (short)paramInt;
    try {
      dataOutputStream.writeShort(paramInt);
      dataOutputStream.writeShort((short)bitSet.value());
      dataOutputStream.writeShort(1);
      dataOutputStream.writeShort(0);
      dataOutputStream.writeShort(0);
      dataOutputStream.writeShort(0);
      dataOutputStream.flush();
      writeQuestion(byteArrayOutputStream, paramString);
      return byteArrayOutputStream.toByteArray();
    } catch (IOException iOException) {
      throw new AssertionError(iOException);
    } 
  }
  
  public static Record[] parseResponse(byte[] paramArrayOfbyte, int paramInt, String paramString) throws IOException {
    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(paramArrayOfbyte));
    int i = dataInputStream.readUnsignedShort();
    if (i == paramInt) {
      int j = dataInputStream.readUnsignedShort();
      i = 1;
      if ((j >> 8 & 0x1) == 1) {
        paramInt = 1;
      } else {
        paramInt = 0;
      } 
      if ((j >> 7 & 0x1) != 1)
        i = 0; 
      if (i != 0 && paramInt != 0) {
        paramInt = dataInputStream.readUnsignedShort();
        i = dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        dataInputStream.readUnsignedShort();
        readQuestions(dataInputStream, paramArrayOfbyte, paramInt);
        return readAnswers(dataInputStream, paramArrayOfbyte, i);
      } 
      throw new DnsException(paramString, "the dns server cant support recursion ");
    } 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("the answer id ");
    stringBuilder.append(i);
    stringBuilder.append(" is not match ");
    stringBuilder.append(paramInt);
    throw new DnsException(paramString, stringBuilder.toString());
  }
  
  private static Record[] readAnswers(DataInputStream paramDataInputStream, byte[] paramArrayOfbyte, int paramInt) throws IOException {
    Record[] arrayOfRecord = new Record[paramInt];
    int i = 0;
    while (paramInt > 0) {
      arrayOfRecord[i] = readRecord(paramDataInputStream, paramArrayOfbyte);
      i++;
      paramInt--;
    } 
    return arrayOfRecord;
  }
  
  private static String readName(DataInputStream paramDataInputStream, byte[] paramArrayOfbyte) throws IOException {
    HashSet<Integer> hashSet;
    int i = paramDataInputStream.readUnsignedByte();
    if ((i & 0xC0) == 192) {
      i = ((i & 0x3F) << 8) + paramDataInputStream.readUnsignedByte();
      hashSet = new HashSet();
      hashSet.add(Integer.valueOf(i));
      return readName(paramArrayOfbyte, i, hashSet);
    } 
    if (i == 0)
      return ""; 
    byte[] arrayOfByte = new byte[i];
    hashSet.readFully(arrayOfByte);
    String str3 = IDN.toUnicode(new String(arrayOfByte));
    String str2 = readName((DataInputStream)hashSet, paramArrayOfbyte);
    String str1 = str3;
    if (str2.length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append(".");
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  private static String readName(byte[] paramArrayOfbyte, int paramInt, HashSet<Integer> paramHashSet) throws IOException {
    int i = paramArrayOfbyte[paramInt] & 0xFF;
    if ((i & 0xC0) == 192) {
      paramInt = ((i & 0x3F) << 8) + (paramArrayOfbyte[paramInt + 1] & 0xFF);
      if (!paramHashSet.contains(Integer.valueOf(paramInt))) {
        paramHashSet.add(Integer.valueOf(paramInt));
        return readName(paramArrayOfbyte, paramInt, paramHashSet);
      } 
      throw new DnsException("", "Cyclic offsets detected.");
    } 
    if (i == 0)
      return ""; 
    String str3 = new String(paramArrayOfbyte, ++paramInt, i);
    String str2 = readName(paramArrayOfbyte, paramInt + i, paramHashSet);
    String str1 = str3;
    if (str2.length() > 0) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(str3);
      stringBuilder.append(".");
      stringBuilder.append(str2);
      str1 = stringBuilder.toString();
    } 
    return str1;
  }
  
  private static void readQuestions(DataInputStream paramDataInputStream, byte[] paramArrayOfbyte, int paramInt) throws IOException {
    while (paramInt > 0) {
      readName(paramDataInputStream, paramArrayOfbyte);
      paramDataInputStream.readUnsignedShort();
      paramDataInputStream.readUnsignedShort();
      paramInt--;
    } 
  }
  
  private static Record readRecord(DataInputStream paramDataInputStream, byte[] paramArrayOfbyte) throws IOException {
    String str;
    readName(paramDataInputStream, paramArrayOfbyte);
    int i = paramDataInputStream.readUnsignedShort();
    paramDataInputStream.readUnsignedShort();
    long l1 = paramDataInputStream.readUnsignedShort();
    long l2 = paramDataInputStream.readUnsignedShort();
    int j = paramDataInputStream.readUnsignedShort();
    if (i != 1) {
      if (i != 5) {
        for (int k = 0; k < j; k++)
          paramDataInputStream.readByte(); 
        paramDataInputStream = null;
      } else {
        str = readName(paramDataInputStream, paramArrayOfbyte);
      } 
    } else {
      paramArrayOfbyte = new byte[4];
      str.readFully(paramArrayOfbyte);
      str = InetAddress.getByAddress(paramArrayOfbyte).getHostAddress();
    } 
    if (str != null)
      return new Record(str, i, (int)((l1 << 16L) + l2), System.currentTimeMillis() / 1000L); 
    throw new UnknownHostException("no record");
  }
  
  private static void writeDomain(OutputStream paramOutputStream, String paramString) throws IOException {
    String[] arrayOfString = paramString.split("[.。．｡]");
    int j = arrayOfString.length;
    for (int i = 0; i < j; i++) {
      byte[] arrayOfByte = IDN.toASCII(arrayOfString[i]).getBytes();
      paramOutputStream.write(arrayOfByte.length);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
    } 
    paramOutputStream.write(0);
  }
  
  private static void writeQuestion(OutputStream paramOutputStream, String paramString) throws IOException {
    DataOutputStream dataOutputStream = new DataOutputStream(paramOutputStream);
    writeDomain(paramOutputStream, paramString);
    dataOutputStream.writeShort(1);
    dataOutputStream.writeShort(1);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\dns\local\DnsMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */