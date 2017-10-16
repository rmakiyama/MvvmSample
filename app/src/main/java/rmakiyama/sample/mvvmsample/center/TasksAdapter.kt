package rmakiyama.sample.mvvmsample.center

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import rmakiyama.sample.mvvmsample.R
import rmakiyama.sample.mvvmsample.databinding.ItemTaskBinding
import rmakiyama.sample.mvvmsample.domain.entity.Task

class TasksAdapter : RecyclerView.Adapter<TasksAdapter.TaskHolder>() {

  private val tasks = ArrayList<Task>()

  override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TaskHolder {
    val binding = DataBindingUtil.inflate<ItemTaskBinding>(
        LayoutInflater.from(parent?.context), R.layout.item_task, parent, false)
    return TaskHolder(binding)
  }

  override fun onBindViewHolder(holder: TaskHolder, position: Int) {
    holder.bindTask(tasks[position])
    holder.mBinding.executePendingBindings()
  }

  override fun getItemCount(): Int = tasks.size

  fun setTasks(tasks: List<Task>) {
    this.tasks.apply {
      clear()
      addAll(tasks)
    }
    notifyDataSetChanged()
  }

  class TaskHolder(val mBinding: ItemTaskBinding) : RecyclerView.ViewHolder(mBinding.root) {

    lateinit var viewModel: TaskViewModel

    fun bindTask(task: Task) {
      if (mBinding.viewModel == null) {
        viewModel = TaskViewModel(task)
        mBinding.viewModel = viewModel
      } else {
        mBinding.viewModel = viewModel.also { it.task.set(task) }
      }
    }
  }
}
