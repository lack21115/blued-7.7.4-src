package com.soft.blued.ui.yy_room.fragment;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.chat.model.ChattingModel;
import com.blued.android.chat.utils.ChatHelper;
import com.blued.android.core.AppInfo;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.activity.PreloadFragment;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshBase;
import com.blued.android.framework.view.pulltorefresh.PullToRefreshRecyclerView;
import com.blued.android.framework.view.pulltorefresh.RecyclerViewLoadMoreView;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live_china.liveForMsg.model.LiveMsgShareEntity;
import com.blued.android.module.live_china.msg.ILiveMsgSender;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.google.gson.Gson;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.soft.blued.customview.NoDataAndLoadFailView;
import com.soft.blued.http.LiveHttpUtils;
import com.soft.blued.http.MineHttpUtils;
import com.soft.blued.ui.msg.controller.tools.ChatHelperV4;
import com.soft.blued.ui.msg.model.FriendsModel;
import com.soft.blued.ui.msg.model.ShareToMsgEntity;
import com.soft.blued.ui.setting.model.BluedBlackList;
import com.soft.blued.utils.Logger;
import com.soft.blued.utils.StringUtils;
import java.util.List;

public class InviteFriendsFragment extends PreloadFragment {
  private ShareToMsgEntity A;
  
  private String B;
  
  private String C;
  
  private final int o = 20;
  
  private int p = 1;
  
  private boolean q;
  
  private boolean r;
  
  private Context s;
  
  private FriendListAdapter t;
  
  private NoDataAndLoadFailView u;
  
  private FrameLayout v;
  
  private ProgressBar w;
  
  private RecyclerView x;
  
  private PullToRefreshRecyclerView y;
  
  private FriendsModel z;
  
  public static InviteFriendsFragment a(Bundle paramBundle) {
    InviteFriendsFragment inviteFriendsFragment = new InviteFriendsFragment();
    if (paramBundle != null)
      inviteFriendsFragment.setArguments(paramBundle); 
    return inviteFriendsFragment;
  }
  
  private String a(BluedBlackList paramBluedBlackList) {
    return (paramBluedBlackList == null) ? "" : (!TextUtils.isEmpty(paramBluedBlackList.note) ? paramBluedBlackList.note : (!TextUtils.isEmpty(paramBluedBlackList.name) ? paramBluedBlackList.name : ""));
  }
  
  private void a(BluedEntityA<BluedBlackList> paramBluedEntityA) {
    // Byte code:
    //   0: aload_1
    //   1: ifnull -> 69
    //   4: aload_1
    //   5: invokevirtual hasData : ()Z
    //   8: ifeq -> 69
    //   11: aload_0
    //   12: iconst_0
    //   13: putfield q : Z
    //   16: aload_0
    //   17: getfield p : I
    //   20: iconst_1
    //   21: if_icmpne -> 38
    //   24: aload_0
    //   25: getfield t : Lcom/soft/blued/ui/yy_room/fragment/InviteFriendsFragment$FriendListAdapter;
    //   28: aload_1
    //   29: getfield data : Ljava/util/List;
    //   32: invokevirtual c : (Ljava/util/List;)V
    //   35: goto -> 49
    //   38: aload_0
    //   39: getfield t : Lcom/soft/blued/ui/yy_room/fragment/InviteFriendsFragment$FriendListAdapter;
    //   42: aload_1
    //   43: getfield data : Ljava/util/List;
    //   46: invokevirtual a : (Ljava/util/Collection;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokevirtual hasMore : ()Z
    //   54: putfield r : Z
    //   57: aload_0
    //   58: getfield t : Lcom/soft/blued/ui/yy_room/fragment/InviteFriendsFragment$FriendListAdapter;
    //   61: aload_0
    //   62: getfield r : Z
    //   65: invokevirtual c : (Z)V
    //   68: return
    //   69: aload_0
    //   70: iconst_1
    //   71: putfield q : Z
    //   74: aload_0
    //   75: getfield p : I
    //   78: iconst_1
    //   79: if_icmpeq -> 118
    //   82: aload_0
    //   83: getfield t : Lcom/soft/blued/ui/yy_room/fragment/InviteFriendsFragment$FriendListAdapter;
    //   86: invokevirtual n : ()Ljava/util/List;
    //   89: invokeinterface size : ()I
    //   94: ifle -> 118
    //   97: aload_0
    //   98: getfield s : Landroid/content/Context;
    //   101: invokevirtual getResources : ()Landroid/content/res/Resources;
    //   104: ldc 2131756083
    //   106: invokevirtual getString : (I)Ljava/lang/String;
    //   109: invokestatic a : (Ljava/lang/CharSequence;)V
    //   112: return
    //   113: astore_1
    //   114: aload_1
    //   115: invokevirtual printStackTrace : ()V
    //   118: return
    // Exception table:
    //   from	to	target	type
    //   4	35	113	java/lang/Exception
    //   38	49	113	java/lang/Exception
    //   49	68	113	java/lang/Exception
    //   69	112	113	java/lang/Exception
  }
  
