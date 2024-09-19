package ta.com.sepi.med_search.service

import org.springframework.data.domain.Page
import ta.com.sepi.med_search.dto.MedicineDetailDto

interface IMedicineService {

    fun getMedicines(pageNumber: Int, pageSize: Int, queryString: String) : Page<MedicineDetailDto>

}