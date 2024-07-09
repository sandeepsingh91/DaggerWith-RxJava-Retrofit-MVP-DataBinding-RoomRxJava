package test.com.testapp.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import test.com.testapp.data.db.model.User;
import test.com.testapp.data.db.model.UserDao;

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

