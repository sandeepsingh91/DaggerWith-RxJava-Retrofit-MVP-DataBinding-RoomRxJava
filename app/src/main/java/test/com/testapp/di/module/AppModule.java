package test.com.testapp.di.module;

import android.app.AlarmManager;
import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.support.v4.app.NotificationManagerCompat;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import test.com.testapp.data.db.AppDatabase;
import test.com.testapp.ui.TestApp;

@Module
public class AppModule {

    private TestApp app;

    public AppModule(TestApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return app;
    }

    @Provides
    @Singleton
    Context providesContext() {
        return app.getApplicationContext();
    }

    @Provides
    @Singleton
    NotificationManagerCompat provideNotificationManager() {
        return NotificationManagerCompat.from(app);
    }

    @Provides
    @Singleton
    AlarmManager provideAlarmManager() {
        return (AlarmManager) app.getSystemService(Context.ALARM_SERVICE);
    }

    @Provides
    @Singleton
    PowerManager providePowerManager() {
        return (PowerManager) app.getSystemService(Context.POWER_SERVICE);
    }

    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences() {
        return app.getSharedPreferences("appName", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    AppDatabase providesAppDatabase() {
        return Room.databaseBuilder(app.getApplicationContext(),
                AppDatabase.class, "database-name").fallbackToDestructiveMigration().build();
    }
}