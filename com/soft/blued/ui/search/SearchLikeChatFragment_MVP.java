package com.soft.blued.ui.search;

import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.search.model.SearchSessionModel;
import java.util.List;

public final class SearchLikeChatFragment_MVP implements MvpDispatcher {
  private void a(SearchLikeChatFragment paramSearchLikeChatFragment, String paramString) {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual hashCode : ()I
    //   4: istore_3
    //   5: iload_3
    //   6: ldc -1059378096
    //   8: if_icmpeq -> 54
    //   11: iload_3
    //   12: ldc -979726365
    //   14: if_icmpeq -> 40
    //   17: iload_3
    //   18: ldc -254638518
    //   20: if_icmpeq -> 26
    //   23: goto -> 68
    //   26: aload_2
    //   27: ldc 'no_more_list'
    //   29: invokevirtual equals : (Ljava/lang/Object;)Z
    //   32: ifeq -> 68
    //   35: iconst_0
    //   36: istore_3
    //   37: goto -> 70
    //   40: aload_2
    //   41: ldc 'has_more_list'
    //   43: invokevirtual equals : (Ljava/lang/Object;)Z
    //   46: ifeq -> 68
    //   49: iconst_1
    //   50: istore_3
    //   51: goto -> 70
    //   54: aload_2
    //   55: ldc 'empty_list'
    //   57: invokevirtual equals : (Ljava/lang/Object;)Z
    //   60: ifeq -> 68
    //   63: iconst_2
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
    //   91: invokevirtual m : ()V
    //   94: return
    //   95: aload_1
    //   96: invokevirtual l : ()V
    //   99: return
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<Object> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      Object object = paramList.get(0);
      if (object != null) {
        if (paramString.hashCode() != -1742866476 || !paramString.equals("notify_list"))
          b = -1; 
        if (b == 0 && SearchSessionModel.class.isInstance(object)) {
          paramMvpFragment.a((List)paramList);
          return;
        } 
      } 
    } 
    a((SearchLikeChatFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\search\SearchLikeChatFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */