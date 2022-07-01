package com.soft.blued.ui.msg;

import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.ui.mvp.MvpDispatcher;
import com.blued.android.framework.ui.mvp.MvpFragment;
import com.soft.blued.ui.find.model.HelloDataExtra;
import java.util.List;

public final class MsgFragment_MVP implements MvpDispatcher {
  private void a(MsgFragment paramMsgFragment, String paramString) {
    byte b;
    switch (paramString.hashCode()) {
      default:
        b = -1;
        break;
      case 1445862261:
        if (paramString.equals("hideHelloView")) {
          b = 2;
          break;
        } 
      case 857162668:
        if (paramString.equals("showDeletedMsgHint")) {
          b = 1;
          break;
        } 
      case 749411636:
        if (paramString.equals("refreshComplete")) {
          b = 3;
          break;
        } 
      case -735794347:
        if (paramString.equals("showMsgBoxGuide")) {
          b = 0;
          break;
        } 
    } 
    if (b != 0) {
      if (b != 1) {
        if (b != 2) {
          if (b != 3)
            return; 
          paramMsgFragment.n();
          return;
        } 
        paramMsgFragment.E();
        return;
      } 
      paramMsgFragment.m();
      return;
    } 
    paramMsgFragment.l();
  }
  
  public void a(MvpFragment paramMvpFragment, String paramString, List<List> paramList) {
    paramMvpFragment = paramMvpFragment;
    if (paramList != null && paramList.size() > 0) {
      byte b = 0;
      paramList = paramList.get(0);
      if (paramList != null) {
        switch (paramString.hashCode()) {
          default:
            b = -1;
            break;
          case 2044212671:
            if (paramString.equals("filterOpenHasNewMessage")) {
              b = 3;
              break;
            } 
          case 1740154169:
            if (paramString.equals("addHelloListData"))
              break; 
          case 868298632:
            if (paramString.equals("helloViewShowBtn")) {
              b = 4;
              break;
            } 
          case -256514471:
            if (paramString.equals("setNewHelloView")) {
              b = 5;
              break;
            } 
          case -256577311:
            if (paramString.equals("setNewHelloText")) {
              b = 2;
              break;
            } 
          case -1674097786:
            if (paramString.equals("dataUpdateFinish")) {
              b = 1;
              break;
            } 
        } 
        if (b != 0) {
          if (b != 1) {
            if (b != 2) {
              if (b != 3) {
                if (b != 4) {
                  if (b == 5 && HelloDataExtra.class.isInstance(paramList)) {
                    paramMvpFragment.b((HelloDataExtra)paramList);
                    return;
                  } 
                } else if (Boolean.class.isInstance(paramList)) {
                  paramMvpFragment.a((Boolean)paramList);
                  return;
                } 
              } else if (Boolean.class.isInstance(paramList)) {
                paramMvpFragment.b((Boolean)paramList);
                return;
              } 
            } else if (HelloDataExtra.class.isInstance(paramList)) {
              paramMvpFragment.a((HelloDataExtra)paramList);
              return;
            } 
          } else if (Integer.class.isInstance(paramList)) {
            paramMvpFragment.a((Integer)paramList);
            return;
          } 
        } else if (BluedEntity.class.isInstance(paramList)) {
          paramMvpFragment.a((BluedEntity)paramList);
          return;
        } 
      } 
    } 
    a((MsgFragment)paramMvpFragment, paramString);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\MsgFragment_MVP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */