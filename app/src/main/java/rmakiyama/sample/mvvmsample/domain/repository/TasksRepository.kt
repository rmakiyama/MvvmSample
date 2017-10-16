package rmakiyama.sample.mvvmsample.domain.repository

import rmakiyama.sample.mvvmsample.domain.entity.Task


interface TasksRepository {

  fun getTasks(): List<Task>
}
