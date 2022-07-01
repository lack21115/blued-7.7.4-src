package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.http.parser.BluedEntityA;
import com.blued.android.framework.utils.StringUtils;
import com.blued.android.module.yy_china.R;
import com.blued.android.module.yy_china.fragment.BaseYYStudioFragment;
import com.blued.android.module.yy_china.manager.YYRoomInfoManager;
import com.blued.android.module.yy_china.model.YYRoomModel;
import com.blued.android.module.yy_china.model.YYVoteDataModel;
import com.blued.android.module.yy_china.model.YYVoteListModel;
import com.blued.android.module.yy_china.utils.YYRoomHttpUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.ArrayList;

public class YYVoteResultView extends RelativeLayout {
  private BaseYYStudioFragment a;
  
  private VoteResultAdapter b;
  
  private RecyclerView c;
  
  private ImageView d;
  
  public YYVoteResultView(Context paramContext) {
    super(paramContext);
    a();
  }
  
  public YYVoteResultView(Context paramContext, AttributeSet paramAttributeSet) {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public YYVoteResultView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a() {
    LayoutInflater.from(getContext()).inflate(R.layout.view_yy_vote_result, (ViewGroup)this, true);
    this.b = new VoteResultAdapter(this);
    this.c = (RecyclerView)findViewById(R.id.rv_vote_result);
    this.d = (ImageView)findViewById(R.id.iv_close_result);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
    linearLayoutManager.setOrientation(1);
    this.c.setLayoutManager((RecyclerView.LayoutManager)linearLayoutManager);
    this.c.setAdapter((RecyclerView.Adapter)this.b);
    this.d.setOnClickListener(new View.OnClickListener(this) {
          public void onClick(View param1View) {
            if (YYVoteResultView.a(this.a) != null)
              YYVoteResultView.a(this.a).H(); 
          }
        });
  }
  
  private void getVoteList() {
    YYRoomModel yYRoomModel = YYRoomInfoManager.d().b();
    if (yYRoomModel != null)
      YYRoomHttpUtils.f(yYRoomModel.room_id, yYRoomModel.vote_id, new BluedUIHttpResponse<BluedEntityA<YYVoteListModel>>(this, (IRequestHost)this.a.w_()) {
            protected void a(BluedEntityA<YYVoteListModel> param1BluedEntityA) {
              if (param1BluedEntityA != null && param1BluedEntityA.hasData()) {
                if (param1BluedEntityA.getSingleData() == null)
                  return; 
                YYVoteResultView.b(this.a).c(((YYVoteListModel)param1BluedEntityA.getSingleData()).vote_data);
              } 
            }
          }(IRequestHost)this.a.w_()); 
  }
  
  public void a(BaseYYStudioFragment paramBaseYYStudioFragment) {
    this.a = paramBaseYYStudioFragment;
    getVoteList();
  }
  
  class VoteResultAdapter extends BaseQuickAdapter<YYVoteDataModel, BaseViewHolder> {
    public VoteResultAdapter(YYVoteResultView this$0) {
      super(R.layout.item_yy_vote_resul_listt, new ArrayList());
    }
    
    protected void a(BaseViewHolder param1BaseViewHolder, YYVoteDataModel param1YYVoteDataModel) {
      ImageView imageView = (ImageView)param1BaseViewHolder.d(R.id.iv_result_header);
      TextView textView1 = (TextView)param1BaseViewHolder.d(R.id.tv_result_count);
      TextView textView2 = (TextView)param1BaseViewHolder.d(R.id.tv_result_name);
      TextView textView3 = (TextView)param1BaseViewHolder.d(R.id.tv_result_index);
      ImageLoader.a((IRequestHost)YYVoteResultView.a(this.a).w_(), param1YYVoteDataModel.avatar).a(R.drawable.user_bg_round).a(imageView);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(param1YYVoteDataModel.num);
      stringBuilder.append("票");
      textView1.setText(stringBuilder.toString());
      textView2.setText(param1YYVoteDataModel.name);
      textView3.setText(StringUtils.a(param1BaseViewHolder.getAdapterPosition() + 1, ""));
      if (param1BaseViewHolder.getAdapterPosition() == 0) {
        textView3.setTextColor(BluedSkinUtils.a(this.a.getContext(), R.color.syc_00E0AB));
        return;
      } 
      textView3.setTextColor(BluedSkinUtils.a(this.a.getContext(), R.color.syc_dark_8F8F91));
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7575468-dex2jar.jar!\com\blued\android\module\yy_china\view\YYVoteResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */