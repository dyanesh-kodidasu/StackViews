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

public class FirstBottomSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener{

    public static final String TAG = "cred/FirstBottomSheetFragment";

    private IViewClickListeners mListener;
    public static FirstBottomSheetFragment newInstance() {
        return new FirstBottomSheetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.first_bottom_sheet_fragment,container);
        return inflatedView;
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
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.GONE);
                bottomSheet.getLayoutParams().height = Constants.FIRST_BOTTOM_SHEET_HEIGHT;
            } else {
                bottomSheet.findViewById(R.id.landscape_swipe_up).setVisibility(View.VISIBLE);
                bottomSheet.getLayoutParams().height = Constants.FIRST_BOTTOM_SHEET_LANDSCAPE_HEIGHT;
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
        mListener.onItemClick(Constants.INFLATE_SECOND_BOTTOM_SHEET);
    }


}
