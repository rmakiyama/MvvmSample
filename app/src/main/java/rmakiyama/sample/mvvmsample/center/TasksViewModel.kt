package rmakiyama.sample.mvvmsample.center

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

  @Subscribe(threadMode = ThreadMode.MAIN)
  fun onTasksLoaded(event: GetTasksUseCase.OnLoadedEvent) {
    tasks.addAll(event.tasks)
    EventBus.getDefault().post(OnLoadedEvent(tasks))
  }

  class OnLoadedEvent(val tasks: List<Task>)
}