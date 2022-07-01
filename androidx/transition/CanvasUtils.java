package androidx.transition;

import android.graphics.Canvas;
import java.lang.reflect.Method;

class CanvasUtils {
  private static Method a;
  
  private static Method b;
  
  private static boolean c;
  
  static void a(Canvas paramCanvas, boolean paramBoolean) {
    // Byte code:
    //   0: getstatic android/os/Build$VERSION.SDK_INT : I
    //   3: bipush #21
    //   5: if_icmpge -> 9
    //   8: return
    //   9: getstatic android/os/Build$VERSION.SDK_INT : I
    //   12: bipush #29
    //   14: if_icmplt -> 31
    //   17: iload_1
    //   18: ifeq -> 26
    //   21: aload_0
    //   22: invokevirtual enableZ : ()V
    //   25: return
    //   26: aload_0
    //   27: invokevirtual disableZ : ()V
    //   30: return
    //   31: getstatic android/os/Build$VERSION.SDK_INT : I
    //   34: bipush #28
    //   36: if_icmpeq -> 152
    //   39: getstatic androidx/transition/CanvasUtils.c : Z
    //   42: ifne -> 91
    //   45: ldc android/graphics/Canvas
    //   47: ldc 'insertReorderBarrier'
    //   49: iconst_0
    //   50: anewarray java/lang/Class
    //   53: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   56: putstatic androidx/transition/CanvasUtils.a : Ljava/lang/reflect/Method;
    //   59: getstatic androidx/transition/CanvasUtils.a : Ljava/lang/reflect/Method;
    //   62: iconst_1
    //   63: invokevirtual setAccessible : (Z)V
    //   66: ldc android/graphics/Canvas
    //   68: ldc 'insertInorderBarrier'
    //   70: iconst_0
    //   71: anewarray java/lang/Class
    //   74: invokevirtual getDeclaredMethod : (Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   77: putstatic androidx/transition/CanvasUtils.b : Ljava/lang/reflect/Method;
    //   80: getstatic androidx/transition/CanvasUtils.b : Ljava/lang/reflect/Method;
    //   83: iconst_1
    //   84: invokevirtual setAccessible : (Z)V
    //   87: iconst_1
    //   88: putstatic androidx/transition/CanvasUtils.c : Z
    //   91: iload_1
    //   92: ifeq -> 116
    //   95: getstatic androidx/transition/CanvasUtils.a : Ljava/lang/reflect/Method;
    //   98: ifnull -> 116
    //   101: getstatic androidx/transition/CanvasUtils.a : Ljava/lang/reflect/Method;
    //   104: aload_0
    //   105: iconst_0
    //   106: anewarray java/lang/Object
    //   109: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: goto -> 116
    //   116: iload_1
    //   117: ifne -> 151
    //   120: getstatic androidx/transition/CanvasUtils.b : Ljava/lang/reflect/Method;
    //   123: ifnull -> 151
    //   126: getstatic androidx/transition/CanvasUtils.b : Ljava/lang/reflect/Method;
    //   129: aload_0
    //   130: iconst_0
    //   131: anewarray java/lang/Object
    //   134: invokevirtual invoke : (Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: return
    //   139: new java/lang/RuntimeException
    //   142: dup
    //   143: aload_0
    //   144: invokevirtual getCause : ()Ljava/lang/Throwable;
    //   147: invokespecial <init> : (Ljava/lang/Throwable;)V
    //   150: athrow
    //   151: return
    //   152: new java/lang/IllegalStateException
    //   155: dup
    //   156: ldc 'This method doesn't work on Pie!'
    //   158: invokespecial <init> : (Ljava/lang/String;)V
    //   161: athrow
    //   162: astore_2
    //   163: goto -> 87
    //   166: astore_0
    //   167: return
    //   168: astore_0
    //   169: goto -> 139
    // Exception table:
    //   from	to	target	type
    //   45	87	162	java/lang/NoSuchMethodException
    //   95	113	166	java/lang/IllegalAccessException
    //   95	113	168	java/lang/reflect/InvocationTargetException
    //   120	138	166	java/lang/IllegalAccessException
    //   120	138	168	java/lang/reflect/InvocationTargetException
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\transition\CanvasUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */