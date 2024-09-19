package ta.com.sepi.med_search.data.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "medicine_detail", schema = "medicine_management")
data class MedicineDetail(
    @Id val id: Long? = null,
    val uniqueId: String? = null,
    val name: String,
    var primaryComposition: String,
    var secondaryComposition: String? = null,
    var pharmaceuticalName: String,
    var price: Double,
    var packSize: String,
    var isDiscontinued: Boolean? = null
)
