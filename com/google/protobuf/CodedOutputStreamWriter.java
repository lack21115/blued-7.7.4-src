package com.google.protobuf;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class CodedOutputStreamWriter implements Writer {
  private final CodedOutputStream output;
  
  private CodedOutputStreamWriter(CodedOutputStream paramCodedOutputStream) {
    this.output = Internal.<CodedOutputStream>checkNotNull(paramCodedOutputStream, "output");
    this.output.wrapper = this;
  }
  
  public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream paramCodedOutputStream) {
    return (paramCodedOutputStream.wrapper != null) ? paramCodedOutputStream.wrapper : new CodedOutputStreamWriter(paramCodedOutputStream);
  }
  
  private <V> void writeDeterministicBooleanMapEntry(int paramInt, boolean paramBoolean, V paramV, MapEntryLite.Metadata<Boolean, V> paramMetadata) throws IOException {
    this.output.writeTag(paramInt, 2);
    this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(paramMetadata, Boolean.valueOf(paramBoolean), paramV));
    MapEntryLite.writeTo(this.output, paramMetadata, Boolean.valueOf(paramBoolean), paramV);
  }
  
  private <V> void writeDeterministicIntegerMap(int paramInt, MapEntryLite.Metadata<Integer, V> paramMetadata, Map<Integer, V> paramMap) throws IOException {
    int[] arrayOfInt = new int[paramMap.size()];
    Iterator iterator = paramMap.keySet().iterator();
    int j = 0;
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfInt[i] = ((Integer)iterator.next()).intValue(); 
    Arrays.sort(arrayOfInt);
    int k = arrayOfInt.length;
    for (i = j; i < k; i++) {
      j = arrayOfInt[i];
      iterator = (Iterator)paramMap.get(Integer.valueOf(j));
      this.output.writeTag(paramInt, 2);
      this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(paramMetadata, Integer.valueOf(j), (V)iterator));
      MapEntryLite.writeTo(this.output, paramMetadata, Integer.valueOf(j), (V)iterator);
    } 
  }
  
  private <V> void writeDeterministicLongMap(int paramInt, MapEntryLite.Metadata<Long, V> paramMetadata, Map<Long, V> paramMap) throws IOException {
    long[] arrayOfLong = new long[paramMap.size()];
    Iterator iterator = paramMap.keySet().iterator();
    boolean bool = false;
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfLong[i] = ((Long)iterator.next()).longValue(); 
    Arrays.sort(arrayOfLong);
    int j = arrayOfLong.length;
    for (i = bool; i < j; i++) {
      long l = arrayOfLong[i];
      iterator = (Iterator)paramMap.get(Long.valueOf(l));
      this.output.writeTag(paramInt, 2);
      this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(paramMetadata, Long.valueOf(l), (V)iterator));
      MapEntryLite.writeTo(this.output, paramMetadata, Long.valueOf(l), (V)iterator);
    } 
  }
  
  private <K, V> void writeDeterministicMap(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap) throws IOException {
    switch (paramMetadata.keyType) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("does not support key type: ");
        stringBuilder.append(paramMetadata.keyType);
        throw new IllegalArgumentException(stringBuilder.toString());
      case null:
        writeDeterministicStringMap(paramInt, (MapEntryLite.Metadata)paramMetadata, (Map<String, V>)stringBuilder);
        return;
      case FIXED64:
      case INT64:
      case SFIXED64:
      case SINT64:
      case UINT64:
        writeDeterministicLongMap(paramInt, (MapEntryLite.Metadata)paramMetadata, (Map<Long, V>)stringBuilder);
        return;
      case FIXED32:
      case INT32:
      case SFIXED32:
      case SINT32:
      case UINT32:
        writeDeterministicIntegerMap(paramInt, (MapEntryLite.Metadata)paramMetadata, (Map<Integer, V>)stringBuilder);
        return;
      case BOOL:
        break;
    } 
    Object object = stringBuilder.get(Boolean.FALSE);
    if (object != null)
      writeDeterministicBooleanMapEntry(paramInt, false, object, (MapEntryLite.Metadata)paramMetadata); 
    StringBuilder stringBuilder = (StringBuilder)stringBuilder.get(Boolean.TRUE);
    if (stringBuilder != null)
      writeDeterministicBooleanMapEntry(paramInt, true, stringBuilder, (MapEntryLite.Metadata)paramMetadata); 
  }
  
  private <V> void writeDeterministicStringMap(int paramInt, MapEntryLite.Metadata<String, V> paramMetadata, Map<String, V> paramMap) throws IOException {
    String[] arrayOfString = new String[paramMap.size()];
    Iterator<String> iterator = paramMap.keySet().iterator();
    boolean bool = false;
    int i;
    for (i = 0; iterator.hasNext(); i++)
      arrayOfString[i] = iterator.next(); 
    Arrays.sort((Object[])arrayOfString);
    int j = arrayOfString.length;
    for (i = bool; i < j; i++) {
      String str = arrayOfString[i];
      V v = paramMap.get(str);
      this.output.writeTag(paramInt, 2);
      this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(paramMetadata, str, v));
      MapEntryLite.writeTo(this.output, paramMetadata, str, v);
    } 
  }
  
  private void writeLazyString(int paramInt, Object paramObject) throws IOException {
    if (paramObject instanceof String) {
      this.output.writeString(paramInt, (String)paramObject);
      return;
    } 
    this.output.writeBytes(paramInt, (ByteString)paramObject);
  }
  
  public Writer.FieldOrder fieldOrder() {
    return Writer.FieldOrder.ASCENDING;
  }
  
  public int getTotalBytesWritten() {
    return this.output.getTotalBytesWritten();
  }
  
  public void writeBool(int paramInt, boolean paramBoolean) throws IOException {
    this.output.writeBool(paramInt, paramBoolean);
  }
  
  public void writeBoolList(int paramInt, List<Boolean> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeBoolSizeNoTag(((Boolean)paramList.get(paramInt)).booleanValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeBoolNoTag(((Boolean)paramList.get(paramInt)).booleanValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeBool(paramInt, ((Boolean)paramList.get(i)).booleanValue());
        i++;
      } 
    } 
  }
  
  public void writeBytes(int paramInt, ByteString paramByteString) throws IOException {
    this.output.writeBytes(paramInt, paramByteString);
  }
  
  public void writeBytesList(int paramInt, List<ByteString> paramList) throws IOException {
    for (int i = 0; i < paramList.size(); i++)
      this.output.writeBytes(paramInt, paramList.get(i)); 
  }
  
  public void writeDouble(int paramInt, double paramDouble) throws IOException {
    this.output.writeDouble(paramInt, paramDouble);
  }
  
  public void writeDoubleList(int paramInt, List<Double> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeDoubleSizeNoTag(((Double)paramList.get(paramInt)).doubleValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeDoubleNoTag(((Double)paramList.get(paramInt)).doubleValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeDouble(paramInt, ((Double)paramList.get(i)).doubleValue());
        i++;
      } 
    } 
  }
  
  public void writeEndGroup(int paramInt) throws IOException {
    this.output.writeTag(paramInt, 4);
  }
  
  public void writeEnum(int paramInt1, int paramInt2) throws IOException {
    this.output.writeEnum(paramInt1, paramInt2);
  }
  
  public void writeEnumList(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeEnumSizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeEnumNoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeEnum(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeFixed32(int paramInt1, int paramInt2) throws IOException {
    this.output.writeFixed32(paramInt1, paramInt2);
  }
  
  public void writeFixed32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeFixed32SizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeFixed32NoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeFixed32(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeFixed64(int paramInt, long paramLong) throws IOException {
    this.output.writeFixed64(paramInt, paramLong);
  }
  
  public void writeFixed64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeFixed64SizeNoTag(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeFixed64NoTag(((Long)paramList.get(paramInt)).longValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeFixed64(paramInt, ((Long)paramList.get(i)).longValue());
        i++;
      } 
    } 
  }
  
  public void writeFloat(int paramInt, float paramFloat) throws IOException {
    this.output.writeFloat(paramInt, paramFloat);
  }
  
  public void writeFloatList(int paramInt, List<Float> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeFloatSizeNoTag(((Float)paramList.get(paramInt)).floatValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeFloatNoTag(((Float)paramList.get(paramInt)).floatValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeFloat(paramInt, ((Float)paramList.get(i)).floatValue());
        i++;
      } 
    } 
  }
  
  public void writeGroup(int paramInt, Object paramObject) throws IOException {
    this.output.writeGroup(paramInt, (MessageLite)paramObject);
  }
  
  public void writeGroup(int paramInt, Object paramObject, Schema paramSchema) throws IOException {
    this.output.writeGroup(paramInt, (MessageLite)paramObject, paramSchema);
  }
  
  public void writeGroupList(int paramInt, List<?> paramList) throws IOException {
    for (int i = 0; i < paramList.size(); i++)
      writeGroup(paramInt, paramList.get(i)); 
  }
  
  public void writeGroupList(int paramInt, List<?> paramList, Schema paramSchema) throws IOException {
    int i;
    for (i = 0; i < paramList.size(); i++)
      writeGroup(paramInt, paramList.get(i), paramSchema); 
  }
  
  public void writeInt32(int paramInt1, int paramInt2) throws IOException {
    this.output.writeInt32(paramInt1, paramInt2);
  }
  
  public void writeInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeInt32SizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeInt32NoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeInt32(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeInt64(int paramInt, long paramLong) throws IOException {
    this.output.writeInt64(paramInt, paramLong);
  }
  
  public void writeInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeInt64SizeNoTag(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeInt64NoTag(((Long)paramList.get(paramInt)).longValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeInt64(paramInt, ((Long)paramList.get(i)).longValue());
        i++;
      } 
    } 
  }
  
  public <K, V> void writeMap(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap) throws IOException {
    if (this.output.isSerializationDeterministic()) {
      writeDeterministicMap(paramInt, paramMetadata, paramMap);
      return;
    } 
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      this.output.writeTag(paramInt, 2);
      this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(paramMetadata, (K)entry.getKey(), (V)entry.getValue()));
      MapEntryLite.writeTo(this.output, paramMetadata, (K)entry.getKey(), (V)entry.getValue());
    } 
  }
  
  public void writeMessage(int paramInt, Object paramObject) throws IOException {
    this.output.writeMessage(paramInt, (MessageLite)paramObject);
  }
  
  public void writeMessage(int paramInt, Object paramObject, Schema paramSchema) throws IOException {
    this.output.writeMessage(paramInt, (MessageLite)paramObject, paramSchema);
  }
  
  public void writeMessageList(int paramInt, List<?> paramList) throws IOException {
    for (int i = 0; i < paramList.size(); i++)
      writeMessage(paramInt, paramList.get(i)); 
  }
  
  public void writeMessageList(int paramInt, List<?> paramList, Schema paramSchema) throws IOException {
    int i;
    for (i = 0; i < paramList.size(); i++)
      writeMessage(paramInt, paramList.get(i), paramSchema); 
  }
  
  public final void writeMessageSetItem(int paramInt, Object paramObject) throws IOException {
    if (paramObject instanceof ByteString) {
      this.output.writeRawMessageSetExtension(paramInt, (ByteString)paramObject);
      return;
    } 
    this.output.writeMessageSetExtension(paramInt, (MessageLite)paramObject);
  }
  
  public void writeSFixed32(int paramInt1, int paramInt2) throws IOException {
    this.output.writeSFixed32(paramInt1, paramInt2);
  }
  
  public void writeSFixed32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeSFixed32SizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeSFixed32NoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeSFixed32(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeSFixed64(int paramInt, long paramLong) throws IOException {
    this.output.writeSFixed64(paramInt, paramLong);
  }
  
  public void writeSFixed64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeSFixed64SizeNoTag(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeSFixed64NoTag(((Long)paramList.get(paramInt)).longValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeSFixed64(paramInt, ((Long)paramList.get(i)).longValue());
        i++;
      } 
    } 
  }
  
  public void writeSInt32(int paramInt1, int paramInt2) throws IOException {
    this.output.writeSInt32(paramInt1, paramInt2);
  }
  
  public void writeSInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeSInt32SizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeSInt32NoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeSInt32(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeSInt64(int paramInt, long paramLong) throws IOException {
    this.output.writeSInt64(paramInt, paramLong);
  }
  
  public void writeSInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeSInt64SizeNoTag(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeSInt64NoTag(((Long)paramList.get(paramInt)).longValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeSInt64(paramInt, ((Long)paramList.get(i)).longValue());
        i++;
      } 
    } 
  }
  
  public void writeStartGroup(int paramInt) throws IOException {
    this.output.writeTag(paramInt, 3);
  }
  
  public void writeString(int paramInt, String paramString) throws IOException {
    this.output.writeString(paramInt, paramString);
  }
  
  public void writeStringList(int paramInt, List<String> paramList) throws IOException {
    boolean bool = paramList instanceof LazyStringList;
    int i = 0;
    byte b = 0;
    if (bool) {
      LazyStringList lazyStringList = (LazyStringList)paramList;
      for (i = b; i < paramList.size(); i++)
        writeLazyString(paramInt, lazyStringList.getRaw(i)); 
    } else {
      while (i < paramList.size()) {
        this.output.writeString(paramInt, paramList.get(i));
        i++;
      } 
    } 
  }
  
  public void writeUInt32(int paramInt1, int paramInt2) throws IOException {
    this.output.writeUInt32(paramInt1, paramInt2);
  }
  
  public void writeUInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeUInt32SizeNoTag(((Integer)paramList.get(paramInt)).intValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeUInt32NoTag(((Integer)paramList.get(paramInt)).intValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeUInt32(paramInt, ((Integer)paramList.get(i)).intValue());
        i++;
      } 
    } 
  }
  
  public void writeUInt64(int paramInt, long paramLong) throws IOException {
    this.output.writeUInt64(paramInt, paramLong);
  }
  
  public void writeUInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    int i = 0;
    boolean bool = false;
    if (paramBoolean) {
      this.output.writeTag(paramInt, 2);
      paramInt = 0;
      i = 0;
      while (paramInt < paramList.size()) {
        i += CodedOutputStream.computeUInt64SizeNoTag(((Long)paramList.get(paramInt)).longValue());
        paramInt++;
      } 
      this.output.writeUInt32NoTag(i);
      for (paramInt = bool; paramInt < paramList.size(); paramInt++)
        this.output.writeUInt64NoTag(((Long)paramList.get(paramInt)).longValue()); 
    } else {
      while (i < paramList.size()) {
        this.output.writeUInt64(paramInt, ((Long)paramList.get(i)).longValue());
        i++;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\CodedOutputStreamWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */