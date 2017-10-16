package rmakiyama.sample.mvvmsample.domain.usecase

import rmakiyama.sample.mvvmsample.domain.entity.Task

interface GetTasksUseCase {

  fun getTasks()

  class OnLoadedEvent(val tasks: List<Task>)
}
