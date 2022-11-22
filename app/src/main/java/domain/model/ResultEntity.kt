package domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var result: String
)
