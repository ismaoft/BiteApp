package data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "privilege")
data class Privilege(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)
