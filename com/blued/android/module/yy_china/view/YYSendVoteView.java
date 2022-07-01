package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYSendVoteModel;
import com.blued.android.module.yy_china.model.YYVoteTimeModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class YYSendVoteView extends LinearLayout implements View.OnClickListener {
  private RecyclerView a;
  
  private RecyclerView b;
  
  private ShapeFrameLayout c;
  
  private ShapeFrameLayout d;
  
  private ShapeTextView e;
  
  private ShapeTextView f;
  
  private ShapeTextView g;
  
  private int h = 1;
  
  private String i = null;
  
  private YYVoteTimeModel j;
  
  private VoteUserAdapter k;
  
  private BaseYYStudioFragment l;
  
  private List<String> m = new ArrayList<String>();
  
  public YYSendVoteView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYSendVoteView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYSendVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_send_vote, (ViewGroup)this, true);
    this.a = (RecyclerView)findViewById(R.id.rv_vote_list);
    this.b = (RecyclerView)findViewById(R.id.rv_times_lsit);
    this.c = (ShapeFrameLayout)findViewById(R.id.fl_all);
    this.d = (ShapeFrameLayout)findViewById(R.id.fl_only_mic);
    this.e = (ShapeTextView)findViewById(R.id.tv_all_vote);
    this.f = (ShapeTextView)findViewById(R.id.tv_mic_vote);
    this.g = (ShapeTextView)findViewById(R.id.tv_create_vote);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    onClick((View)this.e);
    this.k = new VoteUserAdapter(this);
    LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
    linearLayoutManager1.setOrientation(0);
    this.a.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager1);
    this.a.setAdapter((RecyclerView.Adapter)this.k);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    ArrayList<YYSeatMemberModel> arrayList = new ArrayList();
    Iterator<YYSeatMemberModel> iterator = yYRoomModel.getHasPeopleMics().iterator();
    while (iterator.hasNext())
      arrayList.add(((YYSeatMemberModel)iterator.next()).copy()); 
    this.k.c(arrayList);
    this.k.a(new BaseQuickAdapter.OnItemClickListener(this) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            YYSeatMemberModel yYSeatMemberModel = (YYSeatMemberModel)YYSendVoteView.a(this.a).e(param1Int);
            yYSeatMemberModel.isVoted ^= 0x1;
            if (yYSeatMemberModel.isVoted) {
              YYSendVoteView.b(this.a).add(yYSeatMemberModel.getUid());
            } else {
              YYSendVoteView.b(this.a).remove(yYSeatMemberModel.getUid());
            } 
            YYSendVoteView.a(this.a).notifyItemChanged(param1Int);
            YYSendVoteView.c(this.a);
          }
        });
    VoteTimeAdapter voteTimeAdapter = new VoteTimeAdapter(this);
    LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getContext());
    linearLayoutManager2.setOrientation(0);
    this.b.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager2);
    this.b.setAdapter((RecyclerView.Adapter)voteTimeAdapter);
    voteTimeAdapter.c(getTimeList());
    voteTimeAdapter.a(new BaseQuickAdapter.OnItemClickListener(this, voteTimeAdapter) {
          public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
            int i;
            for (i = 0; i < this.a.getItemCount(); i++) {
              YYVoteTimeModel yYVoteTimeModel = (YYVoteTimeModel)this.a.e(i);
              if (i == param1Int) {
                yYVoteTimeModel.isCheck = true;
                YYSendVoteView.a(this.b, yYVoteTimeModel);
              } else {
                yYVoteTimeModel.isCheck = false;
              } 
            } 
            this.a.notifyDataSetChanged();
          }
        });
  }
  
  private void a(boolean paramBoolean) {
    int i;
    ShapeFrameLayout shapeFrameLayout2;
    ShapeTextView shapeTextView2;
    ShapeFrameLayout shapeFrameLayout1;
    ShapeTextView shapeTextView1;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    } 
    this.h = i;
    Resources resources = getResources();
    if (paramBoolean) {
      i = R.string.yy_vote_all;
    } else {
      i = R.string.yy_vote_mic;
    } 
    this.i = resources.getString(i);
    if (paramBoolean) {
      shapeFrameLayout2 = this.c;
    } else {
      shapeFrameLayout2 = this.d;
    } 
    ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout2, R.color.syc_00E0AB, R.color.syc_3883FD);
    if (paramBoolean) {
      shapeTextView2 = this.e;
    } else {
      shapeTextView2 = this.f;
    } 
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView2, R.color.white);
    if (paramBoolean) {
      shapeFrameLayout1 = this.d;
    } else {
      shapeFrameLayout1 = this.c;
    } 
    ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout1, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
    if (paramBoolean) {
      shapeTextView1 = this.f;
    } else {
      shapeTextView1 = this.e;
    } 
    ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView1, R.color.syc_8d8d8e);
  }
  
  private void b() {
    if (this.m.size() >= 2) {
      this.g.setEnabled(true);
      this.g.setAlpha(1.0F);
      return;
    } 
    this.g.setEnabled(false);
    this.g.setAlpha(0.3F);
  }
  
  private void c() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (this.j == null)
        return; 
      EventTrackYY.c(ChatRoomProtos.Event.CHAT_ROOM_VOTE_LAUNCH_CLICK, yYRoomModel.room_id, this.i);
      YYRoomHttpUtils.a(yYRoomModel.room_id, this.h, this.j.timeMill, this.m, new BluedUIHttpResponse<BluedEntityA<YYSendVoteModel>>(this, (IRequestHost)this.l.w_(), yYRoomModel) {
            protected void a(BluedEntityA<YYSendVoteModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData() && param1BluedEntityA.getSingleData() != null) {
                this.a.vote_id = ((YYSendVoteModel)param1BluedEntityA.getSingleData()).vote_id;
                YYSendVoteView.d(this.b).H();
              } 
            }
          }(IRequestHost)this.l.w_());
    } 
  }
  
  private List<YYVoteTimeModel> getTimeList() {
    String[] arrayOfString1 = getResources().getStringArray(R.array.yy_vote_times);
    String[] arrayOfString2 = getResources().getStringArray(R.array.yy_vote_time_mill);
    if (arrayOfString1 == null)
      return null; 
    ArrayList<YYVoteTimeModel> arrayList = new ArrayList();
    for (int i = 0; i < arrayOfString1.length; i++) {
      YYVoteTimeModel yYVoteTimeModel = new YYVoteTimeModel();
      yYVoteTimeModel.timeStr = arrayOfString1[i];
      if (i < arrayOfString2.length)
        yYVoteTimeModel.timeMill = StringUtils.a(arrayOfString2[i], 0); 
      if (i == 0) {
        this.j = yYVoteTimeModel;
        this.j.isCheck = true;
      } 
      arrayList.add(yYVoteTimeModel);
    } 
    return arrayList;
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.l = paramBaseYYStudioFragment;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.tv_all_vote) {
      a(true);
      return;
    } 
    if (paramView.getId() == R.id.tv_mic_vote) {
      a(false);
      return;
    } 
    if (paramView.getId() == R.id.tv_create_vote)
      c(); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    List<String> list = this.m;
    if (list != null) {
      list.clear();
      this.m = null;
    } 
    this.j = null;
    this.h = 1;
  }
  
  class VoteTimeAdapter extends BaseQuickAdapter<YYVoteTimeModel, BaseViewHolder> {
    public VoteTimeAdapter(YYSendVoteView this$0) {
      super(R.layout.item_vote_time_layout, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYVoteTimeModel param1YYVoteTimeModel) {
      ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)param1BaseViewHolder.d(R.id.fl_vote_time);
      ShapeTextView shapeTextView = (ShapeTextView)param1BaseViewHolder.d(R.id.tv_vote_time);
      shapeTextView.setText(param1YYVoteTimeModel.timeStr);
      if (param1YYVoteTimeModel.isCheck) {
        ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.white);
        return;
      } 
      ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_8d8d8e);
    }
  }
  
  class VoteUserAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
    public VoteUserAdapter(YYSendVoteView this$0) {
      super(R.layout.item_vote_user_layout, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYSeatMemberModel param1YYSeatMemberModel) {
      ImageView imageView1 = (ImageView)param1BaseViewHolder.d(R.id.iv_vote_header);
      ImageView imageView2 = (ImageView)param1BaseViewHolder.d(R.id.iv_vote);
      ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)param1BaseViewHolder.d(R.id.fl_vote_header);
      ImageLoader.a(null, param1YYSeatMemberModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView1);
      if (param1YYSeatMemberModel.isVoted) {
        imageView2.setVisibility(0);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout, R.color.syc_00E0AB, R.color.syc_3883FD);
        return;
      } 
      imageView2.setVisibility(8);
      ShapeHelper.a((ShapeHelper.ShapeView)shapeFrameLayout, R.color.white, R.color.white);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYSendVoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */