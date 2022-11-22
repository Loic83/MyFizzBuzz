package data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import domain.model.ResultEntity

@Database(
    entities = [ResultEntity::class],
    version = 1
)
abstract class ResultDatabase: RoomDatabase() {

    abstract val resultDao: ResultDao

    companion object {
        const val DATABASE_NAME = "results_db"
    }
}