package rmakiyama.sample.mvvmsample.center

import android.widget.CompoundButton
import org.greenrobot.eventbus.EventBus
import rmakiyama.sample.mvvmsample.domain.entity.Task
import rmakiyama.sample.mvvmsample.domain.usecase.GetTasksUseCase
import org.greenrobot.eventbus.ThreadMode
import org.greenrobot.eventbus.Subscribe
import rmakiyama.sample.mvvmsample.ViewModel

class TasksViewModel constructor(
    private val mGetTasksUseCase: GetTasksUseCase) : ViewModel() {

  private val tasks = ArrayList<Task>()

  override fun onResume() {
    EventBus.getDefault().register(this)
    mGetTasksUseCase.getTasks()
  }

  override fun onPause() {
    EventBus.getDefault().unregister(this)
  }

  fun onCheckedChanged(@SuppressWarnings("unused") view: CompoundButton, isChecked: Boolean) {
    if (isChecked) {
      EventBus.getDefault().post(OnShowCompletedEvent(tasks.filter { it.completed }))
    } else {
      EventBus.getDefault().post(OnShowAllEvent(tasks))
    }
  }

  @Subscribe(threadMode = ThreadMode.MAIN)
  fun onTasksLoaded(event: GetTasksUseCase.OnLoadedEvent) {
    tasks.addAll(event.tasks)
    EventBus.getDefault().post(OnLoadedEvent(tasks))
  }

  class OnLoadedEvent(val tasks: List<Task>)
  class OnShowCompletedEvent(val completedTasks: List<Task>)
  class OnShowAllEvent(val allTasks: List<Task>)
}