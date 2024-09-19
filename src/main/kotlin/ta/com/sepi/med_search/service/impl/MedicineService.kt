package ta.com.sepi.med_search.service.impl

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import ta.com.sepi.med_search.data.repository.MedicineDetailRepository
import ta.com.sepi.med_search.dto.MedicineDetailDto
import ta.com.sepi.med_search.service.IMedicineService

@Service
class MedicineService (private val medicineDetailRepository: MedicineDetailRepository) : IMedicineService {

    override fun getMedicines(pageNumber: Int, pageSize: Int, queryString: String) : Page<MedicineDetailDto> {
        return medicineDetailRepository.findAllByNameContainsOrPrimaryCompositionContainsOrSecondaryCompositionContainsOrPharmaceuticalNameContains(
            queryString, queryString, queryString, queryString, PageRequest.of(pageNumber, pageSize))
            .map {
            MedicineDetailDto(
                it.id!!, it.uniqueId.toString(), it.name, it.primaryComposition,
                it.secondaryComposition, it.pharmaceuticalName, it.price,
                it.packSize, it.isDiscontinued
            )
        }
    }
}