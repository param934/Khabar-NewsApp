package com.example.newsapp.bookmark;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class StringDao_Impl implements StringDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<StringEntity> __insertionAdapterOfStringEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteByTitle;

  public StringDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfStringEntity = new EntityInsertionAdapter<StringEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `string_table` (`content`,`title`,`url`,`imageurl`,`id`) VALUES (?,?,?,?,nullif(?, 0))";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final StringEntity entity) {
        if (entity.getContent() == null) {
          statement.bindNull(1);
        } else {
          statement.bindString(1, entity.getContent());
        }
        if (entity.getTitle() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getTitle());
        }
        if (entity.getUrl() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getUrl());
        }
        if (entity.getImageurl() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getImageurl());
        }
        statement.bindLong(5, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteByTitle = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM string_table WHERE title = ?";
        return _query;
      }
    };
  }

  @Override
  public void insert(final StringEntity stringEntity) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfStringEntity.insert(stringEntity);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteByTitle(final String value) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteByTitle.acquire();
    int _argIndex = 1;
    if (value == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, value);
    }
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfDeleteByTitle.release(_stmt);
    }
  }

  @Override
  public LiveData<List<StringEntity>> getAllStrings() {
    final String _sql = "SELECT * FROM string_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[] {"string_table"}, false, new Callable<List<StringEntity>>() {
      @Override
      @Nullable
      public List<StringEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
          final int _cursorIndexOfImageurl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageurl");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<StringEntity> _result = new ArrayList<StringEntity>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final StringEntity _item;
            final String _tmpContent;
            if (_cursor.isNull(_cursorIndexOfContent)) {
              _tmpContent = null;
            } else {
              _tmpContent = _cursor.getString(_cursorIndexOfContent);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpUrl;
            if (_cursor.isNull(_cursorIndexOfUrl)) {
              _tmpUrl = null;
            } else {
              _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
            }
            final String _tmpImageurl;
            if (_cursor.isNull(_cursorIndexOfImageurl)) {
              _tmpImageurl = null;
            } else {
              _tmpImageurl = _cursor.getString(_cursorIndexOfImageurl);
            }
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            _item = new StringEntity(_tmpContent,_tmpTitle,_tmpUrl,_tmpImageurl,_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public StringEntity getStringByValue(final String value) {
    final String _sql = "SELECT * FROM string_table WHERE title = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (value == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, value);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfContent = CursorUtil.getColumnIndexOrThrow(_cursor, "content");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfImageurl = CursorUtil.getColumnIndexOrThrow(_cursor, "imageurl");
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final StringEntity _result;
      if (_cursor.moveToFirst()) {
        final String _tmpContent;
        if (_cursor.isNull(_cursorIndexOfContent)) {
          _tmpContent = null;
        } else {
          _tmpContent = _cursor.getString(_cursorIndexOfContent);
        }
        final String _tmpTitle;
        if (_cursor.isNull(_cursorIndexOfTitle)) {
          _tmpTitle = null;
        } else {
          _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        }
        final String _tmpUrl;
        if (_cursor.isNull(_cursorIndexOfUrl)) {
          _tmpUrl = null;
        } else {
          _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        }
        final String _tmpImageurl;
        if (_cursor.isNull(_cursorIndexOfImageurl)) {
          _tmpImageurl = null;
        } else {
          _tmpImageurl = _cursor.getString(_cursorIndexOfImageurl);
        }
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result = new StringEntity(_tmpContent,_tmpTitle,_tmpUrl,_tmpImageurl,_tmpId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
