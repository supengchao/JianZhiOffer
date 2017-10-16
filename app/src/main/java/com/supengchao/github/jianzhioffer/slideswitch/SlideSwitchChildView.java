package com.supengchao.github.jianzhioffer.slideswitch;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.supengchao.github.jianzhioffer.R;

/**
 * Created by supengchao on 17/9/15.
 */

public class SlideSwitchChildView extends LinearLayout {

    public SlideSwitchChildView(Context context) {
        super(context);
        initView(context);
    }

    public SlideSwitchChildView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SlideSwitchChildView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context){
        inflate(context, R.layout.slide_switch_child_view,this);
    }
}
