package com.soft.blued.ui.find.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import java.util.List;

public final class NearbyHomeFragment_MVP implements MvpDispatcher {
  private void a(NearbyHomeFragment paramNearbyHomeFragment, String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case -308528461:
        if (paramString.equals("set_tip_visibility")) {
          b = 3;
          break;
        } 
      case -1073522738:
        if (paramString.equals("is_show_tip")) {
          b = 1;
          break;
        } 
      case -1760453407:
        if (paramString.equals("home_city_code")) {
          b = 0;
          break;
        } 
      case -1818789622:
        if (paramString.equals("filter_state")) {
          b = 2;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3)
            return; 
          paramNearbyHomeFragment.l();
          return;
        } 
        paramNearbyHomeFragment.n();
        return;
      } 
      paramNearbyHomeFragment.k();
      return;
    } 
    paramNearbyHomeFragment.m();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List paramList) {
    // Byte code:
    //   0: aload_1
    //   1: checkcast com/soft/blued/ui/find/fragment/NearbyHomeFragment
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
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull -> 182
    //   33: aload_2
    //   34: invokevirtual hashCode : ()I
    //   37: istore #5
    //   39: iload #5
    //   41: ldc -1635952433
    //   43: if_icmpeq -> 93
    //   46: iload #5
    //   48: ldc 840348031
    //   50: if_icmpeq -> 78
    //   53: iload #5
    //   55: ldc 1813186427
    //   57: if_icmpeq -> 63
    //   60: goto -> 105
    //   63: aload_2
    //   64: ldc 'recommend_view_rect'
    //   66: invokevirtual equals : (Ljava/lang/Object;)Z
    //   69: ifeq -> 105
    //   72: iconst_1
    //   73: istore #4
    //   75: goto -> 108
    //   78: aload_2
    //   79: ldc 'invisible_state'
    //   81: invokevirtual equals : (Ljava/lang/Object;)Z
    //   84: ifeq -> 105
    //   87: iconst_2
    //   88: istore #4
    //   90: goto -> 108
    //   93: aload_2
    //   94: ldc 'nearby_activity'
    //   96: invokevirtual equals : (Ljava/lang/Object;)Z
    //   99: ifeq -> 105
    //   102: goto -> 108
    //   105: iconst_m1
    //   106: istore #4
    //   108: iload #4
    //   110: ifeq -> 164
    //   113: iload #4
    //   115: iconst_1
    //   116: if_icmpeq -> 146
    //   119: iload #4
    //   121: iconst_2
    //   122: if_icmpeq -> 128
    //   125: goto -> 182
    //   128: ldc java/lang/Boolean
    //   130: aload_3
    //   131: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   134: ifeq -> 182
    //   137: aload_1
    //   138: aload_3
    //   139: checkcast java/lang/Boolean
    //   142: invokevirtual a : (Ljava/lang/Boolean;)V
    //   145: return
    //   146: ldc android/graphics/Rect
    //   148: aload_3
    //   149: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   152: ifeq -> 182
    //   155: aload_1
    //   156: aload_3
    //   157: checkcast android/graphics/Rect
    //   160: invokevirtual a : (Landroid/graphics/Rect;)V
    //   163: return
    //   164: ldc com/soft/blued/ui/feed/model/BluedADExtra
    //   166: aload_3
    //   167: invokevirtual isInstance : (Ljava/lang/Object;)Z
    //   170: ifeq -> 182
    //   173: aload_1
    //   174: aload_3
    //   175: checkcast com/soft/blued/ui/feed/model/BluedADExtra
    //   178: invokevirtual a : (Lcom/soft/blued/ui/feed/model/BluedADExtra;)V
    //   181: return
    //   182: aload_0
    //   183: aload_1
    //   184: aload_2
    //   185: invokespecial a : (Lcom/soft/blued/ui/find/fragment/NearbyHomeFragment;Ljava/lang/String;)V
    //   188: return
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\find\fragment\NearbyHomeFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */