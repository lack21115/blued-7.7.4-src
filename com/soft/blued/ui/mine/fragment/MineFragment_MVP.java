package com.soft.blued.ui.mine.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class MineFragment_MVP implements MvpDispatcher {
  private void a(MineFragment paramMineFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc 403484520
    //   8: if_icmpeq -> 34
    //   11: iload_3
    //   12: ldc 1340885022
    //   14: if_icmpeq -> 20
    //   17: goto -> 48
    //   20: aload_2
    //   21: ldc 'TAB_CLICK'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 48
    //   29: iconst_0
    //   30: istore_3
    //   31: goto -> 50
    //   34: aload_2
    //   35: ldc 'PRIVACY'
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 48
    //   43: iconst_1
    //   44: istore_3
    //   45: goto -> 50
    //   48: iconst_m1
    //   49: istore_3
    //   50: iload_3
    //   51: ifeq -> 65
    //   54: iload_3
    //   55: iconst_1
    //   56: if_icmpeq -> 60
    //   59: return
    //   60: aload_1
    //   61: invokevirtual l : ()V
    //   64: return
    //   65: aload_1
    //   66: invokevirtual k : ()V
    //   69: return
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/mine/fragment/MineFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 136
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 136
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 136
    //   33: aload_2
    //   34: invokevirtual hashCode : ()I
    //   37: istore #5
    //   39: iload #5
    //   41: ldc -2038483646
    //   43: if_icmpeq -> 68
    //   46: iload #5
    //   48: ldc 403484520
    //   50: if_icmpeq -> 56
    //   53: goto -> 83
    //   56: aload_2
    //   57: ldc 'PRIVACY'
    //   59: invokevirtual equals : (Ljava/lang/Object;)Z
    //   62: ifeq -> 83
    //   65: goto -> 86
    //   68: aload_2
    //   69: ldc 'MY_PAGE'
    //   71: invokevirtual equals : (Ljava/lang/Object;)Z
    //   74: ifeq -> 83
    //   77: iconst_1
    //   78: istore #4
    //   80: goto -> 86
    //   83: iconst_m1
    //   84: istore #4
    //   86: iload #4
    //   88: ifeq -> 118
    //   91: iload #4
    //   93: iconst_1
    //   94: if_icmpeq -> 100
    //   97: goto -> 136
    //   100: ldc com/soft/blued/ui/mine/model/MineEntryInfo
    //   102: aload_3
    //   103: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   106: ifeq -> 136
    //   109: aload_1
    //   110: aload_3
    //   111: checkcast com/soft/blued/ui/mine/model/MineEntryInfo
    //   114: invokevirtual a : (Lcom/soft/blued/ui/mine/model/MineEntryInfo;)V
    //   117: return
    //   118: ldc java/lang/Integer
    //   120: aload_3
    //   121: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   124: ifeq -> 136
    //   127: aload_1
    //   128: aload_3
    //   129: checkcast java/lang/Integer
    //   132: invokevirtual a : (Ljava/lang/Integer;)V
    //   135: return
    //   136: aload_0
    //   137: aload_1
    //   138: aload_2
    //   139: invokespecial a : (Lcom/soft/blued/ui/mine/fragment/MineFragment;Ljava/lang/String;)V
    //   142: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\mine\fragment\MineFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */