package com.soft.blued.ui.circle.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blued.android.core.AppMethods;
import com.blued.android.framework.view.shape.ShapeTextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.soft.blued.ui.circle.adapter.CircleTextVoteViewAdapter;
import com.soft.blued.ui.feed.model.CircleTextVote;
import java.util.Iterator;
import java.util.List;

public class CircleTextVoteView extends FrameLayout {
  private View a;
  
  private TextView b;
  
  private RecyclerView c;
  
  private TextView d;
  
  private ShapeTextView e;
  
  private CircleTextVoteViewAdapter f;
  
  private OnVoteListener g;
  
  public CircleTextVoteView(Context paramContext) {
    this(paramContext, null);
  }
  
  public CircleTextVoteView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleTextVoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {
    this.a = LayoutInflater.from(paramContext).inflate(2131494229, (ViewGroup)this);
    this.b = (TextView)this.a.findViewById(2131301409);
    this.c = (RecyclerView)this.a.findViewById(2131299605);
    this.d = (TextView)this.a.findViewById(2131300670);
    this.e = (ShapeTextView)this.a.findViewById(2131300132);
    this.c.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(this, paramContext) {
          public boolean canScrollVertically() {
            return false;
          }
        });
    this.f = new CircleTextVoteViewAdapter();
    this.c.setAdapter((RecyclerView.Adapter)this.f);
  }
  
  public void a(int paramInt1, int paramInt2) {
    this.f.a(paramInt1);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt1);
    stringBuilder.append(getContext().getString(2131755949));
    String str = stringBuilder.toString();
    this.d.setText(str);
    this.d.setVisibility(0);
    if (paramInt2 > 0) {
      this.e.setText(2131755960);
      if (this.f.n().size() >= paramInt2)
        ((CircleTextVote)this.f.n().get(paramInt2 - 1)).select = true; 
      this.f.a(true);
    } else {
      this.e.setText(2131755955);
      this.e.setOnClickListener(new View.OnClickListener(this) {
            public void onClick(View param1View) {
              AppMethods.d(2131755956);
            }
          });
      this.f.e(true);
      this.f.a(new BaseQuickAdapter.OnItemClickListener(this, paramInt1) {
            public void onItemClick(BaseQuickAdapter param1BaseQuickAdapter, View param1View, int param1Int) {
              if (CircleTextVoteView.a(this.b).a())
                return; 
              Iterator iterator = CircleTextVoteView.a(this.b).n().iterator();
              while (iterator.hasNext())
                ((CircleTextVote)iterator.next()).select = false; 
              CircleTextVote circleTextVote = CircleTextVoteView.a(this.b).n().get(param1Int);
              circleTextVote.select = true;
              CircleTextVoteView.a(this.b).notifyDataSetChanged();
              CircleTextVoteView.b(this.b).setAlpha(1.0F);
              CircleTextVoteView.b(this.b).setText(2131755953);
              CircleTextVoteView.b(this.b).setOnClickListener(new View.OnClickListener(this, circleTextVote, param1Int) {
                    public void onClick(View param2View) {
                      if (CircleTextVoteView.c(this.c.b) != null) {
                        CircleTextVoteView.b(this.c.b).setOnClickListener(null);
                        CircleTextVoteView.b(this.c.b).setEnabled(false);
                        CircleTextVoteView.b(this.c.b).setAlpha(0.3F);
                        CircleTextVoteView.b(this.c.b).setText(2131755960);
                        CircleTextVoteView.c(this.c.b).a(this.a, this.b);
                        int i = this.c.a + 1;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(i);
                        stringBuilder.append(this.c.b.getContext().getString(2131755949));
                        String str = stringBuilder.toString();
                        CircleTextVoteView.d(this.c.b).setText(str);
                        CircleTextVoteView.a(this.c.b).a(i);
                        CircleTextVote circleTextVote = this.a;
                        circleTextVote.count++;
                        CircleTextVoteView.a(this.c.b).e(false);
                        CircleTextVoteView.a(this.c.b).a(true);
                      } 
                    }
                  });
            }
          });
    } 
    this.e.setAlpha(0.3F);
    this.e.setVisibility(0);
  }
  
  public void setOnVoteListener(OnVoteListener paramOnVoteListener) {
    this.g = paramOnVoteListener;
  }
  
  public void setOptionList(List<CircleTextVote> paramList) {
    this.f.c(paramList);
  }
  
  public void setOptionTitle(String paramString) {
    this.b.setText(paramString);
  }
  
  public static interface OnVoteListener {
    void a(CircleTextVote param1CircleTextVote, int param1Int);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\view\CircleTextVoteView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */