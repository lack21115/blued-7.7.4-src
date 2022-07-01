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
import com.soft.blued.customview.emoji.category.PeopleCategory;
import com.soft.blued.customview.emoji.manager.Emoji;
import com.soft.blued.emoticon.ui.EmoticonsIndicatorView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecentEmojiFragment extends Fragment {
  private View a;
  
  private GridView b;
  
  private List<Emoji> c = new ArrayList<Emoji>();
  
  private OnRecentEmojiClickedListener d;
  
  private EmojiAdapter e;
  
  private boolean f = false;
  
  private boolean g = false;
  
  private boolean h = false;
  
  private void a() {
    this.b = (GridView)this.a.findViewById(2131297220);
    ((EmoticonsIndicatorView)this.a.findViewById(2131297221)).a(1);
  }
  
  private void b() {
    if (this.g)
      return; 
    if (!this.h)
      return; 
    if (!this.f)
      return; 
    this.g = true;
    c();
  }
  
  private void c() {
    EmojiAdapter emojiAdapter = this.e;
    if (emojiAdapter == null) {
      this.e = new EmojiAdapter(this, getContext(), this.c);
      this.b.setAdapter((ListAdapter)this.e);
      return;
    } 
    emojiAdapter.notifyDataSetChanged();
  }
  
  public void a(OnRecentEmojiClickedListener paramOnRecentEmojiClickedListener) {
    this.d = paramOnRecentEmojiClickedListener;
  }
  
  public void a(Collection<Emoji> paramCollection) {
    this.c.clear();
    Emoji[] arrayOfEmoji = paramCollection.<Emoji>toArray(new Emoji[paramCollection.size()]);
    boolean bool = false;
    int i;
    for (i = 0; i < arrayOfEmoji.length; i++)
      this.c.add(arrayOfEmoji[i]); 
    if (paramCollection.size() < 35) {
      int j = paramCollection.size();
      for (i = bool; i < 35 - j; i++)
        this.c.add(PeopleCategory.a[i]); 
    } 
    EmojiAdapter emojiAdapter = this.e;
    if (emojiAdapter != null)
      emojiAdapter.notifyDataSetChanged(); 
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle) {
    if (this.a == null) {
      this.h = true;
      this.a = paramLayoutInflater.inflate(2131493279, paramViewGroup, false);
      a();
      b();
    } 
    ViewGroup viewGroup = (ViewGroup)this.a.getParent();
    if (viewGroup != null)
      viewGroup.removeView(this.a); 
    return this.a;
  }
  
  public void setUserVisibleHint(boolean paramBoolean) {
    super.setUserVisibleHint(paramBoolean);
    this.f = paramBoolean;
    b();
  }
  
  class EmojiAdapter extends ArrayAdapter<Emoji> {
    public EmojiAdapter(RecentEmojiFragment this$0, Context param1Context, List<Emoji> param1List) {
      super(param1Context, 2131493047, param1List);
    }
    
    public View getView(int param1Int, View param1View, ViewGroup param1ViewGroup) {
      View view = param1View;
      if (param1View == null) {
        view = View.inflate(getContext(), 2131493047, null);
        ViewHolder viewHolder1 = new ViewHolder(this);
        viewHolder1.a = (TextView)view.findViewById(2131296982);
        view.setTag(viewHolder1);
      } 
      Emoji emoji = (Emoji)getItem(param1Int);
      ViewHolder viewHolder = (ViewHolder)view.getTag();
      if (emoji != null) {
        viewHolder.a.setVisibility(0);
        viewHolder.a.setText(emoji.a());
        viewHolder.a.setOnClickListener(new View.OnClickListener(this, emoji) {
              public void onClick(View param2View) {
                RecentEmojiFragment.a(this.b.a).b(this.a);
              }
            });
        return view;
      } 
      viewHolder.a.setVisibility(4);
      return view;
    }
    
    class ViewHolder {
      TextView a;
      
      ViewHolder(RecentEmojiFragment.EmojiAdapter this$0) {}
    }
  }
  
  class null implements View.OnClickListener {
    null(RecentEmojiFragment this$0, Emoji param1Emoji) {}
    
    public void onClick(View param1View) {
      RecentEmojiFragment.a(this.b.a).b(this.a);
    }
  }
  
  class ViewHolder {
    TextView a;
    
    ViewHolder(RecentEmojiFragment this$0) {}
  }
  
  public static interface OnRecentEmojiClickedListener {
    void b(Emoji param1Emoji);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blued\customview\emoji\fragment\RecentEmojiFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */