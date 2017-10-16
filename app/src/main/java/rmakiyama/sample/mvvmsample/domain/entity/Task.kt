package rmakiyama.sample.mvvmsample.domain.entity


import java.util.UUID

data class Task(
    val id: String = UUID.randomUUID().toString(),
    var title: String,
    var description: String? = null,
    var completed: Boolean = false
)
