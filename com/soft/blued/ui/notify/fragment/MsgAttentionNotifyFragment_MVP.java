package com.soft.blued.ui.notify.fragment;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.notify.model.FeedNotice;
import java.util.List;

public final class MsgAttentionNotifyFragment_MVP implements MvpDispatcher {
  private void a(MsgAttentionNotifyFragment paramMsgAttentionNotifyFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc 1243180967
    //   8: if_icmpeq -> 34
    //   11: iload_3
    //   12: ldc 2071979985
    //   14: if_icmpeq -> 20
    //   17: goto -> 48
    //   20: aload_2
    //   21: ldc 'SHOW_LOAD_ERROR'
    //   23: invokevirtual equals : (Ljava/lang/Object;)Z
    //   26: ifeq -> 48
    //   29: iconst_1
    //   30: istore_3
    //   31: goto -> 50
    //   34: aload_2
    //   35: ldc 'ATTENTION_NOTICE_CLEAR'
    //   37: invokevirtual equals : (Ljava/lang/Object;)Z
    //   40: ifeq -> 48
    //   43: iconst_0
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
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != 1980030948 || !paramString.equals("ATTENTION_NOTICE_LIST"))
          b = -1; 
        if (b == 0 && FeedNotice.class.isInstance(object)) {
          paramMvpFragment.a((List)paramList);
          return;
        } 
      } 
    } 
    a((MsgAttentionNotifyFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\fragment\MsgAttentionNotifyFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */