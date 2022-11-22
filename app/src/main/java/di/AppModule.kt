package di

import data.db.ResultDatabase
import domain.repository.ResultRepository
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import data.repository.ResultRepositoryImpl
import domain.use_case.AddResult
import domain.use_case.DeleteResults
import domain.use_case.GetResults
import domain.use_case.ResultUseCases
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideResultDatabase(app: Application): ResultDatabase {
        return Room.databaseBuilder(
            app,
            ResultDatabase::class.java,
            ResultDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideResultRepository(db: ResultDatabase): ResultRepository {
        return ResultRepositoryImpl(db.resultDao)
    }

    @Provides
    @Singleton
    fun provideResultUseCases(repository: ResultRepository): ResultUseCases {
        return ResultUseCases(
            getResults = GetResults(repository),
            addResult = AddResult(repository),
            deleteResults = DeleteResults(repository)
        )
    }
}