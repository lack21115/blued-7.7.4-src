package com.soft.blued.ui.circle.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class CircleTextVoteEditFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/circle/fragment/CircleTextVoteEditFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 135
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 135
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 135
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc 110371416
    //   45: if_icmpeq -> 73
    //   48: iload #5
    //   50: ldc 951530617
    //   52: if_icmpeq -> 58
    //   55: goto -> 85
    //   58: aload_2
    //   59: ldc 'content'
    //   61: invokevirtual equals : (Ljava/lang/Object;)Z
    //   64: ifeq -> 85
    //   67: iconst_1
    //   68: istore #4
    //   70: goto -> 88
    //   73: aload_2
    //   74: ldc 'title'
    //   76: invokevirtual equals : (Ljava/lang/Object;)Z
    //   79: ifeq -> 85
    //   82: goto -> 88
    //   85: iconst_m1
    //   86: istore #4
    //   88: iload #4
    //   90: ifeq -> 116
    //   93: iload #4
    //   95: iconst_1
    //   96: if_icmpeq -> 100
    //   99: return
    //   100: ldc com/soft/blued/ui/feed/model/CircleTextVote
    //   102: aload #6
    //   104: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   107: ifeq -> 135
    //   110: aload_1
    //   111: aload_3
    //   112: invokevirtual a : (Ljava/util/List;)V
    //   115: return
    //   116: ldc java/lang/String
    //   118: aload #6
    //   120: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   123: ifeq -> 135
    //   126: aload_1
    //   127: aload #6
    //   129: checkcast java/lang/String
    //   132: invokevirtual c : (Ljava/lang/String;)V
    //   135: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\fragment\CircleTextVoteEditFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */