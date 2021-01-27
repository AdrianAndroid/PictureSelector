package com.luck.pictureselector;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//https://blog.csdn.net/yann02/article/details/92844364
public class MediaStoreFiles {
    private static class FileEntity {
        public void setName(String displayName) {

        }

        public void setPath(String path) {

        }

        public void setSize(Long showLongFileSize) {

        }

        public void setId(String s) {

        }

        public void setTime(String time) {

        }
    }

    // 获取所有文件
    public static List<FileEntity> getFilesByType(Context context) {
        List<FileEntity> files = new ArrayList<>();
        // 扫描files文件库
        Cursor c = null;
        try {
            ContentResolver mContentResolver = context.getContentResolver();
            c = mContentResolver.query(MediaStore.Files.getContentUri("external"), null, null, null, null);
            int columnIndexOrThrow_ID = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID);
            int columnIndexOrThrow_MIME_TYPE = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE);
            int columnIndexOrThrow_DATA = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATA);
            int columnIndexOrThrow_SIZE = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.SIZE);
            int columnIndexOrThrow_DATE_MODIFIED = c.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DATE_MODIFIED);

            int tempId = 0;
            while (c.moveToNext()) {
                String path = c.getString(columnIndexOrThrow_DATA);
                String minType = c.getString(columnIndexOrThrow_MIME_TYPE);

                int position_do = path.lastIndexOf(".");
                if (position_do == -1) {
                    continue;
                }
                int position_x = path.lastIndexOf(File.separator);
                if (position_x == -1) {
                    continue;
                }
                String displayName = path.substring(position_x + 1, path.length());
                long size = c.getLong(columnIndexOrThrow_SIZE);
                long modified_date = c.getLong(columnIndexOrThrow_DATE_MODIFIED);
                File file = new File(path);
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));

                FileEntity info = new FileEntity();
                info.setName(displayName);
                info.setPath(path);
                info.setSize(ShowLongFileSize(size));
                info.setId((tempId++) + "");
                info.setTime(time);
                files.add(info);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return files;
    }

    private static Long ShowLongFileSize(long size) {
        return 0L;
    }

    //获取视频文件
    public static List<FileEntity> getFilesByVideo(Context context) {
        List<FileEntity> files = new ArrayList<>();
        // 扫描files文件库
        Cursor c = null;
        try {
            ContentResolver mContentResolver = context.getContentResolver();
            c = mContentResolver.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI
                    , null, null, null, null);
            int columnIndexOrThrow_ID = c.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
            int columnIndexOrThrow_MIME_TYPE = c.getColumnIndexOrThrow(MediaStore.Video.Media.MIME_TYPE);
            int columnIndexOrThrow_DATA = c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            int columnIndexOrThrow_SIZE = c.getColumnIndexOrThrow(MediaStore.Video.Media.SIZE);
            // 更改时间
            int columnIndexOrThrow_DATE_MODIFIED = c.getColumnIndexOrThrow(MediaStore.Video.Media.DATE_MODIFIED);

            int tempId = 0;
            while (c.moveToNext()) {
                String path = c.getString(columnIndexOrThrow_DATA);
                String minType = c.getString(columnIndexOrThrow_MIME_TYPE);
                int position_do = path.lastIndexOf(".");
                if (position_do == -1) {
                    continue;
                }
                int position_x = path.lastIndexOf(File.separator);
                if (position_x == -1) {
                    continue;
                }
                String displayName = path.substring(position_x + 1, path.length());
                long size = c.getLong(columnIndexOrThrow_SIZE);
                long modified_date = c.getLong(columnIndexOrThrow_DATE_MODIFIED);
                File file = new File(path);
                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(file.lastModified()));
                FileEntity info = new FileEntity();
                info.setName(displayName);
                info.setPath(path);
                info.setSize(ShowLongFileSzie(size));
                info.setId((tempId++) + "");
                info.setTime(time);
                files.add(info);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) c.close();
        }
        return files;
    }

    private static Long ShowLongFileSzie(long size) {
        return 0L;
    }

}
