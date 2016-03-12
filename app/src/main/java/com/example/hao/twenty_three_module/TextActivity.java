package com.example.hao.twenty_three_module;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

public class TextActivity extends AppCompatActivity {


    ListView mlist_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        mlist_view = (ListView) findViewById(R.id.mlist_view);

        mlist_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {

                ((LinearLayout)view).getChildAt(0).setVisibility(View.GONE);
                view.findViewById(R.id.textid).setVisibility(View.VISIBLE);

                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();

                viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        //        Utils.log("textView高2:"+((RowTextView)v.getTag()).getHeight());

                        int finalHeight =    Utils.dp2px(40);
                        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                        layoutParams.height = finalHeight;
                        view.setLayoutParams(layoutParams);
                        // Utils.setListViewHeight((ListView) parent,LAD_SysNotification.this);

                    }
                });

            }
        });

        mlist_view.setAdapter(new BSAdapter());




    }
}
