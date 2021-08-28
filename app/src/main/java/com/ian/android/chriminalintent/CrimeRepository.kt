package com.ian.android.chriminalintent

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.ian.android.chriminalintent.database.CrimeDatabase
import java.util.*

private const val DATABASE_NAME = "crime-database"

class CrimeRepository private constructor(context: Context) { // singleton實例
    private val database: CrimeDatabase = Room.databaseBuilder(
        context.applicationContext, // 應用上下文
        CrimeDatabase::class.java,
        DATABASE_NAME
    ).build()

    private val crimeDao = database.crimeDao()

//    fun getCrimes(): List<Crime> = crimeDao.getCrimes()
    fun getCrimes(): LiveData<List<Crime>> = crimeDao.getCrimes()

//    fun getCrime(id: UUID): Crime? = crimeDao.getCrime(id)
    fun getCrime(id: UUID): LiveData<Crime?> = crimeDao.getCrime(id)


    companion object {
        private var INSTANCE: CrimeRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }

        fun get(): CrimeRepository {
            return INSTANCE
                ?: throw IllegalArgumentException("CrimeRepositary must be initialized.")
        }
    }
}