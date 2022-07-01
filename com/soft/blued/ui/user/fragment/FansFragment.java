package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.blued.android.core.AppMethods;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.view.pulltorefresh.RenrenPullToRefreshListView;
import com.blued.das.profile.PersonalProfileProtos;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.FollowedExtra;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;

public class FansFragment extends PreloadFragment {
  private boolean A = true;
  
  private boolean B;
  
  private String C;
  
  BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, FollowedExtra>>(this, (IRequestHost)w_()) {
      boolean a;
      
      int b;
      
      public boolean onUIFailure(int param1Int, String param1String) {
        this.a = true;
        this.b = param1Int;
        if (FansFragment.d(this.c) != 1)
          FansFragment.f(this.c); 
        return true;
      }
      
      public void onUIFinish() {
        FansFragment.c(this.c).j();
        FansFragment.c(this.c).q();
        if (this.b == 403903) {
          Log.v("drb", "没有访问权限");
          FansFragment.e(this.c).a(new ArrayList());
          FansFragment.h(this.c).setNoDataImg(2131232646);
          FansFragment.h(this.c).setNoDataStr(2131756384);
        } else {
          FansFragment.h(this.c).setNoDataImg(2131232643);
          if ((UserInfo.a().i()).uid.equals(FansFragment.i(this.c))) {
            FansFragment.h(this.c).setNoDataStr(2131758238);
          } else {
            FansFragment.h(this.c).setNoDataStr(2131756841);
          } 
        } 
        if (FansFragment.e(this.c).getCount() == 0) {
          if (this.a) {
            if (this.b == 403903) {
              Log.v("drb", "showNodata");
              FansFragment.h(this.c).a();
            } else {
              Log.v("drb", "showFail");
              FansFragment.h(this.c).b();
            } 
          } else {
            FansFragment.h(this.c).a();
          } 
        } else {
          FansFragment.h(this.c).c();
        } 
        if (FansFragment.j(this.c) && FansFragment.e(this.c).getCount() < 15) {
          FansFragment.a(this.c);
          FansFragment.a(this.c, false);
        } 
        FansFragment.e(this.c).notifyDataSetChanged();
      }
      
      public void onUIUpdate(BluedEntity<BluedRecommendUsers, FollowedExtra> param1BluedEntity) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull -> 55
        //   4: aload_1
        //   5: invokevirtual hasMore : ()Z
        //   8: ifeq -> 33
        //   11: aload_0
        //   12: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   15: iconst_1
        //   16: invokestatic b : (Lcom/soft/blued/ui/user/fragment/FansFragment;Z)Z
        //   19: pop
        //   20: aload_0
        //   21: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   24: invokestatic c : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   27: invokevirtual o : ()V
        //   30: goto -> 55
        //   33: aload_0
        //   34: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   37: iconst_0
        //   38: invokestatic b : (Lcom/soft/blued/ui/user/fragment/FansFragment;Z)Z
        //   41: pop
        //   42: aload_0
        //   43: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   46: invokestatic c : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   49: invokevirtual p : ()V
        //   52: goto -> 55
        //   55: aload_1
        //   56: ifnull -> 111
        //   59: aload_1
        //   60: invokevirtual hasData : ()Z
        //   63: ifeq -> 111
        //   66: aload_0
        //   67: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   70: invokestatic d : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   73: iconst_1
        //   74: if_icmpne -> 94
        //   77: aload_0
        //   78: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   81: invokestatic e : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   84: aload_1
        //   85: getfield data : Ljava/util/List;
        //   88: invokevirtual a : (Ljava/util/List;)V
        //   91: goto -> 212
        //   94: aload_0
        //   95: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   98: invokestatic e : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   101: aload_1
        //   102: getfield data : Ljava/util/List;
        //   105: invokevirtual b : (Ljava/util/List;)V
        //   108: goto -> 212
        //   111: aload_0
        //   112: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   115: invokestatic d : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   118: iconst_1
        //   119: if_icmpne -> 136
        //   122: aload_0
        //   123: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   126: invokestatic e : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   129: aload_1
        //   130: getfield data : Ljava/util/List;
        //   133: invokevirtual a : (Ljava/util/List;)V
        //   136: aload_0
        //   137: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   140: invokestatic d : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   143: iconst_1
        //   144: if_icmpeq -> 194
        //   147: aload_0
        //   148: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   151: invokestatic f : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   154: pop
        //   155: aload_0
        //   156: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   159: iconst_0
        //   160: invokestatic b : (Lcom/soft/blued/ui/user/fragment/FansFragment;Z)Z
        //   163: pop
        //   164: aload_0
        //   165: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   168: invokestatic c : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   171: invokevirtual p : ()V
        //   174: aload_0
        //   175: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   178: invokestatic c : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   181: invokevirtual j : ()V
        //   184: aload_0
        //   185: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   188: invokestatic c : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   191: invokevirtual q : ()V
        //   194: aload_0
        //   195: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   198: invokestatic g : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Landroid/content/Context;
        //   201: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   204: ldc 2131756083
        //   206: invokevirtual getString : (I)Ljava/lang/String;
        //   209: invokestatic a : (Ljava/lang/CharSequence;)V
        //   212: aload_1
        //   213: ifnull -> 249
        //   216: aload_1
        //   217: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   220: ifnull -> 249
        //   223: aload_1
        //   224: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   227: checkcast com/soft/blued/ui/user/model/FollowedExtra
        //   230: getfield count_repair : I
        //   233: iconst_1
        //   234: if_icmpne -> 249
        //   237: aload_0
        //   238: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   241: invokestatic b : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Landroid/widget/TextView;
        //   244: iconst_0
        //   245: invokevirtual setVisibility : (I)V
        //   248: return
        //   249: aload_0
        //   250: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   253: invokestatic b : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Landroid/widget/TextView;
        //   256: bipush #8
        //   258: invokevirtual setVisibility : (I)V
        //   261: return
        //   262: aload_1
        //   263: invokevirtual printStackTrace : ()V
        //   266: aload_0
        //   267: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   270: invokestatic g : (Lcom/soft/blued/ui/user/fragment/FansFragment;)Landroid/content/Context;
        //   273: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   276: ldc 2131756082
        //   278: invokevirtual getString : (I)Ljava/lang/String;
        //   281: invokestatic a : (Ljava/lang/CharSequence;)V
        //   284: aload_0
        //   285: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   288: invokestatic d : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   291: iconst_1
        //   292: if_icmpeq -> 303
        //   295: aload_0
        //   296: getfield c : Lcom/soft/blued/ui/user/fragment/FansFragment;
        //   299: invokestatic f : (Lcom/soft/blued/ui/user/fragment/FansFragment;)I
        //   302: pop
        //   303: return
        //   304: astore_1
        //   305: goto -> 262
        // Exception table:
        //   from	to	target	type
        //   4	30	304	java/lang/Exception
        //   33	52	304	java/lang/Exception
        //   59	91	304	java/lang/Exception
        //   94	108	304	java/lang/Exception
        //   111	136	304	java/lang/Exception
        //   136	194	304	java/lang/Exception
        //   194	212	304	java/lang/Exception
        //   216	248	304	java/lang/Exception
        //   249	261	304	java/lang/Exception
      }
    };
  
  private Context p;
  
  private View q;
  
  private RenrenPullToRefreshListView r;
  
  private ListView s;
  
  private View t;
  
  private TextView u;
  
  private LayoutInflater v;
  
  private RecommendListAdapter w;
  
  private NoDataAndLoadFailView x;
  
  private int y;
  
  private int z = 20;
  
  private void a(boolean paramBoolean) {
    if (paramBoolean)
      this.y = 1; 
    if (this.y == 1)
      this.A = true; 
    if (!this.A) {
      int i = this.y;
      if (i != 1) {
        this.y = i - 1;
        AppMethods.a(this.p.getResources().getString(2131756083));
        this.r.j();
        this.r.q();
        return;
      } 
    } 
    Context context = this.p;
    BluedUIHttpResponse bluedUIHttpResponse = this.o;
    String str1 = this.C;
    StringBuilder stringBuilder1 = new StringBuilder();
    stringBuilder1.append(this.y);
    stringBuilder1.append("");
    String str2 = stringBuilder1.toString();
    StringBuilder stringBuilder2 = new StringBuilder();
    stringBuilder2.append(this.z);
    stringBuilder2.append("");
    MineHttpUtils.d(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void t() {
    this.v = LayoutInflater.from(this.p);
    this.r = (RenrenPullToRefreshListView)this.q.findViewById(2131298144);
    this.r.setRefreshEnabled(true);
    this.s = (ListView)this.r.getRefreshableView();
    this.s.setClipToPadding(false);
    this.s.setScrollBarStyle(33554432);
    this.s.setHeaderDividersEnabled(false);
    this.s.setDividerHeight(0);
    u();
    if (BluedConstant.e == 1) {
      this.r.k();
      this.B = true;
    } 
    this.w = new RecommendListAdapter(this.p, 1, v(), (IRequestHost)w_());
    this.s.setAdapter((ListAdapter)this.w);
    this.r.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            FansFragment.a(this.a, 1);
            FansFragment.a(this.a, false);
          }
          
          public void b() {
            FansFragment.a(this.a);
            FansFragment.a(this.a, false);
          }
        });
  }
  
  private void u() {
    this.t = this.v.inflate(2131493782, null, false);
    this.u = (TextView)this.t.findViewById(2131301393);
    String str = getContext().getString(2131758273);
    this.u.setText(str);
    TypefaceUtils.a(getContext(), this.u, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK);
            MineHttpUtils.c(null, "followers");
            FansFragment.b(this.a).setVisibility(8);
            AppMethods.d(2131758274);
          }
        }new TypefaceUtils.SpannIndex(str.length() - 4, str.length()), new TypefaceUtils.SpannIndex(str.length() - 14, str.length()));
    this.s.addHeaderView(this.t);
    this.u.setVisibility(8);
  }
  
  private boolean v() {
    return TextUtils.isEmpty(this.C) ? false : (this.C.equals(UserInfo.a().i().getUid()));
  }
  
  public void a(View paramView) {
    this.p = (Context)getActivity();
    LayoutInflater layoutInflater = LayoutInflater.from(this.p);
    this.q = paramView;
    View view = layoutInflater.inflate(2131493364, null);
    ((ViewGroup)paramView).addView(view);
    this.x = new NoDataAndLoadFailView(this.p);
    this.x.setNoDataImg(2131232643);
    this.x.c();
    if (getArguments() != null)
      this.C = getArguments().getString("uid"); 
    if ((UserInfo.a().i()).uid.equals(this.C)) {
      this.x.setNoDataStr(2131758238);
    } else {
      this.x.setNoDataStr(2131756841);
    } 
    ((FrameLayout)this.q.findViewById(2131297224)).addView((View)this.x);
    t();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean && !this.B) {
      RenrenPullToRefreshListView renrenPullToRefreshListView = this.r;
      if (renrenPullToRefreshListView != null) {
        renrenPullToRefreshListView.k();
        this.B = true;
      } 
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\FansFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */