package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;

public class SearchView$SearchAutoComplete extends AppCompatAutoCompleteTextView {
  private boolean mHasPendingShowSoftInputRequest;
  
  private Runnable mRunShowSoftInputIfNecessary = new SearchView$SearchAutoComplete$1(this);
  
  private SearchView mSearchView;
  
  private int mThreshold = getThreshold();
  
  public SearchView$SearchAutoComplete(Context paramContext) {
    this(paramContext, (AttributeSet)null);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet) {
    this(paramContext, paramAttributeSet, R.attr.autoCompleteTextViewStyle);
  }
  
  public SearchView$SearchAutoComplete(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setImeVisibility(boolean paramBoolean) {
    InputMethodManager inputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
    if (!paramBoolean) {
      this.mHasPendingShowSoftInputRequest = false;
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
      return;
    } 
    if (inputMethodManager.isActive((View)this)) {
      this.mHasPendingShowSoftInputRequest = false;
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      inputMethodManager.showSoftInput((View)this, 0);
      return;
    } 
    this.mHasPendingShowSoftInputRequest = true;
  }
  
  public boolean enoughToFilter() {
    return (this.mThreshold <= 0 || super.enoughToFilter());
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo) {
    InputConnection inputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (this.mHasPendingShowSoftInputRequest) {
      removeCallbacks(this.mRunShowSoftInputIfNecessary);
      post(this.mRunShowSoftInputIfNecessary);
    } 
    return inputConnection;
  }
  
  protected void onFinishInflate() {
    super.onFinishInflate();
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    Configuration configuration = getResources().getConfiguration();
    int i = configuration.screenWidthDp;
    int j = configuration.screenHeightDp;
    if (i >= 960 && j >= 720 && configuration.orientation == 2) {
      i = 256;
    } else if (i >= 600 || (i >= 640 && j >= 480)) {
      i = 192;
    } else {
      i = 160;
    } 
    setMinWidth((int)TypedValue.applyDimension(1, i, displayMetrics));
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect) {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    this.mSearchView.onTextFocusChanged();
  }
  
  public boolean onKeyPreIme(int paramInt, KeyEvent paramKeyEvent) {
    if (paramInt == 4) {
      if (paramKeyEvent.getAction() == 0 && paramKeyEvent.getRepeatCount() == 0) {
        KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.startTracking(paramKeyEvent, this); 
        return true;
      } 
      if (paramKeyEvent.getAction() == 1) {
        KeyEvent.DispatcherState dispatcherState = getKeyDispatcherState();
        if (dispatcherState != null)
          dispatcherState.handleUpEvent(paramKeyEvent); 
        if (paramKeyEvent.isTracking() && !paramKeyEvent.isCanceled()) {
          this.mSearchView.clearFocus();
          setImeVisibility(false);
          return true;
        } 
      } 
    } 
    return super.onKeyPreIme(paramInt, paramKeyEvent);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {
    super.onWindowFocusChanged(paramBoolean);
    if (paramBoolean && this.mSearchView.hasFocus() && getVisibility() == 0) {
      this.mHasPendingShowSoftInputRequest = true;
      if (SearchView.isLandscapeMode(getContext())) {
        SearchView$AutoCompleteTextViewReflector searchView$AutoCompleteTextViewReflector = SearchView.HIDDEN_METHOD_INVOKER;
        if (searchView$AutoCompleteTextViewReflector.ensureImeVisible != null)
          try {
            searchView$AutoCompleteTextViewReflector.ensureImeVisible.invoke(this, new Object[] { Boolean.valueOf(true) });
            return;
          } catch (Exception exception) {} 
      } 
    } 
  }
  
  public void performCompletion() {}
  
  protected void replaceText(CharSequence paramCharSequence) {}
  
  public void setThreshold(int paramInt) {
    super.setThreshold(paramInt);
    this.mThreshold = paramInt;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\android\support\v7\widget\SearchView$SearchAutoComplete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */