package com.example.albumappdemo.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.albumappdemo.BR;
import com.example.albumappdemo.model.AlbumList;
import com.example.albumappdemo.viewmodel.AlbumListViewModel;

import java.util.List;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumListAdapter extends RecyclerView.Adapter<AlbumListAdapter.GenericViewHolder> {
    private int layoutId;
    private List<AlbumList> albumLists;
    private AlbumListViewModel viewModel;


    public AlbumListAdapter(@LayoutRes int layoutId, AlbumListViewModel viewModel) {
        this.layoutId = layoutId;
        this.viewModel = viewModel;
    }

    private int getLayoutIdForPosition(int position) {
        return layoutId;
    }

    @Override
    public int getItemCount() {
        return albumLists == null ? 0 : albumLists.size();
    }

    public GenericViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, viewType, parent, false);

        return new GenericViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull GenericViewHolder holder, int position) {
        holder.bind(viewModel, position);
    }

    @Override
    public int getItemViewType(int position) {
        return getLayoutIdForPosition(position);
    }

    public void setAlbumLists(List<AlbumList> albumLists) {
        this.albumLists = albumLists;
    }


    class GenericViewHolder extends RecyclerView.ViewHolder {
        final ViewDataBinding binding;

        GenericViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(AlbumListViewModel viewModel, Integer position) {

            binding.setVariable(BR.listmodel, viewModel);
            binding.setVariable(BR.position, position);
            binding.executePendingBindings();
        }

    }
}
