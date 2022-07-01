package androidx.core.view.accessibility;

import android.os.Bundle;
import android.view.View;

public interface AccessibilityViewCommand {
  boolean perform(View paramView, CommandArguments paramCommandArguments);
  
  public static abstract class CommandArguments {
    Bundle a;
    
    public void setBundle(Bundle param1Bundle) {
      this.a = param1Bundle;
    }
  }
  
  public static final class MoveAtGranularityArguments extends CommandArguments {
    public boolean getExtendSelection() {
      return this.a.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
    }
    
    public int getGranularity() {
      return this.a.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
    }
  }
  
  public static final class MoveHtmlArguments extends CommandArguments {
    public String getHTMLElement() {
      return this.a.getString("ACTION_ARGUMENT_HTML_ELEMENT_STRING");
    }
  }
  
  public static final class MoveWindowArguments extends CommandArguments {
    public int getX() {
      return this.a.getInt("ACTION_ARGUMENT_MOVE_WINDOW_X");
    }
    
    public int getY() {
      return this.a.getInt("ACTION_ARGUMENT_MOVE_WINDOW_Y");
    }
  }
  
  public static final class ScrollToPositionArguments extends CommandArguments {
    public int getColumn() {
      return this.a.getInt("android.view.accessibility.action.ARGUMENT_COLUMN_INT");
    }
    
    public int getRow() {
      return this.a.getInt("android.view.accessibility.action.ARGUMENT_ROW_INT");
    }
  }
  
  public static final class SetProgressArguments extends CommandArguments {
    public float getProgress() {
      return this.a.getFloat("android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE");
    }
  }
  
  public static final class SetSelectionArguments extends CommandArguments {
    public int getEnd() {
      return this.a.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
    }
    
    public int getStart() {
      return this.a.getInt("ACTION_ARGUMENT_SELECTION_START_INT");
    }
  }
  
  public static final class SetTextArguments extends CommandArguments {
    public CharSequence getText() {
      return this.a.getCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
    }
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\androidx\core\view\accessibility\AccessibilityViewCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */