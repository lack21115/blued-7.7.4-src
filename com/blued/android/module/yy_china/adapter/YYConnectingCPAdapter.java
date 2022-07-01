package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.framework.utils.Logger;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.framework.view.shape.ShapeFrameLayout;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYImMsgManager;
import com.blued.android.module.yy_china.manager.YYObserverManager;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.BlindPublishModel;
import com.blued.android.module.yy_china.model.YYCPStepModel;
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.model.YYStepModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class YYConnectingCPAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {
  private BaseYYStudioFragment a;
  
  private YYStepModel b;
  
  private YYRoomModel c;
  
  private ShapeTextView d;
  
  private ArrayList<YYStepModel> e;
  
  private StepAdapter f;
  
  public YYConnectingCPAdapter(Context paramContext, BaseYYStudioFragment paramBaseYYStudioFragment) {
    super((List<YYSeatMemberModel>)null);
    this.a = paramBaseYYStudioFragment;
    this.k = paramContext;
    b(0, R.layout.item_yy_connecting_layout);
    b(1, R.layout.view_yy_cp_layout);
    b();
  }
  
  private void a(int paramInt) {
    YYRoomHttpUtils.a(new BluedUIHttpResponse<BluedEntityA<YYCPStepModel>>(this, (IRequestHost)this.a.w_()) {
          protected void a(BluedEntityA<YYCPStepModel> param1BluedEntityA) {
            if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
              if (param1BluedEntityA.getSingleData() == null)
                return; 
              YYCPStepModel yYCPStepModel = new YYCPStepModel();
              yYCPStepModel.present_step = ((YYCPStepModel)param1BluedEntityA.getSingleData()).present_step;
              yYCPStepModel.next_step = ((YYCPStepModel)param1BluedEntityA.getSingleData()).next_step;
              if (YYConnectingCPAdapter.a(this.a) != null) {
                YYConnectingCPAdapter.a(this.a).setCPPresentStep(yYCPStepModel.present_step);
                YYConnectingCPAdapter.a(this.a).setCPNextStep(yYCPStepModel.next_step);
              } 
            } 
          }
        }this.c.room_id, paramInt, (IRequestHost)this.a.w_());
  }
  
  private void a(View paramView, YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    TextView textView2 = (TextView)paramView.findViewById(R.id.tv_audience_name);
    ShapeTextView shapeTextView = (ShapeTextView)paramView.findViewById(R.id.fl_disable_audience);
    CardView cardView = (CardView)paramView.findViewById(R.id.fl_no_audience);
    ShapeFrameLayout shapeFrameLayout = (ShapeFrameLayout)paramView.findViewById(R.id.fl_has_audience);
    ImageView imageView1 = (ImageView)paramView.findViewById(R.id.iv_microphone_status);
    ImageView imageView2 = (ImageView)paramView.findViewById(R.id.iv_audience_img);
    ImageView imageView3 = (ImageView)paramView.findViewById(R.id.talking_anim_view);
    TextView textView3 = (TextView)paramView.findViewById(R.id.tv_role);
    TextView textView4 = (TextView)paramView.findViewById(R.id.tv_audience_index);
    FrameLayout frameLayout = (FrameLayout)paramView.findViewById(R.id.fl_cp_heart);
    TextView textView1 = (TextView)paramView.findViewById(R.id.tv_like_index);
    YYRoomModel yYRoomModel = this.c;
    if (yYRoomModel != null && textView1 != null && frameLayout != null)
      if (TextUtils.equals(yYRoomModel.uid, YYRoomInfoManager.d().e()) || this.c.getCPPresentStep() >= 3) {
        if (TextUtils.isEmpty(paramYYSeatMemberModel.likeNum)) {
          frameLayout.setVisibility(8);
        } else {
          frameLayout.setVisibility(0);
          textView1.setText(paramYYSeatMemberModel.likeNum);
        } 
      } else {
        paramYYSeatMemberModel.likeNum = "";
        frameLayout.setVisibility(8);
      }  
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYSeatMemberModel.mic_position);
    stringBuilder.append("");
    textView4.setText(stringBuilder.toString());
    if (textView2 != null)
      if (TextUtils.isEmpty(paramYYSeatMemberModel.getName())) {
        textView2.setText("");
      } else {
        textView2.setText(paramYYSeatMemberModel.getName());
      }  
    if (TextUtils.equals(paramYYSeatMemberModel.chat_anchor, "1")) {
      textView3.setVisibility(0);
      textView3.setText(this.k.getResources().getString(R.string.yy_role_host));
    } else if (TextUtils.equals(paramYYSeatMemberModel.chat_anchor, "2")) {
      textView3.setVisibility(0);
      textView3.setText(this.k.getResources().getString(R.string.yy_role_manager));
    } else {
      textView3.setVisibility(8);
    } 
    ImageLoader.a((IRequestHost)this.a.w_(), paramYYSeatMemberModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView2);
    imageView3.setVisibility(4);
    ImageLoader.c((IRequestHost)this.a.w_(), "live_talking.png").e(-1).d(StringUtils.a(paramYYSeatMemberModel.getUid(), paramInt)).a(imageView3);
    paramInt = paramYYSeatMemberModel.position_status;
    if (paramInt != -1) {
      if (paramInt != 0) {
        if (paramInt != 1)
          return; 
        if (shapeFrameLayout != null)
          shapeFrameLayout.setVisibility(0); 
        if (shapeTextView != null)
          shapeTextView.setVisibility(8); 
        if (cardView != null)
          cardView.setVisibility(8); 
        if (paramYYSeatMemberModel.is_open_mic == 0) {
          imageView1.setImageResource(R.drawable.icon_microphone_close);
          return;
        } 
        if (paramYYSeatMemberModel.is_open_mic == 1) {
          imageView1.setImageResource(R.drawable.icon_microphone_open);
          return;
        } 
        imageView3.setVisibility(0);
        imageView1.setImageResource(R.drawable.icon_microphone_connecting);
        return;
      } 
      if (shapeFrameLayout != null)
        shapeFrameLayout.setVisibility(8); 
      if (shapeTextView != null)
        shapeTextView.setVisibility(8); 
      if (cardView != null) {
        cardView.setVisibility(0);
        return;
      } 
    } else {
      if (shapeFrameLayout != null)
        shapeFrameLayout.setVisibility(8); 
      if (shapeTextView != null)
        shapeTextView.setVisibility(0); 
      if (cardView != null)
        cardView.setVisibility(8); 
    } 
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, YYSeatMemberModel paramYYSeatMemberModel, int paramInt) {
    View view1 = paramBaseViewHolder.itemView;
    a(view1, paramYYSeatMemberModel, paramInt);
    this.d = (ShapeTextView)view1.findViewById(R.id.tv_action);
    RecyclerView recyclerView = (RecyclerView)view1.findViewById(R.id.rv_step_list);
    TextView textView = (TextView)view1.findViewById(R.id.tv_audience_name);
    View view2 = view1.findViewById(R.id.default_view);
    FrameLayout frameLayout = (FrameLayout)view1.findViewById(R.id.fl_item_view);
    if (this.f == null) {
      LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.k);
      linearLayoutManager.setOrientation(0);
      this.f = new StepAdapter(this);
      recyclerView.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
      recyclerView.setAdapter((RecyclerView.Adapter)this.f);
      StepAdapter stepAdapter = this.f;
      ArrayList<YYStepModel> arrayList = this.e;
      stepAdapter.c(arrayList.subList(1, arrayList.size()));
      b(this.c.getCPPresentStep(), this.c.getCPNextStep(), this.a.z ^ true);
    } 
    if (textView != null) {
      if (this.d == null)
        return; 
      YYRoomModel yYRoomModel = this.c;
      if (yYRoomModel != null && yYRoomModel.isCPChannel() && TextUtils.equals(YYRoomInfoManager.d().e(), this.c.uid)) {
        textView.setVisibility(8);
        this.d.setVisibility(0);
      } else {
        textView.setVisibility(0);
        this.d.setVisibility(8);
      } 
      c();
      this.d.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              if (YYConnectingCPAdapter.a(this.a) == null)
                return; 
              EventTrackYY.a(ChatRoomProtos.Event.CHAT_ROOM_CP_MATCH_START, (YYConnectingCPAdapter.a(this.a)).room_id, (YYConnectingCPAdapter.a(this.a)).uid, YYConnectingCPAdapter.a(this.a).getCPNextStep());
              YYConnectingCPAdapter yYConnectingCPAdapter = this.a;
              YYConnectingCPAdapter.a(yYConnectingCPAdapter, YYConnectingCPAdapter.a(yYConnectingCPAdapter).getCPNextStep());
            }
          });
      if (view2 != null)
        view2.setOnClickListener(new View.OnClickListener(this) {
              public void onClick(View param1View) {}
            }); 
      if (frameLayout != null) {
        frameLayout.post(new Runnable(this, frameLayout, view2) {
              public void run() {
                FrameLayout frameLayout = this.a;
                if (frameLayout != null) {
                  if (this.b == null)
                    return; 
                  int i = frameLayout.getMeasuredHeight();
                  StringBuilder stringBuilder = new StringBuilder();
                  stringBuilder.append("height = ");
                  stringBuilder.append(i);
                  LogUtils.d("cp_adapter", stringBuilder.toString());
                  RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
                  layoutParams.height = i;
                  this.b.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                } 
              }
            });
        frameLayout.setOnClickListener(new View.OnClickListener(this, view1, paramBaseViewHolder) {
              public void onClick(View param1View) {
                this.c.x().onItemClick((BaseQuickAdapter)this.c, this.a, this.b.getLayoutPosition() - this.c.o());
              }
            });
      } 
    } 
  }
  
  private ArrayList<YYStepModel> b() {
    this.e = new ArrayList<YYStepModel>();
    String[] arrayOfString = this.k.getResources().getStringArray(R.array.yy_cp_step);
    if (arrayOfString == null || arrayOfString.length <= 0)
      return null; 
    this.c = YYRoomInfoManager.d().b();
    for (int i = 0; i < arrayOfString.length; i++) {
      String str = arrayOfString[i];
      YYStepModel yYStepModel = new YYStepModel();
      yYStepModel.a = i;
      yYStepModel.b = str;
      yYStepModel.c = false;
      YYRoomModel yYRoomModel = this.c;
      if (yYRoomModel != null)
        if (i < yYRoomModel.getCPPresentStep()) {
          yYStepModel.c = true;
        } else if (i == this.c.getCPPresentStep()) {
          yYStepModel.c = true;
          this.b = yYStepModel;
        }  
      this.e.add(yYStepModel);
    } 
    return this.e;
  }
  
  private void b(int paramInt1, int paramInt2, boolean paramBoolean) {
    ArrayList<YYStepModel> arrayList = this.e;
    if (arrayList != null) {
      if (paramInt1 >= arrayList.size())
        return; 
      Iterator<YYStepModel> iterator = this.e.iterator();
      while (iterator.hasNext())
        ((YYStepModel)iterator.next()).c = false; 
      this.b = this.e.get(paramInt1);
      this.b.c = true;
      this.f.notifyDataSetChanged();
      c();
    } 
  }
  
  private void c() {
    if (this.d != null) {
      String str;
      YYStepModel yYStepModel = this.b;
      if (yYStepModel == null)
        return; 
      if (yYStepModel.a == 0) {
        str = ((YYStepModel)this.e.get(0)).b;
      } else if (this.b.a >= this.e.size() - 1) {
        str = "结束交友";
      } else {
        str = "下一阶段";
      } 
      this.d.setText(str);
    } 
  }
  
  public void a() {
    for (int i = 0; i < n().size(); i++) {
      YYSeatMemberModel yYSeatMemberModel = n().get(i);
      yYSeatMemberModel.likeNum = "";
      View view = c(i, R.id.yy_connectting_root);
      if (view != null)
        a(view, yYSeatMemberModel, i); 
    } 
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.a.a(new Runnable(this, paramInt1, paramInt2) {
          public void run() {
            if (this.a >= this.c.n().size())
              return; 
            YYSeatMemberModel yYSeatMemberModel = this.c.n().get(this.a);
            int i = this.b;
            if (i == 1) {
              yYSeatMemberModel.position_status = -1;
            } else {
              yYSeatMemberModel.position_status = i;
            } 
            this.c.notifyItemChanged(this.a);
          }
        });
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {
    b(paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, YYImModel paramYYImModel) {
    ImageView imageView = (ImageView)c(paramInt, R.id.iv_apng);
    if (imageView == null)
      return; 
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    imageView.setVisibility(0);
    ImageLoader.a((IRequestHost)this.a.w_(), paramString2).d(StringUtils.a(paramString1, paramInt)).a().a(new ImageLoader.OnAnimationStateListener(this, yYRoomModel, paramString1, paramYYImModel, paramInt, imageView) {
          public void a() {
            this.a.putPlayingEmoji(this.b, this.c);
            Logger.e("timer", new Object[] { "onAnimationStart ... " });
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("apng start ... position：");
            stringBuilder.append(this.d);
            Logger.c("YYConnectingAdapter", new Object[] { stringBuilder.toString() });
          }
          
          public void b() {
            Logger.e("timer", new Object[] { "onAnimationEnd ... " });
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("apng end ...position：");
            stringBuilder.append(this.d);
            Logger.c("YYConnectingAdapter", new Object[] { stringBuilder.toString() });
            this.e.setVisibility(8);
            if (this.c != null) {
              this.a.removePlayingEmoji(this.b);
              YYImMsgManager.a().w(this.c);
            } 
          }
        }).a(imageView);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, YYSeatMemberModel paramYYSeatMemberModel) {
    if (paramBaseViewHolder.getAdapterPosition() != 0) {
      a(paramBaseViewHolder.itemView, paramYYSeatMemberModel, paramBaseViewHolder.getAdapterPosition());
      return;
    } 
    a(paramBaseViewHolder, paramYYSeatMemberModel, paramBaseViewHolder.getAdapterPosition());
  }
  
  public void a(String paramString1, String paramString2) {
    Iterator<YYSeatMemberModel> iterator = n().iterator();
    for (int i = 0; iterator.hasNext(); i++) {
      YYSeatMemberModel yYSeatMemberModel = iterator.next();
      if (TextUtils.equals(yYSeatMemberModel.getUid(), paramString1)) {
        yYSeatMemberModel.chat_anchor = paramString2;
        notifyItemChanged(i);
        return;
      } 
    } 
  }
  
  public void a(List<BlindPublishModel> paramList) {
    for (int i = 0; i < n().size(); i++) {
      YYSeatMemberModel yYSeatMemberModel = n().get(i);
      View view = c(i, R.id.yy_connectting_root);
      if (view != null)
        a(view, yYSeatMemberModel, i); 
    } 
  }
  
  public void a(Set<String> paramSet) {
    for (int i = 0; i < n().size(); i++) {
      YYSeatMemberModel yYSeatMemberModel = n().get(i);
      if (yYSeatMemberModel.is_open_mic != 0) {
        if (paramSet != null && !paramSet.isEmpty() && paramSet.contains(yYSeatMemberModel.getUid())) {
          yYSeatMemberModel.is_open_mic = 2;
        } else {
          yYSeatMemberModel.is_open_mic = 1;
        } 
        ImageView imageView1 = (ImageView)c(i, R.id.talking_anim_view);
        ImageView imageView2 = (ImageView)c(i, R.id.iv_microphone_status);
        if (imageView1 == null)
          return; 
        if (paramSet.contains(yYSeatMemberModel.getUid())) {
          imageView1.setVisibility(0);
        } else {
          imageView1.setVisibility(4);
        } 
        if (imageView2 == null)
          return; 
        int j = yYSeatMemberModel.is_open_mic;
        if (j != 1) {
          if (j == 2)
            imageView2.setImageResource(R.drawable.icon_microphone_connecting); 
        } else {
          imageView2.setImageResource(R.drawable.icon_microphone_open);
        } 
      } 
    } 
  }
  
  public void b(List<YYSeatMemberModel> paramList) {
    this.a.a(new Runnable(this, paramList) {
          public void run() {
            if (this.a == null)
              return; 
            for (int i = 0; i < this.a.size(); i++) {
              YYSeatMemberModel yYSeatMemberModel = this.a.get(i);
              View view = this.b.c(i, R.id.yy_connectting_root);
              if (view != null)
                YYConnectingCPAdapter.a(this.b, view, yYSeatMemberModel, i); 
            } 
          }
        });
  }
  
  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {
    super.onAttachedToRecyclerView(paramRecyclerView);
    Logger.e("observer", new Object[] { "YYConnectingAdapter onAttachedToRecyclerView ..." });
    YYObserverManager.a().a(this);
  }
  
  public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {
    super.onDetachedFromRecyclerView(paramRecyclerView);
    Logger.e("observer", new Object[] { "YYConnectingAdapter onDetachedFromRecyclerView ..." });
    YYObserverManager.a().b(this);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    yYRoomModel.clearEmojiAndSendMessage();
  }
  
  class StepAdapter extends BaseQuickAdapter<YYStepModel, BaseViewHolder> {
    public StepAdapter(YYConnectingCPAdapter this$0) {
      super(R.layout.item_yy_cp_step, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYStepModel param1YYStepModel) {
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.step_name);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.step_num);
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.step_line);
      textView1.setText(param1YYStepModel.b);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1YYStepModel.a);
      stringBuilder.append("");
      textView2.setText(stringBuilder.toString());
      if (param1YYStepModel.c) {
        textView1.setTextColor(BluedSkinUtils.a(this.k, R.color.syc_00E0AB));
        textView2.setTextColor(BluedSkinUtils.a(this.k, R.color.syc_00E0AB));
        textView2.setBackgroundResource(R.drawable.shape_ring_00e0ab);
        textView1.setAlpha(1.0F);
        textView2.setAlpha(1.0F);
      } else {
        textView1.setTextColor(BluedSkinUtils.a(this.k, R.color.white));
        textView2.setTextColor(BluedSkinUtils.a(this.k, R.color.white));
        textView2.setBackgroundResource(R.drawable.shape_ring_ffffff);
        textView1.setAlpha(0.6F);
        textView2.setAlpha(0.6F);
      } 
      if (param1BaseViewHolder.getAdapterPosition() == n().size() - 1) {
        imageView.setVisibility(8);
        return;
      } 
      imageView.setVisibility(0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYConnectingCPAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */