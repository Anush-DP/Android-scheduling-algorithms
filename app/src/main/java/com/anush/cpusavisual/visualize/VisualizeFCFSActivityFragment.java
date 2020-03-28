package com.anush.cpusavisual.visualize;

import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anush.cpusavisual.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class VisualizeFCFSActivityFragment extends Fragment {

    public VisualizeFCFSActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_visualize_fcfs, container, false);
    }
}
