package cn.wildfire.chat.moment.thirdbar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import cn.wildfire.chat.moment.thirdbar.StatusBarHelper;
import cn.wildfire.chat.moment.thirdbar.StatusBarViewPlaceHolder;
import cn.wildfire.chat.kit.R;

/**
 * Created by 大灯泡 on 2017/3/22.
 * <p>
 * BaseActivity
 */

public abstract class BaseStatusControlActivity extends AppCompatActivity {

    protected StatusBarViewPlaceHolder mStatusBarViewPlaceHolder;
    private boolean isInitStatusConfig = false;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onAfterSetedContentView();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onAfterSetedContentView();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        onAfterSetedContentView();
    }

    protected void onAfterSetedContentView() {
        if (!isInitStatusConfig && isTranslucentStatus()) {
            StatusBarHelper.setRootViewFitsSystemWindows(this, isFitsSystemWindows());
            StatusBarHelper.setTranslucentStatus(this);
            isInitStatusConfig = true;
        }
        if (mStatusBarViewPlaceHolder == null) {
            mStatusBarViewPlaceHolder = findViewById(R.id.statusbar_placeholder);
        }
    }

    protected void setStatusBarHolderBackgroundColor(int color) {
        if (mStatusBarViewPlaceHolder != null) {
            mStatusBarViewPlaceHolder.setBackgroundColor(color);
        }
    }

    protected boolean isFitsSystemWindows() {
        return true;
    }

    protected boolean isTranslucentStatus() {
        return false;
    }

    protected void setStatusBarColor(int color) {
        StatusBarHelper.setStatusBarColor(this, color);
    }

    protected boolean setStatusBarDark(boolean dark) {
        return StatusBarHelper.setStatusBarDarkTheme(this, dark);
    }
}
