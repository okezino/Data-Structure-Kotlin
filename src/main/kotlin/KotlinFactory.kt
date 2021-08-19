enum class SchoolName{
    IKEJA,
    OJO,
    OSHODI,
    IPAJA
}

sealed class School{
    object CommandDayIkeja : School()
    object CommandDayOjo : School()
    object CommandDayIpaja : School()
    object CommandDayOshodi : School()

}

/**
 * Factory method is use to create Object of multiple similar type
 */
object SchoolFactory {
    fun createSchool(schoolName: SchoolName) : School{
        return  when(schoolName){
            SchoolName.IKEJA -> School.CommandDayIkeja
            SchoolName.OJO -> School.CommandDayOjo
            SchoolName.OSHODI -> School.CommandDayOshodi
            SchoolName.IPAJA-> School.CommandDayIpaja
        }
    }
}