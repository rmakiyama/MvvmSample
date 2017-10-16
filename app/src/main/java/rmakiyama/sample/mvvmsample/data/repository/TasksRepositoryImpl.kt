package rmakiyama.sample.mvvmsample.data.repository

import rmakiyama.sample.mvvmsample.domain.entity.Task
import rmakiyama.sample.mvvmsample.domain.repository.TasksRepository

class TasksRepositoryImpl : TasksRepository {

  companion object {

    private var INSTANCE: TasksRepository? = null

    @JvmStatic
    fun getInstance() = INSTANCE ?: TasksRepositoryImpl().also { INSTANCE = it }
  }

  override fun getTasks(): List<Task> {
    return arrayListOf(
        Task(title = "task 1", description = "The Android Architecture Blueprints project demonstrates strategies to help solve or avoid these common problems. This project implements the same app using different architectural concepts and tools."),
        Task(title = "task 2"),
        Task(title = "task 3", description = "This project hosts each sample app in separate repository branches. For more information, see the README.md file in each branch."),
        Task(title = "task 4"),
        Task(title = "task 5", description = "データ バインディング用のレイアウト ファイルは通常のレイアウト ファイルとは若干異なっており、最初にルート要素の layout タグがあり、その下に data要素、view のルート要素と続きます。この view 要素は、通常のレイアウト ファイルにおけるルート要素です。", completed = true),
        Task(title = "task 6", description = "データバイディングでは、onClick イベントなどのビューから送られたイベントを処理する式を記述することができます。いくつかの例外を除いて、イベント属性名はリスナー メソッドの名前によって決まります。たとえば、View.OnLongClickListener のメソッドは onLongClick() なので、このイベント属性は android:onLongClick になります。イベントを扱うには 2 つの方法があります。", completed = true),
        Task(title = "task 7", description = "リスナーは、式のルート要素としてのみ許可されたラムダ式で表されます。式の中でコールバックが使われている場合、データ バインディングでは自動的に必要なリスナーを作成して、対応するイベントに登録します。ビューがイベントを発生させると、データ バインディングでは指定した式が評価されます。通常のバインディング式と同じく、リスナー式の評価中に null やデータ バインディングのスレッドセーフが返される場合があります。", completed = true)
    )
  }
}
