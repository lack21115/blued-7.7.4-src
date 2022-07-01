package com.soft.blued.ui.circle.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.imagecache.LoadOptions;
import com.blued.android.core.net.IRequestHost;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CircleTypeListFragment;
import com.soft.blued.ui.circle.model.CircleConstants;
import com.soft.blued.ui.circle.model.CircleJoinState;
import com.soft.blued.ui.circle.model.CircleMethods;
import com.soft.blued.ui.circle.model.MyCircleModel;
import com.soft.blued.ui.circle.view.CircleJoinView;
import java.util.ArrayList;

public class CircleListAdapter extends BaseQuickAdapter<MyCircleModel, BaseViewHolder> {
  private LoadOptions a;
  
  private CircleConstants.CIRCLE_FROM_PAGE b;
  
  private IRequestHost c;
  
  private View.OnClickListener d;
  
  private View e;
  
  public CircleListAdapter(Context paramContext, CircleConstants.CIRCLE_FROM_PAGE paramCIRCLE_FROM_PAGE, IRequestHost paramIRequestHost, View.OnClickListener paramOnClickListener) {
    super(2131493483, new ArrayList());
    this.k = paramContext;
    this.d = paramOnClickListener;
    this.c = paramIRequestHost;
    this.a = new LoadOptions();
    LoadOptions loadOptions = this.a;
    loadOptions.j = true;
    loadOptions.l = false;
    loadOptions.d = 2131231369;
    loadOptions.b = 2131231369;
    this.b = paramCIRCLE_FROM_PAGE;
    if (paramCIRCLE_FROM_PAGE == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
      this.e = View.inflate(this.k, 2131493553, null);
      this.e.setOnClickListener(new -$$Lambda$CircleListAdapter$e_B8BSb-5nRRZPiUD9i9sU1_1Fg(this));
      d(this.e);
    } 
  }
  
  private void a(CircleJoinView paramCircleJoinView, MyCircleModel paramMyCircleModel) {
    FragmentManager fragmentManager;
    if (this.k instanceof AppCompatActivity) {
      fragmentManager = ((AppCompatActivity)this.k).getSupportFragmentManager();
    } else {
      fragmentManager = null;
    } 
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
        }paramMyCircleModel.getJoinState(), this.c, fragmentManager, false, true);
    notifyDataSetChanged();
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, MyCircleModel paramMyCircleModel) {
    if (paramBaseViewHolder != null && paramMyCircleModel != null) {
      MyCircleViewHolder myCircleViewHolder = new MyCircleViewHolder(paramBaseViewHolder);
      ImageLoader.a(this.c, paramMyCircleModel.cover).a(2131231281).a(8.0F).a(myCircleViewHolder.a);
      myCircleViewHolder.c.setText(paramMyCircleModel.title);
      myCircleViewHolder.b.setText(paramMyCircleModel.description);
      TextView textView = myCircleViewHolder.d;
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(paramMyCircleModel.members_num);
      stringBuilder.append(this.k.getResources().getString(2131757872));
      textView.setText(stringBuilder.toString());
      if (this.b == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE || this.b == CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE) {
        myCircleViewHolder.g.setVisibility(0);
        myCircleViewHolder.e.setVisibility(8);
        if (this.b == CircleConstants.CIRCLE_FROM_PAGE.MANAGED_CIRCLE) {
          myCircleViewHolder.f.setVisibility(0);
          CircleMethods.setLevelMark(myCircleViewHolder.f, paramMyCircleModel.admin_level);
        } 
      } else {
        myCircleViewHolder.e.setVisibility(0);
        myCircleViewHolder.e.setJoinStatusWithMember(paramMyCircleModel);
        if (paramMyCircleModel.is_member != 1 && paramMyCircleModel.is_applied != 1) {
          myCircleViewHolder.e.setOnClickListener(new -$$Lambda$CircleListAdapter$pNFwswbUSw10OYyuAICZ4lrZcCQ(this, myCircleViewHolder, paramMyCircleModel));
        } else {
          myCircleViewHolder.e.setOnClickListener(null);
        } 
      } 
      if (this.b == CircleConstants.CIRCLE_FROM_PAGE.EXPLORE_MORE) {
        if (!paramMyCircleModel.isDraw) {
          boolean bool1;
          boolean bool2;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
          String str = paramMyCircleModel.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_LIST;
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
          paramMyCircleModel.isDraw = true;
        } 
      } else if (this.b == CircleConstants.CIRCLE_FROM_PAGE.JOINED_CIRCLE) {
        if (!paramMyCircleModel.isDraw) {
          boolean bool1;
          boolean bool2;
          FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
          String str = paramMyCircleModel.circle_id;
          FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.FIND_CIRCLE_MINE_ALL;
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
          paramMyCircleModel.isDraw = true;
        } 
      } else if (this.b == CircleConstants.CIRCLE_FROM_PAGE.RECOMMEND_CIRCLE && !paramMyCircleModel.isDraw) {
        boolean bool1;
        boolean bool2;
        FeedProtos.Event event = FeedProtos.Event.CIRCLE_DRAW;
        String str = paramMyCircleModel.circle_id;
        FeedProtos.CircleSource circleSource = FeedProtos.CircleSource.PLAZA_RECOMMEND_CIRCLE;
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
        paramMyCircleModel.isDraw = true;
      } 
      myCircleViewHolder.g.setOnClickListener(new -$$Lambda$CircleListAdapter$LQN5788ml3dVpCpi-1g3SIUB0AI(this, paramMyCircleModel, myCircleViewHolder));
    } 
  }
  
  public static class MyCircleViewHolder {
    ImageView a;
    
    TextView b;
    
    TextView c;
    
    TextView d;
    
    CircleJoinView e;
    
    ImageView f;
    
    View g;
    
    public MyCircleViewHolder(BaseViewHolder param1BaseViewHolder) {
      this.a = (ImageView)param1BaseViewHolder.d(2131297463);
      this.b = (TextView)param1BaseViewHolder.d(2131300629);
      this.c = (TextView)param1BaseViewHolder.d(2131300633);
      this.d = (TextView)param1BaseViewHolder.d(2131300632);
      this.f = (ImageView)param1BaseViewHolder.d(2131297820);
      this.e = (CircleJoinView)param1BaseViewHolder.d(2131296752);
      this.e.setStyle(0);
      this.g = param1BaseViewHolder.d(2131301634);
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */