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
    fun insertUser(user: UserTest) : Long

    @Update
    fun updateUser(newUser : UserTest)

    @Query("select * from UserTest")
    fun loadAllUsers() : List<UserTest>

    @Query("select * from UserTest where age > :age")
    fun loadUsersOlderThan(age: Int) : List<UserTest>

    @Delete
    fun deleteUser(user: UserTest)
}

@Database(version = 1, entities = [UserTest::class], exportSchema = false)
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