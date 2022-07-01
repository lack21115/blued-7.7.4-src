package android.support.v4.app;

import java.util.ArrayList;
import java.util.Map;

final class FragmentTransitionImpl$2 implements Runnable {
  public final void run() {
    // Byte code:
    //   0: aload_0
    //   1: getfield val$sharedElementsIn : Ljava/util/ArrayList;
    //   4: invokevirtual size : ()I
    //   7: istore_2
    //   8: iconst_0
    //   9: istore_1
    //   10: iload_1
    //   11: iload_2
    //   12: if_icmpge -> 122
    //   15: aload_0
    //   16: getfield val$sharedElementsIn : Ljava/util/ArrayList;
    //   19: iload_1
    //   20: invokevirtual get : (I)Ljava/lang/Object;
    //   23: checkcast android/view/View
    //   26: astore #4
    //   28: aload #4
    //   30: invokestatic getTransitionName : (Landroid/view/View;)Ljava/lang/String;
    //   33: astore_3
    //   34: aload_3
    //   35: ifnull -> 115
    //   38: aload_0
    //   39: getfield val$nameOverrides : Ljava/util/Map;
    //   42: invokeinterface entrySet : ()Ljava/util/Set;
    //   47: invokeinterface iterator : ()Ljava/util/Iterator;
    //   52: astore #5
    //   54: aload #5
    //   56: invokeinterface hasNext : ()Z
    //   61: ifeq -> 107
    //   64: aload #5
    //   66: invokeinterface next : ()Ljava/lang/Object;
    //   71: checkcast java/util/Map$Entry
    //   74: astore #6
    //   76: aload_3
    //   77: aload #6
    //   79: invokeinterface getValue : ()Ljava/lang/Object;
    //   84: invokevirtual equals : (Ljava/lang/Object;)Z
    //   87: ifeq -> 104
    //   90: aload #6
    //   92: invokeinterface getKey : ()Ljava/lang/Object;
    //   97: checkcast java/lang/String
    //   100: astore_3
    //   101: goto -> 109
    //   104: goto -> 54
    //   107: aconst_null
    //   108: astore_3
    //   109: aload #4
    //   111: aload_3
    //   112: invokestatic setTransitionName : (Landroid/view/View;Ljava/lang/String;)V
    //   115: iload_1
    //   116: iconst_1
    //   117: iadd
    //   118: istore_1
    //   119: goto -> 10
    //   122: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v4\app\FragmentTransitionImpl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */