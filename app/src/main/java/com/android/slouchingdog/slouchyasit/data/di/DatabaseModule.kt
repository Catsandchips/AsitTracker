package com.android.slouchingdog.slouchyasit.data.di

import android.content.Context
import androidx.room.Room
import com.android.slouchingdog.slouchyasit.data.local.IntakeDAO
import com.android.slouchingdog.slouchyasit.data.local.IntakeDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val DB_NAME = "SlouchyASITDB"

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): IntakeDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = IntakeDatabase::class.java,
            name = DB_NAME,
        ).build()
    }

    @Provides
    @Singleton
    fun provideDAO(database: IntakeDatabase): IntakeDAO {
        return database.intakeDao()
    }
}