package com.vipul.bit_hotels.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.vipul.bit_hotels.R;

public class GalleryActivity extends BaseActivity {
    private ImageView ivHeroImage, ivClose;
    private int imageResource;
    private LinearLayout parentLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        parentLayout = (LinearLayout) findViewById(R.id.parent_view);
        ivHeroImage = (ImageView) findViewById(R.id.iv_image_gallery);
        ivClose = (ImageView) findViewById(R.id.iv_close);
        imageResource = getIntent().getIntExtra("image", R.drawable.img_city_1);
        ivHeroImage.setImageResource(imageResource);

        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
