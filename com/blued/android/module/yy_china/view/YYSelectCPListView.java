package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYChooseCPUserExtra;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYSeatMemberModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYSelectCPListView extends LinearLayout {
  private RecyclerView a;
  
  private CPUserAdapter b;
  
  private BaseYYStudioFragment c;
  
  private int d;
  
  private Handler e = new Handler(this) {
      public void handleMessage(Message param1Message) {
        super.handleMessage(param1Message);
        YYSelectCPListView.a(this.a).H();
      }
    };
  
  public YYSelectCPListView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYSelectCPListView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYSelectCPListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_select_cp_list, (ViewGroup)this, true);
    this.a = (RecyclerView)findViewById(R.id.rv_select_list);
    this.d = DensityUtils.a(getContext(), 10.0F);
    this.b = new CPUserAdapter(this);
  }
  
  private void a(String paramString) {
    YYRoomHttpUtils.c(new BluedUIHttpResponse<BluedEntity<YYSeatMemberModel, YYChooseCPUserExtra>>(this, (IRequestHost)this.c.w_()) {
          public void onUIUpdate(BluedEntity<YYSeatMemberModel, YYChooseCPUserExtra> param1BluedEntity) {
            if (param1BluedEntity == null || !param1BluedEntity.hasData()) {
              YYSelectCPListView.a(this.a).H();
              return;
            } 
            if (param1BluedEntity.extra != null)
              YYSelectCPListView.b(this.a).a(((YYChooseCPUserExtra)param1BluedEntity.extra).target_uid); 
            if (param1BluedEntity.data.size() < 4) {
              LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getContext());
              linearLayoutManager.setOrientation(0);
              YYSelectCPListView.c(this.a).setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
            } else {
              GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a.getContext(), 4);
              YYSelectCPListView.c(this.a).setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
            } 
            YYSelectCPListView.c(this.a).setAdapter((RecyclerView.Adapter)YYSelectCPListView.b(this.a));
            YYSelectCPListView.b(this.a).c(param1BluedEntity.data);
          }
        }paramString, (IRequestHost)this.c.w_());
  }
  
  private void a(String paramString, YYSeatMemberModel paramYYSeatMemberModel) {
    YYRoomHttpUtils.c(new BluedUIHttpResponse(this, (IRequestHost)this.c.w_(), paramYYSeatMemberModel) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {
            YYSelectCPListView.b(this.b).a(this.a.getUid());
            YYSelectCPListView.b(this.b).notifyDataSetChanged();
            YYSelectCPListView.d(this.b).sendEmptyMessageDelayed(10, 2000L);
          }
        }paramString, paramYYSeatMemberModel.getUid(), (IRequestHost)this.c.w_());
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.c = paramBaseYYStudioFragment;
  }
  
  protected void onAttachedToWindow() {
    super.onAttachedToWindow();
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      a(yYRoomModel.room_id); 
  }
  
  protected void onDetachedFromWindow() {
    super.onDetachedFromWindow();
    Handler handler = this.e;
    if (handler != null)
      handler.removeCallbacksAndMessages(null); 
  }
  
  class CPUserAdapter extends BaseQuickAdapter<YYSeatMemberModel, BaseViewHolder> {
    private String b;
    
    public CPUserAdapter(YYSelectCPListView this$0) {
      super(R.layout.item_cp_user_layout, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYSeatMemberModel param1YYSeatMemberModel) {
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.iv_user_img);
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.tv_user_index);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.tv_user_name);
      ShapeTextView shapeTextView = (ShapeTextView)param1BaseViewHolder.d(R.id.tv_select);
      ImageLoader.a((IRequestHost)YYSelectCPListView.a(this.a).w_(), param1YYSeatMemberModel.getAvatar()).a(R.drawable.user_bg_round).a(imageView);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1YYSeatMemberModel.mic_position);
      stringBuilder.append("");
      textView1.setText(stringBuilder.toString());
      textView2.setText(param1YYSeatMemberModel.getName());
      if (!TextUtils.isEmpty(this.b)) {
        if (TextUtils.equals(param1YYSeatMemberModel.getUid(), this.b)) {
          shapeTextView.setVisibility(0);
          shapeTextView.setText(this.a.getResources().getString(R.string.yy_cp_like_text));
          shapeTextView.setEnabled(false);
          ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_8d8d8e);
          ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
        } else {
          shapeTextView.setVisibility(8);
        } 
      } else {
        shapeTextView.setText(this.a.getResources().getString(R.string.yy_cp_like_text));
        shapeTextView.setEnabled(true);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.white);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_00E0AB, R.color.syc_3883FD);
      } 
      shapeTextView.setOnClickListener(new View.OnClickListener(this, param1YYSeatMemberModel) {
            public void onClick(View param2View) {
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null) {
                EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_VOTE_USER_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.getUid());
                YYSelectCPListView.a(this.b.a, yYRoomModel.room_id, this.a);
              } 
            }
          });
    }
    
    public void a(String param1String) {
      this.b = param1String;
    }
  }
  
  class null implements View.OnClickListener {
    null(YYSelectCPListView this$0, YYSeatMemberModel param1YYSeatMemberModel) {}
    
    public void onClick(View param1View) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null) {
        EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_VOTE_USER_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.getUid());
        YYSelectCPListView.a(this.b.a, yYRoomModel.room_id, this.a);
      } 
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYSelectCPListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */