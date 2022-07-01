package com.soft.blued.ui.msg;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.ChatManager;
import com.blued.android.chat.StableSessionListListener;
import com.blued.android.chat.listener.SessionListener;
import com.blued.android.chat.model.SessionModel;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.utils.KeyboardUtils;
import com.blued.android.framework.view.SearchEditText;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.BluedConstant;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.customview.SearchView;
import com.soft.blued.db.model.SessionSettingModel;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.find.model.UserBasicModel;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.utils.ShareUtils;
import com.soft.blued.utils.UserRelationshipUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareToChatRecentFragment extends PreloadFragment {
  private List<SessionModel> A;
  
  private List<SessionModel> B;
  
  private List<SessionModel> C;
  
  private boolean D = false;
  
  private boolean E = true;
  
  private int F = 0;
  
  private ShareToMsgEntity G;
  
  private String H;
  
  private Context o;
  
  private ChatListAdapter p;
  
  private ShareToSessionListListener q;
  
  private View r;
  
  private NoDataAndLoadFailView s;
  
  private SearchEditText t;
  
  private FrameLayout u;
  
  private ProgressBar v;
  
  private RecyclerView w;
  
  private SearchView x;
  
  private PullToRefreshRecyclerView y;
  
  private KeyboardListenLinearLayout z;
  
  public static ShareToChatRecentFragment a(Bundle paramBundle) {
    ShareToChatRecentFragment shareToChatRecentFragment = new ShareToChatRecentFragment();
    if (paramBundle != null)
      shareToChatRecentFragment.setArguments(paramBundle); 
    return shareToChatRecentFragment;
  }
  
  private String a(SessionModel paramSessionModel) {
    String str;
    if (paramSessionModel == null)
      return ""; 
    SessionSettingModel sessionSettingModel = (SessionSettingModel)paramSessionModel.sessionSettingModel;
    if (sessionSettingModel != null) {
      str = sessionSettingModel.getSessinoNote();
    } else {
      str = "";
    } 
    if (!TextUtils.isEmpty(str))
      return str; 
    if (!TextUtils.isEmpty(paramSessionModel.nickName))
      return paramSessionModel.nickName; 
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramSessionModel.sessionId);
    stringBuilder.append("");
    return stringBuilder.toString();
  }
  
  private void a(String paramString) {
    if (!this.E)
      u(); 
    List<SessionModel> list = this.B;
    if (list != null && list.size() > 0) {
      this.C.clear();
      for (SessionModel sessionModel : this.B) {
        SessionSettingModel sessionSettingModel = (SessionSettingModel)sessionModel.sessionSettingModel;
        if ((!TextUtils.isEmpty(sessionModel.nickName) && sessionModel.nickName.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgFromNickname) && sessionModel.lastMsgFromNickname.contains(paramString)) || (!TextUtils.isEmpty(sessionModel.lastMsgContent) && sessionModel.lastMsgContent.contains(paramString)) || (sessionSettingModel != null && !TextUtils.isEmpty(sessionSettingModel.getSessinoNote()) && sessionSettingModel.getSessinoNote().contains(paramString)))
          this.C.add(sessionModel); 
      } 
      int j = this.p.n().size();
      for (int i = 0; i < j - 1; i++)
        this.p.d(1); 
      this.p.a(this.C);
      if (this.p.n().size() > 0)
        this.p.d(0); 
    } 
  }
  
  private boolean t() {
    return !!TextUtils.isEmpty(this.t.getText().toString());
  }
  
  private void u() {
    if (t()) {
      this.r.setVisibility(0);
      return;
    } 
    this.r.setVisibility(8);
  }
  
  public void a(View paramView) {
    this.C = new ArrayList<SessionModel>();
    this.A = new ArrayList<SessionModel>();
    this.B = new ArrayList<SessionModel>();
    paramView = LayoutInflater.from(this.o).inflate(2131493316, (ViewGroup)paramView, true);
    this.x = (SearchView)LayoutInflater.from(this.o).inflate(2131493774, null);
    this.x.setDelaymillis(0L);
    this.t = this.x.getEditView();
    this.u = (FrameLayout)paramView.findViewById(2131297158);
    this.v = (ProgressBar)paramView.findViewById(2131299526);
    this.v.setVisibility(8);
    this.r = paramView.findViewById(2131297985);
    this.y = (PullToRefreshRecyclerView)paramView.findViewById(2131299532);
    this.y.setRefreshEnabled(false);
    this.w = (RecyclerView)this.y.getRefreshableView();
    this.z = (KeyboardListenLinearLayout)paramView.findViewById(2131297982);
    a(this.z);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.o);
    this.p = new ChatListAdapter();
    this.w.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.p.b((View)this.x);
    this.p.d(true);
    this.w.setAdapter((RecyclerView.Adapter)this.p);
    this.p.a(this.w);
    this.p.f();
    this.q = new ShareToSessionListListener();
    ChatManager.getInstance().registerSessionListener((SessionListener)this.q);
    this.w.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener(this) {
          public void onGlobalLayout() {
            ShareToChatRecentFragment.a(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (!ShareToChatRecentFragment.b(this.a)) {
              ShareToChatRecentFragment.a(this.a, true);
              ShareToChatRecentFragment shareToChatRecentFragment = this.a;
              ShareToChatRecentFragment.a(shareToChatRecentFragment, new NoDataAndLoadFailView(ShareToChatRecentFragment.c(shareToChatRecentFragment)));
              ShareToChatRecentFragment.d(this.a).setNoDataImg(2131232632);
              ShareToChatRecentFragment.d(this.a).setNoDataStr(2131759016);
              ShareToChatRecentFragment.d(this.a).a();
              ShareToChatRecentFragment.e(this.a).e((View)ShareToChatRecentFragment.d(this.a));
            } 
          }
        });
    this.p.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            if (param1BaseQuickAdapter.n() != null) {
              String str;
              if (param1BaseQuickAdapter.n().size() <= param1Int)
                return; 
              SessionModel sessionModel = param1BaseQuickAdapter.n().get(param1Int);
              if (sessionModel == null)
                return; 
              param1Int = ShareToChatRecentFragment.f(this.a);
              if (param1Int != 0) {
                if (param1Int != 1)
                  return; 
                EventTrackFeed.e(FeedProtos.Event.CIRCLE_USER_MANAGE_INVITE_USER, ShareToChatRecentFragment.h(this.a), String.valueOf(sessionModel.sessionId));
                CircleMethods.circleInvitationJoin((IRequestHost)this.a.w_(), ShareToChatRecentFragment.h(this.a), String.valueOf(sessionModel.sessionId), true);
                return;
              } 
              if (sessionModel.sessionType == 3) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("[");
                stringBuilder.append(this.a.getResources().getString(2131756611));
                stringBuilder.append("]");
                stringBuilder.append(ShareToChatRecentFragment.a(this.a, sessionModel));
                str = stringBuilder.toString();
              } else {
                str = ShareToChatRecentFragment.a(this.a, sessionModel);
              } 
              ShareUtils.a().a(ShareToChatRecentFragment.c(this.a), sessionModel.sessionId, sessionModel.sessionType, sessionModel.nickName, sessionModel.avatar, sessionModel.vBadge, sessionModel.vipGrade, sessionModel.vipAnnual, sessionModel.vipExpLvl, sessionModel.hideVipLook, ShareToChatRecentFragment.g(this.a), str, (ShareToChatRecentFragment.g(this.a)).gid);
            } 
          }
        });
    this.x.setOnSearchInfoListener(new SearchView.OnSearchInfoListener(this) {
          public void a() {
            KeyboardUtils.a((Activity)ShareToChatRecentFragment.c(this.a));
          }
          
          public void a(String param1String) {
            ShareToChatRecentFragment.a(this.a, param1String);
          }
          
          public void b() {}
        });
    this.r.setOnTouchListener(new View.OnTouchListener(this) {
          public boolean onTouch(View param1View, MotionEvent param1MotionEvent) {
            if (param1MotionEvent.getAction() == 0)
              KeyboardUtils.a((Activity)ShareToChatRecentFragment.c(this.a)); 
            return true;
          }
        });
  }
  
  public void e_(int paramInt) {
    if (paramInt != -3) {
      if (paramInt != -2)
        return; 
      this.E = true;
      if (t()) {
        this.p.e((View)this.s);
        this.p.c(this.A);
      } 
      this.r.setVisibility(8);
      this.x.a(false);
      return;
    } 
    this.E = false;
    u();
    this.u.setFocusable(false);
    this.u.setFocusableInTouchMode(false);
    SearchView searchView = this.x;
    if (searchView != null)
      searchView.a(true); 
    this.p.e((View)this.s);
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.o = paramContext;
    if (getArguments() != null) {
      this.F = getArguments().getInt("share_type");
      this.G = (ShareToMsgEntity)getArguments().get("share_entity");
      this.H = getArguments().getString("circle_id");
    } 
  }
  
  class ChatListAdapter extends BaseQuickAdapter<SessionModel, BaseViewHolder> {
    private TextView b;
    
    private ShapeTextView c;
    
    private ImageView d;
    
    private ImageView e;
    
    private int f = DensityUtils.a(ShareToChatRecentFragment.c(ShareToChatRecentFragment.this), 9.0F);
    
    private int g = DensityUtils.a(ShareToChatRecentFragment.c(ShareToChatRecentFragment.this), 6.0F);
    
    private ChatListAdapter(ShareToChatRecentFragment this$0) {
      super(2131493648, null);
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, SessionModel param1SessionModel) {
      if (param1BaseViewHolder != null && param1SessionModel != null) {
        this.b = (TextView)param1BaseViewHolder.d(2131301088);
        this.c = (ShapeTextView)param1BaseViewHolder.d(2131300828);
        this.d = (ImageView)param1BaseViewHolder.d(2131299684);
        this.e = (ImageView)param1BaseViewHolder.d(2131297581);
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams)this.b.getLayoutParams();
        if (param1SessionModel.sessionType == 3) {
          this.c.setVisibility(0);
          layoutParams.setMargins(this.g, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
          this.c.setVisibility(8);
          layoutParams.setMargins(this.f, layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } 
        this.b.setText(ShareToChatRecentFragment.a(this.a, param1SessionModel));
        UserBasicModel userBasicModel = new UserBasicModel();
        userBasicModel.vip_grade = param1SessionModel.vipGrade;
        userBasicModel.is_vip_annual = param1SessionModel.vipAnnual;
        userBasicModel.vip_exp_lvl = param1SessionModel.vipExpLvl;
        UserRelationshipUtils.a(this.k, this.b, userBasicModel);
        UserRelationshipUtils.a(this.e, userBasicModel);
        ImageLoader.a((IRequestHost)this.a.w_(), param1SessionModel.avatar).a(2131234356).c().a(this.d);
      } 
    }
  }
  
  class ShareToSessionListListener extends StableSessionListListener {
    private ShareToSessionListListener(ShareToChatRecentFragment this$0) {}
    
    public void onUISessionDataChanged(List<SessionModel> param1List) {
      if (param1List == null) {
        param1List = new ArrayList<SessionModel>();
      } else {
        ChatHelperV4.b(param1List);
      } 
      if (BluedConstant.a) {
        Iterator<SessionModel> iterator = param1List.iterator();
        while (iterator.hasNext()) {
          SessionModel sessionModel = iterator.next();
          if (sessionModel.sessionType == 3) {
            iterator.remove();
            continue;
          } 
          if (sessionModel.sessionType == 1 && sessionModel.sessionId == 2L)
            iterator.remove(); 
        } 
      } 
      ShareToChatRecentFragment.a(this.a, param1List);
      ShareToChatRecentFragment.i(this.a).addAll(param1List);
      if (ShareToChatRecentFragment.j(this.a).size() > 0) {
        ShareToChatRecentFragment.e(this.a).c(ShareToChatRecentFragment.i(this.a));
        return;
      } 
      ShareToChatRecentFragment.e(this.a).c(null);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\msg\ShareToChatRecentFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */