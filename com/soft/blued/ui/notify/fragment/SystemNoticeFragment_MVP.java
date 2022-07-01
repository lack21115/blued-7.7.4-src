package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class SystemNoticeFragment_MVP implements MvpDispatcher {
  private void a(SystemNoticeFragment paramSystemNoticeFragment, String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1803427515:
        if (paramString.equals("REFRESH")) {
          b = 2;
          break;
        } 
      case 698704871:
        if (paramString.equals("VIEW_POINT_LIST")) {
          b = 0;
          break;
        } 
      case 632941979:
        if (paramString.equals("CLEAR_NOTIFY")) {
          b = 1;
          break;
        } 
      case 176778244:
        if (paramString.equals("VIEW_POINT_CLEAR")) {
          b = 3;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3)
            return; 
          paramSystemNoticeFragment.l();
          return;
        } 
        paramSystemNoticeFragment.m();
        return;
      } 
      paramSystemNoticeFragment.n();
      return;
    } 
    paramSystemNoticeFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/notify/fragment/SystemNoticeFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 138
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 138
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 138
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -121134250
    //   45: if_icmpeq -> 73
    //   48: iload #5
    //   50: ldc 698704871
    //   52: if_icmpeq -> 58
    //   55: goto -> 85
    //   58: aload_2
    //   59: ldc 'VIEW_POINT_LIST'
    //   61: invokevirtual equals : (Ljava/lang/Object;)Z
    //   64: ifeq -> 85
    //   67: iconst_1
    //   68: istore #4
    //   70: goto -> 88
    //   73: aload_2
    //   74: ldc 'VIEW_POINT'
    //   76: invokevirtual equals : (Ljava/lang/Object;)Z
    //   79: ifeq -> 85
    //   82: goto -> 88
    //   85: iconst_m1
    //   86: istore #4
    //   88: iload #4
    //   90: ifeq -> 118
    //   93: iload #4
    //   95: iconst_1
    //   96: if_icmpeq -> 102
    //   99: goto -> 138
    //   102: ldc com/soft/blued/ui/notify/model/FeedNotice
    //   104: aload #6
    //   106: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   109: ifeq -> 138
    //   112: aload_1
    //   113: aload_3
    //   114: invokevirtual a : (Ljava/util/List;)V
    //   117: return
    //   118: ldc com/soft/blued/ui/notify/model/ViewpointNoticeCount
    //   120: aload #6
    //   122: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   125: ifeq -> 138
    //   128: aload_1
    //   129: aload #6
    //   131: checkcast com/soft/blued/ui/notify/model/ViewpointNoticeCount
    //   134: invokevirtual a : (Lcom/soft/blued/ui/notify/model/ViewpointNoticeCount;)V
    //   137: return
    //   138: aload_0
    //   139: aload_1
    //   140: aload_2
    //   141: invokespecial a : (Lcom/soft/blued/ui/notify/fragment/SystemNoticeFragment;Ljava/lang/String;)V
    //   144: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\SystemNoticeFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */