package com.example.Stackviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.Stackviews.fragments.FirstBottomSheetFragment;
import com.example.Stackviews.fragments.SecondBottomSheetFragment;
import com.example.Stackviews.fragments.ThirdBottomSheetFragment;

public class MainActivity extends AppCompatActivity implements IViewClickListeners {
    private static String TAG = "MainActivity";
    Button nextViewButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nextViewButton = findViewById(R.id.next_view_cta);
        addClickListener();
    }

    private void addClickListener() {
        nextViewButton.setOnClickListener((v) -> {
            onItemClick(Constants.INFLATE_FIRST_BOTTOM_SHEET);
        });
    }

    @Override
    public void onItemClick(String item) {
        if(Constants.INFLATE_FIRST_BOTTOM_SHEET.equals(item)) {
            FirstBottomSheetFragment addPhotoBottomDialogFragment =
                    FirstBottomSheetFragment.newInstance();
            addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                    FirstBottomSheetFragment.TAG);
        } else if(Constants.INFLATE_SECOND_BOTTOM_SHEET.equals(item)) {
            SecondBottomSheetFragment addPhotoBottomDialogFragment =
                    SecondBottomSheetFragment.newInstance();
            addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                    SecondBottomSheetFragment.TAG);
        } else if(Constants.INFLATE_THIRD_BOTTOM_SHEET.equals(item)) {
            ThirdBottomSheetFragment addPhotoBottomDialogFragment =
                    ThirdBottomSheetFragment.newInstance();
            addPhotoBottomDialogFragment.show(getSupportFragmentManager(),
                    ThirdBottomSheetFragment.TAG);
        }
    }
}