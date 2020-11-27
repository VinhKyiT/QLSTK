package tech.vktl.qlsotietkiem;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tech.vktl.qlsotietkiem.adpaters.NotificationAdapter;
import tech.vktl.qlsotietkiem.adpaters.PromoAdapter;
import tech.vktl.qlsotietkiem.models.ModelNotification;

public class Noti_Chung extends Fragment {

    List<ModelNotification> notifications;
    RecyclerView notiRecv;
    NotificationAdapter notificationAdapter;
    DividerItemDecoration mDividerItemDecoration;

    public Noti_Chung() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_noti__chung, container, false);

        notifications = new ArrayList<>();
        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));
        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));
        notifications.add(new ModelNotification("Thông báo 1", "Nội dung thông báo 1", "26/11/2020", false));

        notiRecv = view.findViewById(R.id.notiRecv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        //set layout vao recyclerview
        notiRecv.setLayoutManager(linearLayoutManager);
        notificationAdapter = new NotificationAdapter(getActivity(), notifications);
        notiRecv.setAdapter(notificationAdapter);
        mDividerItemDecoration = new DividerItemDecoration(notiRecv.getContext(),
                linearLayoutManager.getOrientation());
        notiRecv.addItemDecoration(mDividerItemDecoration);

        return view;
    }
}