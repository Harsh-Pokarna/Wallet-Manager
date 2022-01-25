package com.example.walletmanager.pojos

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.walletmanager.utils.TAGS_TABLE_NAME

@Entity(tableName = TAGS_TABLE_NAME)
data class Tag(

    @PrimaryKey(autoGenerate = false)
    val id: Long = -1,

    @ColumnInfo(name = "tagName")
    val tagName: String = ""

)
