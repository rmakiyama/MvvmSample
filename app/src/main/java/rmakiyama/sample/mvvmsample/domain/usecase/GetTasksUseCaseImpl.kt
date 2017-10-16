package rmakiyama.sample.mvvmsample.domain.usecase

import rmakiyama.sample.mvvmsample.domain.repository.TasksRepository
import org.greenrobot.eventbus.EventBus


class GetTasksUseCaseImpl constructor(
    private val mRepository: TasksRepository) : GetTasksUseCase {

  override fun getTasks() {
    mRepository.getTasks().also { EventBus.getDefault().post(GetTasksUseCase.OnLoadedEvent(it)) }
  }
}
