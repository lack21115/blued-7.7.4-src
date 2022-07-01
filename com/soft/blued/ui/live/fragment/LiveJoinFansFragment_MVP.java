package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class LiveJoinFansFragment_MVP implements MvpDispatcher {
  private void a(LiveJoinFansFragment paramLiveJoinFansFragment, String paramString) {
    byte b;
    if (paramString.hashCode() == -97990110 && paramString.equals("LIVE_JOIN_FANS")) {
      b = 0;
    } else {
      b = -1;
    } 
    if (b != 0)
      return; 
    paramLiveJoinFansFragment.k();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/live/fragment/LiveJoinFansFragment
    //   4: astore_1
    //   5: aload_3
    //   6: ifnull -> 182
    //   9: aload_3
    //   10: invokeinterface size : ()I
    //   15: ifle -> 182
    //   18: iconst_0
    //   19: istore #4
    //   21: aload_3
    //   22: iconst_0
    //   23: invokeinterface get : (I)Ljava/lang/Object;
    //   28: astore #6
    //   30: aload #6
    //   32: ifnull -> 182
    //   35: aload_2
    //   36: invokevirtual hashCode : ()I
    //   39: istore #5
    //   41: iload #5
    //   43: ldc -97990110
    //   45: if_icmpeq -> 92
    //   48: iload #5
    //   50: ldc 288034380
    //   52: if_icmpeq -> 77
    //   55: iload #5
    //   57: ldc 1445811066
    //   59: if_icmpeq -> 65
    //   62: goto -> 107
    //   65: aload_2
    //   66: ldc 'LIVE_JOIN_RECOMMEND'
    //   68: invokevirtual equals : (Ljava/lang/Object;)Z
    //   71: ifeq -> 107
    //   74: goto -> 110
    //   77: aload_2
    //   78: ldc 'LIVE_JOIN_FANS_QUIT'
    //   80: invokevirtual equals : (Ljava/lang/Object;)Z
    //   83: ifeq -> 107
    //   86: iconst_1
    //   87: istore #4
    //   89: goto -> 110
    //   92: aload_2
    //   93: ldc 'LIVE_JOIN_FANS'
    //   95: invokevirtual equals : (Ljava/lang/Object;)Z
    //   98: ifeq -> 107
    //   101: iconst_2
    //   102: istore #4
    //   104: goto -> 110
    //   107: iconst_m1
    //   108: istore #4
    //   110: iload #4
    //   112: ifeq -> 166
    //   115: iload #4
    //   117: iconst_1
    //   118: if_icmpeq -> 146
    //   121: iload #4
    //   123: iconst_2
    //   124: if_icmpeq -> 130
    //   127: goto -> 182
    //   130: ldc com/soft/blued/ui/live/model/LiveJoinFansModel
    //   132: aload #6
    //   134: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   137: ifeq -> 182
    //   140: aload_1
    //   141: aload_3
    //   142: invokevirtual a : (Ljava/util/List;)V
    //   145: return
    //   146: ldc com/blued/android/module/live_china/model/LiveFansQuitModel
    //   148: aload #6
    //   150: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   153: ifeq -> 182
    //   156: aload_1
    //   157: aload #6
    //   159: checkcast com/blued/android/module/live_china/model/LiveFansQuitModel
    //   162: invokevirtual a : (Lcom/blued/android/module/live_china/model/LiveFansQuitModel;)V
    //   165: return
    //   166: ldc com/blued/android/module/live_china/model/LiveFansRecommendModel
    //   168: aload #6
    //   170: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   173: ifeq -> 182
    //   176: aload_1
    //   177: aload_3
    //   178: invokevirtual b : (Ljava/util/List;)V
    //   181: return
    //   182: aload_0
    //   183: aload_1
    //   184: aload_2
    //   185: invokespecial a : (Lcom/soft/blued/ui/live/fragment/LiveJoinFansFragment;Ljava/lang/String;)V
    //   188: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveJoinFansFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */