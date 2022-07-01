package android.support.v4.util;

import java.util.LinkedHashMap;

public class LruCache {
  private int evictionCount;
  
  private int hitCount;
  
  private final LinkedHashMap map;
  
  private int maxSize;
  
  private int missCount;
  
  private int putCount;
  
  private int size;
  
  public LruCache(int paramInt) {
    if (paramInt > 0) {
      this.maxSize = paramInt;
      this.map = new LinkedHashMap<Object, Object>(0, 0.75F, true);
      return;
    } 
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private void trimToSize(int paramInt) {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield size : I
    //   6: iflt -> 119
    //   9: aload_0
    //   10: getfield map : Ljava/util/LinkedHashMap;
    //   13: invokevirtual isEmpty : ()Z
    //   16: ifeq -> 26
    //   19: aload_0
    //   20: getfield size : I
    //   23: ifne -> 119
    //   26: aload_0
    //   27: getfield size : I
    //   30: iload_1
    //   31: if_icmple -> 116
    //   34: aload_0
    //   35: getfield map : Ljava/util/LinkedHashMap;
    //   38: invokevirtual isEmpty : ()Z
    //   41: ifeq -> 47
    //   44: goto -> 116
    //   47: aload_0
    //   48: getfield map : Ljava/util/LinkedHashMap;
    //   51: invokevirtual entrySet : ()Ljava/util/Set;
    //   54: invokeinterface iterator : ()Ljava/util/Iterator;
    //   59: invokeinterface next : ()Ljava/lang/Object;
    //   64: checkcast java/util/Map$Entry
    //   67: astore_2
    //   68: aload_2
    //   69: invokeinterface getKey : ()Ljava/lang/Object;
    //   74: astore_3
    //   75: aload_2
    //   76: invokeinterface getValue : ()Ljava/lang/Object;
    //   81: pop
    //   82: aload_0
    //   83: getfield map : Ljava/util/LinkedHashMap;
    //   86: aload_3
    //   87: invokevirtual remove : (Ljava/lang/Object;)Ljava/lang/Object;
    //   90: pop
    //   91: aload_0
    //   92: aload_0
    //   93: getfield size : I
    //   96: iconst_1
    //   97: isub
    //   98: putfield size : I
    //   101: aload_0
    //   102: aload_0
    //   103: getfield evictionCount : I
    //   106: iconst_1
    //   107: iadd
    //   108: putfield evictionCount : I
    //   111: aload_0
    //   112: monitorexit
    //   113: goto -> 0
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: new java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial <init> : ()V
    //   126: astore_2
    //   127: aload_2
    //   128: aload_0
    //   129: invokevirtual getClass : ()Ljava/lang/Class;
    //   132: invokevirtual getName : ()Ljava/lang/String;
    //   135: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_2
    //   140: ldc '.sizeOf() is reporting inconsistent results!'
    //   142: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: new java/lang/IllegalStateException
    //   149: dup
    //   150: aload_2
    //   151: invokevirtual toString : ()Ljava/lang/String;
    //   154: invokespecial <init> : (Ljava/lang/String;)V
    //   157: athrow
    //   158: astore_2
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    // Exception table:
    //   from	to	target	type
    //   2	26	158	finally
    //   26	44	158	finally
    //   47	113	158	finally
    //   116	118	158	finally
    //   119	158	158	finally
    //   159	161	158	finally
  }
  
  public final Object get(Object paramObject) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 52
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield map : Ljava/util/LinkedHashMap;
    //   10: aload_1
    //   11: invokevirtual get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   14: astore_1
    //   15: aload_1
    //   16: ifnull -> 33
    //   19: aload_0
    //   20: aload_0
    //   21: getfield hitCount : I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield hitCount : I
    //   29: aload_0
    //   30: monitorexit
    //   31: aload_1
    //   32: areturn
    //   33: aload_0
    //   34: aload_0
    //   35: getfield missCount : I
    //   38: iconst_1
    //   39: iadd
    //   40: putfield missCount : I
    //   43: aload_0
    //   44: monitorexit
    //   45: aconst_null
    //   46: areturn
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    //   52: new java/lang/NullPointerException
    //   55: dup
    //   56: ldc 'key == null'
    //   58: invokespecial <init> : (Ljava/lang/String;)V
    //   61: athrow
    // Exception table:
    //   from	to	target	type
    //   6	15	47	finally
    //   19	31	47	finally
    //   33	45	47	finally
    //   48	50	47	finally
  }
  
  public final Object put(Object paramObject1, Object paramObject2) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 71
    //   4: aload_2
    //   5: ifnull -> 71
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: aload_0
    //   12: getfield putCount : I
    //   15: iconst_1
    //   16: iadd
    //   17: putfield putCount : I
    //   20: aload_0
    //   21: aload_0
    //   22: getfield size : I
    //   25: iconst_1
    //   26: iadd
    //   27: putfield size : I
    //   30: aload_0
    //   31: getfield map : Ljava/util/LinkedHashMap;
    //   34: aload_1
    //   35: aload_2
    //   36: invokevirtual put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull -> 54
    //   44: aload_0
    //   45: aload_0
    //   46: getfield size : I
    //   49: iconst_1
    //   50: isub
    //   51: putfield size : I
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_0
    //   57: aload_0
    //   58: getfield maxSize : I
    //   61: invokespecial trimToSize : (I)V
    //   64: aload_1
    //   65: areturn
    //   66: astore_1
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_1
    //   70: athrow
    //   71: new java/lang/NullPointerException
    //   74: dup
    //   75: ldc 'key == null || value == null'
    //   77: invokespecial <init> : (Ljava/lang/String;)V
    //   80: athrow
    // Exception table:
    //   from	to	target	type
    //   10	40	66	finally
    //   44	54	66	finally
    //   54	56	66	finally
    //   67	69	66	finally
  }
  
  public final String toString() {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield hitCount : I
    //   6: aload_0
    //   7: getfield missCount : I
    //   10: iadd
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq -> 88
    //   16: aload_0
    //   17: getfield hitCount : I
    //   20: bipush #100
    //   22: imul
    //   23: iload_1
    //   24: idiv
    //   25: istore_1
    //   26: goto -> 29
    //   29: getstatic java/util/Locale.US : Ljava/util/Locale;
    //   32: ldc 'LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]'
    //   34: iconst_4
    //   35: anewarray java/lang/Object
    //   38: dup
    //   39: iconst_0
    //   40: aload_0
    //   41: getfield maxSize : I
    //   44: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   47: aastore
    //   48: dup
    //   49: iconst_1
    //   50: aload_0
    //   51: getfield hitCount : I
    //   54: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   57: aastore
    //   58: dup
    //   59: iconst_2
    //   60: aload_0
    //   61: getfield missCount : I
    //   64: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   67: aastore
    //   68: dup
    //   69: iconst_3
    //   70: iload_1
    //   71: invokestatic valueOf : (I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic format : (Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   78: astore_2
    //   79: aload_0
    //   80: monitorexit
    //   81: aload_2
    //   82: areturn
    //   83: astore_2
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_2
    //   87: athrow
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -> 29
    // Exception table:
    //   from	to	target	type
    //   2	12	83	finally
    //   16	26	83	finally
    //   29	79	83	finally
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v\\util\LruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */