package ex.mr.marionette;

import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UiFragment extends Fragment {
    private Activity activity;
    private Context context;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity = getActivity();
        context = getContext();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        activity.setTitle(R.string.textUITitle);
        return inflater.inflate(R.layout.ui_fragment, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvUIPage = view.findViewById(R.id.rvUIPage);
        rvUIPage.setLayoutManager(new LinearLayoutManager(activity));
        List<UIPage> uiList = getPageList();
        rvUIPage.setAdapter(new UIAdapter(context, uiList));
    }

    private class UIAdapter extends RecyclerView.Adapter<UIAdapter.MyViewHolder> {
        Context context;
        List<UIPage> uiList;

        UIAdapter(Context context, List<UIPage> uiList) {
            this.context = context;
            this.uiList = uiList;
        }

        @Override
        public int getItemCount() {
            return uiList.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tvHead,tvTitle,tvSubTitle;

            MyViewHolder(View itemView) {
                super(itemView);
                tvHead = itemView.findViewById(R.id.tvHead);
                tvTitle = itemView.findViewById(R.id.tvTitle);
                tvSubTitle = itemView.findViewById(R.id.tvSubTitle);
            }
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(context)
                    .inflate(R.layout.item_view_ui, parent, false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final UIPage uiPage = uiList.get(position);
            holder.tvTitle.setText(uiPage.getItemTitle());
            holder.tvSubTitle.setText(uiPage.getItemSubTitle());


        }




    }
    private List<UIPage> getPageList() {
        List<UIPage> uiList = new ArrayList<>();
        uiList.add(new UIPage(1,"News Title 1","News Sub Title 1"));
        uiList.add(new UIPage(2,"News Title 2","News Sub Title 2"));
        return uiList;
    }
}
