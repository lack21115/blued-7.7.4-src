package com.soft.blued.ui.discover.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class RecommendFeedFragment_MVP implements MvpDispatcher {
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/discover/fragment/RecommendFeedFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 131
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 131
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 131
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -1925279588
    //   45: if_icmpeq -> 73
    //   48: iload #5
    //   50: ldc -1045564913
    //   52: if_icmpeq -> 58
    //   55: goto -> 85
    //   58: aload_2
    //   59: ldc 'featured_list'
    //   61: invokevirtual equals : (Ljava/lang/Object;)Z
    //   64: ifeq -> 85
    //   67: iconst_1
    //   68: istore #4
    //   70: goto -> 88
    //   73: aload_2
    //   74: ldc 'discover_entry'
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
    //   100: ldc com/soft/blued/ui/feed/model/BluedIngSelfFeed
    //   102: aload #6
    //   104: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   107: ifeq -> 131
    //   110: aload_1
    //   111: aload_3
    //   112: invokevirtual b : (Ljava/util/List;)V
    //   115: return
    //   116: ldc com/soft/blued/ui/discover/model/DiscoverSquareExtra$Explore
    //   118: aload #6
    //   120: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   123: ifeq -> 131
    //   126: aload_1
    //   127: aload_3
    //   128: invokevirtual a : (Ljava/util/List;)V
    //   131: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\discover\fragment\RecommendFeedFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */