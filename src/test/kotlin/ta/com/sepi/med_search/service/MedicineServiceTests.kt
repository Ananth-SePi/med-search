package ta.com.sepi.med_search.service

import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import ta.com.sepi.med_search.data.entity.MedicineDetail
import ta.com.sepi.med_search.data.repository.MedicineDetailRepository
import ta.com.sepi.med_search.service.impl.MedicineService
import java.util.UUID
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class MedicineServiceTests {

    private val mockMedicineDetailRepository: MedicineDetailRepository = mockk<MedicineDetailRepository>(relaxed = true)
    private val medicineService = MedicineService(mockMedicineDetailRepository)

    @Test
    @DisplayName("GetMedicines: Success: Valid params give valid response")
    fun testGetMedicines_givenValidParameters_thenReturnResponse() {
        every {
            mockMedicineDetailRepository.findAllByNameContainsOrPrimaryCompositionContainsOrSecondaryCompositionContainsOrPharmaceuticalNameContains(
                any<String>(), any<String>(), any<String>(), any<String>(), any<Pageable>()
            )
        }.returns(getMedicines())
        val medicines = medicineService.getMedicines(1, 100, "test")
        assertNotNull(medicines, "Response of getMedicines must not be null")
        assertEquals(1, medicines.size, "Response size for given params must be 1")
    }

    companion object {
        fun getMedicines(): Page<MedicineDetail> {
            val medicine = MedicineDetail(
                1, UUID.randomUUID().toString(), "TestMed", "TestCompoPri",
                "TestCompoSec", "TestPharma", 100.0, "10", false
            )
            return PageImpl(listOf(medicine))
        }
    }

}