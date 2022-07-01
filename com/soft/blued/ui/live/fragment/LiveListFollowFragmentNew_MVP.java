package com.soft.blued.ui.live.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.live.model.BluedLiveListData;
import com.soft.blued.ui.live.model.LiveRecommendModel;
import java.util.List;

public final class LiveListFollowFragmentNew_MVP implements MvpDispatcher {
  private void a(LiveListFollowFragmentNew paramLiveListFollowFragmentNew, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc -390669347
    //   8: if_icmpeq -> 34
    //   11: iload_3
    //   12: ldc -73333168
    //   14: if_icmpeq -> 20
    //   17: goto -> 48
    //   20: aload_2
    //   21: ldc 'recommend_list_user_has_more'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 48
    //   29: iconst_0
    //   30: istore_3
    //   31: goto -> 50
    //   34: aload_2
    //   35: ldc 'recommend_list_user_no_more'
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
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      BluedLiveListData bluedLiveListData = (BluedLiveListData)paramList.get(0);
      if (bluedLiveListData != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case -306246562:
            if (paramString.equals("more_recommend_list_new_user"))
              break; 
          case -390669347:
            if (paramString.equals("recommend_list_user_no_more")) {
              b = 3;
              break;
            } 
          case -1447382082:
            if (paramString.equals("follow_list_user")) {
              b = 1;
              break;
            } 
          case -2132740343:
            if (paramString.equals("recommend_list_user")) {
              b = 2;
              break;
            } 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b == 3 && BluedLiveListData.class.isInstance(bluedLiveListData)) {
                paramMvpFragment.a(bluedLiveListData);
                return;
              } 
            } else if (LiveRecommendModel.class.isInstance(bluedLiveListData)) {
              paramMvpFragment.b((List)paramList);
              return;
            } 
          } else if (BluedLiveListData.class.isInstance(bluedLiveListData)) {
            paramMvpFragment.a((List)paramList);
            return;
          } 
        } else if (LiveRecommendModel.class.isInstance(bluedLiveListData)) {
          paramMvpFragment.c((List)paramList);
          return;
        } 
      } 
    } 
    a((LiveListFollowFragmentNew)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\live\fragment\LiveListFollowFragmentNew_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */