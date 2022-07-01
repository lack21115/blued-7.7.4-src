package com.google.protobuf;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class UnsafeUtil {
  private static final long ARRAY_BASE_OFFSET = 0L;
  
  private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
  
  private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
  
  private static final UnsafeUtil$MemoryAccessor MEMORY_ACCESSOR;
  
  private static final Unsafe UNSAFE;
  
  private static final Logger logger;
  
  static {
    throw new VerifyError("bad dex opcode");
  }
  
  private static Field field(Class paramClass, String paramString) {
    try {
      Field field = paramClass.getDeclaredField(paramString);
      field.setAccessible(true);
      return field;
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static long getArrayBaseOffset() {
    return ARRAY_BASE_OFFSET;
  }
  
  private static Unsafe getUnsafe() {
    try {
      return AccessController.<Unsafe>doPrivileged(new UnsafeUtil$1());
    } catch (Throwable throwable) {
      return null;
    } 
  }
  
  static boolean hasUnsafeArrayOperations() {
    return HAS_UNSAFE_ARRAY_OPERATIONS;
  }
  
  static boolean hasUnsafeByteBufferOperations() {
    return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
  }
  
  static void putByte(Object paramObject, long paramLong, byte paramByte) {
    MEMORY_ACCESSOR.putByte(paramObject, paramLong, paramByte);
  }
  
  private static boolean supportsUnsafeArrayOperations() {
    if (UNSAFE == null)
      return false; 
    try {
      Class<?> clazz = UNSAFE.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("arrayBaseOffset", new Class[] { Class.class });
      clazz.getMethod("getInt", new Class[] { Object.class, long.class });
      clazz.getMethod("putInt", new Class[] { Object.class, long.class, int.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      clazz.getMethod("putLong", new Class[] { Object.class, long.class, long.class });
      clazz.getMethod("getObject", new Class[] { Object.class, long.class });
      clazz.getMethod("putObject", new Class[] { Object.class, long.class, Object.class });
      clazz.getMethod("getByte", new Class[] { Object.class, long.class });
      clazz.getMethod("putByte", new Class[] { Object.class, long.class, byte.class });
      clazz.getMethod("getBoolean", new Class[] { Object.class, long.class });
      clazz.getMethod("putBoolean", new Class[] { Object.class, long.class, boolean.class });
      clazz.getMethod("getFloat", new Class[] { Object.class, long.class });
      clazz.getMethod("putFloat", new Class[] { Object.class, long.class, float.class });
      clazz.getMethod("getDouble", new Class[] { Object.class, long.class });
      clazz.getMethod("putDouble", new Class[] { Object.class, long.class, double.class });
      return true;
    } catch (Throwable throwable) {
      Logger logger = logger;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(throwable);
      logger.log(level, stringBuilder.toString());
      return false;
    } 
  }
  
  private static boolean supportsUnsafeByteBufferOperations() {
    if (UNSAFE == null)
      return false; 
    try {
      Class<?> clazz = UNSAFE.getClass();
      clazz.getMethod("objectFieldOffset", new Class[] { Field.class });
      clazz.getMethod("getLong", new Class[] { Object.class, long.class });
      clazz.getMethod("getByte", new Class[] { long.class });
      clazz.getMethod("putByte", new Class[] { long.class, byte.class });
      clazz.getMethod("getInt", new Class[] { long.class });
      clazz.getMethod("putInt", new Class[] { long.class, int.class });
      clazz.getMethod("getLong", new Class[] { long.class });
      clazz.getMethod("putLong", new Class[] { long.class, long.class });
      clazz.getMethod("copyMemory", new Class[] { long.class, long.class, long.class });
      return true;
    } catch (Throwable throwable) {
      Logger logger = logger;
      Level level = Level.WARNING;
      StringBuilder stringBuilder = new StringBuilder("platform method missing - proto runtime falling back to safer methods: ");
      stringBuilder.append(throwable);
      logger.log(level, stringBuilder.toString());
      return false;
    } 
  }
  
  private static boolean supportsUnsafeCopyMemory() {
    if (UNSAFE == null)
      return false; 
    try {
      UNSAFE.getClass().getMethod("copyMemory", new Class[] { Object.class, long.class, Object.class, long.class, long.class });
      return true;
    } catch (Throwable throwable) {
      logger.log(Level.WARNING, "copyMemory is missing from platform - proto runtime falling back to safer methods.");
      return false;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\com\google\protobuf\UnsafeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */