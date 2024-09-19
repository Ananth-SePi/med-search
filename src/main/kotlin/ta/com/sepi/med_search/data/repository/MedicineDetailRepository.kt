package ta.com.sepi.med_search.data.repository

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import ta.com.sepi.med_search.data.entity.MedicineDetail

@Repository
interface MedicineDetailRepository : JpaRepository<MedicineDetail, Long> {
    fun findAllByNameContainsOrPrimaryCompositionContainsOrSecondaryCompositionContainsOrPharmaceuticalNameContains(
        name: String, primaryComposition: String, secondaryComposition: String, pharmaceuticalName: String, pageable: Pageable
    ) : Page<MedicineDetail>
}