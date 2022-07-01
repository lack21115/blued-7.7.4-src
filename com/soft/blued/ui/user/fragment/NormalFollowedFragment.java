package com.soft.blued.ui.user.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackPersonalProfile;
import com.soft.blued.ui.find.adapter.RecommendListAdapter;
import com.soft.blued.ui.find.model.BluedRecommendUsers;
import com.soft.blued.ui.user.model.FollowedExtra;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.TypefaceUtils;
import java.util.ArrayList;

public class NormalFollowedFragment extends PreloadFragment {
  private boolean A = true;
  
  private boolean B = false;
  
  private String C;
  
  BluedUIHttpResponse o = new BluedUIHttpResponse<BluedEntity<BluedRecommendUsers, FollowedExtra>>(this, (IRequestHost)w_()) {
      int a;
      
      public boolean onUIFailure(int param1Int, String param1String1, String param1String2) {
        this.a = param1Int;
        NormalFollowedFragment.c(this.b, true);
        if (NormalFollowedFragment.d(this.b) != 1)
          NormalFollowedFragment.f(this.b); 
        return true;
      }
      
      public void onUIFinish() {
        NormalFollowedFragment.c(this.b).j();
        NormalFollowedFragment.c(this.b).q();
        if (!(UserInfo.a().i()).uid.equals(NormalFollowedFragment.h(this.b)))
          if (this.a == 403903) {
            NormalFollowedFragment.e(this.b).a(new ArrayList());
            NormalFollowedFragment.i(this.b).setNoDataImg(2131232646);
            NormalFollowedFragment.i(this.b).setNoDataStr(2131756384);
          } else {
            NormalFollowedFragment.i(this.b).setNoDataImg(2131232643);
            if ((UserInfo.a().i()).uid.equals(NormalFollowedFragment.h(this.b))) {
              NormalFollowedFragment.i(this.b).setNoDataStr(2131758241);
            } else {
              NormalFollowedFragment.i(this.b).setNoDataStr(2131756842);
            } 
          }  
        if (NormalFollowedFragment.j(this.b)) {
          NormalFollowedFragment.c(this.b, false);
          if (NormalFollowedFragment.e(this.b).getCount() == 0) {
            if (this.a == 403903) {
              NormalFollowedFragment.i(this.b).a();
            } else {
              NormalFollowedFragment.i(this.b).b();
            } 
          } else {
            NormalFollowedFragment.i(this.b).c();
          } 
        } else if (NormalFollowedFragment.e(this.b).getCount() == 0) {
          NormalFollowedFragment.i(this.b).a();
        } else {
          NormalFollowedFragment.i(this.b).c();
        } 
        if (NormalFollowedFragment.k(this.b) && NormalFollowedFragment.e(this.b).getCount() < 15) {
          NormalFollowedFragment.a(this.b);
          NormalFollowedFragment.a(this.b, false);
        } 
        NormalFollowedFragment.e(this.b).notifyDataSetChanged();
      }
      
      public void onUIUpdate(BluedEntity<BluedRecommendUsers, FollowedExtra> param1BluedEntity) {
        // Byte code:
        //   0: aload_1
        //   1: ifnull -> 111
        //   4: aload_1
        //   5: getfield data : Ljava/util/List;
        //   8: ifnull -> 111
        //   11: aload_1
        //   12: invokevirtual hasData : ()Z
        //   15: ifeq -> 111
        //   18: aload_1
        //   19: invokevirtual hasMore : ()Z
        //   22: ifeq -> 47
        //   25: aload_0
        //   26: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   29: iconst_1
        //   30: invokestatic b : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;Z)Z
        //   33: pop
        //   34: aload_0
        //   35: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   38: invokestatic c : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   41: invokevirtual o : ()V
        //   44: goto -> 66
        //   47: aload_0
        //   48: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   51: iconst_0
        //   52: invokestatic b : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;Z)Z
        //   55: pop
        //   56: aload_0
        //   57: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   60: invokestatic c : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   63: invokevirtual p : ()V
        //   66: aload_0
        //   67: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   70: invokestatic d : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   73: iconst_1
        //   74: if_icmpne -> 94
        //   77: aload_0
        //   78: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   81: invokestatic e : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   84: aload_1
        //   85: getfield data : Ljava/util/List;
        //   88: invokevirtual a : (Ljava/util/List;)V
        //   91: goto -> 216
        //   94: aload_0
        //   95: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   98: invokestatic e : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   101: aload_1
        //   102: getfield data : Ljava/util/List;
        //   105: invokevirtual b : (Ljava/util/List;)V
        //   108: goto -> 216
        //   111: aload_1
        //   112: ifnull -> 140
        //   115: aload_0
        //   116: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   119: invokestatic d : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   122: iconst_1
        //   123: if_icmpne -> 140
        //   126: aload_0
        //   127: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   130: invokestatic e : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/soft/blued/ui/find/adapter/RecommendListAdapter;
        //   133: aload_1
        //   134: getfield data : Ljava/util/List;
        //   137: invokevirtual a : (Ljava/util/List;)V
        //   140: aload_0
        //   141: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   144: invokestatic d : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   147: iconst_1
        //   148: if_icmple -> 216
        //   151: aload_0
        //   152: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   155: invokestatic f : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   158: pop
        //   159: aload_0
        //   160: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   163: iconst_0
        //   164: invokestatic b : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;Z)Z
        //   167: pop
        //   168: aload_0
        //   169: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   172: invokestatic c : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   175: invokevirtual p : ()V
        //   178: aload_0
        //   179: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   182: invokestatic c : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   185: invokevirtual j : ()V
        //   188: aload_0
        //   189: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   192: invokestatic c : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Lcom/blued/android/framework/view/pulltorefresh/RenrenPullToRefreshListView;
        //   195: invokevirtual q : ()V
        //   198: aload_0
        //   199: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   202: invokestatic g : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Landroid/content/Context;
        //   205: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   208: ldc 2131756083
        //   210: invokevirtual getString : (I)Ljava/lang/String;
        //   213: invokestatic a : (Ljava/lang/CharSequence;)V
        //   216: aload_1
        //   217: ifnull -> 253
        //   220: aload_1
        //   221: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   224: ifnull -> 253
        //   227: aload_1
        //   228: getfield extra : Lcom/blued/android/framework/http/parser/BluedEntityBaseExtra;
        //   231: checkcast com/soft/blued/ui/user/model/FollowedExtra
        //   234: getfield count_repair : I
        //   237: iconst_1
        //   238: if_icmpne -> 253
        //   241: aload_0
        //   242: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   245: invokestatic b : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Landroid/widget/TextView;
        //   248: iconst_0
        //   249: invokevirtual setVisibility : (I)V
        //   252: return
        //   253: aload_0
        //   254: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   257: invokestatic b : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Landroid/widget/TextView;
        //   260: bipush #8
        //   262: invokevirtual setVisibility : (I)V
        //   265: return
        //   266: aload_1
        //   267: invokevirtual printStackTrace : ()V
        //   270: aload_0
        //   271: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   274: invokestatic g : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)Landroid/content/Context;
        //   277: invokevirtual getResources : ()Landroid/content/res/Resources;
        //   280: ldc 2131756082
        //   282: invokevirtual getString : (I)Ljava/lang/String;
        //   285: invokestatic a : (Ljava/lang/CharSequence;)V
        //   288: aload_0
        //   289: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   292: invokestatic d : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   295: iconst_1
        //   296: if_icmpeq -> 307
        //   299: aload_0
        //   300: getfield b : Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;
        //   303: invokestatic f : (Lcom/soft/blued/ui/user/fragment/NormalFollowedFragment;)I
        //   306: pop
        //   307: return
        //   308: astore_1
        //   309: goto -> 266
        // Exception table:
        //   from	to	target	type
        //   4	44	308	java/lang/Exception
        //   47	66	308	java/lang/Exception
        //   66	91	308	java/lang/Exception
        //   94	108	308	java/lang/Exception
        //   115	140	308	java/lang/Exception
        //   140	216	308	java/lang/Exception
        //   220	252	308	java/lang/Exception
        //   253	265	308	java/lang/Exception
      }
    };
  
  private Context p;
  
  private View q;
  
  private NoDataAndLoadFailView r;
  
  private RenrenPullToRefreshListView s;
  
  private ListView t;
  
  private View u;
  
  private TextView v;
  
  private LayoutInflater w;
  
  private RecommendListAdapter x;
  
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
        this.s.j();
        this.s.q();
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
    MineHttpUtils.e(context, bluedUIHttpResponse, str1, str2, stringBuilder2.toString(), (IRequestHost)w_());
  }
  
  private void t() {
    this.w = LayoutInflater.from(this.p);
    this.s = (RenrenPullToRefreshListView)this.q.findViewById(2131298144);
    this.s.setRefreshEnabled(true);
    this.t = (ListView)this.s.getRefreshableView();
    this.t.setClipToPadding(false);
    this.t.setScrollBarStyle(33554432);
    this.t.setHeaderDividersEnabled(false);
    this.t.setDividerHeight(0);
    u();
    this.s.k();
    this.x = new RecommendListAdapter(this.p, 2, v(), (IRequestHost)w_());
    this.t.setAdapter((ListAdapter)this.x);
    this.s.setOnPullDownListener(new RenrenPullToRefreshListView.OnPullDownListener(this) {
          public void a() {
            NormalFollowedFragment.a(this.a, 1);
            NormalFollowedFragment.a(this.a, false);
          }
          
          public void b() {
            NormalFollowedFragment.a(this.a);
            NormalFollowedFragment.a(this.a, false);
          }
        });
  }
  
  private void u() {
    this.u = this.w.inflate(2131493782, null, false);
    this.v = (TextView)this.u.findViewById(2131301393);
    String str = getContext().getString(2131758273);
    this.v.setText(str);
    TypefaceUtils.a(getContext(), this.v, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            EventTrackPersonalProfile.a(PersonalProfileProtos.Event.PERSONAL_FOLLOW_LIST_CLEAR_INVALID_USERS_CLICK);
            MineHttpUtils.c(null, "followed");
            NormalFollowedFragment.b(this.a).setVisibility(8);
            AppMethods.d(2131758274);
          }
        }new TypefaceUtils.SpannIndex(str.length() - 4, str.length()), new TypefaceUtils.SpannIndex(str.length() - 14, str.length()));
    this.t.addHeaderView(this.u);
    this.v.setVisibility(8);
  }
  
  private boolean v() {
    return TextUtils.isEmpty(this.C) ? false : (this.C.equals(UserInfo.a().i().getUid()));
  }
  
  public void a(View paramView) {
    this.q = paramView;
    this.p = (Context)getActivity();
    this.w = LayoutInflater.from(this.p);
    this.w.inflate(2131493364, (ViewGroup)this.q, true);
    this.r = new NoDataAndLoadFailView(this.p);
    this.r.setNoDataImg(2131232643);
    this.r.c();
    if (getArguments() != null)
      this.C = getArguments().getString("uid"); 
    if ((UserInfo.a().i()).uid.equals(this.C)) {
      this.r.setNoDataStr(2131758241);
    } else {
      this.r.setNoDataStr(2131756842);
    } 
    ((FrameLayout)this.q.findViewById(2131297224)).addView((View)this.r);
    t();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle) {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\u\\user\fragment\NormalFollowedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */