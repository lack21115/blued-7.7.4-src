package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.blued.android.module.live_china.model.LiveLiangModel;
import com.soft.blued.ui.live.model.BannerModel;
import com.soft.blued.ui.live.model.LiveTabInfo;
import com.soft.blued.ui.live.model.LiveTwoFloorModel;
import java.util.List;

public final class LiveHomeFragment_MVP implements MvpDispatcher {
  private void a(LiveHomeFragment paramLiveHomeFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc -311231599
    //   8: if_icmpeq -> 54
    //   11: iload_3
    //   12: ldc 275365345
    //   14: if_icmpeq -> 40
    //   17: iload_3
    //   18: ldc 2129566804
    //   20: if_icmpeq -> 26
    //   23: goto -> 68
    //   26: aload_2
    //   27: ldc 'LIST_TAB'
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 68
    //   35: iconst_2
    //   36: istore_3
    //   37: goto -> 70
    //   40: aload_2
    //   41: ldc 'BANNER_INFO'
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 68
    //   49: iconst_1
    //   50: istore_3
    //   51: goto -> 70
    //   54: aload_2
    //   55: ldc 'TWO_LEVEL'
    //   57: invokevirtual equals : (Ljava/lang/Object;)Z
    //   60: ifeq -> 68
    //   63: iconst_0
    //   64: istore_3
    //   65: goto -> 70
    //   68: iconst_m1
    //   69: istore_3
    //   70: iload_3
    //   71: ifeq -> 95
    //   74: iload_3
    //   75: iconst_1
    //   76: if_icmpeq -> 90
    //   79: iload_3
    //   80: iconst_2
    //   81: if_icmpeq -> 85
    //   84: return
    //   85: aload_1
    //   86: invokevirtual k : ()V
    //   89: return
    //   90: aload_1
    //   91: invokevirtual l : ()V
    //   94: return
    //   95: aload_1
    //   96: invokevirtual m : ()V
    //   99: return
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      LiveTabInfo liveTabInfo = (LiveTabInfo)paramList.get(0);
      if (liveTabInfo != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 2129566804:
            if (paramString.equals("LIST_TAB")) {
              b = 3;
              break;
            } 
          case 1114302320:
            if (paramString.equals("LIVE_LIANG_ID")) {
              b = 2;
              break;
            } 
          case 275365345:
            if (paramString.equals("BANNER_INFO")) {
              b = 1;
              break;
            } 
          case -311231599:
            if (paramString.equals("TWO_LEVEL"))
              break; 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b == 3 && LiveTabInfo.class.isInstance(liveTabInfo)) {
                paramMvpFragment.a(liveTabInfo);
                return;
              } 
            } else if (LiveLiangModel.class.isInstance(liveTabInfo)) {
              paramMvpFragment.c((List)paramList);
              return;
            } 
          } else if (BannerModel.class.isInstance(liveTabInfo)) {
            paramMvpFragment.a((List)paramList);
            return;
          } 
        } else if (LiveTwoFloorModel.class.isInstance(liveTabInfo)) {
          paramMvpFragment.b((List)paramList);
          return;
        } 
      } 
    } 
    a((LiveHomeFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveHomeFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */