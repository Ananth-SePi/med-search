package ta.com.sepi.med_search.api

import org.springframework.data.domain.Page
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ta.com.sepi.med_search.dto.MedicineDetailDto
import ta.com.sepi.med_search.service.impl.MedicineService

@RestController
@RequestMapping("/medicines")
class MedicineController(
    private val medicineService : MedicineService
) {

    @GetMapping("")
    public fun getMedicines(
        @RequestParam("pageNumber") pageNumber: Int,
        @RequestParam("pageSize") pageSize: Int,
        @RequestParam("queryString") queryString: String,
    ) : ResponseEntity<Page<MedicineDetailDto>> {
        try {
            val medicines = medicineService.getMedicines(pageNumber, pageSize, queryString)
            return ResponseEntity.ok(medicines)
        } catch (exception: Exception) {
            return ResponseEntity.internalServerError().build()
        }
    }

}