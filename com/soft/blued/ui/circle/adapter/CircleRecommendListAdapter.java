package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.view.CircleJoinView;
import java.util.ArrayList;

public class CircleRecommendListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
  private IRequestHost a;
  
  public CircleRecommendListAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493637, new ArrayList());
    this.k = paramContext;
    this.a = paramIRequestHost;
  }
  
  private void a(MyCircleModel paramMyCircleModel, MyCircleViewHolder paramMyCircleViewHolder) {
    ImageLoader.a(this.a, paramMyCircleModel.cover).a(2131231281).a(8.0F).a(MyCircleViewHolder.b(paramMyCircleViewHolder));
    MyCircleViewHolder.c(paramMyCircleViewHolder).setText(paramMyCircleModel.title);
    MyCircleViewHolder.d(paramMyCircleViewHolder).setText(paramMyCircleModel.description);
    TextView textView = MyCircleViewHolder.e(paramMyCircleViewHolder);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramMyCircleModel.members_num);
    stringBuilder.append(this.k.getResources().getString(2131757872));
    textView.setText(stringBuilder.toString());
    MyCircleViewHolder.f(paramMyCircleViewHolder).setVisibility(0);
    MyCircleViewHolder.f(paramMyCircleViewHolder).setJoinStatusWithMember(paramMyCircleModel);
    if (paramMyCircleModel.is_member != 1 && paramMyCircleModel.is_applied != 1) {
      MyCircleViewHolder.f(paramMyCircleViewHolder).setOnClickListener(new -$$Lambda$CircleRecommendListAdapter$dcFHXod2eiLe-5rBt7h-CeeyBRo(this, paramMyCircleViewHolder, paramMyCircleModel));
    } else {
      MyCircleViewHolder.f(paramMyCircleViewHolder).setOnClickListener(null);
    } 
    MyCircleViewHolder.a(paramMyCircleViewHolder).setOnClickListener(new View.OnClickListener(this, paramMyCircleModel) {
          public void onClick(View param1View) {
            CircleDetailsFragment.a(CircleRecommendListAdapter.a(this.b), this.a, CircleConstants.CIRCLE_FROM_PAGE.HOME_RECOMMEND_CIRCLE);
          }
        });
  }
  
  private void a(CircleJoinView paramCircleJoinView, MyCircleModel paramMyCircleModel) {
    boolean bool;
    FragmentManager fragmentManager;
    FeedProtos.Event event = FeedProtos.Event.CIRCLE_JOIN_BTN_CLICK;
    String str = paramMyCircleModel.circle_id;
    FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
    if (paramMyCircleModel.allow_join == 0) {
      bool = true;
    } else {
      bool = false;
    } 
    EventTrackFeed.a(event, str, circleSource, bool, paramMyCircleModel.classify_id);
    event = null;
    if (this.k instanceof AppCompatActivity)
      fragmentManager = ((AppCompatActivity)this.k).getSupportFragmentManager(); 
    CircleMethods.joinCircle(this.k, new CircleMethods.JoinViewChangeListener(this, paramMyCircleModel, paramCircleJoinView) {
          public void joinViewChange(CircleJoinState param1CircleJoinState) {
            if (param1CircleJoinState.isJoin()) {
              this.a.is_member = 1;
            } else {
              this.a.is_member = 0;
            } 
            this.a.setJoinState(param1CircleJoinState);
            this.b.setJoinStatusWithMember(this.a);
            this.c.notifyDataSetChanged();
          }
        }paramMyCircleModel.getJoinState(), this.a, fragmentManager, false, true);
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MyCircleModel paramMyCircleModel) {
    if (paramBaseViewHolder != null && paramMyCircleModel != null) {
      MyCircleViewHolder myCircleViewHolder3 = new MyCircleViewHolder(this, paramBaseViewHolder, 0);
      MyCircleViewHolder myCircleViewHolder2 = new MyCircleViewHolder(this, paramBaseViewHolder, 1);
      MyCircleViewHolder myCircleViewHolder1 = new MyCircleViewHolder(this, paramBaseViewHolder, 2);
      MyCircleViewHolder.a(myCircleViewHolder3).setVisibility(8);
      MyCircleViewHolder.a(myCircleViewHolder2).setVisibility(8);
      MyCircleViewHolder.a(myCircleViewHolder1).setVisibility(8);
      if (paramMyCircleModel.circleModelList.size() > 0) {
        MyCircleViewHolder.a(myCircleViewHolder3).setVisibility(0);
        MyCircleModel myCircleModel = paramMyCircleModel.circleModelList.get(0);
        a(myCircleModel, myCircleViewHolder3);
        if (!myCircleModel.isDraw) {
          boolean bool1;
          boolean bool2;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
          String str = myCircleModel.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
          if (paramMyCircleModel.is_member == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (paramMyCircleModel.allow_join == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          EventTrackFeed.a(event, str, circleSource, bool1, bool2, paramMyCircleModel.classify_id);
          myCircleModel.isDraw = true;
        } 
      } 
      if (paramMyCircleModel.circleModelList.size() > 1) {
        MyCircleViewHolder.a(myCircleViewHolder2).setVisibility(0);
        MyCircleModel myCircleModel = paramMyCircleModel.circleModelList.get(1);
        a(myCircleModel, myCircleViewHolder2);
        if (!myCircleModel.isDraw) {
          boolean bool1;
          boolean bool2;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
          String str = myCircleModel.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
          if (paramMyCircleModel.is_member == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (paramMyCircleModel.allow_join == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          EventTrackFeed.a(event, str, circleSource, bool1, bool2, paramMyCircleModel.classify_id);
          myCircleModel.isDraw = true;
        } 
      } 
      if (paramMyCircleModel.circleModelList.size() > 2) {
        MyCircleViewHolder.a(myCircleViewHolder1).setVisibility(0);
        MyCircleModel myCircleModel = paramMyCircleModel.circleModelList.get(2);
        a(myCircleModel, myCircleViewHolder1);
        if (!myCircleModel.isDraw) {
          boolean bool1;
          boolean bool2;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
          String str = myCircleModel.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_RECOMMEND;
          if (paramMyCircleModel.is_member == 1) {
            bool1 = true;
          } else {
            bool1 = false;
          } 
          if (paramMyCircleModel.allow_join == 0) {
            bool2 = true;
          } else {
            bool2 = false;
          } 
          EventTrackFeed.a(event, str, circleSource, bool1, bool2, paramMyCircleModel.classify_id);
          myCircleModel.isDraw = true;
        } 
      } 
    } 
  }
  
  public class MyCircleViewHolder {
    private View b;
    
    private ImageView c;
    
    private TextView d;
    
    private TextView e;
    
    private TextView f;
    
    private CircleJoinView g;
    
    public MyCircleViewHolder(CircleRecommendListAdapter this$0, BaseViewHolder param1BaseViewHolder, int param1Int) {
      if (param1Int != 0) {
        if (param1Int != 1) {
          if (param1Int == 2)
            this.b = param1BaseViewHolder.d(2131297652); 
        } else {
          this.b = param1BaseViewHolder.d(2131297651);
        } 
      } else {
        this.b = param1BaseViewHolder.d(2131297650);
      } 
      this.c = (ImageView)this.b.findViewById(2131297463);
      this.d = (TextView)this.b.findViewById(2131300629);
      this.e = (TextView)this.b.findViewById(2131300633);
      this.f = (TextView)this.b.findViewById(2131300632);
      this.g = (CircleJoinView)this.b.findViewById(2131296752);
      this.g.setStyle(0);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleRecommendListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */