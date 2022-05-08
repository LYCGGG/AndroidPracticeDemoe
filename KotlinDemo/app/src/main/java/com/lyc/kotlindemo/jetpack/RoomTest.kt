package com.lyc.kotlindemo.jetpack

import android.content.Context
import androidx.room.*

class RoomTest {
}

@Entity
data class UserTest(var firstName: String, var lastName: String, var age : Int) {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
}

@Dao
interface UserDao {
    @Insert
    fun insertUser(user: User) : Long

    @Update
    fun updateUser(newUser : User)

    @Query("select * from UserTest")
    fun loadAllUsers() : List<User>

    @Query("select * from UserTest where age > 20")
    fun loadUsersOlderThan()

    @Delete
    fun deleteUser(user: User)
}

@Database(version = 1, entities = [User::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object {
        private var instance : AppDatabase ?= null

        @Synchronized
        fun getDatabase(context: Context) : AppDatabase {
            instance?.let {
                return it
            }
            return Room.databaseBuilder(context.applicationContext,
            AppDatabase::class.java, "app_database")
                .build().apply {
                    instance = this
                }

        }
    }
}