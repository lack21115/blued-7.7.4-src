package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
  private TextView a;
  
  private TextClassifier b;
  
  AppCompatTextClassifierHelper(TextView paramTextView) {
    this.a = (TextView)Preconditions.checkNotNull(paramTextView);
  }
  
  public TextClassifier getTextClassifier() {
    TextClassifier textClassifier2 = this.b;
    TextClassifier textClassifier1 = textClassifier2;
    if (textClassifier2 == null) {
      TextClassificationManager textClassificationManager = (TextClassificationManager)this.a.getContext().getSystemService(TextClassificationManager.class);
      if (textClassificationManager != null)
        return textClassificationManager.getTextClassifier(); 
      textClassifier1 = TextClassifier.NO_OP;
    } 
    return textClassifier1;
  }
  
  public void setTextClassifier(TextClassifier paramTextClassifier) {
    this.b = paramTextClassifier;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\appcompat\widget\AppCompatTextClassifierHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */