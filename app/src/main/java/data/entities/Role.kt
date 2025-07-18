package data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "role")
data class Role(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)