  private boolean a(List<BluedBlackList> paramList) {
    if (paramList != null)
      try {
        if (paramList.size() > 0) {
          this.z.data.clear();
          for (int i = 0; i < paramList.size(); i++)
            this.z.data.add((BluedBlackList)((BluedBlackList)paramList.get(i)).clone()); 
          return true;
        } 
      } catch (Exception exception) {
        exception.printStackTrace();
      }  
    return false;
  }
  
  private void t() {
    Context context = this.s;
    BluedUIHttpResponse<BluedEntityA<BluedBlackList>> bluedUIHttpResponse = new BluedUIHttpResponse<BluedEntityA<BluedBlackList>>(this, (IRequestHost)w_()) {
        boolean a = false;
        
        protected void a(BluedEntityA<BluedBlackList> param1BluedEntityA) {
          this.a = false;
          InviteFriendsFragment.a(this.b, param1BluedEntityA);
        }
        
        public boolean onUIFailure(int param1Int, String param1String) {
          if (InviteFriendsFragment.d(this.b) == 1 && InviteFriendsFragment.c(this.b).n().size() == 0) {
            InviteFriendsFragment.e(this.b).b();
            InviteFriendsFragment.c(this.b).e((View)InviteFriendsFragment.e(this.b));
            InviteFriendsFragment.c(this.b).c(null);
          } else if (InviteFriendsFragment.d(this.b) != 1) {
            InviteFriendsFragment.c(this.b).m();
          } 
          if (InviteFriendsFragment.d(this.b) != 1)
            InviteFriendsFragment.f(this.b); 
          return super.onUIFailure(param1Int, param1String);
        }
        
        public void onUIFinish() {
          super.onUIFinish();
          InviteFriendsFragment.g(this.b).setVisibility(8);
          InviteFriendsFragment.h(this.b).j();
          if (!InviteFriendsFragment.i(this.b) && !this.a)
            if (InviteFriendsFragment.j(this.b)) {
              InviteFriendsFragment.c(this.b).l();
            } else {
              InviteFriendsFragment.c(this.b).k();
            }  
          if (InviteFriendsFragment.i(this.b) && !this.a) {
            if (InviteFriendsFragment.d(this.b) != 1) {
              InviteFriendsFragment.f(this.b);
            } else {
              InviteFriendsFragment.e(this.b).a();
              InviteFriendsFragment.c(this.b).e((View)InviteFriendsFragment.e(this.b));
              InviteFriendsFragment.c(this.b).c(null);
            } 
            InviteFriendsFragment.c(this.b).k();
          } 
          InviteFriendsFragment inviteFriendsFragment = this.b;
          InviteFriendsFragment.a(inviteFriendsFragment, InviteFriendsFragment.c(inviteFriendsFragment).n());
        }
        
        public void onUIStart() {
          super.onUIStart();
          InviteFriendsFragment.a(this.b, false);
          InviteFriendsFragment.b(this.b, false);
        }
      };
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.p);
    stringBuilder.append("");
    MineHttpUtils.b(context, bluedUIHttpResponse, stringBuilder.toString(), "20", (IRequestHost)w_());
  }
  
  public ChattingModel a(long paramLong, short paramShort1, short paramShort2, String paramString1, String paramString2) {
    return ChatHelper.getChattingModelForSendmsg(paramLong, paramShort2, paramString1, ILiveMsgSender.e(), paramString2, paramShort1);
  }
  
  public void a(View paramView) {
    this.z = new FriendsModel();
    paramView = LayoutInflater.from(this.s).inflate(2131493316, (ViewGroup)paramView, true);
    this.v = (FrameLayout)paramView.findViewById(2131297158);
    this.v.setBackgroundResource(2131100662);
    this.w = (ProgressBar)paramView.findViewById(2131299526);
    this.y = (PullToRefreshRecyclerView)paramView.findViewById(2131299532);
    this.y.setRefreshEnabled(true);
    this.x = (RecyclerView)this.y.getRefreshableView();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.s);
    this.t = new FriendListAdapter();
    this.x.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.t.d(true);
    this.t.a((LoadMoreView)new RecyclerViewLoadMoreView());
    this.x.setAdapter((RecyclerView.Adapter)this.t);
    this.t.a(this.x);
    this.t.f();
    this.u = new NoDataAndLoadFailView(this.s);
    this.u.setBackgroundColorRes(2131100662);
    this.u.setNoDataTextColor(2131100980);
    this.u.setNoDataStr(2131759017);
    this.u.setNoDataImg(2131232643);
    this.u.c();
    this.g = (KeyboardListenLinearLayout)paramView.findViewById(2131297982);
    a(this.g);
    this.t.a(new BaseQuickAdapter.RequestLoadMoreListener(this) {
          public void onLoadMoreRequested() {
            InviteFriendsFragment.a(this.a);
            InviteFriendsFragment.b(this.a);
          }
        },  this.x);
    this.y.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<RecyclerView>(this) {
          public void a(PullToRefreshBase<RecyclerView> param1PullToRefreshBase) {
            InviteFriendsFragment.a(this.a, 1);
            InviteFriendsFragment.b(this.a);
          }
        });
    t();
  }
  
  public void onActivityCreated(Bundle paramBundle) {
    super.onActivityCreated(paramBundle);
    LiveEventBus.get("share_to_private_chat", String.class).observe((LifecycleOwner)this, new Observer<String>(this) {
          public void a(String param1String) {
            Logger.e("invite", new Object[] { "event bus onChanged ..." });
            if (!TextUtils.isEmpty(param1String)) {
              if (InviteFriendsFragment.c(this.a) == null)
                return; 
              for (int i = 0; i < InviteFriendsFragment.c(this.a).getItemCount(); i++) {
                BluedBlackList bluedBlackList = (BluedBlackList)InviteFriendsFragment.c(this.a).e(i);
                if (bluedBlackList != null && TextUtils.equals(bluedBlackList.uid, param1String)) {
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("event bus uid: ");
                  stringBuilder.append(bluedBlackList.uid);
                  Logger.e("invite", new Object[] { stringBuilder.toString() });
                  InviteFriendsFragment.c(this.a).notifyItemChanged(i);
                  return;
                } 
              } 
            } 
          }
        });
  }
  
  public void onAttach(Context paramContext) {
    super.onAttach(paramContext);
    this.s = paramContext;
    if (getArguments() != null) {
      this.A = (ShareToMsgEntity)getArguments().get("share_entity");
      this.B = getArguments().getString("share_yy_type_name");
      this.C = getArguments().getString("share_yy_type_id");
    } 
  }
  
  class FriendListAdapter extends BaseQuickAdapter<BluedBlackList, BaseViewHolder> {
    private TextView b;
    
    private ImageView c;
    
    private ShapeTextView d;
    
    private FriendListAdapter(InviteFriendsFragment this$0) {
      super(2131493552, null);
    }
    
    private void a(BluedBlackList param1BluedBlackList, int param1Int) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append((InviteFriendsFragment.k(this.a)).sessionId);
      stringBuilder.append("");
      LiveHttpUtils.b(stringBuilder.toString(), new BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>>(this, (IRequestHost)this.a.w_(), param1BluedBlackList, param1Int) {
            protected void a(BluedEntityA<LiveMsgShareEntity> param2BluedEntityA) {
              if (param2BluedEntityA != null) {
                if (!param2BluedEntityA.hasData())
                  return; 
                LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)param2BluedEntityA.getSingleData();
                Gson gson = AppInfo.f();
                liveMsgShareEntity.copywriting = (InviteFriendsFragment.k(this.c.a)).title;
                liveMsgShareEntity.room_type = StringUtils.a(InviteFriendsFragment.l(this.c.a), 1);
                liveMsgShareEntity.description = InviteFriendsFragment.m(this.c.a);
                String str = gson.toJson(liveMsgShareEntity);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("invite friends extra: ");
                stringBuilder.append(str);
                Logger.e("invite", new Object[] { stringBuilder.toString() });
                ChattingModel chattingModel = this.c.a.a(StringUtils.a(this.a.uid, 0L), (short)2, (short)210, InviteFriendsFragment.FriendListAdapter.a(this.c).getResources().getString(2131759501), str);
                ChatHelperV4.a().a(chattingModel, false);
                YYRoomInfoManager.d().b().addInvited(this.a.uid);
                InviteFriendsFragment.c(this.c.a).notifyItemChanged(this.b);
              } 
            }
          }(IRequestHost)this.a.w_());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, BluedBlackList param1BluedBlackList) {
      if (param1BaseViewHolder != null && param1BluedBlackList != null) {
        this.b = (TextView)param1BaseViewHolder.d(2131301088);
        this.c = (ImageView)param1BaseViewHolder.d(2131299684);
        this.d = (ShapeTextView)param1BaseViewHolder.d(2131297604);
        if (YYRoomInfoManager.d().b().isInvited(param1BluedBlackList.uid)) {
          this.d.setEnabled(false);
          this.d.setText("已邀请");
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100692);
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100748, 2131100748);
        } else {
          this.d.setEnabled(true);
          this.d.setText("邀请");
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100980);
          ShapeHelper.a((ShapeHelper.ShapeView)this.d, 2131100658, 2131100672);
        } 
        this.b.setText(InviteFriendsFragment.a(this.a, param1BluedBlackList));
        ImageLoader.a((IRequestHost)this.a.w_(), param1BluedBlackList.avatar).a(2131234356).c().a(this.c);
        this.d.setOnClickListener(new View.OnClickListener(this, param1BluedBlackList, param1BaseViewHolder) {
              public void onClick(View param2View) {
                YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
                if (yYRoomModel != null)
                  EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
                InviteFriendsFragment.FriendListAdapter.a(this.c, this.a, this.b.getAdapterPosition());
              }
            });
      } 
    }
  }
  
  class null implements View.OnClickListener {
    null(InviteFriendsFragment this$0, BluedBlackList param1BluedBlackList, BaseViewHolder param1BaseViewHolder) {}
    
    public void onClick(View param1View) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_USER_INVITE_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
      InviteFriendsFragment.FriendListAdapter.a(this.c, this.a, this.b.getAdapterPosition());
    }
  }
  
  class null extends BluedUIHttpResponse<BluedEntityA<LiveMsgShareEntity>> {
    null(InviteFriendsFragment this$0, IRequestHost param1IRequestHost, BluedBlackList param1BluedBlackList, int param1Int) {
      super(param1IRequestHost);
    }
    
    protected void a(BluedEntityA<LiveMsgShareEntity> param1BluedEntityA) {
      if (param1BluedEntityA != null) {
        if (!param1BluedEntityA.hasData())
          return; 
        LiveMsgShareEntity liveMsgShareEntity = (LiveMsgShareEntity)param1BluedEntityA.getSingleData();
        Gson gson = AppInfo.f();
        liveMsgShareEntity.copywriting = (InviteFriendsFragment.k(this.c.a)).title;
        liveMsgShareEntity.room_type = StringUtils.a(InviteFriendsFragment.l(this.c.a), 1);
        liveMsgShareEntity.description = InviteFriendsFragment.m(this.c.a);
        String str = gson.toJson(liveMsgShareEntity);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("invite friends extra: ");
        stringBuilder.append(str);
        Logger.e("invite", new Object[] { stringBuilder.toString() });
        ChattingModel chattingModel = this.c.a.a(StringUtils.a(this.a.uid, 0L), (short)2, (short)210, InviteFriendsFragment.FriendListAdapter.a(this.c).getResources().getString(2131759501), str);
        ChatHelperV4.a().a(chattingModel, false);
        YYRoomInfoManager.d().b().addInvited(this.a.uid);
        InviteFriendsFragment.c(this.c.a).notifyItemChanged(this.b);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\yy_room\fragment\InviteFriendsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */