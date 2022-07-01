package com.soft.blued.ui.discover.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class DiscoveryPageFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/discover/fragment/DiscoveryPageFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 179
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 179
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 179
    //   33: aload_2
    //   34: invokevirtual hashCode : ()I
    //   37: istore #5
    //   39: iload #5
    //   41: ldc -2146539519
    //   43: if_icmpeq -> 90
    //   46: iload #5
    //   48: ldc -1770327719
    //   50: if_icmpeq -> 78
    //   53: iload #5
    //   55: ldc -356131170
    //   57: if_icmpeq -> 63
    //   60: goto -> 105
    //   63: aload_2
    //   64: ldc 'hide_red_dot'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 105
    //   72: iconst_1
    //   73: istore #4
    //   75: goto -> 108
    //   78: aload_2
    //   79: ldc 'show_red_dot'
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 105
    //   87: goto -> 108
    //   90: aload_2
    //   91: ldc 'view_page_to_item'
    //   93: invokevirtual equals : (Ljava/lang/Object;)Z
    //   96: ifeq -> 105
    //   99: iconst_2
    //   100: istore #4
    //   102: goto -> 108
    //   105: iconst_m1
    //   106: istore #4
    //   108: iload #4
    //   110: ifeq -> 162
    //   113: iload #4
    //   115: iconst_1
    //   116: if_icmpeq -> 144
    //   119: iload #4
    //   121: iconst_2
    //   122: if_icmpeq -> 126
    //   125: return
    //   126: ldc java/lang/Integer
    //   128: aload_3
    //   129: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   132: ifeq -> 179
    //   135: aload_1
    //   136: aload_3
    //   137: checkcast java/lang/Integer
    //   140: invokevirtual c : (Ljava/lang/Integer;)V
    //   143: return
    //   144: ldc java/lang/Integer
    //   146: aload_3
    //   147: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   150: ifeq -> 179
    //   153: aload_1
    //   154: aload_3
    //   155: checkcast java/lang/Integer
    //   158: invokevirtual b : (Ljava/lang/Integer;)V
    //   161: return
    //   162: ldc java/lang/Integer
    //   164: aload_3
    //   165: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   168: ifeq -> 179
    //   171: aload_1
    //   172: aload_3
    //   173: checkcast java/lang/Integer
    //   176: invokevirtual a : (Ljava/lang/Integer;)V
    //   179: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\DiscoveryPageFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */