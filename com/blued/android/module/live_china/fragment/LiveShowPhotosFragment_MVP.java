package com.blued.android.module.live_china.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class LiveShowPhotosFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/blued/android/module/live_china/fragment/LiveShowPhotosFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 175
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 175
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 175
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -602888526
    //   45: if_icmpeq -> 92
    //   48: iload #5
    //   50: ldc 520236611
    //   52: if_icmpeq -> 80
    //   55: iload #5
    //   57: ldc 833420977
    //   59: if_icmpeq -> 65
    //   62: goto -> 107
    //   65: aload_2
    //   66: ldc 'changed_folder_name'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 107
    //   74: iconst_2
    //   75: istore #4
    //   77: goto -> 110
    //   80: aload_2
    //   81: ldc 'album_data_list'
    //   83: invokevirtual equals : (Ljava/lang/Object;)Z
    //   86: ifeq -> 107
    //   89: goto -> 110
    //   92: aload_2
    //   93: ldc 'feed_data_list'
    //   95: invokevirtual equals : (Ljava/lang/Object;)Z
    //   98: ifeq -> 107
    //   101: iconst_1
    //   102: istore #4
    //   104: goto -> 110
    //   107: iconst_m1
    //   108: istore #4
    //   110: iload #4
    //   112: ifeq -> 160
    //   115: iload #4
    //   117: iconst_1
    //   118: if_icmpeq -> 144
    //   121: iload #4
    //   123: iconst_2
    //   124: if_icmpeq -> 128
    //   127: return
    //   128: ldc java/lang/String
    //   130: aload #6
    //   132: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   135: ifeq -> 175
    //   138: aload_1
    //   139: aload_3
    //   140: invokevirtual c : (Ljava/util/List;)V
    //   143: return
    //   144: ldc java/lang/String
    //   146: aload #6
    //   148: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   151: ifeq -> 175
    //   154: aload_1
    //   155: aload_3
    //   156: invokevirtual b : (Ljava/util/List;)V
    //   159: return
    //   160: ldc java/lang/String
    //   162: aload #6
    //   164: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   167: ifeq -> 175
    //   170: aload_1
    //   171: aload_3
    //   172: invokevirtual a : (Ljava/util/List;)V
    //   175: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\fragment\LiveShowPhotosFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */