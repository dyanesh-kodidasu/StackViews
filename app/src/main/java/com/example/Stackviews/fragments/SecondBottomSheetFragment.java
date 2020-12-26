package com.example.Stackviews.fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.Stackviews.Constants;
import com.example.Stackviews.IViewClickListeners;
import com.example.Stackviews.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class SecondBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener{

    public static final String TAG = "cred/SecondBottomSheetFragment";

    private IViewClickListeners mListener;
    public static SecondBottomSheetFragment newInstance() {
        return new SecondBottomSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.second_bottom_sheet_fragment,container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.next_view_cta).setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        View bottomSheet =getView();
        Configuration configuration = getResources().getConfiguration();
        if(bottomSheet != null) {
            if(configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                bottomSheet.getLayoutParams().height = Constants.SECOND_BOTTOM_SHEET_HEIGHT;
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.GONE);
            } else {
                bottomSheet.getLayoutParams().height = Constants.SECOND_BOTTOM_SHEET_LANDSCAPE_HEIGHT;
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof IViewClickListeners) {
            mListener = (IViewClickListeners) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ItemClickListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG,"Button clicked");
        TextView textView = (TextView)view;
        mListener.onItemClick(Constants.INFLATE_THIRD_BOTTOM_SHEET);
    }


}
