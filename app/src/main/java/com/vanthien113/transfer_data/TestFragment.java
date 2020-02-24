package com.vanthien113.transfer_data;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class TestFragment extends Fragment {
    private TestClickListener listener;
    private TextView tvValue;
    private Button btSend;

    public static TestFragment newInstance(String value) {
        Bundle args = new Bundle();
        args.putString("INPUT", value);

        TestFragment fragment = new TestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvValue = getActivity().findViewById(R.id.tvValue);
        btSend = getActivity().findViewById(R.id.btSend);

        tvValue.setText(getArguments().getString("INPUT"));
        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSendClick("hihihi");
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        if (context instanceof TestClickListener) {
            listener = (TestClickListener) context;
//        }
    }
}
