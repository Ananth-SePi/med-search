package ta.com.sepi.med_search.exception

class InvalidInputException(override val message: String?, override val cause: Throwable? = null) : RuntimeException()