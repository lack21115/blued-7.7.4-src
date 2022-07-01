package com.blued.android.module.yy_china.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
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
import com.blued.android.module.yy_china.model.YYImModel;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.observer.SeatChangedObserver;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class YYConnectingAdapter extends BaseConnectingAdapter<YYSeatMemberModel, BaseViewHolder> implements SeatChangedObserver {
  private BaseYYStudioFragment a;
  
  public YYConnectingAdapter(Context paramContext, BaseYYStudioFragment paramBaseYYStudioFragment) {
    super((List<YYSeatMemberModel>)null);
    this.a = paramBaseYYStudioFragment;
    this.k = paramContext;
    b(0, R.layout.item_yy_connecting_layout);
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
    TextView textView1 = (TextView)paramView.findViewById(R.id.tv_audience_index);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramYYSeatMemberModel.mic_position);
    stringBuilder.append("");
    textView1.setText(stringBuilder.toString());
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
        shapeFrameLayout.setVisibility(0);
        shapeTextView.setVisibility(8);
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
      shapeFrameLayout.setVisibility(8);
      shapeTextView.setVisibility(8);
      cardView.setVisibility(0);
      return;
    } 
    shapeFrameLayout.setVisibility(8);
    shapeTextView.setVisibility(0);
    cardView.setVisibility(8);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {
    this.a.a(new Runnable(this, paramInt1, paramInt2) {
          public void run() {
            YYSeatMemberModel yYSeatMemberModel = this.c.n().get(this.a - 1);
            int i = this.b;
            if (i == 1) {
              yYSeatMemberModel.position_status = -1;
            } else {
              yYSeatMemberModel.position_status = i;
            } 
            this.c.notifyItemChanged(this.a - 1);
          }
        });
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
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
    a(paramBaseViewHolder.itemView, paramYYSeatMemberModel, paramBaseViewHolder.getAdapterPosition());
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
  
  public void a(List<BlindPublishModel> paramList) {}
  
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
            List<YYSeatMemberModel> list = new ArrayList();
            int j = this.a.size();
            int i = 0;
            if (j > 8) {
              list = this.a.subList(0, 8);
            } else {
              list.addAll(this.a);
            } 
            while (i < list.size()) {
              YYSeatMemberModel yYSeatMemberModel = list.get(i);
              View view = this.b.c(i, R.id.yy_connectting_root);
              if (view != null)
                YYConnectingAdapter.a(this.b, view, yYSeatMemberModel, i); 
              i++;
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
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\adapter\YYConnectingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */