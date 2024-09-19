package ta.com.sepi.med_search.dto

import java.io.Serializable

data class MedicineDetailDto (
    val id: Long? = null,
    val uniqueId: String? = null,
    val name: String,
    var primaryComposition: String,
    var secondaryComposition: String? = null,
    var pharmaceuticalName: String,
    var price: Double,
    var packSize: String,
    var isDiscontinued: Boolean? = null
) : Serializable
