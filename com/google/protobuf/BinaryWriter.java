package com.google.protobuf;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;

abstract class BinaryWriter extends ByteOutput implements Writer {
  public static final int DEFAULT_CHUNK_SIZE = 4096;
  
  private static final int MAP_KEY_NUMBER = 1;
  
  private static final int MAP_VALUE_NUMBER = 2;
  
  private final BufferAllocator alloc;
  
  final ArrayDeque<AllocatedBuffer> buffers = new ArrayDeque<AllocatedBuffer>(4);
  
  private final int chunkSize;
  
  int totalDoneBytes;
  
  private BinaryWriter(BufferAllocator paramBufferAllocator, int paramInt) {
    if (paramInt > 0) {
      this.alloc = Internal.<BufferAllocator>checkNotNull(paramBufferAllocator, "alloc");
      this.chunkSize = paramInt;
      return;
    } 
    throw new IllegalArgumentException("chunkSize must be > 0");
  }
  
  private static byte computeUInt64SizeNoTag(long paramLong) {
    if ((0xFFFFFFFFFFFFFF80L & paramLong) == 0L)
      return 1; 
    if (paramLong < 0L)
      return 10; 
    if ((0xFFFFFFF800000000L & paramLong) != 0L) {
      b2 = (byte)6;
      paramLong >>>= 28L;
    } else {
      b2 = 2;
    } 
    byte b1 = b2;
    long l = paramLong;
    if ((0xFFFFFFFFFFE00000L & paramLong) != 0L) {
      b1 = (byte)(b2 + 2);
      l = paramLong >>> 14L;
    } 
    byte b2 = b1;
    if ((l & 0xFFFFFFFFFFFFC000L) != 0L)
      b2 = (byte)(b1 + 1); 
    return b2;
  }
  
  static boolean isUnsafeDirectSupported() {
    return UnsafeDirectWriter.isSupported();
  }
  
  static boolean isUnsafeHeapSupported() {
    return UnsafeHeapWriter.isSupported();
  }
  
  public static BinaryWriter newDirectInstance(BufferAllocator paramBufferAllocator) {
    return newDirectInstance(paramBufferAllocator, 4096);
  }
  
  public static BinaryWriter newDirectInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    return isUnsafeDirectSupported() ? newUnsafeDirectInstance(paramBufferAllocator, paramInt) : newSafeDirectInstance(paramBufferAllocator, paramInt);
  }
  
  public static BinaryWriter newHeapInstance(BufferAllocator paramBufferAllocator) {
    return newHeapInstance(paramBufferAllocator, 4096);
  }
  
  public static BinaryWriter newHeapInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    return isUnsafeHeapSupported() ? newUnsafeHeapInstance(paramBufferAllocator, paramInt) : newSafeHeapInstance(paramBufferAllocator, paramInt);
  }
  
  static BinaryWriter newSafeDirectInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    return new SafeDirectWriter(paramBufferAllocator, paramInt);
  }
  
  static BinaryWriter newSafeHeapInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    return new SafeHeapWriter(paramBufferAllocator, paramInt);
  }
  
  static BinaryWriter newUnsafeDirectInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    if (isUnsafeDirectSupported())
      return new UnsafeDirectWriter(paramBufferAllocator, paramInt); 
    throw new UnsupportedOperationException("Unsafe operations not supported");
  }
  
  static BinaryWriter newUnsafeHeapInstance(BufferAllocator paramBufferAllocator, int paramInt) {
    if (isUnsafeHeapSupported())
      return new UnsafeHeapWriter(paramBufferAllocator, paramInt); 
    throw new UnsupportedOperationException("Unsafe operations not supported");
  }
  
  private final void writeBoolList_Internal(int paramInt, BooleanArrayList paramBooleanArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramBooleanArrayList.size() + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramBooleanArrayList.size() - 1; j >= 0; j--)
        writeBool(paramBooleanArrayList.getBoolean(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramBooleanArrayList.size() - 1; i >= 0; i--)
      writeBool(paramInt, paramBooleanArrayList.getBoolean(i)); 
  }
  
  private final void writeBoolList_Internal(int paramInt, List<Boolean> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeBool(((Boolean)paramList.get(j)).booleanValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeBool(paramInt, ((Boolean)paramList.get(i)).booleanValue()); 
  }
  
  private final void writeDoubleList_Internal(int paramInt, DoubleArrayList paramDoubleArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramDoubleArrayList.size() * 8 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramDoubleArrayList.size() - 1; j >= 0; j--)
        writeFixed64(Double.doubleToRawLongBits(paramDoubleArrayList.getDouble(j))); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramDoubleArrayList.size() - 1; i >= 0; i--)
      writeDouble(paramInt, paramDoubleArrayList.getDouble(i)); 
  }
  
  private final void writeDoubleList_Internal(int paramInt, List<Double> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 8 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeFixed64(Double.doubleToRawLongBits(((Double)paramList.get(j)).doubleValue())); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeDouble(paramInt, ((Double)paramList.get(i)).doubleValue()); 
  }
  
  private final void writeFixed32List_Internal(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramIntArrayList.size() * 4 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramIntArrayList.size() - 1; j >= 0; j--)
        writeFixed32(paramIntArrayList.getInt(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramIntArrayList.size() - 1; i >= 0; i--)
      writeFixed32(paramInt, paramIntArrayList.getInt(i)); 
  }
  
  private final void writeFixed32List_Internal(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 4 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeFixed32(((Integer)paramList.get(j)).intValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeFixed32(paramInt, ((Integer)paramList.get(i)).intValue()); 
  }
  
  private final void writeFixed64List_Internal(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramLongArrayList.size() * 8 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramLongArrayList.size() - 1; j >= 0; j--)
        writeFixed64(paramLongArrayList.getLong(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramLongArrayList.size() - 1; i >= 0; i--)
      writeFixed64(paramInt, paramLongArrayList.getLong(i)); 
  }
  
  private final void writeFixed64List_Internal(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 8 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeFixed64(((Long)paramList.get(j)).longValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeFixed64(paramInt, ((Long)paramList.get(i)).longValue()); 
  }
  
  private final void writeFloatList_Internal(int paramInt, FloatArrayList paramFloatArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramFloatArrayList.size() * 4 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramFloatArrayList.size() - 1; j >= 0; j--)
        writeFixed32(Float.floatToRawIntBits(paramFloatArrayList.getFloat(j))); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramFloatArrayList.size() - 1; i >= 0; i--)
      writeFloat(paramInt, paramFloatArrayList.getFloat(i)); 
  }
  
  private final void writeFloatList_Internal(int paramInt, List<Float> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 4 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeFixed32(Float.floatToRawIntBits(((Float)paramList.get(j)).floatValue())); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeFloat(paramInt, ((Float)paramList.get(i)).floatValue()); 
  }
  
  private final void writeInt32List_Internal(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramIntArrayList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramIntArrayList.size() - 1; j >= 0; j--)
        writeInt32(paramIntArrayList.getInt(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramIntArrayList.size() - 1; i >= 0; i--)
      writeInt32(paramInt, paramIntArrayList.getInt(i)); 
  }
  
  private final void writeInt32List_Internal(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeInt32(((Integer)paramList.get(j)).intValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeInt32(paramInt, ((Integer)paramList.get(i)).intValue()); 
  }
  
  private void writeLazyString(int paramInt, Object paramObject) throws IOException {
    if (paramObject instanceof String) {
      writeString(paramInt, (String)paramObject);
      return;
    } 
    writeBytes(paramInt, (ByteString)paramObject);
  }
  
  static final void writeMapEntryField(Writer paramWriter, int paramInt, WireFormat.FieldType paramFieldType, Object paramObject) throws IOException {
    StringBuilder stringBuilder;
    switch (paramFieldType) {
      default:
        stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported map value type for: ");
        stringBuilder.append(paramFieldType);
        throw new IllegalArgumentException(stringBuilder.toString());
      case null:
        if (paramObject instanceof Internal.EnumLite) {
          stringBuilder.writeEnum(paramInt, ((Internal.EnumLite)paramObject).getNumber());
          return;
        } 
        if (paramObject instanceof Integer) {
          stringBuilder.writeEnum(paramInt, ((Integer)paramObject).intValue());
          return;
        } 
        throw new IllegalArgumentException("Unexpected type for enum in map.");
      case BYTES:
        stringBuilder.writeBytes(paramInt, (ByteString)paramObject);
        return;
      case MESSAGE:
        stringBuilder.writeMessage(paramInt, paramObject);
        return;
      case DOUBLE:
        stringBuilder.writeDouble(paramInt, ((Double)paramObject).doubleValue());
        return;
      case FLOAT:
        stringBuilder.writeFloat(paramInt, ((Float)paramObject).floatValue());
        return;
      case UINT64:
        stringBuilder.writeUInt64(paramInt, ((Long)paramObject).longValue());
        return;
      case UINT32:
        stringBuilder.writeUInt32(paramInt, ((Integer)paramObject).intValue());
        return;
      case STRING:
        stringBuilder.writeString(paramInt, (String)paramObject);
        return;
      case SINT64:
        stringBuilder.writeSInt64(paramInt, ((Long)paramObject).longValue());
        return;
      case SINT32:
        stringBuilder.writeSInt32(paramInt, ((Integer)paramObject).intValue());
        return;
      case SFIXED64:
        stringBuilder.writeSFixed64(paramInt, ((Long)paramObject).longValue());
        return;
      case SFIXED32:
        stringBuilder.writeSFixed32(paramInt, ((Integer)paramObject).intValue());
        return;
      case INT64:
        stringBuilder.writeInt64(paramInt, ((Long)paramObject).longValue());
        return;
      case INT32:
        stringBuilder.writeInt32(paramInt, ((Integer)paramObject).intValue());
        return;
      case FIXED64:
        stringBuilder.writeFixed64(paramInt, ((Long)paramObject).longValue());
        return;
      case FIXED32:
        stringBuilder.writeFixed32(paramInt, ((Integer)paramObject).intValue());
        return;
      case BOOL:
        break;
    } 
    stringBuilder.writeBool(paramInt, ((Boolean)paramObject).booleanValue());
  }
  
  private final void writeSInt32List_Internal(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramIntArrayList.size() * 5 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramIntArrayList.size() - 1; j >= 0; j--)
        writeSInt32(paramIntArrayList.getInt(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramIntArrayList.size() - 1; i >= 0; i--)
      writeSInt32(paramInt, paramIntArrayList.getInt(i)); 
  }
  
  private final void writeSInt32List_Internal(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 5 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeSInt32(((Integer)paramList.get(j)).intValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeSInt32(paramInt, ((Integer)paramList.get(i)).intValue()); 
  }
  
  private final void writeSInt64List_Internal(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramLongArrayList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramLongArrayList.size() - 1; j >= 0; j--)
        writeSInt64(paramLongArrayList.getLong(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramLongArrayList.size() - 1; i >= 0; i--)
      writeSInt64(paramInt, paramLongArrayList.getLong(i)); 
  }
  
  private final void writeSInt64List_Internal(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeSInt64(((Long)paramList.get(j)).longValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeSInt64(paramInt, ((Long)paramList.get(i)).longValue()); 
  }
  
  private final void writeUInt32List_Internal(int paramInt, IntArrayList paramIntArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramIntArrayList.size() * 5 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramIntArrayList.size() - 1; j >= 0; j--)
        writeVarint32(paramIntArrayList.getInt(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramIntArrayList.size() - 1; i >= 0; i--)
      writeUInt32(paramInt, paramIntArrayList.getInt(i)); 
  }
  
  private final void writeUInt32List_Internal(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 5 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeVarint32(((Integer)paramList.get(j)).intValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeUInt32(paramInt, ((Integer)paramList.get(i)).intValue()); 
  }
  
  private final void writeUInt64List_Internal(int paramInt, LongArrayList paramLongArrayList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramLongArrayList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramLongArrayList.size() - 1; j >= 0; j--)
        writeVarint64(paramLongArrayList.getLong(j)); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramLongArrayList.size() - 1; i >= 0; i--)
      writeUInt64(paramInt, paramLongArrayList.getLong(i)); 
  }
  
  private final void writeUInt64List_Internal(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramBoolean) {
      requireSpace(paramList.size() * 10 + 10);
      int k = getTotalBytesWritten();
      int j;
      for (j = paramList.size() - 1; j >= 0; j--)
        writeVarint64(((Long)paramList.get(j)).longValue()); 
      writeVarint32(getTotalBytesWritten() - k);
      writeTag(paramInt, 2);
      return;
    } 
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeUInt64(paramInt, ((Long)paramList.get(i)).longValue()); 
  }
  
  public final Queue<AllocatedBuffer> complete() {
    finishCurrentBuffer();
    return this.buffers;
  }
  
  public final Writer.FieldOrder fieldOrder() {
    return Writer.FieldOrder.DESCENDING;
  }
  
  abstract void finishCurrentBuffer();
  
  public abstract int getTotalBytesWritten();
  
  final AllocatedBuffer newDirectBuffer() {
    return this.alloc.allocateDirectBuffer(this.chunkSize);
  }
  
  final AllocatedBuffer newDirectBuffer(int paramInt) {
    return this.alloc.allocateDirectBuffer(Math.max(paramInt, this.chunkSize));
  }
  
  final AllocatedBuffer newHeapBuffer() {
    return this.alloc.allocateHeapBuffer(this.chunkSize);
  }
  
  final AllocatedBuffer newHeapBuffer(int paramInt) {
    return this.alloc.allocateHeapBuffer(Math.max(paramInt, this.chunkSize));
  }
  
  abstract void requireSpace(int paramInt);
  
  abstract void writeBool(boolean paramBoolean);
  
  public final void writeBoolList(int paramInt, List<Boolean> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof BooleanArrayList) {
      writeBoolList_Internal(paramInt, (BooleanArrayList)paramList, paramBoolean);
      return;
    } 
    writeBoolList_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeBytesList(int paramInt, List<ByteString> paramList) throws IOException {
    for (int i = paramList.size() - 1; i >= 0; i--)
      writeBytes(paramInt, paramList.get(i)); 
  }
  
  public final void writeDouble(int paramInt, double paramDouble) throws IOException {
    writeFixed64(paramInt, Double.doubleToRawLongBits(paramDouble));
  }
  
  public final void writeDoubleList(int paramInt, List<Double> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof DoubleArrayList) {
      writeDoubleList_Internal(paramInt, (DoubleArrayList)paramList, paramBoolean);
      return;
    } 
    writeDoubleList_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeEnum(int paramInt1, int paramInt2) throws IOException {
    writeInt32(paramInt1, paramInt2);
  }
  
  public final void writeEnumList(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    writeInt32List(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeFixed32(int paramInt);
  
  public final void writeFixed32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof IntArrayList) {
      writeFixed32List_Internal(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    } 
    writeFixed32List_Internal(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeFixed64(long paramLong);
  
  public final void writeFixed64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof LongArrayList) {
      writeFixed64List_Internal(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    } 
    writeFixed64List_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeFloat(int paramInt, float paramFloat) throws IOException {
    writeFixed32(paramInt, Float.floatToRawIntBits(paramFloat));
  }
  
  public final void writeFloatList(int paramInt, List<Float> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof FloatArrayList) {
      writeFloatList_Internal(paramInt, (FloatArrayList)paramList, paramBoolean);
      return;
    } 
    writeFloatList_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeGroupList(int paramInt, List<?> paramList) throws IOException {
    for (int i = paramList.size() - 1; i >= 0; i--)
      writeGroup(paramInt, paramList.get(i)); 
  }
  
  public final void writeGroupList(int paramInt, List<?> paramList, Schema paramSchema) throws IOException {
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeGroup(paramInt, paramList.get(i), paramSchema); 
  }
  
  abstract void writeInt32(int paramInt);
  
  public final void writeInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof IntArrayList) {
      writeInt32List_Internal(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    } 
    writeInt32List_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeInt64(int paramInt, long paramLong) throws IOException {
    writeUInt64(paramInt, paramLong);
  }
  
  public final void writeInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    writeUInt64List(paramInt, paramList, paramBoolean);
  }
  
  public <K, V> void writeMap(int paramInt, MapEntryLite.Metadata<K, V> paramMetadata, Map<K, V> paramMap) throws IOException {
    for (Map.Entry<K, V> entry : paramMap.entrySet()) {
      int i = getTotalBytesWritten();
      writeMapEntryField(this, 2, paramMetadata.valueType, entry.getValue());
      writeMapEntryField(this, 1, paramMetadata.keyType, entry.getKey());
      writeVarint32(getTotalBytesWritten() - i);
      writeTag(paramInt, 2);
    } 
  }
  
  public final void writeMessageList(int paramInt, List<?> paramList) throws IOException {
    for (int i = paramList.size() - 1; i >= 0; i--)
      writeMessage(paramInt, paramList.get(i)); 
  }
  
  public final void writeMessageList(int paramInt, List<?> paramList, Schema paramSchema) throws IOException {
    int i;
    for (i = paramList.size() - 1; i >= 0; i--)
      writeMessage(paramInt, paramList.get(i), paramSchema); 
  }
  
  public final void writeMessageSetItem(int paramInt, Object paramObject) throws IOException {
    writeTag(1, 4);
    if (paramObject instanceof ByteString) {
      writeBytes(3, (ByteString)paramObject);
    } else {
      writeMessage(3, paramObject);
    } 
    writeUInt32(2, paramInt);
    writeTag(1, 3);
  }
  
  public final void writeSFixed32(int paramInt1, int paramInt2) throws IOException {
    writeFixed32(paramInt1, paramInt2);
  }
  
  public final void writeSFixed32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    writeFixed32List(paramInt, paramList, paramBoolean);
  }
  
  public final void writeSFixed64(int paramInt, long paramLong) throws IOException {
    writeFixed64(paramInt, paramLong);
  }
  
  public final void writeSFixed64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    writeFixed64List(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeSInt32(int paramInt);
  
  public final void writeSInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof IntArrayList) {
      writeSInt32List_Internal(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    } 
    writeSInt32List_Internal(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeSInt64(long paramLong);
  
  public final void writeSInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof LongArrayList) {
      writeSInt64List_Internal(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    } 
    writeSInt64List_Internal(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeString(String paramString);
  
  public final void writeStringList(int paramInt, List<String> paramList) throws IOException {
    if (paramList instanceof LazyStringList) {
      LazyStringList lazyStringList = (LazyStringList)paramList;
      for (int i = paramList.size() - 1; i >= 0; i--)
        writeLazyString(paramInt, lazyStringList.getRaw(i)); 
    } else {
      for (int i = paramList.size() - 1; i >= 0; i--)
        writeString(paramInt, paramList.get(i)); 
    } 
  }
  
  abstract void writeTag(int paramInt1, int paramInt2);
  
  public final void writeUInt32List(int paramInt, List<Integer> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof IntArrayList) {
      writeUInt32List_Internal(paramInt, (IntArrayList)paramList, paramBoolean);
      return;
    } 
    writeUInt32List_Internal(paramInt, paramList, paramBoolean);
  }
  
  public final void writeUInt64List(int paramInt, List<Long> paramList, boolean paramBoolean) throws IOException {
    if (paramList instanceof LongArrayList) {
      writeUInt64List_Internal(paramInt, (LongArrayList)paramList, paramBoolean);
      return;
    } 
    writeUInt64List_Internal(paramInt, paramList, paramBoolean);
  }
  
  abstract void writeVarint32(int paramInt);
  
  abstract void writeVarint64(long paramLong);
  
  static final class SafeDirectWriter extends BinaryWriter {
    private ByteBuffer buffer;
    
    private int limitMinusOne;
    
    private int pos;
    
    SafeDirectWriter(BufferAllocator param1BufferAllocator, int param1Int) {
      super(param1BufferAllocator, param1Int);
      nextBuffer();
    }
    
    private int bytesWrittenToCurrentBuffer() {
      return this.limitMinusOne - this.pos;
    }
    
    private void nextBuffer() {
      nextBuffer(newDirectBuffer());
    }
    
    private void nextBuffer(int param1Int) {
      nextBuffer(newDirectBuffer(param1Int));
    }
    
    private void nextBuffer(AllocatedBuffer param1AllocatedBuffer) {
      if (param1AllocatedBuffer.hasNioBuffer()) {
        ByteBuffer byteBuffer = param1AllocatedBuffer.nioBuffer();
        if (byteBuffer.isDirect()) {
          finishCurrentBuffer();
          this.buffers.addFirst(param1AllocatedBuffer);
          this.buffer = byteBuffer;
          ByteBuffer byteBuffer1 = this.buffer;
          byteBuffer1.limit(byteBuffer1.capacity());
          this.buffer.position(0);
          this.buffer.order(ByteOrder.LITTLE_ENDIAN);
          this.limitMinusOne = this.buffer.limit() - 1;
          this.pos = this.limitMinusOne;
          return;
        } 
        throw new RuntimeException("Allocator returned non-direct buffer");
      } 
      throw new RuntimeException("Allocated buffer does not have NIO buffer");
    }
    
    private int spaceLeft() {
      return this.pos + 1;
    }
    
    private void writeVarint32FiveBytes(int param1Int) {
      ByteBuffer byteBuffer = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, (byte)(param1Int >>> 28));
      this.pos -= 4;
      this.buffer.putInt(this.pos + 1, param1Int & 0x7F | 0x80 | (param1Int >>> 21 & 0x7F | 0x80) << 24 | (param1Int >>> 14 & 0x7F | 0x80) << 16 | (param1Int >>> 7 & 0x7F | 0x80) << 8);
    }
    
    private void writeVarint32FourBytes(int param1Int) {
      this.pos -= 4;
      this.buffer.putInt(this.pos + 1, param1Int & 0x7F | 0x80 | (0xFE00000 & param1Int) << 3 | (0x1FC000 & param1Int | 0x200000) << 2 | (param1Int & 0x3F80 | 0x4000) << 1);
    }
    
    private void writeVarint32OneByte(int param1Int) {
      ByteBuffer byteBuffer = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, (byte)param1Int);
    }
    
    private void writeVarint32ThreeBytes(int param1Int) {
      this.pos -= 3;
      this.buffer.putInt(this.pos, (param1Int & 0x7F | 0x80) << 8 | (0x1FC000 & param1Int) << 10 | (param1Int & 0x3F80 | 0x4000) << 9);
    }
    
    private void writeVarint32TwoBytes(int param1Int) {
      this.pos -= 2;
      this.buffer.putShort(this.pos + 1, (short)(param1Int & 0x7F | 0x80 | (param1Int & 0x3F80) << 1));
    }
    
    private void writeVarint64EightBytes(long param1Long) {
      this.pos -= 8;
      this.buffer.putLong(this.pos + 1, param1Long & 0x7FL | 0x80L | (0xFE000000000000L & param1Long) << 7L | (0x1FC0000000000L & param1Long | 0x2000000000000L) << 6L | (0x3F800000000L & param1Long | 0x40000000000L) << 5L | (0x7F0000000L & param1Long | 0x800000000L) << 4L | (0xFE00000L & param1Long | 0x10000000L) << 3L | (0x1FC000L & param1Long | 0x200000L) << 2L | (0x3F80L & param1Long | 0x4000L) << 1L);
    }
    
    private void writeVarint64EightBytesWithSign(long param1Long) {
      this.pos -= 8;
      this.buffer.putLong(this.pos + 1, param1Long & 0x7FL | 0x80L | (0xFE000000000000L & param1Long | 0x100000000000000L) << 7L | (0x1FC0000000000L & param1Long | 0x2000000000000L) << 6L | (0x3F800000000L & param1Long | 0x40000000000L) << 5L | (0x7F0000000L & param1Long | 0x800000000L) << 4L | (0xFE00000L & param1Long | 0x10000000L) << 3L | (0x1FC000L & param1Long | 0x200000L) << 2L | (0x3F80L & param1Long | 0x4000L) << 1L);
    }
    
    private void writeVarint64FiveBytes(long param1Long) {
      this.pos -= 5;
      this.buffer.putLong(this.pos - 2, (param1Long & 0x7FL | 0x80L) << 24L | (0x7F0000000L & param1Long) << 28L | (0xFE00000L & param1Long | 0x10000000L) << 27L | (0x1FC000L & param1Long | 0x200000L) << 26L | (0x3F80L & param1Long | 0x4000L) << 25L);
    }
    
    private void writeVarint64FourBytes(long param1Long) {
      writeVarint32FourBytes((int)param1Long);
    }
    
    private void writeVarint64NineBytes(long param1Long) {
      ByteBuffer byteBuffer = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, (byte)(int)(param1Long >>> 56L));
      writeVarint64EightBytesWithSign(param1Long & 0xFFFFFFFFFFFFFFL);
    }
    
    private void writeVarint64OneByte(long param1Long) {
      writeVarint32OneByte((int)param1Long);
    }
    
    private void writeVarint64SevenBytes(long param1Long) {
      this.pos -= 7;
      this.buffer.putLong(this.pos, (param1Long & 0x7FL | 0x80L) << 8L | (0x1FC0000000000L & param1Long) << 14L | (0x3F800000000L & param1Long | 0x40000000000L) << 13L | (0x7F0000000L & param1Long | 0x800000000L) << 12L | (0xFE00000L & param1Long | 0x10000000L) << 11L | (0x1FC000L & param1Long | 0x200000L) << 10L | (0x3F80L & param1Long | 0x4000L) << 9L);
    }
    
    private void writeVarint64SixBytes(long param1Long) {
      this.pos -= 6;
      this.buffer.putLong(this.pos - 1, (param1Long & 0x7FL | 0x80L) << 16L | (0x3F800000000L & param1Long) << 21L | (0x7F0000000L & param1Long | 0x800000000L) << 20L | (0xFE00000L & param1Long | 0x10000000L) << 19L | (0x1FC000L & param1Long | 0x200000L) << 18L | (0x3F80L & param1Long | 0x4000L) << 17L);
    }
    
    private void writeVarint64TenBytes(long param1Long) {
      ByteBuffer byteBuffer = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, (byte)(int)(param1Long >>> 63L));
      byteBuffer = this.buffer;
      i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, (byte)(int)(param1Long >>> 56L & 0x7FL | 0x80L));
      writeVarint64EightBytesWithSign(param1Long & 0xFFFFFFFFFFFFFFL);
    }
    
    private void writeVarint64ThreeBytes(long param1Long) {
      writeVarint32ThreeBytes((int)param1Long);
    }
    
    private void writeVarint64TwoBytes(long param1Long) {
      writeVarint32TwoBytes((int)param1Long);
    }
    
    void finishCurrentBuffer() {
      if (this.buffer != null) {
        this.totalDoneBytes += bytesWrittenToCurrentBuffer();
        this.buffer.position(this.pos + 1);
        this.buffer = null;
        this.pos = 0;
        this.limitMinusOne = 0;
      } 
    }
    
    public int getTotalBytesWritten() {
      return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
    }
    
    void requireSpace(int param1Int) {
      if (spaceLeft() < param1Int)
        nextBuffer(param1Int); 
    }
    
    public void write(byte param1Byte) {
      ByteBuffer byteBuffer = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      byteBuffer.put(i, param1Byte);
    }
    
    public void write(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i)
        nextBuffer(i); 
      this.pos -= i;
      this.buffer.position(this.pos + 1);
      this.buffer.put(param1ByteBuffer);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2)
        nextBuffer(param1Int2); 
      this.pos -= param1Int2;
      this.buffer.position(this.pos + 1);
      this.buffer.put(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public void writeBool(int param1Int, boolean param1Boolean) {
      requireSpace(6);
      write((byte)param1Boolean);
      writeTag(param1Int, 0);
    }
    
    void writeBool(boolean param1Boolean) {
      write((byte)param1Boolean);
    }
    
    public void writeBytes(int param1Int, ByteString param1ByteString) {
      try {
        param1ByteString.writeToReverse(this);
        requireSpace(10);
        writeVarint32(param1ByteString.size());
        writeTag(param1Int, 2);
        return;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public void writeEndGroup(int param1Int) {
      writeTag(param1Int, 4);
    }
    
    void writeFixed32(int param1Int) {
      this.pos -= 4;
      this.buffer.putInt(this.pos + 1, param1Int);
    }
    
    public void writeFixed32(int param1Int1, int param1Int2) {
      requireSpace(9);
      writeFixed32(param1Int2);
      writeTag(param1Int1, 5);
    }
    
    public void writeFixed64(int param1Int, long param1Long) {
      requireSpace(13);
      writeFixed64(param1Long);
      writeTag(param1Int, 1);
    }
    
    void writeFixed64(long param1Long) {
      this.pos -= 8;
      this.buffer.putLong(this.pos + 1, param1Long);
    }
    
    public void writeGroup(int param1Int, Object param1Object) throws IOException {
      writeTag(param1Int, 4);
      Protobuf.getInstance().writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    public void writeGroup(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      writeTag(param1Int, 4);
      param1Schema.writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    void writeInt32(int param1Int) {
      if (param1Int >= 0) {
        writeVarint32(param1Int);
        return;
      } 
      writeVarint64(param1Int);
    }
    
    public void writeInt32(int param1Int1, int param1Int2) {
      requireSpace(15);
      writeInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeLazy(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i) {
        this.totalDoneBytes += i;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ByteBuffer));
        nextBuffer();
        return;
      } 
      this.pos -= i;
      this.buffer.position(this.pos + 1);
      this.buffer.put(param1ByteBuffer);
    }
    
    public void writeLazy(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2) {
        this.totalDoneBytes += param1Int2;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ArrayOfbyte, param1Int1, param1Int2));
        nextBuffer();
        return;
      } 
      this.pos -= param1Int2;
      this.buffer.position(this.pos + 1);
      this.buffer.put(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public void writeMessage(int param1Int, Object param1Object) throws IOException {
      int i = getTotalBytesWritten();
      Protobuf.getInstance().writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    public void writeMessage(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      int i = getTotalBytesWritten();
      param1Schema.writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeSInt32(int param1Int) {
      writeVarint32(CodedOutputStream.encodeZigZag32(param1Int));
    }
    
    public void writeSInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeSInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeSInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeSInt64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeSInt64(long param1Long) {
      writeVarint64(CodedOutputStream.encodeZigZag64(param1Long));
    }
    
    public void writeStartGroup(int param1Int) {
      writeTag(param1Int, 3);
    }
    
    public void writeString(int param1Int, String param1String) {
      int i = getTotalBytesWritten();
      writeString(param1String);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeString(String param1String) {
      requireSpace(param1String.length());
      int i = param1String.length() - 1;
      this.pos -= i;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          this.buffer.put(this.pos + i, (byte)c);
          i--;
        } 
      } 
      if (i == -1) {
        this.pos--;
        return;
      } 
      this.pos += i;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          int j = this.pos;
          if (j >= 0) {
            ByteBuffer byteBuffer = this.buffer;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)c);
            continue;
          } 
        } 
        if (c < 'ࠀ') {
          int j = this.pos;
          if (j > 0) {
            ByteBuffer byteBuffer = this.buffer;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)(c & 0x3F | 0x80));
            byteBuffer = this.buffer;
            j = this.pos;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)(c >>> 6 | 0x3C0));
            continue;
          } 
        } 
        if (c < '?' || '?' < c) {
          int j = this.pos;
          if (j > 1) {
            ByteBuffer byteBuffer = this.buffer;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)(c & 0x3F | 0x80));
            byteBuffer = this.buffer;
            j = this.pos;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)(c >>> 6 & 0x3F | 0x80));
            byteBuffer = this.buffer;
            j = this.pos;
            this.pos = j - 1;
            byteBuffer.put(j, (byte)(c >>> 12 | 0x1E0));
            continue;
          } 
        } 
        if (this.pos > 2) {
          if (i != 0) {
            char c1 = param1String.charAt(i - 1);
            if (Character.isSurrogatePair(c1, c)) {
              i--;
              int j = Character.toCodePoint(c1, c);
              ByteBuffer byteBuffer = this.buffer;
              int k = this.pos;
              this.pos = k - 1;
              byteBuffer.put(k, (byte)(j & 0x3F | 0x80));
              byteBuffer = this.buffer;
              k = this.pos;
              this.pos = k - 1;
              byteBuffer.put(k, (byte)(j >>> 6 & 0x3F | 0x80));
              byteBuffer = this.buffer;
              k = this.pos;
              this.pos = k - 1;
              byteBuffer.put(k, (byte)(j >>> 12 & 0x3F | 0x80));
              byteBuffer = this.buffer;
              k = this.pos;
              this.pos = k - 1;
              byteBuffer.put(k, (byte)(j >>> 18 | 0xF0));
            } else {
              throw new Utf8.UnpairedSurrogateException(i - 1, i);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
          } 
        } else {
          requireSpace(i);
          i++;
        } 
        continue;
        i--;
      } 
    }
    
    void writeTag(int param1Int1, int param1Int2) {
      writeVarint32(WireFormat.makeTag(param1Int1, param1Int2));
    }
    
    public void writeUInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeVarint32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeUInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeVarint64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeVarint32(int param1Int) {
      if ((param1Int & 0xFFFFFF80) == 0) {
        writeVarint32OneByte(param1Int);
        return;
      } 
      if ((param1Int & 0xFFFFC000) == 0) {
        writeVarint32TwoBytes(param1Int);
        return;
      } 
      if ((0xFFE00000 & param1Int) == 0) {
        writeVarint32ThreeBytes(param1Int);
        return;
      } 
      if ((0xF0000000 & param1Int) == 0) {
        writeVarint32FourBytes(param1Int);
        return;
      } 
      writeVarint32FiveBytes(param1Int);
    }
    
    void writeVarint64(long param1Long) {
      switch (BinaryWriter.computeUInt64SizeNoTag(param1Long)) {
        default:
          return;
        case 10:
          writeVarint64TenBytes(param1Long);
          return;
        case 9:
          writeVarint64NineBytes(param1Long);
          return;
        case 8:
          writeVarint64EightBytes(param1Long);
          return;
        case 7:
          writeVarint64SevenBytes(param1Long);
          return;
        case 6:
          writeVarint64SixBytes(param1Long);
          return;
        case 5:
          writeVarint64FiveBytes(param1Long);
          return;
        case 4:
          writeVarint64FourBytes(param1Long);
          return;
        case 3:
          writeVarint64ThreeBytes(param1Long);
          return;
        case 2:
          writeVarint64TwoBytes(param1Long);
          return;
        case 1:
          break;
      } 
      writeVarint64OneByte(param1Long);
    }
  }
  
  static final class SafeHeapWriter extends BinaryWriter {
    private AllocatedBuffer allocatedBuffer;
    
    private byte[] buffer;
    
    private int limit;
    
    private int limitMinusOne;
    
    private int offset;
    
    private int offsetMinusOne;
    
    private int pos;
    
    SafeHeapWriter(BufferAllocator param1BufferAllocator, int param1Int) {
      super(param1BufferAllocator, param1Int);
      nextBuffer();
    }
    
    private void nextBuffer() {
      nextBuffer(newHeapBuffer());
    }
    
    private void nextBuffer(int param1Int) {
      nextBuffer(newHeapBuffer(param1Int));
    }
    
    private void nextBuffer(AllocatedBuffer param1AllocatedBuffer) {
      if (param1AllocatedBuffer.hasArray()) {
        finishCurrentBuffer();
        this.buffers.addFirst(param1AllocatedBuffer);
        this.allocatedBuffer = param1AllocatedBuffer;
        this.buffer = param1AllocatedBuffer.array();
        int i = param1AllocatedBuffer.arrayOffset();
        this.limit = param1AllocatedBuffer.limit() + i;
        this.offset = i + param1AllocatedBuffer.position();
        this.offsetMinusOne = this.offset - 1;
        this.limitMinusOne = this.limit - 1;
        this.pos = this.limitMinusOne;
        return;
      } 
      throw new RuntimeException("Allocator returned non-heap buffer");
    }
    
    private void writeVarint32FiveBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 28);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 21 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 14 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 7 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int & 0x7F | 0x80);
    }
    
    private void writeVarint32FourBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 21);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 14 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 7 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int & 0x7F | 0x80);
    }
    
    private void writeVarint32OneByte(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)param1Int;
    }
    
    private void writeVarint32ThreeBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 14);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 7 & 0x7F | 0x80);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int & 0x7F | 0x80);
    }
    
    private void writeVarint32TwoBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >>> 7);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int & 0x7F | 0x80);
    }
    
    private void writeVarint64EightBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 49L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64FiveBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64FourBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64NineBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 56L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64OneByte(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)param1Long;
    }
    
    private void writeVarint64SevenBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 42L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64SixBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 35L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64TenBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 63L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 56L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64ThreeBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)param1Long >>> 14);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long & 0x7FL | 0x80L);
    }
    
    private void writeVarint64TwoBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(int)(param1Long >>> 7L);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)param1Long & 0x7F | 0x80);
    }
    
    int bytesWrittenToCurrentBuffer() {
      return this.limitMinusOne - this.pos;
    }
    
    void finishCurrentBuffer() {
      if (this.allocatedBuffer != null) {
        this.totalDoneBytes += bytesWrittenToCurrentBuffer();
        AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
        allocatedBuffer.position(this.pos - allocatedBuffer.arrayOffset() + 1);
        this.allocatedBuffer = null;
        this.pos = 0;
        this.limitMinusOne = 0;
      } 
    }
    
    public int getTotalBytesWritten() {
      return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
    }
    
    void requireSpace(int param1Int) {
      if (spaceLeft() < param1Int)
        nextBuffer(param1Int); 
    }
    
    int spaceLeft() {
      return this.pos - this.offsetMinusOne;
    }
    
    public void write(byte param1Byte) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = param1Byte;
    }
    
    public void write(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i)
        nextBuffer(i); 
      this.pos -= i;
      param1ByteBuffer.get(this.buffer, this.pos + 1, i);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2)
        nextBuffer(param1Int2); 
      this.pos -= param1Int2;
      System.arraycopy(param1ArrayOfbyte, param1Int1, this.buffer, this.pos + 1, param1Int2);
    }
    
    public void writeBool(int param1Int, boolean param1Boolean) throws IOException {
      requireSpace(6);
      write((byte)param1Boolean);
      writeTag(param1Int, 0);
    }
    
    void writeBool(boolean param1Boolean) {
      write((byte)param1Boolean);
    }
    
    public void writeBytes(int param1Int, ByteString param1ByteString) throws IOException {
      try {
        param1ByteString.writeToReverse(this);
        requireSpace(10);
        writeVarint32(param1ByteString.size());
        writeTag(param1Int, 2);
        return;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public void writeEndGroup(int param1Int) {
      writeTag(param1Int, 4);
    }
    
    void writeFixed32(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >> 24 & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >> 16 & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int >> 8 & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)(param1Int & 0xFF);
    }
    
    public void writeFixed32(int param1Int1, int param1Int2) throws IOException {
      requireSpace(9);
      writeFixed32(param1Int2);
      writeTag(param1Int1, 5);
    }
    
    public void writeFixed64(int param1Int, long param1Long) throws IOException {
      requireSpace(13);
      writeFixed64(param1Long);
      writeTag(param1Int, 1);
    }
    
    void writeFixed64(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      int i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 56L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 48L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 40L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 32L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 24L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 16L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)(param1Long >> 8L) & 0xFF);
      i = this.pos;
      this.pos = i - 1;
      arrayOfByte[i] = (byte)((int)param1Long & 0xFF);
    }
    
    public void writeGroup(int param1Int, Object param1Object) throws IOException {
      writeTag(param1Int, 4);
      Protobuf.getInstance().writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    public void writeGroup(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      writeTag(param1Int, 4);
      param1Schema.writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    void writeInt32(int param1Int) {
      if (param1Int >= 0) {
        writeVarint32(param1Int);
        return;
      } 
      writeVarint64(param1Int);
    }
    
    public void writeInt32(int param1Int1, int param1Int2) throws IOException {
      requireSpace(15);
      writeInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeLazy(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i) {
        this.totalDoneBytes += i;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ByteBuffer));
        nextBuffer();
      } 
      this.pos -= i;
      param1ByteBuffer.get(this.buffer, this.pos + 1, i);
    }
    
    public void writeLazy(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2) {
        this.totalDoneBytes += param1Int2;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ArrayOfbyte, param1Int1, param1Int2));
        nextBuffer();
        return;
      } 
      this.pos -= param1Int2;
      System.arraycopy(param1ArrayOfbyte, param1Int1, this.buffer, this.pos + 1, param1Int2);
    }
    
    public void writeMessage(int param1Int, Object param1Object) throws IOException {
      int i = getTotalBytesWritten();
      Protobuf.getInstance().writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    public void writeMessage(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      int i = getTotalBytesWritten();
      param1Schema.writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeSInt32(int param1Int) {
      writeVarint32(CodedOutputStream.encodeZigZag32(param1Int));
    }
    
    public void writeSInt32(int param1Int1, int param1Int2) throws IOException {
      requireSpace(10);
      writeSInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeSInt64(int param1Int, long param1Long) throws IOException {
      requireSpace(15);
      writeSInt64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeSInt64(long param1Long) {
      writeVarint64(CodedOutputStream.encodeZigZag64(param1Long));
    }
    
    public void writeStartGroup(int param1Int) {
      writeTag(param1Int, 3);
    }
    
    public void writeString(int param1Int, String param1String) throws IOException {
      int i = getTotalBytesWritten();
      writeString(param1String);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeString(String param1String) {
      requireSpace(param1String.length());
      int i = param1String.length() - 1;
      this.pos -= i;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          this.buffer[this.pos + i] = (byte)c;
          i--;
        } 
      } 
      if (i == -1) {
        this.pos--;
        return;
      } 
      this.pos += i;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          int j = this.pos;
          if (j > this.offsetMinusOne) {
            byte[] arrayOfByte = this.buffer;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)c;
            continue;
          } 
        } 
        if (c < 'ࠀ') {
          int j = this.pos;
          if (j > this.offset) {
            byte[] arrayOfByte = this.buffer;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)(c & 0x3F | 0x80);
            j = this.pos;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)(c >>> 6 | 0x3C0);
            continue;
          } 
        } 
        if (c < '?' || '?' < c) {
          int j = this.pos;
          if (j > this.offset + 1) {
            byte[] arrayOfByte = this.buffer;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)(c & 0x3F | 0x80);
            j = this.pos;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)(c >>> 6 & 0x3F | 0x80);
            j = this.pos;
            this.pos = j - 1;
            arrayOfByte[j] = (byte)(c >>> 12 | 0x1E0);
            continue;
          } 
        } 
        if (this.pos > this.offset + 2) {
          if (i != 0) {
            char c1 = param1String.charAt(i - 1);
            if (Character.isSurrogatePair(c1, c)) {
              i--;
              int j = Character.toCodePoint(c1, c);
              byte[] arrayOfByte = this.buffer;
              int k = this.pos;
              this.pos = k - 1;
              arrayOfByte[k] = (byte)(j & 0x3F | 0x80);
              k = this.pos;
              this.pos = k - 1;
              arrayOfByte[k] = (byte)(j >>> 6 & 0x3F | 0x80);
              k = this.pos;
              this.pos = k - 1;
              arrayOfByte[k] = (byte)(j >>> 12 & 0x3F | 0x80);
              k = this.pos;
              this.pos = k - 1;
              arrayOfByte[k] = (byte)(j >>> 18 | 0xF0);
            } else {
              throw new Utf8.UnpairedSurrogateException(i - 1, i);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(i - 1, i);
          } 
        } else {
          requireSpace(i);
          i++;
        } 
        continue;
        i--;
      } 
    }
    
    void writeTag(int param1Int1, int param1Int2) {
      writeVarint32(WireFormat.makeTag(param1Int1, param1Int2));
    }
    
    public void writeUInt32(int param1Int1, int param1Int2) throws IOException {
      requireSpace(10);
      writeVarint32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeUInt64(int param1Int, long param1Long) throws IOException {
      requireSpace(15);
      writeVarint64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeVarint32(int param1Int) {
      if ((param1Int & 0xFFFFFF80) == 0) {
        writeVarint32OneByte(param1Int);
        return;
      } 
      if ((param1Int & 0xFFFFC000) == 0) {
        writeVarint32TwoBytes(param1Int);
        return;
      } 
      if ((0xFFE00000 & param1Int) == 0) {
        writeVarint32ThreeBytes(param1Int);
        return;
      } 
      if ((0xF0000000 & param1Int) == 0) {
        writeVarint32FourBytes(param1Int);
        return;
      } 
      writeVarint32FiveBytes(param1Int);
    }
    
    void writeVarint64(long param1Long) {
      switch (BinaryWriter.computeUInt64SizeNoTag(param1Long)) {
        default:
          return;
        case 10:
          writeVarint64TenBytes(param1Long);
          return;
        case 9:
          writeVarint64NineBytes(param1Long);
          return;
        case 8:
          writeVarint64EightBytes(param1Long);
          return;
        case 7:
          writeVarint64SevenBytes(param1Long);
          return;
        case 6:
          writeVarint64SixBytes(param1Long);
          return;
        case 5:
          writeVarint64FiveBytes(param1Long);
          return;
        case 4:
          writeVarint64FourBytes(param1Long);
          return;
        case 3:
          writeVarint64ThreeBytes(param1Long);
          return;
        case 2:
          writeVarint64TwoBytes(param1Long);
          return;
        case 1:
          break;
      } 
      writeVarint64OneByte(param1Long);
    }
  }
  
  static final class UnsafeDirectWriter extends BinaryWriter {
    private ByteBuffer buffer;
    
    private long bufferOffset;
    
    private long limitMinusOne;
    
    private long pos;
    
    UnsafeDirectWriter(BufferAllocator param1BufferAllocator, int param1Int) {
      super(param1BufferAllocator, param1Int);
      nextBuffer();
    }
    
    private int bufferPos() {
      return (int)(this.pos - this.bufferOffset);
    }
    
    private int bytesWrittenToCurrentBuffer() {
      return (int)(this.limitMinusOne - this.pos);
    }
    
    private static boolean isSupported() {
      return UnsafeUtil.hasUnsafeByteBufferOperations();
    }
    
    private void nextBuffer() {
      nextBuffer(newDirectBuffer());
    }
    
    private void nextBuffer(int param1Int) {
      nextBuffer(newDirectBuffer(param1Int));
    }
    
    private void nextBuffer(AllocatedBuffer param1AllocatedBuffer) {
      if (param1AllocatedBuffer.hasNioBuffer()) {
        ByteBuffer byteBuffer = param1AllocatedBuffer.nioBuffer();
        if (byteBuffer.isDirect()) {
          finishCurrentBuffer();
          this.buffers.addFirst(param1AllocatedBuffer);
          this.buffer = byteBuffer;
          ByteBuffer byteBuffer1 = this.buffer;
          byteBuffer1.limit(byteBuffer1.capacity());
          this.buffer.position(0);
          this.bufferOffset = UnsafeUtil.addressOffset(this.buffer);
          this.limitMinusOne = this.bufferOffset + (this.buffer.limit() - 1);
          this.pos = this.limitMinusOne;
          return;
        } 
        throw new RuntimeException("Allocator returned non-direct buffer");
      } 
      throw new RuntimeException("Allocated buffer does not have NIO buffer");
    }
    
    private int spaceLeft() {
      return bufferPos() + 1;
    }
    
    private void writeVarint32FiveBytes(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 28));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 21 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 14 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32FourBytes(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 21));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 14 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32OneByte(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)param1Int);
    }
    
    private void writeVarint32ThreeBytes(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 14));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32TwoBytes(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >>> 7));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint64EightBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 49L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64FiveBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64FourBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64NineBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 56L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64OneByte(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)param1Long);
    }
    
    private void writeVarint64SevenBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 42L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64SixBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 35L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64TenBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 63L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 56L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64ThreeBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)param1Long >>> 14));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64TwoBytes(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(int)(param1Long >>> 7L));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)param1Long & 0x7F | 0x80));
    }
    
    void finishCurrentBuffer() {
      if (this.buffer != null) {
        this.totalDoneBytes += bytesWrittenToCurrentBuffer();
        this.buffer.position(bufferPos() + 1);
        this.buffer = null;
        this.pos = 0L;
        this.limitMinusOne = 0L;
      } 
    }
    
    public int getTotalBytesWritten() {
      return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
    }
    
    void requireSpace(int param1Int) {
      if (spaceLeft() < param1Int)
        nextBuffer(param1Int); 
    }
    
    public void write(byte param1Byte) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, param1Byte);
    }
    
    public void write(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i)
        nextBuffer(i); 
      this.pos -= i;
      this.buffer.position(bufferPos() + 1);
      this.buffer.put(param1ByteBuffer);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2)
        nextBuffer(param1Int2); 
      this.pos -= param1Int2;
      this.buffer.position(bufferPos() + 1);
      this.buffer.put(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public void writeBool(int param1Int, boolean param1Boolean) {
      requireSpace(6);
      write((byte)param1Boolean);
      writeTag(param1Int, 0);
    }
    
    void writeBool(boolean param1Boolean) {
      write((byte)param1Boolean);
    }
    
    public void writeBytes(int param1Int, ByteString param1ByteString) {
      try {
        param1ByteString.writeToReverse(this);
        requireSpace(10);
        writeVarint32(param1ByteString.size());
        writeTag(param1Int, 2);
        return;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public void writeEndGroup(int param1Int) {
      writeTag(param1Int, 4);
    }
    
    void writeFixed32(int param1Int) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >> 24 & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >> 16 & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int >> 8 & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)(param1Int & 0xFF));
    }
    
    public void writeFixed32(int param1Int1, int param1Int2) {
      requireSpace(9);
      writeFixed32(param1Int2);
      writeTag(param1Int1, 5);
    }
    
    public void writeFixed64(int param1Int, long param1Long) {
      requireSpace(13);
      writeFixed64(param1Long);
      writeTag(param1Int, 1);
    }
    
    void writeFixed64(long param1Long) {
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 56L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 48L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 40L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 32L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 24L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 16L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)(param1Long >> 8L) & 0xFF));
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(l, (byte)((int)param1Long & 0xFF));
    }
    
    public void writeGroup(int param1Int, Object param1Object) throws IOException {
      writeTag(param1Int, 4);
      Protobuf.getInstance().writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    public void writeGroup(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      writeTag(param1Int, 4);
      param1Schema.writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    void writeInt32(int param1Int) {
      if (param1Int >= 0) {
        writeVarint32(param1Int);
        return;
      } 
      writeVarint64(param1Int);
    }
    
    public void writeInt32(int param1Int1, int param1Int2) {
      requireSpace(15);
      writeInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeLazy(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i) {
        this.totalDoneBytes += i;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ByteBuffer));
        nextBuffer();
        return;
      } 
      this.pos -= i;
      this.buffer.position(bufferPos() + 1);
      this.buffer.put(param1ByteBuffer);
    }
    
    public void writeLazy(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (spaceLeft() < param1Int2) {
        this.totalDoneBytes += param1Int2;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ArrayOfbyte, param1Int1, param1Int2));
        nextBuffer();
        return;
      } 
      this.pos -= param1Int2;
      this.buffer.position(bufferPos() + 1);
      this.buffer.put(param1ArrayOfbyte, param1Int1, param1Int2);
    }
    
    public void writeMessage(int param1Int, Object param1Object) throws IOException {
      int i = getTotalBytesWritten();
      Protobuf.getInstance().writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    public void writeMessage(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      int i = getTotalBytesWritten();
      param1Schema.writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeSInt32(int param1Int) {
      writeVarint32(CodedOutputStream.encodeZigZag32(param1Int));
    }
    
    public void writeSInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeSInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeSInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeSInt64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeSInt64(long param1Long) {
      writeVarint64(CodedOutputStream.encodeZigZag64(param1Long));
    }
    
    public void writeStartGroup(int param1Int) {
      writeTag(param1Int, 3);
    }
    
    public void writeString(int param1Int, String param1String) {
      int i = getTotalBytesWritten();
      writeString(param1String);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeString(String param1String) {
      requireSpace(param1String.length());
      int i = param1String.length() - 1;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          long l = this.pos;
          this.pos = l - 1L;
          UnsafeUtil.putByte(l, (byte)c);
          i--;
        } 
      } 
      int j = i;
      if (i == -1)
        return; 
      while (j >= 0) {
        char c = param1String.charAt(j);
        if (c < '') {
          long l = this.pos;
          if (l >= this.bufferOffset) {
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)c);
            continue;
          } 
        } 
        if (c < 'ࠀ') {
          long l = this.pos;
          if (l > this.bufferOffset) {
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)(c & 0x3F | 0x80));
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)(c >>> 6 | 0x3C0));
            continue;
          } 
        } 
        if (c < '?' || '?' < c) {
          long l = this.pos;
          if (l > this.bufferOffset + 1L) {
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)(c & 0x3F | 0x80));
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)(c >>> 6 & 0x3F | 0x80));
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(l, (byte)(c >>> 12 | 0x1E0));
            continue;
          } 
        } 
        if (this.pos > this.bufferOffset + 2L) {
          if (j != 0) {
            char c1 = param1String.charAt(j - 1);
            if (Character.isSurrogatePair(c1, c)) {
              j--;
              i = Character.toCodePoint(c1, c);
              long l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(l, (byte)(i & 0x3F | 0x80));
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(l, (byte)(i >>> 6 & 0x3F | 0x80));
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(l, (byte)(i >>> 12 & 0x3F | 0x80));
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(l, (byte)(i >>> 18 | 0xF0));
            } else {
              throw new Utf8.UnpairedSurrogateException(j - 1, j);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(j - 1, j);
          } 
        } else {
          requireSpace(j);
          j++;
        } 
        continue;
        j--;
      } 
    }
    
    void writeTag(int param1Int1, int param1Int2) {
      writeVarint32(WireFormat.makeTag(param1Int1, param1Int2));
    }
    
    public void writeUInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeVarint32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeUInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeVarint64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeVarint32(int param1Int) {
      if ((param1Int & 0xFFFFFF80) == 0) {
        writeVarint32OneByte(param1Int);
        return;
      } 
      if ((param1Int & 0xFFFFC000) == 0) {
        writeVarint32TwoBytes(param1Int);
        return;
      } 
      if ((0xFFE00000 & param1Int) == 0) {
        writeVarint32ThreeBytes(param1Int);
        return;
      } 
      if ((0xF0000000 & param1Int) == 0) {
        writeVarint32FourBytes(param1Int);
        return;
      } 
      writeVarint32FiveBytes(param1Int);
    }
    
    void writeVarint64(long param1Long) {
      switch (BinaryWriter.computeUInt64SizeNoTag(param1Long)) {
        default:
          return;
        case 10:
          writeVarint64TenBytes(param1Long);
          return;
        case 9:
          writeVarint64NineBytes(param1Long);
          return;
        case 8:
          writeVarint64EightBytes(param1Long);
          return;
        case 7:
          writeVarint64SevenBytes(param1Long);
          return;
        case 6:
          writeVarint64SixBytes(param1Long);
          return;
        case 5:
          writeVarint64FiveBytes(param1Long);
          return;
        case 4:
          writeVarint64FourBytes(param1Long);
          return;
        case 3:
          writeVarint64ThreeBytes(param1Long);
          return;
        case 2:
          writeVarint64TwoBytes(param1Long);
          return;
        case 1:
          break;
      } 
      writeVarint64OneByte(param1Long);
    }
  }
  
  static final class UnsafeHeapWriter extends BinaryWriter {
    private AllocatedBuffer allocatedBuffer;
    
    private byte[] buffer;
    
    private long limit;
    
    private long limitMinusOne;
    
    private long offset;
    
    private long offsetMinusOne;
    
    private long pos;
    
    UnsafeHeapWriter(BufferAllocator param1BufferAllocator, int param1Int) {
      super(param1BufferAllocator, param1Int);
      nextBuffer();
    }
    
    private int arrayPos() {
      return (int)this.pos;
    }
    
    static boolean isSupported() {
      return UnsafeUtil.hasUnsafeArrayOperations();
    }
    
    private void nextBuffer() {
      nextBuffer(newHeapBuffer());
    }
    
    private void nextBuffer(int param1Int) {
      nextBuffer(newHeapBuffer(param1Int));
    }
    
    private void nextBuffer(AllocatedBuffer param1AllocatedBuffer) {
      if (param1AllocatedBuffer.hasArray()) {
        finishCurrentBuffer();
        this.buffers.addFirst(param1AllocatedBuffer);
        this.allocatedBuffer = param1AllocatedBuffer;
        this.buffer = param1AllocatedBuffer.array();
        int i = param1AllocatedBuffer.arrayOffset();
        this.limit = (param1AllocatedBuffer.limit() + i);
        this.offset = (i + param1AllocatedBuffer.position());
        this.offsetMinusOne = this.offset - 1L;
        this.limitMinusOne = this.limit - 1L;
        this.pos = this.limitMinusOne;
        return;
      } 
      throw new RuntimeException("Allocator returned non-heap buffer");
    }
    
    private void writeVarint32FiveBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 28));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 21 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 14 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32FourBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 21));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 14 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32OneByte(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)param1Int);
    }
    
    private void writeVarint32ThreeBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 14));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 7 & 0x7F | 0x80));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint32TwoBytes(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >>> 7));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int & 0x7F | 0x80));
    }
    
    private void writeVarint64EightBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 49L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64FiveBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64FourBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64NineBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 56L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64OneByte(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)param1Long);
    }
    
    private void writeVarint64SevenBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 42L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64SixBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 35L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64TenBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 63L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 56L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 49L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 42L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 35L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 28L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 21L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 14L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64ThreeBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)param1Long >>> 14));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L & 0x7FL | 0x80L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long & 0x7FL | 0x80L));
    }
    
    private void writeVarint64TwoBytes(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(int)(param1Long >>> 7L));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)param1Long & 0x7F | 0x80));
    }
    
    int bytesWrittenToCurrentBuffer() {
      return (int)(this.limitMinusOne - this.pos);
    }
    
    void finishCurrentBuffer() {
      if (this.allocatedBuffer != null) {
        this.totalDoneBytes += bytesWrittenToCurrentBuffer();
        this.allocatedBuffer.position(arrayPos() - this.allocatedBuffer.arrayOffset() + 1);
        this.allocatedBuffer = null;
        this.pos = 0L;
        this.limitMinusOne = 0L;
      } 
    }
    
    public int getTotalBytesWritten() {
      return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
    }
    
    void requireSpace(int param1Int) {
      if (spaceLeft() < param1Int)
        nextBuffer(param1Int); 
    }
    
    int spaceLeft() {
      return (int)(this.pos - this.offsetMinusOne);
    }
    
    public void write(byte param1Byte) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, param1Byte);
    }
    
    public void write(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      requireSpace(i);
      this.pos -= i;
      param1ByteBuffer.get(this.buffer, arrayPos() + 1, i);
    }
    
    public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (param1Int1 >= 0 && param1Int1 + param1Int2 <= param1ArrayOfbyte.length) {
        requireSpace(param1Int2);
        this.pos -= param1Int2;
        System.arraycopy(param1ArrayOfbyte, param1Int1, this.buffer, arrayPos() + 1, param1Int2);
        return;
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    public void writeBool(int param1Int, boolean param1Boolean) {
      requireSpace(6);
      write((byte)param1Boolean);
      writeTag(param1Int, 0);
    }
    
    void writeBool(boolean param1Boolean) {
      write((byte)param1Boolean);
    }
    
    public void writeBytes(int param1Int, ByteString param1ByteString) {
      try {
        param1ByteString.writeToReverse(this);
        requireSpace(10);
        writeVarint32(param1ByteString.size());
        writeTag(param1Int, 2);
        return;
      } catch (IOException iOException) {
        throw new RuntimeException(iOException);
      } 
    }
    
    public void writeEndGroup(int param1Int) {
      writeTag(param1Int, 4);
    }
    
    void writeFixed32(int param1Int) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >> 24 & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >> 16 & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int >> 8 & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)(param1Int & 0xFF));
    }
    
    public void writeFixed32(int param1Int1, int param1Int2) {
      requireSpace(9);
      writeFixed32(param1Int2);
      writeTag(param1Int1, 5);
    }
    
    public void writeFixed64(int param1Int, long param1Long) {
      requireSpace(13);
      writeFixed64(param1Long);
      writeTag(param1Int, 1);
    }
    
    void writeFixed64(long param1Long) {
      byte[] arrayOfByte = this.buffer;
      long l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 56L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 48L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 40L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 32L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 24L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 16L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)(param1Long >> 8L) & 0xFF));
      arrayOfByte = this.buffer;
      l = this.pos;
      this.pos = l - 1L;
      UnsafeUtil.putByte(arrayOfByte, l, (byte)((int)param1Long & 0xFF));
    }
    
    public void writeGroup(int param1Int, Object param1Object) throws IOException {
      writeTag(param1Int, 4);
      Protobuf.getInstance().writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    public void writeGroup(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      writeTag(param1Int, 4);
      param1Schema.writeTo(param1Object, this);
      writeTag(param1Int, 3);
    }
    
    void writeInt32(int param1Int) {
      if (param1Int >= 0) {
        writeVarint32(param1Int);
        return;
      } 
      writeVarint64(param1Int);
    }
    
    public void writeInt32(int param1Int1, int param1Int2) {
      requireSpace(15);
      writeInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeLazy(ByteBuffer param1ByteBuffer) {
      int i = param1ByteBuffer.remaining();
      if (spaceLeft() < i) {
        this.totalDoneBytes += i;
        this.buffers.addFirst(AllocatedBuffer.wrap(param1ByteBuffer));
        nextBuffer();
      } 
      this.pos -= i;
      param1ByteBuffer.get(this.buffer, arrayPos() + 1, i);
    }
    
    public void writeLazy(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) {
      if (param1Int1 >= 0 && param1Int1 + param1Int2 <= param1ArrayOfbyte.length) {
        if (spaceLeft() < param1Int2) {
          this.totalDoneBytes += param1Int2;
          this.buffers.addFirst(AllocatedBuffer.wrap(param1ArrayOfbyte, param1Int1, param1Int2));
          nextBuffer();
          return;
        } 
        this.pos -= param1Int2;
        System.arraycopy(param1ArrayOfbyte, param1Int1, this.buffer, arrayPos() + 1, param1Int2);
        return;
      } 
      throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", new Object[] { Integer.valueOf(param1ArrayOfbyte.length), Integer.valueOf(param1Int1), Integer.valueOf(param1Int2) }));
    }
    
    public void writeMessage(int param1Int, Object param1Object) throws IOException {
      int i = getTotalBytesWritten();
      Protobuf.getInstance().writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    public void writeMessage(int param1Int, Object param1Object, Schema<Object> param1Schema) throws IOException {
      int i = getTotalBytesWritten();
      param1Schema.writeTo(param1Object, this);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeSInt32(int param1Int) {
      writeVarint32(CodedOutputStream.encodeZigZag32(param1Int));
    }
    
    public void writeSInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeSInt32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeSInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeSInt64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeSInt64(long param1Long) {
      writeVarint64(CodedOutputStream.encodeZigZag64(param1Long));
    }
    
    public void writeStartGroup(int param1Int) {
      writeTag(param1Int, 3);
    }
    
    public void writeString(int param1Int, String param1String) {
      int i = getTotalBytesWritten();
      writeString(param1String);
      int j = getTotalBytesWritten();
      requireSpace(10);
      writeVarint32(j - i);
      writeTag(param1Int, 2);
    }
    
    void writeString(String param1String) {
      requireSpace(param1String.length());
      int i = param1String.length() - 1;
      while (i >= 0) {
        char c = param1String.charAt(i);
        if (c < '') {
          byte[] arrayOfByte = this.buffer;
          long l = this.pos;
          this.pos = l - 1L;
          UnsafeUtil.putByte(arrayOfByte, l, (byte)c);
          i--;
        } 
      } 
      int j = i;
      if (i == -1)
        return; 
      while (j >= 0) {
        char c = param1String.charAt(j);
        if (c < '') {
          long l = this.pos;
          if (l > this.offsetMinusOne) {
            byte[] arrayOfByte = this.buffer;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)c);
            continue;
          } 
        } 
        if (c < 'ࠀ') {
          long l = this.pos;
          if (l > this.offset) {
            byte[] arrayOfByte = this.buffer;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)(c & 0x3F | 0x80));
            arrayOfByte = this.buffer;
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)(c >>> 6 | 0x3C0));
            continue;
          } 
        } 
        if (c < '?' || '?' < c) {
          long l = this.pos;
          if (l > this.offset + 1L) {
            byte[] arrayOfByte = this.buffer;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)(c & 0x3F | 0x80));
            arrayOfByte = this.buffer;
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)(c >>> 6 & 0x3F | 0x80));
            arrayOfByte = this.buffer;
            l = this.pos;
            this.pos = l - 1L;
            UnsafeUtil.putByte(arrayOfByte, l, (byte)(c >>> 12 | 0x1E0));
            continue;
          } 
        } 
        if (this.pos > this.offset + 2L) {
          if (j != 0) {
            char c1 = param1String.charAt(j - 1);
            if (Character.isSurrogatePair(c1, c)) {
              j--;
              i = Character.toCodePoint(c1, c);
              byte[] arrayOfByte = this.buffer;
              long l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(arrayOfByte, l, (byte)(i & 0x3F | 0x80));
              arrayOfByte = this.buffer;
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(arrayOfByte, l, (byte)(i >>> 6 & 0x3F | 0x80));
              arrayOfByte = this.buffer;
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(arrayOfByte, l, (byte)(i >>> 12 & 0x3F | 0x80));
              arrayOfByte = this.buffer;
              l = this.pos;
              this.pos = l - 1L;
              UnsafeUtil.putByte(arrayOfByte, l, (byte)(i >>> 18 | 0xF0));
            } else {
              throw new Utf8.UnpairedSurrogateException(j - 1, j);
            } 
          } else {
            throw new Utf8.UnpairedSurrogateException(j - 1, j);
          } 
        } else {
          requireSpace(j);
          j++;
        } 
        continue;
        j--;
      } 
    }
    
    void writeTag(int param1Int1, int param1Int2) {
      writeVarint32(WireFormat.makeTag(param1Int1, param1Int2));
    }
    
    public void writeUInt32(int param1Int1, int param1Int2) {
      requireSpace(10);
      writeVarint32(param1Int2);
      writeTag(param1Int1, 0);
    }
    
    public void writeUInt64(int param1Int, long param1Long) {
      requireSpace(15);
      writeVarint64(param1Long);
      writeTag(param1Int, 0);
    }
    
    void writeVarint32(int param1Int) {
      if ((param1Int & 0xFFFFFF80) == 0) {
        writeVarint32OneByte(param1Int);
        return;
      } 
      if ((param1Int & 0xFFFFC000) == 0) {
        writeVarint32TwoBytes(param1Int);
        return;
      } 
      if ((0xFFE00000 & param1Int) == 0) {
        writeVarint32ThreeBytes(param1Int);
        return;
      } 
      if ((0xF0000000 & param1Int) == 0) {
        writeVarint32FourBytes(param1Int);
        return;
      } 
      writeVarint32FiveBytes(param1Int);
    }
    
    void writeVarint64(long param1Long) {
      switch (BinaryWriter.computeUInt64SizeNoTag(param1Long)) {
        default:
          return;
        case 10:
          writeVarint64TenBytes(param1Long);
          return;
        case 9:
          writeVarint64NineBytes(param1Long);
          return;
        case 8:
          writeVarint64EightBytes(param1Long);
          return;
        case 7:
          writeVarint64SevenBytes(param1Long);
          return;
        case 6:
          writeVarint64SixBytes(param1Long);
          return;
        case 5:
          writeVarint64FiveBytes(param1Long);
          return;
        case 4:
          writeVarint64FourBytes(param1Long);
          return;
        case 3:
          writeVarint64ThreeBytes(param1Long);
          return;
        case 2:
          writeVarint64TwoBytes(param1Long);
          return;
        case 1:
          break;
      } 
      writeVarint64OneByte(param1Long);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\BinaryWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */