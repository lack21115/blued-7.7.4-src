package com.soft.blued.ui.notify.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blued.android.core.image.ImageLoader;
import com.blued.android.core.net.IRequestHost;
import com.blued.android.core.utils.skin.BluedSkinUtils;
import com.blued.android.framework.http.BluedUIHttpResponse;
import com.blued.android.framework.http.parser.BluedEntity;
import com.blued.android.framework.utils.EncryptTool;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.blued.das.client.feed.FeedProtos;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.http.CircleHttpUtils;
import com.soft.blued.http.H5Url;
import com.soft.blued.log.trackUtils.EventTrackFeed;
import com.soft.blued.ui.circle.fragment.CircleDetailsFragment;
import com.soft.blued.ui.circle.fragment.CirclePostDetailsFragment;
import com.soft.blued.ui.notify.model.CircleNotify;
import com.soft.blued.ui.user.fragment.UserInfoFragmentNew;
import com.soft.blued.ui.web.WebViewShowInfoFragment;
import com.soft.blued.utils.TimeAndDateUtils;

public class CircleNotifyAdapter extends BaseQuickAdapter<CircleNotify, BaseViewHolder> {
  private Context a;
  
  private IRequestHost b;
  
  public CircleNotifyAdapter(Context paramContext, IRequestHost paramIRequestHost) {
    super(2131493485);
    this.a = paramContext;
    this.b = paramIRequestHost;
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, CircleNotify paramCircleNotify, boolean paramBoolean) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297723);
    TextView textView = (TextView)paramBaseViewHolder.d(2131300627);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300121);
    ImageLoader.a(this.b, paramCircleNotify.cover).a(2131231280).a(8.0F).a(imageView);
    textView.setText(paramCircleNotify.title);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramCircleNotify) {
        public void onClick(View param1View) {
          CircleDetailsFragment.b(CircleNotifyAdapter.a(this.b), this.a.circle_id, this.a.from);
        }
      };
    imageView.setOnClickListener(onClickListener);
    textView.setOnClickListener(onClickListener);
    if (paramBoolean) {
      shapeTextView.setVisibility(0);
      shapeTextView.setOnClickListener(onClickListener);
      return;
    } 
    shapeTextView.setVisibility(8);
  }
  
  private void a(CircleNotify paramCircleNotify) {
    CircleHttpUtils.b(new BluedUIHttpResponse(this, this.b) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }paramCircleNotify.id, 1, this.b);
  }
  
  private void b(BaseViewHolder paramBaseViewHolder, CircleNotify paramCircleNotify) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297725);
    TextView textView = (TextView)paramBaseViewHolder.d(2131300630);
    ShapeTextView shapeTextView = (ShapeTextView)paramBaseViewHolder.d(2131300122);
    ImageLoader.a(this.b, paramCircleNotify.cover).a(2131231280).a(8.0F).a(imageView);
    textView.setText(paramCircleNotify.title);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramCircleNotify) {
        public void onClick(View param1View) {
          EventTrackFeed.f(FeedProtos.Event.MSG_NOTICE_CIRCLE_VIEW_CLICK, this.a.circle_id, this.a.posting_id);
          if (this.a.type == 5) {
            WebViewShowInfoFragment.show(CircleNotifyAdapter.a(this.b), H5Url.a(54, new Object[] { EncryptTool.b(this.a.circle_id) }));
            return;
          } 
          CirclePostDetailsFragment.a(CircleNotifyAdapter.a(this.b), this.a.posting_id, FeedProtos.NoteSource.CIRCLE_ESSENCE);
        }
      };
    imageView.setOnClickListener(onClickListener);
    textView.setOnClickListener(onClickListener);
    shapeTextView.setOnClickListener(onClickListener);
  }
  
  private void b(CircleNotify paramCircleNotify) {
    CircleHttpUtils.b(new BluedUIHttpResponse(this, this.b) {
          public void onUIUpdate(BluedEntity param1BluedEntity) {}
        }paramCircleNotify.id, 2, this.b);
  }
  
  private void c(BaseViewHolder paramBaseViewHolder, CircleNotify paramCircleNotify) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297953);
    TextView textView = (TextView)paramBaseViewHolder.d(2131301475);
    ImageLoader.a(this.b, paramCircleNotify.ops_avatar).a(2131234356).a(40.0F).a(imageView);
    textView.setText(paramCircleNotify.ops_name);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramCircleNotify) {
        public void onClick(View param1View) {
          EventTrackFeed.g(FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_USER_CLICK, this.a.circle_id, this.a.ops_uid);
          UserInfoFragmentNew.a(CircleNotifyAdapter.a(this.b), this.a.ops_uid, "CIRCLE_NOTIFY");
        }
      };
    imageView.setOnClickListener(onClickListener);
    textView.setOnClickListener(onClickListener);
    ShapeTextView shapeTextView2 = (ShapeTextView)paramBaseViewHolder.d(2131300051);
    ShapeTextView shapeTextView1 = (ShapeTextView)paramBaseViewHolder.d(2131300082);
    int i = paramCircleNotify.result;
    if (i != 0) {
      if (i != 1) {
        if (i != 2)
          return; 
        shapeTextView2.setVisibility(8);
        shapeTextView1.setVisibility(0);
        shapeTextView1.setText(2131755864);
        shapeTextView1.setTextColor(BluedSkinUtils.a(this.a, 2131100844));
        shapeTextView1.setOnClickListener(null);
        shapeTextView1.setEnabled(false);
        return;
      } 
      shapeTextView2.setVisibility(0);
      shapeTextView1.setVisibility(8);
      shapeTextView2.setText(2131755833);
      shapeTextView2.setTextColor(BluedSkinUtils.a(this.a, 2131100844));
      shapeTextView2.setOnClickListener(null);
      shapeTextView2.setEnabled(false);
      return;
    } 
    shapeTextView2.setVisibility(0);
    shapeTextView1.setVisibility(0);
    shapeTextView2.setText(2131755832);
    shapeTextView1.setText(2131755865);
    shapeTextView2.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    shapeTextView1.setTextColor(BluedSkinUtils.a(this.a, 2131100716));
    shapeTextView2.setEnabled(true);
    shapeTextView2.setOnClickListener(new View.OnClickListener(this, paramCircleNotify) {
          public void onClick(View param1View) {
            boolean bool;
            FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_AGREE_CLICK;
            String str1 = this.a.circle_id;
            String str2 = this.a.ops_uid;
            if (this.a.type == 1) {
              bool = true;
            } else {
              bool = false;
            } 
            EventTrackFeed.a(event, str1, str2, bool);
            CircleNotifyAdapter.a(this.b, this.a);
            this.a.result = 1;
            this.b.notifyDataSetChanged();
          }
        });
    shapeTextView1.setEnabled(true);
    shapeTextView1.setOnClickListener(new View.OnClickListener(this, paramCircleNotify) {
          public void onClick(View param1View) {
            FeedProtos.Event event = FeedProtos.Event.MSG_NOTICE_CIRCLE_JOIN_REJECT_CLICK;
            String str1 = this.a.circle_id;
            String str2 = this.a.ops_uid;
            int i = this.a.type;
            boolean bool = true;
            if (i != 1)
              bool = false; 
            EventTrackFeed.a(event, str1, str2, bool);
            CircleNotifyAdapter.b(this.b, this.a);
            this.a.result = 2;
            this.b.notifyDataSetChanged();
          }
        });
  }
  
  private void d(BaseViewHolder paramBaseViewHolder, CircleNotify paramCircleNotify) {
    ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297727);
    TextView textView = (TextView)paramBaseViewHolder.d(2131300634);
    ImageLoader.a(this.b, paramCircleNotify.cover).a(2131231280).a(8.0F).a(imageView);
    textView.setText(paramCircleNotify.title);
    View.OnClickListener onClickListener = new View.OnClickListener(this, paramCircleNotify) {
        public void onClick(View param1View) {
          CircleDetailsFragment.b(CircleNotifyAdapter.a(this.b), this.a.circle_id, this.a.from);
        }
      };
    imageView.setOnClickListener(onClickListener);
    textView.setOnClickListener(onClickListener);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, CircleNotify paramCircleNotify) {
    int i = paramCircleNotify.type;
    if (i != 1) {
      if (i != 2) {
        if (i != 3) {
          if (i == 4 || i == 5) {
            paramBaseViewHolder.b(2131298050, false);
            paramBaseViewHolder.b(2131298100, false);
            paramBaseViewHolder.b(2131298048, false);
            paramBaseViewHolder.b(2131298049, true);
            b(paramBaseViewHolder, paramCircleNotify);
          } 
        } else {
          paramBaseViewHolder.b(2131298050, false);
          paramBaseViewHolder.b(2131298100, false);
          paramBaseViewHolder.b(2131298048, true);
          paramBaseViewHolder.b(2131298049, false);
          a(paramBaseViewHolder, paramCircleNotify, false);
        } 
      } else {
        paramBaseViewHolder.b(2131298050, false);
        paramBaseViewHolder.b(2131298100, false);
        paramBaseViewHolder.b(2131298048, true);
        paramBaseViewHolder.b(2131298049, false);
        a(paramBaseViewHolder, paramCircleNotify, true);
      } 
    } else {
      paramBaseViewHolder.b(2131298050, true);
      paramBaseViewHolder.b(2131298100, true);
      paramBaseViewHolder.b(2131298048, false);
      paramBaseViewHolder.b(2131298049, false);
      d(paramBaseViewHolder, paramCircleNotify);
      c(paramBaseViewHolder, paramCircleNotify);
    } 
    paramBaseViewHolder.a(2131300072, paramCircleNotify.text);
    paramBaseViewHolder.a(2131300698, TimeAndDateUtils.e(this.a, TimeAndDateUtils.b(paramCircleNotify.timestamp)));
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\notify\adapter\CircleNotifyAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */