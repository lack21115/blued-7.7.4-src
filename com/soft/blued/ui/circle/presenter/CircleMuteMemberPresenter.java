package com.soft.blued.ui.circle.presenter;

import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.discover.model.CircleBaseMember;

public class CircleMuteMemberPresenter extends CircleJoinMemberPresenter {
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.j = 1;
    this.l = true;
    c(paramIFetchDataListener);
  }
  
  public void a(CircleBaseMember.Member paramMember, int paramInt) {
    CircleHttpUtils.a(this.h, new BluedUIHttpResponse(this, g(), paramInt) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.m.d(this.a);
          }
        }paramMember.uid, paramMember.is_anonym, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.j++;
    c(paramIFetchDataListener);
  }
  
  protected void c(IFetchDataListener paramIFetchDataListener) {
    String str1 = this.h;
    BluedUIHttpResponse<BluedEntityA<CircleBaseMember.Member>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<CircleBaseMember.Member>>(this, g(), paramIFetchDataListener) {
        protected void a(BluedEntityA<CircleBaseMember.Member> param1BluedEntityA) {
          if (param1BluedEntityA.hasData()) {
            IFetchDataListener iFetchDataListener = this.a;
            if (iFetchDataListener != null)
              iFetchDataListener.a("data_member", param1BluedEntityA.data); 
            this.b.l = param1BluedEntityA.hasMore();
            return;
          } 
          this.b.l = false;
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean && this.b.j > 0) {
            CircleMuteMemberPresenter circleMuteMemberPresenter = this.b;
            circleMuteMemberPresenter.j--;
          } 
          if (!this.b.l)
            this.a.b(); 
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(param1Boolean); 
        }
        
        public void onUIStart() {
          super.onUIStart();
          IFetchDataListener iFetchDataListener = this.a;
          if (iFetchDataListener != null)
            iFetchDataListener.a(); 
        }
      };
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.j);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.k);
    stringBuilder2.append("");
    CircleHttpUtils.b(str1, bluedUIHttpResponse, str2, stringBuilder2.toString(), g());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleMuteMemberPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */