package com.google.protobuf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
  static {
    UNSAFE = getUnsafe();
    MEMORY_CLASS = Android.getMemoryClass();
    IS_ANDROID_64 = determineAndroidSupportByAddressSize(long.class);
    IS_ANDROID_32 = determineAndroidSupportByAddressSize(int.class);
    MEMORY_ACCESSOR = getMemoryAccessor();
    HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();
    BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset(byte[].class);
    BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
    BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
    INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
    INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
    LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
    LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
    FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
    FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
    DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
    DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
    OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
    OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
    BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
    BYTE_ARRAY_ALIGNMENT = (int)(BYTE_ARRAY_BASE_OFFSET & 0x7L);
    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
      bool = true;
    } else {
      bool = false;
    } 
    IS_BIG_ENDIAN = bool;
  }
  
  static long addressOffset(ByteBuffer paramByteBuffer) {
    return MEMORY_ACCESSOR.getLong(paramByteBuffer, BUFFER_ADDRESS_OFFSET);
  }
  
  static <T> T allocateInstance(Class<T> paramClass) {
    try {
      return (T)UNSAFE.allocateInstance(paramClass);
    } catch (InstantiationException instantiationException) {
      throw new IllegalStateException(instantiationException);
    } 
  }
  
  private static int arrayBaseOffset(Class<?> paramClass) {
    return HAS_UNSAFE_ARRAY_OPERATIONS ? MEMORY_ACCESSOR.arrayBaseOffset(paramClass) : -1;
  }
  
  private static int arrayIndexScale(Class<?> paramClass) {
    return HAS_UNSAFE_ARRAY_OPERATIONS ? MEMORY_ACCESSOR.arrayIndexScale(paramClass) : -1;
  }
  
  private static Field bufferAddressField() {
    if (Android.isOnAndroidDevice()) {
      Field field1 = field(Buffer.class, "effectiveDirectAddress");
      if (field1 != null)
        return field1; 
    } 
    Field field = field(Buffer.class, "address");
    return (field != null && field.getType() == long.class) ? field : null;
  }
  
  static void copyMemory(long paramLong1, byte[] paramArrayOfbyte, long paramLong2, long paramLong3) {
    MEMORY_ACCESSOR.copyMemory(paramLong1, paramArrayOfbyte, paramLong2, paramLong3);
  }
  
  static void copyMemory(byte[] paramArrayOfbyte, long paramLong1, long paramLong2, long paramLong3) {
    MEMORY_ACCESSOR.copyMemory(paramArrayOfbyte, paramLong1, paramLong2, paramLong3);
  }
  
  static void copyMemory(byte[] paramArrayOfbyte1, long paramLong1, byte[] paramArrayOfbyte2, long paramLong2, long paramLong3) {
    System.arraycopy(paramArrayOfbyte1, (int)paramLong1, paramArrayOfbyte2, (int)paramLong2, (int)paramLong3);
  }
  
  private static boolean determineAndroidSupportByAddressSize(Class<?> paramClass) {
    if (!Android.isOnAndroidDevice())
      return false; 
    try {
      Class<?> clazz = MEMORY_CLASS;
      clazz.getMethod("peekLong", new Class[] { paramClass, boolean.class });
      clazz.getMethod("pokeLong", new Class[] { paramClass, long.class, boolean.class });
      clazz.getMethod("pokeInt", new Class[] { paramClass, int.class, boolean.class });
      clazz.getMethod("peekInt", new Class[] { paramClass, boolean.class });
      clazz.getMethod("pokeByte", new Class[] { paramClass, byte.class });
      clazz.getMethod("peekByte", new Class[] { paramClass });
      clazz.getMethod("pokeByteArray", new Class[] { paramClass, byte[].class, int.class, int.class });
      return true;
    } finally {
      paramClass = null;
    } 
  }
  
  private static Field field(Class<?> paramClass, String paramString) {
    try {
      return paramClass.getDeclaredField(paramString);
    } finally {
      paramClass = null;
    } 
  }
  
  private static long fieldOffset(Field paramField) {
    if (paramField != null) {
      MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
      if (memoryAccessor != null)
        return memoryAccessor.objectFieldOffset(paramField); 
    } 
    return -1L;
  }
  
  private static int firstDifferingByteIndexNativeEndian(long paramLong1, long paramLong2) {
    int i;
    if (IS_BIG_ENDIAN) {
      i = Long.numberOfLeadingZeros(paramLong1 ^ paramLong2);
    } else {
      i = Long.numberOfTrailingZeros(paramLong1 ^ paramLong2);
    } 
    return i >> 3;
  }
  
  static boolean getBoolean(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getBoolean(paramObject, paramLong);
  }
  
  static boolean getBoolean(boolean[] paramArrayOfboolean, long paramLong) {
    return MEMORY_ACCESSOR.getBoolean(paramArrayOfboolean, BOOLEAN_ARRAY_BASE_OFFSET + paramLong * BOOLEAN_ARRAY_INDEX_SCALE);
  }
  
  private static boolean getBooleanBigEndian(Object paramObject, long paramLong) {
    return (getByteBigEndian(paramObject, paramLong) != 0);
  }
  
  private static boolean getBooleanLittleEndian(Object paramObject, long paramLong) {
    return (getByteLittleEndian(paramObject, paramLong) != 0);
  }
  
  static byte getByte(long paramLong) {
    return MEMORY_ACCESSOR.getByte(paramLong);
  }
  
  static byte getByte(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getByte(paramObject, paramLong);
  }
  
  static byte getByte(byte[] paramArrayOfbyte, long paramLong) {
    return MEMORY_ACCESSOR.getByte(paramArrayOfbyte, BYTE_ARRAY_BASE_OFFSET + paramLong);
  }
  
  private static byte getByteBigEndian(Object paramObject, long paramLong) {
    return (byte)(getInt(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)((paramLong & 0x3L) << 3L) & 0xFF);
  }
  
  private static byte getByteLittleEndian(Object paramObject, long paramLong) {
    return (byte)(getInt(paramObject, 0xFFFFFFFFFFFFFFFCL & paramLong) >>> (int)((paramLong & 0x3L) << 3L) & 0xFF);
  }
  
  static double getDouble(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getDouble(paramObject, paramLong);
  }
  
  static double getDouble(double[] paramArrayOfdouble, long paramLong) {
    return MEMORY_ACCESSOR.getDouble(paramArrayOfdouble, DOUBLE_ARRAY_BASE_OFFSET + paramLong * DOUBLE_ARRAY_INDEX_SCALE);
  }
  
  static float getFloat(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getFloat(paramObject, paramLong);
  }
  
  static float getFloat(float[] paramArrayOffloat, long paramLong) {
    return MEMORY_ACCESSOR.getFloat(paramArrayOffloat, FLOAT_ARRAY_BASE_OFFSET + paramLong * FLOAT_ARRAY_INDEX_SCALE);
  }
  
  static int getInt(long paramLong) {
    return MEMORY_ACCESSOR.getInt(paramLong);
  }
  
  static int getInt(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getInt(paramObject, paramLong);
  }
  
  static int getInt(int[] paramArrayOfint, long paramLong) {
    return MEMORY_ACCESSOR.getInt(paramArrayOfint, INT_ARRAY_BASE_OFFSET + paramLong * INT_ARRAY_INDEX_SCALE);
  }
  
  static long getLong(long paramLong) {
    return MEMORY_ACCESSOR.getLong(paramLong);
  }
  
  static long getLong(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getLong(paramObject, paramLong);
  }
  
  static long getLong(long[] paramArrayOflong, long paramLong) {
    return MEMORY_ACCESSOR.getLong(paramArrayOflong, LONG_ARRAY_BASE_OFFSET + paramLong * LONG_ARRAY_INDEX_SCALE);
  }
  
  private static MemoryAccessor getMemoryAccessor() {
    return (MemoryAccessor)((UNSAFE == null) ? null : (Android.isOnAndroidDevice() ? (IS_ANDROID_64 ? new Android64MemoryAccessor(UNSAFE) : (IS_ANDROID_32 ? new Android32MemoryAccessor(UNSAFE) : null)) : new JvmMemoryAccessor(UNSAFE)));
  }
  
  static Object getObject(Object paramObject, long paramLong) {
    return MEMORY_ACCESSOR.getObject(paramObject, paramLong);
  }
  
  static Object getObject(Object[] paramArrayOfObject, long paramLong) {
    return MEMORY_ACCESSOR.getObject(paramArrayOfObject, OBJECT_ARRAY_BASE_OFFSET + paramLong * OBJECT_ARRAY_INDEX_SCALE);
  }
  
  static Object getStaticObject(Field paramField) {
    return MEMORY_ACCESSOR.getStaticObject(paramField);
  }
  
  static Unsafe getUnsafe() {
    try {
      return AccessController.<Unsafe>doPrivileged(new PrivilegedExceptionAction<Unsafe>() {
            public Unsafe run() throws Exception {
              for (Field field : Unsafe.class.getDeclaredFields()) {
                field.setAccessible(true);
                Object object = field.get((Object)null);
                if (Unsafe.class.isInstance(object))
                  return Unsafe.class.cast(object); 
              } 
              return null;
            }
          });
    } finally {
      Exception exception = null;
    } 
  }
  
  static boolean hasUnsafeArrayOperations() {
    return HAS_UNSAFE_ARRAY_OPERATIONS;
  }
  
  static boolean hasUnsafeByteBufferOperations() {
    return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  }
  
  static boolean isAndroid64() {
    return IS_ANDROID_64;
  }
  
  static int mismatch(byte[] paramArrayOfbyte1, int paramInt1, byte[] paramArrayOfbyte2, int paramInt2, int paramInt3) {
    if (paramInt1 >= 0 && paramInt2 >= 0 && paramInt3 >= 0 && paramInt1 + paramInt3 <= paramArrayOfbyte1.length && paramInt2 + paramInt3 <= paramArrayOfbyte2.length) {
      int j = 0;
      int i = 0;
      if (HAS_UNSAFE_ARRAY_OPERATIONS) {
        for (j = BYTE_ARRAY_ALIGNMENT + paramInt1 & 0x7; i < paramInt3 && (j & 0x7) != 0; j++) {
          if (paramArrayOfbyte1[paramInt1 + i] != paramArrayOfbyte2[paramInt2 + i])
            return i; 
          i++;
        } 
        j = i;
        while (true) {
          int k = j;
          j = k;
          if (k < (paramInt3 - i & 0xFFFFFFF8) + i) {
            long l2 = BYTE_ARRAY_BASE_OFFSET;
            long l3 = paramInt1;
            long l1 = k;
            l2 = getLong(paramArrayOfbyte1, l2 + l3 + l1);
            l1 = getLong(paramArrayOfbyte2, BYTE_ARRAY_BASE_OFFSET + paramInt2 + l1);
            if (l2 != l1)
              return k + firstDifferingByteIndexNativeEndian(l2, l1); 
            j = k + 8;
            continue;
          } 
          break;
        } 
      } 
      while (j < paramInt3) {
        if (paramArrayOfbyte1[paramInt1 + j] != paramArrayOfbyte2[paramInt2 + j])
          return j; 
        j++;
      } 
      return -1;
    } 
    throw new IndexOutOfBoundsException();
  }
  
  static long objectFieldOffset(Field paramField) {
    return MEMORY_ACCESSOR.objectFieldOffset(paramField);
  }
  
  static void putBoolean(Object paramObject, long paramLong, boolean paramBoolean) {
    MEMORY_ACCESSOR.putBoolean(paramObject, paramLong, paramBoolean);
  }
  
  static void putBoolean(boolean[] paramArrayOfboolean, long paramLong, boolean paramBoolean) {
    MEMORY_ACCESSOR.putBoolean(paramArrayOfboolean, BOOLEAN_ARRAY_BASE_OFFSET + paramLong * BOOLEAN_ARRAY_INDEX_SCALE, paramBoolean);
  }
  
  private static void putBooleanBigEndian(Object paramObject, long paramLong, boolean paramBoolean) {
    putByteBigEndian(paramObject, paramLong, (byte)paramBoolean);
  }
  
  private static void putBooleanLittleEndian(Object paramObject, long paramLong, boolean paramBoolean) {
    putByteLittleEndian(paramObject, paramLong, (byte)paramBoolean);
  }
  
  static void putByte(long paramLong, byte paramByte) {
    MEMORY_ACCESSOR.putByte(paramLong, paramByte);
  }
  
  static void putByte(Object paramObject, long paramLong, byte paramByte) {
    MEMORY_ACCESSOR.putByte(paramObject, paramLong, paramByte);
  }
  
  static void putByte(byte[] paramArrayOfbyte, long paramLong, byte paramByte) {
    MEMORY_ACCESSOR.putByte(paramArrayOfbyte, BYTE_ARRAY_BASE_OFFSET + paramLong, paramByte);
  }
  
  private static void putByteBigEndian(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = getInt(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    putInt(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  private static void putByteLittleEndian(Object paramObject, long paramLong, byte paramByte) {
    long l = 0xFFFFFFFFFFFFFFFCL & paramLong;
    int i = getInt(paramObject, l);
    int j = ((int)paramLong & 0x3) << 3;
    putInt(paramObject, l, (0xFF & paramByte) << j | i & 255 << j);
  }
  
  static void putDouble(Object paramObject, long paramLong, double paramDouble) {
    MEMORY_ACCESSOR.putDouble(paramObject, paramLong, paramDouble);
  }
  
  static void putDouble(double[] paramArrayOfdouble, long paramLong, double paramDouble) {
    MEMORY_ACCESSOR.putDouble(paramArrayOfdouble, DOUBLE_ARRAY_BASE_OFFSET + paramLong * DOUBLE_ARRAY_INDEX_SCALE, paramDouble);
  }
  
  static void putFloat(Object paramObject, long paramLong, float paramFloat) {
    MEMORY_ACCESSOR.putFloat(paramObject, paramLong, paramFloat);
  }
  
  static void putFloat(float[] paramArrayOffloat, long paramLong, float paramFloat) {
    MEMORY_ACCESSOR.putFloat(paramArrayOffloat, FLOAT_ARRAY_BASE_OFFSET + paramLong * FLOAT_ARRAY_INDEX_SCALE, paramFloat);
  }
  
  static void putInt(long paramLong, int paramInt) {
    MEMORY_ACCESSOR.putInt(paramLong, paramInt);
  }
  
  static void putInt(Object paramObject, long paramLong, int paramInt) {
    MEMORY_ACCESSOR.putInt(paramObject, paramLong, paramInt);
  }
  
  static void putInt(int[] paramArrayOfint, long paramLong, int paramInt) {
    MEMORY_ACCESSOR.putInt(paramArrayOfint, INT_ARRAY_BASE_OFFSET + paramLong * INT_ARRAY_INDEX_SCALE, paramInt);
  }
  
  static void putLong(long paramLong1, long paramLong2) {
    MEMORY_ACCESSOR.putLong(paramLong1, paramLong2);
  }
  
  static void putLong(Object paramObject, long paramLong1, long paramLong2) {
    MEMORY_ACCESSOR.putLong(paramObject, paramLong1, paramLong2);
  }
  
  static void putLong(long[] paramArrayOflong, long paramLong1, long paramLong2) {
    MEMORY_ACCESSOR.putLong(paramArrayOflong, LONG_ARRAY_BASE_OFFSET + paramLong1 * LONG_ARRAY_INDEX_SCALE, paramLong2);
  }
  
  static void putObject(Object paramObject1, long paramLong, Object paramObject2) {
    MEMORY_ACCESSOR.putObject(paramObject1, paramLong, paramObject2);
  }
  
  static void putObject(Object[] paramArrayOfObject, long paramLong, Object paramObject) {
    MEMORY_ACCESSOR.putObject(paramArrayOfObject, OBJECT_ARRAY_BASE_OFFSET + paramLong * OBJECT_ARRAY_INDEX_SCALE, paramObject);
  }
  
  private static boolean supportsUnsafeArrayOperations() {
    Unsafe unsafe = UNSAFE;
    if (unsafe == null)
      return false; 
    try {
      Class<?> clazz = unsafe.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("arrayBaseOffset", new Class[] { Class.class });
      clazz.getMethod("arrayIndexScale", new Class[] { Class.class });
      clazz.getMethod("getInt", new Class[] { Object.class, long.class });
      clazz.getMethod("putInt", new Class[] { Object.class, long.class, int.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      clazz.getMethod("putLong", new Class[] { Object.class, long.class, long.class });
      clazz.getMethod("getObject", new Class[] { Object.class, long.class });
      clazz.getMethod("putObject", new Class[] { Object.class, long.class, Object.class });
      if (Android.isOnAndroidDevice())
        return true; 
      clazz.getMethod("getByte", new Class[] { Object.class, long.class });
      return true;
    } finally {
      unsafe = null;
      Logger logger = logger;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(unsafe);
      logger.log(level, stringBuilder.toString());
    } 
  }
  
  private static boolean supportsUnsafeByteBufferOperations() {
    Unsafe unsafe = UNSAFE;
    if (unsafe == null)
      return false; 
    try {
      Class<?> clazz = unsafe.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      if (bufferAddressField() == null)
        return false; 
      if (Android.isOnAndroidDevice())
        return true; 
      clazz.getMethod("getByte", new Class[] { long.class });
      return true;
    } finally {
      unsafe = null;
      Logger logger = logger;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(unsafe);
      logger.log(level, stringBuilder.toString());
    } 
  }
  
  static {
    boolean bool;
  }
  
  private static final long BOOLEAN_ARRAY_BASE_OFFSET;
  
  private static final long BOOLEAN_ARRAY_INDEX_SCALE;
  
  private static final long BUFFER_ADDRESS_OFFSET;
  
  private static final int BYTE_ARRAY_ALIGNMENT;
  
  static final long BYTE_ARRAY_BASE_OFFSET;
  
  private static final long DOUBLE_ARRAY_BASE_OFFSET;
  
  private static final long DOUBLE_ARRAY_INDEX_SCALE;
  
  private static final long FLOAT_ARRAY_BASE_OFFSET;
  
  private static final long FLOAT_ARRAY_INDEX_SCALE;
  
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS;
  
  private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  
  private static final long INT_ARRAY_BASE_OFFSET;
  
  private static final long INT_ARRAY_INDEX_SCALE;
  
  private static final boolean IS_ANDROID_32;
  
  private static final boolean IS_ANDROID_64;
  
  static final boolean IS_BIG_ENDIAN;
  
  private static final long LONG_ARRAY_BASE_OFFSET;
  
  private static final long LONG_ARRAY_INDEX_SCALE;
  
  private static final MemoryAccessor MEMORY_ACCESSOR;
  
  private static final Class<?> MEMORY_CLASS;
  
  private static final long OBJECT_ARRAY_BASE_OFFSET;
  
  private static final long OBJECT_ARRAY_INDEX_SCALE;
  
  private static final int STRIDE = 8;
  
  private static final int STRIDE_ALIGNMENT_MASK = 7;
  
  private static final Unsafe UNSAFE;
  
  private static final Logger logger = Logger.getLogger(UnsafeUtil.class.getName());
  
  static final class Android32MemoryAccessor extends MemoryAccessor {
    private static final long SMALL_ADDRESS_MASK = -1L;
    
    Android32MemoryAccessor(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    private static int smallAddress(long param1Long) {
      return (int)(param1Long & 0xFFFFFFFFFFFFFFFFL);
    }
    
    public void copyMemory(long param1Long1, byte[] param1ArrayOfbyte, long param1Long2, long param1Long3) {
      throw new UnsupportedOperationException();
    }
    
    public void copyMemory(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      throw new UnsupportedOperationException();
    }
    
    public boolean getBoolean(Object param1Object, long param1Long) {
      return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(param1Object, param1Long) : UnsafeUtil.getBooleanLittleEndian(param1Object, param1Long);
    }
    
    public byte getByte(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public byte getByte(Object param1Object, long param1Long) {
      return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(param1Object, param1Long) : UnsafeUtil.getByteLittleEndian(param1Object, param1Long);
    }
    
    public double getDouble(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(getLong(param1Object, param1Long));
    }
    
    public float getFloat(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(getInt(param1Object, param1Long));
    }
    
    public int getInt(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public long getLong(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public Object getStaticObject(Field param1Field) {
      try {
        return param1Field.get((Object)null);
      } catch (IllegalAccessException illegalAccessException) {
        return null;
      } 
    }
    
    public void putBoolean(Object param1Object, long param1Long, boolean param1Boolean) {
      if (UnsafeUtil.IS_BIG_ENDIAN) {
        UnsafeUtil.putBooleanBigEndian(param1Object, param1Long, param1Boolean);
        return;
      } 
      UnsafeUtil.putBooleanLittleEndian(param1Object, param1Long, param1Boolean);
    }
    
    public void putByte(long param1Long, byte param1Byte) {
      throw new UnsupportedOperationException();
    }
    
    public void putByte(Object param1Object, long param1Long, byte param1Byte) {
      if (UnsafeUtil.IS_BIG_ENDIAN) {
        UnsafeUtil.putByteBigEndian(param1Object, param1Long, param1Byte);
        return;
      } 
      UnsafeUtil.putByteLittleEndian(param1Object, param1Long, param1Byte);
    }
    
    public void putDouble(Object param1Object, long param1Long, double param1Double) {
      putLong(param1Object, param1Long, Double.doubleToLongBits(param1Double));
    }
    
    public void putFloat(Object param1Object, long param1Long, float param1Float) {
      putInt(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public void putInt(long param1Long, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public void putLong(long param1Long1, long param1Long2) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class Android64MemoryAccessor extends MemoryAccessor {
    Android64MemoryAccessor(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public void copyMemory(long param1Long1, byte[] param1ArrayOfbyte, long param1Long2, long param1Long3) {
      throw new UnsupportedOperationException();
    }
    
    public void copyMemory(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      throw new UnsupportedOperationException();
    }
    
    public boolean getBoolean(Object param1Object, long param1Long) {
      return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(param1Object, param1Long) : UnsafeUtil.getBooleanLittleEndian(param1Object, param1Long);
    }
    
    public byte getByte(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public byte getByte(Object param1Object, long param1Long) {
      return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getByteBigEndian(param1Object, param1Long) : UnsafeUtil.getByteLittleEndian(param1Object, param1Long);
    }
    
    public double getDouble(Object param1Object, long param1Long) {
      return Double.longBitsToDouble(getLong(param1Object, param1Long));
    }
    
    public float getFloat(Object param1Object, long param1Long) {
      return Float.intBitsToFloat(getInt(param1Object, param1Long));
    }
    
    public int getInt(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public long getLong(long param1Long) {
      throw new UnsupportedOperationException();
    }
    
    public Object getStaticObject(Field param1Field) {
      try {
        return param1Field.get((Object)null);
      } catch (IllegalAccessException illegalAccessException) {
        return null;
      } 
    }
    
    public void putBoolean(Object param1Object, long param1Long, boolean param1Boolean) {
      if (UnsafeUtil.IS_BIG_ENDIAN) {
        UnsafeUtil.putBooleanBigEndian(param1Object, param1Long, param1Boolean);
        return;
      } 
      UnsafeUtil.putBooleanLittleEndian(param1Object, param1Long, param1Boolean);
    }
    
    public void putByte(long param1Long, byte param1Byte) {
      throw new UnsupportedOperationException();
    }
    
    public void putByte(Object param1Object, long param1Long, byte param1Byte) {
      if (UnsafeUtil.IS_BIG_ENDIAN) {
        UnsafeUtil.putByteBigEndian(param1Object, param1Long, param1Byte);
        return;
      } 
      UnsafeUtil.putByteLittleEndian(param1Object, param1Long, param1Byte);
    }
    
    public void putDouble(Object param1Object, long param1Long, double param1Double) {
      putLong(param1Object, param1Long, Double.doubleToLongBits(param1Double));
    }
    
    public void putFloat(Object param1Object, long param1Long, float param1Float) {
      putInt(param1Object, param1Long, Float.floatToIntBits(param1Float));
    }
    
    public void putInt(long param1Long, int param1Int) {
      throw new UnsupportedOperationException();
    }
    
    public void putLong(long param1Long1, long param1Long2) {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class JvmMemoryAccessor extends MemoryAccessor {
    JvmMemoryAccessor(Unsafe param1Unsafe) {
      super(param1Unsafe);
    }
    
    public void copyMemory(long param1Long1, byte[] param1ArrayOfbyte, long param1Long2, long param1Long3) {
      this.unsafe.copyMemory(null, param1Long1, param1ArrayOfbyte, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + param1Long2, param1Long3);
    }
    
    public void copyMemory(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3) {
      this.unsafe.copyMemory(param1ArrayOfbyte, UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + param1Long1, null, param1Long2, param1Long3);
    }
    
    public boolean getBoolean(Object param1Object, long param1Long) {
      return this.unsafe.getBoolean(param1Object, param1Long);
    }
    
    public byte getByte(long param1Long) {
      return this.unsafe.getByte(param1Long);
    }
    
    public byte getByte(Object param1Object, long param1Long) {
      return this.unsafe.getByte(param1Object, param1Long);
    }
    
    public double getDouble(Object param1Object, long param1Long) {
      return this.unsafe.getDouble(param1Object, param1Long);
    }
    
    public float getFloat(Object param1Object, long param1Long) {
      return this.unsafe.getFloat(param1Object, param1Long);
    }
    
    public int getInt(long param1Long) {
      return this.unsafe.getInt(param1Long);
    }
    
    public long getLong(long param1Long) {
      return this.unsafe.getLong(param1Long);
    }
    
    public Object getStaticObject(Field param1Field) {
      return getObject(this.unsafe.staticFieldBase(param1Field), this.unsafe.staticFieldOffset(param1Field));
    }
    
    public void putBoolean(Object param1Object, long param1Long, boolean param1Boolean) {
      this.unsafe.putBoolean(param1Object, param1Long, param1Boolean);
    }
    
    public void putByte(long param1Long, byte param1Byte) {
      this.unsafe.putByte(param1Long, param1Byte);
    }
    
    public void putByte(Object param1Object, long param1Long, byte param1Byte) {
      this.unsafe.putByte(param1Object, param1Long, param1Byte);
    }
    
    public void putDouble(Object param1Object, long param1Long, double param1Double) {
      this.unsafe.putDouble(param1Object, param1Long, param1Double);
    }
    
    public void putFloat(Object param1Object, long param1Long, float param1Float) {
      this.unsafe.putFloat(param1Object, param1Long, param1Float);
    }
    
    public void putInt(long param1Long, int param1Int) {
      this.unsafe.putInt(param1Long, param1Int);
    }
    
    public void putLong(long param1Long1, long param1Long2) {
      this.unsafe.putLong(param1Long1, param1Long2);
    }
  }
  
  static abstract class MemoryAccessor {
    Unsafe unsafe;
    
    MemoryAccessor(Unsafe param1Unsafe) {
      this.unsafe = param1Unsafe;
    }
    
    public final int arrayBaseOffset(Class<?> param1Class) {
      return this.unsafe.arrayBaseOffset(param1Class);
    }
    
    public final int arrayIndexScale(Class<?> param1Class) {
      return this.unsafe.arrayIndexScale(param1Class);
    }
    
    public abstract void copyMemory(long param1Long1, byte[] param1ArrayOfbyte, long param1Long2, long param1Long3);
    
    public abstract void copyMemory(byte[] param1ArrayOfbyte, long param1Long1, long param1Long2, long param1Long3);
    
    public abstract boolean getBoolean(Object param1Object, long param1Long);
    
    public abstract byte getByte(long param1Long);
    
    public abstract byte getByte(Object param1Object, long param1Long);
    
    public abstract double getDouble(Object param1Object, long param1Long);
    
    public abstract float getFloat(Object param1Object, long param1Long);
    
    public abstract int getInt(long param1Long);
    
    public final int getInt(Object param1Object, long param1Long) {
      return this.unsafe.getInt(param1Object, param1Long);
    }
    
    public abstract long getLong(long param1Long);
    
    public final long getLong(Object param1Object, long param1Long) {
      return this.unsafe.getLong(param1Object, param1Long);
    }
    
    public final Object getObject(Object param1Object, long param1Long) {
      return this.unsafe.getObject(param1Object, param1Long);
    }
    
    public abstract Object getStaticObject(Field param1Field);
    
    public final long objectFieldOffset(Field param1Field) {
      return this.unsafe.objectFieldOffset(param1Field);
    }
    
    public abstract void putBoolean(Object param1Object, long param1Long, boolean param1Boolean);
    
    public abstract void putByte(long param1Long, byte param1Byte);
    
    public abstract void putByte(Object param1Object, long param1Long, byte param1Byte);
    
    public abstract void putDouble(Object param1Object, long param1Long, double param1Double);
    
    public abstract void putFloat(Object param1Object, long param1Long, float param1Float);
    
    public abstract void putInt(long param1Long, int param1Int);
    
    public final void putInt(Object param1Object, long param1Long, int param1Int) {
      this.unsafe.putInt(param1Object, param1Long, param1Int);
    }
    
    public abstract void putLong(long param1Long1, long param1Long2);
    
    public final void putLong(Object param1Object, long param1Long1, long param1Long2) {
      this.unsafe.putLong(param1Object, param1Long1, param1Long2);
    }
    
    public final void putObject(Object param1Object1, long param1Long, Object param1Object2) {
      this.unsafe.putObject(param1Object1, param1Long, param1Object2);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\google\protobuf\UnsafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */