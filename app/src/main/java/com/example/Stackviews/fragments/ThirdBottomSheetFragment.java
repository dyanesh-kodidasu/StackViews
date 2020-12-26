package com.example.Stackviews.fragments;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.Stackviews.Constants;
import com.example.Stackviews.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ThirdBottomSheetFragment extends BottomSheetDialogFragment {

    public static final String TAG = "cred/ThirdBottomSheetFragment";

    public static ThirdBottomSheetFragment newInstance() {
        return new ThirdBottomSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.third_bottom_sheet_fragment, container);
    }

    @Override
    public void onStart() {
        super.onStart();
        View bottomSheet = getView();
        Configuration configuration = getResources().getConfiguration();
        if(bottomSheet != null) {
            if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                bottomSheet.getLayoutParams().height = Constants.THIRD_BOTTOM_SHEET_HEIGHT;
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.GONE);
            } else {
                bottomSheet.getLayoutParams().height = Constants.THIRD_BOTTOM_SHEET_LANDSCAPE_HEIGHT;
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.VISIBLE);
            }
        }
    }

}
