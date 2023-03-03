package com.example.pr3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MenuLayoutFragment extends Fragment {

        private final static String TAG = "MenuLayoutFragment";

        public interface OnFragmentToDataListener {
            void onFragmentToDataListener(String string);
        }

        private MenuLayoutFragment.OnFragmentToDataListener mListener;


        public MenuLayoutFragment(){
            Log.d(TAG, "Constructor");

        }

        public void setAnswer (String answer){
            TextView textView = (TextView) getView().findViewById(R.id.for_result);
            textView.setText(answer);
        }

        @Override
        public void onAttach(@NonNull Context context) {
            super.onAttach(context);
            Log.d(TAG, "onAttach");
            mListener = (MenuLayoutFragment.OnFragmentToDataListener) context;
            Toast.makeText(getActivity(), "On attach", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.d(TAG, "onCreate");
            Toast.makeText(getActivity(), "On create", Toast.LENGTH_SHORT).show();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "onCreateView");
            Toast.makeText(getActivity(), "On createView", Toast.LENGTH_SHORT).show();
            return inflater.inflate(R.layout.fragment_menu_layout,null);
        }

        @Override
        public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            Bundle bundle = this.getArguments();
            if (bundle != null) {
                String answer = bundle.getString("key");
                TextView textView = (TextView) view.findViewById(R.id.for_result);
                textView.setText(answer);
            }

            Button button1 = view.findViewById(R.id.button_1);
            Button button2 = view.findViewById(R.id.button_2);
            Button button3 = view.findViewById(R.id.button_3);
            Button button4 = view.findViewById(R.id.button_4);
            EditText enterText = (EditText) view.findViewById(R.id.entering_text);
            Log.d(TAG, "onViewCreated");
            Toast.makeText(getActivity(), "On ViewCreated", Toast.LENGTH_SHORT).show();
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent1 = new Intent(getActivity(), ActivityMain.class);
                    intent1.putExtra("enter", enterText.getText());
                    startActivity(intent1);
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent2 = new Intent(getActivity(), ActivityLinear.class);
                    intent2.putExtra("enter", enterText.getText());
                    startActivity(intent2);
                }
            });
            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent3 = new Intent(getActivity(), ActivityRelative.class);
                    intent3.putExtra("enter", enterText.getText());
                    startActivity(intent3);
                }
            });
            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onFragmentToDataListener("text");
                }
            });
        }

        @Override
        public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
            super.onViewStateRestored(savedInstanceState);
            Log.d(TAG, "onViewStateRestored");
            Toast.makeText(getActivity(), "on ViewStateRestored", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStart() {
            super.onStart();
            Log.d(TAG, "onStart");
            Toast.makeText(getActivity(), "on Start", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.d(TAG, "onResume");
            Toast.makeText(getActivity(), "on Resume", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.d(TAG, "onPause");
            Toast.makeText(getActivity(), "on Pause", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.d(TAG, "onStop");
            Toast.makeText(getActivity(), "on Stop", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.d(TAG, "onDestroyView");
            Toast.makeText(getActivity(), "on DestroyView", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d(TAG, "onDestroy");
            Toast.makeText(getActivity(), "on Destroy", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Log.d(TAG, "onDetach");
            Toast.makeText(getActivity(), "on Detach", Toast.LENGTH_SHORT).show();
        }


}