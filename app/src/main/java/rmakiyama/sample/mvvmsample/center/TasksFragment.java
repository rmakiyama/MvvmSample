package rmakiyama.sample.mvvmsample.center;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import rmakiyama.sample.mvvmsample.data.repository.TasksRepositoryImpl;
import rmakiyama.sample.mvvmsample.databinding.FragmentCenterBinding;
import rmakiyama.sample.mvvmsample.domain.usecase.GetTasksUseCaseImpl;

public class TasksFragment extends Fragment {

    private FragmentCenterBinding mBinding;
    private TasksViewModel mViewModel =
            new TasksViewModel(new GetTasksUseCaseImpl(TasksRepositoryImpl.getInstance()));
    private TasksAdapter mAdapter = new TasksAdapter();

    public static TasksFragment newInstance() {
        return new TasksFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentCenterBinding.inflate(inflater, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupRecyclerView(mBinding.tasks);
    }

    private void setupRecyclerView(RecyclerView v) {
        v.setLayoutManager(new LinearLayoutManager(getContext()));
        v.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
        mViewModel.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
        mViewModel.onPause();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onTasksLoaded(TasksViewModel.OnLoadedEvent event) {
        mAdapter.setTasks(event.getTasks());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSwitchToggle(TasksViewModel.OnShowCompletedEvent event) {
        mAdapter.setTasks(event.getCompletedTasks());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSwitchToggle(TasksViewModel.OnShowAllEvent event) {
        mAdapter.setTasks(event.getAllTasks());
    }
}
