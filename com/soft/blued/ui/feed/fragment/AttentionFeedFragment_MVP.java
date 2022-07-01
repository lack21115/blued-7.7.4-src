package com.soft.blued.ui.feed.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class AttentionFeedFragment_MVP implements MvpDispatcher {
  private void a(AttentionFeedFragment paramAttentionFeedFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc -1030803812
    //   8: if_icmpeq -> 34
    //   11: iload_3
    //   12: ldc 1008757777
    //   14: if_icmpeq -> 20
    //   17: goto -> 48
    //   20: aload_2
    //   21: ldc 'live_list'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 48
    //   29: iconst_0
    //   30: istore_3
    //   31: goto -> 50
    //   34: aload_2
    //   35: ldc 'send_list_visibility'
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
    //   1: checkcast com/soft/blued/ui/feed/fragment/AttentionFeedFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 134
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 134
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 134
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -1644013921
    //   45: if_icmpeq -> 70
    //   48: iload #5
    //   50: ldc 1008757777
    //   52: if_icmpeq -> 58
    //   55: goto -> 85
    //   58: aload_2
    //   59: ldc 'live_list'
    //   61: invokevirtual equals : (Ljava/lang/Object;)Z
    //   64: ifeq -> 85
    //   67: goto -> 88
    //   70: aload_2
    //   71: ldc 'feed_list'
    //   73: invokevirtual equals : (Ljava/lang/Object;)Z
    //   76: ifeq -> 85
    //   79: iconst_1
    //   80: istore #4
    //   82: goto -> 88
    //   85: iconst_m1
    //   86: istore #4
    //   88: iload #4
    //   90: ifeq -> 118
    //   93: iload #4
    //   95: iconst_1
    //   96: if_icmpeq -> 102
    //   99: goto -> 134
    //   102: ldc com/soft/blued/ui/feed/model/BluedIngSelfFeed
    //   104: aload #6
    //   106: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   109: ifeq -> 134
    //   112: aload_1
    //   113: aload_3
    //   114: invokevirtual b : (Ljava/util/List;)V
    //   117: return
    //   118: ldc com/soft/blued/ui/feed/model/AttentionLiveRecommendData
    //   120: aload #6
    //   122: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   125: ifeq -> 134
    //   128: aload_1
    //   129: aload_3
    //   130: invokevirtual a : (Ljava/util/List;)V
    //   133: return
    //   134: aload_0
    //   135: aload_1
    //   136: aload_2
    //   137: invokespecial a : (Lcom/soft/blued/ui/feed/fragment/AttentionFeedFragment;Ljava/lang/String;)V
    //   140: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\feed\fragment\AttentionFeedFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */