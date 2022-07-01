package com.soft.blued.ui.circle.presenter;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.ui.mvp.IFetchDataListener;
import com.blued.android.framework.ui.mvp.MvpPresenter;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.ui.circle.adapter.CircleMemberAdapter;
import com.soft.blued.ui.discover.model.CircleBaseMember;
import java.util.ArrayList;

public class CircleJoinMemberPresenter extends MvpPresenter {
  protected String h;
  
  protected int i;
  
  protected int j = 1;
  
  protected int k = 30;
  
  protected boolean l = true;
  
  protected CircleMemberAdapter m;
  
  private boolean n;
  
  public void a(FragmentActivity paramFragmentActivity, Bundle paramBundle1, Bundle paramBundle2) {
    super.a(paramFragmentActivity, paramBundle1, paramBundle2);
    if (paramBundle1 != null) {
      this.h = paramBundle1.getString("circle_id");
      this.i = paramBundle1.getInt("admin_level");
    } 
  }
  
  public void a(IFetchDataListener paramIFetchDataListener) {
    this.j = 1;
    this.l = true;
    this.n = false;
    c(paramIFetchDataListener);
  }
  
  public void a(CircleMemberAdapter paramCircleMemberAdapter) {
    this.m = paramCircleMemberAdapter;
  }
  
  public void a(CircleBaseMember.Member paramMember, int paramInt) {
    if (paramMember.is_mute == 1) {
      CircleHttpUtils.a(this.h, new BluedUIHttpResponse(this, g(), paramMember) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              this.a.is_mute = 0;
              this.b.m.notifyDataSetChanged();
            }
          }paramMember.uid, paramMember.is_anonym, g());
      return;
    } 
    CircleHttpUtils.a(this.h, new BluedUIHttpResponse(this, g(), paramMember) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.is_mute = 1;
            this.b.m.notifyDataSetChanged();
          }
        }paramMember.uid, paramMember.is_anonym, paramMember.name, paramMember.avatar, g());
  }
  
  public void b(IFetchDataListener paramIFetchDataListener) {
    this.j++;
    c(paramIFetchDataListener);
  }
  
  public void b(CircleBaseMember.Member paramMember, int paramInt) {
    CircleHttpUtils.c(this.h, new BluedUIHttpResponse(this, g(), paramInt) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.b.m.d(this.a);
            this.b.m.e(false);
          }
        }paramMember.uid, "3", g());
  }
  
  protected void c(IFetchDataListener paramIFetchDataListener) {
    String str1 = this.h;
    BluedUIHttpResponse<BluedEntityA<CircleBaseMember>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<CircleBaseMember>>(this, g(), paramIFetchDataListener) {
        protected void a(BluedEntityA<CircleBaseMember> param1BluedEntityA) {
          if (param1BluedEntityA.hasData()) {
            this.b.i = ((CircleBaseMember)param1BluedEntityA.data.get(0)).admin_level;
            if (this.a != null) {
              ArrayList<CircleBaseMember.MemberHeader> arrayList = new ArrayList();
              if (this.b.j == 1 && ((CircleBaseMember)param1BluedEntityA.data.get(0)).admins != null && !((CircleBaseMember)param1BluedEntityA.data.get(0)).admins.isEmpty()) {
                CircleBaseMember.MemberHeader memberHeader = new CircleBaseMember.MemberHeader();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.b.h().getString(2131755899));
                stringBuilder.append("/");
                stringBuilder.append(this.b.h().getString(2131755890));
                ((CircleBaseMember.Member)memberHeader).name = stringBuilder.toString();
                ((CircleBaseMember.Member)memberHeader).number = ((CircleBaseMember)param1BluedEntityA.data.get(0)).admins_num;
                ((CircleBaseMember.Member)memberHeader).adapterType = 1;
                arrayList.add(memberHeader);
                arrayList.addAll(((CircleBaseMember)param1BluedEntityA.data.get(0)).admins);
              } 
              if (((CircleBaseMember)param1BluedEntityA.data.get(0)).members != null && !((CircleBaseMember)param1BluedEntityA.data.get(0)).members.isEmpty()) {
                if (!CircleJoinMemberPresenter.a(this.b)) {
                  CircleBaseMember.MemberHeader memberHeader = new CircleBaseMember.MemberHeader();
                  ((CircleBaseMember.Member)memberHeader).name = this.b.h().getString(2131757871);
                  ((CircleBaseMember.Member)memberHeader).number = ((CircleBaseMember)param1BluedEntityA.data.get(0)).members_num;
                  ((CircleBaseMember.Member)memberHeader).adapterType = 2;
                  arrayList.add(memberHeader);
                  CircleJoinMemberPresenter.a(this.b, true);
                } 
                arrayList.addAll(((CircleBaseMember)param1BluedEntityA.data.get(0)).members);
              } 
              this.a.a("data_member", arrayList);
            } 
            this.b.l = param1BluedEntityA.hasMore();
            return;
          } 
          this.b.l = false;
        }
        
        public void onUIFinish(boolean param1Boolean) {
          super.onUIFinish(param1Boolean);
          if (!param1Boolean && this.b.j > 0) {
            CircleJoinMemberPresenter circleJoinMemberPresenter = this.b;
            circleJoinMemberPresenter.j--;
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
    CircleHttpUtils.a(str1, bluedUIHttpResponse, str2, stringBuilder2.toString(), g());
  }
  
  public void c(CircleBaseMember.Member paramMember, int paramInt) {
    if (paramMember.isManager()) {
      CircleHttpUtils.c(this.h, new BluedUIHttpResponse(this, g(), paramMember, paramInt) {
            public void onUIUpdate(BluedEntity param1BluedEntity) {
              this.a.setMember();
              this.c.m.notifyDataSetChanged();
              this.c.m.a(false);
              this.c.m.e(true);
              this.c.m.d(this.b);
              this.c.m.a(this.a);
            }
          }paramMember.uid, "2", g());
      return;
    } 
    CircleHttpUtils.c(this.h, new BluedUIHttpResponse(this, g(), paramMember, paramInt) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            this.a.setManager();
            this.c.m.notifyDataSetChanged();
            this.c.m.a(true);
            this.c.m.e(false);
            this.c.m.d(this.b);
            this.c.m.a(2, this.a);
          }
        }paramMember.uid, "1", g());
  }
  
  public String m() {
    return this.h;
  }
  
  public int n() {
    return this.i;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\presenter\CircleJoinMemberPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */