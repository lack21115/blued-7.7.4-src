package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.http.ChatHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.model.FriendsModel;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.user.UserInfo;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.List;

public class ShareToFriendsFragment extends PreloadFragment {
  private View A;
  
  private SearchEditText B;
  
  private FrameLayout C;
  
  private ProgressBar D;
  
  private RecyclerView E;
  
  private SearchView F;
  
  private PullToRefreshRecyclerView G;
  
  private FriendsModel H;
  
  private int I = 0;
  
  private ShareToMsgEntity J;
  
  private String K;
  
  private final int o = 20;
  
  private int p = 1;
  
  private int q = 1;
  
  private boolean r = true;
  
  private boolean s = false;
  
  private boolean t;
  
  private boolean u;
  
  private boolean v;
  
  private boolean w;
  
  private Context x;
  
  private FriendListAdapter y;
  
  private NoDataAndLoadFailView z;
  
  public static ShareToFriendsFragment a(Bundle paramBundle) {
    ShareToFriendsFragment shareToFriendsFragment = new ShareToFriendsFragment();
    if (paramBundle != null)
      shareToFriendsFragment.setArguments(paramBundle); 
    return shareToFriendsFragment;
  }
  
  private String a(BluedBlackList paramBluedBlackList) {
    return (paramBluedBlackList == null) ? "" : (!TextUtils.isEmpty(paramBluedBlackList.note) ? paramBluedBlackList.note : (!TextUtils.isEmpty(paramBluedBlackList.name) ? paramBluedBlackList.name : ""));
  }
  
  private void a(BluedEntityA<BluedBlackList> paramBluedEntityA, boolean paramBoolean) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 176
    //   4: aload_1
    //   5: invokevirtual hasData : ()Z
    //   8: ifeq -> 176
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield t : Z
    //   16: aload_0
    //   17: iconst_0
    //   18: putfield u : Z
    //   21: aload_0
    //   22: getfield p : I
    //   25: iconst_1
    //   26: if_icmpne -> 137
    //   29: iload_2
    //   30: ifne -> 61
    //   33: iload_2
    //   34: ifne -> 47
    //   37: aload_0
    //   38: getfield r : Z
    //   41: ifne -> 47
    //   44: goto -> 61
    //   47: aload_0
    //   48: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   51: aload_1
    //   52: getfield data : Ljava/util/List;
    //   55: invokevirtual c : (Ljava/util/List;)V
    //   58: goto -> 148
    //   61: aload_0
    //   62: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   65: invokevirtual n : ()Ljava/util/List;
    //   68: invokeinterface size : ()I
    //   73: istore #4
    //   75: iconst_0
    //   76: istore_3
    //   77: iload_3
    //   78: iload #4
    //   80: iconst_1
    //   81: isub
    //   82: if_icmpge -> 100
    //   85: aload_0
    //   86: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   89: iconst_1
    //   90: invokevirtual d : (I)V
    //   93: iload_3
    //   94: iconst_1
    //   95: iadd
    //   96: istore_3
    //   97: goto -> 77
    //   100: aload_0
    //   101: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   104: aload_1
    //   105: getfield data : Ljava/util/List;
    //   108: invokevirtual a : (Ljava/util/Collection;)V
    //   111: aload_0
    //   112: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   115: invokevirtual n : ()Ljava/util/List;
    //   118: invokeinterface size : ()I
    //   123: ifle -> 148
    //   126: aload_0
    //   127: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   130: iconst_0
    //   131: invokevirtual d : (I)V
    //   134: goto -> 148
    //   137: aload_0
    //   138: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   141: aload_1
    //   142: getfield data : Ljava/util/List;
    //   145: invokevirtual a : (Ljava/util/Collection;)V
    //   148: aload_0
    //   149: aload_1
    //   150: invokevirtual hasMore : ()Z
    //   153: putfield v : Z
    //   156: aload_0
    //   157: aload_1
    //   158: invokevirtual hasMore : ()Z
    //   161: putfield w : Z
    //   164: aload_0
    //   165: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   168: aload_0
    //   169: getfield v : Z
    //   172: invokevirtual c : (Z)V
    //   175: return
    //   176: aload_0
    //   177: iconst_1
    //   178: putfield t : Z
    //   181: aload_0
    //   182: iconst_1
    //   183: putfield u : Z
    //   186: iload_2
    //   187: ifeq -> 201
    //   190: aload_0
    //   191: getfield q : I
    //   194: iconst_1
    //   195: if_icmpeq -> 245
    //   198: goto -> 209
    //   201: aload_0
    //   202: getfield p : I
    //   205: iconst_1
    //   206: if_icmpeq -> 245
    //   209: aload_0
    //   210: getfield y : Lcom/soft/blued/ui/msg/ShareToFriendsFragment$FriendListAdapter;
    //   213: invokevirtual n : ()Ljava/util/List;
    //   216: invokeinterface size : ()I
    //   221: ifle -> 245
    //   224: aload_0
    //   225: getfield x : Landroid/content/Context;
    //   228: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   231: ldc 2131756083
    //   233: invokevirtual getString : (I)Ljava/lang/String;
    //   236: invokestatic a : (Ljava/lang/CharSequence;)V
    //   239: return
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual printStackTrace : ()V
    //   245: return
    // Exception table:
    //   from	to	target	type
    //   4	29	240	java/lang/Exception
    //   37	44	240	java/lang/Exception
    //   47	58	240	java/lang/Exception
    //   61	75	240	java/lang/Exception
    //   85	93	240	java/lang/Exception
    //   100	134	240	java/lang/Exception
    //   137	148	240	java/lang/Exception
    //   148	175	240	java/lang/Exception
    //   176	186	240	java/lang/Exception
    //   190	198	240	java/lang/Exception
    //   201	209	240	java/lang/Exception
    //   209	239	240	java/lang/Exception
  }
  
  private void a(String paramString) {
    if (!this.r)
      w(); 
    if (this.H.data.size() > 0 && !TextUtils.isEmpty(paramString)) {
      if (!u()) {
        this.z.a();
        this.y.e((View)this.z);
      } 
      ChatHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this) {
            boolean a = false;
            
            protected void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
              this.a = false;
              ShareToFriendsFragment.a(this.b, param1BluedEntityA, true);
            }
            
            public boolean onUIFailure(int param1Int, String param1String) {
              if (ShareToFriendsFragment.k(this.b) != 1) {
                ShareToFriendsFragment.l(this.b).m();
                ShareToFriendsFragment.m(this.b);
              } 
              return super.onUIFailure(param1Int, param1String);
            }
            
            public void onUIFinish() {
              super.onUIFinish();
              if (!ShareToFriendsFragment.n(this.b) && !this.a)
                if (ShareToFriendsFragment.o(this.b)) {
                  ShareToFriendsFragment.l(this.b).l();
                } else {
                  ShareToFriendsFragment.l(this.b).k();
                }  
              if (ShareToFriendsFragment.n(this.b) && !this.a) {
                if (ShareToFriendsFragment.k(this.b) != 1) {
                  ShareToFriendsFragment.m(this.b);
                } else {
                  ShareToFriendsFragment.l(this.b).c(null);
                } 
                ShareToFriendsFragment.l(this.b).k();
              } 
            }
            
            public void onUIStart() {
              super.onUIStart();
              ShareToFriendsFragment.a(this.b, false);
              ShareToFriendsFragment.b(this.b, false);
            }
          }UserInfo.a().i().getUid(), paramString, this.q, (IRequestHost)w_());
    } 
    try {
      if (this.H.data.size() > 0 && TextUtils.isEmpty(paramString)) {
        this.p = 1;
        t();
        return;
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  private boolean a(List<BluedBlackList> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() > 0) {
          this.H.data.clear();
          for (int i = 0; i < paramList.size(); i++)
            this.H.data.add((BluedBlackList)((BluedBlackList)paramList.get(i)).clone()); 
          return true;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  private void t() {
    Context context = this.x;
    BluedUIHttpResponse<BluedEntityA<BluedBlackList>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this) {
        boolean a = false;
        
        protected void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
          this.a = false;
          ShareToFriendsFragment.a(this.b, param1BluedEntityA, false);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (ShareToFriendsFragment.p(this.b) == 1 && ShareToFriendsFragment.l(this.b).n().size() == 0) {
            ShareToFriendsFragment.q(this.b).b();
            ShareToFriendsFragment.l(this.b).e((View)ShareToFriendsFragment.q(this.b));
            ShareToFriendsFragment.l(this.b).c(null);
          } else if (ShareToFriendsFragment.p(this.b) != 1) {
            ShareToFriendsFragment.l(this.b).m();
          } 
          if (ShareToFriendsFragment.p(this.b) != 1)
            ShareToFriendsFragment.r(this.b); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          ShareToFriendsFragment.s(this.b).setVisibility(8);
          ShareToFriendsFragment.t(this.b).j();
          if (!ShareToFriendsFragment.u(this.b) && !this.a)
            if (ShareToFriendsFragment.v(this.b)) {
              ShareToFriendsFragment.l(this.b).l();
            } else {
              ShareToFriendsFragment.l(this.b).k();
            }  
          if (ShareToFriendsFragment.u(this.b) && !this.a) {
            if (ShareToFriendsFragment.p(this.b) != 1) {
              ShareToFriendsFragment.r(this.b);
            } else {
              ShareToFriendsFragment.q(this.b).a();
              ShareToFriendsFragment.l(this.b).e((View)ShareToFriendsFragment.q(this.b));
              ShareToFriendsFragment.l(this.b).c(null);
            } 
            ShareToFriendsFragment.l(this.b).k();
          } 
          ShareToFriendsFragment shareToFriendsFragment = this.b;
          ShareToFriendsFragment.a(shareToFriendsFragment, ShareToFriendsFragment.l(shareToFriendsFragment).n());
        }
        
        public void onUIStart() {
          super.onUIStart();
          ShareToFriendsFragment.c(this.b, false);
          ShareToFriendsFragment.d(this.b, false);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.p);
    stringBuilder.append("");
    MineHttpUtils.b(context, bluedUIHttpResponse, stringBuilder.toString(), "20", (IRequestHost)w_());
  }
  
  private boolean u() {
    if (!TextUtils.isEmpty(this.B.getText().toString())) {
      this.G.setRefreshEnabled(false);
      return false;
    } 
    this.G.setRefreshEnabled(true);
    return true;
  }
  
  private boolean v() {
    return this.r ? (!u()) : (!u());
  }
  
  private void w() {
    if (u()) {
      this.A.setVisibility(0);
      return;
    } 
    this.A.setVisibility(8);
  }
  
  public void a(View paramView) {
    this.H = new FriendsModel();
    paramView = LayoutInflater.from(this.x).inflate(2131493316, (ViewGroup)paramView, true);
    this.F = (SearchView)LayoutInflater.from(this.x).inflate(2131493774, null);
    this.B = this.F.getEditView();
    this.C = (FrameLayout)paramView.findViewById(2131297158);
    this.D = (ProgressBar)paramView.findViewById(2131299526);
    this.A = paramView.findViewById(2131297985);
    this.G = (PullToRefreshRecyclerView)paramView.findViewById(2131299532);
    this.G.setRefreshEnabled(true);
    this.E = (RecyclerView)this.G.getRefreshableView();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.x);
    this.y = new FriendListAdapter();
    this.E.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.y.b((View)this.F);
    this.y.d(true);
    this.y.a((LoadMoreView)new RecyclerViewLoadMoreView());
    this.E.setAdapter((RecyclerView.Adapter)this.y);
    this.y.a(this.E);
    this.y.f();
    this.z = new NoDataAndLoadFailView(this.x);
    this.z.setNoDataStr(2131759017);
    this.z.setNoDataImg(2131232643);
    this.z.c();
    this.g = (KeyboardListenLinearLayout)paramView.findViewById(2131297982);
    a(this.g);
    this.F.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)ShareToFriendsFragment.a(this.a));
          }
          
          public void a(String param1String) {
            ShareToFriendsFragment.a(this.a, 1);
            ShareToFriendsFragment.a(this.a, param1String);
          }
          
          public void b() {}
        });
    this.A.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0)
              KeyboardUtils.a((Activity)ShareToFriendsFragment.a(this.a)); 
            return true;
          }
        });
    this.y.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            BluedBlackList bluedBlackList = param1BaseQuickAdapter.n().get(param1Int);
            if (bluedBlackList == null)
              return; 
            param1Int = ShareToFriendsFragment.b(this.a);
            if (param1Int != 0) {
              if (param1Int != 1)
                return; 
              EventTrackFeed.e(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_USER, ShareToFriendsFragment.d(this.a), bluedBlackList.uid);
              CircleMethods.circleInvitationJoin((IRequestHost)this.a.w_(), ShareToFriendsFragment.d(this.a), bluedBlackList.uid, true);
              return;
            } 
            ShareUtils.a().a(ShareToFriendsFragment.a(this.a), Long.parseLong(bluedBlackList.uid), (short)2, bluedBlackList.name, bluedBlackList.avatar, bluedBlackList.vbadge, bluedBlackList.vip_grade, bluedBlackList.is_vip_annual, bluedBlackList.vip_exp_lvl, bluedBlackList.is_hide_vip_look, ShareToFriendsFragment.c(this.a), ShareToFriendsFragment.a(this.a, bluedBlackList), (ShareToFriendsFragment.c(this.a)).gid);
          }
        });
    this.y.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            if (ShareToFriendsFragment.e(this.a)) {
              ShareToFriendsFragment.f(this.a);
              ShareToFriendsFragment shareToFriendsFragment = this.a;
              ShareToFriendsFragment.a(shareToFriendsFragment, ShareToFriendsFragment.g(shareToFriendsFragment).getText().toString());
              return;
            } 
            if (ShareToFriendsFragment.h(this.a)) {
              ShareToFriendsFragment.i(this.a);
              ShareToFriendsFragment.j(this.a);
            } 
          }
        }this.E);
    this.G.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            ShareToFriendsFragment.b(this.a, 1);
            ShareToFriendsFragment.j(this.a);
          }
        });
    t();
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.r = true;
      if (u()) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.H.data);
        this.y.c(arrayList);
        this.y.k();
      } 
      this.A.setVisibility(8);
      this.F.a(false);
      return;
    } 
    this.r = false;
    w();
    this.C.setFocusable(false);
    this.C.setFocusableInTouchMode(false);
    SearchView searchView = this.F;
    if (searchView != null)
      searchView.a(true); 
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.x = paramContext;
    if (getArguments() != null) {
      this.I = getArguments().getInt("share_type");
      this.J = (ShareToMsgEntity)getArguments().get("share_entity");
      this.K = getArguments().getString("circle_id");
    } 
  }
  
  class FriendListAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {
    private TextView b;
    
    private ImageView c;
    
    private ImageView d;
    
    private FriendListAdapter(ShareToFriendsFragment this$0) {
      super(2131493648, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, BluedBlackList param1BluedBlackList) {
      if (param1BaseViewHolder != null && param1BluedBlackList != null) {
        this.b = (TextView)param1BaseViewHolder.d(2131301088);
        this.c = (ImageView)param1BaseViewHolder.d(2131299684);
        this.d = (ImageView)param1BaseViewHolder.d(2131297581);
        this.b.setText(ShareToFriendsFragment.a(this.a, param1BluedBlackList));
        UserRelationshipUtils.a(this.k, this.b, (UserBasicModel)param1BluedBlackList);
        UserRelationshipUtils.a(this.d, (UserBasicModel)param1BluedBlackList);
        ImageLoader.a((IRequestHost)this.a.w_(), param1BluedBlackList.avatar).a(2131234356).c().a(this.c);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ShareToFriendsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */