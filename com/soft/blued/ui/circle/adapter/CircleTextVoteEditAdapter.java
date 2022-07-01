package com.soft.blued.ui.circle.adapter;

import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.soft.blued.ui.feed.model.CircleTextVote;
import com.soft.blued.view.tip.CommonAlertDialog;
import java.util.List;

public class CircleTextVoteEditAdapter extends BaseQuickAdapter<CircleTextVote, BaseViewHolder> {
  private OnEditChangeListener a;
  
  public CircleTextVoteEditAdapter() {
    super(2131493487);
    this.n.add(new CircleTextVote());
    this.n.add(new CircleTextVote());
    notifyDataSetChanged();
  }
  
  private void a(int paramInt) {
    CommonAlertDialog.a(this.k, this.k.getString(2131756094), this.k.getString(2131755950), this.k.getString(2131755609), new DialogInterface.OnClickListener(this, paramInt) {
          public void onClick(DialogInterface param1DialogInterface, int param1Int) {
            CircleTextVoteEditAdapter.b(this.b).remove(this.a);
            this.b.notifyDataSetChanged();
            CircleTextVoteEditAdapter.a(this.b).a();
          }
        }this.k.getString(2131755577), null, null);
  }
  
  protected void a(BaseViewHolder paramBaseViewHolder, CircleTextVote paramCircleTextVote) {
    if (paramBaseViewHolder != null && paramCircleTextVote != null) {
      int i = paramBaseViewHolder.getAdapterPosition() - o();
      EditText editText = (EditText)paramBaseViewHolder.d(2131296978);
      editText.removeTextChangedListener((TextWatcher)editText.getTag());
      editText.setText(paramCircleTextVote.option);
      TextWatcher textWatcher = new TextWatcher(this, paramCircleTextVote, editText) {
          public void afterTextChanged(Editable param1Editable) {
            this.a.option = this.b.getText().toString();
            if (CircleTextVoteEditAdapter.a(this.c) != null)
              CircleTextVoteEditAdapter.a(this.c).a(); 
          }
          
          public void beforeTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
          
          public void onTextChanged(CharSequence param1CharSequence, int param1Int1, int param1Int2, int param1Int3) {}
        };
      editText.setTag(textWatcher);
      editText.addTextChangedListener(textWatcher);
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append(this.k.getString(2131755954));
      stringBuilder.append(paramBaseViewHolder.getAdapterPosition() + 1);
      editText.setHint(stringBuilder.toString());
      editText.setOnEditorActionListener(new TextView.OnEditorActionListener(this) {
            public boolean onEditorAction(TextView param1TextView, int param1Int, KeyEvent param1KeyEvent) {
              return (param1KeyEvent.getKeyCode() == 66);
            }
          });
      ImageView imageView = (ImageView)paramBaseViewHolder.d(2131297729);
      if (i + 1 > 2) {
        imageView.setVisibility(0);
        imageView.setOnClickListener(new View.OnClickListener(this, i) {
              public void onClick(View param1View) {
                CircleTextVoteEditAdapter.a(this.b, this.a);
              }
            });
        return;
      } 
      imageView.setVisibility(8);
      imageView.setOnClickListener(null);
    } 
  }
  
  public void a(OnEditChangeListener paramOnEditChangeListener) {
    this.a = paramOnEditChangeListener;
  }
  
  public static interface OnEditChangeListener {
    void a();
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\soft\blue\\ui\circle\adapter\CircleTextVoteEditAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */