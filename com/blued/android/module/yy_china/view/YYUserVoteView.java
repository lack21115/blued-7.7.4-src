package com.blued.android.module.yy_china.view;

import android.content.Context;
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
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.view.shape.ShapeHelper;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.android.module.live.base.utils.LiveAlterDialog;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteDataModel;
import com.blued.android.module.yy_china.model.YYVoteListModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.blued.android.module.yy_china.utils.log.EventTrackYY;
import com.blued.das.client.chatroom.ChatRoomProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;
import java.util.Iterator;

public class YYUserVoteView extends LinearLayout {
  private RecyclerView a;
  
  private ShapeTextView b;
  
  private VoteUserAdapter c;
  
  private BaseYYStudioFragment d;
  
  private String e;
  
  private boolean f;
  
  public YYUserVoteView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYUserVoteView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYUserVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_user_vote, (ViewGroup)this, true);
    this.a = (RecyclerView)findViewById(R.id.rv_vote_user_list);
    this.b = (ShapeTextView)findViewById(R.id.tv_close_vote);
    this.b.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYUserVoteView.a(this.a);
          }
        });
    this.c = new VoteUserAdapter(this);
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (TextUtils.equals(yYRoomModel.uid, YYRoomInfoManager.d().e())) {
        this.b.setVisibility(0);
        return;
      } 
      this.b.setVisibility(8);
    } 
  }
  
  private void a(YYVoteDataModel paramYYVoteDataModel, int paramInt) {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null) {
      if (paramYYVoteDataModel == null)
        return; 
      YYRoomHttpUtils.c(yYRoomModel.room_id, paramYYVoteDataModel.vote_id, paramYYVoteDataModel.uid, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_(), paramYYVoteDataModel) {
            protected void a(BluedEntityA<Object> param1BluedEntityA) {
              YYVoteDataModel yYVoteDataModel = this.a;
              yYVoteDataModel.num++;
              this.a.is_choise = 1;
              YYUserVoteView.a(this.b, true);
              YYUserVoteView.c(this.b).notifyDataSetChanged();
            }
          }(IRequestHost)this.d.w_());
    } 
  }
  
  private void b() {
    LiveAlterDialog.a(getContext(), R.layout.dialog_vote_close_layout, null, new View.OnClickListener(this) {
          public void onClick(View param1View) {
            YYUserVoteView.d(this.a);
          }
        },  true, false);
  }
  
  private void c() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel == null)
      return; 
    YYRoomHttpUtils.g(yYRoomModel.room_id, yYRoomModel.vote_id, new BluedUIHttpResponse<BluedEntityA<Object>>(this, (IRequestHost)this.d.w_()) {
          protected void a(BluedEntityA<Object> param1BluedEntityA) {
            if (YYUserVoteView.e(this.a) != null)
              YYUserVoteView.e(this.a).H(); 
          }
        }(IRequestHost)this.d.w_());
  }
  
  private void getVoteList() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      YYRoomHttpUtils.f(yYRoomModel.room_id, yYRoomModel.vote_id, new BluedUIHttpResponse<BluedEntityA<YYVoteListModel>>(this, (IRequestHost)this.d.w_()) {
            protected void a(BluedEntityA<YYVoteListModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
                if (param1BluedEntityA.getSingleData() == null)
                  return; 
                if (((YYVoteListModel)param1BluedEntityA.getSingleData()).vote_data.size() < 4) {
                  LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.a.getContext());
                  linearLayoutManager.setOrientation(0);
                  YYUserVoteView.b(this.a).setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
                } else {
                  GridLayoutManager gridLayoutManager = new GridLayoutManager(this.a.getContext(), 4);
                  YYUserVoteView.b(this.a).setLayoutManager((RecyclerView.LayoutManager)gridLayoutManager);
                } 
                Iterator iterator = ((YYVoteListModel)param1BluedEntityA.getSingleData()).vote_data.iterator();
                while (iterator.hasNext()) {
                  if (((YYVoteDataModel)iterator.next()).is_choise == 1) {
                    YYUserVoteView.a(this.a, true);
                    break;
                  } 
                } 
                YYUserVoteView.b(this.a).setAdapter((RecyclerView.Adapter)YYUserVoteView.c(this.a));
                YYUserVoteView.c(this.a).c(((YYVoteListModel)param1BluedEntityA.getSingleData()).vote_data);
              } 
            }
          }(IRequestHost)this.d.w_()); 
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment, String paramString) {
    this.d = paramBaseYYStudioFragment;
    this.e = paramString;
    getVoteList();
  }
  
  class VoteUserAdapter extends BaseQuickAdapter<YYVoteDataModel, BaseViewHolder> {
    public VoteUserAdapter(YYUserVoteView this$0) {
      super(R.layout.item_yy_vote_user, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYVoteDataModel param1YYVoteDataModel) {
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.iv_vote_header);
      TextView textView = (TextView)param1BaseViewHolder.d(R.id.tv_vote_count);
      ShapeTextView shapeTextView = (ShapeTextView)param1BaseViewHolder.d(R.id.tv_check);
      ImageLoader.a((IRequestHost)YYUserVoteView.e(this.a).w_(), param1YYVoteDataModel.avatar).a(R.drawable.user_bg_round).a(imageView);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1YYVoteDataModel.num);
      stringBuilder.append("票");
      textView.setText(stringBuilder.toString());
      if (param1YYVoteDataModel.is_choise == 1) {
        shapeTextView.setVisibility(0);
        shapeTextView.setText(this.a.getResources().getString(R.string.yy_mic_voted));
        shapeTextView.setEnabled(false);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_8d8d8e);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_dark_28282b, R.color.syc_dark_28282b);
      } else if (YYUserVoteView.f(this.a)) {
        shapeTextView.setVisibility(4);
      } else {
        shapeTextView.setVisibility(0);
        shapeTextView.setText(this.a.getResources().getString(R.string.yy_mic_vote));
        shapeTextView.setEnabled(true);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.white);
        ShapeHelper.a((ShapeHelper.ShapeView)shapeTextView, R.color.syc_00E0AB, R.color.syc_3883FD);
      } 
      shapeTextView.setOnClickListener(new View.OnClickListener(this, param1YYVoteDataModel, param1BaseViewHolder) {
            public void onClick(View param2View) {
              YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
              if (yYRoomModel != null)
                EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_VOTE_USER_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
              YYUserVoteView.a(this.c.a, this.a, this.b.getAdapterPosition());
            }
          });
    }
  }
  
  class null implements View.OnClickListener {
    null(YYUserVoteView this$0, YYVoteDataModel param1YYVoteDataModel, BaseViewHolder param1BaseViewHolder) {}
    
    public void onClick(View param1View) {
      YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
      if (yYRoomModel != null)
        EventTrackYY.g(ChatRoomProtos.Event.CHAT_ROOM_VOTE_USER_CLICK, yYRoomModel.room_id, yYRoomModel.uid, this.a.uid); 
      YYUserVoteView.a(this.c.a, this.a, this.b.getAdapterPosition());
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYUserVoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */