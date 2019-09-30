package ipca.examples.newspaper.entities

import org.json.JSONObject
import java.util.*

class News : BaseModel() {

    var date      : Date?      = null
    var url       : String?    = null
    var image     : String?    = null
    var category  : Category?  = null
    var newspaper : Newspaper? = null

    override fun toJson(): JSONObject {
        val jsonObject = super.toJson()
        jsonObject.put("date", date.toString())
        jsonObject.put("url", url)
        jsonObject.put("image", image)
        jsonObject.put("category", category?.toJson())
        jsonObject.put("newspaper", newspaper?.toJson())
        return jsonObject
    }

}