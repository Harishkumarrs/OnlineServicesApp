package com.example.servicesapp;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    GridView gridView;
    String[] names = {"burner","burner clean","regulator","tube"};
    int[] images = {R.drawable.burner,R.drawable.burnerclean,R.drawable.regulator,R.drawable.tube};

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        LinearLayout layout = rootView.findViewById(R.id.HomeLinearLayout);
        // Inflate the layout for this fragment
        gridView = (GridView) rootView.findViewById(R.id.GridViewLayout);
        CustomAdapter customAdapter = new CustomAdapter(names,images,getActivity());
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getActivity(),"You clicked on "+names[i],Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getActivity(),ServicesPage.class);
                intent.putExtra("id",i);
                startActivity(intent);
            }
        });
        return rootView;
    }

    public class CustomAdapter extends BaseAdapter {

        private String[] imageNames;
        private int[] imagePhoto;
        private Context context;
        private LayoutInflater layoutInflater;


        public CustomAdapter(String[] imageNames, int[] imagePhoto, Context context2) {
            this.imageNames = imageNames;
            this.imagePhoto = imagePhoto;
            this.context = context2;
            this.layoutInflater = (LayoutInflater) context2.getSystemService(LAYOUT_INFLATER_SERVICE) ;
        }

        @Override
        public int getCount() {
            return imagePhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view == null)
            {
                view = layoutInflater.inflate(R.layout.grid_item,viewGroup,false);
            }

            TextView textView = view.findViewById(R.id.TextName);
            ImageView imageView = view.findViewById(R.id.ServiceImage);

            textView.setText(imageNames[i]);
            imageView.setImageResource(imagePhoto[i]);
            return view;
        }
    }
}