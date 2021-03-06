package com.bbgo.common_base.util

import android.os.Environment
import android.os.Environment.MEDIA_MOUNTED
import com.bbgo.common_base.RootApplication
import com.orhanobut.logger.Logger
import java.io.File


class FileUtil {

    companion object {

        /**
         * 外置存储卡的路径
         */
        fun getExternalStorePath(): String? {
            return if (isExistExternalStore()) {
                Environment.getExternalStorageDirectory().absolutePath
            } else null
        }

        /**
         * 内置存储卡的路径
         */
        fun getInternalStorePath(): String? {
            return RootApplication.getContext().filesDir.absolutePath
        }

        /**
         * 优先使用外置存储卡，没有则使用内部存储卡
         */
        fun getStorePath(): String? {
            return if (isExistExternalStore()) {
                Environment.getExternalStorageDirectory().absolutePath
            } else {
                getInternalStorePath()
            }
        }

        /**
         * 外置存储卡缓存的路径
         */
        fun getExternalStoreCachePath(): String? {
            return if (isExistExternalStore()) {
                return RootApplication.getContext().externalCacheDir?.absolutePath
            } else null
        }

        /**
         * 内置存储卡的路径
         */
        fun getInternalStoreCachePath(): String {
            return RootApplication.getContext().cacheDir.absolutePath
        }

        /**
         * 优先使用外置存储卡，没有则使用内部存储卡
         */
        fun getStoreCachePath(): String? {
            return if (isExistExternalStore()) {
                RootApplication.getContext().externalCacheDir?.absolutePath
            } else {
                getInternalStoreCachePath()
            }
        }

        /**
         * 获取指定路径
         */
        fun getFilePath(dir: String): String? {
            val filePath = if (isExistExternalStore()) {
                RootApplication.getContext().getExternalFilesDir(dir)?.absolutePath
            } else {
                RootApplication.getContext().filesDir.absolutePath + File.separator + dir
            }
            Logger.d("filePath=${filePath}")
            Logger.d("filePath2=${Environment.getExternalStorageDirectory().absolutePath}")

            val file = File(filePath)
            if (!file.exists()) {
                file.mkdir()
            }
            return filePath
        }

        /**
         * 是否有外存卡
         */
        fun isExistExternalStore(): Boolean {
            return Environment.getExternalStorageState() == MEDIA_MOUNTED
        }
    }
}