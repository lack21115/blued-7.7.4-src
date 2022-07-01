package com.soft.blued.customview.emoji.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.soft.blued.customview.emoji.manager.Emoji;
import java.util.ArrayList;
import java.util.List;

public class EmojiFragment extends Fragment {
  private View a;
  
  private GridView b;
  
  private List<Emoji> c;
  
  private OnEmojiClickedListener d;
  
  private EmojiAdapter e;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private void a() {
    this.b = (GridView)this.a.findViewById(2131297204);
  }
  
  private void b() {
    EmojiAdapter emojiAdapter = this.e;
    if (emojiAdapter == null) {
      this.e = new EmojiAdapter(this, getContext(), this.c);
      this.b.setAdapter((ListAdapter)this.e);
      return;
    } 
    emojiAdapter.notifyDataSetChanged();
  }
  
  private void c() {
    if (this.g)
      return; 
    if (!this.h)
      return; 
    if (!this.f)
      return; 
    this.g = true;
    b();
  }
  
  public void a(OnEmojiClickedListener paramOnEmojiClickedListener) {
    this.d = paramOnEmojiClickedListener;
  }
  
  public void a(List<Emoji> paramList) {
    List<Emoji> list = this.c;
    if (list == null) {
      this.c = new ArrayList<Emoji>();
    } else {
      list.clear();
    } 
    for (int i = 0; i < 35; i++) {
      if (i < paramList.size()) {
        this.c.add(paramList.get(i));
      } else {
        this.c.add(null);
      } 
    } 
    EmojiAdapter emojiAdapter = this.e;
    if (emojiAdapter != null)
      emojiAdapter.notifyDataSetChanged(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.a == null) {
      this.h = true;
      this.a = paramLayoutInflater.inflate(2131493119, paramViewGroup, false);
      a();
      c();
    } 
    ViewGroup viewGroup = (ViewGroup)this.a.getParent();
    if (viewGroup != null)
      viewGroup.removeView(this.a); 
    return this.a;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.f = paramBoolean;
    c();
  }
  
  class EmojiAdapter extends ArrayAdapter<Emoji> {
    public EmojiAdapter(EmojiFragment this$0, Context param1Context, List<Emoji> param1List) {
      super(param1Context, 2131493047, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      ViewHolder viewHolder;
      if (param1View == null) {
        param1View = View.inflate(getContext(), 2131493047, null);
        viewHolder = new ViewHolder(this);
        viewHolder.a = (TextView)param1View.findViewById(2131296982);
        param1View.setTag(viewHolder);
      } else {
        viewHolder = (ViewHolder)param1View.getTag();
      } 
      Emoji emoji = (Emoji)getItem(param1Int);
      if (emoji != null) {
        viewHolder.a.setVisibility(0);
        viewHolder.a.setText(emoji.a());
        viewHolder.a.setOnClickListener(new View.OnClickListener(this, emoji) {
              public void onClick(View param2View) {
                EmojiFragment.a(this.b.a).a(this.a);
              }
            });
        return param1View;
      } 
      viewHolder.a.setVisibility(4);
      return param1View;
    }
    
    class ViewHolder {
      TextView a;
      
      ViewHolder(EmojiFragment.EmojiAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(EmojiFragment this$0, Emoji param1Emoji) {}
    
    public void onClick(View param1View) {
      EmojiFragment.a(this.b.a).a(this.a);
    }
  }
  
  class ViewHolder {
    TextView a;
    
    ViewHolder(EmojiFragment this$0) {}
  }
  
  public static interface OnEmojiClickedListener {
    void a(Emoji param1Emoji);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\fragment\EmojiFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */