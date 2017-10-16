package rmakiyama.sample.mvvmsample.center

import android.databinding.ObservableField
import rmakiyama.sample.mvvmsample.domain.entity.Task

class TaskViewModel(task: Task) {

  val task = ObservableField<Task>(task)
}