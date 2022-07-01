package com.blued.android.module.live_china.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blued.android.module.live_china.R;
import com.blued.android.module.live_china.fragment.PlayingOnliveFragment;

public class LiveMakeLoverManagerRecordView extends FrameLayout implements View.OnClickListener {
  public int a;
  
  public boolean b = false;
  
  private Context c;
  
  private LayoutInflater d;
  
  private View e;
  
  private LinearLayout f;
  
  private TextView g;
  
  private ImageView h;
  
  private TextView i;
  
  private LiveMakeLoverOnClickListener j;
  
  private PlayingOnliveFragment k;
  
  public LiveMakeLoverManagerRecordView(Context paramContext) {
    this(paramContext, null);
  }
  
  public LiveMakeLoverManagerRecordView(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LiveMakeLoverManagerRecordView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
    this.c = paramContext;
    a();
  }
  
  private void a() {
    this.d = LayoutInflater.from(this.c);
    this.e = this.d.inflate(R.layout.live_make_lover_manage_record, (ViewGroup)this);
    this.f = (LinearLayout)this.e.findViewById(R.id.live_make_lover_wait_layout);
    this.g = (TextView)this.e.findViewById(R.id.live_make_lover_wait_num);
    this.i = (TextView)this.e.findViewById(R.id.live_make_lover_wait_text);
    this.h = (ImageView)this.e.findViewById(R.id.live_make_lover_manage_head);
    a(0);
    this.f.setOnClickListener(this);
  }
  
  public void a(int paramInt) {
    TextView textView = this.g;
    String str = this.c.getString(R.string.live_make_friend_wait);
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramInt);
    stringBuilder.append("");
    textView.setText(String.format(str, new Object[] { stringBuilder.toString() }));
  }
  
  public void a(boolean paramBoolean, LiveMakeLoverOnClickListener paramLiveMakeLoverOnClickListener) {
    a(paramBoolean, paramLiveMakeLoverOnClickListener, null);
  }
  
  public void a(boolean paramBoolean, LiveMakeLoverOnClickListener paramLiveMakeLoverOnClickListener, PlayingOnliveFragment paramPlayingOnliveFragment) {
    this.j = paramLiveMakeLoverOnClickListener;
    this.k = paramPlayingOnliveFragment;
    if (paramBoolean) {
      this.a = 0;
      return;
    } 
    this.a = 1;
  }
  
  public void onClick(View paramView) {
    if (paramView.getId() == R.id.live_make_lover_wait_layout) {
      LiveMakeLoverOnClickListener liveMakeLoverOnClickListener = this.j;
      if (liveMakeLoverOnClickListener != null)
        liveMakeLoverOnClickListener.a(); 
    } 
  }
  
  public boolean performClick() {
    return this.f.performClick();
  }
  
  public static interface LiveMakeLoverOnClickListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\live_china\view\LiveMakeLoverManagerRecordView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */