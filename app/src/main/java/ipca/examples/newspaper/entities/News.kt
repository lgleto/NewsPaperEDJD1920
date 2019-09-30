package ipca.examples.newspaper.entities

import java.util.*

class News : BaseModel() {

    var date      : Date?      = null
    var url       : String?    = null
    var image     : String?    = null
    var category  : Category?  = null
    var newspaper : Newspaper? = null

}